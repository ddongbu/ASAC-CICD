# Node.js_api

1. express-generator 설치

Express Application Generator Tool : 사용자가 손쉽게 프로젝트를 생성할 수 있도록 도와주는 웹 애플리케이션 프레임워크
// express-generator를 설치합니다.
npm install -g express-generator

// 현재 디렉토리에 myapp디렉토를 생성하고 기본 코드들을 자동으로 생성
express --no-view projectname

// myapp디렉토리로 이동후 기본 패키지들을 설치
cd projectname
npm install
1-1. views의 내용중 index.jade를 참조하자면
extends layout

block content
  h1= title
  p Welcome to #{title}
필자에게는 생소한 언어였다.

2. 서버 실행
http://localhost:3000/



3. 프로젝트 루트 폴더 내용



express를 통해 프로젝트를 생성하면 아래와 같은 구성이 생성된다.

bin/www
웹 서버 구축에 관한 파일, 포트번호 등

node_modules
Node.js 모듈

public
정적 파일을 위한 폴더로서 자바스크립트 파일, 이미지 파일, CSS 등

routes
라우팅 리소스 별로 모듈을 만들어서 라우팅 조직을 구현
클라이언트의 요청별로 어떤 로직을 수행할 지 정해놓는 파일
ex) java controller

view
request 요청에 대한 로직을 처리한 후 클라이언트에 응답을 보낼 때 html 코드로 변환해서 반환하는 파일을 정의

app.js
express 설정 정보가 담겨져 있는 파일

package.json
프로젝트 이름, 버전, dependencies, 모듈 등 기술된 파일

4. 기본페이지 접근의 라우트 설정

var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

module.exports = router;
기본적으로 서버주소:포트번호/ 의 /로 접속했을때 "router.get('/')"
res.render로 index를 사용하는 것

5. route에 get과 post 추가

GET

/* GET nodejs-api test. */
router.get("/api/get/nodejs-api", function (req, res) {
 res.status(200).json({
   message: "hello get api nodejs-api",
 });
});
POST

router.post('/api/post/nodejs-api',function(req, res){
	res.status(200).json({
    	"message" : "hello post api nodejs-api"
    });    
});    
GET방식과 POST방식 두가지를 추가해주었는데 말그대로

서버주소:포트번호/api/post/nodejs-api
서버주소:포트번호/api/get/nodejs-api

코드

var express = require("express");
var router = express.Router();

/* GET home page. */
router.get("/", function (req, res, next) {
  res.render("index", { title: "Express" });
});
/* GET nodejs-api test. */
router.get("/api/get/nodejs-api", function (req, res) {
  res.status(200).json({
    message: "hello get api nodejs-api",
  });
});

/* POST nodejs-api test. */
router.post("/api/post/nodejs-api", function (req, res) {
  res.status(200).json({
    message: "hello post api nodejs-api",
  });
});
module.exports = router;
6. 서버 재 가동

npm start
GET방식 http://localhost:3000/api/get/nodejs-api
확인완료



POST 방식은 POSTMAN으로 확인 완료
