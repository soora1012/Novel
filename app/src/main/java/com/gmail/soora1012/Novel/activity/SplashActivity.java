package com.gmail.soora1012.Novel.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.gmail.soora1012.Novel.CustomDialog;
import com.gmail.soora1012.Novel.R;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class SplashActivity extends AppCompatActivity {
    private int PERMISSION_OK = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (android.os.Build.VERSION.SDK_INT >= 23) {
                 permissionCheck();
        }
    }

    private void permissionCheck() {
        if (ContextCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE} , PERMISSION_OK);
        }else {
            finish();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }

    @Override

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] permissionResult) {

        if (requestCode == 0) {
            if (permissionResult[0] == 0) {
                finish();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            } else {

               new CustomDialog(this).
                       OneDialog(getString(R.string.notice), getString(R.string.permission_check_no),
                               new CustomDialog.CustomOneDialogListener() {
                                   @Override
                                   public void onPositiveClicked() {
                                       finish();
                                   }
                               }

                       );
            }
        }
    }


}
