DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_animal`(IN id VARCHAR(10), IN name VARCHAR(30), IN species VARCHAR(50), IN age INT, IN physical_description VARCHAR(100), IN microchip_id VARCHAR(10), IN adoption_history VARCHAR(100))
BEGIN
INSERT INTO animal 
VALUES (id,name,species,age,physical_description,microchip_id,adoption_history);
END$$
DELIMITER ;


DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_shelter_animal`(IN animal_id VARCHAR(10), IN shelter_id VARCHAR(10), IN date_of_entry DATE, IN date_of_exit DATE, IN adopter_id VARCHAR(10))
BEGIN
INSERT INTO shelter_animal 
VALUES (animal_id,shelter_id,date_if_entry,date_of_exit,adopter_id);
END$$
DELIMITER ;


DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `calculate_donations`(date_from DATE, date_to DATE) RETURNS int
    READS SQL DATA
BEGIN

DECLARE c2 INT;

SELECT SUM(transaction_value) INTO c2
FROM shelter_finance
WHERE transaction_date >= date_from AND transaction_date <= date_to;

RETURN c2;
END$$
DELIMITER ;


DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `find_old_animal`(animal_age INT) RETURNS int
    READS SQL DATA
BEGIN

DECLARE output VARCHAR(10);

SELECT name INTO output
FROM animal
WHERE age > animal_age;
RETURN 1;

END$$
DELIMITER ;
