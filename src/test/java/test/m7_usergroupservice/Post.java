package test.m7_usergroupservice;

import base.Hooks;
import endpoints.M7_UserGroupServicesEndPoints;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.m7_usergroupservicepojos.UserGroup_post;

public class Post extends Hooks {

    @Test
    public void createGroupTest() {

        response = M7_UserGroupServicesEndPoints.postUserGroup(UserGroup_post.createUser());
        response.prettyPeek();

        int id = response.jsonPath().getInt("id");

        response = M7_UserGroupServicesEndPoints.getGETUserGroupById(id);
        response.prettyPeek();

        M7_UserGroupServicesEndPoints.deleteUserGroupById(id);

        try {

            M7_UserGroupServicesEndPoints.getGETUserGroupById(id);

        } catch (Exception e) {
            System.out.println(id + " ID nolu User Group Başarılı bir şekilde Create edilip Silindi.");
        }
    }

    @Test

    public void createGroupTestNegative() {
        response = M7_UserGroupServicesEndPoints.postUserGroup(UserGroup_post.createUserNegative());
        Assert.assertEquals(response.statusCode(), 406);
    }
}
