package com.example.wzxxiaoshixun.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.wzxxiaoshixun.R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

public class FenActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "FenActivity";
    private Button mButter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fen);
        initView();
        initPermission();
    }

    private void initView() {
        mButter = (Button) findViewById(R.id.butter);
        mButter.setOnClickListener(this);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
    private void initPermission() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.butter:
                // TODO 20/06/09
                share();
                break;
            default:
                break;
        }
    }

    private void share() {
        //分享图片、分享文本（可以单独分享）
        UMImage image = new UMImage(this, "http://ww4.sinaimg.cn/large/7a8aed7bjw1exp4h479xfj20hs0qoq6t.jpg");
        UMImage thumb = new UMImage(this, R.drawable.umeng_socialize_copy);
        image.compressStyle = UMImage.CompressStyle.SCALE;//大小压缩，默认为大小压缩，适合普通很大的图
        new ShareAction(FenActivity.this)
                .withText("我是美女")//文本
                .withMedias(image, image)//分享的图片
                .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.QZONE)//三方列表
                .setCallback(umShareListener)//分享回调
                .open();
    }
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {
            Log.d(TAG, "onStart: " + share_media);
        }

        @Override
        public void onResult(SHARE_MEDIA share_media) {
            Log.d(TAG, "onResult: " + share_media);
        }

        @Override
        public void onError(SHARE_MEDIA share_media, Throwable throwable) {
            Log.d(TAG, "onError: " + throwable.toString());
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media) {
            Log.d(TAG, "onCancel: " + share_media);
        }
    };
}
