package com.github.sweeeeeet.poem.crawler.common;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:sweet
 * Created:2019/4/25
 */
//@Data注解会自动生成get,set,toString,equals方法
    //如果只想生成get方法，只需在类上声明    @Getter
@Data
public class Page {
    /*
    * 数据网站的根地址，
    * 比如：https://www.gushiwen.org/
    * */
    private final String base;
  //利用lombok自动生成getter setter方法
    @Getter
    @Setter
    /*
    * 具体的网页路径
    * 比如：/shiwenv_5d405a1d5b64.aspx
    * */
    private final String path;

    /*
    * 网页Dom对象
    * */
    private HtmlPage htmlPage;


    /*
    * 标识网页是否详情页
    * */
    private final boolean detail;

    /*
    * 子页面对象集合
    * */
    private Set<Page> subPage=new HashSet<>();

    /*
    * 数据对象
    * */

    private DataSet dataSet=new DataSet();

    public String getUrl(){
        return this.base+this.path;
    }
}
