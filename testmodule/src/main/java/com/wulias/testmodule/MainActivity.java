package com.wulias.testmodule;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.wulias.customdialog.dialogui.CommomDialog;
import com.wulias.customdialog.dialogui.InputDialog;

import interfaces.OnCloseListener;
import interfaces.OnInputListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv1).setOnClickListener(this);
        findViewById(R.id.tv2).setOnClickListener(this);
        findViewById(R.id.tv3).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv1:
                new CommomDialog(MainActivity.this, "你确定找的就是我？？", new OnCloseListener() {
                    @Override
                    public void onClick(Dialog dialog, boolean confirm) {
                        if (confirm){

                        }else {

                        }
                        dialog.dismiss();
                    }
                }).show();
                break;
            case R.id.tv2:
                new InputDialog(MainActivity.this, "你确定找的就是我？？", new OnInputListener() {
                    @Override
                    public void onClick(Dialog dialog,String[] result, boolean confirm) {
                        if (confirm){
                            Log.e("TAG_RRRR",result[0]+"<----->"+result[1]);
                        }else {
                            Log.e("TAG_RRRR",result[0]+"<----->"+result[1]);
                        }
                        dialog.dismiss();
                    }
                }).show();
                break;
            case R.id.tv3:
                break;
            case R.id.tv4:
                break;
        }
    }
}
