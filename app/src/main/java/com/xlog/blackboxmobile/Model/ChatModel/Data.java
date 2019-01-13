
package com.xlog.blackboxmobile.Model.ChatModel;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Data {



    private String date;

    private String image;

    private MessageNew messageNew;

    private String firstName;

    private String lastName;

    private int accountId;

    private String accountType;

    private int userId;

    private int mediumTypeId;

    public Data(String date, String image, MessageNew messageNew, String firstName, String lastName, int accountId, String accountType, int userId, int mediumTypeId, JSONArray attachments) {
        this.date = date;
        this.image = image;
        this.messageNew = messageNew;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountId = accountId;
        this.accountType = accountType;
        this.userId = userId;
        this.mediumTypeId = mediumTypeId;
        this.attachments = attachments;
    }

    private JSONArray attachments = null;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MessageNew getMessageNew() {
        return messageNew;
    }

    public void setMessageNew(MessageNew messageNew) {
        this.messageNew = messageNew;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMediumTypeId() {
        return mediumTypeId;
    }

    public void setMediumTypeId(int mediumTypeId) {
        this.mediumTypeId = mediumTypeId;
    }

    public JSONArray getAttachments() {
        return attachments;
    }

    public void setAttachments(JSONArray attachments) {
        this.attachments = attachments;
    }

}
