package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestFacadePostService;
import com.ll.domain.testPost.testPost.service.TestPostService;

import java.lang.reflect.Field;
import java.util.HashMap;

public class ApplicationContext {

    private final HashMap<String, Object> beansRegistry = new HashMap<>();

    public ApplicationContext() {
        createBean("testPostRepository", TestPostRepository.class);
        createBean("testPostService", TestPostService.class);
        createBean("testFacadePostService", TestFacadePostService.class);
        //생성자 생길때 빈 생성후 의존성 주입
        injectDependencies();
    }

    public <T> T genBean(String beanName) {
        Object bean = beansRegistry.get(beanName);
        if(bean == null) {
            throw new RuntimeException("빈을 찾을 수 없음: " + beanName);
        }
        return (T) bean;

    }
    //map에 빈 등록
    private void createBean(String beanName, Class clazz) {
        try {
            Object beanInstance = clazz.getDeclaredConstructor().newInstance();
            beansRegistry.put(beanName, beanInstance);
        }catch (Exception e) {
            throw new RuntimeException("빈 생성 실패: " + beanName, e);
        }
    }
    //의존성 주입을 위해서 만든 함수
    private void injectDependencies(){

        beansRegistry.values().forEach(bean -> {

            Field[] fields = bean.getClass().getDeclaredFields();
            for(Field field : fields) {
                String dependencyBeanName = field.getName(); //필드명을 빈 이름으로 사용
                Object dependencyBean = beansRegistry.get(dependencyBeanName); //빈 레지스트리에서 의존성 빈 가져오기

                if(dependencyBean != null) {
                    field.setAccessible(true); //필드 접근 허용
                    try {
                        field.set(bean, dependencyBean); //의존성 주입
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("의존성 주입 실패: " + dependencyBeanName, e);
                    }
                }
            }

        });
    }
}
