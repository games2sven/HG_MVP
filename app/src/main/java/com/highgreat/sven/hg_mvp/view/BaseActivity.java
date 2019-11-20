package com.highgreat.sven.hg_mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.highgreat.sven.hg_mvp.presenter.BasePresenter;

/**
 * 子类继承，并实现抽象方法，让子类自己选择表示层（presenter）
 */
public abstract class BaseActivity<T extends BasePresenter,V extends IGirlView> extends AppCompatActivity {

    public T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //有继承的子类Activity选择一个表示层
        presenter=createPresenter();
        presenter.attachView((V)this);
    }

    public abstract T createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.detachView();
    }
}
