-- test de connexion au page correspondent

Candidat de test

update detailleemploie set idfhierarchiegenerale='GENE00001' where idfcandidat='CAND00079';
update detailleemploie set idfhierarchiegenerale='GENE00002' where idfcandidat='CAND00082';
update detailleemploie set idfhierarchiegenerale='GENE00003' where idfcandidat='CAND00085';


select idfhierarchiegenerale from detailleemploie where idfcandidat=''


insert into login_employee values ('CAND00079','mertina50');
insert into login_employee values ('CAND00082','mertina50');
insert into login_employee values ('CAND00085','mertina50');

insert into heursup(datedebut,datefin,description,idsudo,idheursup,idsuperieur,iddemandeur) values('2023-10-17 21:30:00','2023-10-17 22:30:00','demande heure sup',null,'HEUR00008',null,'CAND00085')


insert into detailleemploie values ('CAND00079','HIER000001','MAT000001','2023-10-10');
insert into detailleemploie values ('CAND00082','HIER000001','MAT000002','2023-10-11');
insert into detailleemploie values ('CAND00085','HIER000001','MAT000003','2023-10-12');
insert into detailleemploie values ('CAND00073','HIER000001','MAT000004','2021-10-12');
insert into detailleemploie values ('CAND00055','HIER000001','MAT000004','2017-10-12');

HIER000001


select * from detailleemploie join hierarchie on detailleemploie.idfhierarchie=hierarchie.idhierarchie where idfcandidat='CAND00079';


pagevaliderdemandehsphp1.do


monfichedepay.do?idfcandidat=CAND00085

--detaille emploiee
select idfhierarchie,idfservice,idcandidat from demande_besoin join candidat on demande_besoin.iddemande = candidat.idfdemande where idcandidat='CAND00425';


idfcandidat | idfhierarchie | matricule |    dateembouche     | idfhierarchiegenerale


insert into detailleemploie(idfcandidat,idfhierarchie,matricule,dateembouche,idfhierarchiegenerale) values ('','','',now(),'GENE00003')
