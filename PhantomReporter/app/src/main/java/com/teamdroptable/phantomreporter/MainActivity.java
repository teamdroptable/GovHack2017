package com.teamdroptable.phantomreporter;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.ActivityCompat;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("HOOPGOD", "HATSS");


        setContentView(R.layout.activity_main);


        final Button policeButton = (Button) findViewById(R.id.bttnPolice);
        final MainActivity currentObject = this;

        policeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(currentObject, CallActivity.class);
                startActivity(intent);

            }
        });
    }






    public void reportClick(View view){
        Intent intent = new Intent (this, ReportActivity.class);
        startActivity(intent);
    }


    public void graphClick(View view){
        Intent intent = new Intent (this, GraphActivity.class);
        startActivity(intent);
    }


}





