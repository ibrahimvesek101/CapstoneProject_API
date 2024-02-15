package test.m10_userstatus;

import base.Hooks;
import endpoints.M10_UserStatusServicesEndPoints;
import org.testng.annotations.Test;
import pojos.m10_userstatuspojos.UserStatusPostPojo;
import pojos.m10_userstatuspojos.UserStatusPutPojo;

public class UserStatus extends Hooks {

    private int newUSId01;

    @Test(testName = "CAPI10-TC01 GET ALL US Response status code is 200",
            priority = 1)
    public void GET_All_US_TC01(){

        response = M10_UserStatusServicesEndPoints.getAll_US();
        response.then()
                .statusCode(200);
        response.prettyPeek();

    }

    @Test(testName = "CAPI10-TC02 GET US BY ID Response status code is 200",
            priority = 2)
    public void GET_US_ById_TC02(){

        response = M10_UserStatusServicesEndPoints.get_US_ById(11);
        response.then()
                .statusCode(200);
        response.prettyPeek();

    }

    @Test(testName = "CAPI10-TC03 POST ADD NEW US Response status code is 200",
            priority = 3)
    public void POST_Add_New_US_TC03(){

        UserStatusPostPojo userStatus = new UserStatusPostPojo();

        userStatus.setName("Sakalar");
        userStatus.setDescription("Sakalar Ailesi Unit");

        userStatus.getName();
        userStatus.getDescription();
        System.out.println("userStatus = " + userStatus);

        response = M10_UserStatusServicesEndPoints.post_Add_New_US(userStatus);
        response.then()
                .statusCode(201);
        response.prettyPeek();

        newUSId01 = response.jsonPath().getInt("id");

    }

    @Test(testName = "CAPI10-TC02 GET US BY ID Response status code is 200",
            priority = 4)
    public void GET_US_ById_TC04(){

        response = M10_UserStatusServicesEndPoints.get_US_ById(newUSId01);
        response.then()
                .statusCode(200);
        response.prettyPeek();

    }


    @Test(testName = "CAPI10-TC04 PUT UPDATE EXISTING US Response status code is 200",
            priority = 5)
    public void PUT_Update_Existing_US_TC05(){

        UserStatusPutPojo userStatus = new UserStatusPutPojo();

        userStatus.setId(11);
        userStatus.setName("Sakalar");
        userStatus.setDescription("Sakalar Ailesi Unit");

        userStatus.getId();
        userStatus.getName();
        userStatus.getDescription();
        System.out.println("userStatus = " + userStatus);

        response = M10_UserStatusServicesEndPoints.put_Update_Existing_US(userStatus);
        response.then()
                .statusCode(200);
        response.prettyPeek();

    }

    @Test(testName = "CAPI10-TC05 DELETE EXISTING US BY ID Response status code is 200",
            priority = 6)
    public void DELETE_Existing_US_ById_TC06(){

        response = M10_UserStatusServicesEndPoints.delete_Existing_US_By_Id(6);
        response.then()
                .statusCode(200);
        response.prettyPeek();

    }





}
