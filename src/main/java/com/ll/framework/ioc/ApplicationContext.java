package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestFacadePostService;
import com.ll.domain.testPost.testPost.service.TestPostService;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private final Map<String, Object> beanRegistry = new HashMap<>();

    public ApplicationContext() {
        TestPostRepository testPostRepository = new TestPostRepository();
        TestPostService testPostService = new TestPostService(testPostRepository);
        TestFacadePostService testFacadePostService =
                new TestFacadePostService(testPostService, testPostRepository);

        beanRegistry.put("testPostRepository", testPostRepository);
        beanRegistry.put("testPostService", testPostService);
        beanRegistry.put("testFacadePostService", testFacadePostService);
    }

    public <T> T genBean(String beanName) {
        return (T) beanRegistry.get(beanName);
    }
}