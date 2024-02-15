package pojos.m5_organisationStatusServicePojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrganisationStatus {

    public int getId() {
        return this.id; }
    public void setId(int id) {
        this.id = id; }
    @JsonIgnoreProperties({"id"})
    public int id;
    @JsonProperty("name")
    public String getName() {
        return this.name; }
    public void setName(String name) {
        this.name = name; }
    public String name;
    @JsonProperty("description")
    public String getDescription() {
        return this.description; }
    public void setDescription(String description) {
        this.description = description; }
    public String description;

    @Override
    public String toString() {
        return "OrganisationStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
