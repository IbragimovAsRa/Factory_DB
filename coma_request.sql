-- самый востребованный тип станков(equpment)
select equpment_name, count(*) as count
from
(select * from product left join product_to_equpment
    on product.id_product = product_to_equpment.product_id_product) as fir left join equpment as sec
on equpment_id_equpment = sec.id_equpment group by equpment_name;

-- на какую стоимость необходимо закупить  материалов для выполнения n заказа


-- стоимость материалов каждого изделия
(select product_id_product, sum(quantity_entity*unit_price) as materials_price from
product_has_materials
    left join
materials m
    on
m.id_materials = product_has_materials.materials_id_materials
group by product_id_product);

--  какие материлы надо закупить для выполнения n заказа (n=1)
select orders_id_orders, id_product from orders_has_product
left join product p on
    orders_has_product.product_id_product = p.id_product
where orders_id_orders=1;

-- какие материлы надо закупить для выполнения n заказа (n=1) и их стоимость
select * from
(select orders_id_orders, id_product from orders_has_product
left join product p on
    orders_has_product.product_id_product = p.id_product) as a
    left join
(select product_id_product, sum(quantity_entity*unit_price) as materials_price from
product_has_materials
    left join
materials m
    on
m.id_materials = product_has_materials.materials_id_materials
group by product_id_product) as b
on id_product=product_id_product
where orders_id_orders=2;


--  на какую стоимость необходимо закупить  материалов для выполнения n заказа


select orders_id_orders, sum(materials_price) as price_materials from
(select orders_id_orders, id_product from orders_has_product
left join product p on
    orders_has_product.product_id_product = p.id_product) as a
    left join
(select product_id_product, sum(quantity_entity*unit_price) as materials_price from
product_has_materials
    left join
materials m
    on
m.id_materials = product_has_materials.materials_id_materials
group by product_id_product) as b
on id_product=product_id_product
         group by orders_id_orders
having orders_id_orders=6;


-- Прибыль от заказов (стоимость материалов - стоимость заказа - стоимость доставки)

select id_orders, (price_order - price_materials - price_delivery) as profit from
(select orders_id_orders, sum(materials_price) as price_materials from
(select orders_id_orders, id_product from orders_has_product
left join product p on
    orders_has_product.product_id_product = p.id_product) as a
    left join
(select product_id_product, sum(quantity_entity*unit_price) as materials_price from
product_has_materials
    left join
materials m
    on
m.id_materials = product_has_materials.materials_id_materials
group by product_id_product) as b
on id_product=product_id_product
         group by orders_id_orders) as c

left join orders as d
on orders_id_orders = id_orders;


-- вывести список оборудования с истекшим сроком гарантии

select `equpment_name` from equpment
where (`guaranty_period(months)` - `period_of_exploitation(months)`) < 0;

-- вывести список оборудования и стоимость одного часа работы

(select id_equpment, equpment_name, (`equpment_price`/`work_resource(hours)`) from equpment);



-- затраты на оборудование для производства каждого изделия

(select product_id_product, sum(price_eq*`operation_execution_time(hours)`) as equipment_costs from product_to_equpment left join
    (select id_equpment, equpment_name, (`equpment_price`/`work_resource(hours)`) as price_eq from equpment) as eq
on id_equpment=product_to_equpment.equpment_id_equpment
group by product_id_product);


-- список оборудования каждого заказа
(select * from orders_has_product left join product p on p.id_product = orders_has_product.product_id_product);

-- Расходы на каждый тип оборудование для каждого заказа
select * from (select * from orders_has_product left join product p on p.id_product = orders_has_product.product_id_product)  as l
left join
(select product_id_product, sum(price_eq*`operation_execution_time(hours)`) as equipment_costs from product_to_equpment left join
    (select id_equpment, equpment_name, (`equpment_price`/`work_resource(hours)`) as price_eq from equpment) as eq
on id_equpment=product_to_equpment.equpment_id_equpment
group by product_id_product) as r
on
    l.product_id_product = r.product_id_product;

-- Расходы на оборудование для каждого заказа
(select orders_id_orders, sum(equipment_costs) as equipment_costs from (select * from orders_has_product left join product p on p.id_product = orders_has_product.product_id_product)  as l
left join
(select product_id_product, sum(price_eq*`operation_execution_time(hours)`) as equipment_costs from product_to_equpment left join
    (select id_equpment, equpment_name, (`equpment_price`/`work_resource(hours)`) as price_eq from equpment) as eq
on id_equpment=product_to_equpment.equpment_id_equpment
group by product_id_product) as r
on
    l.product_id_product = r.product_id_product
group by orders_id_orders);

--  Чистая прибыль от заказов (стоимость материалов - стоимость заказа - стоимость доставки)
select id_orders, (price_order - price_delivery - equipment_costs) as profit from
(select *  from
(select orders_id_orders, sum(materials_price) as price_materials from
(select orders_id_orders, id_product from orders_has_product
left join product p on
    orders_has_product.product_id_product = p.id_product) as a
    left join
(select product_id_product, sum(quantity_entity*unit_price) as materials_price from
product_has_materials
    left join
materials m
    on
m.id_materials = product_has_materials.materials_id_materials
group by product_id_product) as b
on id_product=product_id_product
         group by orders_id_orders) as c

left join orders as d
on orders_id_orders = id_orders) as lll
left join
  (select orders_id_orders, sum(equipment_costs) as equipment_costs from (select * from orders_has_product left join product p on p.id_product = orders_has_product.product_id_product)  as l
left join
(select product_id_product, sum(price_eq*`operation_execution_time(hours)`) as equipment_costs from product_to_equpment left join
    (select id_equpment, equpment_name, (`equpment_price`/`work_resource(hours)`) as price_eq from equpment) as eq
on id_equpment=product_to_equpment.equpment_id_equpment
group by product_id_product) as r
on
    l.product_id_product = r.product_id_product
group by orders_id_orders)  as rrr
on lll.orders_id_orders=rrr.orders_id_orders;