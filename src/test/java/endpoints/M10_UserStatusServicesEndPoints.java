package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static base.BaseClass.token;
import static io.restassured.RestAssured.given;

public class M10_UserStatusServicesEndPoints {

    public static final String GET_All_US = "/auth/api/user-status";
    public static final String GET_US_By_Id = "/auth/api/user-status/{id}";
    public static final String POST_Add_New_US = "/auth/api/user-status";
    public static final String PUT_Update_Existing_US = "/auth/api/user-status";
    public static final String DELETE_Existing_US_By_Id = "/auth/api/user-status/{id}";


    public static Response getAll_US() {

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get(GET_All_US);

        return response;
    }

    public static Response get_US_ById(int Id) {

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .pathParam("id", Id)
                .when()
                .get(GET_US_By_Id);

        return response;
    }

    public static Response put_Update_Existing_US(Object body) {

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(body)
                .when()
                .put(PUT_Update_Existing_US);

        return response;
    }


    public static Response post_Add_New_US(Object body) {

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(body)
                .when()
                .post(POST_Add_New_US);

        return response;

    }


    public static Response delete_Existing_US_By_Id(int id) {

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .pathParam("id",id)
                .when()
                .delete(DELETE_Existing_US_By_Id);

        return response;
    }


}
