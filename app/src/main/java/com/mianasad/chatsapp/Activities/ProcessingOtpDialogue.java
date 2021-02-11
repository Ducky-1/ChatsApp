package com.mianasad.chatsapp.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import com.mianasad.chatsapp.R;

public class ProcessingOtpDialogue {
    Activity activity;
    AlertDialog dialog;

    ProcessingOtpDialogue(Activity myActivity){
        activity = myActivity;
    }

    void startProcessingDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_otp_dialoguebox, null));
        builder.setCancelable(false);

        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();
    }

    void dismissDialog(){
        dialog.dismiss();
    }
}
