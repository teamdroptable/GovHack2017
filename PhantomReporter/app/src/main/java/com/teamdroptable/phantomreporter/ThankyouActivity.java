package com.teamdroptable.phantomreporter;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ThankyouActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);



        final Handler handler = new Handler();
        final ThankyouActivity currentObject = this;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                Intent intent = new Intent (currentObject, MainActivity.class);

                //do bundle stuff
                startActivity(intent);

            }
        }, 3000);
    }
}
