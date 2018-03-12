package com.wulias.customdialog.dialogui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wulias.customdialog.R;

import interfaces.OnCloseListener;
import interfaces.OnInputListener;

/**
 * Created by Administrator on 2018/3/9.
 */

public class InputDialog extends Dialog implements View.OnClickListener {
    private EditText oneEdit;
    private EditText otwoEdit;
    private TextView titleTxt;
    private TextView submitTxt;
    private TextView cancelTxt;
    private View view;

    private Context mContext;
    private String firstHint;
    private String seconHint;
    private String oneString;
    private String twoString;
    private OnInputListener listener;
    private String positiveName;
    private String negativeName;
    private String title;

    public InputDialog(Context context) {
        super(context, R.style.dialog);
        this.mContext = context;
    }

    public InputDialog(Context context, String firstHint, String seconHint) {
        this(context);
        this.firstHint = firstHint;
        this.seconHint = seconHint;
    }

    public InputDialog(Context context, String firstHint, String seconHint, OnInputListener listener) {
        this(context, firstHint, seconHint);
        this.listener = listener;
    }

    public InputDialog(Context context, String firstHint, OnInputListener listener) {
        this(context, firstHint, "");
        this.listener = listener;
    }

    protected InputDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.mContext = context;
    }

    public InputDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public InputDialog setPositiveButton(String name) {
        this.positiveName = name;
        return this;
    }

    public InputDialog setNegativeButton(String name) {
        this.negativeName = name;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_input);
        setCanceledOnTouchOutside(false);
        initView();
    }

    private void initView() {
        oneEdit = (EditText) findViewById(R.id.inpunt_one);
        otwoEdit = (EditText) findViewById(R.id.inpunt_two);
        view = (View) findViewById(R.id.center_hint);
        titleTxt = (TextView) findViewById(R.id.title);
        submitTxt = (TextView) findViewById(R.id.submit);
        submitTxt.setOnClickListener(this);
        cancelTxt = (TextView) findViewById(R.id.cancel);
        cancelTxt.setOnClickListener(this);

        oneEdit.setHint(firstHint);
        if (seconHint != null && "".equals(seconHint)) {
            otwoEdit.setHint(seconHint);
            otwoEdit.setVisibility(View.VISIBLE);
        }

        if (!TextUtils.isEmpty(positiveName)) {
            submitTxt.setText(positiveName);
        }

        if (!TextUtils.isEmpty(negativeName)) {
            cancelTxt.setText(negativeName);
        }

        if (!TextUtils.isEmpty(title)) {
            titleTxt.setText(title);
        }

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        String[] result = new String[]{oneEdit.getText().toString(), otwoEdit.getText().toString()};
        if (i == R.id.cancel) {
            if (listener != null) {
                listener.onClick(this, result, false);
            }
            this.dismiss();

        } else if (i == R.id.submit) {
            if (listener != null) {
                listener.onClick(this, result, true);
            }

        }
    }

}
