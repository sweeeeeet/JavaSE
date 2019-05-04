package com.github.sweeeeeet.poem.crawler.pipeline;

import com.github.sweeeeeet.poem.crawler.common.Page;

import java.util.Map;

/**
 * Author:sweet
 * Created:2019/4/25
 */
public class ConsolePipeline implements Pipeline{

    @Override
    public void pipeline(Page page) {
        Map<String,Object> data =page.getDataSet().getData();
        //存储
        //TODO
        System.out.println(data);
    }
}
