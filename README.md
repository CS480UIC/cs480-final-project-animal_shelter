## Table of Contents
1. [Database](#database)
1. [Author(s)](#author)
1. [Database description](#description)
 
# Database
animal_shelter
# Author(s)
Ameesha Saxena
# Database description
This database contains information about the animals that come into a shelter, as well as financial information and transactions.
The tables are : 
animal: id, name, species, date_of_entry, exit_date, personality_information, adoption_history, physical_description
finance: money_in, donor_name, donor_information, transaction_date, transaction_value
medical_history(animals usually get evaluated by a veterinarian when they get in a shelter, this table will be accessible via the vets office as well as the shelter): animal_id, clinic_code, name, conditions, notes, visit_dates, last_visit, prescriptions
People(who want to adopt the animals in the shelter): id, name, age, address, housing_status, number_of_kids, adoption_history
