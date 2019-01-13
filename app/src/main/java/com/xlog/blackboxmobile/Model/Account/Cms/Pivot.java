
package com.xlog.blackboxmobile.Model.Account.Cms;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pivot {

    @SerializedName("group_id")
    @Expose
    private int groupId;
    @SerializedName("permission_id")
    @Expose
    private int permissionId;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

}
