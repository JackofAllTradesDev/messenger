
package com.xlog.blackboxmobile.Model.ChatList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("transactionId")
    @Expose
    private String transactionId;
    @SerializedName("chatTransactionId")
    @Expose
    private int chatTransactionId;
    @SerializedName("unreadCount")
    @Expose
    private int unreadCount;
    @SerializedName("recentChat")
    @Expose
    private RecentChat recentChat;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getChatTransactionId() {
        return chatTransactionId;
    }

    public void setChatTransactionId(int chatTransactionId) {
        this.chatTransactionId = chatTransactionId;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public RecentChat getRecentChat() {
        return recentChat;
    }

    public void setRecentChat(RecentChat recentChat) {
        this.recentChat = recentChat;
    }

}
