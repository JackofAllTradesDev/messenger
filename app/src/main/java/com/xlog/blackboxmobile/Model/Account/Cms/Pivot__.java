
package com.xlog.blackboxmobile.Model.Account.Cms;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pivot__ {

    @SerializedName("shipping_agency_id")
    @Expose
    private int shippingAgencyId;
    @SerializedName("transit_point_id")
    @Expose
    private int transitPointId;

    public int getShippingAgencyId() {
        return shippingAgencyId;
    }

    public void setShippingAgencyId(int shippingAgencyId) {
        this.shippingAgencyId = shippingAgencyId;
    }

    public int getTransitPointId() {
        return transitPointId;
    }

    public void setTransitPointId(int transitPointId) {
        this.transitPointId = transitPointId;
    }

}
