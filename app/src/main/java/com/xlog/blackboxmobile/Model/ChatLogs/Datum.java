
package com.xlog.blackboxmobile.Model.ChatLogs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Datum {


    public MessageLogs getMessage() {
        return message;
    }

    public void setMessage(MessageLogs message) {
        this.message = message;
    }

    @SerializedName("chatLogId")
    @Expose
    private Integer chatLogId;
    @SerializedName("createdOn")
    @Expose
    private String createdOn;
    @SerializedName("room")
    @Expose
    private String room;
    @SerializedName("message")
    @Expose
    private MessageLogs message;
    @SerializedName("accountId")
    @Expose
    private Integer accountId;
    @SerializedName("accountType")
    @Expose
    private String accountType;
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("mediumTypeId")
    @Expose
    private Integer mediumTypeId;
    @SerializedName("attachments")
    @Expose
    private List<Object> attachments = null;

    public Datum(String createdOn, MessageLogs message, Integer accountId, String accountType, Integer mediumTypeId) {
        this.createdOn = createdOn;
        this.message = message;
        this.accountId = accountId;
        this.accountType = accountType;
        this.mediumTypeId = mediumTypeId;
    }

    public Integer getChatLogId() {
        return chatLogId;
    }

    public void setChatLogId(Integer chatLogId) {
        this.chatLogId = chatLogId;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

}
