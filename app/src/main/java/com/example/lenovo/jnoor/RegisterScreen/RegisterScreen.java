package com.example.lenovo.jnoor.RegisterScreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.jnoor.LoginScreen.LoginScreen;
import com.example.lenovo.jnoor.R;

import butterknife.ButterKnife;
import butterknife.BindView;


public class RegisterScreen extends AppCompatActivity {
    private static final String TAG = "SignupActivity";
//    @BindView(R.id.input_name) EditText _nameText;
//    @BindView(R.id.input_address) EditText _addressText;
//    @BindView(R.id.input_email) EditText _emailText;
//    @BindView(R.id.input_mobile) EditText _mobileText;
//    @BindView(R.id.input_password) EditText _passwordText;
//    @BindView(R.id.input_reEnterPassword) EditText _reEnterPasswordText;
//    @BindView(R.id.btn_signup) Button _signupButton;
    @BindView(R.id.btn_next) Button _btnNext;
    @BindView(R.id.link_login) TextView _loginLink;
    EditText employeeCode;
    RadioGroup radioGroup;
    RadioButton coorporate,employee,individual;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_registeration_screen);
        this.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        ButterKnife.bind(this);
        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                Intent intent = new Intent(getApplicationContext(),LoginScreen.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });

        //RadioGroup Initialization and funtions implementation
        optionsSelection();
        //Check edittext on valuechange function
        edittextOnValueChangeListener();
        //Checking the RadioButton Selection Checked State
        if(radioGroup.getCheckedRadioButtonId() == -1){
            _btnNext.setClickable(false);
            _btnNext.setBackgroundColor(getResources().getColor(R.color.aluminum));
        }
        _btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check Which Radio Button is Checked
                if(radioGroup.getCheckedRadioButtonId() == individual.getId()){
                    Intent i = new Intent(RegisterScreen.this,IndividualRegisterScreen.class);
                    finish();
                    startActivity(i);
                } else if(radioGroup.getCheckedRadioButtonId() == coorporate.getId()){
                    Intent i = new Intent(RegisterScreen.this,CompanyRegisterScreen.class);
                    finish();
                    startActivity(i);
                }
            }
        });

        //BroadCast Receivcer
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
            }
        };
    }

    private void edittextOnValueChangeListener() {
        TextWatcher textwatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Toast.makeText(getApplicationContext(),employeeCode.getText().toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        employeeCode.addTextChangedListener(textwatcher);
    }

    private void optionsSelection() {
        //Radio Group
        radioGroup = (RadioGroup) findViewById(R.id.type);
        coorporate = (RadioButton) findViewById(R.id.corporate);
        employee = (RadioButton) findViewById(R.id.employee);
        individual = (RadioButton) findViewById(R.id.individual);
        employeeCode = (EditText) findViewById(R.id.employeeCode);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                _btnNext.setClickable(true);
                _btnNext.setBackgroundColor(getResources().getColor(R.color.shade2));

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                switch (checkedId){
                    case R.id.corporate:
                        employeeCode.setEnabled(false);
                        imm.hideSoftInputFromWindow(employeeCode.getWindowToken(), 0);
                        employeeCode.clearFocus();
                        break;
                    case R.id.individual:
                        employeeCode.setEnabled(false);
                        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(employeeCode.getWindowToken(), 0);
                        employeeCode.clearFocus();
                        break;
                    case R.id.employee:
                        employeeCode.setEnabled(true);
                        employeeCode.setInputType(InputType.TYPE_CLASS_TEXT);
                        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.showSoftInput(employeeCode, InputMethodManager.SHOW_IMPLICIT);
                        employeeCode.requestFocus();
                        break;

                }
            }
        });
    }


//    public void signup() {
//        Log.d(TAG, "Signup");
//
//        if (!validate()) {
//            onSignupFailed();
//            return;
//        }
//
//        _signupButton.setEnabled(false);
//
//        final ProgressDialog progressDialog = new ProgressDialog(RegisterScreen.this,
//                R.style.AppTheme_Dark_Dialog);
//        progressDialog.setIndeterminate(true);
//        progressDialog.setMessage("Creating Account...");
//        progressDialog.show();
//
//        String name = _nameText.getText().toString();
//        String address = _addressText.getText().toString();
//        String email = _emailText.getText().toString();
//        String mobile = _mobileText.getText().toString();
//        String password = _passwordText.getText().toString();
//        String reEnterPassword = _reEnterPasswordText.getText().toString();
//
//        // TODO: Implement your own signup logic here.
//
//        new android.os.Handler().postDelayed(
//                new Runnable() {
//                    public void run() {
//                        // On complete call either onSignupSuccess or onSignupFailed
//                        // depending on success
//                        onSignupSuccess();
//                        // onSignupFailed();
//                        progressDialog.dismiss();
//                    }
//                }, 3000);
//    }
//
//
//    public void onSignupSuccess() {
//        _signupButton.setEnabled(true);
//        setResult(RESULT_OK, null);
//        finish();
//    }
//
//    public void onSignupFailed() {
//        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
//
//        _signupButton.setEnabled(true);
//    }
//
//    public boolean validate() {
//        boolean valid = true;
//
//        String name = _nameText.getText().toString();
//        String address = _addressText.getText().toString();
//        String email = _emailText.getText().toString();
//        String mobile = _mobileText.getText().toString();
//        String password = _passwordText.getText().toString();
//        String reEnterPassword = _reEnterPasswordText.getText().toString();
//
//        if (name.isEmpty() || name.length() < 3) {
//            _nameText.setError("at least 3 characters");
//            valid = false;
//        } else {
//            _nameText.setError(null);
//        }
//
//        if (address.isEmpty()) {
//            _addressText.setError("Enter Valid Address");
//            valid = false;
//        } else {
//            _addressText.setError(null);
//        }
//
//
//        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            _emailText.setError("enter a valid email address");
//            valid = false;
//        } else {
//            _emailText.setError(null);
//        }
//
//        if (mobile.isEmpty() || mobile.length()!=10) {
//            _mobileText.setError("Enter Valid Mobile Number");
//            valid = false;
//        } else {
//            _mobileText.setError(null);
//        }
//
//        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
//            _passwordText.setError("between 4 and 10 alphanumeric characters");
//            valid = false;
//        } else {
//            _passwordText.setError(null);
//        }
//
//        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 || reEnterPassword.length() > 10 || !(reEnterPassword.equals(password))) {
//            _reEnterPasswordText.setError("Password Do not match");
//            valid = false;
//        } else {
//            _reEnterPasswordText.setError(null);
//        }
//
//        return valid;
//    }
}