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

    public ApplicationContext() {
        this.testPostService = new TestPostService();
        beans.put("testPostService",testPostService);
        this.testPostRepository = new TestPostRepository();
    }

    public <T> T genBean(String beanName) {
        if("testPostRepository".equalsIgnoreCase(beanName))
            return (T) testPostRepository;
        else if("testPostService".equalsIgnoreCase(beanName))
            return (T) beans.get(beanName);
        return null;

    }
}
