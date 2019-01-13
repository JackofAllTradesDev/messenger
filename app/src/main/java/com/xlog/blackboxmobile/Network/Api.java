package com.xlog.blackboxmobile.Network;

import com.xlog.blackboxmobile.Model.Account.AccountModel;
import com.xlog.blackboxmobile.Model.Account.Cms.ChatModelCms;
import com.xlog.blackboxmobile.Model.ChatList.ChatList;
import com.xlog.blackboxmobile.Model.ChatLogs.ChatLogs;
import com.xlog.blackboxmobile.Model.ChatLogs.Datum;
import com.xlog.blackboxmobile.Model.Login;
import com.xlog.blackboxmobile.Model.LoginCms;
import com.xlog.blackboxmobile.Model.TrasanctionsList.TransactionModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    /**DEV SIDE**/
    String Dev = "https://dev.api.xlog.asia/";
    String DevInternal = "http://dev-bb-api.xlog.asia/";

    @POST("oauth/token")
    Call<Login> Login(@Body Login loginModel);

    @POST("oauth/token")
    Call<LoginCms> LoginCms(@Body LoginCms loginModel);

    @GET("api/me")
    Call<AccountModel> getDetails(@Header("Authorization") String bearer);

    @GET("api/me")
    Call<ChatModelCms> getDetailsCms(@Header("Authorization") String bearer);

    @GET("api/teams")
    Call<List<TransactionModel>> getTransactions(@Header("Authorization") String bearer, @Query("transaction_type") String type);

    @GET("api/teams")
    Call<List<TransactionModel>> getPerTransactions(@Header("Authorization") String bearer, @Query("transaction_type") String type, @Query("prefixed_id") String prefix_id);

    @GET("api/v1/chatlog")
    Call<ChatLogs> getChatLogs(@Query("page") int page, @Query("limit") int limit, @Query("accountId") int account_id, @Query("accountType") String type, @Query("room") String room);

    @GET("api/v1/chatlist")
    Call<ChatList> getChatLists(@Query("page") int page, @Query("limit") int limit, @Query("accountId") int account_id, @Query("accountType") String type);
}
