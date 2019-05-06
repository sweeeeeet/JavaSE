package com.github.sweeeeeet.poem.crawler;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.github.sweeeeeet.poem.crawler.common.Page;
import com.github.sweeeeeet.poem.crawler.parse.DataPageParse;
import com.github.sweeeeeet.poem.crawler.parse.DocumentParse;
import com.github.sweeeeeet.poem.crawler.parse.Parse;
import com.github.sweeeeeet.poem.crawler.pipeline.ConsolePipeline;
import com.github.sweeeeeet.poem.crawler.pipeline.Pipeline;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author:sweet
 * Created:2019/4/25
 */
public class Crawler {
    /*
     * 放置文档页面（超链接）
     * 放置详情页面
     *
     * 未被采集和解析的页面
     * page html dataSet

     * */
    private Queue<Page> docPage = new LinkedBlockingDeque<>();

    /*
     *  放置详情页面(处理完成，数据在dataSet)
     * */
    private Queue<Page> detailPage = new LinkedBlockingDeque<>();

    /*
     * 采集器
     * */
    private WebClient webClient;

    /*
     * 所有的解析器
     * */
    private List<Parse> parseList = new LinkedList<>();

    /*
     * 所有的清洗器
     * */
    private List<Pipeline> pipelineList = new LinkedList<>();

    /*
     * 线程地调度器
     * */
    private final ExecutorService executorService;


    public Crawler() {
        this.webClient = new WebClient();
        this.webClient.getOptions().setJavaScriptEnabled(false);
        this.executorService = Executors.newFixedThreadPool(8, new ThreadFactory() {
            private final AtomicInteger id = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("Crawler-Thread-" + id.getAndIncrement());
                return thread;
            }
        });
    }

    public void addParse(Parse parse) {
        this.parseList.add(parse);
    }

    public void addPipeline(Pipeline pipeline) {
        this.pipelineList.add(pipeline);
    }

    public void start() {
//爬取
        //解析
        //清洗
        this.executorService.submit(() -> parse());
        this.executorService.submit(() -> pipeline());
    }

    private void parse() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //一开始只包含 base path detail htmlpage
            final Page page = this.docPage.poll();
            if (page == null) {
                continue;
            }

            //使用多线程提交任务，解析数据
            this.executorService.submit(() -> {
                try {
                    //采集信息
                    //在匿名内部类中通过类名访问对象
                    HtmlPage htmlPage = Crawler.this.webClient
                            .getPage(page.getUrl());
                    page.setHtmlPage(htmlPage);
                    for (Parse parse : Crawler.this.parseList) {
                        parse.parse(page);
                    }

                    if (!page.isDetail()) {
                        //如果包含超链接
                        Iterator<Page> iterator = page.getSubPage().iterator();
                        while (iterator.hasNext()) {
                            Page subPage = iterator.next();
                            Crawler.this.docPage.add(subPage);
                            iterator.remove();
                        }
                    } else {
                        //如果是详情页面，就加到已经处理好的队列中
                        Crawler.this.detailPage.add(page);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });


        }
    }

    private void stop() {
        if (this.executorService != null && this.executorService.isShutdown()) {
            this.executorService.shutdown();
        }
    }


    private void pipeline() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            final Page page = this.detailPage.poll();
            if (page == null) {
                continue;
            }
            this.executorService.submit(() -> {
                for (Pipeline pipeline :Crawler.this.pipelineList) {
                    pipeline.pipeline(page);
                }
            });

        }
    }





    public void addPage(Page page) {
        this.docPage.add(page);
    }
}
