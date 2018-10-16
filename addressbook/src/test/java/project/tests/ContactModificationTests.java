package project.tests;

import org.testng.annotations.Test;
import project.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Ivan", "Ivanov", "street","32111111", "123456@mail.com", "test1"));
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Ivan2", "Ivanov2", "street2","232111111", "2222@mail.com", null), false);
        app.getContactHelper().submitContactModification();
    }
}
