package project;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{


  @Test
  public void testGroupCreation() {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test1", "test1-2", "test1-3"));
    submitGroupCreation();
    returnToGroupPage();
    logout();
  }

}
