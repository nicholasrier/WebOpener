package com.plusqa.bc.webopener;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setBackgroundColor(Color.parseColor("#4286c1"));

        myToolbar.setLogo(R.drawable.bc_logo_white);
    }

    /** Called when the user taps the SUBMIT button */
    public void submitPassword(View view) {
        EditText editText = findViewById(R.id.editText4);
        String password = editText.getText().toString();
        String link = "https://apps.betacrash.com/get/" + password;
        Uri webPage = Uri.parse(link);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webPage);
        editText.clearFocus();
        startActivity(webIntent);
    }

}
