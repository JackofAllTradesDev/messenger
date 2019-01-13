package com.xlog.blackboxmobile.Login;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import com.xlog.blackboxmobile.Model.Login;
import com.xlog.blackboxmobile.Model.LoginCms;
import com.xlog.blackboxmobile.Network.Api;
import com.xlog.blackboxmobile.Network.ApiClient;
import com.xlog.blackboxmobile.Repository.Database.RmDatabase;
import com.xlog.blackboxmobile.Repository.Entity.TokenEntity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * Created by Jay on 12/03/2018.
 */
public class LoginInteractor{

    public LoginInteractor(Context context) {
        this.context = context;
    }

    private Context context;
    private static final String TAG = "LOGIN";
    interface OnLoginFinishedListener {

        void onErrorMessage();

        void onSuccess();

        void errorLogin(String message, String messageBody);

    }

    public void login(final String username, final String password, final Boolean type, final OnLoginFinishedListener listener) {


            if (TextUtils.isEmpty(username) && TextUtils.isEmpty(password)) {
                listener.onErrorMessage();
                return;
            }else if (type == true){
                authApiCMS(username,password,listener);
                Log.e("TAG", "true" +type );
            }else {
                authApi(username,password, listener);
                Log.e("TAG", "false "+type);
            }

    }

    public void authApi(final String username, final String password,final OnLoginFinishedListener listener){
        Api apiService =
                ApiClient.getClient().create(Api.class);
            Login login = new Login();
            login.setClientSecret("2kqHC2808CSSXxqYWFrm2tIss0pJx361c0e7r6ba");
            login.setClientId(2);
            login.setUsername(username);
            login.setPassword(password);
            login.setGrantType("password");
            login.setScope("*");
            login.setIsWeb("true");


            Call<Login> call = apiService.Login(login);
            call.enqueue(new Callback<Login>() {
                @Override
                public void onResponse(Call<Login> call, final Response<Login> response) {
                    if(response.isSuccessful()){
                        final String token = response.body().getAccessToken();
                        final String refresh_token = response.body().getRefreshToken();

                        final TokenEntity tokenEntity = new TokenEntity(1,token, refresh_token);
                        final RmDatabase rmDatabase = RmDatabase.getDatabase(context);
                        AsyncTask.execute(new Runnable() {
                            @Override
                            public void run() {
                                Log.e(TAG, "COUNT____ "+ rmDatabase.rmDao().countToken());

                                int count = rmDatabase.rmDao().countToken();
                                if(count == 0){
                                    rmDatabase.rmDao().setToken(tokenEntity);
                                    listener.onSuccess();
                                }else
                                {
                                    rmDatabase.rmDao().update(token, 1);
                                    listener.onSuccess();

                                }
                            }
                        });
                    }
                    else {
                        JSONObject jsonObject = null;
                        try {
                                String error = response.errorBody().string();
                             jsonObject = new JSONObject(error);
                            String messageHeader = jsonObject.getString("error");
                            String messageBody =   jsonObject.getString("message");
                            listener.errorLogin(messageHeader,messageBody);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }






                }

                @Override
                public void onFailure(Call<Login> call, Throwable t) {
                    Log.e("TAG", "Error Message New"+ t.getMessage());
                    listener.onErrorMessage();
                }
            });

    }

    public void authApiCMS(final String username, final String password,final OnLoginFinishedListener listener){
        Api apiService =
                ApiClient.getClient().create(Api.class);
        LoginCms login = new LoginCms();
        login.setClientSecret("2kqHC2808CSSXxqYWFrm2tIss0pJx361c0e7r6ba");
        login.setClientId(2);
        login.setUsername(username);
        login.setPassword(password);
        login.setGrantType("password");
        login.setScope("*");


        Call<LoginCms> call = apiService.LoginCms(login);
        call.enqueue(new Callback<LoginCms>() {
            @Override
            public void onResponse(Call<LoginCms> call, final Response<LoginCms> response) {
                if(response.isSuccessful()){
                    final String token = response.body().getAccessToken();
                    final String refresh_token = response.body().getRefreshToken();

                    final TokenEntity tokenEntity = new TokenEntity(1,token, refresh_token);
                    final RmDatabase rmDatabase = RmDatabase.getDatabase(context);
                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            Log.e(TAG, "COUNT____ "+ rmDatabase.rmDao().countToken());

                            int count = rmDatabase.rmDao().countToken();
                            if(count == 0){
                                rmDatabase.rmDao().setToken(tokenEntity);
                                listener.onSuccess();
                            }else
                            {
                                rmDatabase.rmDao().update(token, 1);
                                listener.onSuccess();

                            }
                        }
                    });
                }
                else {
                    JSONObject jsonObject = null;
                    try {
                        String error = response.errorBody().string();
                        jsonObject = new JSONObject(error);
                        String messageHeader = jsonObject.getString("error");
                        String messageBody =   jsonObject.getString("message");
                        listener.errorLogin(messageHeader,messageBody);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }






            }

            @Override
            public void onFailure(Call<LoginCms> call, Throwable t) {
                Log.e("TAG", "Error Message New"+ t.getMessage());
                listener.onErrorMessage();
            }
        });

    }

}
