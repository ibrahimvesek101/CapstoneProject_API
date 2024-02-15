package test.m5_organisationStatusService;

import base.Hooks;
import endpoints.M5_OrganizationStatusServicesEndPoints;
import org.testng.annotations.Test;
import pojos.m5_organisationStatusServicePojo.OrganisationStatus;
import pojos.m5_organisationStatusServicePojo.PostOrganisation;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CrudOrganisation extends Hooks {

    @Test(priority = 1)
    public static void createNewOrganisation(){
        PostOrganisation po = new PostOrganisation();
        po.setName("test4test");
        po.setDescription("trololo");
        response = M5_OrganizationStatusServicesEndPoints.postOrganisation(po);
        response.prettyPrint();
        response.then().statusCode(201);
    }

    @Test(priority = 2)
    public static void updateOrganisationById(){
        int id = getNewOrganisationBodyId();
        Map<String,Object> body = new HashMap<String,Object>();
        body.put("id", id);
        body.put("name", "putName");
        body.put("description", "putDescription");
        response = M5_OrganizationStatusServicesEndPoints.putOrganisation(body);
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test(priority = 5)
    public static void getOrganisationById(){
        int id = getNewOrganisationBodyId();
        response = M5_OrganizationStatusServicesEndPoints.getOrganisationById(id);
    }



    @Test(priority = 3)
    public static void deleteOrganisationById(){
        int id = getNewOrganisationBodyId();
        response = M5_OrganizationStatusServicesEndPoints.deleteOrganisation(id);
        response.then().statusCode(200);
    }

    @Test(priority = 4)
    public static void deletedOrganisationIsExist(){
        int id = getNewOrganisationBodyId();
        response = M5_OrganizationStatusServicesEndPoints.getOrganisationById(id);
        response.then().statusCode(404);
    }




    // post ettigimiz icerigin idsini alip onu get etmekte kullanmaliyiz ama nasil?
    public static int getNewOrganisationBodyId(){
        response = M5_OrganizationStatusServicesEndPoints.getOrganisationService();
        OrganisationStatus[] Response = response.as(OrganisationStatus[].class);
        int id = 0;
        for (int i = 0; i < Response.length; i++) {
            if(Objects.equals(Response[i].getName(), "test4test")){
                id = Response[i].getId();
                break;
            }else if (Objects.equals(Response[i].getName(), "putName")) {
                id = Response[i].getId();

            }
        }
        return id;
    }


}
