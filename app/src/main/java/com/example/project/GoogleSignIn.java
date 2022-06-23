package com.example.project;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class GoogleSignIn extends MainActivity {

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(com.google.firebase.R.string.common_google_play_services_unknown_issue))
                .requestEmail()
                .build();

        mGoogleSignInClient = com.google.android.gms.auth.api.signin.GoogleSignIn.getClient(this, gso);
//        SignInCredential googleCredential = oneTapClient.getSignInCredentialFromIntent(data);
//        String idToken = googleCredential.getGoogleIdToken();
//        if (idToken !=  null) {
//            // Got an ID token from Google. Use it to authenticate
//            // with Firebase.
//            AuthCredential firebaseCredential = GoogleAuthProvider.getCredential(idToken, null);
//            mAuth.signInWithCredential(firebaseCredential)
//                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if (task.isSuccessful()) {
//                                // Sign in success, update UI with the signed-in user's information
//                                Log.d(TAG, "signInWithCredential:success");
//                                FirebaseUser user = mAuth.getCurrentUser();
//                                updateUI(user);
//                            } else {
//                                // If sign in fails, display a message to the user.
//                                Log.w(TAG, "signInWithCredential:failure", task.getException());
//                                updateUI(null);
//                            }
//                        }
//                    });
//        }
//
//        GoogleSignInAccount acct= com.google.android.gms.auth.api.signin.GoogleSignIn.getLastSignedInAccount(this);
//        if(acct != null){
//            startActivity(new Intent(this,HomeScreen.class));
//        }else{
//
//            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
//        }
//
////        googleLogin.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                performAuthentication();
////            }
////        });
//
//    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
//    }
//
//    private void updateUI(FirebaseUser currentUser) {
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        mGoogleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                finish();
//                startActivity(new Intent(GoogleSignIn.this, MainActivity.class));
//            }
//        });
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        mGoogleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                finish();
//                startActivity(new Intent(GoogleSignIn.this, MainActivity.class));
//            }
//        });
    }

    //        private void performAuthentication() {
//            String inputEmail = mEmail.getText().toString();
//            String inputPassword = mPass.getText().toString();
//
//
//            if (!inputEmail.matches(verifyEmail)) {
////            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
//                mEmail.setError("Enter Correct Email");
//            } else if (inputPassword.isEmpty() || inputPassword.length() < 6) {
//                mPass.setError("Enter Proper Password");
//            } else {
//                progressDialog.setMessage("Logging in your account ... ");
//                progressDialog.setTitle("Signing Up");
//                progressDialog.setCanceledOnTouchOutside(false);
//                progressDialog.show();
//
//                mAuth.startActivityForSignInWithProvider(inputEmail, inputPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            progressDialog.dismiss();
//                            Toast.makeText(GoogleSignIn.this, "Sign In successful !", Toast.LENGTH_SHORT).show();
//                            sendUserToNextActivity();
//                        } else {
//                            progressDialog.dismiss();
//                            Toast.makeText(GoogleSignIn.this, "" + task.getException(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//            }
//
//    }
//    private void sendUserToNextActivity() {
////        startActivity(new Intent(SignUp.this, HomeScreen.class));
//        Intent intent = new Intent(GoogleSignIn.this, HomeScreen.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
//    }
}