package test.M8_UserGroupTypeService_Tests;

import base.Hooks;
import endpoints.M8_UserGroupTypeService_EPs;
import org.testng.annotations.Test;
import utils.Token;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.hamcrest.Matchers.*;

public class _01_GET_All_UGT extends Hooks {

    @Test(testName = "CAPI08-TC01 GET All UGT Response status is 200", groups = {"Positive", "Regression"})
    public void get_All_UGT_TC01() {

        response = M8_UserGroupTypeService_EPs.getAll_UGT();
        response.then()
                .statusCode(200);

        //            .time(lessThan(500L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC02 GET All UGT Response Object has a 'id' field", groups = {"Positive", "Regression"})
    public void get_All_UGT_TC02() {

        response = M8_UserGroupTypeService_EPs.getAll_UGT();
        response.then()
                .statusCode(200)
                //        .time(lessThan(500L))
                .body("", everyItem(hasKey("id")));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC03 GET All UGT Response Object has a 'name' field", groups = {"Positive", "Regression"})
    public void get_All_UGT_TC03() {

        response = M8_UserGroupTypeService_EPs.getAll_UGT();
        response.then()
                .statusCode(200)
                .time(lessThan(1500L))
                .body("", everyItem(hasKey("name")));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC04 GET All UGT Response Object has a 'description' field", groups = {"Positive", "Regression"})
    public void get_All_UGT_TC04() {

        response = M8_UserGroupTypeService_EPs.getAll_UGT();
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("", everyItem(hasKey("name")));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC05 GET All UGT Resp.Object has a id, name and description field", groups = {"Positive", "Regression"})
    public void get_All_UGT_TC05() {

        response = M8_UserGroupTypeService_EPs.getAll_UGT();
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("", everyItem(hasKey("id")))
                .body("", everyItem(hasKey("name")));
    //            .body("", everyItem(hasKey("description")));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC06 GET All UGT Response Object 'id' field has a value", groups = {"Positive", "Regression"})
    public void get_All_UGT_TC06() {

        response = M8_UserGroupTypeService_EPs.getAll_UGT();
        response.then()
                .statusCode(200)
                //        .time(lessThan(500L))
                .body("id", notNullValue()); // "id" alanının herhangi bir değeri olup olmadığını kontrol ediyoruz

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC07 GET All UGT Response Object 'id' field has a value", groups = {"Positive", "Regression"})
    public void get_All_UGT_TC07() {

        response = M8_UserGroupTypeService_EPs.getAll_UGT();
        response.then()
                .statusCode(200)
                //        .time(lessThan(500L))
                .body("name", notNullValue()); // "name" alanının herhangi bir değeri olup olmadığını kontrol ediyoruz

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC08 GET All UGT Response Object 'id' field has a value", groups = {"Positive", "Regression"})
    public void get_All_UGT_TC08() {

        response = M8_UserGroupTypeService_EPs.getAll_UGT();
        response.then()
                .statusCode(200)
                //        .time(lessThan(500L))
                .body("description", notNullValue()); // "description" alanının herhangi bir değeri olup olmadığını kontrol ediyoruz

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC09 GET UGT Response contains an array", groups = {"Positive", "Regression"})
    public void get_All_UGT_TC09() {

        response = M8_UserGroupTypeService_EPs.getAll_UGT();
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("", is(instanceOf(List.class))); // Response body'nin bir List (dizi) türünde olduğunu kontrol ediyoruz;

        response.prettyPeek();
    }

/*
    @Test(testName = "CAPI08-TC10 GET UGT Response is in the Json Format", groups = {"Positive", "Regression"})
    public void get_All_UGT_TC10() throws IOException {

        String json = Files.readString(Path.of("src/test/resources/SchemaValidation/userGroupType.json"));

        response = M8_UserGroupTypeService_EPs.getAll_UGT();
        response.then()
               .body(Token.schemaValidator("src/test/resources/SchemaValidation/userGroupType.json"))
                .log().all();

           response.prettyPeek();
    }
*/

}
