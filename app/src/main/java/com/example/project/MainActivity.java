package com.example.project;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {



    private static final int RC_SIGN_IN = 1000;
    Button loginButton;
    TextView createNewAccount;
    EditText mEmail, mPass;
    Button signUpBut;
    String verifyEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    ImageView mGoogle,mApple, mFacebook;
    GoogleSignInOptions gso;
    GoogleSignInClient mGoogleSignInClient;
    ImageView googleLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        googleLogin = findViewById(R.id.googleLogIn);
        mApple = findViewById(R.id.appleLogIn);
        mFacebook = findViewById(R.id.facebookLogIn);

        mFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });

        mApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,HomeScreen.class));
            }
        });

        googleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        mGoogle = findViewById(R.id.googleLogIn);
        mEmail = findViewById(R.id.enterEmail);
        mPass = findViewById(R.id.enterPasswrd);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        progressDialog = new ProgressDialog(this);
        loginButton = findViewById(R.id.signInButton);
        createNewAccount = findViewById(R.id.createNewAccount);
        Intent registerIntent = new Intent(this, SignUp.class);
        createNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(registerIntent);
            }
        });


        loginButton.setBackgroundResource(000000);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAuthentication();
//                startActivity(intent);

            }
        });
    }

    private void signIn() {
        Intent intent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(intent, RC_SIGN_IN);
    }

    private void performAuthentication() {
        String inputEmail = mEmail.getText().toString();
        String inputPassword = mPass.getText().toString();


        if (!inputEmail.matches(verifyEmail)) {
//            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            mEmail.setError("Enter Correct Email");
        } else if (inputPassword.isEmpty() || inputPassword.length() < 6) {
            mPass.setError("Enter Proper Password");
        } else {
            progressDialog.setMessage("Logging in your account ... ");
            progressDialog.setTitle("Signing Up");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(inputEmail, inputPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Sign In successful !", Toast.LENGTH_SHORT).show();
                        sendUserToNextActivity();
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "" + task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void sendUserToNextActivity() {
//        startActivity(new Intent(SignUp.this, HomeScreen.class));
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//            handleSignInResult(task);
            try {
                task.getResult(ApiException.class);
                moveToNext();
//                sendUserToNextActivity();
            } catch (ApiException e) {
                Toast.makeText(this, "Something went wrong ...", Toast.LENGTH_SHORT).show();
            }
        }
//        private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
//            try {
//                GoogleSignInAccount account = completedTask.getResult(ApiException.class);
//
//                // Signed in successfully, show authenticated UI.
//                updateUI(account);
//            } catch (ApiException e) {
//                // The ApiException status code indicates the detailed failure reason.
//                // Please refer to the GoogleSignInStatusCodes class reference for more information.
//                Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
//                updateUI(null);
//            }
//        }
    }

    private void moveToNext() {
        finish();
        startActivity(new Intent(this, HomeScreen.class));
    }
}