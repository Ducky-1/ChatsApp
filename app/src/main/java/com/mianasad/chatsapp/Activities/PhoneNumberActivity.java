package com.mianasad.chatsapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.hbb20.CountryCodePicker;
import com.mianasad.chatsapp.databinding.ActivityPhoneNumberBinding;

public class PhoneNumberActivity extends AppCompatActivity {
    ActivityPhoneNumberBinding binding;

    private Spinner spinner; //Sarthak
    private CountryCodePicker ccp;


FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneNumberBinding.inflate(getLayoutInflater());
        //Start Sarthak


        ccp = binding.picker;
        setContentView(binding.getRoot());
        //End Sarthak


        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() != null) {
            Intent intent = new Intent(PhoneNumberActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        getSupportActionBar().hide();
//        binding.phoneBox.requestFocus();
        binding.continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start Sarthak
                String number = binding.phoneBox.getText().toString();
                String code = ccp.getSelectedCountryCodeWithPlus();
                String phoneNumber = code+number;
                System.out.println(phoneNumber);
                //End Sarthak

                Intent intent = new Intent(PhoneNumberActivity.this, OTPActivity.class);
                intent.putExtra("phoneNumber",phoneNumber);
                startActivity(intent);
            }
        });
    }
}