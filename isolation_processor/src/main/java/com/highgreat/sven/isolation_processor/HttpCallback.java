package com.highgreat.sven.isolation_processor;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class HttpCallback<Result> implements ICallback {
    
    @Override
    public void onSuccess(String result) {//result就是网络回来的数据
        //result把转换成用户需要的对象
        Gson gson = new Gson();
        //需要得到用户输入的对象对应的字节码是什么样的
        //得到用户接收数据的对象对应的class
        Class<?> clz=analysisClassInfo(this);

        Result objResult = (Result) gson.fromJson(result,clz);
        //把已经转好的对象交给客户
        onSuccess(objResult);
    }

    public abstract void onSuccess(Result objResult);


    private Class<?> analysisClassInfo(HttpCallback<Result> resultHttpCallback) {
        //getGenericSuperclass可以得到包含原始类型,参数化类型,数组,类型变量,基本数据
        Type genType = resultHttpCallback.getClass().getGenericSuperclass();
        //获取参数化类型（泛型）
        Type[] typeArguments = ((ParameterizedType) genType).getActualTypeArguments();
        return (Class<?>) typeArguments[0];

    }

    @Override
    public void onFailure(String e) {

    }
}
