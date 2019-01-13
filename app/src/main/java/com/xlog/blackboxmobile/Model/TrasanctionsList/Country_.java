
package com.xlog.blackboxmobile.Model.TrasanctionsList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country_ {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("calling_code")
    @Expose
    private String callingCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCallingCode() {
        return callingCode;
    }

    public void setCallingCode(String callingCode) {
        this.callingCode = callingCode;
    }

}
