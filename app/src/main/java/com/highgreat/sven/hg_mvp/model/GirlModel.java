package com.highgreat.sven.hg_mvp.model;

import android.util.Log;

import com.highgreat.sven.hg_mvp.R;
import com.highgreat.sven.hg_mvp.bean.Girl;
import com.highgreat.sven.hg_mvp.bean.ResponceData;
import com.highgreat.sven.isolation_processor.HttpCallback;
import com.highgreat.sven.isolation_processor.HttpHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GirlModel implements IGirlModel {

    List<Girl> data=new ArrayList<>();
    @Override
    public void loadGirlData(OnLoadListener onLoadListener) {
        data.add(new Girl(R.drawable.f1, "一星", "****"));
        data.add(new Girl(R.drawable.f2, "一星", "****"));
        data.add(new Girl(R.drawable.f3, "一星", "****"));
        data.add(new Girl(R.drawable.f4, "一星", "****"));
        data.add(new Girl(R.drawable.f5, "一星", "****"));
        data.add(new Girl(R.drawable.f6, "一星", "****"));
        data.add(new Girl(R.drawable.f7, "一星", "****"));
        data.add(new Girl(R.drawable.f8, "一星", "****"));
        data.add(new Girl(R.drawable.f9, "一星", "****"));
        data.add(new Girl(R.drawable.f10, "一星", "****"));

        onLoadListener.onComplete(data);


        //测试隔离层代码
        String url="https://v.juhe.cn/historyWeather/citys";
        HashMap<String,Object> params=new HashMap<>();
        params.put("province_id","2");
        params.put("key","bb52107206585ab074f5e59a8c73875b");
        HttpHelper.getInstance().post(url, params, new HttpCallback<ResponceData>() {
            @Override
            public void onSuccess(ResponceData responceData) {
                Log.i("Sven",responceData.toString());
            }
        });
    }
}
