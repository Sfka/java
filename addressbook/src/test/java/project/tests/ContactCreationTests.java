package project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import project.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{


  @Test (enabled = false)
  public void testContactCreation() {
      app.goTo().homePage();
      List<ContactData> before = app.contact().list();
      ContactData contact = new ContactData()
              .withFirstName("Ivan").withLastName("Ivanov").withAddress("street")
              .withMobile("32111111").withEmail("123456@mail.com").withGroup("test1");
      app.contact().create(contact, true);
      List<ContactData> after = app.contact().list();
      Assert.assertEquals(after.size(), before.size() + 1);

      before.add(contact);
      Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
  }
}
