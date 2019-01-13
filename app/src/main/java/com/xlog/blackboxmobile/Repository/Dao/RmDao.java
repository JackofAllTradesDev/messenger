package com.xlog.blackboxmobile.Repository.Dao;

import com.xlog.blackboxmobile.Repository.Entity.TokenEntity;
import com.xlog.blackboxmobile.Repository.Entity.UserDetailsEntity;

import java.util.List;

import androidx.room.Insert;
import androidx.room.Query;

@androidx.room.Dao
public interface RmDao {
    @Insert
    void setToken(TokenEntity... tokenEntities);

    @Insert
    void setUser(UserDetailsEntity... userDetailsEntities);


    @Query("SELECT COUNT(*) from TokenEntity")
    int countToken();

    @Query("UPDATE TokenEntity SET access= :token WHERE token_ID = :id")
    void update(String token, int id);

    @Query("SELECT * FROM TokenEntity")
    List<TokenEntity> getToken();

    @Query("SELECT * FROM UserDetails")
    List<UserDetailsEntity> getUserDetails();

    @Query("SELECT COUNT(*) from UserDetails")
    int countUser();

    @Query("DELETE FROM UserDetails")
    void deleteAllUsers();



}
