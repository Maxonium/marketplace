<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>marketplace</title>
</head>
<body>
<h1>Marketplace</h1><hr>
<h4>Подробная информация о товаре</h4>
<#list images as img>
    <img src="/images/${img.id}" height="60px"/><br><br>
</#list>
<b>Название товара: </b>${productEntity.title}<br>
<b>Описание товара: </b>${productEntity.description}<br>
<b>Цена: </b>${productEntity.price}<br>
<b>Город: </b>${productEntity.city}<br>
<b>Автор: </b>${productEntity.author}<br>
<hr>
<form action="/product/delete/${productEntity.id}" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Удалить товар"/>
</form>
</body>
</html>