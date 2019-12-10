package com.finger.desgin.flyweight.webSiteDemo;

import java.util.HashMap;
import java.util.Map;

public class WebSiteFactory {

    private Map<String,Website> pool=new HashMap<String, Website>();

    public Website getWebsite(String key){
        if(!pool.containsKey(key)){
            pool.put(key,new ConcreateWebsite(key));
        }
        return pool.get(key);
    }

    /**
     * 获得网站分类总数
      * @return
     */
    public int getPoolSize(){
        return pool.size();
    }

}
