package com.xlog.blackboxmobile.Chat.Origin;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

import com.xlog.blackboxmobile.Model.ChatLogs.ChatLogs;
import com.xlog.blackboxmobile.Model.ChatLogs.Datum;
import com.xlog.blackboxmobile.Model.ChatLogs.MessageLogs;
import com.xlog.blackboxmobile.Model.ChatModel.ChatModel;
import com.xlog.blackboxmobile.Model.ChatModel.Data;
import com.xlog.blackboxmobile.Model.ChatModel.MessageNew;
import com.xlog.blackboxmobile.Model.MessageModel.Message;
import com.xlog.blackboxmobile.Model.MessageModel.MessagingModel;
import com.xlog.blackboxmobile.Model.MessageModel.Recipient;
import com.xlog.blackboxmobile.Model.TrasanctionsList.Member;
import com.xlog.blackboxmobile.Model.TrasanctionsList.TransactionModel;
import com.xlog.blackboxmobile.Network.Api;
import com.xlog.blackboxmobile.Network.ApiClient;
import com.xlog.blackboxmobile.Network.ApiClientInternal;
import com.xlog.blackboxmobile.Repository.Database.RmDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatAllPresenter {
    public ChatAllPresenter(View view, Context context) {
        this.view = view;
        this.context = context;
    }

    private View view;
    private Context context;
    private static final String TAG = "ChatAllPresenter";
    List<Member> transactionList;
    List<TransactionModel> everthing;
    List<Datum> datumList = new ArrayList<>();
    List<Recipient> recipients;
    List<String> imagesList;
    List<JSONObject> rp = new ArrayList<>();
    MessagingModel model;
    Message message;
    Recipient recipient;
    String userID, accountID,image,first,last,accout_type;
    private String roomName = "XLOG-1810000734-all";
    String urlDev = "https://xlog-dev.s3.amazonaws.com/";
    private String transactionID = "XLOG-1810000734";

    public void getToken(){
        final RmDatabase rmDatabase = RmDatabase.getDatabase(context);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                String token_access = rmDatabase.rmDao().getToken().get(0).getAccess_token();
                Log.e(TAG, "token_access__ "+token_access);
                userID = rmDatabase.rmDao().getUserDetails().get(0).getUser_id();
                accountID = rmDatabase.rmDao().getUserDetails().get(0).getAccountid();
                image = rmDatabase.rmDao().getUserDetails().get(0).getImage_id();
                first = rmDatabase.rmDao().getUserDetails().get(0).getFirst_name();
                last = rmDatabase.rmDao().getUserDetails().get(0).getLast_name();
                accout_type = rmDatabase.rmDao().getUserDetails().get(0).getAccount_t();
                getApiMe(token_access);
                setDataToMessageModel(userID,accountID,image,first,last,accout_type);


            }
        });

    }

    private void setDataToMessageModel(String userID,String accountID,String image,String first,String last,String accout_type ){
        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss");
        Date todayDate = new Date();
        model = new MessagingModel();
        model.setRoom(roomName);
        model.setUserId(Integer.parseInt(userID));
        model.setImage(image);
        model.setDate(currentDate.format(todayDate));
        model.setFirstName(first);
        model.setLastName(last);
        model.setAccountType(accout_type);
        model.setAccountId(Integer.parseInt(accountID));
        model.setTransactionId(transactionID);



    }

    public void getApiMe(final String token_access) {
        String token = "Bearer " + token_access;
        String type_account = "all";
        String transaction_num = "XLOG-1810000734";


        Api apiService =
                ApiClient.getClient().create(Api.class);

        Call<List<TransactionModel>> call = apiService.getPerTransactions(token, type_account, transaction_num);

        call.enqueue(new Callback<List<TransactionModel>>() {
            @Override
            public void onResponse(Call<List<TransactionModel>> call, Response<List<TransactionModel>> response) {
                if (response.isSuccessful()) { ;
                    imagesList = new ArrayList<>();
                    recipients = new ArrayList<>();
                    everthing = new ArrayList<>();
                    transactionList = response.body().get(0).getTransaction().getGroups().get(0).getMembers();
                    view.addDatas(transactionList);
                    view.hideProgressBar();
                    int imageSize = response.body().get(0).getTransaction().getGroups().size();
                    for(int a = 0; a < imageSize; a++){
                        transactionList = new ArrayList<>();
                        int imageSizes = response.body().get(0).getTransaction().getGroups().get(a).getMembers().size();
                        for(int i = 0; i < imageSizes; i++) {

                            String images = response.body().get(0).getTransaction().getGroups().get(a).getMembers().get(i).getImage();
                            String imagesUrl = urlDev + images;
                            String type = response.body().get(0).getTransaction().getGroups().get(a).getMembers().get(i).getAccountType();
                            String email = response.body().get(0).getTransaction().getGroups().get(a).getMembers().get(i).getEmailAddress();
                            String mobileNumber = response.body().get(0).getTransaction().getGroups().get(a).getMembers().get(i).getMobileNumber();
                            String companyName = response.body().get(0).getTransaction().getGroups().get(a).getMembers().get(i).getCompanyName();
                            int account_id = response.body().get(0).getTransaction().getGroups().get(a).getMembers().get(i).getAccountId();
                            imagesList.add(imagesUrl);
                             recipient = new Recipient();
                            recipient.setAccountId(account_id);
                            recipient.setAccountType(type);
                            recipient.setEmail(email);
                            recipient.setMobileNumber(mobileNumber);
                            recipient.setCompanyName(companyName);
                            recipients.add(recipient);
                        }
                    }
                    everthing = response.body();
                    model.setRecipients(recipients);
                    view.imageData(imagesList);
                    view.addLogs(datumList, everthing);
                }else{
                    Log.e(TAG, "Not successfull_____ ");
                }
            }

            @Override
            public void onFailure(Call<List<TransactionModel>> call, Throwable t) {
                Log.e(TAG, "Failure_____ "+t.getMessage());
            }
        });

    }



    public void getString(String messages){
        rp.clear();
        Log.e(TAG, "MESSAGE  "+ messages);
        message = new Message();
        message.setMessage(messages);
        model.setMessage(message);
        JSONObject obj = new JSONObject();
        JSONObject objMessage = new JSONObject();
        try {
            int s = model.getRecipients().size();
            for(int i = 0; i < s; i++){
                JSONObject objRecipient = new JSONObject();
                objRecipient.putOpt("accountId", recipients.get(i).getAccountId());
                objRecipient.putOpt("accountType",   recipients.get(i).getAccountType());
                objRecipient.putOpt("email",   recipients.get(i).getEmail());
                objRecipient.putOpt("mobileNumber",   recipients.get(i).getMobileNumber());
                objRecipient.putOpt("companyName",   recipients.get(i).getCompanyName());
                rp.add(objRecipient);
            }
            objMessage.putOpt("message", model.getMessage().getMessage());
            //////
            obj.putOpt("userId", model.getUserId());
            obj.putOpt("accountId", model.getAccountId());
            obj.putOpt("accountType", model.getAccountType());
            obj.putOpt("transactionId", model.getTransactionId());
            obj.putOpt("message", objMessage);
            obj.putOpt("attachments", new JSONArray());
            obj.putOpt("recipients", new JSONArray(rp));
            obj.putOpt("room", model.getRoom());
//            Log.e(TAG, "JSON OBJECT  "+ obj);
            view.sendObject(obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }




    }

    public void receive(JSONObject jsonReceive){
        JSONObject received = jsonReceive;
        String messageObject = null;
        Integer mediumType = null;
        Integer accountId = null;
        String createdDate = null;
        String accountType = null;
        List<Object> attach = new ArrayList<>();
        MessageLogs messageReceived = null;

        try {
            messageObject = received.getJSONObject("message").getString("message");
            mediumType = received.getInt("mediumTypeId");
            createdDate = received.getString("createdOn");
            accountType = received.getString("accountType");
            accountId = received.getInt("accountId");
            messageReceived = new MessageLogs();
            messageReceived.setMessage(messageObject);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Datum data = new Datum(createdDate, messageReceived ,accountId, accountType, mediumType);
        datumList.add(data);
        view.addLogs(datumList, everthing);
    }

    public void getLogs(){
        int page = 1;
        int limit = 30;
        int account_id = 132;
        String room = "XLOG-1810000734-all";
        String account_type = accout_type;

        Api apiService =
                ApiClientInternal.getClient().create(Api.class);

        Call<ChatLogs> call = apiService.getChatLogs(page, limit, account_id, account_type, room);

        call.enqueue(new Callback<ChatLogs>() {
            @Override
            public void onResponse(Call<ChatLogs> call, Response<ChatLogs> response) {
                if(response.isSuccessful()){
                    datumList = response.body().getData();



                }else{
                    try {
                        Log.e(TAG, " FAILUREEEEE  "+response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ChatLogs> call, Throwable t) {
                Log.e(TAG, "Failure_____Chat_logs  "+ t.getMessage());
            }
        });

    }




    public interface View{
        void addDatas(List<Member> datas);
        void imageData(List<String> images);
        void addLogs(List<Datum> data, List<TransactionModel> every);
        void showProgressBar();
        void hideProgressBar();
        void getMessageString();
        void sendObject(JSONObject jsonObject);

    }
}
