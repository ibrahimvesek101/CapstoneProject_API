package test.M8_UserGroupTypeService_Tests;

import base.Hooks;
import endpoints.M8_UserGroupTypeService_EPs;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;

public class _02_GET_UGT_By_Id extends Hooks {


    @Test(testName = "CAPI08-TC11 GET UGT Response status is 200", groups = {"Positive", "Regression"})
    public void getUGT_ById_TC11() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)                // 'Status code un 200' oldugunu dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC12 GET UGT Response Object has a 'id' field'", groups = {"Positive", "Regression"})
    public void getUGT_ById_TC12() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("id", is(notNullValue())); // "id" alanının 'null' olmadığını yani var oldugunu dogrular.

    /*  2. YOL
        JsonPath jsonPath = response.jsonPath();

        JsonPath ile "id" alanının varlığını kontrol etmek için
        boolean hasIdField = jsonPath.get("id") != null;

        if (hasIdField) {
            System.out.println("Response body içinde 'id' alanı bulunuyor.");
        } else {
            System.out.println("Response body içinde 'id' alanı bulunmuyor.");
        }
     */
        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC13 GET UGT Response Object 'id' field' has a value.", groups = {"Positive", "Regression"})
    public void getUGT_ById_TC13() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("id", notNullValue());        // "id" alanının bir 'deger' icerdigini dogrular.

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC14 GET UGT Response Object 'id' field' has only an integer value.", groups = {"Positive", "Regression"})
    public void getUGT_ById_TC14() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("id", greaterThan(0)); // "id" alanının pozitif bir sayı icerdigini dogrular.

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC15 GET UGT Response Object 'id' field' contains only an integer between 1-9.", groups = {"Positive", "Regression"})
    public void getUGT_ById_TC15() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("id", both(greaterThanOrEqualTo(1)).and(lessThanOrEqualTo(9))) // "id" alanının 0 ile 9 arasında bir sayı olduğunu kontrol ediyoruz
                .body("id", isA(Integer.class));        // "id" alanının bir tamsayı (integer) icerdigini doğrular.

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC16 GET UGT By Id Response Object has a 'name' field'", groups = {"Positive", "Regression"})
    public void getUGT_ById_TC16() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("name", is(notNullValue())); // "name" alanının 'null' olmadığını yani var oldugunu dogrular.

    /*  2. YOL
        JsonPath jsonPath = response.jsonPath();

        JsonPath ile "name" alanının varlığını kontrol etmek için
        boolean hasIdField = jsonPath.get("name") != null;

        if (hasIdField) {
            System.out.println("Response body içinde 'name' alanı bulunuyor.");
        } else {
            System.out.println("Response body içinde 'name' alanı bulunmuyor.");
        }
     */
        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC17 GET UGT By Id Response Object 'name' field' contains a value.", groups = {"Positive", "Regression"})
    public void getUGT_ById_TC17() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("name", notNullValue()); // "name" alanının bir 'deger' icerdigini dogrular.

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC18 GET UGT By Id Response Object 'name' field' contains a string value.", groups = {"Positive", "Regression"})
    public void getUGT_ById_TC18() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("name", instanceOf(String.class));    // "name" alanının bir 'string value' icerdigini dogrular.

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC19 GET UGT Response Object has a 'description' field'", groups = {"Positive", "Regression"})
    public void getUGT_ById_TC19() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("description", is(notNullValue())); // "description" alanının 'null olmadığını' yani var oldugunu dogrular.

    /*  2. YOL
        JsonPath jsonPath = response.jsonPath();

        JsonPath ile "description" alanının varlığını kontrol etmek için
        boolean hasIdField = jsonPath.get("description") != null;

        if (hasIdField) {
            System.out.println("Response body içinde 'description' alanı bulunuyor.");
        } else {
            System.out.println("Response body içinde 'description' alanı bulunmuyor.");
        }
     */
        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC20 GET UGT Response Object 'description' field contains a value.", groups = {"Positive", "Regression"})
    public void getUGT_ById_TC20() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("description", notNullValue()); // "description" alanının bir 'deger' icerdigini dogrular.
        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC21 GET UGT Response Object 'description' field'", groups = {"Positive", "Regression"})
    public void getUGT_ById_TC21() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("description", instanceOf(String.class)); // "description" alanının bir 'string value' icerdigini dogrular.
        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC22 GET UGT Response Object has a id, name and description field", groups = {"Positive", "Regression"})
    public void getUGT_ById_TC22() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("id", is(notNullValue()))             // "id" alanının 'null olmadığını' yani var oldugunu dogrular.
                .body("name", is(notNullValue()))           // "name" alanının 'null olmadığını' yani var oldugunu dogrular.
                .body("description", is(notNullValue()));   // "description" alanının 'null olmadığını' yani var oldugunu dogrular.

    /*   2. YOL
        JsonPath jsonPath = response.jsonPath();

        // JsonPath ile "id", "name" ve "description" alanlarının varlığını kontrol etmek için
        boolean hasIdField = jsonPath.get("id") != null;
        boolean hasNameField = jsonPath.get("name") != null;
        boolean hasDescriptionField = jsonPath.get("description") != null;

        if (hasIdField && hasNameField && hasDescriptionField) {
            System.out.println("Response body içinde 'id', 'name' ve 'description' alanları bulunuyor.");
        } else {
            System.out.println("Response body içinde 'id', 'name' ve 'description' alanlarından en az biri bulunmuyor.");
        }
    */
        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC23 GET UGT By Id Response Object 'name' field' contains a value.", groups = {"Positive", "Regression"})
    public void getUGT_ById_TC23() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("name", notNullValue()); // "name" alanının bir 'deger' icerdigini dogrular.

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC24 GET UGT Response Object 'description' field' contains a value.", groups = {"Positive", "Regression"})
    public void getUGT_ById_TC24() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("description", notNullValue()); // "description" alanının bir 'deger' icerdigini dogrular.

        response.prettyPeek();
    }


    /*  ----------------    NEGATIVE CASES    ------------------------  */

    @Test(testName = "CAPI08-TC25 GET UGT Response Object 'id' field contains a non-negativ integer.", groups = {"Negative", "Regression"})
    public void getUGT_ById_TC25() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("id", not(lessThan(0))); // "id" alanının non-negativ integer icerdigini dogrular.

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC26 GET UGT Response Object 'id' field' contains a non-string value.", groups = {"Negative", "Regression"})
    public void getUGT_ById_TC26() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("id", not(instanceOf(String.class))); // "id" alanının bir string (metin) değer içermediğini dogrular.

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC27 GET UGT Response Object 'name' field' contains a non-string value.", groups = {"Negative", "Regression"})
    public void getUGT_ById_TC27() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("name", not(isA(Integer.class))); // "name" alanının bir 'integer' deger icermedigini doğrular.

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC28 GET UGT Response Object 'description' field' contains a non-integer value.", groups = {"Negative", "Regression"})
    public void getUGT_ById_TC28() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("description", not(isA(Integer.class))); // "description" alanının bir 'integer' deger icermedigini doğrular.

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC29 GET UGT Response Object 'description' field' contains a non-integer value.", groups = {"Negative", "Regression"})
    public void getUGT_ById_TC29() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("description", not(isA(Integer.class))); // "description" alanının bir 'integer' deger icermedigini doğrular.

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC30 GET UGT Response contains an non-array object.", groups = {"Negative", "Regression"})
    public void getUGT_ById_TC30() {

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(9);
        response.then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("", not(instanceOf(List.class))); // Response body'nin bir 'List (dizi)' türünde olduğunu dogrular.

        response.prettyPeek();
    }

}
