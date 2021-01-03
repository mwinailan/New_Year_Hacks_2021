package com.example.new_year_new_hacks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText ePassword, eEmail;
    public EditText eNickname;
    private Button mRegister;
    private Button goLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        ePassword = findViewById(R.id.ePassword);
        eEmail = findViewById(R.id.eEmail);
        eNickname = findViewById(R.id.eNickname);
        goLogin = (Button) findViewById(R.id.alreadyButton);
        goLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent signUp = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(signUp);
            }
        });
        mRegister = findViewById(R.id.goButton);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String email = eEmail.getText().toString();
                String password = ePassword.getText().toString();
                String nickname = eNickname.getText().toString();

                if (email.isEmpty())
                {
                    eEmail.setError("Please enter your email");
                    eEmail.requestFocus();
                }
                if (password.isEmpty())
                {
                    ePassword.setError("Please enter a password");
                    ePassword.requestFocus();
                }
                if (nickname.isEmpty())
                {
                    eNickname.setError("Please enter a nickname");
                    eNickname.requestFocus();
                }
                if (!(nickname.isEmpty() && password.isEmpty() && email.isEmpty()))
                {
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful())
                            {
                                Toast.makeText(SignUpActivity.this, "Please try again", Toast.LENGTH_SHORT ).show();
                            }
                            else {
                                startActivity(new Intent (SignUpActivity.this, LoginActivity.class));
                            }
                        }
                    });
                }

            }
        });
    }

}