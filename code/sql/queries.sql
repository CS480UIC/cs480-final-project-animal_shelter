CREATE VIEW animalView
AS SELECT animal.name
FROM animal
ORDER BY name asc;

CREATE VIEW healthyAnimal
AS SELECT animal_id
FROM medical
WHERE diagnoses = "perfect health"
order by animal_id;

CREATE VIEW maxDonationView
AS SELECT name, MAX(transaction_value)
FROM shelter_finance;

CREATE VIEW averageAgeView
AS SELECT AVG(age)
FROM animal;

CREATE VIEW differentAges
AS SELECT COUNT(age)
FROM animal
GROUP BY age;

CREATE VIEW dateInOrder
AS SELECT animal.name, YEAR(shelter_animal.date_of_entry) as inYear
FROM animal, shelter_animal
WHERE animal.id = shelter_animal.animal_id
ORDER BY inYear ASC;

CREATE VIEW adoptorView
AS SELECT animal.name, person.name
FROM animal, person, shelter_animal
WHERE animal.id = shelter_animal.animal_id AND person.id = shelter_animal.adopter_id;

CREATE VIEW peopleDonationView
AS SELECT person.first_name, person.last_name, shelter_finance.transaction_value
FROM person, shelter_finance
WHERE person.id = shelter_finance.person_id;

CREATE VIEW commonAdoptedAnimals
AS SELECT animal.physical_features, animal.age
FROM animal 
WHERE EXISTS (SELECT date_of_exit FROM shelter_animal);

CREATE VIEW biggerThanAverageDonationsView
AS SELECT transaction_id
FROM shelter_finance 
WHERE transaction_value > (SELECT AVG(transaction_value) FROM shelter_finances);
