package com.xlog.blackboxmobile.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.xlog.blackboxmobile.Dashboard.MainDashboard.MainDashboard;
import com.xlog.blackboxmobile.R;
import com.xlog.blackboxmobile.TypeAccount.UserType;

/**
 * Created by Jay on 12/03/2018.
 */
public class MainActivity extends AppCompatActivity implements LoginView {

    private EditText email;
    private EditText pass;
    private Button login;
    private LoginPresenter loginPresenter;
    private ProgressBar progressBar;
    private ProgressDialog dialog;
    Boolean yourBool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar2);
        email = (EditText)findViewById(R.id.emailTxt);
        pass = (EditText)findViewById(R.id.password);
        login = (Button) findViewById(R.id.loginBtn);
        loginPresenter = new LoginPresenter(this, new LoginInteractor(this));
         yourBool = getIntent().getExtras().getBoolean("EXTRA_BOOLEAN_RESULT");
        dialog = new ProgressDialog(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateLogin();
            }
        });

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        login.setEnabled(false);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        login.setEnabled(true);
    }

    @Override
    public void setErrorMessage() {
        Toast.makeText(this, "Please Input Empty Fields",
                Toast.LENGTH_LONG).show();
    }

    public void navigateToDashboard(){
        Intent intent = new Intent(MainActivity.this, MainDashboard.class);
        intent.putExtra("EXTRA_MAIN_RESULT", yourBool);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void showError(String Message, String MessageBody) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setTitle(Message);
        builder1.setMessage(MessageBody);

        builder1.setPositiveButton(
                "OKAY",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }



    private void validateLogin(){
        loginPresenter.validateCredentials(email.getText().toString(), pass.getText().toString(), yourBool);
    }



}
