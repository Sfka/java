package project.tests;


import org.testng.annotations.Test;
import project.model.GroupData;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGoupModification(){
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", "test1-2", "test1-3"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
