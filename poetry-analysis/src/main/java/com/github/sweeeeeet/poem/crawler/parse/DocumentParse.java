package com.github.sweeeeeet.poem.crawler.parse;

import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.github.sweeeeeet.poem.crawler.common.Page;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * Author:sweet
 * Created:2019/4/25
 */
public class DocumentParse  implements Parse {
    @Override
    public void parse(Page page) {
        if (page.isDetail()) {
            return;
        }
        HtmlPage htmlPage = page.getHtmlPage();
        htmlPage.getBody()
                .getElementsByAttribute("div", "class",
                        "typecont").forEach(div -> {
            DomNodeList<HtmlElement> nodeList =
                    div.getElementsByTagName("a");
            nodeList.forEach(
                    aNode -> {
                        String path = aNode.getAttribute("href");
                        // page.setPath(path);
                        Page subPage = new Page(page.getBase(), path, true);
                        page.getSubPage().add(subPage);
                    }
            );


        });
    }
}
