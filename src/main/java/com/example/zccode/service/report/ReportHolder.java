package com.example.zccode.service.report;

import com.example.zccode.bo.ReportBO;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 报表持有者
 *
 * @author lizhuang
 */
public class ReportHolder {

    private static final ConcurrentMap<String, ReportBO> CACHE = new ConcurrentHashMap<>();

    public static ReportBO get(String id){
        if (id != null){
            return CACHE.get(id);
        }

        return null;
    }

    public static void update(String id, ReportBO report){
        if(id !=null && report !=null){
            CACHE.put(id, report);
        }
    }

    public static ReportBO clean(String id){
        if(id!=null){
            return CACHE.remove(id);
        }

        return null;
    }

    public static Map<String, ReportBO> snapshot(){
        return new HashMap<>(CACHE);
    }
}
