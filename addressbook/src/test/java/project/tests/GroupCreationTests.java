package project.tests;

import org.testng.annotations.Test;
import project.model.GroupData;

public class GroupCreationTests extends TestBase{


  @Test
  public void testGroupCreation() {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test1", "test1-2", "test1-3"));
    app.submitGroupCreation();
    app.returnToGroupPage();
    app.logout();
  }

}
