package com.xlog.blackboxmobile.Adapters.ChatAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;
import com.xlog.blackboxmobile.Model.TrasanctionsList.Member;
import com.xlog.blackboxmobile.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChatMembersAdapter extends RecyclerView.Adapter<ChatMembersAdapter.ViewHolder> {


    List<Member> memberList;

    public ChatMembersAdapter(List<Member> memberList) {
        this.memberList = memberList;
    }

    String urlDev = "https://xlog-dev.s3.amazonaws.com/";
    List<String> imagesList = new ArrayList<String>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.category_icon_chat, parent, false);
        return new ChatMembersAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Member member = memberList.get(position);
        holder.textViewTransactionId.setText(member.getRole());
        String imageList = member.getImage();
        String url = urlDev + imageList;
        Picasso.get()
                .load(url)
                .resize(600, 200)
                .centerInside()
                .into(holder.circularImageView);

    }

    @Override
    public int getItemCount() {
        return memberList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewTransactionId;
        public CircularImageView circularImageView;

        public ViewHolder(View itemView) {
            super(itemView);

            this.textViewTransactionId = (TextView) itemView.findViewById(R.id.accountType);
            this.circularImageView = (CircularImageView) itemView.findViewById(R.id.imageCircleViewHeadLogs);

        }
    }
}
