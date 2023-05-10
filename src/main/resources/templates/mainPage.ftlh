<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>marketplace</title>
</head>
<body>
<h1>Marketplace</h1><hr>
<h4>Все объявления</h4>
<form action="/" method="get">
    Поиск по названию объявления: <input type="text" name="title"><br>
    <input type="submit" value="Поиск"/>
</form>
<#list productEntities as productEntity>
    <div>
        <p><b>${productEntity.title}<b/> ${productEntity.price} руб. | <a href="/product/${productEntity.id}">Подробнее...</a></p>
    </div>
    <#else>
        <h3>Товаров нет</h3>
</#list>
<hr>
<h3>Создать новый товар</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    Название объявления: <input type="text" name="title"/><br><br>
    Описание объявления: <input type="text" name="description"/><br><br>
    Цена: <input type="number" name="price"/><br><br>
    Город: <input type="text" name="city"/><br><br>
    Создал: <input type="text" name="author"/><br><br>
    Первая фотография: <input type="file" name="file1"/><br><br>
    Вторая фотография: <input type="file" name="file2"/><br><br>
    Третья фотография: <input type="file" name="file3"/><br><br>
    <input type="submit" value="Добавить товар"/>
</form>
</body>
</html>