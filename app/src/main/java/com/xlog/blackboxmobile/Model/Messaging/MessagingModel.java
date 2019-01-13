
package com.xlog.blackboxmobile.Model.Messaging;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MessagingModel {

    @SerializedName("room")
    @Expose
    private String room;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("message")
    @Expose
    private Message message;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("accountType")
    @Expose
    private String accountType;
    @SerializedName("accountId")
    @Expose
    private String accountId;
    @SerializedName("transactionId")
    @Expose
    private String transactionId;
    @SerializedName("mediumTypeId")
    @Expose
    private Integer mediumTypeId;
    @SerializedName("attachments")
    @Expose
    private List<Object> attachments = null;
    @SerializedName("recipients")
    @Expose
    private List<Recipient> recipients = null;

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getMediumTypeId() {
        return mediumTypeId;
    }

    public void setMediumTypeId(Integer mediumTypeId) {
        this.mediumTypeId = mediumTypeId;
    }

    public List<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    public List<Recipient> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<Recipient> recipients) {
        this.recipients = recipients;
    }

}
