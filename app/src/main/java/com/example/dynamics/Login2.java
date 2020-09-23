package com.example.dynamics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login2 extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonSignin;
    private FirebaseAuth firebaseAuth;
    private TextView textViewSignup;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        firebaseAuth= FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() !=null){

            finish();

            Intent intent=new Intent(getApplicationContext(),registration.class);
            startActivity(intent);

        }

        editTextEmail=findViewById(R.id.edittextemail);
        editTextPassword=findViewById(R.id.edittextpassword);
        buttonSignin= findViewById(R.id.buttonsign);
        textViewSignup=findViewById(R.id.textviewsignup);

        progressDialog =new ProgressDialog(this);

        buttonSignin.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==buttonSignin){
            userlogin();
        }
        if (v==textViewSignup){
            finish();

            startActivity(new Intent(this,MainActivity.class));

        }



    }
    private void userlogin(){
        final String email=editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this,"please enter email",Toast.LENGTH_LONG).show();



        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"please enter password",Toast.LENGTH_LONG).show();



        }
        progressDialog.setMessage("signinginplease wait");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();


                if (task.isSuccessful()){

                    finish();
                    startActivity(new Intent(getApplicationContext(),SubjectChoice.class));

                }


            }
        });



    }
}