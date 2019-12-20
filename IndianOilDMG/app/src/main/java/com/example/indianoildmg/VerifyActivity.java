package com.example.indianoildmg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class VerifyActivity extends AppCompatActivity {

    TextView mTextNote, mTextWelcomeBack, mTextAuto, mTextTime;
    TextInputLayout mTextInputLayout;
    TextInputEditText mEditText;
    Button mButton, mButtonSubmit;
    ProgressBar progressBar;
    ImageButton mButtonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        mTextNote = findViewById(R.id.text_note);
        mTextInputLayout = findViewById(R.id.text_input_layout);
        mEditText = findViewById(R.id.edit_text);
        mButton = findViewById(R.id.button);
        progressBar = findViewById(R.id.progress_bar);
        mButtonNext = findViewById(R.id.button_next);
        mTextWelcomeBack = findViewById(R.id.text_welcome_back);
        mButtonSubmit = findViewById(R.id.button_submit);
        mTextAuto = findViewById(R.id.text_auto);
        mTextTime = findViewById(R.id.text_time);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (!TextUtils.isEmpty(extras.getString(getString(R.string.is_for)))) {
                if (Objects.requireNonNull(extras.getString(getString(R.string.is_for))).equalsIgnoreCase("Email ID")) {
                    setTitle(R.string.title_verify_email_id);
                    mTextNote.setText(R.string.verify_email_note);
                    mButton.setText(R.string.resend_otp);
                    mTextInputLayout.setPasswordVisibilityToggleEnabled(false);
                    mTextInputLayout.setHint(getResources().getString(R.string.hint_enter_otp));
                } else if (Objects.requireNonNull(extras.getString(getString(R.string.is_for))).equalsIgnoreCase("Mobile")) {
                    setTitle(R.string.title_verify_mobile_no);
                    mTextNote.setText(R.string.verify_mobile_note);
                    mButton.setText(R.string.resend_otp);
                    mTextInputLayout.setPasswordVisibilityToggleEnabled(false);
                    mTextInputLayout.setHint(getResources().getString(R.string.hint_enter_otp));
                    progressBar.setVisibility(View.GONE);
                    mTextAuto.setVisibility(View.VISIBLE);
                    mTextTime.setVisibility(View.VISIBLE);
                    mButtonNext.setVisibility(View.VISIBLE);
                } else if (Objects.requireNonNull(extras.getString(getString(R.string.is_for))).equalsIgnoreCase("New Password")) {
                    setTitle(R.string.title_secure_password);
                    mTextNote.setText(R.string.secure_password_note);
                    mButton.setText(R.string.forgot_password);
                    mTextInputLayout.setPasswordVisibilityToggleEnabled(true);
                    mTextInputLayout.setHint(getResources().getString(R.string.label_enter_password));
                    mEditText.setInputType(InputType.TYPE_CLASS_TEXT |
                            InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    progressBar.setVisibility(View.GONE);
                    mButton.setVisibility(View.GONE);
                    mButtonNext.setVisibility(View.VISIBLE);
                } else if(Objects.requireNonNull(extras.getString(getString(R.string.is_for))).equalsIgnoreCase("Password")){
                    setTitle("");
                    mTextNote.setText(R.string.sample_email_id);
                    mButton.setText(R.string.forgot_password);
                    mTextInputLayout.setPasswordVisibilityToggleEnabled(true);
                    mTextInputLayout.setHint(getResources().getString(R.string.label_enter_password));
                    mEditText.setInputType(InputType.TYPE_CLASS_TEXT |
                            InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    progressBar.setVisibility(View.GONE);
                    mButtonNext.setVisibility(View.GONE);
                    mButtonSubmit.setVisibility(View.VISIBLE);
                    mTextWelcomeBack.setVisibility(View.VISIBLE);
                }
            }
        }

//        setTitle(R.string.title_verify_email_id);
//        setTitle(R.string.title_verify_mobile_no);
//        setTitle(R.string.title_secure_password);
//        setTitle("");
//        mTextNote.setText(R.string.verify_mobile_note);
        //Password
//        mTextNote.setText(R.string.secure_password_note);
       /* mTextInputLayout.setPasswordVisibilityToggleEnabled(true);
        mTextInputLayout.setHint(getResources().getString(R.string.label_enter_password));
        mEditText.setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_PASSWORD);
        //Welcome Back
        mButton.setText(R.string.forgot_password);
        mTextNote.setText(R.string.sample_email_id);*/
    }
}
