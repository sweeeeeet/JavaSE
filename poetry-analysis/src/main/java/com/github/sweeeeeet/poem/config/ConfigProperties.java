package com.github.sweeeeeet.poem.config;

import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Author:sweet
 * Created:2019/4/26
 */
@Data
public class ConfigProperties {
    private String crawlerBase;
    private String crawlerPath;
    private boolean crawlerDetail;

    private String dbUsername;
    private String dbPassword;
    private String dbUrl;
    private String dbDriverClass;

    public ConfigProperties() {
        //从外部文件加载
        InputStream inputStream =
                ConfigProperties.class.getClassLoader().getResourceAsStream("config.properties");
        Properties p = new Properties();
        try {
            p.load(inputStream);
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.crawlerBase = String.valueOf(p.get("crawler.Base")) ;
        this.crawlerPath = String.valueOf(p.get("crawler.Path")) ;
        this.crawlerDetail =
                Boolean.parseBoolean(String.valueOf(p.get("crawler.Detail")));
        this.dbUsername = (String) p.get("db.Username");
        this.dbPassword = (String) p.get("db.Password");
        this.dbUrl = (String) p.get("db.Url");
        this.dbDriverClass = (String) p.get("db.DriverClass");
    }

    public static void main(String[] args) {
        new ConfigProperties();
    }
}
