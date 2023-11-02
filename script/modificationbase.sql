 CAND00079   | HIER000001    | MAT000001 | 2023-10-10 00:00:00        | GENE00001
 CAND00082   | HIER000001    | MAT000002 | 2023-10-11 00:00:00        | GENE00002
 CAND00085   | HIER000001    | MAT000003 | 2022-10-12 00:00:00        | GENE00003
 CAND00425   | HIER000001    | MATR00007 | 2023-10-23 08:08:38.608387 | GENE00003
 CAND00428   | HIER000001    | MATR00008 | 2023-10-23 08:43:27.058609 | GENE00003

 idcandidat |      nom      |     prenom      |   datedenaisance    |                mail                 |    tel     | depotdecandidature  | idfsexe | idfdemande

 Léa Dupont - 2003-04-19
Lucas Martin - 2003-04-19
Emma Dubois - 2003-04-19
Hugo Girard - 2003-04-19
Chloé Lefebvre - 2003-04-19
Louis Moreau - 2003-04-19
Jade Rousseau - 2003-04-19
Noah Gagnon - 2003-04-19
Lola Mercier - 2003-04-19
Arthur Roy - 2003-04-19

select * from detailleemploie;
 idfcandidat | idfhierarchie | matricule |        dateembouche        | idfhierarchiegenerale

 update detailleemploie set dateembouche='2018-10-10 00:00:00'  where idfcandidat='CAND00079';
 update detailleemploie set dateembouche='2020-10-10 00:00:00'  where idfcandidat='CAND00082';
 update detailleemploie set dateembouche='2021-10-10 00:00:00'  where idfcandidat='CAND00085';
 update detailleemploie set dateembouche='2022-10-10 00:00:00'  where idfcandidat='CAND00425';
 update detailleemploie set dateembouche='2023-10-10 00:00:00'  where idfcandidat='CAND00428';

 update detailleemploie set dateembouche='2022-10-10 00:00:00'  where idfcandidat='CAND00434';

  
 


 update candidat set nom='Randriatsiresy' ,prenom='Mandresy',datedenaisance='1998-04-19',depotdecandidature='2023-09-01' where idcandidat='CAND00079';
 update candidat set nom='Andriasahy' ,prenom='Tsiresy',datedenaisance='1999-04-19',depotdecandidature='2023-09-01' where idcandidat='CAND00082';
 update candidat set nom='Ambinintsoa' ,prenom='Tafita soa',datedenaisance='1987-04-19',depotdecandidature='2023-09-01' where idcandidat='CAND00085';
 update candidat set nom='Razafimalaza' ,prenom='Fitiavana',datedenaisance='1987-04-19',depotdecandidature='2023-09-01' where idcandidat='CAND00425';
 update candidat set nom='Rakotoarisoa' ,prenom='Pamela',datedenaisance='2003-04-19',depotdecandidature='2023-09-01' where idcandidat='CAND00428';


 select * from Login_employee where idfemployee='CAND00434' and modpass='metrina50';
 
 select * from Login_employee where idfemployee='CAND00434' and modpass='mertina50';

