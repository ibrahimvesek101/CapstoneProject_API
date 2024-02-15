package test.M8_UserGroupTypeService_Tests;

import base.Hooks;
import endpoints.M8_UserGroupTypeService_EPs;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.M8_UserGroupTypePojos.UserGroupTypePostPojo;

import static endpoints.M8_UserGroupTypeService_EPs.post_Add_New_UGT;
import static org.hamcrest.Matchers.lessThan;

public class _06_POST_Add_New_UGT_Negative extends Hooks {

    private int newUGTId;

    @Test(testName = "CAPI08-TC91 POST Add New UGT 'name' can contain only a space character.", groups = {"Negative", "Regression"})
    public void POST_Add_New_UGT_TC91() {

        UserGroupTypePostPojo userGroupType = new UserGroupTypePostPojo();

        userGroupType.setName(" ");
        userGroupType.setDescription("Efeler Ailesi Unit");

        userGroupType.getName();
        userGroupType.getDescription();
        System.out.println("userGroupType = " + userGroupType);

        Response response = post_Add_New_UGT(userGroupType);

        response.then()
                .statusCode(201);           // 'Status code 201', yeni bir UGT 'creat' edildigini dogrular.
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC92 POST Add New UGT 'name' can not be a empty string.", groups = {"Negative", "Regression"})
    public void POST_Add_New_UGT_TC92() {

        UserGroupTypePostPojo userGroupType = new UserGroupTypePostPojo();

        userGroupType.setName("");
        userGroupType.setDescription("Efeler Ailesi Unit");

        userGroupType.getName();
        userGroupType.getDescription();

        System.out.println("userGroupType = " + userGroupType);

        Response response = post_Add_New_UGT(userGroupType);

        response.then()
                .statusCode(406);           // 'Status code 201', yeni bir UGT 'creat' edildigini dogrular.
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }


    @Test(testName = "CAPI08-TC93 POST Add New UGT 'name' can not be null value.", groups = {"Negative", "Regression"})
    public void POST_Add_New_UGT_TC93() {

        UserGroupTypePostPojo userGroupType = new UserGroupTypePostPojo();

        userGroupType.setName(null);
        userGroupType.setDescription("Efeler Ailesi Unit");

        userGroupType.getName();
        userGroupType.getDescription();

        System.out.println("userGroupType = " + userGroupType);

        Response response = post_Add_New_UGT(userGroupType);

        response.then()
                .statusCode(400);           // '400', Bad Request, yani 'null# olamaz.
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC94 POST Add New UGT contains a 'name' field.", groups = {"Negative", "Regression"})
    public void POST_Add_New_UGT_TC94() {

        UserGroupTypePostPojo userGroupType = new UserGroupTypePostPojo();

        userGroupType.setDescription("Efeler Ailesi Unit");

        userGroupType.getName();
        userGroupType.getDescription();

        System.out.println("userGroupType = " + userGroupType);

        Response response = post_Add_New_UGT(userGroupType);

        response.then()
                .statusCode(400);           // '400', Bad Request, yani 'null# olamaz.
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC95 POST Add New UGT 'name' must not contain a string with a length of above 50 characters.", groups = {"Negative", "Regression"})
    public void POST_Add_New_UGT_TC95() {

        UserGroupTypePostPojo userGroupType = new UserGroupTypePostPojo();

        userGroupType.setName("qwert12345qwert12345qwert12345qwert12345qwert123456");
        userGroupType.setDescription("Efeler Ailesi Unit");

        userGroupType.getName();
        userGroupType.getDescription();

        System.out.println("userGroupType = " + userGroupType);

        Response response = post_Add_New_UGT(userGroupType);

        response.then()
                .statusCode(500);           // 'Status code 201', yeni bir UGT 'creat' edildigini dogrular.
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }



    @Test(testName = "CAPI08-TC96 POST Add New UGT 'description' can be a empty string.", groups = {"Negative", "Regression"})
    public void POST_Add_New_UGT_TC96() {

        UserGroupTypePostPojo userGroupType = new UserGroupTypePostPojo();

        userGroupType.setName("Efeler");
        userGroupType.setDescription("");

        userGroupType.getName();
        userGroupType.getDescription();

        System.out.println("userGroupType = " + userGroupType);

        Response response = post_Add_New_UGT(userGroupType);

        response.then()
                .statusCode(201);           // 'Status code 201', yeni bir UGT 'creat' edildigini dogrular.
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }


    @Test(testName = "CAPI08-TC97 POST Add New UGT 'description' can be a null value.", groups = {"Negative", "Regression"})
    public void POST_Add_New_UGT_TC97() {

        UserGroupTypePostPojo userGroupType = new UserGroupTypePostPojo();

        userGroupType.setName("Efeler");
        userGroupType.setDescription(null);

        userGroupType.getName();
        userGroupType.getDescription();

        System.out.println("userGroupType = " + userGroupType);

        Response response = post_Add_New_UGT(userGroupType);

        response.then()
                .statusCode(201);           // '400', Bad Request, yani 'null# olamaz.
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC98 POST Add New UGT must not be 'description' field.", groups = {"Negative", "Regression"})
    public void POST_Add_New_UGT_TC98() {

        UserGroupTypePostPojo userGroupType = new UserGroupTypePostPojo();

        userGroupType.setName("Efeler");


        userGroupType.getName();
        userGroupType.getDescription();

        System.out.println("userGroupType = " + userGroupType);

        Response response = post_Add_New_UGT(userGroupType);

        response.then()
                .statusCode(201);           // '400', Bad Request, yani 'null# olamaz.
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }


    @Test(testName = "CAPI08-TC99 POST Add New UGT 'description' must not contain a string with a length of above 255 characters.", groups = {"Negative", "Regression"})
    public void POST_Add_New_UGT_TC99() {

        UserGroupTypePostPojo userGroupType = new UserGroupTypePostPojo();

        userGroupType.setName("Efeler");
        userGroupType.setDescription("Qwertzuiopasdfghjklöyxcvbnm,.-1234567890°!§$%&/()=Qwertzuiopasdfghjklöyxcvbnm,.-1234567890°!§$%&/()=Qwertzuiopasdfghjklöyxcvbnm,.-1234567890°!§$%&/()=Qwertzuiopasdfghjklöyxcvbnm,.-1234567890°!§$%&/()=Qwertzuiopasdfghjklöyxcvbnm,.-1234567890°!§$%&/()=123456");

        userGroupType.getName();
        userGroupType.getDescription();

        System.out.println("userGroupType = " + userGroupType);

        Response response = post_Add_New_UGT(userGroupType);

        response.then()
                .statusCode(500);           // 'Status code 201', yeni bir UGT 'creat' edildigini dogrular.
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }


    @Test(testName = "CAPI08-TC100 POST Add New UGT 'description' can contain only a space character.", groups = {"Negative", "Regression"})
    public void POST_Add_New_UGT_TC100() {

        UserGroupTypePostPojo userGroupType = new UserGroupTypePostPojo();

        userGroupType.setName("Efeler");
        userGroupType.setDescription(" ");

        userGroupType.getName();
        userGroupType.getDescription();

        System.out.println("userGroupType = " + userGroupType);

        Response response = post_Add_New_UGT(userGroupType);

        response.then()
                .statusCode(201);           // 'Status code 201', yeni bir UGT 'creat' edildigini dogrular.
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }



}
