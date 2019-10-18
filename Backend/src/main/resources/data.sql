insert into territory (id, city, postal, country)
values (10000, 'Belgrade', '11000', 'Serbia');
insert into territory (id, city, postal, country)
values (20000, 'Zurich', '8000', 'Switzerland');
insert into territory (id, city, postal, country)
values (30000, 'Budapest', '1007', 'Hungary');

insert into shop (id, name, address, phone, territory_id)
values(10000, 'Gatto', 'Ruzveltova 4', '+3816520585', 10000);
insert into shop (id, name, address, phone, territory_id)
values(20000, 'ITKitty', 'Pozarevacka 16', '+381661155285', 10000);
insert into shop (id, name, address, phone, territory_id)
values(30000, 'Dataquest', 'Weinbergstrasse 71', '+414436015648', 20000);
insert into shop (id, name, address, phone, territory_id)
values(40000, 'PremiumIT', 'Lagerhausstrasse 18', '+4152361606711', 20000);
insert into shop (id, name, address, phone, territory_id)
values(50000, 'PCLand', 'Jasz u. 71', '+36568002585', 30000);
insert into shop (id, name, address, phone, territory_id)
values(60000, 'MagiComp', 'Bajcsy-Zsilinszky u. 60', '+361828205463', 30000);

insert into employee (id, firstName, lastName, age, position, shop_id)
values(1, 'Jovana', 'Ilic', 29, 'register', 10000);
insert into employee (id, firstName, lastName, age, position, shop_id)
values(2, 'Milos', 'Petrovic', 34, 'customer support', 20000);
insert into employee (id, firstName, lastName, age, position, shop_id)
values(3, 'Ben', 'Fischer', 16, 'tech support', 30000);
insert into employee (id, firstName, lastName, age, position, shop_id)
values(4, 'Jonas', 'Meyer', 37, 'manager', 40000);
insert into employee (id, firstName, lastName, age, position, shop_id)
values(5, 'Adrienn', 'Tot', 33, 'advertising', 50000);
insert into employee (id, firstName, lastName, age, position, shop_id)
values(6, 'Marko', 'Horvat', 29, 'tech support', 60000);

insert into territory_shops (territory_id, shops_id) values (10000,10000);
insert into territory_shops (territory_id, shops_id) values (10000,20000);
insert into territory_shops (territory_id, shops_id) values (20000,30000);
insert into territory_shops (territory_id, shops_id) values (20000,40000);
insert into territory_shops (territory_id, shops_id) values (30000,50000);
insert into territory_shops (territory_id, shops_id) values (30000,60000);

insert into shop_employees (shop_id, employees_id) values (10000,1);
insert into shop_employees (shop_id, employees_id) values (20000,2);
insert into shop_employees (shop_id, employees_id) values (30000,3);
insert into shop_employees (shop_id, employees_id) values (40000,4);
insert into shop_employees (shop_id, employees_id) values (50000,5);
insert into shop_employees (shop_id, employees_id) values (60000,6);