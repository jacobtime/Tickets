create table account(user varchar(50) not null primary key, pass varchar(50) not null, is_admin boolean not null, sex varchar(5) not null , ID_card varchar(20) not null, check ( sex = 'man' or  sex = 'woman') );
create table trains(ID varchar(50) not null primary key, seats int not null, remain int not null , type varchar(20));
create table states(ID varchar(50) not null, state_id int not null , pay_from_start int not null , state_name varchar(50) not null , arrive_time time not null ,foreign key (ID) references trains(ID), primary key (ID, state_id));
create table orders(user varchar(50) not null, ID varchar(50) not null , state_from varchar(50) not null , state_to varchar(50) not null , start_time time not null , arrive_time time not null , cost int not null, foreign key (user) references account(user), foreign key (ID) references  trains(ID), primary key (user, ID)) ;
insert into trains value ('G488', 100, 100, 'High-speed train');
insert into trains value ('G4885', 100, 100, 'High-speed train');
insert into trains value ('G38', 100, 100, 'High-speed train');
insert into trains value ('Z66', 300, 300, 'Direct express train');
insert into trains value ('G4794', 300, 300, 'High-speed train');
insert into trains value ('G4766', 300, 300, 'High-speed train');
insert into states value ('G488', 0, 0, 'Nanchang', '10:49:00');
insert into states value ('G488', 1, 36, 'Lushan', '11:32:00');
insert into states value ('G488', 2, 551, 'Zhengzhou', '14:31:00');
insert into states value ('G488', 3, 707, 'Shijiazhuang', '15:57:00');
insert into states value ('G488', 4, 806, 'Beijing', '17:06:00');
insert into states value ('G4885', 0, 0, 'Shanghai', '08:00:00');
insert into states value ('G4885', 1, 73, 'Hangzhou', '12:00:00');
insert into states value ('G4885', 2, 230, 'Shangrao', '16:20:00');
insert into states value ('G4885', 3, 337, 'Nanchang', '18:36:00');
insert into states value ('G38', 0, 0, 'Nanchang', '08:37:00');
insert into states value ('G38', 1, 264, 'Hangzhou', '11:30:00');
insert into states value ('G38', 2, 400, 'Tianjin', '17:26:00');
insert into states value ('G38', 3, 600, 'Beijing', '18:09:00');
insert into states value ('Z66', 0, 0, 'Beijing', '7:40:00');
insert into states value ('Z66', 1, 21, 'Nanchang', '19:34:00');
insert into states value ('G4794', 0, 0, 'Nanchang', '17:26:00');
insert into states value ('G4794', 1, 111, 'Shangrao', '18:09:00');
insert into states value ('G4794', 2, 264, 'Hangzhou', '7:40:00');
insert into states value ('G4794', 3, 337, 'Shanghai', '19:34:00');
insert into states value ('G4794', 4, 837, 'Beijing', '22:34:00');
insert into states value ('G4766', 0, 0, 'Nanchang', '11:00:00');
insert into states value ('G4766', 1, 300, 'Hangzhou', '13:09:00');
insert into states value ('G4766', 2, 405, 'Shanghai', '18:40:00');
insert into states value ('G4766', 3, 731, 'Beijing', '23:34:00');
insert into account value ('root','123456',true,'man' ,'000000000000000');
insert into account value ('test','123',false ,'woman','3423423423');
delimiter @@

create procedure account_insert(in user varchar(50), in pass varchar(50), in sex varchar(5) , in ID_card varchar(20) )
   begin
       insert into `account` value(user, pass, false, sex, ID_card);
    end@@
call account_insert('Jacob', '12321', 'man', '363432424342');

create procedure admin_account_insert(in user varchar(50), in pass varchar(50), in sex varchar(5) , in ID_card varchar(20) )
begin
    insert into `account` value(user, pass, true, sex, ID_card);
end@@

call admin_account_insert('admin', '123', 'woman', '12312313213');

create procedure train_insert(in id varchar(50),in seats int, in type varchar(20))
begin
    insert into `trains` value(id, seats, seats, type);
end@@

call train_insert('005', 20, 'Super-high train');

create procedure state_insert(in ID varchar(50), in state_id int , in pay_from_start int , in state_name varchar(50) , in arrive_time time)
begin
    insert into `states` value(ID, state_id, pay_from_start, state_name, arrive_time);
end@@

call state_insert('005', 0, 0, 'Fuzhou', '9:00:00');
call state_insert('005', 1, 100, 'Nanchang', '12:00:00');
call state_insert('005', 2, 256, 'Shanghai', '16:30:00');

create procedure orders_insert(in user varchar(50), in ID varchar(50) ,in state_from varchar(50) ,in state_to varchar(50) )
begin
    declare cost int;
    declare froms int;
    declare tos int;
    declare from_time time;
    declare  to_time time;
    select pay_from_start, arrive_time into froms, from_time from states where state_name = state_from and states.ID = ID ;
    select pay_from_start, arrive_time into tos, to_time from states where state_name = state_to and states.ID = ID ;
    set cost = tos - froms;
    insert into orders value (user, ID, state_from, state_to, from_time, to_time, cost);
end @@

call orders_insert('test', '001', 'Beijing', 'Hangzhou');

create procedure account_delete(in user varchar(50))
begin
    delete from orders where orders.user = user;
    delete from account where account.user = user;
end@@

call account_delete('test');

create procedure orders_delete(in user varchar(50), in ID varchar(50) )
begin
    delete from orders where orders.user = user and orders.ID = ID;
end@@

call orders_delete('test', '001');

create procedure state_delete(in ID varchar(50), in state_id int)
begin
    delete from states where states.ID = ID and states.state_id = state_id;
end@@

call state_delete('005', 2);

create procedure train_delete(in id varchar(50))
begin
    delete from states where states.ID = id;
    delete from trains where trains.ID = id;
end@@

call train_delete('005');

create procedure train_update(in id varchar(50),in seats int, in type varchar(20))
begin
    update trains set trains.seats = seats, trains.remain = least(trains.seats, remain), trains.type = type where trains.ID = id;
end@@

call train_update('001', 10, 'Super-high train');

create procedure state_update(in ID varchar(50), in state_id int , in pay_from_start int , in state_name varchar(50) , in arrive_time time)
begin
    update states set states.pay_from_start = pay_from_start, states.state_name = state_name, states.arrive_time = arrive_time where states.ID = ID and states.state_id = state_id;
end@@

call state_update('001', 1, 105, 'Tianjin', '9:20:20');

create procedure orders_update(in user varchar(50), in ID varchar(50) ,in state_from varchar(50) ,in state_to varchar(50) )
begin
    declare cost int;
    declare froms int;
    declare tos int;
    declare from_time time;
    declare  to_time time;
    select pay_from_start, arrive_time into froms, from_time from states where state_name = state_from and states.ID = ID ;
    select pay_from_start, arrive_time into tos, to_time from states where state_name = state_to and states.ID = ID ;
    set cost = tos - froms;
    update orders set orders.state_from =state_from, orders.state_to = state_to, orders.arrive_time = to_time, orders.start_time = from_time, orders.cost = cost where orders.ID = ID and orders.user = user;
end @@

call orders_update('test', '001', 'Tianjin', 'Hangzhou');

create procedure account_update(in user varchar(50), in pass varchar(50) )
begin
    update  account set account.pass = pass where account.user = user;
end@@

call account_update('test', '12306');

create procedure account_get()
begin
    select * from account;
end @@

call account_get();

create procedure train_get()
begin
    select * from trains;
end @@

call train_get();

create function train_decrease( ID varchar(50))
returns boolean
begin
    declare remains int;
    select remain into remains from trains where trains.ID = ID;
    if remains > 0 then
        update trains set remain = remain - 1 where trains.ID = ID;
        return true;
    else
        return false;
    end if;
end @@

select train_decrease('001');


create procedure order_get()
begin
    select * from orders;
end @@

call order_get();

create procedure state_get(id varchar(50))
begin
    select * from states where states.ID = id;
end @@

call state_get('001');

create procedure login_check(user varchar(50))
begin
    select pass, is_admin from account where account.user = user;
end @@

call login_check('Jacob');

create
    definer = root@localhost procedure user_check(IN user varchar(50))
begin
    if exists(select * from account where account.user = user) then
        select true;
    else
        select false;
    end if ;
end;



call user_check('admin');

create
    definer = root@localhost procedure search_check(IN froms varchar(50), IN tos varchar(50))
begin
    select s1.ID as ID, type, s1.arrive_time as start_time, s2.arrive_time as end_time, remain, timestampdiff(minute, s1.arrive_time, s2.arrive_time) as time , (select s2.pay_from_start -  s1.pay_from_start from states s1, states s2 where s1.ID = s2.ID and s1.ID = trains.ID and s1.state_name = froms and s2.state_name = tos)  as cost  from trains, states s1, states s2 where trains.ID = s1.ID and s1.ID = s2.ID and s1.arrive_time < s2.arrive_time and s1.state_name = froms and s2.state_name = tos;
end;



call search_check('Beijing', 'Nanchang');

create procedure order_get_one(user varchar(50))
begin
    select * from orders where orders.user = user;
end @@
call order_get_one("test");

create procedure get_train(in id varchar(50), in type varchar(20))
begin
    select * from trains where  trains.type like type and trains.ID like id ;
end@@
drop procedure get_train;
call get_train('001%', '%');
