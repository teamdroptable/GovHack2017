package com.teamdroptable.phantomreporter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);


        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        final Button btnAlpha = (Button)findViewById(R.id.angry_btn);

        final ReportActivity currentObject = this;
        btnAlpha.setOnClickListener(new Button.OnClickListener(){


            @Override
            public void onClick(View arg0) {
                arg0.startAnimation(animAlpha);
                btnAlpha.setText("Processing...");


                Intent intent = new Intent (currentObject, ThankyouActivity.class);

                //do bundle stuff
                startActivity(intent);
            }});

    }


}

