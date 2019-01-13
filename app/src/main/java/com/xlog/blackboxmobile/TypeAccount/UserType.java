package com.xlog.blackboxmobile.TypeAccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xlog.blackboxmobile.Dashboard.MainDashboard.MainDashboard;
import com.xlog.blackboxmobile.Login.MainActivity;
import com.xlog.blackboxmobile.R;

public class UserType extends AppCompatActivity implements UserTypePresenter.View {
    UserTypePresenter userTypePresenter;
    private Button yesbtn,no;
    Boolean shippingLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userTypePresenter = new UserTypePresenter(this,getApplicationContext());
        setContentView(R.layout.activity_user_type);

        yesbtn = (Button) findViewById(R.id.yesbtnUser);
        no = (Button) findViewById(R.id.noBtn);

        yesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTypePresenter.setUserType(true);
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTypePresenter.setUserType(false);
            }
        });


    }


    @Override
    public void startActivity(Boolean type) {
        shippingLine = type;
        Intent intent = new Intent(UserType.this, MainActivity.class);
        intent.putExtra("EXTRA_BOOLEAN_RESULT", shippingLine);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
