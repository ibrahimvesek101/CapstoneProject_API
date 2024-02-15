package test.M8_UserGroupTypeService_Tests;

import base.Hooks;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.M8_UserGroupTypePojos.UserGroupTypePutPojo;

import static endpoints.M8_UserGroupTypeService_EPs.put_Update_Existing_UGT;

public class _04_PUT_Update_Existing_UGT_Negative extends Hooks {

/*
    @Test(testName = "CAPI08-TC30 POST Add New UGT by changing 'id' value to get status code 201", groups = {"Positive", "Regression"})
    public void PUT_Update_Existing_UGT_TC99() {

        // Yeni bir UGT oluşturup "id" değerini döndüren POST isteğini yapalım
        Response createResponse = post_Add_New_UGT(11);

        // Oluşturulan UGT'nin "id" değerini alalım
        int createdId = createResponse.path("id");

        //  "id" değeri oluşturulan UGT için 11 mi kontrol edelim
        //  assertEquals(createdId, 11, "Created UGT id doesn't match the expected value");

        //  Şimdi POST_Add_New_UGT_TC30 testini gerçekleştirelim
        Response postAddNewUgtResponse = post_Add_New_UGT(11);
        postAddNewUgtResponse.then()
                .statusCode(201)
                .time(lessThan(2000L));

        postAddNewUgtResponse.prettyPeek();
    }
*/
    @Test(testName = "CAPI08-TC47 PUT Update Existing UGT without 'id' field.",
            priority = 1,
            groups = {"Negative", "Regression"})
    public void put_Update_Existing_UGT_TC47() {

        UserGroupTypePutPojo uGT_Body = new UserGroupTypePutPojo();

        uGT_Body.setName("Efelerimiz");
        uGT_Body.setDescription("Efeler Unit");

        uGT_Body.getName();
        uGT_Body.getDescription();
        System.out.println("userGroupType = " + uGT_Body);

    /*    Map<String, Object> body = new HashMap<String, Object>();
        body.put("id", 9);
        body.put("name", "Efelerimiz");
        body.put("description", "Efeler Unit");
    */

        Response response = put_Update_Existing_UGT(uGT_Body);

        response.then()
                .statusCode(404);
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC48 PUT Update Existing UGT without 'name' field.",
            priority = 1,
            groups = {"Negative", "Regression"})
    public void put_Update_Existing_UGT_TC48() {

        UserGroupTypePutPojo uGT_Body = new UserGroupTypePutPojo();

        uGT_Body.setId(9);
        uGT_Body.setDescription("Efeler Unit");

        uGT_Body.getName();
        uGT_Body.getDescription();
        System.out.println("userGroupType = " + uGT_Body);

        Response response = put_Update_Existing_UGT(uGT_Body);

        response.then()
                .statusCode(400);           // Bad Request
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC49 PUT Update Existing UGT without 'description' field.",
            priority = 1,
            groups = {"Negative", "Regression"})
    public void put_Update_Existing_UGT_TC49() {

        UserGroupTypePutPojo uGT_Body = new UserGroupTypePutPojo();

        uGT_Body.setId(9);
        uGT_Body.setName("Efelerimiz");

        uGT_Body.getName();
        uGT_Body.getDescription();
        System.out.println("userGroupType = " + uGT_Body);

        Response response = put_Update_Existing_UGT(uGT_Body);

        response.then()
                .statusCode(200);
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC50 PUT Update Existing UGT without 'id' and 'name' field.",
            priority = 1,
            groups = {"Negative", "Regression"})
    public void put_Update_Existing_UGT_TC50() {

        UserGroupTypePutPojo uGT_Body = new UserGroupTypePutPojo();

        uGT_Body.setDescription("Efeler Unit");

        uGT_Body.getName();
        uGT_Body.getDescription();
        System.out.println("userGroupType = " + uGT_Body);

        Response response = put_Update_Existing_UGT(uGT_Body);

        response.then()
                .statusCode(400);               // Bad Request
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC51 PUT Update Existing UGT without 'id' and 'description' field.",
            priority = 1,
            groups = {"Negative", "Regression"})
    public void put_Update_Existing_UGT_TC51() {

        UserGroupTypePutPojo uGT_Body = new UserGroupTypePutPojo();

       uGT_Body.setName("Efelerimiz");

        uGT_Body.getName();

        System.out.println("userGroupType = " + uGT_Body);

        Response response = put_Update_Existing_UGT(uGT_Body);

        response.then()
                .statusCode(404);                    // Not Found
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC52 PUT Update Existing UGT without 'name' and 'description' field.",
            priority = 1,
            groups = {"Negative", "Regression"})
    public void put_Update_Existing_UGT_TC52() {

        UserGroupTypePutPojo uGT_Body = new UserGroupTypePutPojo();

        uGT_Body.setId(9);

        uGT_Body.getName();
        uGT_Body.getDescription();
        System.out.println("userGroupType = " + uGT_Body);

        Response response = put_Update_Existing_UGT(uGT_Body);

        response.then()
                .statusCode(400);               // Bad Request
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC53 PUT Update Existing UGT 'name' can be a empty string.",
            priority = 1,
            groups = {"Negative", "Regression"})
    public void put_Update_Existing_UGT_TC53() {

        UserGroupTypePutPojo uGT_Body = new UserGroupTypePutPojo();

        uGT_Body.setId(9);
        uGT_Body.setName("");
        uGT_Body.setDescription("Efeler Unit");

        uGT_Body.getName();
        uGT_Body.getDescription();
        System.out.println("userGroupType = " + uGT_Body);

        Response response = put_Update_Existing_UGT(uGT_Body);

        response.then()
                .statusCode(200);
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC54 PUT Update Existing UGT without 'name' can not be a null value.",
            priority = 1,
            groups = {"Negative", "Regression"})
    public void put_Update_Existing_UGT_TC54() {

        UserGroupTypePutPojo uGT_Body = new UserGroupTypePutPojo();

        uGT_Body.setId(9);
        uGT_Body.setName(null);
        uGT_Body.setDescription("Efeler Unit");

        uGT_Body.getName();
        uGT_Body.getDescription();
        System.out.println("userGroupType = " + uGT_Body);

        Response response = put_Update_Existing_UGT(uGT_Body);

        response.then()
                .statusCode(400);
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC55 PUT Update Existing UGT 'name' must not contain a string with a length of above 50 characters.",
            priority = 1,
            groups = {"Negative", "Regression"})
    public void put_Update_Existing_UGT_TC55() {

        UserGroupTypePutPojo uGT_Body = new UserGroupTypePutPojo();

        uGT_Body.setId(9);
        uGT_Body.setName("qwert12345qwert12345qwert12345qwert12345qwert123456");
        uGT_Body.setDescription("Efeler Unit");

        uGT_Body.getName();
        uGT_Body.getDescription();
        System.out.println("userGroupType = " + uGT_Body);

        Response response = put_Update_Existing_UGT(uGT_Body);

        response.then()
                .statusCode(500);
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC56 PUT Update Existing UGT without 'description' contain an empty string.",
            priority = 1,
            groups = {"Negative", "Regression"})
    public void put_Update_Existing_UGT_TC56() {

        UserGroupTypePutPojo uGT_Body = new UserGroupTypePutPojo();

        uGT_Body.setId(9);
        uGT_Body.setName("Efeler");
        uGT_Body.setDescription("");

        uGT_Body.getName();
        uGT_Body.getDescription();
        System.out.println("userGroupType = " + uGT_Body);

        Response response = put_Update_Existing_UGT(uGT_Body);

        response.then()
                .statusCode(200);
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC57 PUT Update Existing UGT 'description' can be a null value.",
            priority = 1,
            groups = {"Negative", "Regression"})
    public void put_Update_Existing_UGT_TC57() {

        UserGroupTypePutPojo uGT_Body = new UserGroupTypePutPojo();

        uGT_Body.setId(9);
        uGT_Body.setName("Efeler");
        uGT_Body.setDescription(null);

        uGT_Body.getName();
        uGT_Body.getDescription();
        System.out.println("userGroupType = " + uGT_Body);

        Response response = put_Update_Existing_UGT(uGT_Body);

        response.then()
                .statusCode(200);
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC58 PUT Update Existing UGT 'description' must not contain a string with a length of above 255 characters.",
            priority = 1,
            groups = {"Negative", "Regression"})
    public void put_Update_Existing_UGT_TC58() {

        UserGroupTypePutPojo uGT_Body = new UserGroupTypePutPojo();

        uGT_Body.setId(9);
        uGT_Body.setName("Efeler");
        uGT_Body.setDescription("Qwertzuiopasdfghjklöyxcvbnm,.-1234567890°!§$%&/()=Qwertzuiopasdfghjklöyxcvbnm,.-1234567890°!§$%&/()=Qwertzuiopasdfghjklöyxcvbnm,.-1234567890°!§$%&/()=Qwertzuiopasdfghjklöyxcvbnm,.-1234567890°!§$%&/()=Qwertzuiopasdfghjklöyxcvbnm,.-1234567890°!§$%&/()=123456");

        uGT_Body.getName();
        uGT_Body.getDescription();
        System.out.println("userGroupType = " + uGT_Body);

        Response response = put_Update_Existing_UGT(uGT_Body);

        response.then()
                .statusCode(500);
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }
}
