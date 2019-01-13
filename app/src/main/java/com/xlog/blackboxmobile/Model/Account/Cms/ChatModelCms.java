
package com.xlog.blackboxmobile.Model.Account.Cms;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChatModelCms {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("login_attempts")
    @Expose
    private int loginAttempts;
    @SerializedName("last_login")
    @Expose
    private Object lastLogin;
    @SerializedName("current_login")
    @Expose
    private Object currentLogin;
    @SerializedName("account_type")
    @Expose
    private Integer accountType;
    @SerializedName("unopened_notifications_count")
    @Expose
    private int unopenedNotificationsCount;
    @SerializedName("cms_profile")
    @Expose
    private CmsProfile cmsProfile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public Object getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Object lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Object getCurrentLogin() {
        return currentLogin;
    }

    public void setCurrentLogin(Object currentLogin) {
        this.currentLogin = currentLogin;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public int getUnopenedNotificationsCount() {
        return unopenedNotificationsCount;
    }

    public void setUnopenedNotificationsCount(int unopenedNotificationsCount) {
        this.unopenedNotificationsCount = unopenedNotificationsCount;
    }

    public CmsProfile getCmsProfile() {
        return cmsProfile;
    }

    public void setCmsProfile(CmsProfile cmsProfile) {
        this.cmsProfile = cmsProfile;
    }

}
