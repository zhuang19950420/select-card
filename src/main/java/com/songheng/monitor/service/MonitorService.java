package com.songheng.monitor.service;

import com.songheng.monitor.utils.Httputil;
import com.songheng.monitor.utils.LoadConf;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;


@Service
public class MonitorService {
    public List<HashMap> getIsalive() {
        LoadConf loadConf = null;
        try {
            loadConf = new LoadConf();
        } catch (IOException e) {
            System.out.println("读取配置文件错误==");
            e.printStackTrace();
        }

        List<HashMap> list = new LinkedList<>();
        BlockingQueue<String> queue=new LinkedBlockingQueue<>();
        String[] urls=loadConf.getProperty("jiekouUrl").split("%&%");
        for (int i = 0; i < urls.length ; i++) {
            queue.offer(urls[i]);
        }

        ExecutorService handleThreadPool = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 8; i++) {
            handleThreadPool.execute(()->{
                while (true) {
                    HashMap<String,String> hashMap=new HashMap<>();
                    String url = queue.poll();
                    System.out.println(url);
                    if (url==null){
                        break;
                    }
                    String type = Httputil.sendGet(url, "");
                    type=type.equals("yes")?"true":"false";
                    System.out.println(type);
                    hashMap.put("url", url);
                    hashMap.put("type", type);
                    synchronized (list){
                        list.add(hashMap);
                    }
                }
            });
        }
        //十秒执行不完直接退出
        handleThreadPool.shutdown();
        try {
            handleThreadPool.awaitTermination(10,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }
}
