package com.teamdroptable.phantomreporter;

import android.*;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CallActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        Button emergencyBtn = (Button)findViewById((R.id.emergencybtn));
        Button policeReportBtn = (Button)findViewById((R.id.policeReportBtn));
        Button animalHurtBtn = (Button)findViewById((R.id.animalHurtBtn));
        Button ACTHealthBtn = (Button)findViewById((R.id.ACTHealthBtn));




        emergencyBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0424185593"));

                if (ActivityCompat.checkSelfPermission(CallActivity.this,
                        android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }

        });

        policeReportBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0424185593"));

                if (ActivityCompat.checkSelfPermission(CallActivity.this,
                        android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }

        });

        animalHurtBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0424185593"));

                if (ActivityCompat.checkSelfPermission(CallActivity.this,
                        android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }

        });

        ACTHealthBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);

                callIntent.setData(Uri.parse("tel:0424185593"));

                if (ActivityCompat.checkSelfPermission(CallActivity.this,
                        android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }

        });





    }
}
