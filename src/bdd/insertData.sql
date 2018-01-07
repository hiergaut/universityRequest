
insert into groups values ('sport');
insert into groups values ('info');
insert into groups values ('chauffage');
insert into groups values ('nadege');
insert into groups values ('fablab');


insert into users values ('gauthier', 'fuck', 'gauthier', 'bouyjou', 'student');
insert into users values ('anonymous', 'passwd', 'prenom', 'nom', 'student');
insert into users values ('rastaman', 'passwd', 'prenom', 'nom', 'student');
insert into users values ('migeon', 'passwd', 'migeon', 'nom', 'professor');
insert into users values ('nadege', 'passwd', 'nadege', 'nom', 'service');
insert into users values ('maintenance', 'passwd', 'prenom', 'nom', 'service');


-- insert into belong values ('gauthier', 'info');
insert into belong values ('gauthier', 'nadege');
insert into belong values ('gauthier', 'chauffage');
insert into belong values ('gauthier', 'sport');

insert into belong values ('anonymous', 'info');

insert into belong values ('rastaman', 'sport');
insert into belong values ('rastaman', 'fablab');

insert into belong values ('migeon', 'info');
insert into belong values ('migeon', 'nadege');
insert into belong values ('migeon', 'fablab');

insert into belong values ('nadege', 'sport');
insert into belong values ('nadege', 'info');
insert into belong values ('nadege', 'chauffage');
insert into belong values ('nadege', 'nadege');

insert into belong values ('maintenance', 'chauffage');
insert into belong values ('maintenance', 'nadege');


insert into tickets values (1, 'cours d''info en salle 101 ?', '2010-02-02 10:24:54', 'gauthier', 'info');
insert into tickets values (2, 'plus de chauffage en salle 2!', '2010-02-02 10:25:54', 'rastaman', 'chauffage');
insert into tickets values (3, 'plus de sport', '2010-02-02 10:26:54', 'rastaman', 'sport');
insert into tickets values (4, 'note de ct', '2010-02-02 10:27:54', 'anonymous', 'nadege');
insert into tickets values (5, 'controle de math', '2010-02-02 10:28:54', 'anonymous', 'info');


insert into messages values (1, 'bonjour il n''y a pas de cours en salle 101', '2010-02-02 10:28:54', 'gauthier', 1);
insert into seen values ('gauthier', 1);
insert into messages values (2, 'c''est normal, l''emploi du temp a ete mis a jour', '2010-02-02 10:29:54', 'nadege', 1);
insert into seen values ('nadege', 2);
insert into messages values (3, 'je suis desole, je suis malade', '2010-02-02 10:30:54', 'migeon', 1);
insert into seen values ('migeon', 3);

insert into messages values (4, 'pas de chauffage urgent', '2010-02-02 10:31:54', 'rastaman', 2);
insert into seen values ('rastaman', 4);
insert into messages values (5, 'c''est reparé', '2010-02-02 10:33:54', 'maintenance', 2);
insert into seen values ('maintenance', 5);

insert into messages values (6, 'il faut plus de sport', '2010-02-02 10:34:54', 'rastaman', 3);
insert into seen values ('rastaman', 6);

insert into messages values (7, 'pourrait on avoir les notes de ct?', '2010-02-02 10:35:54', 'anonymous', 4);
insert into seen values ('anonymous', 7);
insert into messages values (8, 'oui biensur', '2010-02-02 10:39:54', 'nadege', 4);
insert into seen values ('nadege', 7);

insert into messages values (9, 'controle de math quand?', '2010-02-02 10:36:54', 'anonymous', 5);
insert into seen values ('anonymous', 9);
insert into messages values (10, 'je ne sais pas', '2010-02-02 10:37:54', 'nadege', 5);
insert into seen values ('nadege', 10);
insert into messages values (11, 'dans une semaine', '2010-02-02 10:41:54', 'migeon', 5);
insert into seen values ('migeon', 11);
insert into messages values (12, 'dans une semaine', '2010-02-02 10:43:54', 'migeon', 5);
insert into seen values ('migeon', 12);
insert into messages values (13, 'dans une semaine', '2010-02-02 10:44:54', 'migeon', 5);
insert into seen values ('migeon', 13);
insert into messages values (14, 'dans une semaine', '2010-02-02 10:47:54', 'migeon', 5);
insert into seen values ('migeon', 14);
insert into messages values (15, 'dans une semaine', '2010-02-02 10:48:54', 'migeon', 5);
insert into seen values ('migeon', 15);
insert into messages values (16, 'dans une semaine', '2010-02-02 10:49:54', 'migeon', 5);
insert into seen values ('migeon', 16);
insert into messages values (17, 'dans une semaine', '2010-02-02 10:50:54', 'migeon', 5);
