package com.lzk;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Created by lzk on 2018/7/4 19:35
 * Description:
 */
public class bbb {
        public static void main(String[] args) throws IOException {
        Html html = new Html();
        String url = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2015/index.html";
        Document document = html.getHtmlTextByUrl(url);
//        html.Save_Html(url,"aa");
//        Elements elements = html.getEleByClass(document,"tr.provincetr");
//        for (Element element :elements){
//            System.out.println(element.text());
//        }

        Elements elements1 = document.select("tr[class=provincetr]");
            for (Element element :elements1){
                System.out.println(element);
            }
    }
}
