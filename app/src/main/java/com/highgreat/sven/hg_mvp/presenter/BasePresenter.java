package com.highgreat.sven.hg_mvp.presenter;

import com.highgreat.sven.hg_mvp.view.IGirlView;

import java.lang.ref.WeakReference;

public class BasePresenter<M extends IGirlView> {

    //用弱引用包装view，，这样就可以避免Activity的泄漏
    public WeakReference<M> iGirlView;

    public void attachView(M view){
        iGirlView = new WeakReference<>(view);
    }

    public void detachView(){
        if(iGirlView != null){
            iGirlView.clear();
            iGirlView = null;
        }
    }

}
