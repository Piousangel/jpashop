# jpashop

- 핵심 라이브러리
1. 스프링 MVC
2. 스프링 ORM
3. JPA, 하이버네이트
4. 스프링 데이터 JPA.

- 기타 라이브러리
1. H2 데이터베이스 클라이언트(H2 DB는 개발이나 테스트 용도로 가볍고 편리한 DB, 웹화면을 제공합니다)
2. 커넥션 풀: 부트 기본은 HikariCP
3. WEB(thymeleaf)
4. 로깅 SLF4J & LogBack
5. 테스트

참고: 스프링 데이터 JPA는 스프링과 JPA를 먼저 이해하고 사용해야하는 응용기술이다.

오늘부터 API를 설계하는 공부를 해보겠습니당!
- API 개발
1. 조회용 샘플 데이터 입력
2. 지연 로딩과 조회 성능 최적화
3. 컬렉션 조회 최적화
4. 페이징과 한계 돌파
5. OSIV와 성능 최적화


- 도메인 분석 설계
7. 요구사항 분석
8. 도메인 모델과 테이블 설계
9. 엔티티 클래스 개발
10. 엔티티 설계시 주의점.  -> 기존의 엔티티를 DTO로 변환 , 페치 조인 최적화 작업 -> JPA에서 DTO로 바로(직접) 조회

참고: 외래 키가 있는 곳을 연관관계의 주인으로 정해라.

- 기능 목록

- [x] 회원 기능  Pk값은 long type
  - 회원 등록
  - 회원 조회

- [x] 상품 기능
  - 상품 등록
  - 상품 수정
  - 상품 조회
- [x] 주문 기능
  - 상품 주문
  - 주문 내역 조회
  - 주문 취소 
- [x] 기타 요구사항
  - 상품은 제고 관리가 필요하다.
  - 상품의 종류는 도서, 음반, 영화가 있다.
  - 상품을 카테고리로 구분할 수 있다.
  - 상품 주문시 배송 정보를 입력할 수 있다.
  
  <img width="1006" alt="스크린샷 2021-11-26 오후 9 09 13" src="https://user-images.githubusercontent.com/55525574/143579083-fa181bf6-9ba0-4934-8b0c-14d3d98d527f.png">
  
<img width="1008" alt="Category" src="https://user-images.githubusercontent.com/55525574/143579092-4753513d-72e0-4134-ad71-68f924093e53.png">

<img width="685" alt="스크린샷 2021-11-26 오후 10 35 29" src="https://user-images.githubusercontent.com/55525574/143589112-511a1aae-3b3e-4b49-a4ff-5a9ea7e26614.png">

<img width="802" alt="스크린샷 2021-12-03 오후 11 57 49" src="https://user-images.githubusercontent.com/55525574/144623671-ac40696e-dc9d-4a71-8fc7-8e2dc72d7822.png">

