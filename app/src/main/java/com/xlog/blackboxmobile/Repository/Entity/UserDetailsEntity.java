package com.xlog.blackboxmobile.Repository.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "UserDetails")
public class UserDetailsEntity {


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAccount_t() {
        return account_t;
    }

    public void setAccount_t(String account_t) {
        this.account_t = account_t;
    }

    public UserDetailsEntity(Integer id, String user_id, String accountid, String image_id, String first_name, String last_name, String account_t) {
        this.id = id;
        this.user_id = user_id;
        this.accountid = accountid;
        this.image_id = image_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.account_t = account_t;
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public Integer id;
    @ColumnInfo(name = "user_id")
    public String user_id;
    @ColumnInfo(name = "account_id")
    public String accountid;
    @ColumnInfo(name = "image")
    public String image_id;
    @ColumnInfo(name = "first_name")
    public String first_name;
    @ColumnInfo(name = "last_name")
    public String last_name;
    @ColumnInfo(name = "account_type")
    public String account_t;
}
