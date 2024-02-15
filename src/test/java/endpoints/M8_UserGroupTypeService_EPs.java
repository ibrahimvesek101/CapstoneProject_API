package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static base.BaseClass.token;
import static io.restassured.RestAssured.given;

public class M8_UserGroupTypeService_EPs {

    public static final String GET_All_UGT = "/auth/api/user-group-type";
    public static final String GET_UGT_By_Id = "/auth/api/user-group-type/{id}";
    public static final String POST_Add_New_UGT = "/auth/api/user-group-type";
    public static final String PUT_Update_Existing_UGT = "/auth/api/user-group-type";
    public static final String DELETE_Existing_UGT_By_Id = "/auth/api/user-group-type/{id}";


    public static Response getAll_UGT() {

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
            .when()
                .get(GET_All_UGT);

        return response;
    }

    public static Response get_UGT_ById(int id) {

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .pathParam("id", id)
            .when()
                .get(GET_UGT_By_Id);

        return response;
    }

    public static Response put_Update_Existing_UGT(Object body) {

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(body)
                .when()
                .put(PUT_Update_Existing_UGT);

        return response;
    }

    public static Response post_Add_New_UGT(Object body) {

    //   UserGroupTypePostPojo userGroupType = new UserGroupTypePostPojo();
//
    //    Integer id = null;
    //    String name = userGroupType.getName();
    //    String description = userGroupType.getDescription();
//
    //    String requestBody = "{\n" +
    //            "  \"id\": " + id + ",\n" +
    //            "  \"name\": \"" + name + "\",\n" +
    //            "  \"description\": \"" + description + "\"\n" +
    //            "}";

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(body)                      // JSON veriyi POST isteği içine ekliyoruz
            .when()
                .post(POST_Add_New_UGT);

        return response;
    }

    public static Response delete_Existing_UGT_By_Id(int id) {

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .pathParam("id", id)
                .when()
                .delete(DELETE_Existing_UGT_By_Id);

        return response;
    }
}
