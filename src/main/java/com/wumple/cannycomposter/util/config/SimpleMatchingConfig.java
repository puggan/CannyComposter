package com.wumple.cannycomposter.util.config;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleMatchingConfig<T> {

    protected final Map<String, T> map;
    public final T FALSE_VALUE;

    public SimpleMatchingConfig(T falseValueIn) {
        map = new HashMap<String, T>();
        FALSE_VALUE = falseValueIn;
    }

    public SimpleMatchingConfig(Map<String, T> configIn, T falseValueIn) {
        map = configIn;
        FALSE_VALUE = falseValueIn;
    }

    public boolean addDefaultProperty(String name, T amountIn) {
        if (name == null) {
            name = "";
        }

        map.putIfAbsent(name, amountIn);

        return true;
    }

    public T getProperty(String key) {
        T amount = null;

        if ((key != null) && map.containsKey(key)) {
            amount = map.get(key);
        }

        return amount;
    }

    @Nullable
    public T getProperty(List<String> keys) {
        T amount = null;

        for (String key : keys) {
            amount = getProperty(key);
            if (amount != null) {
                break;
            }
        }

        return amount;
    }

}