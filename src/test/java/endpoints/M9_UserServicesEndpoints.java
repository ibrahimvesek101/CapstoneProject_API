package endpoints;

import base.BaseClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class M9_UserServicesEndpoints {

            // Add a user to a specific role within an organization's application
        public static final String ADD_USER_TO_ROLE = "/auth/api/organization/{organizationId}/application/{appId}/role/{roleId}/user";
            // Retrieve a list of users associated with a specific organization
        public static final String GET_ORGANIZATION_USERS = "/auth/api/organization/{organizationId}/user";
            // Retrieve information about the currently authenticated user
        public static final String GET_CURRENT_USER = "/auth/api/user";
            // Update user information for the currently authenticated user
        public static final String UPDATE_USER = "/auth/api/user";
            // Retrieve information about a specific user by their ID
        public static final String GET_USER_BY_ID = "/auth/api/user/{id}";
            // Delete a specific user by their ID
        public static final String DELETE_USER_BY_ID = "/auth/api/user/{id}";
            // Perform a "cherry-pick" operation related to user data
        public static final String CHERRY_PICK_USER = "/auth/api/user/cherry-pick";
            // Register a new user
        public static final String REGISTER_USER = "/auth/api/user/register";
            // Resend an invitation to join an organization to a specific user
        public static final String RESEND_ORG_INVITATION = "/auth/api/user/resend-organization-invitation";
            // Reset user credentials, typically involving a password reset
        public static final String RESET_CREDENTIALS = "/auth/api/user/reset-credentials";
            // Send a verification request to the user for confirming their identity
        public static final String SEND_VERIFICATION_REQUEST = "/auth/api/user/send-verification-request";


    public static Response addNewUserToUserService(int organizationID ,int appID,int roleID , Object body){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("organizationId",organizationID )
                .pathParam("appId",appID )
                .pathParam("roleId",roleID )
                .header("Authorization", BaseClass.token)
                .body(body)
                .when()
                .post(ADD_USER_TO_ROLE );

        return response;
    }

    public static Response getAllUsersOfOrganization(int organizationID){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("organizationId",organizationID )
                .header("Authorization", BaseClass.token)
                .when()
                .get(GET_ORGANIZATION_USERS);

        return response;
    }

    public static Response getAllUsers(){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", BaseClass.token)
                .when()
                .get(GET_CURRENT_USER);

        return response;
    }

    public static Response updateUser(Object body) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", BaseClass.token)
                .body(body)
                .when()
                .put(UPDATE_USER);

        return response;
    }

    public static Response getUserById(int userId){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id",userId )
                .header("Authorization", BaseClass.token)
                .when()
                .get(GET_USER_BY_ID);

        return response;
    }

    public static Response deleteUserById(int userId) {

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", BaseClass.token)
                .pathParam("id",userId )
                .when()
                .delete(DELETE_USER_BY_ID);

        return response;
    }

    public static Response cherryPickUser(Object body) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", BaseClass.token)
                .body(body)
                .when()
                .post(CHERRY_PICK_USER);

        return response;
    }

    public static Response registerUser(Object body) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(REGISTER_USER);

        return response;
    }

    public static Response resendOrgInvitation(Object body) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", BaseClass.token)
                .body(body)
                .when()
                .post(RESEND_ORG_INVITATION);

        return response;
    }

    public static Response resetUserCredentials(Object body) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(RESET_CREDENTIALS);

        return response;
    }

    public static Response sendVerificationRequest(Object body) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", BaseClass.token)
                .body(body)
                .when()
                .post(SEND_VERIFICATION_REQUEST);

        return response;
    }



}
