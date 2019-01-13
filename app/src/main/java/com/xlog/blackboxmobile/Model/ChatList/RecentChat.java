
package com.xlog.blackboxmobile.Model.ChatList;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecentChat {

    @SerializedName("createdOn")
    @Expose
    private String createdOn;
    @SerializedName("room")
    @Expose
    private String room;
    @SerializedName("message")
    @Expose
    private Message message;
    @SerializedName("accountId")
    @Expose
    private int accountId;
    @SerializedName("accountType")
    @Expose
    private String accountType;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("mediumTypeId")
    @Expose
    private int mediumTypeId;
    @SerializedName("attachments")
    @Expose
    private List<String> attachments = null;

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

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getMediumTypeId() {
        return mediumTypeId;
    }

    public void setMediumTypeId(int mediumTypeId) {
        this.mediumTypeId = mediumTypeId;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

}
