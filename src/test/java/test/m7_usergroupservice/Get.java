package test.m7_usergroupservice;

import base.Hooks;
import endpoints.M7_UserGroupServicesEndPoints;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class Get extends Hooks {

    @Test
    public void verifyStatusCodeAndTime() {
        response = M7_UserGroupServicesEndPoints.getGETUserGroup();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.getTime() < 12000);
    }

    @Test
    public void verifyIDNotNegative() {
        response = M7_UserGroupServicesEndPoints.getGETUserGroupById(45);
        int id = response.jsonPath().getInt("id");
        Assert.assertTrue(id>0);
    }

    @Test
    public void verifyReaponse() {
        response = M7_UserGroupServicesEndPoints.getGETUserGroup();
        response.prettyPeek();
    }

    @Test
    public void verifyReaponseIsNotEmpty() {
        response = M7_UserGroupServicesEndPoints.getGETUserGroup();
        Assert.assertTrue(response.getBody().toString().length() > 0);
    }

    @Test
    public void verifyIDInteger() {
        response = M7_UserGroupServicesEndPoints.getGETUserGroupById(45);
        response.then().body("id", equalTo(45));
    }

    @Test
    public void verifyNameString() {
        M7_UserGroupServicesEndPoints service = new M7_UserGroupServicesEndPoints();
        service.verifyName(45, "Selam_Api");
    }

    @Test
    public void verifyTimeAndStatusCode() {
        response = M7_UserGroupServicesEndPoints.getGETUserGroupById(25);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.getTime() < 12000);
    }


    @Test
    public void verifyId() {
        response = M7_UserGroupServicesEndPoints.getGETUserGroupById(45);
        int id = response.jsonPath().getInt("id");
        Assert.assertTrue(id>0);
    }

    @Test
    public void verifyNameNotEmpty() {
        M7_UserGroupServicesEndPoints service = new M7_UserGroupServicesEndPoints();
        service.verifyName(45, "Selam_Api");
    }

    @Test
    public void verifyName() {
        M7_UserGroupServicesEndPoints service = new M7_UserGroupServicesEndPoints();
        service.verifyName(45, "Selam_Api");
    }
}
