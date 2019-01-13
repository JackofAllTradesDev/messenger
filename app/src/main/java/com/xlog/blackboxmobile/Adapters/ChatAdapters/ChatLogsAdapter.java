package com.xlog.blackboxmobile.Adapters.ChatAdapters;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;
import com.xlog.blackboxmobile.Model.ChatLogs.Datum;
import com.xlog.blackboxmobile.Model.TrasanctionsList.Transaction;
import com.xlog.blackboxmobile.Model.TrasanctionsList.TransactionModel;
import com.xlog.blackboxmobile.R;
import com.xlog.blackboxmobile.Repository.Database.RmDatabase;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChatLogsAdapter extends RecyclerView.Adapter{


    public ChatLogsAdapter(List<Datum> dataList, List<TransactionModel> everyData) {
        this.dataList = dataList;
        this.everyData = everyData;
    }

    List<Datum> dataList;
    List<TransactionModel> everyData;
    private Context context;
    public static final int SENDER = 1;
    public static final int RECEIVER = 0;
    private String type;
    private static final String TAG = "ChatAllAdapter";



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == RECEIVER) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.incoming_message, parent, false);
            return new ViewHolder(view);
        }else if (viewType == SENDER){
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.my_message, parent, false);
            return new ViewHolderSent(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Datum datum = dataList.get(position);
        TransactionModel model = everyData.get(0);

        switch (holder.getItemViewType()) {
            case SENDER:
                ((ViewHolderSent) holder).bind(datum, model);
                break;
            case RECEIVER:
                ((ViewHolder) holder).bind(datum, model);
        }
    }



    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        int[] imageMediumType = {R.drawable.email_medium_type, R.drawable.message_medium_type, R.drawable.sms_icon_medium_type};
        private String urlDev = "https://xlog-dev.s3.amazonaws.com/";
        public TextView nameTxt;
        public TextView messageBody;
        public TextView timeDay;
        public TextView fullName;
        public TextView typeAccount;
        public ImageView mediumTypeIncoming;
        public CircularImageView circularImageView;

        public ViewHolder(View itemView) {
            super(itemView);

            this.typeAccount = (TextView) itemView.findViewById(R.id.type_account);
            this.fullName = (TextView) itemView.findViewById(R.id.name_incoming);
            this.nameTxt = (TextView) itemView.findViewById(R.id.name_logs);
            this.messageBody = (TextView) itemView.findViewById(R.id.message_body);
            this.timeDay = (TextView) itemView.findViewById(R.id.dateTimeTxt);
            this.mediumTypeIncoming = (ImageView) itemView.findViewById(R.id.medium_incoming);
            this.circularImageView = (CircularImageView) itemView.findViewById(R.id.imageCircleViewHeadLogs);


        }
        void bind(Datum message, TransactionModel model) {
            int size = model.getTransaction().getGroups().size();
            String fullname, first = null,last = null,type = null, image = null, companyName = null;
            for(int i = 0; i < size; i++){
                int gSize = model.getTransaction().getGroups().get(i).getMembers().size();
                for(int a = 0; a < gSize; a++){
                    image = model.getTransaction().getGroups().get(i).getMembers().get(a).getImage();
                    type = model.getTransaction().getGroups().get(i).getMembers().get(a).getAccountType();
                    first = model.getTransaction().getGroups().get(i).getMembers().get(a).getFirstName();
                    last = model.getTransaction().getGroups().get(i).getMembers().get(a).getLastName();
                    companyName = model.getTransaction().getGroups().get(i).getMembers().get(a).getCompanyName();
                }
            }
            fullname = first+" "+last;
            String url = urlDev + image;
            int medium = message.getMediumTypeId();
            fullName.setText(fullname);
            typeAccount.setText(type);
            timeDay.setText(message.getCreatedOn());
            nameTxt.setText(companyName);
            messageBody.setText(message.getMessage().getMessage());
            mediumTypeIncoming.setImageResource(imageMediumType[medium]);

            Picasso.get()
                    .load(url)
                    .resize(600, 200)
                    .centerInside()
                    .into(circularImageView);

        }
    }

    public static class ViewHolderSent extends RecyclerView.ViewHolder {
        int[] imageMediumType = {R.drawable.email_medium_type, R.drawable.message_medium_type, R.drawable.sms_icon_medium_type};
        public TextView nameSent;
        public TextView messageSent;
        public TextView timeDay;
        public TextView fullName;
        public TextView companyName;
        public TextView accountTypes;
        public ImageView mediumView;
        public CircularImageView circularImageViewSent;
        private String urlDev = "https://xlog-dev.s3.amazonaws.com/";
        public ViewHolderSent(View itemView) {
            super(itemView);


            this.nameSent = (TextView) itemView.findViewById(R.id.name_sent);
            this.messageSent = (TextView) itemView.findViewById(R.id.message_body_sent);
            this.timeDay = (TextView) itemView.findViewById(R.id.date_time_txt);
            this.mediumView = (ImageView) itemView.findViewById(R.id.medium_type_img);
            this.fullName = (TextView) itemView.findViewById(R.id.orignal_name);
            this.accountTypes = (TextView) itemView.findViewById(R.id.account_type);
            this.circularImageViewSent = (CircularImageView) itemView.findViewById(R.id.imageCircleViewHeadMyMessage);

        }
        void bind(Datum message, TransactionModel model) {
            String sampleURl = model.getImage();
            String companyNameData = model.getCompanyName();
            String accountT = model.getAccountType();
            String first = model.getFirstName();
            String last = model.getLastName();
            String fullname = first+" "+last;
            String url = urlDev + sampleURl;
            int mediumType = message.getMediumTypeId();
            Log.e("TAGGGGGG", "companyNameData "+ companyNameData);
            accountTypes.setText(accountT);
            fullName.setText(fullname);
            messageSent.setText(message.getMessage().getMessage());
            nameSent.setText(companyNameData);
            timeDay.setText(message.getCreatedOn());
            mediumView.setImageResource(imageMediumType[mediumType]);
            Picasso.get()
                    .load(url)
                    .resize(600, 200)
                    .centerInside()
                    .into(circularImageViewSent);

        }
    }



    public void getType(){
        final RmDatabase rmDatabase = RmDatabase.getDatabase(context);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {


                type = rmDatabase.rmDao().getUserDetails().get(0).getAccount_t();
                Log.e("TAGGGGGG", "account type  "+ type);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        Datum message = dataList.get(position);
        if (message.getAccountType().equals("shipper")) {
        return SENDER;
        }
        else {
            return RECEIVER;
        }


    }
}
