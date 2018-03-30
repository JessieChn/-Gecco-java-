package com.chizhangli.gecco.zj;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl = "https://zj.zjol.com.cn/news/{id}.html",pipelines = "zJNewsDetailPipelines")
public class ZJNewsDetail implements HtmlBean {
    @Request
    private HttpRequest request;

    @RequestParameter
    private String id;

    @HtmlField(cssPath = ".content p")
    private String content;

    @HtmlField(cssPath = ".art_title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
