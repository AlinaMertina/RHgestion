create table service(
    idservice Varchar(15) primary key,
    nomservice Varchar(100)
);

select * from heursup;

create table heursup(
    idheursup Varchar(15) primary key,
    iddemandeur Varchar(15),
    idsuperieur Varchar(15),
    idsudo Varchar(15),
    description text,
    datedebut TIMESTAMP,
    datefin TIMESTAMP,
    Foreign key (iddemandeur) references candidat(idcandidat),
    Foreign key (idsuperieur) references candidat(idcandidat),
    Foreign key (idsudo) references candidat(idcandidat)
);

select sum(EXTRACT(EPOCH FROM age(datefin::timestamp, datedebut::timestamp)) / 3600) sup from  heursup where iddemandeur='CAND00085' and idsudo is not null and EXTRACT(MONTH FROM datedebut)=EXTRACT(MONTH FROM now());


update heursup set idsuperieur=''  where idheursup=''

create sequence heursupsequence;



select nomhierarchie,description,idfcandidat,datedebut,datefin from detailleemploie join hierarchie on detailleemploie.idfhierarchie=hierarchie.idhierarchie  join heursup on heursup.iddemandeur=detailleemploie.idfcandidat where idfcandidat='CAND00085' and datedebut>=now();


create table heurdetravaille(
    idheurtravaille Varchar(15) primary key,
    idfhierarchie Varchar(15),
    heure double precision ,
    prix double precision,
    Foreign key (idfhierarchie) references Hierarchie(idhierarchie)
);

delete  from heurdetravaille where idfhierarchie='HEUR00033'
insert into heurdetravaille values ('HEUR00034','HIER000001',540,2500);

select heure from heurdetravaille join detailleemploie on heurdetravaille.idfhierarchie =detailleemploie.idfhierarchie where idfcandidat='CAND00082'

 limit 1;
create sequence heurdetravaillesequence;

create table majorationheursup(
    idmajoration Varchar(15) primary key,
    inferieur int,
    sup int,
    majoration double precision
);

create sequence majorationheursupsequence;

create table cnaps(
    idcnaps Varchar(15) primary key,
    description text,
    pourcentage double precision
);
create sequence cnapssequence;

create table IRSA(
    idirsa Varchar(15) primary key,
    inf double precision,
    sup double precision,
    taux double precision
);
create sequence irsasequence;


create table Prime(
    idprime Varchar(15) primary key,
    description text,
    montant double precision
);
create sequence primesequence;

create table primeemployer(
    idprimeemployee Varchar(15) primary key,
    idfprime Varchar(15),
    idfcandidat Varchar(15),
    dateprime date
);
create sequence primeemployersequence;

select description from primeemployer join prime on  primeemployer.idfprime=prime.idprime where idfprime='PRIM00002'

SELECT taux,  (350000*taux)/100  as irsavalue FROM IRSA WHERE 350000 BETWEEN inf AND sup limit 1;


select sum (DATE_PART('days', age(datefin,datedebut ))) from conge where datedebut>=(SELECT CURRENT_DATE - INTERVAL '2 year') where idfcandidat='CAND00085';

2023-10-10 00:00:00 	2023-11-19 00:00:00

select  '2023-11-19 00:00:00'::date  - '2023-10-10 00:00:00'::date 

select * from demande_besoin join candidat on demande_besoin.iddemande = candidat.idfddemande;

