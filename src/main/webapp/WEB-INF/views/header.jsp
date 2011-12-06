<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
   "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JavaOne :: FunnyCats</title>
<link rel="stylesheet"
    href="<c:url value="/resources/blueprint/screen.css" />"
    type="text/css" media="screen, projection">
<link rel="stylesheet"
    href="<c:url value="/resources/blueprint/print.css" />" type="text/css"
    media="print">
<!--[if lt IE 8]>
        <link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection">
    <![endif]-->
<style type="text/css">
body {
    font-family: 'Verdana', sans-serif;
    font-size: 1.0em;
}

h1 {
    font-family: 'Georgia', serif;
    font-size: 2.0em;
}

.center {
    text-align: center;
}

div#container {
    width: 900px;
    margin: 20px auto;
}

span.number {
    margin: 0px 12px;
    font-family: 'Georgia', serif;
    font-size: 2.0em;
}

span.number a {
    color: blue;
    text-decoration: none;
    font-size: 1.4em;
}

div#holder {
    margin: 20px 0px;
}

img {
    border: 0px solid;
}
</style>
</head>
<body leftmargin="0" topmargin="0" bottommargin="0" rightmargin="0"
    marginheight="0" marginwidth="0" scroll="yes"
    oncontextmenu="return false" ondragstart="return false"
    onselectstart="return false">
    <div id="container">
        <h1 class="center">FunnyCats</h1>

        <p class="center">
            [ <a href="<c:url value="/ranking" />">View ranking</a> ]
        </p>
