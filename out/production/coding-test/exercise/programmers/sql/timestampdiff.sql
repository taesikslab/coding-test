select o.animal_id, o.name
from animal_outs o
         inner join animal_ins i using(animal_id)
order by timestampdiff(minute, i.datetime, o.datetime) desc
    limit 2;