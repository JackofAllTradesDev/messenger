
package com.xlog.blackboxmobile.Model.ChatList;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChatList {

    @SerializedName("hasNext")
    @Expose
    private boolean hasNext;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}
