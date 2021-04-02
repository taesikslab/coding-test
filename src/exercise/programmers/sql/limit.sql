select i.name, i.datetime
from animal_outs o right join animal_ins i using(animal_id)
where o.datetime is null
order by o.datetime
limit 3;