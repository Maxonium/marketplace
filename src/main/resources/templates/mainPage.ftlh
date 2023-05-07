<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>marketplace</title>
</head>
<body>
<h1>Marketplace</h1><hr>
<h4>Все объявления</h4>
<#list productEntities as productEntity>
    <div>
        <p><b>${productEntity.title}<b/> ${productEntity.price} руб. | <a href="/product/${productEntity.id}">Подробнее...</a></p>
    </div>
</#list>
<hr>
<h3>Создать новый товар</h3>
<form action="/product/create" method="post">
    Название объявления: <input type="text" name="title"/><br><br>
    Описание объявления: <input type="text" name="description"/><br><br>
    Цена: <input type="number" name="price"/><br><br>
    Город: <input type="text" name="city"/><br><br>
    Создал: <input type="text" name="author"/><br><br>
    <input type="submit" value="Добавить товар"/>
</form>
</body>
</html>