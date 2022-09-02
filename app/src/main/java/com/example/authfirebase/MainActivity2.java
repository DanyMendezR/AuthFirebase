package com.example.authfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {

    private Button btn;
    Button btnSalir;
    FirebaseAuth mAuth;
    FirebaseAuth mAuth2;
    FirebaseAuth mAuth3;
    Button logout2;
    Button logout;
    Button verifyEmailBtn;
    TextView verifyMsg;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        /////////////////////////////////// EMAIL/PASSWORD SIGN IN (EMAIL VERIFICATION) /////////////////////////////////

        auth = FirebaseAuth.getInstance();
        verifyMsg = findViewById(R.id.verifyEmailMsg);
        verifyEmailBtn = findViewById(R.id.verifyEmailBtn);

        if (auth.getCurrentUser().isEmailVerified()){
            verifyEmailBtn.setVisibility(View.VISIBLE);
            verifyMsg.setVisibility(View.VISIBLE);
        }

        verifyEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.getCurrentUser().sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivity2.this, "Verification Email Sent", Toast.LENGTH_SHORT).show();
                        verifyEmailBtn.setVisibility(View.GONE);
                        verifyMsg.setVisibility(View.GONE);
                    }
                });
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////



        /////////////////////////////////// GOOGLE SIGN IN /////////////////////////////////////////
        btn = findViewById(R.id.logout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(i);
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////




        /////////////////////////////////// EMAIL/PASSWORD SIGN IN /////////////////////////////////

        mAuth = FirebaseAuth.getInstance();
        btnSalir = findViewById(R.id.btnExit);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                finish();
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////


        /////////////////////////////////// YAHOO SIGN IN /////////////////////////////////

        mAuth3 = FirebaseAuth.getInstance();
        logout2 = findViewById(R.id.btnExit2);
        logout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth3.signOut();
                finish();
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////






        /////////////////////////////////// OTP SIGN IN ////////////////////////////////////////////

        mAuth2 = FirebaseAuth.getInstance();
        logout = findViewById(R.id.logout2);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth2.signOut();
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
                finish();
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////







    }
}