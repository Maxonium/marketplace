<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>marketplace</title>
</head>
<body>
    <h1>Marketplace</h1><hr>
    <h4>Подробная информация о товаре</h4>
    <b>Название товара: </b>${productEntity.title}<br>
    <b>Описание товара: </b>${productEntity.description}<br>
    <b>Цена товара: </b>${productEntity.price}<br>
    <b>Город: </b>${productEntity.city}<br>
    <b>Создал: </b>${productEntity.author}<br>
    <hr>
    <h3>Создать новый товар</h3>
    <form action = "/product/delete/${productEntity.id}}" method="post">
        <input type="submit" value="Удалить товар"/>
    </form>
</body>
</html>