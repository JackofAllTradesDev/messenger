
package com.xlog.blackboxmobile.Model.Account.Cms;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CmsProfile {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("user_id")
    @Expose
    private int userId;
    @SerializedName("group_id")
    @Expose
    private int groupId;
    @SerializedName("shipping_agency_id")
    @Expose
    private int shippingAgencyId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("preferred_timezone")
    @Expose
    private String preferredTimezone;
    @SerializedName("port_operator_agent_id")
    @Expose
    private Object portOperatorAgentId;
    @SerializedName("permission_type")
    @Expose
    private int permissionType;
    @SerializedName("group")
    @Expose
    private Group group;
    @SerializedName("shipping_lines")
    @Expose
    private List<ShippingLine> shippingLines = null;
    @SerializedName("shipping_agency")
    @Expose
    private ShippingAgency shippingAgency;
    @SerializedName("port_operator_agent")
    @Expose
    private Object portOperatorAgent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getShippingAgencyId() {
        return shippingAgencyId;
    }

    public void setShippingAgencyId(int shippingAgencyId) {
        this.shippingAgencyId = shippingAgencyId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPreferredTimezone() {
        return preferredTimezone;
    }

    public void setPreferredTimezone(String preferredTimezone) {
        this.preferredTimezone = preferredTimezone;
    }

    public Object getPortOperatorAgentId() {
        return portOperatorAgentId;
    }

    public void setPortOperatorAgentId(Object portOperatorAgentId) {
        this.portOperatorAgentId = portOperatorAgentId;
    }

    public int getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(int permissionType) {
        this.permissionType = permissionType;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<ShippingLine> getShippingLines() {
        return shippingLines;
    }

    public void setShippingLines(List<ShippingLine> shippingLines) {
        this.shippingLines = shippingLines;
    }

    public ShippingAgency getShippingAgency() {
        return shippingAgency;
    }

    public void setShippingAgency(ShippingAgency shippingAgency) {
        this.shippingAgency = shippingAgency;
    }

    public Object getPortOperatorAgent() {
        return portOperatorAgent;
    }

    public void setPortOperatorAgent(Object portOperatorAgent) {
        this.portOperatorAgent = portOperatorAgent;
    }

}
