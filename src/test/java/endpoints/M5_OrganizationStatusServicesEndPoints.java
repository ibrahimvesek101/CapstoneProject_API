package endpoints;

import base.BaseClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class M5_OrganizationStatusServicesEndPoints {
    // GET  /auth/api/organization-status
    public static final String GET_ORGANISATION_STATUS = "/auth/api/organization-status";

    public static Response getOrganisationService(){
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization" , BaseClass.token)
                .when().get(GET_ORGANISATION_STATUS);

        return response;
    }

    ////////////////////////

    // GET  /auth/api/organization-status/{id}
    public static final String GET_ORGANISATION_BY_ID = "/auth/api/organization-status/{id}";

    public static Response getOrganisationById(int id){
        Response response = given()
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .header("Authorization" , BaseClass.token)
                .when().get(GET_ORGANISATION_BY_ID);
        return response;
    }

    ////////////////////////

    // POST /auth/api/organization-status
    public static final String POST_ORGANISATION = "/auth/api/organization-status";
    public static Response postOrganisation(Object body){
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization" , BaseClass.token)
                .body(body)
                .when().post(POST_ORGANISATION);
        return response;
    }

    ////////////////////////

    // PUT /auth/api/organization-status
    public static final String PUT_ORGANISATION = "/auth/api/organization-status";

    public static Response putOrganisation(Object body){
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization" , BaseClass.token)
                .body(body)
                .when().put(PUT_ORGANISATION);
        return response;
    }


    // DELETE /auth/api/organization-status/{id}
    public static final String DELETE_ORGANISATION = "/auth/api/organization-status/{id}";

    public static Response deleteOrganisation(int id){
        Response response = given()
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .header("Authorization" , BaseClass.token)
                .when().delete(DELETE_ORGANISATION);
        return response;

    }







}
