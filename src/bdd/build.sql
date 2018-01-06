
drop table if exists receive;
drop table if exists read;
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

create table read (
    read_fk_users varchar(50) not null references users(u_login),
    read_fk_messages bigint not null references messages(m_idMessage),
    primary key (read_fk_users, read_fk_messages)
);

create table receive (
    rcv_fk_users varchar(50) not null references users(u_login),
    rcv_fk_messages bigint not null references messages(m_idMessage),
    primary key (rcv_fk_users, rcv_fk_messages)
);

-- DROP TABLE IF EXISTS UTILISATEUR ;
-- CREATE TABLE UTILISATEUR (identifiant_Utilisateur VARCHAR AUTO_INCREMENT NOT NULL,
-- motDePasse_Utilisateur VARCHAR(20),
-- nomUser_UTILISATEUR VARCHAR(10),
-- prenom_UTILISATEUR VARCHAR(50),
-- statut_UTILISATEUR VARCHAR(50),
-- PRIMARY KEY (identifiant_Utilisateur)) ENGINE=InnoDB;
--
-- DROP TABLE IF EXISTS GROUPE ;
-- CREATE TABLE GROUPE (idGroupe_GROUPE BIGINT(10) AUTO_INCREMENT NOT NULL,
-- nomGroupe_GROUPE BIGINT(2),
-- PRIMARY KEY (idGroupe_GROUPE)) ENGINE=InnoDB;
--
-- DROP TABLE IF EXISTS MESSAGE ;
-- CREATE TABLE MESSAGE (idMessage_MESSAGE BIGINT(2) AUTO_INCREMENT NOT NULL,
-- dataMessage_MESSAGE BIGINT(1),
-- dateMessage_MESSAGE BIGINT(2),
-- idTicket_TICKET **NOT FOUND**(2),
-- identifiant_Utilisateur **NOT FOUND**(2),
-- PRIMARY KEY (idMessage_MESSAGE)) ENGINE=InnoDB;
--
-- DROP TABLE IF EXISTS TICKET ;
-- CREATE TABLE TICKET (idTicket_TICKET BIGINT(1) AUTO_INCREMENT NOT NULL,
-- nomTicket_TICKET BIGINT(2),
-- dateDeCreation_TICKET BIGINT(2),
-- identifiant_Utilisateur **NOT FOUND**(1),
-- idGroupe_GROUPE **NOT FOUND**(1),
-- PRIMARY KEY (idTicket_TICKET)) ENGINE=InnoDB;
--
-- DROP TABLE IF EXISTS appartenir ;
-- CREATE TABLE appartenir (identifiant_Utilisateur **NOT FOUND** AUTO_INCREMENT NOT NULL,
-- idGroupe_GROUPE **NOT FOUND** NOT NULL,
-- PRIMARY KEY (identifiant_Utilisateur,
--  idGroupe_GROUPE)) ENGINE=InnoDB;
--
-- DROP TABLE IF EXISTS lecture ;
-- CREATE TABLE lecture (identifiant_Utilisateur **NOT FOUND** AUTO_INCREMENT NOT NULL,
-- idMessage_MESSAGE **NOT FOUND** NOT NULL,
-- PRIMARY KEY (identifiant_Utilisateur,
--  idMessage_MESSAGE)) ENGINE=InnoDB;
--
-- DROP TABLE IF EXISTS recevoir ;
-- CREATE TABLE recevoir (identifiant_Utilisateur **NOT FOUND** AUTO_INCREMENT NOT NULL,
-- idMessage_MESSAGE **NOT FOUND** NOT NULL,
-- PRIMARY KEY (identifiant_Utilisateur,
--  idMessage_MESSAGE)) ENGINE=InnoDB;
--
-- ALTER TABLE MESSAGE ADD CONSTRAINT FK_MESSAGE_idTicket_TICKET FOREIGN KEY (idTicket_TICKET) REFERENCES TICKET (idTicket_TICKET);
--
-- ALTER TABLE MESSAGE ADD CONSTRAINT FK_MESSAGE_identifiant_Utilisateur FOREIGN KEY (identifiant_Utilisateur) REFERENCES UTILISATEUR (identifiant_Utilisateur);
-- ALTER TABLE TICKET ADD CONSTRAINT FK_TICKET_identifiant_Utilisateur FOREIGN KEY (identifiant_Utilisateur) REFERENCES UTILISATEUR (identifiant_Utilisateur);
-- ALTER TABLE TICKET ADD CONSTRAINT FK_TICKET_idGroupe_GROUPE FOREIGN KEY (idGroupe_GROUPE) REFERENCES GROUPE (idGroupe_GROUPE);
-- ALTER TABLE appartenir ADD CONSTRAINT FK_appartenir_identifiant_Utilisateur FOREIGN KEY (identifiant_Utilisateur) REFERENCES UTILISATEUR (identifiant_Utilisateur);
-- ALTER TABLE appartenir ADD CONSTRAINT FK_appartenir_idGroupe_GROUPE FOREIGN KEY (idGroupe_GROUPE) REFERENCES GROUPE (idGroupe_GROUPE);
-- ALTER TABLE lecture ADD CONSTRAINT FK_lecture_identifiant_Utilisateur FOREIGN KEY (identifiant_Utilisateur) REFERENCES UTILISATEUR (identifiant_Utilisateur);
-- ALTER TABLE lecture ADD CONSTRAINT FK_lecture_idMessage_MESSAGE FOREIGN KEY (idMessage_MESSAGE) REFERENCES MESSAGE (idMessage_MESSAGE);
-- ALTER TABLE recevoir ADD CONSTRAINT FK_recevoir_identifiant_Utilisateur FOREIGN KEY (identifiant_Utilisateur) REFERENCES UTILISATEUR (identifiant_Utilisateur);
-- ALTER TABLE recevoir ADD CONSTRAINT FK_recevoir_idMessage_MESSAGE FOREIGN KEY (idMessage_MESSAGE) REFERENCES MESSAGE (idMessage_MESSAGE);
