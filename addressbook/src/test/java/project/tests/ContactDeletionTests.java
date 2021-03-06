package project.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project.model.ContactData;
import project.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstName("Ivan").withLastName("Ivanov").withAddress("street")
                    .withMobile("32111111").withEmail("123456@mail.com").withGroup("test1"));
        }
    }

    @Test //(enabled = false)
    public void testContactDeletion() {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        assertThat(app.contact().Count(), equalTo(before.size() -1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(deletedContact)));
    }
}
