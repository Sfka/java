package project.tests;

import org.testng.annotations.Test;
import project.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactCreation(){
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Ivan2", "Ivanov2", "street2","232111111", "2222@mail.com"));
        app.getContactHelper().submitContactModification();
    }
}
