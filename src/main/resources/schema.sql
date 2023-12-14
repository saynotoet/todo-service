create TABLE Users(
id BIGINT primary key,
username varchar(255) not null,
password varchar(255) not null
);

insert into Users(id,username,password)
values (100001,'admin','admin');