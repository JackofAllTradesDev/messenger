package com.xlog.blackboxmobile.Dashboard.MainDashboard;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

import com.xlog.blackboxmobile.Model.Account.AccountModel;
import com.xlog.blackboxmobile.Model.Account.Cms.ChatModelCms;
import com.xlog.blackboxmobile.Model.ChatList.ChatList;
import com.xlog.blackboxmobile.Model.ChatList.Datum;
import com.xlog.blackboxmobile.Model.TrasanctionsList.TransactionModel;
import com.xlog.blackboxmobile.Network.Api;
import com.xlog.blackboxmobile.Network.ApiClient;
import com.xlog.blackboxmobile.Network.ApiClientInternal;
import com.xlog.blackboxmobile.Repository.Database.RmDatabase;
import com.xlog.blackboxmobile.Repository.Entity.UserDetailsEntity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainDashboarPresenter {


    public MainDashboarPresenter(View view, Context context) {
        this.view = view;
        this.context = context;
    }

    private View view;
    private Context context;
    List<Datum> chatLists;
    List<TransactionModel> transactionList;
    private static final String TAG = "Dashboard";
    String urlDev = "https://xlog-dev.s3.amazonaws.com/";




    public void getToken(final Boolean account){
        final RmDatabase rmDatabase = RmDatabase.getDatabase(context);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                String token_access = rmDatabase.rmDao().getToken().get(0).getAccess_token();
                Log.e(TAG, "token_access__ "+token_access);
                if(account == true){
                    getApiMeCms(token_access);
                }else{
                    getApiMe(token_access);
                }


            }
        });

    }
    private void getApiMeCms(final String token){
        final String token_acces = "Bearer "+token;
        Api apiService =
                ApiClient.getClient().create(Api.class);

        Call<ChatModelCms> call = apiService.getDetailsCms(token_acces);

        call.enqueue(new Callback<ChatModelCms>() {
            @Override
            public void onResponse(Call<ChatModelCms> call, Response<ChatModelCms> response) {
                if(response.isSuccessful()) {
                    int id = response.body().getId();
                    final int account_id = response.body().getCmsProfile().getShippingAgencyId();
                    String image = "https://indigenoustourism.ca/corporate/wp-content/uploads/2017/05/no-profile.jpg";
                    String first = response.body().getCmsProfile().getFirstName();
                    String last = response.body().getCmsProfile().getLastName();
                    final int account_type = 0;
                    final String type = "shipping_agency";

                    String full = first+" "+ last;
                    String devURL= urlDev+image;
                    view.showImage(image);
                    view.details(full, type);
                    final UserDetailsEntity userDetailsEntity = new UserDetailsEntity(0,Integer.toString(id), Integer.toString(account_id),image,first,last,type);
                    final RmDatabase rmDatabase = RmDatabase.getDatabase(context);
                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            int size = rmDatabase.rmDao().countUser();
                            if(size == 1){
                                rmDatabase.rmDao().deleteAllUsers();
                            }

                            rmDatabase.rmDao().setUser(userDetailsEntity);
                            Log.e(TAG, "TYPE____ "+rmDatabase.rmDao().getUserDetails().get(0).getAccountid());
//                            String account = rmDatabase.rmDao().getUserDetails().get(0).getAccount_t();
//                            getApiTr(token_acces,account_id,account_type , type);

                        }
                    });

                }else{

                }

            }

            @Override
            public void onFailure(Call<ChatModelCms> call, Throwable t) {

            }
        });
    }


    private void getApiMe(final String token_access){
        final String token = "Bearer "+token_access;

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
                    final String first = response.body().getEntity().getFirstName();
                    final String last = response.body().getEntity().getLastName();
                    int userID = response.body().getId();
                    final int account_id = response.body().getEntity().getId();
                    final int account_type = response.body().getAccountType();
                    String full = first+" "+ last;
                    String devURL= urlDev+profile;
                    view.showImage(devURL);
                    if(account_type == 1){
                        type = account_types[0];

                    }
                    else if(account_type == 2){
                        type = account_types[1];

                    }
                    else if(account_type == 3){
                        type = account_types[2];

                    }
                    else if(account_type == 4){
                        type = account_types[3];

                    }

                    view.details(full, type);

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
                            Log.e(TAG, "TYPE____ "+rmDatabase.rmDao().getUserDetails().get(0).getAccountid());
                            String account = rmDatabase.rmDao().getUserDetails().get(0).getAccount_t();
//                            getApiTr(token,account_id,account_type, account);
                            getChatList(account_id, account,token, account_type);
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

    private void getApiTr(final String token_access,final String transaction_type,final String prefixID){
        final String token = token_access;
        Api apiService =
                ApiClient.getClient().create(Api.class);

        Call<List<TransactionModel>> call = apiService.getTransactions(token, transaction_type);

        call.enqueue(new Callback<List<TransactionModel>>() {
            @Override
            public void onResponse(Call<List<TransactionModel>> call, Response<List<TransactionModel>> response) {
                if (response.isSuccessful()) {
                    int tr_size = response.body().size();
                    for(int a = 0; a < tr_size; a++) {
                        Log.e(TAG, "SUCCESS SP "+ a);
//                        String linkID = response.body().get(a).getTransaction().getLinkPrefixedId();
//                        if(prefixID.equals(linkID)){
//                            transactionList = new ArrayList<>();
//                            transactionList = response.body();
//                            view.addDatas(transactionList, chatLists);
//                            view.hideProgressBar();
//                        }



                    }
                }else{
                    Log.e(TAG, "FAILED  SP ");
                }



            }

            @Override
            public void onFailure(Call<List<TransactionModel>> call, Throwable t) {
                Log.e(TAG, "FAILURE_____ SP "+t.getLocalizedMessage());
            }
        });
    }

    public void getChatList(int account_id, String account_type, final String token, final int typeAcc){
        String[] trasaction_type = {"all","customs_broker_reservation","warehouse_reservation","trucking_reservation","shipping_reservation"};
        String accountType = null;
        String type = account_type;
        final String token_access = token;
        int aID = account_id;
        int page = 1;
        int limit = 10;
        if(typeAcc == 1){
            accountType = trasaction_type[0];

        }
        else if(typeAcc == 2){
            accountType = trasaction_type[1];

        }
        else if(typeAcc == 3){
            accountType = trasaction_type[2];

        }
        else if(typeAcc == 4){
            accountType = trasaction_type[3];

        }else if(typeAcc == 0){
            accountType = trasaction_type[4];
        }

        Log.e(TAG, "id, type " + aID + type);


        Api apiService =
                ApiClientInternal.getClient().create(Api.class);
        Call<ChatList> call = apiService.getChatLists(page, limit,aID,type);
        final String finalAccountType = accountType;
        call.enqueue(new Callback<ChatList>() {
            @Override
            public void onResponse(Call<ChatList> call, Response<ChatList> response) {
                if(response.isSuccessful()){
                    Log.e(TAG, "SUCCESS  INTERNAL ");
                    chatLists = new ArrayList<>();
                    chatLists = response.body().getData();
                    int rSize = response.body().getData().size();
                    for(int a = 0; a <rSize; a++){
                        String prefix = response.body().getData().get(a).getTransactionId().replace("-all", "");
                        Log.e(TAG, "tr, prefix " + finalAccountType + prefix);
                        getApiTr(token_access, finalAccountType, prefix);
                    }





                }else{
                    Log.e(TAG, "FAILED  INTERNAL ");
                }
            }

            @Override
            public void onFailure(Call<ChatList> call, Throwable t) {
                Log.e(TAG, "Failure from chat list "+t.getLocalizedMessage());
            }
        });
    }




    public interface View{
        void showImage(String url);
        void details(String fullname, String type);
        void addDatas(List<TransactionModel> datas, List<Datum> chatData);
        void showProgressBar();
        void hideProgressBar();

    }
}
