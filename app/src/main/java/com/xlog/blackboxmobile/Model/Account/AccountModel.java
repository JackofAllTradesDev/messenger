
package com.xlog.blackboxmobile.Model.Account;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountModel {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("username")
    @Expose
    private Object username;
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
    private String lastLogin;
    @SerializedName("current_login")
    @Expose
    private String currentLogin;
    @SerializedName("account_type")
    @Expose
    private int accountType;
    @SerializedName("unopened_notifications_count")
    @Expose
    private int unopenedNotificationsCount;
    @SerializedName("cms_profile")
    @Expose
    private Object cmsProfile;
    @SerializedName("entity")
    @Expose
    private Entity entity;

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

    public Object getUsername() {
        return username;
    }

    public void setUsername(Object username) {
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

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getCurrentLogin() {
        return currentLogin;
    }

    public void setCurrentLogin(String currentLogin) {
        this.currentLogin = currentLogin;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public int getUnopenedNotificationsCount() {
        return unopenedNotificationsCount;
    }

    public void setUnopenedNotificationsCount(int unopenedNotificationsCount) {
        this.unopenedNotificationsCount = unopenedNotificationsCount;
    }

    public Object getCmsProfile() {
        return cmsProfile;
    }

    public void setCmsProfile(Object cmsProfile) {
        this.cmsProfile = cmsProfile;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

}
