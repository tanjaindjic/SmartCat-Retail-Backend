insert into territory (id, city, postal, country)
values (1, 'Belgrade', '11000', 'Serbia');
insert into territory (id, city, postal, country)
values (2, 'Zurich', '8000', 'Switzerland');
insert into territory (id, city, postal, country)
values (3, 'Budapest', '1007', 'Hungary');

insert into shop (id, name, address, phone, territory_id)
values(1, 'Gatto', 'Ruzveltova 4', '+3816520585', 1);
insert into shop (id, name, address, phone, territory_id)
values(2, 'ITKitty', 'Pozarevacka 16', '+381661155285', 1);
insert into shop (id, name, address, phone, territory_id)
values(3, 'Dataquest', 'Weinbergstrasse 71', '+414436015648', 2);
insert into shop (id, name, address, phone, territory_id)
values(4, 'PremiumIT', 'Lagerhausstrasse 18', '+4152361606711', 2);
insert into shop (id, name, address, phone, territory_id)
values(5, 'PCLand', 'Jasz u. 71', '+36568002585', 3);
insert into shop (id, name, address, phone, territory_id)
values(6, 'MagiComp', 'Bajcsy-Zsilinszky u. 60', '+361828205463', 3);

insert into employee (id, firstName, lastName, age, position, shop_id)
values(1, 'Jovana', 'Ilic', 29, 'register', 1);
insert into employee (id, firstName, lastName, age, position, shop_id)
values(2, 'Milos', 'Petrovic', 34, 'customer support', 2);
insert into employee (id, firstName, lastName, age, position, shop_id)
values(3, 'Ben', 'Fischer', 16, 'tech support', 3);
insert into employee (id, firstName, lastName, age, position, shop_id)
values(4, 'Jonas', 'Meyer', 37, 'manager', 4);
insert into employee (id, firstName, lastName, age, position, shop_id)
values(5, 'Adrienn', 'Tot', 33, 'advertising', 5);
insert into employee (id, firstName, lastName, age, position, shop_id)
values(6, 'Marko', 'Horvat', 29, 'tech support', 6);

insert into territory_shops (territory_id, shops_id) values (1,1);
insert into territory_shops (territory_id, shops_id) values (1,2);
insert into territory_shops (territory_id, shops_id) values (2,3);
insert into territory_shops (territory_id, shops_id) values (2,4);
insert into territory_shops (territory_id, shops_id) values (3,5);
insert into territory_shops (territory_id, shops_id) values (3,6);

insert into shop_employees (shop_id, employees_id) values (1,1);
insert into shop_employees (shop_id, employees_id) values (2,2);
insert into shop_employees (shop_id, employees_id) values (3,3);
insert into shop_employees (shop_id, employees_id) values (4,4);
insert into shop_employees (shop_id, employees_id) values (5,5);
insert into shop_employees (shop_id, employees_id) values (6,6);