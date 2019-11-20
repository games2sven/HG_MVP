package com.highgreat.sven.hg_mvp;


import android.os.Bundle;
import android.widget.ListView;

import com.highgreat.sven.hg_mvp.adapter.GirlAdapter;
import com.highgreat.sven.hg_mvp.bean.Girl;
import com.highgreat.sven.hg_mvp.presenter.GirlPresenter;
import com.highgreat.sven.hg_mvp.view.BaseActivity;
import com.highgreat.sven.hg_mvp.view.IGirlView;

import java.util.List;

public class MainActivity extends BaseActivity<GirlPresenter<IGirlView>,IGirlView> implements IGirlView {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        presenter.fetch();

    }

    /**
     * 表示层的选择就在这个方法中实现
     * @return
     */
    @Override
    public GirlPresenter<IGirlView> createPresenter() {
        return new GirlPresenter<>();
    }

    /**
     * UI逻辑
     * @param girls
     */
    @Override
    public void showGirlView(List<Girl> girls) {
        listView.setAdapter(new GirlAdapter(this,girls));
    }
}
