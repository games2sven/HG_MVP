package com.highgreat.sven.hg_mvp.presenter;

import com.highgreat.sven.hg_mvp.bean.Girl;
import com.highgreat.sven.hg_mvp.model.GirlModel;
import com.highgreat.sven.hg_mvp.model.IGirlModel;
import com.highgreat.sven.hg_mvp.view.IGirlView;

import java.util.List;

public class GirlPresenter<T extends IGirlView> extends BasePresenter<T>{

    //持有model
    IGirlModel iGirlModel = new GirlModel();

    //执行UI逻辑
    public void fetch(){
       if(iGirlView.get() != null  && iGirlModel != null){
           iGirlModel.loadGirlData(new IGirlModel.OnLoadListener() {
               @Override
               public void onComplete(List<Girl> girls) {
                   iGirlView.get().showGirlView(girls);
               }
           });
       }
    }


}
