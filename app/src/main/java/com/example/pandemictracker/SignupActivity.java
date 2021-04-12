package com.example.pandemictracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    public Button registerbutton;
    public EditText editTextname;
    public EditText editTextemail;
    public EditText editTextpassword;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_signup);
        firebaseAuth = FirebaseAuth.getInstance();

        registerbutton = (Button) findViewById(R.id.registerbutton);

        editTextname = (EditText) findViewById(R.id.editTextname);
        editTextemail = (EditText) findViewById(R.id.editTextemail);

        editTextpassword = (EditText) findViewById(R.id.editTextpassword);

        registerbutton.setOnClickListener(this);
    }

    public void registerUser() {
        String email = editTextemail.getText().toString().trim();
        String name = editTextname.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();

        if(TextUtils.isEmpty(name)){
            //name is empty
            Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_SHORT).show();
            return;
        }
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

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                                //Profile activity here
                                finish();
                                startActivity(new Intent(getApplicationContext(),homepage.class));
                            }else{
                            Toast.makeText(SignupActivity.this,"Could not Register . Please try Again",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if (v == registerbutton) {
            registerUser();
        }
    }
}