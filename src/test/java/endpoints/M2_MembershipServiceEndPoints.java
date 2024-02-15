package endpoints;
import base.BaseClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class M2_MembershipServiceEndPoints {

    public static final String GET_MEMBERSHIP= "/auth/api/membership";
    public static final String PUT_MEMBERSHIP = "/auth/api/membership";
    public static final String POST_MEMBERSHIP = "/auth/api/membership";
    public static final String GET_MEMBERSHIP_BY_ID = "/auth/api/membership/{id}";
    public static final String DELETE_MEMBERSHIP_BY_ID = "/auth/api/membership/{id}";
    public static final String SUSPEND_MEMBERSHIP_BY_ID = "/auth/api/membership/{id}/suspend";
    public static final String PUT_MEMBERSHIP_ROLE = "/auth/api/membership/role";
    public static final String DELETE_MEMBERSHIP_ROLE = "/auth/api/membership/role";


    // GET ALL MEMBERSHİP
    public static Response getMembership(){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", BaseClass.token)
                .when()
                .get(GET_MEMBERSHIP);
        return response;
    }

    // GET ALL MEMBERSHİP BY USER_ID
    public static Response getMembershipByUser_Id(){
        Response response=  given().
                 accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParam("userId", 31)
                .header("Authorization", BaseClass.token)
                .when()
                .get(GET_MEMBERSHIP);
        return response;
    }

    // GET ALL MEMBERSHİP WITHOUT TOKEN
    public static Response getMembershipWithoutToken(){
        Response response=  given().
                 accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParam("userId", 31)
                .when()
                .get(GET_MEMBERSHIP);
        return response;
    }


    // POST
    public static Response postMembership(Object body){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", BaseClass.token)
                .body(body)
                .when()
                .post(POST_MEMBERSHIP);

        return response;
    }

    // PUT MEMBERSHİP
    public static Response putMembership(Object body){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", BaseClass.token)
                .body(body)
                .when()
                .put(PUT_MEMBERSHIP);

        return response;
    }

    // GET MEMBERSHİP BY SUBSCRIPTION_ID
    public static Response getMembershipBySubscriptionId(String subscriptionId){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id", subscriptionId)
                .header("Authorization", BaseClass.token)
                .when()
                .get(GET_MEMBERSHIP_BY_ID);
        return response;
    }

    // SUSPEND MEMBERSHIP BY SUBSCRIPTION_ID

    public static Response suspendMembershipBySubscriptionId(String subscriptionId){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id", subscriptionId)
                .header("Authorization", BaseClass.token)
                .when()
                .get(SUSPEND_MEMBERSHIP_BY_ID);
        return response;
    }



    // DELETE MEMBERSHIP BY SUBSCRIPTION_ID

    public static Response deleteMembershipBySubscriptionId(String subscriptionId){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id", subscriptionId)
                .header("Authorization", BaseClass.token)
                .when()
                .delete(DELETE_MEMBERSHIP_BY_ID);
        return response;
    }



    // GET MEMBERSHİP BY INVALID SUBSCRIPTION_ID
    public static Response getMembershipByInvalidSubscriptionId(){
       String invalidSubs_id="411aee19-2551-46e7-9c67-784ace101f10";
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id", invalidSubs_id)
                .header("Authorization", BaseClass.token)
                .when()
                .get(GET_MEMBERSHIP_BY_ID);
        return response;
    }


    // SUSPEND MEMBERSHIP BY SUBSCRIPTION_ID

    public static Response suspendMembershipByInvalidSubscriptionId(){
        String invalidSubs_id="411aee19-2551-46e7-9c67-784ace101f10";
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id", invalidSubs_id)
                .header("Authorization", BaseClass.token)
                .when()
                .get(SUSPEND_MEMBERSHIP_BY_ID);
        return response;
    }


    // PUT MEMBERSHİP ROLE
    public static Response putRoleToMembership(Object body){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", BaseClass.token)
                .body(body)
                .when()
                .put(PUT_MEMBERSHIP_ROLE);

        return response;
    }



    // DELETE MEMBERSHIP ROLE

    public static Response deleteMembershipRole(Object body){
        Response response=  given().
                accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", BaseClass.token)
                .body(body)
                .when()
                .delete(DELETE_MEMBERSHIP_ROLE);
        return response;
    }
















}
