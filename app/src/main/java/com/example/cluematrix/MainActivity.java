package com.example.cluematrix;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //declaring views
    EditText username, password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing views
        username = findViewById(R.id.usernameET);
        password = findViewById(R.id.passwordEt);
        loginButton = findViewById(R.id.loginButton);
        //setting up click listener
        loginButton.setOnClickListener(view -> {
            //extracting values form resources
            String user = username.getText().toString();
            String pass = password.getText().toString();
            //checking if empty or not
            if (!user.isEmpty() && !pass.isEmpty()) {
                //sending it to login method
                loginMethod(user, pass);
            } else {
                //initializing second scenario for else case
                Toast.makeText(this, "Fill all the fields", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //method for checking credentials
    private void loginMethod(String user, String pass) {
        if (user.equals("admin") && pass.equals("password")) {
            Toast.makeText(this, "Login Successful!!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, ParentLoggedInActivity.class));
        } else {
            Toast.makeText(this, "invalid credentials", Toast.LENGTH_SHORT).show();
        }
    }

    //for getting back pressed operation done
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure want to exit ?");
        builder.setTitle("Activity Exit Alert");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes",
                (dialog, which) -> {
                    Intent a = new Intent(Intent.ACTION_MAIN);
                    a.addCategory(Intent.CATEGORY_HOME);
                    a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(a);
                });
        builder.setNegativeButton("No",
                (dialog, which) -> dialog.cancel());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}