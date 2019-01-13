package com.xlog.blackboxmobile.Chat;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xlog.blackboxmobile.Chat.Origin.ChatAll;
import com.xlog.blackboxmobile.R;
import com.xlog.blackboxmobile.Chat.SmallTalk.SmallTalk;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

public class ChatActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        final FragmentManager fragmentManager = getSupportFragmentManager();

        final Fragment fragment1 = new ChatAll();
        final Fragment fragment2 = new SmallTalk();
//        final Fragment fragment3 = new ThirdFragment();

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.smallTalk:
                    FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                    fragmentTransaction1.replace(R.id.container_chat, fragment2).commit();
                    return true;
                case R.id.all_title:
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container_chat, fragment1).commit();
                    return true;
                case R.id.origin_title:

                    return true;
                case R.id.destination_title:
                    return true;
            }
            return true;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        navigation.getMenu().getItem(1).setChecked(true);
        mOnNavigationItemSelectedListener.onNavigationItemSelected(navigation.getMenu().getItem(1));
    }

}
