package endpoints;


import base.BaseClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.m7_usergroupservicepojos.UserGroup_post;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class M7_UserGroupServicesEndPoints {

    // GET Endpoints
    private static final String GET_USER_GROUP = "/auth/api/user-group";
    private static final String GET_USER_GROUP_BY_ID = "/auth/api/user-group/{id}";

    // PUT Endpoint
    private static final String PUT_USER_GROUP = "/auth/api/user-group";

    // POST Endpoint
    private static final String POST_USER_GROUP = "/auth/api/user-group";

    // DELETE Endpoint
    private static final String DELETE_USER_GROUP_BY_ID = "/auth/api/user-group/{id}";

    public static Response getGETUserGroup(){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", BaseClass.token)
                .when()
                .get(GET_USER_GROUP);
        return response;
    }

    public static Response getGETUserGroupById(int ID){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id",ID )
                .header("Authorization", BaseClass.token)
                .when()
                .get(GET_USER_GROUP_BY_ID);
        return response;
    }

    public static Response postUserGroup(Object body){
        Response response=
                given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", BaseClass.token)
                .body(body)
                .when()
                .post(POST_USER_GROUP);
        return response;
    }



    public void verifyName(int ID,String beklenenİsim){

        given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id", ID)
                .header("Authorization", BaseClass.token)
                .when()
                .get(GET_USER_GROUP_BY_ID).then().statusCode(200).assertThat().body("name",equalTo(beklenenİsim));

    }

    public static Response deleteUserGroupById(int ID){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id",ID )
                .header("Authorization", BaseClass.token)
                .when()
                .delete(DELETE_USER_GROUP_BY_ID);
        return response;
    }
public static Response deleteUserGroupByIdNegative(String stringData){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id",stringData )
                .header("Authorization", BaseClass.token)
                .when()
                .delete(DELETE_USER_GROUP_BY_ID);
        return response;
    }

    public static Response putUserGroup(Object body){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", BaseClass.token)
                .body(body)
                .when()
                .put(PUT_USER_GROUP);
        return response;
    }

}

