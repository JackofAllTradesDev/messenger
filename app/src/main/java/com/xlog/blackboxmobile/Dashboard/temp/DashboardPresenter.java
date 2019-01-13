package com.xlog.blackboxmobile.Dashboard.temp;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import com.xlog.blackboxmobile.Model.Account.AccountModel;
import com.xlog.blackboxmobile.Model.TrasanctionsList.TransactionModel;
import com.xlog.blackboxmobile.Network.Api;
import com.xlog.blackboxmobile.Network.ApiClient;
import com.xlog.blackboxmobile.Repository.Database.RmDatabase;
import com.xlog.blackboxmobile.Repository.Entity.TokenEntity;
import com.xlog.blackboxmobile.Repository.Entity.UserDetailsEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * THIS ACTIVITY IS NOT USED SINCE THE PROJECT INTEGRATED NEW DESIGN
 */
public class DashboardPresenter {
    public DashboardPresenter(View view, Context context) {
        this.view = view;
        this.context = context;
    }

    private View view;
    private Context context;
    private static final String TAG = "Dashboard";
    String urlDev = "https://xlog-dev.s3.amazonaws.com/";

    public void getToken(){
        final RmDatabase rmDatabase = RmDatabase.getDatabase(context);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                String token_access = rmDatabase.rmDao().getToken().get(0).getAccess_token();
                Log.e(TAG, "token_access__ "+token_access);
                getApiMe(token_access);

            }
        });

    }
    public void getApiMe(final String token_access){
        String token = "Bearer "+token_access;

        Api apiService =
                ApiClient.getClient().create(Api.class);

        Call<AccountModel> call = apiService.getDetails(token);
        call.enqueue(new Callback<AccountModel>() {
            @Override
            public void onResponse(Call<AccountModel> call, Response<AccountModel> response) {
                if(response.isSuccessful()){
                    String[] account_types = {"shipper","customs_broker","warehouse","trucker"};
                    String type = null;
                    String profile = response.body().getEntity().getImage();
                    String first = response.body().getEntity().getFirstName();
                    String last = response.body().getEntity().getLastName();
                    int userID = response.body().getId();
                    int account_id = response.body().getEntity().getId();
                    int account_type = response.body().getAccountType();
                    if(account_type == 1){
                      type = account_types[0];

                    }
                    if(account_type == 2){
                        type = account_types[1];

                    }
                    if(account_type == 3){
                        type = account_types[2];

                    }
                    if(account_type == 4){
                        type = account_types[3];

                    }
                    String devURL= urlDev+profile;
                    view.showPicture(devURL);

                    final UserDetailsEntity userDetailsEntity = new UserDetailsEntity(0,Integer.toString(userID), Integer.toString(account_id),profile,first,last,type);
                    final RmDatabase rmDatabase = RmDatabase.getDatabase(context);
                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            int size = rmDatabase.rmDao().countUser();
                            if(size == 1){
                                rmDatabase.rmDao().deleteAllUsers();
                            }

                                rmDatabase.rmDao().setUser(userDetailsEntity);
                                Log.e(TAG, "TYPE____ "+rmDatabase.rmDao().getUserDetails().get(0).getAccount_t());
                        }
                    });
                }else{

                }
            }

            @Override
            public void onFailure(Call<AccountModel> call, Throwable t) {

            }
        });

    }

    public interface View{
       void showPicture(String url);

    }


}
