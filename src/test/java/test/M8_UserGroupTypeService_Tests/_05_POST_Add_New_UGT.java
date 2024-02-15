package test.M8_UserGroupTypeService_Tests;

import base.Hooks;
import endpoints.M8_UserGroupTypeService_EPs;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.M8_UserGroupTypePojos.UserGroupTypePostPojo;

import static endpoints.M8_UserGroupTypeService_EPs.post_Add_New_UGT;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class _05_POST_Add_New_UGT extends Hooks {

    private int newUGTId01;
    private int newUGTId02;
    private int newUGTId03;
    private int newUGTId04;
    private int newUGTId05;
    private int newUGTId06;
    private int newUGTId07;
    private int newUGTId08;

    @Test(testName = "CAPI08-TC59 POST Add New UGT 'name' has only 'letters' as a string.",
            priority = 1,
            groups = {"Positive", "Regression"})
    public void POST_Add_New_UGT_TC59() {

        UserGroupTypePostPojo userGroupType = new UserGroupTypePostPojo();

        userGroupType.setName("Efeler");
        userGroupType.setDescription("Efeler Ailesi Unit");

        userGroupType.getName();
        userGroupType.getDescription();
        System.out.println("userGroupType = " + userGroupType);

        Response response = post_Add_New_UGT(userGroupType);

        response.then()
                .statusCode(201);           // 'Status code 201', yeni bir UGT 'creat' edildigini dogrular.
        //        .time(lessThan(2000L));

        response.prettyPeek();

        // Yanıttan ID'yi alıyor ve sınıf düzeyindeki değişkene kaydediyoruz
        newUGTId01 = response.jsonPath().getInt("id");

        System.out.println("newUGTId = " + newUGTId01);
    }

    @Test(testName = "CAPI08-TC60 GET New Added UGT Id = newUGTId01",
            priority = 2,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC60() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(newUGTId01);
        response.then()
                .statusCode(200)           // Yeni 'create' edilmis id=63 nolu UGT yi getirdigini  dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName   = "CAPI08-TC61 DELETE newly created UGT Id is newUGTId01",
            priority = 3,
            groups   = {"Positive", "Regression"})
    public void delete_Existing_UGT_By_Id_TC61() {

        response = M8_UserGroupTypeService_EPs.delete_Existing_UGT_By_Id(newUGTId01);
        response.then()
                .statusCode(200)            // Yeni 'create' edilmis id=63 nolu UGT nin silindigini dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC62 Verify that newly created UGT id = newUGTId01 has been deleted",
            priority = 4,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC62() {

        /* UGT'nin silinip silinmediğini bir GET isteği ile doğrulayabiliriz.
           GET isteğinin yanıtının 404 olması, kaydın silindiğini gösterir.     */

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(newUGTId01);
        response.then()
                .statusCode(404)                // Yeni 'create' edilmis id=63 nolu UGT nin bulunmadigini dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC63 POST Add New UGT 'name' has only 'integer 123' as a string.",
            priority = 5,
            groups = {"Positive", "Regression"})
    public void POST_Add_New_UGT_TC63() {

        UserGroupTypePostPojo userGroupType = new UserGroupTypePostPojo();

        userGroupType.setName("123");
        userGroupType.setDescription("Efeler Unit");

        userGroupType.getName();
        userGroupType.getDescription();
        System.out.println("userGroupType = " + userGroupType);

        Response response = post_Add_New_UGT(userGroupType);

        response.then()
                .statusCode(201);           // 'Status code 201', yeni bir UGT 'creat' edildigini dogrular.
        //        .time(lessThan(2000L));

        response.prettyPeek();
        newUGTId02 = response.jsonPath().getInt("id");
    }

    @Test(testName = "CAPI08-TC64 GET New Added UGT Id = newUGTId02",
            priority = 6,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC64() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(newUGTId02);
        response.then()
                .statusCode(200)           // Yeni 'create' edilmis id=64 nolu UGT yi getirdigini  dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC65 DELETE newly created UGT Id is newUGTId02",
            priority = 7,
            groups = {"Positive", "Regression"})
    public void delete_Existing_UGT_By_Id_TC65() {

        response = M8_UserGroupTypeService_EPs.delete_Existing_UGT_By_Id(newUGTId02);
        response.then()
                .statusCode(200)            // Yeni 'create' edilmis id=63 nolu UGT nin silindigini dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC66 Verify that newly created UGT id = newUGTId02 has been deleted",
            priority = 8,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC66() {

        /* UGT'nin silinip silinmediğini bir GET isteği ile doğrulayabiliriz.
           GET isteğinin yanıtının 404 olması, kaydın silindiğini gösterir.     */

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(newUGTId02);
        response.then()
                .statusCode(404)                // Yeni 'create' edilmis id=63 nolu UGT nin bulunmadigini dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC67 POST Add New UGT 'name' has only 'special chatacters §$%&' as a string.",
            priority = 9,
            groups = {"Positive", "Regression"})
    public void POST_Add_New_UGT_TC67() {

        UserGroupTypePostPojo userGroupType = new UserGroupTypePostPojo();

        userGroupType.setName("§$%&");
        userGroupType.setDescription("Efeler Unit");

        userGroupType.getName();
        userGroupType.getDescription();
        System.out.println("userGroupType = " + userGroupType);

        Response response = post_Add_New_UGT(userGroupType);

        response.then()
                .statusCode(201);           // 'Status code 201', yeni bir UGT 'creat' edildigini dogrular.
        //        .time(lessThan(2000L));

        response.prettyPeek();

        newUGTId03 = response.jsonPath().getInt("id");
    }

    @Test(testName = "CAPI08-TC68 GET New Added UGT Id = newUGTId03",
            priority = 10,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC68() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(newUGTId03);
        response.then()
                .statusCode(200)           // Yeni 'create' edilmis id=64 nolu UGT yi getirdigini  dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC69 DELETE newly created UGT Id is newUGTId03",
            priority = 11,
            groups = {"Positive", "Regression"})
    public void delete_Existing_UGT_By_Id_TC69() {

        response = M8_UserGroupTypeService_EPs.delete_Existing_UGT_By_Id(newUGTId03);
        response.then()
                .statusCode(200)            // Yeni 'create' edilmis id=63 nolu UGT nin silindigini dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC70 Verify that newly created UGT id = newUGTId03 has been deleted",
            priority = 12,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC470() {

        /* UGT'nin silinip silinmediğini bir GET isteği ile doğrulayabiliriz.
           GET isteğinin yanıtının 404 olması, kaydın silindiğini gösterir.     */

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(newUGTId03);
        response.then()
                .statusCode(404)                // Yeni 'create' edilmis id=63 nolu UGT nin bulunmadigini dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC71 POST Add New UGT 'name' field must be a string with a length of 50 characters.",
            priority = 13,
            groups = {"Positive", "Regression"})
    public void POST_Add_New_UGT_TC71() {

        UserGroupTypePostPojo userGroupType = new UserGroupTypePostPojo();

        userGroupType.setName("qwert12345qwert12345qwert12345qwert12345qwert12345");
        userGroupType.setDescription("Efeler Unit");

        userGroupType.getName();
        userGroupType.getDescription();
        System.out.println("userGroupType = " + userGroupType);

        Response response = post_Add_New_UGT(userGroupType);

        response.then()
                .statusCode(201);           // 'Status code 201', yeni bir UGT 'creat' edildigini dogrular.
        //        .time(lessThan(2000L));

        response.prettyPeek();

        newUGTId04 = response.jsonPath().getInt("id");
    }

    @Test(testName = "CAPI08-TC72 GET New Added UGT Id = newUGTId04",
            priority = 14,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC72() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(newUGTId04);
        response.then()
                .statusCode(200)           // Yeni 'create' edilmis id=64 nolu UGT yi getirdigini  dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC73 DELETE newly created UGT Id is newUGTId04",
            priority = 15,
            groups = {"Positive", "Regression"})
    public void delete_Existing_UGT_By_Id_TC73() {

        response = M8_UserGroupTypeService_EPs.delete_Existing_UGT_By_Id(newUGTId04);
        response.then()
                .statusCode(200)            // Yeni 'create' edilmis id=63 nolu UGT nin silindigini dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC74 Verify that newly created UGT id = newUGTId04 has been deleted",
            priority = 16,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC74() {

        /* UGT'nin silinip silinmediğini bir GET isteği ile doğrulayabiliriz.
           GET isteğinin yanıtının 404 olması, kaydın silindiğini gösterir.     */

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(newUGTId04);
        response.then()
                .statusCode(404)                // Yeni 'create' edilmis id=63 nolu UGT nin bulunmadigini dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC75 POST Add New UGT 'description' field contains only 'letters' as a string.",
            priority = 17,
            groups = {"Positive", "Regression"})
    public void POST_Add_New_UGT_TC75() {

        UserGroupTypePostPojo userGroupType = new UserGroupTypePostPojo();

        userGroupType.setName("Efeler");
        userGroupType.setDescription("Efeler Unit");

        userGroupType.getName();
        userGroupType.getDescription();
        System.out.println("userGroupType = " + userGroupType);

        Response response = post_Add_New_UGT(userGroupType);

        response.then()
                .statusCode(201);           // 'Status code 201', yeni bir UGT 'creat' edildigini dogrular.
        //        .time(lessThan(2000L));

        response.prettyPeek();

        newUGTId05 = response.jsonPath().getInt("id");
    }

    @Test(testName = "CAPI08-TC76 GET New Added UGT Id = newUGTId05",
            priority = 18,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC76() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(newUGTId05);
        response.then()
                .statusCode(200)           // Yeni 'create' edilmis id=64 nolu UGT yi getirdigini  dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC77 DELETE newly created UGT Id is newUGTId05",
            priority = 19,
            groups = {"Positive", "Regression"})
    public void delete_Existing_UGT_By_Id_TC77() {

        response = M8_UserGroupTypeService_EPs.delete_Existing_UGT_By_Id(newUGTId05);
        response.then()
                .statusCode(200)            // Yeni 'create' edilmis id=63 nolu UGT nin silindigini dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC78 Verify that newly created UGT id = newUGTId05 has been deleted",
            priority = 20,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC78() {

        /* UGT'nin silinip silinmediğini bir GET isteği ile doğrulayabiliriz.
           GET isteğinin yanıtının 404 olması, kaydın silindiğini gösterir.     */

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(newUGTId05);
        response.then()
                .statusCode(404)                // Yeni 'create' edilmis id=63 nolu UGT nin bulunmadigini dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC79 POST Add New UGT 'name' has only 'integer 123' as a string.",
            priority = 21,
            groups = {"Positive", "Regression"})
    public void POST_Add_New_UGT_TC79() {

        UserGroupTypePostPojo userGroupType = new UserGroupTypePostPojo();

        userGroupType.setName("Efeler");
        userGroupType.setDescription("123");

        userGroupType.getName();
        userGroupType.getDescription();
        System.out.println("userGroupType = " + userGroupType);

        Response response = post_Add_New_UGT(userGroupType);

        response.then()
                .statusCode(201);           // 'Status code 201', yeni bir UGT 'creat' edildigini dogrular.
        //        .time(lessThan(2000L));

        response.prettyPeek();

        newUGTId06 = response.jsonPath().getInt("id");
    }

    @Test(testName = "CAPI08-TC80 GET New Added UGT Id = newUGTId06",
            priority = 22,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC80() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(newUGTId06);
        response.then()
                .statusCode(200)           // Yeni 'create' edilmis id=64 nolu UGT yi getirdigini  dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC81 DELETE newly created UGT Id is newUGTId06",
            priority = 23,
            groups = {"Positive", "Regression"})
    public void delete_Existing_UGT_By_Id_TC81() {

        response = M8_UserGroupTypeService_EPs.delete_Existing_UGT_By_Id(newUGTId06);
        response.then()
                .statusCode(200)            // Yeni 'create' edilmis id=63 nolu UGT nin silindigini dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC82 Verify that newly created UGT id = newUGTId06 has been deleted",
            priority = 24,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC82() {

        /* UGT'nin silinip silinmediğini bir GET isteği ile doğrulayabiliriz.
           GET isteğinin yanıtının 404 olması, kaydın silindiğini gösterir.     */

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(newUGTId06);
        response.then()
                .statusCode(404)                // Yeni 'create' edilmis id=63 nolu UGT nin bulunmadigini dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC83 POST Add New UGT 'name' has only 'special chatacters §$%&' as a string.",
            priority = 25,
            groups = {"Positive", "Regression"})
    public void POST_Add_New_UGT_TC83() {

        UserGroupTypePostPojo userGroupType = new UserGroupTypePostPojo();

        userGroupType.setName("Efeler");
        userGroupType.setDescription("§$%&");

        userGroupType.getName();
        userGroupType.getDescription();
        System.out.println("userGroupType = " + userGroupType);

        Response response = post_Add_New_UGT(userGroupType);

        response.then()
                .statusCode(201);           // 'Status code 201', yeni bir UGT 'creat' edildigini dogrular.
        //        .time(lessThan(2000L));

        response.prettyPeek();

        newUGTId07 = response.jsonPath().getInt("id");
    }

    @Test(testName = "CAPI08-TC84 GET New Added UGT Id = newUGTId07",
            priority = 26,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC84() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(newUGTId07);
        response.then()
                .statusCode(200)           // Yeni 'create' edilmis id=64 nolu UGT yi getirdigini  dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC85 DELETE newly created UGT Id is newUGTId07",
            priority = 27,
            groups = {"Positive", "Regression"})
    public void delete_Existing_UGT_By_Id_TC85() {

        response = M8_UserGroupTypeService_EPs.delete_Existing_UGT_By_Id(newUGTId07);
        response.then()
                .statusCode(200)            // Yeni 'create' edilmis id=63 nolu UGT nin silindigini dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC86 Verify that newly created UGT id = newUGTId07 has been deleted",
            priority = 28,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC86() {

        /* UGT'nin silinip silinmediğini bir GET isteği ile doğrulayabiliriz.
           GET isteğinin yanıtının 404 olması, kaydın silindiğini gösterir.     */

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(newUGTId07);
        response.then()
                .statusCode(404)                // Yeni 'create' edilmis id=63 nolu UGT nin bulunmadigini dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC87 POST Add New UGT 'name' field must be a string with a length of 50 characters.",
            priority = 29,
            groups = {"Positive", "Regression"})
    public void POST_Add_New_UGT_TC87() {

        UserGroupTypePostPojo userGroupType = new UserGroupTypePostPojo();

        userGroupType.setName("Efeler");
        userGroupType.setDescription("Qwertzuiopasdfghjklöyxcvbnm,.-1234567890°!§$%&/()=Qwertzuiopasdfghjklöyxcvbnm,.-1234567890°!§$%&/()=Qwertzuiopasdfghjklöyxcvbnm,.-1234567890°!§$%&/()=Qwertzuiopasdfghjklöyxcvbnm,.-1234567890°!§$%&/()=Qwertzuiopasdfghjklöyxcvbnm,.-1234567890°!§$%&/()=12345");

        userGroupType.getName();
        userGroupType.getDescription();
        System.out.println("userGroupType = " + userGroupType);

        Response response = post_Add_New_UGT(userGroupType);

        response.then()
                .statusCode(201);           // 'Status code 201', yeni bir UGT 'creat' edildigini dogrular.
        //        .time(lessThan(2000L));

        response.prettyPeek();

        newUGTId08 = response.jsonPath().getInt("id");
    }

    @Test(testName = "CAPI08-TC88 GET New Added UGT Id = newUGTId08",
            priority = 30,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC88() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(newUGTId08);
        response.then()
                .statusCode(200)           // Yeni 'create' edilmis id=64 nolu UGT yi getirdigini  dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC89 DELETE newly created UGT Id is newUGTId08",
            priority = 31,
            groups = {"Positive", "Regression"})
    public void delete_Existing_UGT_By_Id_TC89() {

        response = M8_UserGroupTypeService_EPs.delete_Existing_UGT_By_Id(newUGTId08);
        response.then()
                .statusCode(200)            // Yeni 'create' edilmis id=63 nolu UGT nin silindigini dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC90 Verify that newly created UGT id = newUGTId08 has been deleted",
            priority = 32,
            groups = {"Positive", "Regression"})
    public void getUGT_ById_TC90() {

        /* UGT'nin silinip silinmediğini bir GET isteği ile doğrulayabiliriz.
           GET isteğinin yanıtının 404 olması, kaydın silindiğini gösterir.     */

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(newUGTId08);
        response.then()
                .statusCode(404)                // Yeni 'create' edilmis id=63 nolu UGT nin bulunmadigini dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }
}
