use factory;


create schema ff;


insert into orders
values (1, '2022-01-1', 'Tom', '200000', '10000'),
       (2, '2022-01-19', 'Ivan', '500000', '15000'),
       (3, '2022-02-28', 'Smit', '100000', '10000'),
       (4, '2022-03-5', 'Torvald', '300000', '15000'),
       (5, '2022-04-12', 'Tom', '900000', '10000'),
       (6, '2022-04-21', 'Timur', '200000', '10000'),
       (7, '2022-05-3', 'Tom', '600000', '15000');


insert into materials
values (1, 'Chipboard', 220),
       (2, 'Solid wood', 430),
       (3,'MDF',270),
       (4, 'Acryl', 370),
       (5, 'Glass', 500),
       (6, 'Mirrors', 310);


insert into equpment
values (1, 'Format-cutting machines', 12, 4, 1, 24),
       (2, 'Edge-banding machines', 24, 3, 1, 24),
       (3, 'Drilling and priming machines', 12, 1, 1, 24),
       (4, 'Glass processing machines', 12, 11, 1, 24),
       (5, 'CNC Milling machines', 24, 10, 1, 24),
       (6, 'Glue-bearing machines', 12, 16, 1, 24),
       (7, 'Laser engraving machines', 24, 9, 1, 24);

insert into orders_has_product
values
       (1, 1),
       (1, 3),
       (1, 6),
       (1, 4),

       (2, 3),
       (2, 2),
       (2, 1),

       (3, 6),
       (3, 5),
       (3, 1),
       (3, 4),

       (4, 5),
       (4, 3),
       (4, 1),

       (5, 1),
       (5, 3),
       (5, 2),
       (5, 4),

       (6, 2),
       (6, 3),
       (6, 6),

       (7, 6),
       (7, 3),
       (7, 1),
       (7, 4),
       (7, 2);

insert into product
values (1, 'Upholstered furniture', 1),
       (2, 'Wardrobe', 2),
       (3, 'Bedroom furniture', 3),
       (4, 'Living room furniture', 1),
       (5, 'Kitchen furniture', 1),
       (6, 'Office furniture', 2);

-- Какие материалы нужны для производства единицы мебели
insert into product_has_materials
values (1, 2, 5),
       (1, 6, 4),
       (1, 1, 10),
       (1, 3, 11),

       (2, 1, 2),
       (2, 5, 2),
       (2, 2, 6),

       (3, 1, 20),
       (3, 6, 17),

       (4, 3, 10),

       (5, 1, 9),
       (5, 2, 2),
       (5, 3, 6),
       (5, 4, 18),

       (6, 1, 15),
       (6, 6, 13);

insert into product_to_equpment
values (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),

       (2, 2),
       (2, 4),
       (2, 5),

       (3, 5),
       (3, 6),
       (3, 7),
       (3, 2),
       (3, 3),
       (3, 4),

       (4, 6),
       (4, 4),

       (5, 6),
       (5, 5),
       (5, 2),
       (5, 1),

       (6, 1),
       (6, 2),
       (6, 3);





