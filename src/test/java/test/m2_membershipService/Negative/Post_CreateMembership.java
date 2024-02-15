package test.m2_membershipService.Negative;
import base.Hooks;
import endpoints.M2_MembershipServiceEndPoints;
import org.testng.annotations.Test;
import pojos.m2_membershipServicePojos.AllMembership;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class Post_CreateMembership extends Hooks {

    @Test
    public void postMembershipWithoutApp_id() {
        AllMembership allMembership = new AllMembership();
        allMembership.setUser_id(31);
        allMembership.setSubscription_type_id(29);
        response = M2_MembershipServiceEndPoints.postMembership(allMembership);
        response.prettyPrint();
        response.then().statusCode(406).body("error",equalTo("Not Acceptable"));
    }

    @Test
    public void postMembershipWithoutUser_id() {
        AllMembership allMembership = new AllMembership();
        allMembership.setApp_id(2);
        allMembership.setSubscription_type_id(29);
        response = M2_MembershipServiceEndPoints.postMembership(allMembership);
        response.prettyPrint();
        response.then().statusCode(406).body("error",equalTo("Not Acceptable"));
    }

    @Test
    public void postMembershipWithoutSubs_type_id() {
        AllMembership allMembership = new AllMembership();
        allMembership.setApp_id(2);
        allMembership.setUser_id(31);
        response = M2_MembershipServiceEndPoints.postMembership(allMembership);
        response.prettyPrint();
        response.then().statusCode(406).assertThat().statusLine(containsString("Not Acceptable"));
        response.then().body("error",equalTo("Not Acceptable"));
    }

    @Test
    public void postMembershipWithBadRequest() {
        String jsonPayload = "{\"user_id\": 31, \"app_id\": 2,\"subscription_type_id\": 29...}";
        response = M2_MembershipServiceEndPoints.postMembership(jsonPayload);
        response.prettyPrint();
        response.then().statusCode(400).assertThat().statusLine(containsString("Bad Request"));
        response.then().body("error",equalTo("Bad Request"));
    }

}
