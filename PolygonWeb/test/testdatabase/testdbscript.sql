create schema buildingsTest;
use buildingsTest;

create table testbuilding like Polygon.building;

INSERT INTO testbuilding (buildingId,hidden,Address_addressId,rapportURL,User_userId,buildingName) 
VALUES (1,0,1,"testurl",1,'bygning1');

