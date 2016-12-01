INSERT INTO `Polygon`.`Address` (`addressline`, `zipcode_addressId`) VALUES ('Buildingvej1', 1);
INSERT INTO `Polygon`.`Address` (`addressline`, `zipcode_addressId`) VALUES ('Buildingvej2', 2);
INSERT INTO `Polygon`.`userAddress` (`addressLine`, `Zipcode_zipId`) VALUES ('userVej1', 1);
INSERT INTO `Polygon`.`userAddress` (`addressLine`, `Zipcode_zipId`) VALUES ('userVej2', 2);
INSERT INTO `Polygon`.`User` (`firstname`, `lastname`, `phone`, `email`, `userAddress_addressId`) VALUES ('Joacim', 'Vetterlain', '42786242', 'joacim@vetterlain.dk', '1');
INSERT INTO `Polygon`.`User` (`firstname`, `lastname`, `phone`, `email`, `userAddress_addressId`) VALUES ('Janus', 'Janus', '12345678', 'janus@udsen.dk', 2);

INSERT INTO `Polygon`.`Building` (`hidden`, `Address_addressId`, `rapportURL`, `User_userId`, `buildingName`) VALUES (0, 1, 'notnull', 1, 'Bygning1');
INSERT INTO `Polygon`.`Building` (`hidden`, `Address_addressId`, `rapportURL`, `User_userId`, `buildingName`) VALUES (0, 2, 'notnull', 1, 'Bygning2');

INSERT INTO `Polygon`.`Document` (`file`, `note`, `Building_buildingId`) VALUES ('FILE', 'en note', 1);
INSERT INTO `Polygon`.`Login` (`username`, `password`, `rank`, `User_userId`) VALUES ('admin', 'admin', 1, 1);
INSERT INTO `Polygon`.`Login` (`username`, `password`, `rank`, `User_userId`) VALUES ('kunde', 'kunde', 5, 2);
INSERT INTO `Polygon`.`Request` (`requestId`, `type`) VALUES (1, 'deletionRequest');
INSERT INTO `Polygon`.`Request` (`requestId`, `type`) VALUES (2, 'healthCheck');

