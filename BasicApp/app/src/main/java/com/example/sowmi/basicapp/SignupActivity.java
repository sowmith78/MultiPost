package com.example.sowmi.basicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
    public void onRegister(View v)

    {
        EditText name = (EditText)findViewById(R.id.nam);
        EditText mail = (EditText)findViewById(R.id.mail);
        EditText username = (EditText)findViewById(R.id.uname);
        EditText password1 = (EditText)findViewById(R.id.pword);
        EditText password2 = (EditText)findViewById(R.id.pword2);


        String namestr = name.getText().toString();
        String mailstr = mail.getText().toString();
        String usernamestr = username.getText().toString();
        String password1str = password1.getText().toString();
        String password2str = password2.getText().toString();

        if (!password1str.equals(password2str))
        {
            Toast pass = Toast.makeText(SignupActivity.this,"Password does not match ", Toast.LENGTH_SHORT);
            pass.show();
        }

        else
        {
            Contact c = new Contact();
            c.setName(namestr);
            c.setEmail(mailstr);
            c.setUname(usernamestr);
            c.setPass(password1str);

            helper.insertContact(c);

            Intent i = new Intent(SignupActivity.this,MainActivity.class);

            startActivity(i);


        }



    }

}
