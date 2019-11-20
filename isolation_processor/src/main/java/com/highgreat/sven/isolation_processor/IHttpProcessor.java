package com.highgreat.sven.isolation_processor;

import java.util.Map;

/**
 * 功能定义
 */

public interface IHttpProcessor {

    /**
     * 网络操作  get post del update put select.......
     */
    void post(String url, Map<String,Object> params, ICallback callback);

}
