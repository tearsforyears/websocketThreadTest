package com.fourspring.springtest;

import com.fourspring.springtest.service.AsyncService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringtestApplicationTests {
    @Autowired
    AsyncService asyncService;

    @Test
    void asyncTest() {
        System.out.println(Thread.currentThread().getName());
        asyncService.aynscTest();
        asyncService.aynscTest2();
        asyncService.normalTest();
    }

//    @Test
//    void buildDoc() {
//        DocsConfig config = new DocsConfig();
//        config.setProjectPath(System.getProperty("user.dir"));
//        config.setProjectName("fourspring");
//        config.setApiVersion("V1.0");
//        config.setDocsPath(System.getProperty("user.dir") + "/docs");
//        config.setAutoGenerate(Boolean.TRUE);
//        config.addPlugin(new MarkdownDocPlugin());
//        // 配置自动生成
//        Docs.buildHtmlDocs(config);
//    }
}
