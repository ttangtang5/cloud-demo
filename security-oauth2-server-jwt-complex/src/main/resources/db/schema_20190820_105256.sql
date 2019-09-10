create table t_user (
    id bigint not null auto_increment,
    username varchar(20),
    password varchar(100),
    primary key (id)
);

create table login_status (
    id bigint not null,
    session_key varchar(255),
    login_time datetime,
    timeout bigint
);
