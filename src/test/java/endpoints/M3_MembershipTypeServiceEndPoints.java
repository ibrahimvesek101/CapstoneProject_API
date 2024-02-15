package endpoints;

import base.BaseClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;

import static io.restassured.RestAssured.given;

public class M3_MembershipTypeServiceEndPoints {

    // GET /auth/api/application/{appId}/membership-type
    public static final String GET_APP_MEMBERSHIP_TYPE ="/auth/api/application/{appId}/membership-type";

    // GET /auth/api/membership-type
    public static final String GET_MEMBERSHIP_TYPE = "/auth/api/membership-type";

    // PUT /auth/api/membership-type
    public static final String PUT_MEMBERSHIP_TYPE ="/auth/api/membership-type";

    // POST /auth/api/membership-type
    public static final String POST_MEMBERSHIP_TYPE = "/auth/api/membership-type";

    // GET /auth/api/membership-type/{id}
    public static final String GET_MEMBERSHIP_TYPE_BY_ID = "/auth/api/membership-type/{id}";

    // DELETE /auth/api/membership-type/{id}
    public static final String DELETE_MEMBERSHIP_TYPE ="/auth/api/membership-type/{id}";


    /**
     * GET_APP_MEMBERSHIP_TYPE ="/auth/api/application/{appId}/membership-type"
     */
    public static Response getMembershipTypeByAppId(Object appID){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("appId",appID )
                .header("Authorization", BaseClass.token)
                .when()
                        .get(GET_APP_MEMBERSHIP_TYPE);


        return response;
    }


    /**
     * GET_MEMBERSHIP_TYPE = "/auth/api/membership-type";
     */

    public static Response getMembershipType(){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", BaseClass.token)
                .when()
                .get(GET_MEMBERSHIP_TYPE);


        return response;
    }


    /**
     * GET_MEMBERSHIP_TYPE = "/auth/api/membership-type?content=slim";
     */

    public static Response getMembershipTypeQueryParam(Object queryParam){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", BaseClass.token)
                .queryParam("content", queryParam)
                .when()
                .get(GET_MEMBERSHIP_TYPE);

        return response;
    }



    /**
     * PUT_MEMBERSHIP_TYPE ="/auth/api/membership-type";
     */

    public static Response putMembershipType(Object body){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", BaseClass.token)
                .body(body)
                .when()
                .put(PUT_MEMBERSHIP_TYPE);

        return response;

    }



    /**
     * POST_MEMBERSHIP_TYPE = "/auth/api/membership-type";
     */
    public static Response postMembershipType(Object body){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", BaseClass.token)
                .body(body)
                .when()
                .post(POST_MEMBERSHIP_TYPE);

        return response;
    }


    /**
     * GET_MEMBERSHIP_TYPE_BY_ID = "/auth/api/membership-type/{id}"
     */
    public static Response getMembershipTypeById(Object Id){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id",Id )
                .header("Authorization", BaseClass.token)
                .when()
                .get(GET_MEMBERSHIP_TYPE_BY_ID);


        return response;
    }



    /**
     * DELETE_MEMBERSHIP_TYPE ="/auth/api/membership-type/{id}"
     */
    public static Response deleteMembershipTypeByID(int membershipTypeID) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id", membershipTypeID)
                .header("Authorization", BaseClass.token)
                .when()
                .delete(DELETE_MEMBERSHIP_TYPE);
        return response;
    }







}
