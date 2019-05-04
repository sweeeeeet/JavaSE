package com.github.sweeeeeet.poem.crawler.parse;

import com.gargoylesoftware.htmlunit.html.*;
import com.github.sweeeeeet.poem.crawler.common.Page;

/**
 * Author:sweet
 * Created:2019/4/25
 */
public class DataPageParse implements Parse {
    /** 
    * @Description: 详情页面解析 
    * @Param:  
    * @return:  
    */
    @Override
    public void parse(Page page) {
        if(!page.isDetail()){
            return;
        }
//        //取得标签
//      HtmlDivision division= (HtmlDivision) page.getHtmlPage().getElementById("contson5d405a1d5b64");
//        //取得正文
//        String content=division.asText();
//
//        page.getDataSet().putData("正文",content);
//利用xpath定位标签，解析出数据
     HtmlPage htmlPage= page.getHtmlPage();
        HtmlElement body=htmlPage.getBody();
     //标题
     String titlePath="//div[@class='cont']/h1/text()";
    DomText titleDom= (DomText) body.getByXPath(titlePath).get(0);
    String tile=titleDom.asText();
        //朝代
        String dynastyPath="//div[@class='cont']/p[@class='source']/a[1]";
        HtmlAnchor dynastyDom=(HtmlAnchor)body.getByXPath(dynastyPath).get(0);
        String dynasty=dynastyDom.asText();
     //作者
        String authorPath="//div[@class='cont']/p[@class='source']/a[2]";
      HtmlAnchor authorDom=(HtmlAnchor)body.getByXPath(authorPath).get(0);
String author=authorDom.asText();
        //正文
        String contentPath="//div[@class='cont']/div[@class='contson']";
      HtmlDivision contentDom=(HtmlDivision)  body.getByXPath(contentPath).get(0);
      String content=contentDom.asText();


        page.getDataSet().putData("author",author);
        page.getDataSet().putData("title",tile);
        page.getDataSet().putData("dynasty",dynasty);
        page.getDataSet().putData("content",content);

        //更多的数据

    }
}
