package com.desafio_junior_backend.itau.estatistica.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CacheUtils<T> {
	
	private List<T> cacheList;
	
	private static CacheUtils instance;

    private CacheUtils() {}

    public static CacheUtils getInstance() {
        if (instance == null) {
            instance = new CacheUtils();
        }
        return instance;
    }
	
	public void addCache(T e) {
		if(cacheList == null) {
			cacheList = new ArrayList<>();
		}
		cacheList.add(e);
	}
	
	public List<T> getChache() {
		if(cacheList == null) return Collections.emptyList();
		return cacheList;
	}
	
	public void limparCache() {
		if(cacheList != null) {
			cacheList.clear();
		}
	}
	
}
