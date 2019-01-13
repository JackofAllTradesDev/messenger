package com.xlog.blackboxmobile.TypeAccount;

import android.content.Context;
import android.util.Log;
import android.view.View;

public class UserTypePresenter {
    private View view;
    private Context context;

    public UserTypePresenter(View view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void setUserType(Boolean bool){
        view.startActivity(bool);
        Log.e("TAG", "RETURN "+bool);


    }


    public interface View{
        void startActivity(Boolean type);

    }
}
