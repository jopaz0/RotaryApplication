package com.rotary.rotaryapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void login(View view) {
        EditText edtxUsername = findViewById(R.id.login_edtx_username);
        EditText edtxPassword = findViewById(R.id.login_edtx_password);
        String username = edtxUsername.getText().toString();
        String password = edtxPassword.getText().toString();
        if(ValidateCredentials(username, password)){
            Intent intent = new Intent(this, MenuActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        }
        else {
            edtxUsername.setError("Usuario o contraseña incorrectos");
            edtxPassword.setError("Usuario o contraseña incorrectos");
        }
    }
    private boolean ValidateCredentials(String username, String password) {
        //aca deberia acceder a la base de datos o lo que pinte. algun dia xd
        if (username.equals("alumno") && password.equals("1234")) {
            return true;
        }
        return false;
    }

    public void ChangeLang(View view) {
        ImageButton btnLanguage = findViewById(R.id.btn_lang);
        String language = (String) btnLanguage.getTag();

        if (language.equals("es")) {
            language = "en";
            btnLanguage.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.icon_en_uk));
        } else {
            language = "es";
            btnLanguage.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.icon_es_es));
        }

        // Guardar el idioma seleccionado en SharedPreferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("language", language);
        editor.apply();

        // Aplicar el idioma seleccionado en la configuración regional
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

}