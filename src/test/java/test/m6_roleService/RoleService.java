package test.m6_roleService;

import base.Hooks;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import endpoints.M6_RoleServicesEndPoints;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.m6_roleServicePojo.RoleByAppIdPojo;
import pojos.m6_roleServicePojo.RoleGetRolePojo;

import java.io.IOException;

public class RoleService extends Hooks {

    @Test
    public static void getRoleByAppIdPositiveTestCase01() throws JsonProcessingException {
        response = M6_RoleServicesEndPoints.getRoleByAppId(1);

        RoleByAppIdPojo[] Response = response.as(RoleByAppIdPojo[].class);
        response.then().statusCode(200);
        Assert.assertEquals(Response[0].getName(), "A3M_ADMIN");
    }

    @Test
    public static void getRoleByAppIdNegativeTestCase01() throws JsonProcessingException{
        response = M6_RoleServicesEndPoints.getRoleByAppId(99999);
        response.then().statusCode(404);

    }

    /////////

    @Test
    public static void getAllRolePositiveTestCase01(){
        response = M6_RoleServicesEndPoints.getAllRoles();
        RoleByAppIdPojo[] Response = response.as(RoleByAppIdPojo[].class);
        response.then().statusCode(200);
        Assert.assertEquals(Response[0].getName(), "Accountant");
        Assert.assertEquals(Response[0].getId(), 23);
        Assert.assertEquals(Response[0].getApp_id(), 2);
    }

    @Test   // TODO
    public static void getRoleByRoleIdPositiveTestCase01() throws IOException {
        ObjectMapper om = new ObjectMapper();
        RoleGetRolePojo roleGetRolePojo = om.readValue((JsonParser) response,RoleGetRolePojo.class);
        response = M6_RoleServicesEndPoints.getRoleByRoleId(5);
        RoleGetRolePojo[] Response = response.as(RoleGetRolePojo[].class);
        response.then().statusCode(200);
        //Assert.assertEquals(Response[0].getName(), "Accountant");
        //Assert.assertEquals(Response[0].getId(), 23);
        //Assert.assertEquals(Response[0].getApp_id(), 2);
        //Assert.assertEquals(Response[0].getPermissions().get(0).getActions(), "write");
    }





}
