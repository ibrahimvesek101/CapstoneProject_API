package base;

import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import utils.ExtentReport;

@Listeners(ExtentReport.class)
public class BaseClass {


    static public String token;

    static public Response response;
}
