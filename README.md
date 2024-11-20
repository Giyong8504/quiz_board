# Quiz Board

----
## 주제 선정
- 회원 CRUD 게시판에 다양한 주제의 퀴즈를 풀어볼 수 있고 토론해 볼 수 있는 게시판
- 회원만 게시글 작성 가능하며 권한을 부여해 관리자 페이지를 만들어 관리할 수 있는 퀴즈 게시판 서비스를 선정

---
## 개요
- 프로젝트명 : Quiz Board
- 개발 인원 : 1명
- 개발 기간 : 2024.11.20 ~
- 주요 기능
    - 게시판 : CRUD 기능, 댓글, 게시글 검색, 퀴즈 게시판
    - 일반회원 : 회원가입 및 로그인
        - 이메일 검증을 통한 회원가입
        - 유효성 검사
        - 마이페이지
        - 비밀번호 찾기, 변경, 탈퇴
        - 퀴즈 게시판 이용 가능
    - 관리자 : 권한을 부여하여 일반 회원과 게시글 조회, 삭제
        - 퀴즈 생성, 조회, 수정, 삭제

---

### Stack
![java-icon](https://github.com/Giyong8504/memberBoard/assets/128211712/a6104f4d-e299-4017-8617-6863fb9abe73)Java(17)
![spring-icon](https://github.com/Giyong8504/memberBoard/assets/128211712/fdaaaeb8-b2d9-424b-8b54-fdf2d7f6dcf9)Spring
![springboot-icon](https://github.com/Giyong8504/memberBoard/assets/128211712/7bd6f139-e97e-494f-b56a-52ebbfb37893)SpringBoot(3.0.2) + JPA + Lombok + Validation
![thymeleaf-icon](https://github.com/Giyong8504/memberBoard/assets/128211712/251992ab-736a-4669-8dc0-f9ccd231e949)Thymeleaf
![js-icon](https://github.com/Giyong8504/memberBoard/assets/128211712/ab022ed4-e0b6-4a58-a5a0-f4224aa933b6)Javascript
![html-icon](https://github.com/Giyong8504/memberBoard/assets/128211712/45d43c25-78e7-4d87-b499-58ea71136bc4)Html5
![css-icon](https://github.com/Giyong8504/memberBoard/assets/128211712/f1341976-4afc-4487-97c6-cc709cd2413a)Css
![amazon-icon](https://github.com/Giyong8504/memberBoard/assets/128211712/c156fccd-a59b-4f66-aec6-107ba53b11b7)aws


### Tools
![intellij-icon](https://github.com/Giyong8504/memberBoard/assets/128211712/60bb943d-8b2d-4743-bddf-981463b17fc5)IntelliJ
![mysql-icon](https://github.com/Giyong8504/memberBoard/assets/128211712/7e2d7068-2227-4a7d-a2a3-c47e79154351)MySQL
![gradle-icon](https://github.com/Giyong8504/memberBoard/assets/128211712/1cc55962-2a6a-427b-b069-febbfef874b6)Gardle
![git-icon](https://github.com/Giyong8504/memberBoard/assets/128211712/3ddc519c-d58c-4b08-8da0-27ce47ff7e65)Git
![tomcat-icon](https://github.com/Giyong8504/memberBoard/assets/128211712/e5776633-34da-4d8a-8b0c-404196de1821)Tomcat

### Collaboration
![github-icon](https://github.com/Giyong8504/memberBoard/assets/128211712/94861ab3-b104-43a7-ad5b-b89a026498e2)Github
![naverblog](https://github.com/Giyong8504/memberBoard/assets/128211712/a30bea2e-2561-462e-87cf-e5678bb91c26)Blog

---

## 요구사항
- 게시글
    - 글 전체 조회
    - 제목 검색 조회, 내용 조회
    - 작성했던 사용자만 수정, 삭제 가능
    - 로그인하지 않은 상태로 글쓰기 클릭 시 로그인 페이지 이동


- 퀴즈 게시판
    - 전체 조회
    - 회원만 퀴즈 조회
    - 정답 유무 확인
    - 점수 확인


- 댓글
    - 로그인을 한 사용자만 댓글 가능
    - 댓글 작성자만 수정, 삭제 가능


- 회원 가입
    - 이메일 인증
        - DB에 저장된 이메일이 없을 시 메일로 인증코드 전송
        - 가입된 이메일이 있을 시 '이미 가입된 메일입니다' 표시
        - 발급한 인증번호와 세션에 저장한 인증번호가 동일한지 확인
        - 유효 시간 카운트
        - 인증번호 입력 후 '확인된 이메일 입니다.' 표시
        - 인증코드 재전송
    - 유효성 검사
        - 아이디 이메일 형식 확인
        - 비밀번호 잘못 입력 시 비밀번호 8자리 이상 확인
        - 회원명 미 입력 시 확인
        - 휴대전화 번호 형식 확인
        - 회원가입 약관에 동의 받기 체크 여부 확인
    - 중복 확인
        - 이메일 중복 여부 체크
        - 비밀번호, 비밀번호 확인 일치 여부
        - 휴대전화 번호 -> 형식 체크


- 로그인
    - 로그인 검사
        - 이메일 또는 비밀번호가 일치하지 않을 시 "이메일 또는 비밀번호가 일치하지 않습니다." 메시지 노출
    - 로그인하지 않을 경우 접속 가능 페이지
        - 회원가입
        - 로그인
        - 게시글 목록
        - 이 외에 접근 시 로그인 요청 메시지 노출 후 로그인 페이지로 이동


-  Session 로그인 + OAuth2 로그인


- 로그아웃 시
    - HTTP 세션 무효화
    - 사용자 인증정보 제거
    - 쿠키에 담긴 세션, 리프레시 코튼 제거
    - 액세스 토큰 제거


- 비밀번호 찾기
    - 가입한 이메일과 회원명 조합으로 조회 검증
    - 비밀번호 랜덤값으로 초기화
    - 찾기 시 비밀번호 초기화 후 가입한 메일로 전송, 이후 발송 안내 페이지로 이동
    - 초기화된 비밀번호로 로그인
    - 유효성 검사
        - 미가입 회원일 경우 '가입되지 않은 회원입니다' 메시지 노출
        - 구글 연동 로그인 계정일 경우 '구글연동 회원입니다. 구글 계정을 확인해주세요.' 메시지 노출


- 마이페이지
    - 로그인 중인 회원 정보 표시
        - 이메일, 사용자명, 전화번호
    - 비밀번호 변경
        - 유효성 검사
            - NotBlank로 '필수 항목입니다' 표시
            - 기존 비밀번호와 다른지 여부 표시
            - 비밀번호 8자리이상 표시
            - 비밀번호 일치여부 표시
    - 회원탈퇴
        - 유효성검사
            - NotBlank로 '필수 항목입니다' 표시
            - 기존 비밀번호와 다른지 여부 표시
        - 탈퇴 시 탈퇴회원을 다른 엔터티에 저장 후 사용자 삭제


- 관리자
    - 관리자 권한이 있는 사용자만 접속 가능
    - 관리자 권한으로 접속 가능 페이지
        - 사용자 글 목록 리스트 페이지
            - 관리자 권한만 글 삭제
        - 퀴즈 게시글 작성
            - 관리자만 작성, 수정, 삭제 가능
        - 회원 정보
            - 관리자만 USER, DISABLE 권한변경
            - 관리자만 강제 탈퇴 가능

---
## ER 다이어그램

### [eXERD를 사용 ER 다이어그램 링크](https://blog.naver.com/kky5163/223664196794)
![image](https://github.com/user-attachments/assets/f7cec1d3-349a-490a-b0d3-f6943a07b1b1)

---
