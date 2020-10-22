INSERT INTO dominio values(1,'Banco de dados');
INSERT INTO dominio values(2,'LDAP');

INSERT INTO usuario values(1,current_date,'mariafg','maria','12345',1);
INSERT INTO usuario values(2,current_date,'jonas','jonaskr','12345',1);
INSERT INTO usuario values(3,current_date,'joao','joajo','12345',2);
INSERT INTO usuario values(4,current_date,'marcelo','celo','12345',1);
INSERT INTO usuario values(5,current_date,'raquel','raq','12345',2);
INSERT INTO usuario values(6,current_date,'laura','lua','12345',2);

INSERT INTO configuration values(false,false,1);     
INSERT INTO configuration values(false,false,2);

INSERT INTO tab_vehicle(licensePlate,city,manufacturer,model,year_manufacture,model_year,value,fuel_type,date_Register,especification, owner) values('AAA','111','Fiat','Toro',2020,2020,107000,'DIESEL',CURRENT_DATE,'Turism car',1);
INSERT INTO tab_vehicle(licensePlate,city,manufacturer,model,year_manufacture,model_year,value,fuel_type,date_Register,especification, owner) values('BBB','222','Ford','Fiesta',2019,2019,42000,'GASOLINE',CURRENT_DATE,'Turism car',2);
INSERT INTO tab_vehicle(licensePlate,city,manufacturer,model,year_manufacture,model_year,value,fuel_type,date_Register,especification, owner) values('CCC','333','Volkswagen','Gol',2018,2018,10000,'ALKOHOL',CURRENT_DATE,'Turism car',3);
INSERT INTO tab_vehicle(licensePlate,city,manufacturer,model,year_manufacture,model_year,value,fuel_type,date_Register,especification, owner) values('DDD','444','Fiat','Strada',2020,2020,89000,'ALKOHOL',CURRENT_DATE,'Turism car',4);
INSERT INTO tab_vehicle(licensePlate,city,manufacturer,model,year_manufacture,model_year,value,fuel_type,date_Register,especification, owner) values('EEE','555','Fiat','Siena',2020,2020,32000,'BIOFUEL',CURRENT_DATE,'Turism car',5);


INSERT INTO tab_vehicle_collection(licensePlate,city,manufacturer,model,year_manufacture,model_year,value,fuel_type,date_Register,especification, owner) values('EEE','555','Fiat','Siena',2020,2020,32000,'BIOFUEL',CURRENT_DATE,'Turism car',5);


INSERT INTO owner(code,name_owner,telephone_owner,email) values(1,'Fernando Martins','11 9999 9999','fernando@email.com');
INSERT INTO owner(code,name_owner,telephone_owner,email) values(2,'Isabela Santos','34 8888 88888','isabela@email.com');
INSERT INTO owner(code,name_owner,telephone_owner,email) values(3,'Jonas silva','45 7777 7777','Jonas@email.com');
INSERT INTO owner(code,name_owner,telephone_owner,email) values(4,'Ulisses Silva','67 4444 4444','Ulisses@email.com');
INSERT INTO owner(code,name_owner,telephone_owner,email) values(5,'Maria Rodrigues','12 4566 6667','Maria@email.com');