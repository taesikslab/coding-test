select distinct places.id, places.name
from places inner join schedules on places.id = schedules.place_id
            inner join place_reviews on places.id = place_reviews.place_id
where DATE_FORMAT(schedules.scheduled_at, '%Y-%m-%d') = "2019-01-06"
order by places.id;