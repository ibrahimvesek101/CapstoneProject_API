package pojos.m6_roleServicePojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleByAppIdPojo {
    @JsonProperty("id")
    public int getId() {
        return this.id; }
    public void setId(int id) {
        this.id = id; }
    public int id;
    @JsonProperty("name")
    public String getName() {
        return this.name; }

    public void setName(String name) {
        this.name = name; }
    public String name;
    @JsonProperty("app_id")
    public int getApp_id() {
        return this.app_id; }
    public void setApp_id(int app_id) {
        this.app_id = app_id; }
    public int app_id;

    @Override
    public String toString() {
        return "RoleByAppIdPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", app_id=" + app_id +
                '}';
    }
}
