package com.example.spotlyrics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

// ...

public class MainActivity extends AppCompatActivity {

    TextInputEditText editTextemail, editTextpassword;

    Button signin,GsignIN;
    TextView signup;
    GoogleSignInOptions gso;
    GoogleSignInClient  gsc;
    FirebaseAuth firebaseAuth; // Remove the direct initialization here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance(); // Initialize FirebaseAuth here

        editTextemail = findViewById(R.id.email);
        editTextpassword = findViewById(R.id.password);
        signin = findViewById(R.id.sign_in);
        signup = findViewById(R.id.sign_up);
//        GsignIN=findViewById(R.id.google_sign_in);
//             gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail().build();
//
//             gsc= GoogleSignIn.getClient(this,gso);
//
//             GsignIN.setOnClickListener(new View.OnClickListener() {
//                 @Override
//                 public void onClick(View v) {
//                     SignInG();
//                 }
//             });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterPage.class);
                startActivity(intent);
                finish();
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password;
                email = String.valueOf(editTextemail.getText());
                password = String.valueOf(editTextpassword.getText());
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(MainActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "Enter a valid password", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Use firebaseAuth here, not FirebaseAuth
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Sign In successful", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(MainActivity.this, User_Profile.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(MainActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

//    private void SignInG (){
//        Intent intent=gsc.getSignInIntent();
//        startActivityForResult(intent,100);
//    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 100) {
//            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//            try {
//                // Successfully signed in
//                GoogleSignInAccount account = task.getResult(ApiException.class);
//                // Pass the GoogleSignInAccount to Firebase for authentication
//                firebaseAuthWithGoogle(account);
//            } catch (ApiException e) {
//                // Failed to sign in, handle the error
//                Toast.makeText(this, "Google Sign-In failed. Error code: " + e.getStatusCode(), Toast.LENGTH_SHORT).show();
//            }
//        }
//    }

//    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
//        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
//
//        FirebaseAuth.getInstance().signInWithCredential(credential)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Toast.makeText(MainActivity.this, "Google Sign-In successful", Toast.LENGTH_SHORT).show();
//                            UserActivity(); // Start the User_Profile activity
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Toast.makeText(MainActivity.this, "Firebase authentication failed", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//    }


//    private void UserActivity() {
//        finish();
//        Intent intent= new Intent(getApplicationContext(),User_Profile.class);
//        startActivity(intent);
//    }


}

