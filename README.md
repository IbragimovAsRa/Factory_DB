# FactoryDB
Furniture factory database
![github-small](https://github.com/IbragimovAsRa/FactoryDB/blob/develop/img/database_structure.png)

Description
--
База данных мебельной фабрики имеет следущие сущности:
- заказы (orders)
- оборудование (equpments)
- изделие (products)
- метериалы для производства изделия (materials)

Файлы
- coma_create.sql
(код для создания БД)
- coma_insert.sql
(код для заполнения БД)
- coma_request.sql
(код sql запросов к БД (пока без cte))

### API

| Method name | Path | Description |
| ----------- | ---- | ----------- |
| GET | /orders/ | Получить все заказы |
| GET | /orders/{id} | Получить заказ по id |
| GET | /materials/ | Получить все материалы |
| GET | /materials/{id} | Получить материал по id | 
| GET | /products/ | Получить все изделия |
| GET | /products/{id} | Получить изделие по id |
| POST | /materials/ | Добавить новый материал |
| POST | /products/ | Добавить новое изделие|
| POST | /orders/ | Добавить новый заказ|
| DELETE | /products/{id} | Удалить изделие по его id|
| DELETE | /materials/{id} | Удалить материал по его id|
| DELETE | /orders/{id} | Удалить заказ по его id|

