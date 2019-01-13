package com.xlog.blackboxmobile.Chat.Origin;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.socket.client.Ack;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.xlog.blackboxmobile.Adapters.ChatAdapters.ChatLogsAdapter;
import com.xlog.blackboxmobile.Adapters.ChatAdapters.ChatMembersAdapter;
import com.xlog.blackboxmobile.Model.ChatLogs.ChatLogs;
import com.xlog.blackboxmobile.Model.ChatLogs.Datum;
import com.xlog.blackboxmobile.Model.ChatModel.Data;
import com.xlog.blackboxmobile.Model.TrasanctionsList.Group;
import com.xlog.blackboxmobile.Model.TrasanctionsList.Member;
import com.xlog.blackboxmobile.Model.TrasanctionsList.TransactionModel;
import com.xlog.blackboxmobile.Network.Socket.ChatApp;
import com.xlog.blackboxmobile.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatAll extends Fragment implements ChatAllPresenter.View {

    ProgressBar progressBar;
    RecyclerView recyclerView;
    RecyclerView recyclerViewLogs;
    RecyclerView.Adapter adapter;
    RecyclerView.Adapter adapter2;
    EditText messageBox;
    Toolbar toolbarAll;
    ImageButton sendMessage;
    private ChatAllPresenter chatAllPresenter;
    private ChatLogsAdapter chatLogsAdapter;
    ImageView image1, image2,image3;
    private Socket mSocket;
    private String mUsername ="JAAAY";
    private Boolean isConnected = true;
    private String roomName = "XLOG-1810000734-all";
    private static final String TAG = "ChatALL";
    JSONObject jsonObjectInherit;

    public ChatAll() {
        // Required empty public constructor
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat_all, container, false);
        progressBar =  view.findViewById(R.id.progressBarChatAll);
        toolbarAll =  view.findViewById(R.id.toolbar4);
        recyclerView =  view.findViewById(R.id.recyclerViewHeads);
        recyclerViewLogs =  view.findViewById(R.id.chatListRecyclerView);
        image1 =  view.findViewById(R.id.top_right_image);
        image2 =  view.findViewById(R.id.top_left_image);
        image3 =  view.findViewById(R.id.bottom_left_image);
        messageBox =  view.findViewById(R.id.edittext_chatbox);
        sendMessage =  view.findViewById(R.id.button_chatbox_send);
        toolbarAll.setTitle("XLOG-1810000734");
        toolbarAll.setSubtitle("Origin & Destination");
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getMessageString();
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chatAllPresenter = new ChatAllPresenter( this, getContext());
        chatAllPresenter.getToken();
        chatAllPresenter.getLogs();
        ChatApp chatApp = (ChatApp)getActivity().getApplication();
        mSocket = chatApp.getSocket();
        mSocket.on(Socket.EVENT_CONNECT,onConnect);
        mSocket.on("newMessage", onNewMessage);
        mSocket.emit("joinRoom" , roomName);
        mSocket.connect();


    }

    @Override
    public void addDatas(List<Member> datas) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ChatMembersAdapter(datas);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void imageData(List<String> images) {
        ImageView[] IMGS = { image1, image2, image3 };

        for(int b = 0; b < IMGS.length; b++){
            Picasso.get()
                    .load(images.get(b))
                    .resize(600, 200)
                    .centerInside()
                    .into(IMGS[b]);
        }
    }

    @Override
    public void addLogs(List<Datum> data, List<TransactionModel> every) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//                layoutManager.setReverseLayout(true);
                recyclerViewLogs.setLayoutManager(layoutManager);
                chatLogsAdapter = new ChatLogsAdapter(data, every);
                recyclerViewLogs.setAdapter(chatLogsAdapter);
                chatLogsAdapter.notifyItemInserted(data.size());
                scrollToBottom();
    }
    private void scrollToBottom() {
        recyclerViewLogs.scrollToPosition(chatLogsAdapter.getItemCount() - 1);
    }


    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void getMessageString() {
        String message = messageBox.getText().toString().trim();
        if (TextUtils.isEmpty(message)) {
            return;
        }
        messageBox.setText("");
        chatAllPresenter.getString(message);

    }

    @Override
    public void sendObject(JSONObject jsonObject) {
        mSocket.emit("messageRoom" , jsonObject);
    }

    private Emitter.Listener onConnect = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(mSocket.connected()){
                        Log.e("TAGGGGGG", "CONNECTED_____ ");
                    }
                }
            });
        }
    };
    private Emitter.Listener onNewMessage = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject)args[0];
                    chatAllPresenter.receive(data);
                }
            });
        }
    };



}
