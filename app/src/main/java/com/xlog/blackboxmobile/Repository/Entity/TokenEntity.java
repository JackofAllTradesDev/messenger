package com.xlog.blackboxmobile.Repository.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TokenEntity")
public class TokenEntity {

    public Integer getToken_id() {
        return token_id;
    }

    public void setToken_id(Integer token_id) {
        this.token_id = token_id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public TokenEntity(Integer token_id, String access_token, String refresh_token) {
        this.token_id = token_id;
        this.access_token = access_token;
        this.refresh_token = refresh_token;
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "token_ID")
    public Integer token_id;
    @ColumnInfo(name = "access")
   public String access_token;
    @ColumnInfo(name = "r_token")
   public String refresh_token;


}
