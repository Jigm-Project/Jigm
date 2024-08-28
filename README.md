<<<<<<< HEAD
가. 주요 기능
ㅇ 웹페이지
1. 네비게이션(Navigation)
사용자가 사이트 내에서 다른 페이지로 쉽게 이동할 수 있게 함 일반적으로 헤더에 위치한 메뉴바(menu bar)나 사이드바(sidebar)에 배치되며, 중요한 페이지로의 링크를 제공
2. 콘텐츠 표시(Content Display)
텍스트, 이미지, 비디오 등 다양한 형태의 콘텐츠를 사용자에게 제공
3. 검색(Search)
사용자들이 필요한 정보를 빠르게 찾을 수 있도록 도와 사이트의 콘텐츠를 검색할 수 있는 검색창을 제공하며, 이는 어떤 언어를 제공하는지, 고객센터 등으로 검색을 가능하게 함
4. 양식 및 입력(Form and Input)
사용자로부터 데이터를 수집하기 위해 양식(form)을 제공, 예를 들어, 로그인/회원가입 폼, 문의 양식, 댓글 입력란 등
이러한 양식으로 균일화 된 데이터들을 데이터베이스와 연동, 정보를 저장하고 처리
5. 반응형 디자인(Responsive Design)
반응형 디자인은 웹페이지가 다양한 기기와 화면 크기에 맞게 조절되는 기능 데스크톱, 태블릿, 스마트폰 등에서 모두 적절하게 보이도록 설계
6. 대화형 요소(Interactive Elements)
대화형 요소는 사용자 경험을 향상시키기 위해 사용 (버튼, 드롭다운 메뉴, 슬라이더, 팝업 등이 포함)
자바스크립트 언어를 사용하여 사용자와의 상호작용을 처리
7. 미디어 통합(Media Integration)
웹페이지는 이미지, 동영상, 오디오 파일을 포함할 수 있으며, 이를 통해 정보를 시각적이고 청각적으로 전달 (사용 방법과 같은 영상들을 배치)
8. 보안(Security)
웹페이지는 사용자의 개인정보와 데이터를 보호하기 위해 보안 기능을 갖추고 있어야 함
HTTPS 사용, 데이터 암호화, 사용자 인증 등
9. 분석 및 통계(Analytics and Metrics)
웹사이트의 성과를 분석하기 위해 트래픽, 사용자 행동, 전환율 등을 추적하는 기능
Google Analytics와 같은 도구를 통해 수집된 데이터를 기반으로 웹사이트의 개선 방향을 설정할 수 있음
또한 사용자 정보를 저장해 Preference를 정할 수 있음
=======

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
>>>>>>> 7f5e71626d089d5f70ba8c452ff813f36bc60132
