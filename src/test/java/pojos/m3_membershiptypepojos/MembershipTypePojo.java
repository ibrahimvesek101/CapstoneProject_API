package pojos.m3_membershiptypepojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class MembershipTypePojo {
    
    private int id;
    private String name;
    private boolean is_enabled;
    private boolean is_individual_plan;
    private int subscription_type_id;
    private int app_id;
    private Date created_at;
    private int created_by;
    private Date updated_at;
    private int updated_by;
    private int default_role_id;
    private String short_name;





    public static MembershipTypePojo createMembershipType(){
        MembershipTypePojo postMembershipType = new MembershipTypePojo();

        postMembershipType.setName("Nur Membership Type Post");
        postMembershipType.setIs_enabled(true);
        postMembershipType.setApp_id(2);
         return postMembershipType;
    }


    public static MembershipTypePojo createMembershipTypeIntName(){
        MembershipTypePojo postMembershipType = new MembershipTypePojo();

        String nameAsString = "42";
        int nameAsInt = Integer.parseInt(nameAsString);
        postMembershipType.setName(String.valueOf(nameAsInt));
        System.out.println("nameAsInt = " + nameAsInt);
        postMembershipType.setIs_enabled(true);
        postMembershipType.setApp_id(2);
        return postMembershipType;
    }


    public static MembershipTypePojo createMembershipTypeWithoutAppId(){
        MembershipTypePojo postMembershipType = new MembershipTypePojo();

        postMembershipType.setName("Nur Membership Type Post 2");
        postMembershipType.setIs_enabled(true);
        return postMembershipType;
    }




    public static MembershipTypePojo updateMembershipType() {
        MembershipTypePojo putMembershipType = new MembershipTypePojo();

        putMembershipType.setId(DummyClass.getMembershipTypeId());
        putMembershipType.setName("Membership Type NUR Update");
        putMembershipType.setIs_enabled(true);
        putMembershipType.setApp_id(2);
        return putMembershipType;
    }




    public static MembershipTypePojo updateMembershipTypeWithoutId() {
        MembershipTypePojo putMembershipType = new MembershipTypePojo();

        //putMembershipType.setId(DummyClass.getMembershipTypeId()); id olmadan update
        putMembershipType.setName("Membership Type NUR Update Invalid");
        putMembershipType.setIs_enabled(true);
        putMembershipType.setApp_id(2);
        return putMembershipType;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_enabled() {
        return is_enabled;
    }

    public void setIs_enabled(boolean is_enabled) {
        this.is_enabled = is_enabled;
    }

    public boolean isIs_individual_plan() {
        return is_individual_plan;
    }

    public void setIs_individual_plan(boolean is_individual_plan) {
        this.is_individual_plan = is_individual_plan;
    }

    public int getSubscription_type_id() {
        return subscription_type_id;
    }

    public void setSubscription_type_id(int subscription_type_id) {
        this.subscription_type_id = subscription_type_id;
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public int getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(int updated_by) {
        this.updated_by = updated_by;
    }

    public int getDefault_role_id() {
        return default_role_id;
    }

    public void setDefault_role_id(int default_role_id) {
        this.default_role_id = default_role_id;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    @Override
    public String toString() {
        return "MembershipTypePojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", is_enabled=" + is_enabled +
                ", is_individual_plan=" + is_individual_plan +
                ", subscription_type_id=" + subscription_type_id +
                ", app_id=" + app_id +
                ", created_at=" + created_at +
                ", created_by=" + created_by +
                ", updated_at=" + updated_at +
                ", updated_by=" + updated_by +
                ", default_role_id=" + default_role_id +
                ", short_name='" + short_name + '\'' +
                '}';
    }







}
