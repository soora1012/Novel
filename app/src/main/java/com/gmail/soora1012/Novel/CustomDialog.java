package com.gmail.soora1012.Novel;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class CustomDialog {


    public interface CustomOneDialogListener {
         void onPositiveClicked();
    }

    public interface CustomTwoDialogListener {
        void onPositiveClicked();
        void onNegativeClicked();
    }



    private Activity mActivity;
    public CustomDialog(@Nullable Activity activity){
        this.mActivity = activity;

    }

    public void OneDialog(String title, String msg, final CustomOneDialogListener listener) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton(mActivity.getString(R.string.ok),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onPositiveClicked();
                    }
                });
        builder.create();
        builder.show();

    }

}
