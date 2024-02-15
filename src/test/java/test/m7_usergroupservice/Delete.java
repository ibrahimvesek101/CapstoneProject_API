package test.m7_usergroupservice;

import base.BaseClass;
import base.Hooks;
import endpoints.M7_UserGroupServicesEndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.m7_usergroupservicepojos.UserGroup_post;

import static io.restassured.RestAssured.given;

public class Delete extends Hooks {
    @Test
    public void deleteUserGroup() {
        response = M7_UserGroupServicesEndPoints.postUserGroup(UserGroup_post.createUser());
        response.prettyPeek();

        int id = response.jsonPath().getInt("id");
        response = M7_UserGroupServicesEndPoints.getGETUserGroupById(id);
        response.prettyPeek();

        M7_UserGroupServicesEndPoints.deleteUserGroupById(id);

        try {
            M7_UserGroupServicesEndPoints.getGETUserGroupById(id);
        } catch (Exception e) {
            System.out.println(id + " ID nolu User Group Başarılı bir şekilde SİLİNDİ.");
        }
    }

    @Test
    public void deleteUserGroupNegative() {
        response = M7_UserGroupServicesEndPoints.postUserGroup(UserGroup_post.createUser());
        response.prettyPeek();
        int id = response.jsonPath().getInt("id");

        try {
            M7_UserGroupServicesEndPoints.deleteUserGroupByIdNegative("Api");
        } catch (Exception e) {
            M7_UserGroupServicesEndPoints.deleteUserGroupById(id);
            System.out.println("Delete Negatif test çalıştı. Id String olarak kabul edilmedi.");

        }
    }

    @Test
    public void deleteUserGroupBUG() {
        response = M7_UserGroupServicesEndPoints.postUserGroup(UserGroup_post.createUser());
        response.prettyPeek();
        int id = response.jsonPath().getInt("id");

        M7_UserGroupServicesEndPoints.deleteUserGroupById(id);
        M7_UserGroupServicesEndPoints.deleteUserGroupById(id);
        M7_UserGroupServicesEndPoints.deleteUserGroupById(id);

        System.out.println("Delete BUG çalıştı. Silinen UserGroup tekrar tekrar silinmeye çalışıldı.");


    }
}