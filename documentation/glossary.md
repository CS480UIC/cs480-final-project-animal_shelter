1. Animal, shelter_animal, medical_record, person and shelter_finance are entities. 
2. shelter_animal can also be called shelter information, since it contains the relationship between an individual animal and the animal shelter.
3. shelter_finance contains information about the donations made to the shelter, as well as all of the areas they get money and funds from.
4. animal_shelter contains the animal_id, the date of entry into the shelter, the date the animal left the shelter, if it was adopted, who it was adopted by
5. animal contains the id and all of the available information about the animal, such as the date of birth, species etc.
6. person contains information about the people registered in the shelters systems. These people have registered to adopt the shelter animals and contain all 
   relevant information such as their housing status and if they have kids.
7. Each shelter can contain multiple animals, but each animal can belong to one shelter.
8. Each animal can be adopted by at-most one person, but one person can adopt many animals.
9. Each vet clinic can give treatment to multiple animals, and each animal can be treated from multiple vetenerarians.

Relationships
1. Cascade(on delete and on update) relationship between animal and shelter_animal
2. Cascade(on delete and on update) relationship between animal and medical
