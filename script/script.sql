
create table Hierarchiegenerale(
    idhierarchieg Varchar(15) primary key,
    nomhierarchie Varchar(50)
);
insert into Hierarchiegenerale values ('GENE00001','sudo');
insert into Hierarchiegenerale values ('GENE00002','superieur');
insert into Hierarchiegenerale values ('GENE00003','employee');


create table detailleemploie(
    idfcandidat VARCHAR(15) primary key,
    idfhierarchie VARCHAR(15),
    Matricule VARCHAR(20),
    dateembouche  TIMESTAMP,
    Foreign key (idfhierarchie) references Hierarchie(idhierarchieg)
);
ALTER TABLE detailleemploie
ADD idfhierarchiegenerale VARCHAR(15),
ADD CONSTRAINT cleetrangaire FOREIGN KEY (idfhierarchiegenerale) REFERENCES Hierarchiegenerale (idhierarchieg);

select * from detailleemploie  join candidat on detailleemploie.idfcandidat=candidat.idcandidat ;




select DATE_PART('year', age(now(), dateembouche)) from detailleemploie where idfcandidat='CAND00079';

select now()-dateembouche from detailleemploie where idfcandidat='CAND00079';

drop table conge;

drop table conge;

create table conge(
    idconger Varchar(15) primary key,
    idfcandidat Varchar(15),
    datedebut TIMESTAMP,
    datefin TIMESTAMP,
    Raison Varchar(15),
    idsuperieur  Varchar(15),
    idsudo Varchar(15),
    Foreign key (idfcandidat) references candidat(idcandidat),
    Foreign key (idsuperieur) references candidat(idcandidat),
    Foreign key (idsudo) references candidat(idcandidat),
    Foreign key (Raison) references congespecifie(idcongespecifie)
);




insert into conge values('CONG00055','CAND00085','2023-10-10 00:00:00','2023-11-19 00:00:00','CONG00025','CAND00082','CAND00079');


update conge set idsuperieur='' where idconger=''

select nomconge,nomhierarchie,datedebut,datefin,conge.idfcandidat from conge join detailleemploie on conge.idfcandidat=detailleemploie.idfcandidat join hierarchie on hierarchie.idhierarchie=detailleemploie.idfhierarchie join congespecifie on congespecifie.idcongespecifie=conge.Raison  where hierarchie.idfservice = 'SERV00208' ;



select idfcandidat,nomconge,datedebut,datefin from conge join congespecifie on conge.idconger = congespecifie.idcongespecifie where  idsuperieur is null


select sum (DATE_PART('days', age(datefin,datedebut ))) from conge where datedebut>=(SELECT CURRENT_DATE - INTERVAL '2 year')


insert into congespecifie values ('CONG00039','Absence',0,'non',2);


select sum(EXTRACT(EPOCH FROM age(datefin::timestamp, datedebut::timestamp)) / 3600) absence from conge join congespecifie on conge.Raison=congespecifie.idcongespecifie where remunereoupas='non' and  idfcandidat='CAND00079'and EXTRACT(MONTH FROM datedebut)=EXTRACT(MONTH FROM now());


delete from conge;

insert into conge (idconger,idfcandidat,datedebut,datefin,Raison ) values ('CONG00030','CAND00079','2023-10-18 22:30:00','2023-10-18 23:30:00','CONG00039');



insert into conge (idconger,idfcandidat,datedebut,datefin,Raison ) values ('CONG00001','CAND00055','2018-01-12','2023-04-12','CONG00005');
insert into conge (idconger,idfcandidat,datedebut,datefin,Raison ) values ('CONG00002','CAND00055','2019-01-12','2023-02-12','CONG00025');
insert into conge (idconger,idfcandidat,datedebut,datefin,Raison ) values ('CONG00003','CAND00055','2020-01-12','2023-02-08','CONG00025');
insert into conge (idconger,idfcandidat,datedebut,datefin,Raison ) values ('CONG00004','CAND00055','2021-01-12','2023-02-01','CONG00025');

insert into conge (idconger,idfcandidat,datedebut,datefin,Raison ) values ('CONG00005','CAND00055','2022-01-12','2023-01-31','CONG00005');
insert into conge (idconger,idfcandidat,datedebut,datefin,Raison ) values ('CONG00005','CAND00055','2023-01-12','2023-02-12','CONG00005');


select * from conge where datedebut >= (SELECT CURRENT_DATE - interval '2 years') and idfcandidat='%s' order by date ;


create sequence congesequence;

create table listeconge(
    idlisteconge Varchar(15) primary key,
    nomconge Varchar(200)
);
create sequence listecongesequence;

insert into listeconge values ('LIST000001','Conge materinite');
insert into listeconge values ();
insert into listeconge values ();

LIST00003

create table congespecifie(
    idcongespecifie Varchar(15) primary key,
    nomconge Varchar(50),
    dureejours int,
    remunereoupas Varchar(5),
    femmehomme int
);

 idcongespecifie |    nomconge    | dureejours | remunereoupas | femmehomme
-----------------+----------------+------------+---------------+------------
 CONG00005       | maternite      |         90 | oui           |          0
 CONG00023       | maternitehomme |         15 | oui           |          1
 CONG00025       | annuelle       |         30 | oui           |          2
 CONG00029       | maladie        |          0 | oui           |          2
 CONG00033       | nonremuneree   |          0 | non           |          2
 CONG00039       | Absence        |          0 | non           |          2

create sequence congespecifiesequence;


select * from candidat join detailleemploie   on candidat.idcandidat = detailleemploie.idfcandidat;

--requete maka ni difference d'heur entre deux date


SELECT EXTRACT(EPOCH FROM age('2023-10-02'::timestamp, '2023-10-01'::timestamp)) / 3600;


select * from detailleemploie where dateembouche =''

update  detailleemploie set dateembouche='2022-10-12 00:00:00' where idfcandidat='CAND00085';

SELECT CURRENT_DATE - INTERVAL '2 year' AS NouvelleDate;




select idfcandidat,nom,prenom,tel,nomhierarchie,EXTRACT(YEAR FROM age(now(), dateembouche)) as ancienete,EXTRACT(YEAR FROM age(now(), datedenaisance)) as age from candidat join detailleemploie on candidat.idcandidat=detailleemploie.idfcandidat join hierarchie on detailleemploie.idfhierarchie=hierarchie.idhierarchie;


SELECT * FROM candidat LEFT JOIN detailleemploie ON candidat.idcandidat = detailleemploie.idfcandidat where detailleemploie.idfcandidat is null and  idfdemande='DEMA00022';