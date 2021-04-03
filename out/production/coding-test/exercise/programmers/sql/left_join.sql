select o.animal_id, o.name
from animal_outs o
         left join animal_ins i using(animal_id)
where i.animal_id is null
order by o.animal_id;