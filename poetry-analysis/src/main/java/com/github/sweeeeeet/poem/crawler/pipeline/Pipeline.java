package com.github.sweeeeeet.poem.crawler.pipeline;

import com.github.sweeeeeet.poem.crawler.common.Page;

/**
 * Author:sweet
 * Created:2019/4/25
 */
public interface Pipeline {
    void pipeline(Page page);
}
