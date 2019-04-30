package com.github.sweeeeeet.poem;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.sweeeeeet.poem.config.ConfigProperties;
import com.github.sweeeeeet.poem.crawler.Crawler;
import com.github.sweeeeeet.poem.crawler.common.Page;
import com.github.sweeeeeet.poem.crawler.parse.DataPageParse;
import com.github.sweeeeeet.poem.crawler.parse.DocumentParse;
import com.github.sweeeeeet.poem.crawler.pipeline.ConsolePipeline;
import com.github.sweeeeeet.poem.crawler.pipeline.DatabasePipeline;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * 诗词分析程序的主类
 * Author:sweet
 * Created:2019/4/24
 */


// 6/9
public class PoetryAnalysisAppliation {
    public static void main(String[] args) throws IOException {

        ConfigProperties configProperties=new ConfigProperties();

        final Page page = new Page(
                configProperties.getCrawlerBase(),
                configProperties.getCrawlerPath(),
                configProperties.isCrawlerDetail());

        Crawler crawler = new Crawler();
        crawler.addParse(new DocumentParse());
        crawler.addParse(new DataPageParse());
        DruidDataSource dataSource=new DruidDataSource();
         dataSource.setUsername(configProperties.getDbUsername());
         dataSource.setPassword(configProperties.getDbPassword());
         dataSource.setDriverClassName(configProperties.getDbDriverClass());
         dataSource.setUrl(configProperties.getDbUrl());
        crawler.addPipeline(new DatabasePipeline(dataSource));
        crawler.addPage(page);
        crawler.start();
    }
}
