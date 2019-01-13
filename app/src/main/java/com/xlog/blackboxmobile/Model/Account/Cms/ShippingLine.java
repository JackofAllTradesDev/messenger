
package com.xlog.blackboxmobile.Model.Account.Cms;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShippingLine {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("country_id")
    @Expose
    private int countryId;
    @SerializedName("state_id")
    @Expose
    private int stateId;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("standard_carrier_alpha_code")
    @Expose
    private String standardCarrierAlphaCode;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("zip_code")
    @Expose
    private String zipCode;
    @SerializedName("priority")
    @Expose
    private int priority;
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("mobile_number")
    @Expose
    private String mobileNumber;
    @SerializedName("fax_number")
    @Expose
    private String faxNumber;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("pivot")
    @Expose
    private Pivot_ pivot;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandardCarrierAlphaCode() {
        return standardCarrierAlphaCode;
    }

    public void setStandardCarrierAlphaCode(String standardCarrierAlphaCode) {
        this.standardCarrierAlphaCode = standardCarrierAlphaCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
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

    public Pivot_ getPivot() {
        return pivot;
    }

    public void setPivot(Pivot_ pivot) {
        this.pivot = pivot;
    }

}
