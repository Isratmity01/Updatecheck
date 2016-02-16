package com.example.isratjahan.myapplicationupdatecheck;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                UpdateApp atualizaApp = new UpdateApp();
                atualizaApp.setContext(getApplicationContext());
                atualizaApp.execute("http://www.kolorob.net/trial.apk");//change the address of the apk



                File sdCard = Environment.getExternalStorageDirectory();
                String fileStr = sdCard.getAbsolutePath() + "/Download";// + "app-release.apk";
                File file = new File(fileStr, "trial.apk");//change the name
                Intent promptInstall = new Intent(Intent.ACTION_VIEW).setDataAndType(Uri.fromFile(file),
                        "application/vnd.android.package-archive");

                startActivity(promptInstall);

            }
        });
    }
}