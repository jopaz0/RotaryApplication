package com.rotary.rotaryapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AboutAuthorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about_author);

        // Listeners para el primer weon
        TextView buttonEmail1 = findViewById(R.id.about_me_mail_1);
        buttonEmail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = getString(R.string.about_me_mail_1);
                sendEmail(mail);
            }
        });
        TextView buttonTel1 = findViewById(R.id.about_me_tel_1);
        buttonTel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = getString(R.string.about_me_telephone_1);
                sendEmail(phone);
            }
        });

        // Listeners para la weona
        TextView buttonEmail2 = findViewById(R.id.about_me_mail_2);
        buttonEmail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = getString(R.string.about_me_mail_2);
                sendEmail(mail);
            }
        });
        TextView buttonTel2 = findViewById(R.id.about_me_tel_2);
        buttonTel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = getString(R.string.about_me_telephone_2);
                sendEmail(phone);
            }
        });

        // Listeners para el otro weon
        TextView buttonEmail3 = findViewById(R.id.about_me_mail_3);
        buttonEmail3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = getString(R.string.about_me_mail_3);
                sendEmail(mail);
            }
        });
        TextView buttonTel3 = findViewById(R.id.about_me_tel_3);
        buttonTel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = getString(R.string.about_me_telephone_3);
                sendEmail(phone);
            }
        });
    }
    private void sendEmail(String email) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:" + email));
        startActivity(emailIntent);
    }

    private void makePhoneCall(String phoneNumber) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(callIntent);
    }
}
