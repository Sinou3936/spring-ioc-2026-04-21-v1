package com.ll.domain.testPost.testPost.service;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
public class TestFacadePostService {
    private  TestPostService testPostService;
    private TestPostRepository testPostRepository;
}
