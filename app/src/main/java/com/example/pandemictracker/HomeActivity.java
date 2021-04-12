package com.example.pandemictracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonSignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignup;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS ,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() !=null){
            //Profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(),homepage.class));
        }

        editTextEmail = (EditText) findViewById(R.id.editTextemail);
        editTextPassword = (EditText) findViewById(R.id.editTextpassword);
        buttonSignIn = (Button)findViewById(R.id.buttonSignIn);
        textViewSignup = (TextView)findViewById(R.id.textViewSignup);

        buttonSignIn.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);
        if(haveNetwork())
        {
            //proceed with my app functionality
        }
        else if(!haveNetwork())
        {
            Toast.makeText(HomeActivity.this , "Network unavailable!Try again" , Toast.LENGTH_SHORT).show();
        }
    }
    private boolean haveNetwork()
    {
        boolean have_WIFI = false;
        boolean have_MobileData = false;

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();

        for (NetworkInfo info:networkInfos)
        {
            if(info.getTypeName().equalsIgnoreCase("WIFI"))
                if(info.isConnected())
                    have_WIFI = true;
            if(info.getTypeName().equalsIgnoreCase("Mobile"))
                if(info.isConnected())
                    have_MobileData = true;
        }
        return have_MobileData||have_WIFI;
    }

    private void userLogin(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        
        closekeyboard();

        if(TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this,"Please Enter Your Email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this,"Please Enter Your Password",Toast.LENGTH_SHORT).show();
            return;
        }
        firebaseAuth.signInWithEmailAndPassword(email , password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                //Start the profile Activity
                                finish();
                                startActivity(new Intent(getApplicationContext(),homepage.class));
                            }else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(HomeActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }

                    }
                });
    }

    private void closekeyboard() {
        View view = this.getCurrentFocus();
        if(view!=null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }

    @Override
    public void onClick(View v) {
        if(v == buttonSignIn){
            userLogin();
        }
        if(v == textViewSignup){
            finish();
            startActivity(new Intent(this,SignupActivity.class));
        }
    }
}
