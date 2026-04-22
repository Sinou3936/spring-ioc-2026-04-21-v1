package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestFacadePostService;
import com.ll.domain.testPost.testPost.service.TestPostService;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private Map<String, Object> beans = new HashMap<>();
    private final TestPostService testPostService;
    private final TestPostRepository testPostRepository;
    private final TestFacadePostService testFacadePostService;

    public ApplicationContext() {
        this.testPostRepository = new TestPostRepository();
        this.testPostService = new TestPostService(testPostRepository);
        this.testFacadePostService = new TestFacadePostService(testPostService, testPostRepository);
        beans.put("testPostRepository",testPostRepository);
        beans.put("testPostService",testPostService);
        beans.put("testFacadePostService",testFacadePostService);

    }

    public <T> T genBean(String beanName) {
//        if("testPostRepository".equalsIgnoreCase(beanName))
//            return (T) testPostRepository;
//        else if("testPostService".equalsIgnoreCase(beanName))
//            return (T) beans.get(beanName);
//        else if("testFacadePostService".equalsIgnoreCase(beanName))
//            return (T)  testFacadePostService;
//        return null;
        return  (T) beans.get(beanName);

    }
}
