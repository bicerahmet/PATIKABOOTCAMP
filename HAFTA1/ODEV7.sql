SELECT rating FROM film GROUP BY rating
SELECT COUNT(film),replacement_cost FROM film GROUP BY replacement_cost HAVING COUNT(film)>50
SELECT COUNT(customer),store_id FROM customer GROUP BY store_id
SELECT COUNT(city) ,country_id FROM city GROUP BY country_id ORDER BY COUNT(city) DESC LIMIT 1
