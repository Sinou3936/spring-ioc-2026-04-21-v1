package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestFacadePostService;
import com.ll.domain.testPost.testPost.service.TestPostService;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private final TestPostService testPostService;
    private final TestPostRepository testPostRepository;
    private final TestFacadePostService testFacadePostService;

    public ApplicationContext() {
        this.testPostRepository = new TestPostRepository();
        this.testPostService = new TestPostService(testPostRepository);
        this.testFacadePostService = new TestFacadePostService(testPostService, testPostRepository);

    }

    public <T> T genBean(String beanName) {
       if("testPostService".equalsIgnoreCase(beanName))
           return (T) testPostService;
       else if("testPostRepository".equalsIgnoreCase(beanName))
           return (T) testPostRepository;
       else if("testFacadePostService".equalsIgnoreCase(beanName))
           return (T) testFacadePostService;
       else
           return null;

    }
}
