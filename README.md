
# Subtitle Generator Project

이 프로젝트는 네이버 CLOVA Speech API를 사용하여 비디오 콘텐츠에 자막을 생성하는 Spring Boot 애플리케이션입니다.

## 시작하기

### 사전 요구 사항
- **Java 17**: 애플리케이션을 실행하기 위한 자바 버전.
- **Maven 3.x**: 프로젝트의 종속성 관리 및 빌드를 위한 빌드 도구.
- **MySQL**: 자막 데이터를 저장하기 위한 데이터베이스.

### 설치 및 설정

1. **프로젝트 클론**
    ```
    git clone https://github.com/your-repo/project.git
    cd project
    ```

2. **프로젝트 빌드**
    Maven을 사용하여 프로젝트를 빌드합니다.
    ```
    mvn clean install
    ```

### 애플리케이션 실행

애플리케이션을 MySQL과 함께 실행하거나, 테스트 목적으로 H2 데이터베이스를 사용할 수 있습니다.

1. **MySQL과 함께 애플리케이션 실행**
    ```
    mvn spring-boot:run -Dspring.profiles.active=mysql
    ```

2. **H2 데이터베이스(테스트용)와 함께 애플리케이션 실행**
    ```
    mvn spring-boot:run -Dspring.profiles.active=h2
    ```

### API 엔드포인트

애플리케이션에서 제공하는 주요 API 엔드포인트는 다음과 같습니다:

- **POST /api/subtitles/generate**
    - 비디오 URL을 통해 자막을 생성합니다.
  
- **GET /api/subtitles**
    - 모든 자막을 조회합니다.
  
- **GET /api/subtitles/{id}**
    - ID로 특정 자막을 조회합니다.
  
- **PUT /api/subtitles/{id}**
    - 자막을 업데이트합니다.
  
- **DELETE /api/subtitles/{id}**
    - 자막을 삭제합니다.
