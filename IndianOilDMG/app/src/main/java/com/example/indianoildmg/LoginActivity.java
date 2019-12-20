package com.example.indianoildmg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    TextView mBottomNote;
    ImageButton mButtonNext;
    boolean isFromMobile = false;
    TextInputLayout emailLayout;
    LinearLayout mMobileLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            isFromMobile = extras.getBoolean("isFromMobile");
        }

        if(isFromMobile){
            mMobileLayout.setVisibility(View.VISIBLE);
            emailLayout.setVisibility(View.GONE);
        }else {
            mMobileLayout.setVisibility(View.GONE);
            emailLayout.setVisibility(View.VISIBLE);
        }

        mBottomNote.setText(Html.fromHtml(String.format(getString(R.string.lable_login_bottom_note))));
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createNewAccountPopup();
            }
        });

    }

    private void createNewAccountPopup() {

        Dialog d = new BottomSheetDialog(this);
        d.setContentView(R.layout.create_new_acc_popup);
        TextView  mMobileNote = d.findViewById(R.id.mobile_number_note);
        TextView mButtonYes = d.findViewById(R.id.yes_create_acc);
        TextView mButtonNo = d.findViewById(R.id.no_link_exist_acc);

        mButtonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        mButtonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isFromMobile = true;
                Intent intent = new Intent(LoginActivity.this,LoginActivity.class);
                intent.putExtra("isFromMobile",isFromMobile);
                startActivity(intent);
            }
        });


        d.setCancelable(true);
        d.show();

    }

    private void initViews() {

        mBottomNote = findViewById(R.id.bottom_note);
        mButtonNext = findViewById(R.id.button_go);
        emailLayout = findViewById(R.id.emailTextInputLayout);
        mMobileLayout = findViewById(R.id.mobile_layout);
    }


}
