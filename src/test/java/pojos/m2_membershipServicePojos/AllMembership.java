package pojos.m2_membershipServicePojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class AllMembership {

    //@JsonProperty("appId")
    private int app_id;
    private int user_id;
    private String subscription_id;
    private int membership_type_id;
    private boolean is_individual_membership;
    private int default_role_id;
    private boolean is_active;
    private boolean is_default;
    private int organization_id;
    private int subscription_type_id;


    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getSubscription_id() {
        return subscription_id;
    }

    public void setSubscription_id(String subscription_id) {
        this.subscription_id = subscription_id;
    }

    public int getMembership_type_id() {
        return membership_type_id;
    }

    public void setMembership_type_id(int membership_type_id) {
        this.membership_type_id = membership_type_id;
    }

    public boolean isIs_individual_membership() {
        return is_individual_membership;
    }

    public void setIs_individual_membership(boolean is_individual_membership) {
        this.is_individual_membership = is_individual_membership;
    }

    public int getDefault_role_id() {
        return default_role_id;
    }

    public void setDefault_role_id(int default_role_id) {
        this.default_role_id = default_role_id;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public boolean isIs_default() {
        return is_default;
    }

    public void setIs_default(boolean is_default) {
        this.is_default = is_default;
    }

    public int getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(int organization_id) {
        this.organization_id = organization_id;
    }

    @Override
    public String toString() {
        return "AllMembership{" +
                "app_id=" + app_id +
                ", user_id=" + user_id +
                ", subscription_id='" + subscription_id + '\'' +
                ", membership_type_id=" + membership_type_id +
                ", is_individual_membership=" + is_individual_membership +
                ", default_role_id=" + default_role_id +
                ", is_active=" + is_active +
                ", is_default=" + is_default +
                ", organization_id=" + organization_id +
                ", subscription_type_id=" + subscription_type_id +
                '}';
    }

    public int getSubscription_type_id() {
        return subscription_type_id;
    }

    public void setSubscription_type_id(int subscription_type_id) {
        this.subscription_type_id = subscription_type_id;
    }
}
