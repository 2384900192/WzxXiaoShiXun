package com.example.wzxxiaoshixun.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.wzxxiaoshixun.R;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.UMShareAPI;

public class OneFragment extends Fragment implements View.OnClickListener {
    private Button mFenxiangBu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.activity_one, null);
        initView(inflate);
        return inflate;
    }

    private void initView(@NonNull final View itemView) {
        mFenxiangBu = (Button) itemView.findViewById(R.id.bu_fenxiang);
        mFenxiangBu.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bu_fenxiang:
                // TODO 20/06/09

                break;
            default:
                break;
        }
    }
}
