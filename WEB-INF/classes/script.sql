create sequence login_employeesequence;

create table cvcandidadetaille(
    idcvcandidadetaille varchar(15),
    idfdetaille_cr varchar(15),
    idfcandidate varchar(15),
    description text,
    datedebut TIMESTAMP,
    datefin TIMESTAMP,
    Foreign key (idfservice) references service(idservice)
);


rh_employee,5432,postgres,postgres,root

notecritere

C:\L3\MR Tovo\WEB-INF\classes\\
C:\L3\MR Tovo\\

create table service(
    idservice Varchar(15) primary key,
    nomservice Varchar(100)
);



create table enfant(
    idenfant Varchar(15) primary key,
    nomenfant Varchar(50),
    datedenaisance TIMESTAMP
);
create table lien()

-- drop table
drop table critere;
drop table hierarchie;
drop table employee;
drop table notecritere;
drop table detaille_critere;
drop table critere;
drop table login_connexion;
drop table demande_besoinsequence;
drop table detaille_hierarchie_horaire;
drop table detaille_employe_salaire;
drop table Detaille_employe_hierarchie;

--fin 


delete from service;
delete from hierarchie;
delete from Employee;
delete from login_employee;
delete  from detaille_employe_hierarchie ;

delete from critere;
delete from detaille_critere;
delete from notecritere;

insert into service values ('SERV000001','informatique');
insert into service values('SERV000002','manageur');


create sequence servicesequence;

create sequence hierarchiesequence;
create sequence employeesequence;
create sequence detaille_employe_hierarchiesequence;
create sequence detaille_employe_salairesequence;
create sequence detaille_hierarchie_horairesequence;
create sequence demande_besoinsequence;
create sequence login_employeesequence;
create sequence login_Connexionsequence;
create sequence criteresequence;

create sequence detaille_criteresequence;
create sequence notecriteresequence;



create table Hierarchie(
    idhierarchie Varchar(15) primary key,
    idfservice Varchar(15),
    nomhierarchie Varchar(50),
    Foreign key (idfservice) references service(idservice)
);

insert into hierarchie values('HIER000001','SERV000001','dev');
insert into hierarchie values('HIER000002','SERV000001','dessing');
insert into hierarchie values('HIER000003','SERV000001','chefprojet');

insert into hierarchie values('HIER000004','SERV000002','chef');
insert into hierarchie values('HIER000005','SERV000002','employer');

select service.nomservice from Employee join detaille_employe_hierarchie on Employee.idemployee=detaille_employe_hierarchie.idfemployee  join Hierarchie on detaille_employe_hierarchie.idfhierarchie=hierarchie.idhierarchie join  service on service.idservice=hierarchie.idfservice  where datefin is null and Employee.idemployee='EMPL000001';



create table Employee(
    idemployee Varchar(15) primary key,
    nomemployee Varchar(15),
    prenomemployee Varchar(15),
    Datenaissance TIMESTAMP,
    Dateenetre TIMESTAMP,
    idsuperieur Varchar(15),
    idservice Varchar(15),
    Foreign key (idsuperieur) references Employee(idemployee)
);
create table login_employee(
    idfemployee Varchar(15) primary key,
    modpass Varchar(50),
    Foreign key (idfemployee) references Employee(idemployee)
);

insert into login_employee values('EMPL000001','mertina50');
insert into login_employee values('EMPL000002','mertina51');

insert into Employee values('EMPL000000',null,null,null,null,null);
insert into Employee values('EMPL000001','TOTO','Mertina claudie','2002-06-28','2023-12-11','EMPL000000','SERV00131');
insert into Employee values('EMPL000002','TOTO','Marie Anne','2003-06-28','2023-12-11','EMPL000000','SERV00208');

delete from login_employee;
delete from employee;



select service.nomservice,service.idservice from login_employee join Employee on Employee.idemployee=login_employee.idfemployee  join service on service.idservice=Employee.idservice where login_employee.idfemployee='EMPL000002' and login_employee.modpass='mertina51';

select service.nomservice,service.idservice from service join Employee on  service.idservice=Employee.idservice where Employee.idemployee='EMPL000002';


select * from detaille_employe_hierarchie join hierarchie join idservice 

drop table Detaille_employe_hierarchie;


create table detaille_employe_hierarchie(
    iddetaille_eh Varchar(15) primary key,
    idfemployee Varchar(15),
    idfhierarchie Varchar(15),
    dateedebut TIMESTAMP,
    datefin TIMESTAMP,
    Foreign key (idfemployee) references Employee(idemployee),
    Foreign key (idfhierarchie) references Hierarchie(idhierarchie)
);

insert into detaille_employe_hierarchie values ('DTLH000001','EMPL000001','HIER000001','2023-12-11');



create table detaille_employe_salaire(
    iddetaille_es  Varchar(15) primary key,
    idfemployee Varchar(15),
    salaire double precision,
    debut TIMESTAMP,
    fin TIMESTAMP,
    Foreign key (idfemployee) references Employee(idemployee)
);

create table detaille_hierarchie_horaire(
    iddetaille_hh Varchar(15) primary key,
    idfhierarchie Varchar(15),
    heuredetravaille double precision,
    datedebut TIMESTAMP,
    datefin TIMESTAMP,
    Foreign key (idfhierarchie) references Hierarchie(idhierarchie)
);


demande_besoin

create table Demande_Besoin(
    iddemande Varchar(15) primary key,
    horaire double precision,
    nbr_employee int,
    production_actuelle double precision,
    production_demander double precision,
    datedemande TIMESTAMP,
    datefin  TIMESTAMP,
    idfservice Varchar(15),
    Foreign key (idfservice) references service(idservice)
);
ALTER TABLE demande_besoin
ADD COLUMN fait boolean;
ALTER TABLE demande_besoin
ADD COLUMN description Varchar(100);

ALTER TABLE demande_besoin
ALTER COLUMN fait TYPE Varchar(6);

ALTER TABLE demande_besoin
ALTER COLUMN description TYPE Varchar(100);


delete from demande_besoin;



drop table login_employee;

insert into login_employee values('EMPL000001','mertina5041');



create table login_Connexion(
    idfemployee Varchar(15),
    dateheure TIMESTAMP,
    Foreign key (idfemployee) references Employee(idemployee)
);


create table critere(
    idcritere Varchar(15) primary key,
    nomcritere Varchar(50),
    idservice Varchar(15),
    multipleoupas boolean,
    Foreign key (idservice) references service(idservice)
);
where idservice=''

ALTER TABLE critere
ADD COLUMN multipleoupas boolean;

create table detaille_critere(
    iddetaille_cr Varchar(15) primary key,
    idfcrietere Varchar(15),
    Nomdetaillecritere Varchar(60),
    Foreign key (idfcrietere) references critere(idcritere)
);
create table cvcandidadetaille(
    idcvcandidadetaille varchar(15) primary key,
    idfdetaille_cr varchar(15),
    idfcandidat varchar(15),
    description text,
    datedebut TIMESTAMP,
    datefin TIMESTAMP,
    Foreign key (idfdetaille_cr) references detaille_critere(iddetaille_cr),
    Foreign key (idfcandidat) references candidat(idcandidat)
);

update candidat  set idfdemande='DEMA00022' where  idcandidat='CAND00055'

ALTER TABLE candidat ADD idfdemande Varchar(15);
ALTER TABLE candidat  ADD CONSTRAINT fk_candidat FOREIGN KEY (idfdemande) REFERENCES demande_besoin(iddemande);


delete from candidat;
delete from cvcandidadetaille;


create sequence cvcandidadetaillesequence;


select * from detaille_critere where idfcrietere='CRIT00934';

select * from detaille_critere join critere on detaille_critere.idfcrietere=critere.idcritere  CROSS JOIN  where idservice='SERV000208';

select * from detaille_critere CROSS JOIN notecritere on notecritere ;
create table notecritere (
    idnote Varchar(15) primary key,
    idfdetaille_cr Varchar(15),
    note int,
    idfdemande Varchar(15),
    Foreign key (idfdetaille_cr) references detaille_critere(iddetaille_cr),
    Foreign key (idfdemande) references demande_besoin(iddemande)
);



create sequence questionsequence;
create table question(
    idquestion Varchar(15) primary key,
    idfdemande Varchar(15),
    textquestion text,
    note int,
    Foreign key (idfdemande) references demande_besoin(iddemande)
);
select * from  question where idfdemande='DEMA00022';

create table choixquestion(
    idchoixquestion Varchar(15) primary key,
    idfquestion Varchar(15),
    choix text,
    vraifause Varchar(6)
);

create table reponsequetion(
    idreponse Varchar(15) primary key,
    idfchoixquestion Varchar(15),
    idfcandidat Varchar(15),
    Foreign key (idfchoixquestion) references choixquestion(idchoixquestion),
    Foreign key (idfcandidat) references candidat(idcandidat)
);

insert into reponsequetion values ('REPS00001','CHOI00004','CAND00055');
insert into reponsequetion values ('REPS00002','CHOI00023','CAND00055');
