CREATE INDEX microchip
ON animal (microchip_id);

CREATE INDEX vet_office
on medical (clinic_id);

CREATE INDEX person
on person (first_name, last_name, zip_code);

CREATE INDEX entryDate
on shelter_animal (date_of_entry);

CREATE INDEX dateTransact
on shelter_finance (transaction_date);
