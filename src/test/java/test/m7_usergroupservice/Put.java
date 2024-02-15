package test.m7_usergroupservice;

import base.Hooks;
import endpoints.M7_UserGroupServicesEndPoints;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.m7_usergroupservicepojos.UserGroup_post;
import pojos.m7_usergroupservicepojos.UserGroup_put;

public class Put extends Hooks {
    @Test
    public void putGroupTest() {

        response = M7_UserGroupServicesEndPoints.postUserGroup(UserGroup_post.createUser());
        response.prettyPeek();
        int id = response.jsonPath().getInt("id");

        M7_UserGroupServicesEndPoints service = new M7_UserGroupServicesEndPoints();
        service.verifyName(id, "Api_deneme");

        response = M7_UserGroupServicesEndPoints.putUserGroup(UserGroup_put.putUser(id, "Api_deneme_yeni", 1, 1));
        response.prettyPeek();

        service.verifyName(id, "Api_deneme_yeni");

        M7_UserGroupServicesEndPoints.deleteUserGroupById(id);


        try {

            M7_UserGroupServicesEndPoints.getGETUserGroupById(id);

        } catch (Exception e) {
            System.out.println(id + " ID nolu User Group ismi 'Api_deneme' iken 'Api_deneme_yeni' olarak değiştirilip Silindi.");
        }
    }


    @Test
    public void putGroupTestNegative() {

        response = M7_UserGroupServicesEndPoints.postUserGroup(UserGroup_post.createUser());
        response.prettyPeek();
        int id = response.jsonPath().getInt("id");

        M7_UserGroupServicesEndPoints service = new M7_UserGroupServicesEndPoints();
        service.verifyName(id, "Api_deneme");

        try {
        response = M7_UserGroupServicesEndPoints.putUserGroup(UserGroup_put.putUser( 00000,"Api_deneme_yeni", 1, 1));
        Assert.assertEquals(response.statusCode(), 406);

        }catch (Exception e){

        M7_UserGroupServicesEndPoints.deleteUserGroupById(id);

            System.out.println("Negatif test çalıştı. " + id + " ID nolu User Group Silindi.");
        }
    }
}