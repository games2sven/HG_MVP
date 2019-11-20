package com.highgreat.sven.hg_mvp.model;

import com.highgreat.sven.hg_mvp.bean.Girl;

import java.util.List;

/**
 * model还是原来的model
 */
public interface IGirlModel {

    void loadGirlData(OnLoadListener onLoadListener);

    interface OnLoadListener{
        void onComplete(List<Girl> girls);
    }

}
