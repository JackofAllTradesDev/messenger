package com.xlog.blackboxmobile.Chat.SmallTalk;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.xlog.blackboxmobile.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class SmallTalk extends Fragment implements SmallTalkPresenter.View {

    ImageButton btnDown;
    ImageButton btnUp;
    View myView;
    SmallTalkPresenter smallTalkPresenter;


    public SmallTalk() {
        // Required empty public constructor
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_small_talk, container, false);
        btnDown = (ImageButton) view.findViewById(R.id.down_btn);
        btnUp = (ImageButton) view.findViewById(R.id.slideUpAnimation);
        myView   = (LinearLayout)view.findViewById(R.id.hideAndShowRecylerView);
        smallTalkPresenter = new SmallTalkPresenter(this, getContext());
        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideDown(myView);
            }
        });
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideUp(myView);
            }
        });
        return view;
    }

    public void slideUp(View view){
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

    public void slideDown(View view){
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                0,                 // fromYDelta
                view.getHeight()); // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }

}
