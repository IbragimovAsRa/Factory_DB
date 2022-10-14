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

select equpment_name, (`equpment_price`/`work_resource(hours)`) from equpment;

-- скол