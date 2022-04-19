use demo;
select id, `name`,email,country from users where LOWER(country) like ?;