package com.farm.app.utility;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class MapperUtility {

    public static <S, T> T sourceToTarget(S source, Class<T> target) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        T t = target.getDeclaredConstructor().newInstance();
        BeanUtils.copyProperties(source , t);
        return t;
    }
}
