drop schema if exists buildingsTest;

drop user if exists javatester;

create schema buildingsTest;
use buildingsTest;

create table testbuilding like Polygon.building;

create user javatester IDENTIFIED BY 'testogeksperimenter=21coolstuf';

GRANT ALL PRIVILEGES ON buildingsTest.* TO javatester;

INSERT INTO testbuilding (buildingId,hidden,Address_addressId,rapportURL,User_userId,buildingName) 
VALUES (1,0,1,"testurl",1,'bygning1');

