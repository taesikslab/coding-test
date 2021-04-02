select animal_id, name, if(sex_upon_intake like 'Intact%', 'X', 'O')
from animal_ins
order by animal_id;