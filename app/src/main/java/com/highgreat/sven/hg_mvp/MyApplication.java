package com.highgreat.sven.hg_mvp;

import android.app.Application;

import com.highgreat.sven.isolation_processor.HttpHelper;
import com.highgreat.sven.isolation_processor.OkHttpProcessor;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //进行框架的选择
        //        HttpHelper.init(new VolleyProcessor(this));
        HttpHelper.init(new OkHttpProcessor());
//        HttpHelper.init(new XUtilsProcessor(this));
//        HttpHelper.init(new RetrofitProcessor());
    }
}
