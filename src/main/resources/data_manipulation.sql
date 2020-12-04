insert into university (id, short_name, name, foundation_year)
values
	(1, 'СПбГУ', 'СПБ Государственный университет', 1894),
	(2, 'СПбГПУ', 'СПБ Политехнический университет', 1903),
	(3, 'МГУ', 'Московский Государственный университет', 1842);

insert into university
values
	(4, 'СПб университет путей сообщения', 'ПГУПС', 1856);

select * from university;
select short_name, name, foundation_year from university;

update university set foundation_year = 1902
where id = 2;
select * from university;

select * from university
where foundation_year < 1900 and foundation_year > 1850;

select * from university
where foundation_year between 1850 and 1900;

select * from university
where foundation_year <> 1842;

select * from university
where short_name = 'СПбГУ';

select * from university
where short_name like 'СПб%';

select * from university
where name like '%университет';

select * from university
where name like '%Государственный%';

-- delete 
delete from university
where id = 4;

select * from university;