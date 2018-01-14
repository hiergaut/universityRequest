
drop table if exists receive;
drop table if exists seen;
drop table if exists belong;
drop table if exists messages;
drop table if exists tickets;
drop table if exists groups;
drop table if exists users;

create table users (
    u_login varchar(50) not null primary key,

    u_password varchar(50) not null,
    u_firstname varchar(50) not null,
    u_name varchar(50) not null,

    u_status varchar(50) not null
);

create table groups (
    g_name varchar(50) not null primary key
);

create table tickets (
    t_idTicket bigint not null primary key,

    t_title varchar(50) not null,
    t_created timestamp not null,

    t_fk_users varchar(50) references users(u_login),
    t_fk_groups varchar(50) references groups(g_name)
);

create table messages (
    m_idMessage bigint not null primary key,

    m_data varchar(1024) not null,
    m_created timestamp not null,
    
    m_fk_users varchar(50) references users(u_login),
    m_fk_tickets bigint references tickets(t_idTicket)
);


create table belong (
    b_fk_users varchar(50) not null references users(u_login),
    b_fk_groups varchar(50) not null references groups(g_name),
    primary key (b_fk_users, b_fk_groups)
);

create table seen (
    seen_fk_users varchar(50) not null references users(u_login),
    seen_fk_messages bigint not null references messages(m_idMessage),
    primary key (seen_fk_users, seen_fk_messages)
);

create table receive (
    rcv_fk_users varchar(50) not null references users(u_login),
    rcv_fk_messages bigint not null references messages(m_idMessage),
    primary key (rcv_fk_users, rcv_fk_messages)
);
