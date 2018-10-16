package project.tests;

import org.testng.annotations.Test;
import project.model.ContactData;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation() {
      app.getContactHelper().initContactCreation();
      app.getContactHelper().createContact(new ContactData("Ivan", "Ivanov", "street","32111111", "123456@mail.com", "test1"));
  }
}
