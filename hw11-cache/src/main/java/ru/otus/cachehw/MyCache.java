package ru.otus.cachehw;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.SoftReference;
import java.util.*;

import static java.util.Optional.ofNullable;

public class MyCache<K, V> implements HwCache<K, V> {
//Надо реализовать эти методы
    private final Map<K, V> cache = new WeakHashMap<>();
    private final List<SoftReference<HwListener<K, V>>> listeners = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(HWCacheDemo.class);


//    public MyCache() {
//        listeners = new ArrayList<>();
//    }
//    public MyCache(List<HwListener<K, V>> listeners) {
//        this.listeners = listeners;
//    }

    @Override
    public void put(K key, V value) {
        cache.put(key, value);
        notify(key, value, "PUT");
    }

    @Override
    public void remove(K key) {
        V value = cache.remove(key);
        notify(key, value, "REMOVE");
    }

    @Override
    public V get(K key) {
        var value = cache.get(key);
        notify(key, value, "GET");
        return value;
    }

    @Override
    public void addListener(HwListener<K, V> listener) {
        listeners.add(new SoftReference<>(listener));

    }

    @Override
    public void removeListener(HwListener<K, V> listener) {
        for (var softListener : listeners) {
            var currentListener = softListener.get();
            if (listener.equals(currentListener)) {
                listeners.remove(softListener);
            }
            if (listeners.isEmpty()){
                break;
            }
        }

    }

    private void notify(K key, V value, String action) {
        for (var softListener : listeners) {
            var hwListener = softListener.get();
            if (hwListener != null) {
                hwListener.notify(key, value, action);
            } else {
                listeners.remove(softListener);
            }
        }
    }
}
