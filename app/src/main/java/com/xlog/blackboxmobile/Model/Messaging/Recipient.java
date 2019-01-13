
package com.xlog.blackboxmobile.Model.Messaging;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recipient {

    @SerializedName("accountId")
    @Expose
    private Integer accountId;
    @SerializedName("accountType")
    @Expose
    private String accountType;

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

}
