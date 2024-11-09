# DB Connection 과 Spring Transaction 의 관계


## Orders
- `@Service` : 구현체만 존재


## Users
- `@Service` : 추상화를 구현


## 실행방법
**goal** docker 와 jvm 만 설치되어 있다면 바로 실행가능하도록 구성

- openJDK 21

프로젝트 root 경로의 docker-compose.yml 실행
~~~shell
docker compose up -d
~~~


## 모니터링 서버와 연결된 모듈
`play-class` 모듈은 메트릭을 노출하고 있음