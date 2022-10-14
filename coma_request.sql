-- самый востребованный тип станков(equpment)
select equpment_name, count(*) as count
from
(select * from product left join product_to_equpment
    on product.id_product = product_to_equpment.product_id_product) as fir left join equpment as sec
on equpment_id_equpment = sec.id_equpment group by equpment_name;

-- какие материалы необходимо закупить для выполнения n заказа

