package test.m2_membershipService.Positive;
import base.Hooks;
import endpoints.M2_MembershipServiceEndPoints;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.m2_membershipServicePojos.AllMembership;
import pojos.m2_membershipServicePojos.Dummy;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class CRUD extends Hooks {

    @Test(testName = "Get All Membership",priority = 0)
    public void getMembership() {

        response = M2_MembershipServiceEndPoints.getMembership();
        response.prettyPrint();
        response.then().statusCode(200).contentType(ContentType.JSON);
        AllMembership[] Response= response.as(AllMembership[].class);

        for (int i = 0; i < Response.length; i++) {
            Assert.assertTrue(Response[i].toString().contains("app_id"));
            Assert.assertTrue(Response[i].toString().contains("user_id"));
            Assert.assertTrue(Response[i].toString().contains("subscription_id"));
            Assert.assertTrue(Response[i].toString().contains("membership_type_id"));
            Assert.assertTrue(Response[i].toString().contains("is_active"));
            Assert.assertTrue(Response[i].toString().contains("is_default"));
        }
        Assert.assertTrue( Response.length>0);

    }

    @Test(testName = "Get All Membership by User_id",priority = 1)
    public void getMembershipByUser_Id(){
        response = M2_MembershipServiceEndPoints.getMembershipByUser_Id();
        response.prettyPrint();
        response.then().statusCode(200).contentType(ContentType.JSON);
        AllMembership[] Response= response.as(AllMembership[].class);
        for (int i = 0; i < Response.length; i++) {
            Assert.assertTrue(Response[i].toString().contains("app_id"));
            Assert.assertTrue(Response[i].toString().contains("user_id"));
            Assert.assertTrue(Response[i].toString().contains("subscription_id"));
            Assert.assertTrue(Response[i].toString().contains("membership_type_id"));
            Assert.assertTrue(Response[i].toString().contains("is_active"));
            Assert.assertTrue(Response[i].toString().contains("is_default"));
        }
        Assert.assertTrue( Response.length>0);
    }

    @Test(testName = "Add a Membership",priority = 2)
    public void postMembership() {
        AllMembership Response= new AllMembership();
        Response.setApp_id(2);
        Response.setUser_id(31);
        Response.setSubscription_type_id(29); // Real M.
        response = M2_MembershipServiceEndPoints.postMembership(Response);
        response.prettyPrint();
        response.then().statusCode(201).contentType(ContentType.JSON);
        AllMembership all= response.as(AllMembership.class);
        Assert.assertEquals(all.getApp_id(),Response.getApp_id());
        Assert.assertEquals(all.getUser_id(),Response.getUser_id());
        Assert.assertEquals(all.getSubscription_type_id(),Response.getSubscription_type_id());
        String subs_id=response.path("subscription_id");
        Dummy.setSubscription_id(subs_id); // subs_id dummy'e atandı.
        getMembershipBySubscriptionId();
    }

    @Test(testName = "Update Membership",priority = 3)
    public void putMembership(){
        AllMembership Response= new AllMembership();
        Response.setSubscription_id(Dummy.getSubscription_id());
        Response.setSubscription_type_id(35); // Galatasaray
        response = M2_MembershipServiceEndPoints.putMembership(Response);
        response.prettyPrint();
        response.then().statusCode(200).contentType(ContentType.JSON).
                body("subscription_type_id",equalTo(35)).
                body("subscription_id",equalTo(Dummy.getSubscription_id()));

       getMembershipBySubscriptionId();
    }

    @Test(testName = "Get Membership By Subscription_id",priority = 4)
    public void getMembershipBySubscriptionId(){
        response = M2_MembershipServiceEndPoints.getMembershipBySubscriptionId(Dummy.getSubscription_id());
        response.prettyPrint();
        response.then().statusCode(200).contentType(ContentType.JSON).
                body("subscription_id",equalTo(Dummy.getSubscription_id()));
    }

    @Test(testName = "Suspend Membership By Subscription_id",priority = 5)
    public void suspendMembershipBySubscriptionId(){
        response = M2_MembershipServiceEndPoints.suspendMembershipBySubscriptionId(Dummy.getSubscription_id());
        response.prettyPrint();
        response.then().statusCode(404);
        response = M2_MembershipServiceEndPoints.getMembershipBySubscriptionId(Dummy.getSubscription_id());
        response.then().statusCode(200).contentType(ContentType.JSON).
                body("is_active",equalTo(false));
    }

    @Test(testName = "Delete Membership By Subscription_id",priority = 6)
    public void deleteMembershipBySubscriptionId(){
        response = M2_MembershipServiceEndPoints.deleteMembershipBySubscriptionId(Dummy.getSubscription_id());
        response.then().statusCode(200);
        response = M2_MembershipServiceEndPoints.getMembershipBySubscriptionId(Dummy.getSubscription_id());
        response.then().statusCode(404).assertThat().statusLine(containsString("Not Found"));
    }


}
