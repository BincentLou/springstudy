<?xml version="1.0" encoding="UTF-8" ?>
<jsp:directive.page language="java" contentType="text/html; charset=UTF-8"
                    pageEncoding="UTF-8" />
<html>
    <header>

    </header>
    <body>
        \${user.name} : ${user.name}
        \${user.id} : ${user.id}
        \${user.id} : ${applicationScope['scopedTarget.singletonUser'].id}
        \${user.name} : ${applicationScope['scopedTarget.singletonUser'].name}
    </body>
</html>