
package com.xlog.blackboxmobile.Model.Account.Cms;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShippingAgency {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("merchant_id")
    @Expose
    private String merchantId;
    @SerializedName("country_id")
    @Expose
    private int countryId;
    @SerializedName("state_id")
    @Expose
    private int stateId;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("zip_code")
    @Expose
    private String zipCode;
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
    @SerializedName("unopened_notifications_count")
    @Expose
    private int unopenedNotificationsCount;
    @SerializedName("service_charge")
    @Expose
    private String serviceCharge;
    @SerializedName("commission")
    @Expose
    private String commission;
    @SerializedName("charge_type")
    @Expose
    private int chargeType;
    @SerializedName("default_currency_id")
    @Expose
    private Object defaultCurrencyId;
    @SerializedName("default_wallet_id")
    @Expose
    private Object defaultWalletId;
    @SerializedName("transit_points")
    @Expose
    private List<TransitPoint> transitPoints = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
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

    public int getUnopenedNotificationsCount() {
        return unopenedNotificationsCount;
    }

    public void setUnopenedNotificationsCount(int unopenedNotificationsCount) {
        this.unopenedNotificationsCount = unopenedNotificationsCount;
    }

    public String getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(String serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public int getChargeType() {
        return chargeType;
    }

    public void setChargeType(int chargeType) {
        this.chargeType = chargeType;
    }

    public Object getDefaultCurrencyId() {
        return defaultCurrencyId;
    }

    public void setDefaultCurrencyId(Object defaultCurrencyId) {
        this.defaultCurrencyId = defaultCurrencyId;
    }

    public Object getDefaultWalletId() {
        return defaultWalletId;
    }

    public void setDefaultWalletId(Object defaultWalletId) {
        this.defaultWalletId = defaultWalletId;
    }

    public List<TransitPoint> getTransitPoints() {
        return transitPoints;
    }

    public void setTransitPoints(List<TransitPoint> transitPoints) {
        this.transitPoints = transitPoints;
    }

}
