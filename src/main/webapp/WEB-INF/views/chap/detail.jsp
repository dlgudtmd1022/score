<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>${score.studentNumber}번 학생의 정보</h1>

    <table class="table table-hover">
        <tr>
            <td>이름</td>
            <td>${score.name}</td>
        </tr>
        <tr>
            <td>국어</td>
            <td>${score.korScore}점</td>
        </tr>
        <tr>
            <td>수학</td>
            <td>${score.mathScore}점</td>
        </tr>
        <tr>
            <td>영어</td>
            <td>${score.engScore}점</td>
        </tr>
        <tr>
            <td>총점</td>
            <td>${score.korScore + score.mathScore + score.engScore}점</td>
        </tr>
        <tr>
            <td>평균</td>
            <td>${(score.korScore + score.mathScore + score.engScore) / 3}점</td>
        </tr>
    </table>
    <a href="/score/list" class="btn btn-primary">리스트로 돌아가기</a>
    <form action="/score/remove" method="POST">
        <input type="hidden" name="studentNumber" value="${score.studentNumber}">
        <input type="submit" class="btn btn-secondary" value="삭제하기">
    </form>
</div>
</body>
</html>
