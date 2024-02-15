package test.m2_membershipService.Negative;
import base.Hooks;
import com.fasterxml.jackson.core.JsonProcessingException;
import endpoints.M2_MembershipServiceEndPoints;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.containsString;

public class Get_AllMembership extends Hooks {

    @Test(testName = "Get All Membership without token")
    public void getMembershipByUser_Id(){
        response = M2_MembershipServiceEndPoints.getMembershipWithoutToken();
        response.prettyPrint();
        response.then().statusCode(401).assertThat().statusLine(containsString("Unauthorized"));

    }

}
