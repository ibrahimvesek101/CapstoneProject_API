package test.M8_UserGroupTypeService_Tests;

import base.Hooks;
import endpoints.M8_UserGroupTypeService_EPs;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.M8_UserGroupTypePojos.UserGroupTypePutPojo;

import java.util.HashMap;
import java.util.Map;

import static endpoints.M8_UserGroupTypeService_EPs.put_Update_Existing_UGT;
import static org.hamcrest.Matchers.lessThan;

public class _03_PUT_Update_Existing_UGT extends Hooks {

      @Test(testName = "CAPI08-TC31 PUT Update Existing UGT 'name' has only 'letters' as a string.",
            priority = 1,
            groups = {"Positive", "Regression"})
    public void put_Update_Existing_UGT_TC31() {

        UserGroupTypePutPojo uGT_Body = new UserGroupTypePutPojo();

        uGT_Body.setId(9);
        uGT_Body.setName("Efeler");
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

    @Test(testName = "CAPI08-TC32 GET New updated UGT Id = 9",
            priority = 2,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC32() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)           // Yeni 'create' edilmis id=63 nolu UGT yi getirdigini  dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC33 PUT Update Existing UGT 'name' has only 'letters' as a string.",
            priority = 3,
            groups = {"Positive", "Regression"})
    public void put_Update_Existing_UGT_TC33() {

        UserGroupTypePutPojo uGT_Body = new UserGroupTypePutPojo();

        uGT_Body.setId(9);
        uGT_Body.setName("123");
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

    @Test(testName = "CAPI08-TC34 GET New updated UGT Id = 9",
            priority = 4,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC34() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)           // Yeni 'create' edilmis id=63 nolu UGT yi getirdigini  dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC35 PUT Update Existing UGT 'name' has only 'special chatacters §$%&' as a string.",
            priority = 5,
            groups = {"Positive", "Regression"})
    public void put_Update_Existing_UGT_TC35() {

        UserGroupTypePutPojo uGT_Body = new UserGroupTypePutPojo();

        uGT_Body.setId(9);
        uGT_Body.setName("§$%&");
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

    @Test(testName = "CAPI08-TC36 GET New updated UGT Id = 9",
            priority = 6,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC36() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)           // Yeni 'create' edilmis id=63 nolu UGT yi getirdigini  dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC37 PUT Update Existing UGT 'name' field must be a string with a length of 50 characters.",
            priority = 7,
            groups = {"Positive", "Regression"})
    public void put_Update_Existing_UGT_TC37() {

        UserGroupTypePutPojo uGT_Body = new UserGroupTypePutPojo();

        uGT_Body.setId(9);
        uGT_Body.setName("qwert12345qwert12345qwert12345qwert12345qwert12345");
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

    @Test(testName = "CAPI08-TC38 GET New updated UGT Id = 9",
            priority = 8,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC38() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)           // Yeni 'create' edilmis id=63 nolu UGT yi getirdigini  dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC39 PUT Update Existing UGT 'description' has only 'letters' as a string.",
            priority = 9,
            groups = {"Positive", "Regression"})
    public void put_Update_Existing_UGT_TC39() {

        UserGroupTypePutPojo uGT_Body = new UserGroupTypePutPojo();

        uGT_Body.setId(9);
        uGT_Body.setName("Efeler");
        uGT_Body.setDescription("Efeler");

        uGT_Body.getName();
        uGT_Body.getDescription();
        System.out.println("userGroupType = " + uGT_Body);

        Response response = put_Update_Existing_UGT(uGT_Body);

        response.then()
                .statusCode(200);
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC40 GET New updated UGT Id = 9",
            priority = 10,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC40() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)           // Yeni 'create' edilmis id=63 nolu UGT yi getirdigini  dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC41 PUT Update Existing UGT 'description' has only 'integer 123' as a string.",
            priority = 11,
            groups = {"Positive", "Regression"})
    public void put_Update_Existing_UGT_TC41() {

        UserGroupTypePutPojo uGT_Body = new UserGroupTypePutPojo();

        uGT_Body.setId(9);
        uGT_Body.setName("Efeler");
        uGT_Body.setDescription("1234");

        uGT_Body.getName();
        uGT_Body.getDescription();
        System.out.println("userGroupType = " + uGT_Body);

        Response response = put_Update_Existing_UGT(uGT_Body);

        response.then()
                .statusCode(200);
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC42 GET New updated UGT Id = 9",
            priority = 12,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC42() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)           // Yeni 'create' edilmis id=63 nolu UGT yi getirdigini  dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC43 PUT Update Existing UGT 'description' has only 'special chatacters §$%&' as a string.",
            priority = 13,
            groups = {"Positive", "Regression"})
    public void put_Update_Existing_UGT_TC43() {

        UserGroupTypePutPojo uGT_Body = new UserGroupTypePutPojo();

        uGT_Body.setId(9);
        uGT_Body.setName("Efeler");
        uGT_Body.setDescription("§$%&");

        uGT_Body.getName();
        uGT_Body.getDescription();
        System.out.println("userGroupType = " + uGT_Body);

        Response response = put_Update_Existing_UGT(uGT_Body);

        response.then()
                .statusCode(200);
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC44 GET New updated UGT Id = 9",
            priority = 14,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC44() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)           // Yeni 'create' edilmis id=63 nolu UGT yi getirdigini  dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC45 PUT Update Existing UGT 'description' field must be a string with a length of 50 characters.",
            priority = 15,
            groups = {"Positive", "Regression"})
    public void put_Update_Existing_UGT_TC45() {

        UserGroupTypePutPojo uGT_Body = new UserGroupTypePutPojo();

        uGT_Body.setId(9);
        uGT_Body.setName("Efeler");
        uGT_Body.setDescription("Qwertzuiopasdfghjklöyxcvbnm,.-1234567890°!§$%&/()=Qwertzuiopasdfghjklöyxcvbnm,.-1234567890°!§$%&/()=Qwertzuiopasdfghjklöyxcvbnm,.-1234567890°!§$%&/()=Qwertzuiopasdfghjklöyxcvbnm,.-1234567890°!§$%&/()=Qwertzuiopasdfghjklöyxcvbnm,.-1234567890°!§$%&/()=12345");

        uGT_Body.getName();
        uGT_Body.getDescription();
        System.out.println("userGroupType = " + uGT_Body);

        Response response = put_Update_Existing_UGT(uGT_Body);

        response.then()
                .statusCode(200);
        //        .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC46 GET New updated UGT Id = 9",
            priority = 16,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC46() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)           // Yeni 'create' edilmis id=63 nolu UGT yi getirdigini  dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }
}
