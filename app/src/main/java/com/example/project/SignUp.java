package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {

    TextView alreadyHaveAccount;
    EditText mEmail, mPass, mCpass;
    Button signUpBut;
    String verifyEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        alreadyHaveAccount = findViewById(R.id.alreadyAccount);
        alreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, MainActivity.class));
            }
        });
        mEmail = findViewById(R.id.setEmail);
        mPass = findViewById(R.id.setPasswrd);
        mCpass = findViewById(R.id.conformPassword);
        signUpBut = findViewById(R.id.signUpButton);
        signUpBut.setBackgroundResource(000000);

        progressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        

        signUpBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAuthentication();
            }
        });

    }

    private void performAuthentication() {
        String inputEmail = mEmail.getText().toString();
        String inputPassword = mPass.getText().toString();
        String conformPassword = mCpass.getText().toString();
        
        if(!inputEmail.matches(verifyEmail)){
//            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            mEmail.setError("Enter Correct Email");
        }else if(inputPassword.isEmpty() || inputPassword.length()<6){
            mPass.setError("Enter Proper Password");
        }else if(!inputPassword.equals(conformPassword)){
            mCpass.setError("Passwords doesn't match");
        }else{
            progressDialog.setMessage("Creating your account ... ");
            progressDialog.setTitle("Signing Up");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(inputEmail,inputPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        Toast.makeText(SignUp.this, "Sign Up successful !", Toast.LENGTH_SHORT).show();
                        sendUserToNextActivity();
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(SignUp.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

    }

    private void sendUserToNextActivity() {
//        startActivity(new Intent(SignUp.this, HomeScreen.class));
        Intent intent = new Intent(SignUp.this, HomeScreen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}