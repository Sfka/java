package project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import project.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test (enabled = false)
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Ivan", "Ivanov", "street","32111111", "123456@mail.com", "test1"),true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() -1);
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().acceptDeleteContact();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() -1);

        before.remove(before.size() -1);
        Assert.assertEquals(before, after);
    }
}
