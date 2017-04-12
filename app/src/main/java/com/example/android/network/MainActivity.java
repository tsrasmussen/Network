package com.example.android.network;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.name;
import static android.R.id.message;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Making the Email button intent
    public void emailbutton(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL  , new String[]{"tuerasmussen@GNS.com"});
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    //Making the Phone button intent
    int phoneNumber = 123456789;

    public void phonebutton(View view) {
        Intent phoneCall = new Intent(Intent.ACTION_DIAL);
        phoneCall.setData(Uri.parse("tel:" + phoneNumber));
        if (phoneCall.resolveActivity(getPackageManager()) != null) {
            startActivity(phoneCall);
        }
    }

    //Making the Web button intent
    public void webbutton(View v) {
        Uri uri = Uri.parse("https://www.google.com/");
        Intent websiteIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(websiteIntent);
    }
}







