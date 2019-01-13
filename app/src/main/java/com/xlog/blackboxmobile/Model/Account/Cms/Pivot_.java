
package com.xlog.blackboxmobile.Model.Account.Cms;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pivot_ {

    @SerializedName("cms_profile_id")
    @Expose
    private int cmsProfileId;
    @SerializedName("shipping_line_id")
    @Expose
    private int shippingLineId;

    public int getCmsProfileId() {
        return cmsProfileId;
    }

    public void setCmsProfileId(int cmsProfileId) {
        this.cmsProfileId = cmsProfileId;
    }

    public int getShippingLineId() {
        return shippingLineId;
    }

    public void setShippingLineId(int shippingLineId) {
        this.shippingLineId = shippingLineId;
    }

}
