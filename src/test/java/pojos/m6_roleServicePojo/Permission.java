package pojos.m6_roleServicePojo;

public class Permission {
    public String id;
    public String resource;

    public String action;
    public String app_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "id='" + id + '\'' +
                ", resource='" + resource + '\'' +
                ", action='" + action + '\'' +
                ", app_id='" + app_id + '\'' +
                '}';
    }
}
