package com.example.wzxxiaoshixun.connmer;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

public class WzxApplication extends Application {
    private static WzxApplication application;
    public static WzxApplication getApplication() {
        return application;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        //5edef29f978eea085d11e052

        //qq
//        APP ID1110588758
//
//        APP KEYENgKTwR1QjU692XV

        //微博
//        App Key：4026073420
//        App Secret：15a7a2361cb2dc6e17234d2a7f9ff62f

        initUmeng();
    }

    private void initUmeng() {
        UMConfigure.init(this, "5edef29f978eea085d11e052", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        PlatformConfig.setSinaWeibo("4026073420", "15a7a2361cb2dc6e17234d2a7f9ff62f", "http://sns.whalecloud.com");
        PlatformConfig.setQQZone("1110588758", "KEYENgKTwR1QjU692XV");

        UMConfigure.setLogEnabled(true);
    }
}
