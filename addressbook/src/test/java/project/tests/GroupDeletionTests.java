package project.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project.model.GroupData;
import project.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0){
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupDeletion() {
        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        assertThat(app.group().Count(), equalTo(before.size() -1));
        Groups after = app.group().all();
        assertThat(after, equalTo(before.without(deletedGroup)));
        }


}

