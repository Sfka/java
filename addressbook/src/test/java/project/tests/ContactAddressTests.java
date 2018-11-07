package project.tests;

import org.testng.annotations.Test;
import project.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

    @Test
    public void ContactAddressTests() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAddress(), equalTo(mergeAddress(contactInfoFromEditForm)));
    }

    private String mergeAddress(ContactData contact) {
        return Arrays.asList(contact.getAddress())
                .stream()
                .map(ContactAddressTests::cleaned)
                .collect(Collectors.joining(""));
    }

    public static String cleaned(String address) {
        return   address.replaceAll("\\s{3}", "").trim();
    }

}
