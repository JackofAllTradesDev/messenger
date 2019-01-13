
package com.xlog.blackboxmobile.Model.Account;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("country_id")
    @Expose
    private int countryId;
    @SerializedName("state_id")
    @Expose
    private int stateId;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("zip_code")
    @Expose
    private String zipCode;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("payment_email")
    @Expose
    private String paymentEmail;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("mobile_number")
    @Expose
    private String mobileNumber;
    @SerializedName("fax_number")
    @Expose
    private String faxNumber;
    @SerializedName("company_registration_number")
    @Expose
    private String companyRegistrationNumber;
    @SerializedName("shipper_status")
    @Expose
    private int shipperStatus;
    @SerializedName("shipper_supporting_documents")
    @Expose
    private List<String> shipperSupportingDocuments = null;
    @SerializedName("shipper_accreditation_number")
    @Expose
    private String shipperAccreditationNumber;
    @SerializedName("shipper_reference_key")
    @Expose
    private String shipperReferenceKey;
    @SerializedName("consignee_status")
    @Expose
    private Object consigneeStatus;
    @SerializedName("consignee_accreditation_number")
    @Expose
    private Object consigneeAccreditationNumber;
    @SerializedName("consignee_supporting_documents")
    @Expose
    private Object consigneeSupportingDocuments;
    @SerializedName("consignee_reference_key")
    @Expose
    private Object consigneeReferenceKey;
    @SerializedName("domestic_status")
    @Expose
    private int domesticStatus;
    @SerializedName("domestic_supporting_documents")
    @Expose
    private List<String> domesticSupportingDocuments = null;
    @SerializedName("domestic_reference_key")
    @Expose
    private String domesticReferenceKey;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("cucc")
    @Expose
    private Object cucc;
    @SerializedName("evault_account_id")
    @Expose
    private String evaultAccountId;
    @SerializedName("priority")
    @Expose
    private int priority;
    @SerializedName("company_highlights")
    @Expose
    private String companyHighlights;
    @SerializedName("shipper_created_at")
    @Expose
    private String shipperCreatedAt;
    @SerializedName("consignee_created_at")
    @Expose
    private Object consigneeCreatedAt;
    @SerializedName("domestic_created_at")
    @Expose
    private String domesticCreatedAt;
    @SerializedName("shipper_type")
    @Expose
    private int shipperType;
    @SerializedName("user_id")
    @Expose
    private int userId;
    @SerializedName("corporate_title")
    @Expose
    private String corporateTitle;
    @SerializedName("preferred_timezone")
    @Expose
    private String preferredTimezone;
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("is_profile_completed")
    @Expose
    private int isProfileCompleted;
    @SerializedName("is_evault_completed")
    @Expose
    private int isEvaultCompleted;
    @SerializedName("is_clients_completed")
    @Expose
    private int isClientsCompleted;
    @SerializedName("is_preferences_completed")
    @Expose
    private int isPreferencesCompleted;
    @SerializedName("has_shipping_reservation")
    @Expose
    private int hasShippingReservation;
    @SerializedName("is_custom_broker_payment")
    @Expose
    private int isCustomBrokerPayment;
    @SerializedName("permission_type")
    @Expose
    private int permissionType;
    @SerializedName("default_currency_id")
    @Expose
    private Object defaultCurrencyId;
    @SerializedName("merchant_id")
    @Expose
    private Object merchantId;
    @SerializedName("default_wallet_id")
    @Expose
    private Object defaultWalletId;
    @SerializedName("is_terms_and_condition_accepted")
    @Expose
    private int isTermsAndConditionAccepted;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPaymentEmail() {
        return paymentEmail;
    }

    public void setPaymentEmail(String paymentEmail) {
        this.paymentEmail = paymentEmail;
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

    public String getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    public void setCompanyRegistrationNumber(String companyRegistrationNumber) {
        this.companyRegistrationNumber = companyRegistrationNumber;
    }

    public int getShipperStatus() {
        return shipperStatus;
    }

    public void setShipperStatus(int shipperStatus) {
        this.shipperStatus = shipperStatus;
    }

    public List<String> getShipperSupportingDocuments() {
        return shipperSupportingDocuments;
    }

    public void setShipperSupportingDocuments(List<String> shipperSupportingDocuments) {
        this.shipperSupportingDocuments = shipperSupportingDocuments;
    }

    public String getShipperAccreditationNumber() {
        return shipperAccreditationNumber;
    }

    public void setShipperAccreditationNumber(String shipperAccreditationNumber) {
        this.shipperAccreditationNumber = shipperAccreditationNumber;
    }

    public String getShipperReferenceKey() {
        return shipperReferenceKey;
    }

    public void setShipperReferenceKey(String shipperReferenceKey) {
        this.shipperReferenceKey = shipperReferenceKey;
    }

    public Object getConsigneeStatus() {
        return consigneeStatus;
    }

    public void setConsigneeStatus(Object consigneeStatus) {
        this.consigneeStatus = consigneeStatus;
    }

    public Object getConsigneeAccreditationNumber() {
        return consigneeAccreditationNumber;
    }

    public void setConsigneeAccreditationNumber(Object consigneeAccreditationNumber) {
        this.consigneeAccreditationNumber = consigneeAccreditationNumber;
    }

    public Object getConsigneeSupportingDocuments() {
        return consigneeSupportingDocuments;
    }

    public void setConsigneeSupportingDocuments(Object consigneeSupportingDocuments) {
        this.consigneeSupportingDocuments = consigneeSupportingDocuments;
    }

    public Object getConsigneeReferenceKey() {
        return consigneeReferenceKey;
    }

    public void setConsigneeReferenceKey(Object consigneeReferenceKey) {
        this.consigneeReferenceKey = consigneeReferenceKey;
    }

    public int getDomesticStatus() {
        return domesticStatus;
    }

    public void setDomesticStatus(int domesticStatus) {
        this.domesticStatus = domesticStatus;
    }

    public List<String> getDomesticSupportingDocuments() {
        return domesticSupportingDocuments;
    }

    public void setDomesticSupportingDocuments(List<String> domesticSupportingDocuments) {
        this.domesticSupportingDocuments = domesticSupportingDocuments;
    }

    public String getDomesticReferenceKey() {
        return domesticReferenceKey;
    }

    public void setDomesticReferenceKey(String domesticReferenceKey) {
        this.domesticReferenceKey = domesticReferenceKey;
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

    public Object getCucc() {
        return cucc;
    }

    public void setCucc(Object cucc) {
        this.cucc = cucc;
    }

    public String getEvaultAccountId() {
        return evaultAccountId;
    }

    public void setEvaultAccountId(String evaultAccountId) {
        this.evaultAccountId = evaultAccountId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getCompanyHighlights() {
        return companyHighlights;
    }

    public void setCompanyHighlights(String companyHighlights) {
        this.companyHighlights = companyHighlights;
    }

    public String getShipperCreatedAt() {
        return shipperCreatedAt;
    }

    public void setShipperCreatedAt(String shipperCreatedAt) {
        this.shipperCreatedAt = shipperCreatedAt;
    }

    public Object getConsigneeCreatedAt() {
        return consigneeCreatedAt;
    }

    public void setConsigneeCreatedAt(Object consigneeCreatedAt) {
        this.consigneeCreatedAt = consigneeCreatedAt;
    }

    public String getDomesticCreatedAt() {
        return domesticCreatedAt;
    }

    public void setDomesticCreatedAt(String domesticCreatedAt) {
        this.domesticCreatedAt = domesticCreatedAt;
    }

    public int getShipperType() {
        return shipperType;
    }

    public void setShipperType(int shipperType) {
        this.shipperType = shipperType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCorporateTitle() {
        return corporateTitle;
    }

    public void setCorporateTitle(String corporateTitle) {
        this.corporateTitle = corporateTitle;
    }

    public String getPreferredTimezone() {
        return preferredTimezone;
    }

    public void setPreferredTimezone(String preferredTimezone) {
        this.preferredTimezone = preferredTimezone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsProfileCompleted() {
        return isProfileCompleted;
    }

    public void setIsProfileCompleted(int isProfileCompleted) {
        this.isProfileCompleted = isProfileCompleted;
    }

    public int getIsEvaultCompleted() {
        return isEvaultCompleted;
    }

    public void setIsEvaultCompleted(int isEvaultCompleted) {
        this.isEvaultCompleted = isEvaultCompleted;
    }

    public int getIsClientsCompleted() {
        return isClientsCompleted;
    }

    public void setIsClientsCompleted(int isClientsCompleted) {
        this.isClientsCompleted = isClientsCompleted;
    }

    public int getIsPreferencesCompleted() {
        return isPreferencesCompleted;
    }

    public void setIsPreferencesCompleted(int isPreferencesCompleted) {
        this.isPreferencesCompleted = isPreferencesCompleted;
    }

    public int getHasShippingReservation() {
        return hasShippingReservation;
    }

    public void setHasShippingReservation(int hasShippingReservation) {
        this.hasShippingReservation = hasShippingReservation;
    }

    public int getIsCustomBrokerPayment() {
        return isCustomBrokerPayment;
    }

    public void setIsCustomBrokerPayment(int isCustomBrokerPayment) {
        this.isCustomBrokerPayment = isCustomBrokerPayment;
    }

    public int getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(int permissionType) {
        this.permissionType = permissionType;
    }

    public Object getDefaultCurrencyId() {
        return defaultCurrencyId;
    }

    public void setDefaultCurrencyId(Object defaultCurrencyId) {
        this.defaultCurrencyId = defaultCurrencyId;
    }

    public Object getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Object merchantId) {
        this.merchantId = merchantId;
    }

    public Object getDefaultWalletId() {
        return defaultWalletId;
    }

    public void setDefaultWalletId(Object defaultWalletId) {
        this.defaultWalletId = defaultWalletId;
    }

    public int getIsTermsAndConditionAccepted() {
        return isTermsAndConditionAccepted;
    }

    public void setIsTermsAndConditionAccepted(int isTermsAndConditionAccepted) {
        this.isTermsAndConditionAccepted = isTermsAndConditionAccepted;
    }

}
