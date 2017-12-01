create table tb_member (
	id varchar(20) primary key,
	pwd varchar(20) not null,
	username varchar(100) not null
);

create table tb_event (
	id integer primary key,
	title varchar(500) not null,
	start timestamp,
	end timestamp,
	description varchar(2000),
	member_id varchar(20)	
);

insert into tb_member (id, pwd, username) values('hong', 'zxcv1234', 'Hong gildong');
insert into tb_member (id, pwd, username) values('lee', 'zxcv1234', 'Lee sunshin');
insert into tb_member (id, pwd, username) values('kim', 'zxcv1234', 'Kim yushin');
insert into tb_member (id, pwd, username) values('kang', 'zxcv1234', 'Kang gamchan');
insert into tb_member (id, pwd, username) values('ryu', 'zxcv1234', 'Ryu kwansun');

