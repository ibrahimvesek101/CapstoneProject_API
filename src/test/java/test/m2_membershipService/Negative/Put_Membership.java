package test.m2_membershipService.Negative;
import base.Hooks;
import com.fasterxml.jackson.core.JsonProcessingException;
import endpoints.M2_MembershipServiceEndPoints;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojos.m2_membershipServicePojos.AllMembership;
import static org.hamcrest.Matchers.equalTo;

public class Put_Membership extends Hooks {

    @Test (testName = "Put Membership only by Subscription_id")
    public void putMembershipOnlyBySubs_id(){
        AllMembership allMembership= new AllMembership();
        allMembership.setSubscription_id("6e67dc25-abfe-4aa0-98fa-f5b3dbd283ca"); // Manager
        response = M2_MembershipServiceEndPoints.putMembership(allMembership);
        response.prettyPrint();
        response.then().statusCode(406).contentType(ContentType.JSON)
                .body("error",equalTo("Not Acceptable"));
    }

    @Test (testName = "Put Membership only by Subscription_type_id")
    public void putMembershipOnlyBySubs_type_id(){
        AllMembership Membership= new AllMembership();
        Membership.setSubscription_type_id(6);
        response = M2_MembershipServiceEndPoints.putMembership(Membership);
        response.prettyPrint();
        response.then().statusCode(406).contentType(ContentType.JSON)
                .body("error",equalTo("Not Acceptable"));
    }

    @Test (testName = "Put Membership by Invalid Subscription_id")
    public void putMembershipOnlyByInvalidSubs_id() {
        AllMembership membership= new AllMembership();
        membership.setSubscription_id("411aee19-2551-46e7-9c67-784ace101f10");
        membership.setMembership_type_id(30);
        response = M2_MembershipServiceEndPoints.putMembership(membership);
        response.prettyPrint();
        response.then().statusCode(404).contentType(ContentType.JSON);
        // Expected status code <404> but was <406>
    }

}
