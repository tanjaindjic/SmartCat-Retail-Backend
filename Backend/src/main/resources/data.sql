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

insert into employee (id, firstName, lastName, email, position, shop_id)
values(10000, 'Jovana', 'Ilic', 'jovana@smartcat.io', 'register', 10000);
insert into employee (id, firstName, lastName, email, position, shop_id)
values(20000, 'Milos', 'Petrovic', 'milos@smartcat.io', 'customer support', 20000);
insert into employee (id, firstName, lastName, email, position, shop_id)
values(30000, 'Ben', 'Fischer', 'ben@smartcat.io', 'tech support', 30000);
insert into employee (id, firstName, lastName, email, position, shop_id)
values(40000, 'Jonas', 'Meyer', 'jonas@smartcat.io', 'manager', 40000);
insert into employee (id, firstName, lastName, email, position, shop_id)
values(50000, 'Adrienn', 'Tot', 'adrienn@smartcat.io', 'advertising', 50000);
insert into employee (id, firstName, lastName, email, position, shop_id)
values(60000, 'Marko', 'Horvat', 'marko@smartcat.io', 'tech support', 60000);

insert into territory_shops (territory_id, shops_id) values (10000,10000);
insert into territory_shops (territory_id, shops_id) values (10000,20000);
insert into territory_shops (territory_id, shops_id) values (20000,30000);
insert into territory_shops (territory_id, shops_id) values (20000,40000);
insert into territory_shops (territory_id, shops_id) values (30000,50000);
insert into territory_shops (territory_id, shops_id) values (30000,60000);

insert into shop_employees (shop_id, employees_id) values (10000,10000);
insert into shop_employees (shop_id, employees_id) values (20000,20000);
insert into shop_employees (shop_id, employees_id) values (30000,30000);
insert into shop_employees (shop_id, employees_id) values (40000,40000);
insert into shop_employees (shop_id, employees_id) values (50000,50000);
insert into shop_employees (shop_id, employees_id) values (60000,60000);