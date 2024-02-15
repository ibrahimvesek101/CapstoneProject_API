package endpoints;

import base.BaseClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class M6_RoleServicesEndPoints {
    // GET  auth/api/application/{appId}/role
    public static final String GET_ROLESERVICE_APPID = "/auth/api/application/{appId}/role";

    public static Response getRoleByAppId(int appId){
        Response response = given()
                .contentType(ContentType.JSON)
                .pathParam("appId", appId)
                .header("Authorization" , BaseClass.token)
                .when().get(GET_ROLESERVICE_APPID);
        return response;
    }

    ////////////////////////

    // GET  /auth/api/role
    public static final String GET_ROLESERVICE_ALLROLES = "/auth/api/role";

    public static Response getAllRoles(){
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", BaseClass.token)
                .when().get(GET_ROLESERVICE_ALLROLES);
        return  response;
    }

    ////////////////////////

    // GET   /auth/api/role/{id}
    public static final String GET_ROLESERVICE_ROLEID = "/auth/api/role/{id}";

    public static Response getRoleByRoleId(int id){
        Response response = given()
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .header("Authorization", BaseClass.token)
                .when().get(GET_ROLESERVICE_ROLEID);
        return response;
    }

}
