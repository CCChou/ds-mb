create table article (
	id int auto_increment primary key,
	title nvarchar(255),
	content nvarchar(255),
	userid int,
	date datetime default current_timestamp,
	foreign key (userid) references user(id)
);

create table user (
	id int auto_increment primary key,
	account varchar(255) not null,
	password varchar(255)
);

create table comment (
	id int auto_increment primary key,
	articleId int,
	account varchar(255),
	date datetime default current_timestamp,
	comment nvarchar(255),
	foreign key (account) references user(account),
	foreign key (articleId) references article(id)
);