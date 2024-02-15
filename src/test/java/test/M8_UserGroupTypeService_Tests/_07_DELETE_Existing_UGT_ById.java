package test.M8_UserGroupTypeService_Tests;

import base.Hooks;
import endpoints.M8_UserGroupTypeService_EPs;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class _07_DELETE_Existing_UGT_ById extends Hooks {


    @Test(testName = "CAPI08-TC101 DELETING UGT By Id, id is 53", groups = {"Negative", "Regression"})
    public void delete_Existing_UGT_By_Id_TC101() {

        response = M8_UserGroupTypeService_EPs.delete_Existing_UGT_By_Id(100);
        response.then()
                .statusCode(200)                // Silme islemi 'Status code 200' ile dogrulanir.
                .time(lessThan(2000L));

        response.prettyPeek();
    }

    @Test(testName = "CAPI08-TC102 GET UGT Response status is 200", groups = {"Negative", "Regression"})
    public void getUGT_ById_TC102() {

        /* UGT'nin silinip silinmediğini bir GET isteği ile doğrulayabiliriz.
           GET isteğinin yanıtının 404 olması, kaydın silindiğini gösterir.     */

        response = M8_UserGroupTypeService_EPs.get_UGT_ById(106);
        response.then()
                .statusCode(404)             // 'Status code 404, silinen UGT nin 'NotFound' bulunamadigini dogrular.
                .time(lessThan(2000L));

        response.prettyPeek();
    }
}