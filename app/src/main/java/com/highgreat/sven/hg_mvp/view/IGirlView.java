package com.highgreat.sven.hg_mvp.view;


import com.highgreat.sven.hg_mvp.bean.Girl;

import java.util.List;

/**
 * UI逻辑定义
 */
public interface IGirlView {
    //显示图片(回调函数)
    void showGirlView(List<Girl> girls);


}
