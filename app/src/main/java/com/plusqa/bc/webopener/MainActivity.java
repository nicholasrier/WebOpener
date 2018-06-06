package com.plusqa.bc.webopener;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText mBuildCodeET;
    private BuildCodeValidator mBuildCodeValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Super genius code that I invented myself
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up custom toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolBarWithLogo);
        setSupportActionBar(myToolbar);
        myToolbar.setBackgroundColor(Color.parseColor("#4286c1"));
        myToolbar.setLogo(R.drawable.bc_logo_white);

        // EditText shortcut and Build Code Validation setup
        mBuildCodeET = (EditText) findViewById(R.id.userBuildCodeInput);
        mBuildCodeValidator = new BuildCodeValidator();
        mBuildCodeET.addTextChangedListener(mBuildCodeValidator);

    }

    /** Called when the user taps the SUBMIT button */
    public void submitPassword(View view) {
        // Don't launch BC if build code is invalid
        if (!mBuildCodeValidator.isValid()) {
            mBuildCodeET.setError("Invalid Code");
            Log.w(TAG, "Not launching BetaCrash on web: Invalid build code");
            mBuildCodeET.setText("");
            return;
        }

        // Build URL with user entered build code
        String buildCode = mBuildCodeET.getText().toString();
        String link = "https://apps.betacrash.com/get/" + buildCode;
        Uri webPage = Uri.parse(link);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webPage);
        mBuildCodeET.clearFocus();

        // Launch BC web
        startActivity(webIntent);
    }

}
