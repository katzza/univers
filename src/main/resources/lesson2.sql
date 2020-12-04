create table university (
    id int primary key,
    name varchar not null unique,
    short_name varchar(20) not null unique,
    foundation_year int not null
);

create table faculty (
     faculty_id int primary key,
     name varchar not null,
     university_id int not null,
-- constraint <constraint_name>
     constraint faculty_university_id_fkey foreign key (university_id) references university(id)
);

insert into university (id, short_name, name, foundation_year)
values
(1, 'СПбГУ', 'СПБ Государственный университет', 1894),
(2, 'СПбГПУ', 'СПБ Политехнический университет', 1903),
(3, 'МГУ', 'Московский Государственный университет', 1842);

insert into university
values
(4, 'СПб университет путей сообщения', 'ПГУПС', 1856);

insert into faculty
values
(1, 'Юридический факультет', 1);

select * from faculty;


create table subject (
    id int primary key,
    subject varchar not null,
    count_of_hours int not null
);

create table subject_info (
    subject_id int primary key,
    description text not null,
    room_number int,
    constraint subject_info_id_fkey foreign key (subject_id) references subject(id)
);

create table faculty_subject (
    faculty_id int not null,
    subject_id int not null,
    -- unique (faculty_id, subject_id),
    primary key (faculty_id, subject_id),
    foreign key (faculty_id) references faculty(faculty_id),
    foreign key (subject_id) references subject(id)
);

insert into faculty
values
    (2, 'Факультет психологии', 1),
    (3, 'Экономический факультет', 1),
    (4, 'Факультет информатики', 2),
    (5, 'Строительный факультет', 2),
    (6, 'Социологический факультет', 3);

select * from university, faculty; -- << декартовое произведение
select * from university u, faculty f
where u.id = f.university_id; -- << cross join

select * from university u
-- inner join
join faculty f on u.id = f.university_id;

select * from university u
left join faculty f on u.id = f.university_id;
select * from faculty f
left join university u on f.university_id = u.id;

select * from faculty f
right join university u on f.university_id = u.id;

-- группировка данных и агрегирование
-- Функции агрегирования
--      avg(), sum(), count(), min(), max()
-- group by - группировка данных по каким-то полям
-- having - аналог where, только применяется к группе данных

select u.*, count(f.university_id) from university u
join faculty f on u.id = f.university_id
group by u.id
having count(f.university_id) > 1;

create table department (
    id serial primary key, -- serial - bigint auto_increment - default nextval('department_id_seq')
    name varchar not null,
    faculty_id int not null,
    constraint departement_faculty_id_fkey foreign key (faculty_id) references faculty(faculty_id)
);

insert into department (name, faculty_id)
values
    ('Кафедра философии и науки', 2);

select * from department;
select currval('department_id_seq');

--
create sequence university_id_sequence
increment by 1
start with 100;

-- insert into university (id, name) values (nextval('university_id_sequence'), 'name')
-- insert into university (name) values ('name')

alter table university alter column id set default nextval('university_id_sequence');
insert into university (id, name, short_name, foundation_year)
values
    (101, 'Высшая школа экономики', 'ВШЭ', 1957);
select * from university;

-- select setval('university_id_sequence', select max(id) from university);

-- Change sequence
-- alter sequence department_id_seq increment by 10;
-- alter sequence department_id_seq maxvalue 50555;

--
-- insert into university (id, name, short_name, foundation_year)
-- values
--     (101, 'Высшая школа экономики', 'ВШЭ', 1957);
-- insert into university (name, short_name, foundation_year)
-- values
--      ('Высшая школа экономики', 'ВШЭ', 1957); -- << nextval вернут 101