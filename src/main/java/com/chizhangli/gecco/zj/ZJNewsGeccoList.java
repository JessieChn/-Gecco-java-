package com.chizhangli.gecco.zj;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HrefBean;
import com.geccocrawler.gecco.spider.HtmlBean;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

@Gecco(matchUrl = "https://zj.zjol.com.cn/",pipelines = "zjNewsListPipeLines")
public class ZJNewsGeccoList implements HtmlBean{

    @Request
    private HttpRequest request;

    @HtmlField(cssPath = "#news_list_cons h2 a[href*=news]")
    private List<HrefBean> newList;

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public List<HrefBean> getNewList() {
        return newList;
    }

    public void setNewList(List<HrefBean> newList) {
        this.newList = newList;
    }

    public static void main(String[] args) {
/*        Connection connect = Jsoup.connect("https://zj.zjol.com.cn/");
        connect.timeout(2000);
        try {
            Document document = connect.get();
            System.out.println(document.select("#news_list_cons h2 a[href*=news]").html());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        GeccoEngine.create()
                //工程的包路径
                .classpath("com.chizhangli.gecco.zj")
                //开始抓取的页面地址
                .start("http://zj.zjol.com.cn/")
                //开启几个爬虫线程
                .thread(1)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(1000)
                //使用pc端userAgent
                .mobile(false)
                //开始运行
                .run();
        System.out.println("END!!!");
    }





}
