package project.tests;

import org.testng.annotations.Test;
import project.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {
    @Test
    public void ContactEmailTests() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getEmail(), equalTo(mergeEmail(contactInfoFromEditForm)));
    }

    private String mergeEmail(ContactData contact) {
        return Arrays.asList(contact.getEmail())
                .stream()
                .map(ContactAddressTests::cleaned)
                .collect(Collectors.joining(""));
    }

    public static String cleaned(String email) {
        return   email.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

}
