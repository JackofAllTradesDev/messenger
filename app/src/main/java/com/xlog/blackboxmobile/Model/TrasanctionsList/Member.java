
package com.xlog.blackboxmobile.Model.TrasanctionsList;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Member {

    @SerializedName("account_id")
    @Expose
    private int accountId;
    @SerializedName("user_id")
    @Expose
    private int userId;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("account_type")
    @Expose
    private String accountType;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("transaction_id")
    @Expose
    private String transactionId;
    @SerializedName("transaction_type")
    @Expose
    private String transactionType;
    @SerializedName("company_name")
    @Expose
    private String companyName;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("mobile_number")
    @Expose
    private String mobileNumber;
    @SerializedName("email_address")
    @Expose
    private String emailAddress;
    @SerializedName("is_private")
    @Expose
    private boolean isPrivate;
    @SerializedName("entities")
    @Expose
    private List<Entity_> entities = null;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public List<Entity_> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity_> entities) {
        this.entities = entities;
    }

}
