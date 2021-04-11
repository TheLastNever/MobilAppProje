package com.example.colorchange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText etName, etPassword, etPasswordReenter, etEmail;
    RadioButton rb8hours, rb24hours, rbFemale, rbMale;
    RadioGroup rb;
    Button btnRegister, btnClear, btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);




        btnRegister = (Button) findViewById(R.id.button);
        btnClear = (Button) findViewById(R.id.button2);
        etName = (EditText) findViewById(R.id.editTextTextPersonName);
        etPassword = (EditText) findViewById(R.id.editTextTextPassword2);
        etPasswordReenter = (EditText) findViewById(R.id.editTextTextPassword3);
        etEmail = (EditText)findViewById(R.id.editTextTextPersonName2);
        /*
        rb8hours = (RadioButton)findViewById(R.id.radioButton9);
        rb24hours = (RadioButton)findViewById(R.id.radioButton7);
        rbFemale = (RadioButton)findViewById(R.id.radioButton10);
        rbMale = (RadioButton)findViewById(R.id.radioButton11);
        rb = (RadioGroup) findViewById(R.id.radioGroup);*/




    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;



    }

    public void registerPerson(View view){

        String pass = etPassword.getText().toString();
        String passRe = etPasswordReenter.getText().toString();
        String email = etEmail.getText().toString();
        String name = etName.getText().toString();


        if (!pass.equals(passRe) )
        {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Password Match");
            alert.setMessage("Passwords do not match. Please Try Again");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(RegisterActivity.this, "Try Again", Toast.LENGTH_SHORT).show();


                }
            });
            alert.create().show();

        }
        else if(TextUtils.isEmpty(pass) || pass.length() < 8 || pass.equals(pass.toLowerCase()) || pass.equals(pass.toUpperCase()) || !pass.matches(".*\\d.*"))
        {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Password Requirements");
            alert.setMessage("Password Doesn't satisfy the requirements (At least one Upper case, Numeric and minimum length of 8");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(RegisterActivity.this, "Try Again", Toast.LENGTH_SHORT).show();


                }
            });
            alert.create().show();

        }

        else  if(TextUtils.isEmpty(pass) || TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || !email.contains("@") || !email.contains(".com"))
        {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Fill");
            alert.setMessage("Please fill the required areas");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(RegisterActivity.this, "Try Again", Toast.LENGTH_SHORT).show();


                }
            });
            alert.create().show();
        }
        else{
            Toast.makeText(this, "Congratulations you have successfully completed your registration!", Toast.LENGTH_LONG).show();

        }


    }

    public void clearEntries(View view){
       /* rb8hours = (RadioButton)findViewById(R.id.radioButton9);
        rb24hours = (RadioButton)findViewById(R.id.radioButton7);
        rbFemale = (RadioButton)findViewById(R.id.radioButton10);
        rbMale = (RadioButton)findViewById(R.id.radioButton11);
        rb = (RadioGroup) findViewById(R.id.radioGroup);
        */
        etName.getText().clear();
        etEmail.getText().clear();
        etPassword.getText().clear();
        etPasswordReenter.getText().clear();

        /*rb.clearCheck();

        rbFemale.setChecked(false);
        rbMale.setChecked(false);*/

    }



}