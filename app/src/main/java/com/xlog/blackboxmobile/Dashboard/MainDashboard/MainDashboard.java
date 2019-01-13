package com.xlog.blackboxmobile.Dashboard.MainDashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;
import com.xlog.blackboxmobile.Adapters.ChatListAdapter.MainDashboardAdapter;
import com.xlog.blackboxmobile.Model.ChatList.Datum;
import com.xlog.blackboxmobile.Model.TrasanctionsList.TransactionModel;
import com.xlog.blackboxmobile.R;

import java.util.List;

public class MainDashboard extends AppCompatActivity implements MainDashboarPresenter.View {

    private CircularImageView imageCircleView;
    MainDashboarPresenter mainDashboarPresenter;
    ProgressBar progressBar;
    RecyclerView recyclerViewDash;
    RecyclerView.Adapter adapter;
    TextView fullnameDash, typeDash;
    Toolbar toolbar;
    ImageButton downSlide,slideHide;
    View myView;
    Boolean yourBool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);
        imageCircleView = (CircularImageView)findViewById(R.id.imageCircleViewHeadLogs);
        toolbar = (Toolbar) findViewById(R.id.dashboardToolbar);
        progressBar = (ProgressBar)findViewById(R.id.progressBarDashboard);
        recyclerViewDash = (RecyclerView)findViewById(R.id.recyclerViewDash);
        fullnameDash = (TextView)findViewById(R.id.fullnameDash);
        typeDash = (TextView)findViewById(R.id.accountTypeDashboard);
        myView = (LinearLayout)findViewById(R.id.slidingLayout);
        downSlide = (ImageButton) findViewById(R.id.downSearch);
        slideHide = (ImageButton) findViewById(R.id.slideHide);
        yourBool = getIntent().getExtras().getBoolean("EXTRA_MAIN_RESULT");
        Log.e("TAG", "bool "+yourBool);
        mainDashboarPresenter = new MainDashboarPresenter(this, getApplicationContext());
        mainDashboarPresenter.getToken(yourBool);

        downSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideUp(myView);
                downSlide.setVisibility(View.INVISIBLE);

            }
        });
        slideHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideUpLayout(myView);
            }
        });
    }


    @Override
    public void showImage(String url) {
        Picasso.get()
                .load(url)
                .resize(600, 200)
                .centerInside()
                .into(imageCircleView);
    }

    @Override
    public void details(String fullname, String type) {
        fullnameDash.setText(fullname);
        typeDash.setText(type);
    }

    @Override
    public void addDatas(List<TransactionModel> datas, List<Datum> chatData) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewDash.setLayoutManager(layoutManager);
        adapter = new MainDashboardAdapter(datas, chatData);
        recyclerViewDash.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }



    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    public void slideUp(View view){
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                0,                 // fromYDelta
                view.getHeight()); // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }

    public void slideUpLayout(View view){
        view.setVisibility(View.VISIBLE);
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                view.getHeight(),  // fromYDelta
                0);                // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }
}
