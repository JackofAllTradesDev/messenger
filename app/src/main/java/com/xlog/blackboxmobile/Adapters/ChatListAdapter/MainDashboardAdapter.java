package com.xlog.blackboxmobile.Adapters.ChatListAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xlog.blackboxmobile.Model.ChatList.Datum;
import com.xlog.blackboxmobile.Model.TrasanctionsList.TransactionModel;
import com.xlog.blackboxmobile.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MainDashboardAdapter extends RecyclerView.Adapter<MainDashboardAdapter.ViewHolder> {

    public MainDashboardAdapter(List<TransactionModel> transactionModels, List<Datum> chatLists) {
        this.transactionModels = transactionModels;
        this.chatLists = chatLists;
    }

    List<TransactionModel> transactionModels;
    List<Datum> chatLists;
    String urlDev = "https://xlog-dev.s3.amazonaws.com/";
    List<String> imagesList = new ArrayList<String>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.transaction_list_layout, parent, false);
        return new MainDashboardAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String memberImagesOrigin = null;
        int[] imageMediumType = {R.drawable.email_medium_type, R.drawable.message_medium_type, R.drawable.sms_icon_medium_type};
        ImageView[] IMGS = { holder.image1, holder.image2, holder.image3 };
        Datum chatList = chatLists.get(position);
        String transactionID = chatList.getTransactionId().replace("-all", "");
        holder.textViewTransactionId.setText(transactionID);
        holder.dateTextView.setText(chatList.getRecentChat().getCreatedOn());
        holder.messageBodyTxt.setText(chatList.getRecentChat().getMessage().getMessage());





                int members = transactionModels.get(0).getTransaction().getGroups().get(0).getMembers().size();
                for(int b = 0; b < members; b++){
                    memberImagesOrigin = transactionModels.get(0).getTransaction().getGroups().get(0).getMembers().get(b).getImage();
                    String imageUrl = urlDev + memberImagesOrigin;
                    imagesList.add(imageUrl);
                    Log.e("TAG", "IMAGES  "+imageUrl);
                }
//        for(int b = 0; b < IMGS.length; b++){
//            Picasso.get()
//                    .load(imagesList.get(b))
//                    .resize(600, 200)
//                    .centerInside()
//                    .into(IMGS[b]);
//        }

    }

    @Override
    public int getItemCount() {
        return chatLists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewTransactionId,unread, messageBodyTxt,dateTextView, attachmentTxt;
        public ImageView image1,image2,image3, mediumImage;

        CardView cv;

        public ViewHolder(View itemView) {
            super(itemView);

            this.unread = (TextView) itemView.findViewById(R.id.unreadTxt);
            this.messageBodyTxt = (TextView) itemView.findViewById(R.id.messageTxt);
            this.dateTextView = (TextView) itemView.findViewById(R.id.dateTxt);
            this.attachmentTxt = (TextView) itemView.findViewById(R.id.attachmentsTxt);
            this.textViewTransactionId = (TextView) itemView.findViewById(R.id.tr_number);
            this.image1 = (ImageView) itemView.findViewById(R.id.top_left_image);
            this.image2 = (ImageView) itemView.findViewById(R.id.top_right_image);
            this.image3 = (ImageView) itemView.findViewById(R.id.bottom_left_image);
            this.mediumImage = (ImageView) itemView.findViewById(R.id.mediumTypeImage);
            this.cv = (CardView) itemView.findViewById(R.id.cvAll);

        }
    }
}
