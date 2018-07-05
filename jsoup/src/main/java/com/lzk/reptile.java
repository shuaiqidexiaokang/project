package com.lzk;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by lzk on 2018/7/3 19:11
 * Description:三钟爬虫方式
 */
public class reptile {
    public static void main(String[] args) throws IOException {
//        /*方式一：通过urlconnection抓取信息：*/
        String r;
        try {
            //1.新建url对象，表示要访问的网页
            URL url = new URL("http://www.sina.com.cn");
            //2.建立http连接,返回连接对象urlconnection
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //3.获取相应的http状态码，
            int responseCode= urlConnection.getResponseCode();
            //4.如果获取成功，从URLconnection对象获取输入流来获取请求网页的源代码
            if(responseCode == 200){
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                while((r=reader.readLine())!=null){
                    System.out.println(r);
                }
            }else{
                System.out.println("获取不到源代码 ，服务器响应代码为："+responseCode);
            }
        } catch (Exception e) {
            System.out.println("获取不到网页源码："+e);
    }

        /*方式二：通过httpclient抓取信息：*/
        String url1 = "http://www.baidu.com";
        HttpClient httpClient = new HttpClient();
        GetMethod getMethod = new GetMethod(url1);
        int statusCode = httpClient.executeMethod(getMethod);
        if (statusCode == HttpStatus.SC_OK){
            System.out.println("response="+getMethod.getResponseBodyAsString());
        }

        /*方式三：通过jsoup获取网页信息：*/
        String url2 = "http://www.baidu.com";
        Document document = Jsoup.connect(url2).timeout(3000).get();
        //通过Document的select方法获取属性结点集合
        Elements elements = document.select("a");
        //得到节点的第一个对象
        //Element element = elements.get(0);
        System.out.println(elements);
    }
}
