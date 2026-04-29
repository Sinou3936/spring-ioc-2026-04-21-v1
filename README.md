# Spring IoC 직접 구현하기

Spring의 IoC(Inversion of Control) 컨테이너를 직접 구현해보는 프로젝트입니다.

## 학습 목표

- IoC(제어의 역전) 개념 이해
- DI(의존성 주입)를 직접 구현하며 원리 파악
- 싱글톤 패턴이 적용된 Bean 관리 방식 이해
- TDD(테스트 주도 개발) 방식으로 단계별 구현

## 기술 스택

- Java
- Gradle (Kotlin DSL)
- JUnit 5
- AssertJ
- Lombok

## 프로젝트 구조

```
src
├── main/java/com/ll
│   ├── framework/ioc
│   │   └── ApplicationContext.java   # IoC 컨테이너
│   └── domain/testPost/testPost
│       ├── repository/TestPostRepository.java
│       └── service
│           ├── TestPostService.java
│           └── TestFacadePostService.java
└── test/java/com/ll/framework/ioc
    └── ApplicationContextTest.java
```

## 구현 내용

### ApplicationContext

직접 구현한 IoC 컨테이너입니다.

- **Bean 등록**: `ApplicationContext` 생성 시 의존성을 직접 주입하여 객체를 생성·등록
- **Bean 조회**: `genBean(beanName)` 메서드로 등록된 Bean을 이름으로 조회
- **싱글톤 보장**: 동일한 이름으로 조회 시 항상 같은 인스턴스를 반환

### 의존성 관계

```
TestFacadePostService
├── TestPostService
│   └── TestPostRepository
└── TestPostRepository
```

## 테스트 시나리오 (TDD)

| 테스트 | 설명 |
|--------|------|
| t1 | `ApplicationContext` 객체 생성 확인 |
| t2 | `testPostService` Bean 조회 |
| t3 | 싱글톤 확인 (같은 Bean을 두 번 조회하면 동일 인스턴스) |
| t4 | `testPostRepository` Bean 조회 |
| t5 | `testPostService`가 `testPostRepository`를 의존성으로 보유 |
| t6 | `testFacadePostService`가 `testPostService`, `testPostRepository` 모두 보유 |

## 실행 방법

```bash
./gradlew test
```