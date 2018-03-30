package com.chizhangli.gecco.zj;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import com.geccocrawler.gecco.spider.HrefBean;

@PipelineName("zjNewsListPipeLines")
public class ZJNewsListPipelines implements Pipeline<ZJNewsGeccoList> {
    public void process(ZJNewsGeccoList zjNewsGeccoList) {
        System.out.println("process~~~");
        HttpRequest httpRequest = zjNewsGeccoList.getRequest();
        for(HrefBean bean:zjNewsGeccoList.getNewList()){
            System.out.println(bean.getUrl() + bean.getTitle());
            SchedulerContext.into(httpRequest.subRequest(bean.getUrl()));
        }
    }
}
