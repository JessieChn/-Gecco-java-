package com.chizhangli.gecco.zj;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;

@PipelineName("zJNewsDetailPipelines")
public class ZJNewsDetailPipelines implements Pipeline<ZJNewsDetail>{
    public void process(ZJNewsDetail zjNewsDetail) {
        System.out.println(zjNewsDetail.getTitle());
        System.out.println(zjNewsDetail.getContent());
    }
}
