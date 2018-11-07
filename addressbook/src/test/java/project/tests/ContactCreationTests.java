package project.tests;

import org.testng.annotations.Test;
import project.model.ContactData;
import project.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{


  @Test //(enabled = false)
  public void testContactCreation() {
      app.goTo().homePage();
      Contacts before = app.contact().all();
      ContactData contact = new ContactData()
              .withFirstName("Ivan").withLastName("Ivanov").withAddress("Ul. Street, 12-22")
              .withMobile("32111111").withEmail("123456@mail.com").withGroup("test1");
      app.contact().create(contact);
      assertThat(app.contact().Count(), equalTo(before.size() +1));
      Contacts after = app.contact().all();
      assertThat(after, equalTo(
              before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
