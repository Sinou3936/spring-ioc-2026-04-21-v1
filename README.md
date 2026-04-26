Spring IoC Container Clone (v1)
📌 프로젝트 개요

Spring의 핵심 개념인 IoC(Inversion of Control) 와
DI(Dependency Injection) 를 직접 구현해보는 프로젝트입니다.

ApplicationContext를 통해 객체를 생성하고 관리하며,
싱글톤 패턴과 의존성 주입을 구현했습니다.

⚙️ 주요 기능
1. Bean 생성
   ApplicationContext에서 객체를 생성하고 관리
2. Singleton 관리
   동일한 Bean 요청 시 동일 객체 반환
3. 의존성 주입 (DI)
   생성자를 통한 의존성 주입 구현
   🧪 테스트

ApplicationContextTest 기준

ApplicationContext 생성
testPostService 빈 생성
Singleton 검증
testPostRepository 빈 생성
의존성 주입 검증
Facade 의존성 주입 검증

👉 모든 테스트 통과

📂 핵심 코드
private final Map<String, Object> beanRegistry = new HashMap<>();
Bean을 Map으로 관리하여 싱글톤 유지
return (T) beanRegistry.get(beanName);
이름 기반으로 Bean 조회

🔥 구현 흐름 (TDD)
t1: ApplicationContext 생성
t2: Service Bean 생성
t3: Singleton 검증
t4: Repository Bean 추가
t5: Service DI 확인
t6: Facade DI 구현