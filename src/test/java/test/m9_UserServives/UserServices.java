package test.m9_UserServives;

import base.Hooks;
import endpoints.M9_UserServicesEndpoints;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RandomDataGenerator.DataTypeName;
import utils.RandomDataGenerator.RandomData;

import java.util.HashMap;
import java.util.Map;

public class UserServices extends Hooks {

    @Test(testName = "add New User By Organization Id App Id Role Id")
    public void addNewUserByOrgAppRoleId() {

        Map<String, Object> body = new HashMap<String, Object>();
        //body.put("email", "johnnyDeep@example.com");
        body.put("email", RandomData.getRandomDataFor(DataTypeName.EMAIL));

        response = M9_UserServicesEndpoints.addNewUserToUserService(1, 2, 5, body);
        //Assert.assertEquals(201, response.getStatusCode());
        response.prettyPeek();
    }

    @Test(testName = "get All Users Of Organization")
    public void getAllUsersOfOrgByOrgId() {
        response = M9_UserServicesEndpoints.getAllUsersOfOrganization(1);

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertNotNull(response.getBody().asString());
        Assert.assertTrue(response.getBody().asString().contains("user"));
        response.prettyPeek();
    }

    @Test(testName = "get All Users")
    public void getUserServiceUsers() {
        response = M9_UserServicesEndpoints.getAllUsers();
        Assert.assertEquals(200, response.getStatusCode());
        response.prettyPeek();
    }

    @Test(testName = "Update Users Information")
    public void updateUserInfo() {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("id", "33");
        body.put("email", "newemail@example.com");
        response = M9_UserServicesEndpoints.updateUser(body);
        Assert.assertEquals(200, response.getStatusCode());
        response.prettyPeek();
    }

    @Test(testName = "get User By Id")
    public void getUserById() {
        response = M9_UserServicesEndpoints.getUserById(33);
        Assert.assertEquals(200, response.getStatusCode());
        response.prettyPeek();
    }

    @Test(testName = "delete User By Id")
    public void deleteUserByIdTest() {
        response = M9_UserServicesEndpoints.deleteUserById(41);
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertTrue(response.getBody().asString().isEmpty());
        response.prettyPeek();
    }


}
