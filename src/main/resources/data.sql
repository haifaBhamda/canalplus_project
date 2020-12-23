

INSERT INTO TBL_SUBSCRIBER ( first_name, last_name, street_address, country, zip_code) VALUES
( 'Haifa', 'Armand','15 rue des peuplies boulogne billancourt','France','92100'),
( 'Rébecca', 'Armand','45 rue des point de jours','France','92101'),
( 'Maria', 'Armand','5 rue du chateau','France','92101');


INSERT INTO TBL_CONTRACT(subscriber_id, street_address, country, zip_code) VALUES
(1, 'rue des peuplies','France','92100'),
(1, 'rue des peuplies','France','92101'),
(2, 'rue des peuplies','France','92102'),
(1, 'rue de point de Jour','France','92182'),
(2, 'rue de point de jour','France','92182');

