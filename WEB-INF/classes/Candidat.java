package etu002087.demandebesoin;
import java.util.HashMap;
import java.util.Vector;
import generaliser.AmethodeSet;
import generaliser.Generaliser; 
import generaliser.ANomTable; 
import generaliser.Adatabase; 
import generaliser.AmethodeGet; 
import generaliser.APrimarykey; 
import java.util.Date; 
import etu002087.framework.Urlannotation; 
import etu002087.framework.ModelView; 
import etu002087.framework.Scopeannotation; 
import etu002087.framework.Set_value_jspannotation; 
import etu002087.framework.Sessionannotation; 
import etu002087.framework.Gsonannotation;

import java.sql.*;
import java.text.SimpleDateFormat;

import java.util.Collections;
import java.util.Comparator;
import etu002087.conge.Congespecifie;
import etu002087.payement.Majorationheursup;
import  etu002087.payement.Primeemployer;
import  etu002087.payement.Prime;
import etu002087.payement.Cnaps;



@ANomTable(nomtable = "candidat", nbrclonne =9,nomsequence = "candidatsequence")
@Adatabase(nombase = "rh_employee", typebase= "postgres",nomuser= "postgres",password= "root",port="5432") 
public class Candidat extends Generaliser { 
   String idcandidat;
   String nom;
   String prenom;
   Date datedenaisance;
   String mail;
   String tel;
   Date depotdecandidature;
   Integer idfsexe;
   String idfdemande ;
   Integer  notgenerale;
   Integer agecandidat;

   public void setagecandidat(){
    ConnectPostgres connex = new ConnectPostgres();
      try {
        Connection con = connex.getconnection();
        Statement stmt= con.createStatement();
        String requete = " select EXTRACT(YEAR FROM age(now(), datedenaisance)) as age  from candidat  where idcandidat='"+getidcandidat()+"' ";
        System.out.println(requete);
        ResultSet donner = stmt.executeQuery(requete);
        while(donner.next()){
          agecandidat=donner.getInt("age");
        }
        stmt.close();
        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }

   }
   public Integer getagecandidat(){
    return agecandidat;
   }

  //fichie de pay
    Vector<Primeemployer>  listeprime = new Vector<Primeemployer>();
    Double totalprime=0.0;
    public void setlisteprime(){
          listeprime = new Primeemployer().selectAllWithcondition(" where idfcandidat='"+getidcandidat()+"'  and  EXTRACT(MONTH FROM dateprime)=EXTRACT(MONTH FROM now()) ");
          for(int i=0;i<listeprime.size();i++){
              Primeemployer primee = (Primeemployer) listeprime.get(i);
              totalprime=totalprime + primee.getmontant();
          }
    }
    public Double getTotalprime(){
      return totalprime;
    }
    public Vector<Primeemployer>   getlisteprime(){
        return listeprime;
    }
    Double tauxirsa=0.0;
    Double prixtauxirsa=0.0;
    public void setIrsa(){
      ConnectPostgres connex = new ConnectPostgres();
      try {
          Connection con = connex.getconnection();
          Statement stmt= con.createStatement();
          String requete = "SELECT taux,  ("+getSalaire()+"*taux)/100  as irsavalue FROM IRSA WHERE "+getSalaire()+" BETWEEN inf AND sup limit 1; ";
          System.out.println(requete);
          ResultSet donner = stmt.executeQuery(requete);
          Integer in = 0;
          while(donner.next()){
            tauxirsa= donner.getDouble("taux");
            prixtauxirsa=  donner.getDouble("irsavalue");
          }
          stmt.close();
          con.close();
      } catch (Exception e) {
          System.out.println(e);
      }

    }
   

    public Double getTauxIrsa(){
      return tauxirsa;
    }
    public Double getPrixtaux(){
      return prixtauxirsa;
    }
    Double totalcnaps= 0.0;
    public Double getTotalcnaps(){
      return totalcnaps;
    }
    Vector<Cnaps> listecnaps = new Vector<Cnaps>();
    public void setListecnaps(){
        listecnaps = new Cnaps().selectAll();
        Vector<Cnaps> resu = new Vector<Cnaps>();
        for(int i=0;i<listecnaps.size();i++){
          Cnaps cnaps = (Cnaps) listecnaps.get(i);
          cnaps.setPrixcnapscandidat((getSalaire()* cnaps.getpourcentage())/100 );
          totalcnaps=totalcnaps+cnaps.getPrixcnapscandidat();
          resu.add(cnaps);
        }
        listecnaps=resu;
    }
    public Vector<Cnaps> getListecnaps(){
      return listecnaps;
    }
    Double totalheursup=0.0;
    public Double getTotalheursup(){
      return totalheursup;
    }
    //majoration
    Vector<Majorationheursup> majoration = new Vector<Majorationheursup>();
    public void setMajoration(){
      majoration = new Majorationheursup().selectAll();
      
      Double heursupplementaire =0.0;
      heursupplementaire=getHeurSup();
     
      Vector<Majorationheursup> temps = new  Vector<Majorationheursup>();
      for(int i=0;i< majoration.size() ;i++){
       
        Majorationheursup majorationheur = (Majorationheursup)  majoration.get(i);
        
        Integer  value=  majorationheur.getsup()-majorationheur.getinferieur();
       
        heursupplementaire=heursupplementaire-value;
        System.out.println("hhhhhhh  "+heursupplementaire);

        if(heursupplementaire*-1 <=0){
          if(heursupplementaire>=0){
            majorationheur.setPrixmajoration(Double.parseDouble(value.toString()),getPrixParheur());
            
          }
        }else if( heursupplementaire*-1 < value ){
          Double valued = Double.parseDouble((value).toString());

          majorationheur.setPrixmajoration( valued+heursupplementaire  ,getPrixParheur());
          
        }
        totalheursup=totalheursup+majorationheur.getPrixmajoration();

        temps.add(majorationheur);
       
      }
      majoration=temps;
    }
    public Vector<Majorationheursup> getMajoration(){
      return majoration;
    }
  //fin fichie 
  //  calcule heure de travaille

   Double heurabsence=0.0;
   Double heursup=0.0;
   Double heuredetravaille=0.0;
   Double prixparheur=0.0;
   Double salaire=0.0 ;
  
   public Double getPrixabsence(){
    return getHeurAbsence()*getPrixParheur();
   }
   public Double getSalaire(){
    return salaire;
   }
   public Double getPrixParheur(){
    return prixparheur;
   }
  public void setHeurTravaille(){
      ConnectPostgres connex = new ConnectPostgres();
      try {
          Connection con = connex.getconnection();
          Statement stmt= con.createStatement();
          String requete = "select heure,prix,heure*prix as salaire from heurdetravaille join detailleemploie on heurdetravaille.idfhierarchie =detailleemploie.idfhierarchie where idfcandidat='"+getidcandidat()+"' limit 1";
          System.out.println(requete);
          ResultSet donner = stmt.executeQuery(requete);
          Integer in = 0;
          while(donner.next()){
            heuredetravaille=donner.getDouble("heure");
            prixparheur=donner.getDouble("prix");
            salaire=donner.getDouble("salaire");
          }
          stmt.close();
          con.close();
      } catch (Exception e) {
          System.out.println(e);
      }
  }
  public Double getHeurTravaille(){
      return heuredetravaille;
  }
  

  public void setHeurSup(int mois){
    ConnectPostgres connex = new ConnectPostgres();
    try {
        Connection con = connex.getconnection();
        Statement stmt= con.createStatement();
        String requete = "select sum(EXTRACT(EPOCH FROM age(datefin::timestamp, datedebut::timestamp)) / 3600) sup from  heursup where iddemandeur='"+getidcandidat()+"' and idsudo is not null and EXTRACT(MONTH FROM datedebut)="+mois;
        System.out.println(requete);
        ResultSet donner = stmt.executeQuery(requete);
        Integer in = 0;
        while(donner.next()){
          heursup=donner.getDouble("sup");
        }
        stmt.close();
        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }
  }

  public void setHeurSup(){
    ConnectPostgres connex = new ConnectPostgres();
    try {
        Connection con = connex.getconnection();
        Statement stmt= con.createStatement();
        String requete = "select sum(EXTRACT(EPOCH FROM age(datefin::timestamp, datedebut::timestamp)) / 3600) sup from  heursup where iddemandeur='"+getidcandidat()+"' and idsudo is not null and EXTRACT(MONTH FROM datedebut)=EXTRACT(MONTH FROM now())";
        System.out.println(requete);
        ResultSet donner = stmt.executeQuery(requete);
        Integer in = 0;
        while(donner.next()){
          heursup=donner.getDouble("sup");
        }
        stmt.close();
        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }
  }
  public Double getHeurSup(){
    return heursup;
  }
  public void setHeurAbsence(int mois){
    ConnectPostgres connex = new ConnectPostgres();
      try {
          Connection con = connex.getconnection();
          Statement stmt= con.createStatement();
          String requete = "select sum(EXTRACT(EPOCH FROM age(datefin::timestamp, datedebut::timestamp)) / 3600) absence from conge join congespecifie on conge.Raison=congespecifie.idcongespecifie where remunereoupas='non' and  idfcandidat='"+getidcandidat()+"'and EXTRACT(MONTH FROM datedebut)="+mois;
          System.out.println(requete);
          ResultSet donner = stmt.executeQuery(requete);
          Integer in = 0;
          while(donner.next()){
            heurabsence=donner.getDouble("absence");
          }
          stmt.close();
          con.close();
      } catch (Exception e) {
          System.out.println(e);
    }
  }
   public void setHeurAbsence(){
    ConnectPostgres connex = new ConnectPostgres();
      try {
          Connection con = connex.getconnection();
          Statement stmt= con.createStatement();
          String requete = "select sum(EXTRACT(EPOCH FROM age(datefin::timestamp, datedebut::timestamp)) / 3600) absence from conge join congespecifie on conge.Raison=congespecifie.idcongespecifie where remunereoupas='non' and  idfcandidat='"+getidcandidat()+"'and EXTRACT(MONTH FROM datedebut)=EXTRACT(MONTH FROM now())";
          System.out.println(requete);
          ResultSet donner = stmt.executeQuery(requete);
          Integer in = 0;
          while(donner.next()){
            heurabsence=donner.getDouble("absence");
          }
          stmt.close();
          con.close();
      } catch (Exception e) {
          System.out.println(e);
      }
   }
   public Double getHeurAbsence(){
    return heurabsence;
   }
   public void setnotgenerale(Integer i){
    notgenerale=i;
   }
   public Integer getnotegenerale(){
    return notgenerale;
   }
   //information employee
   String matricule;
   String dateembouche;
   Hierarchie hierarchie = new Hierarchie();
   Integer ancienetee=0;
   Integer age = 0;
   public String getmatricule(){
    return matricule;
   }
   public String getdateembouche(){
    return dateembouche;
   }
   public Hierarchie  getHierarchie(){
    return hierarchie;
   }
   public Integer getAncienetee(){
    return ancienetee;
   }
   public Integer getAge(){
    return age;
   }
   
   public void setinfopersonnelle(){
    ConnectPostgres connex = new ConnectPostgres();
      try {
          Connection con = connex.getconnection();
          Statement stmt= con.createStatement();
          String requete = " select Matricule,idfhierarchie,dateembouche,EXTRACT(YEAR FROM age(now(), dateembouche)) as ancienne, EXTRACT(YEAR FROM age(now(), datedenaisance)) as age from detailleemploie  join candidat on detailleemploie.idfcandidat=candidat.idcandidat  where idfcandidat='"+getidcandidat()+"' ";
          System.out.println(requete);
          ResultSet donner = stmt.executeQuery(requete);
          Integer in = 0;
          while(donner.next()){
            matricule=donner.getString("Matricule");
            dateembouche=donner.getString("dateembouche");
            hierarchie.setidhierarchie(donner.getString("idfhierarchie"));
            hierarchie.findOne();
            ancienetee=donner.getInt("ancienne");
            age=donner.getInt("age");
          }
          stmt.close();
          con.close();
      } catch (Exception e) {
          System.out.println(e);
      }
   }
   //info
   
   Vector<HashMap<String,Object>>choixquestion =new Vector<HashMap<String,Object>>() ;
   Vector<HashMap<String,Object>> choixcritere= new Vector<HashMap<String,Object>>() ;

   public void setchoixquestion(HashMap<String,Object> r){
          choixquestion.add(r);
   }
   public Vector<HashMap<String,Object>> getchoixquestion(){
      return choixquestion;
   }
   public void setchoixcritere(HashMap<String,Object> r){
     choixcritere.add(r);
   }
   public Vector<HashMap<String,Object>> getchoixcritere(){
     return choixcritere;
   }

   @AmethodeSet(nomcolonne =  "idfdemande")
    public void setidfdemande(String d){
      idfdemande=d;
    }
   @AmethodeGet(nomcolonne ="idfdemande")
    public String getidfdemande(){
      return idfdemande;
    }

      HashMap<String,Object> session;
      public void setSession(HashMap<String,Object> s){
         session=s;
       }
      public HashMap<String,Object> getSession(){
          return session;
      }

   public Candidat(){  
   super();  
   super.setchild(this);  
      } 
@Set_value_jspannotation(nom_atribue= "idcandidat") 
 @AmethodeSet(nomcolonne =  "idcandidat")  
  public void setidcandidat(String string1){ 
 if(string1==null){ 
 idcandidat=super.newprimarykey().toUpperCase(); 
 }else{ 
 idcandidat= string1; 
 } 
} 
@Set_value_jspannotation(nom_atribue= "nom") 
 @AmethodeSet(nomcolonne =  "nom")  
 public void setnom(String integer1){ 
        nom= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "prenom") 
 @AmethodeSet(nomcolonne =  "prenom")  
 public void setprenom(String integer1){ 
        prenom= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "datedenaisance") 
 @AmethodeSet(nomcolonne =  "datedenaisance")  
 public void setdatedenaisance(Date date1){ 
      datedenaisance= date1; 
 } 
@Set_value_jspannotation(nom_atribue= "mail") 
 @AmethodeSet(nomcolonne =  "mail")  
 public void setmail(String integer1){ 
        mail= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "tel") 
 @AmethodeSet(nomcolonne =  "tel")  
 public void settel(String integer1){ 
        tel= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "depotdecandidature") 
 @AmethodeSet(nomcolonne =  "depotdecandidature")  
 public void setdepotdecandidature(Date date1){ 
      depotdecandidature= date1; 
 } 
@Set_value_jspannotation(nom_atribue= "idfsexe") 
 @AmethodeSet(nomcolonne =  "idfsexe")  
 public void setidfsexe(Integer double1){ 
      idfsexe= double1; 
     } 

   @AmethodeGet(nomcolonne ="idcandidat") 
   @APrimarykey(nomprimarykey = "idcandidat") 
   public String getidcandidat(){
       return idcandidat;
    } 
   @AmethodeGet(nomcolonne ="nom") 
   public String getnom(){  
       return nom;
    } 
   @AmethodeGet(nomcolonne ="prenom") 
   public String getprenom(){
       return prenom;
    } 
   @AmethodeGet(nomcolonne ="datedenaisance") 
   public Date getdatedenaisance(){
         return datedenaisance;
    } 
   @AmethodeGet(nomcolonne ="mail") 
   public String getmail(){ 
       return mail;
    } 
   @AmethodeGet(nomcolonne ="tel") 
   public String gettel(){
       return tel;
    } 
   @AmethodeGet(nomcolonne ="depotdecandidature") 
   public Date getdepotdecandidature(){
         return depotdecandidature;
    } 
   @AmethodeGet(nomcolonne ="idfsexe") 
 public Integer getidfsexe(){
       return idfsexe;
    } 

   
  @Urlannotation(index = "accuillecandidat.do",nomparametre={}) 
  public etu002087.framework.ModelView accuillecandidat(){ 
    Vector resulta= super.selectAllWithcondition("limit 3"); 
    ModelView model = new ModelView(); 
    model.addItem("nbr",0);
    model.addItem("liste",resulta);
    model.setnompage("candidat.jsp");
    return model; 
  }

  @Urlannotation(index = "insertcandidat.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String insertcandidat(){
    setidcandidat(null);
    super.insert(null);
    return "insert"; 
    } 

  @Urlannotation(index = "paginationcandidat.do",nomparametre={"nbr"})
  @Sessionannotation()
  public etu002087.framework.ModelView paginationcandidat(Integer nbr){
    ModelView model = new ModelView();
    Vector resulta= super.selectAllWithcondition(" offset "+nbr+" limit 3");
    if(nbr<=0){
            model.addItem("nbr",0);
    }else{
        model.addItem("nbr",nbr);
   }
    model.addItem("liste",resulta);
    model.setnompage("candidat.jsp");
    return model;
  }
  @Urlannotation(index = "listeemployerconger.do",nomparametre={})
  public  etu002087.framework.ModelView listeemployeconge(){

    Vector<Candidat> resulta = super.selectAllWithcondition(" join detailleemploie   on candidat.idcandidat = detailleemploie.idfcandidat limit 3");

    ModelView model = new ModelView(); 
    model.addItem("conge", new Congespecifie().selectAll());
    model.addItem("nbr",0);
    model.addItem("liste",resulta);
    model.setnompage("listeemployerconger.jsp");
    return model;
  }

  @Urlannotation(index = "listeemployercongerpagination.do",nomparametre={"nbr"})
  public  etu002087.framework.ModelView listeemployecongepagination(Integer nbr){

    Vector<Candidat> resulta = super.selectAllWithcondition(" join detailleemploie   on candidat.idcandidat = detailleemploie.idfcandidat offset "+nbr+" limit 3 ");
    ModelView model = new ModelView(); 
    model.addItem("liste",resulta);
    if(nbr<=0){
      model.addItem("nbr",0);
    }else{
      model.addItem("nbr",nbr);
    }
    model.addItem("conge", new Congespecifie().selectAll());
    model.setnompage("listeemployerconger.jsp");
    return model;
  }

  @Urlannotation(index = "modificationcandidat.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String modificationservice(){
    super.update(null);
    return "update"; 
  } 

  @Urlannotation(index = "deletecandidat.do",nomparametre={})
  public etu002087.framework.ModelView deletecandidat(){
      super.delete(null);
      Vector resulta= super.selectAllWithcondition("limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",resulta);
      model.setnompage("candidat.jsp");
      return model;
  } 
  public java.util.Date convertStringToDate(String dateString) throws java.text.ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = dateFormat.parse(dateString); // En cas d'erreur de conversion
    return date;
  }
  
  @Sessionannotation()
  @Urlannotation(index = "insertcandidature.do",nomparametre={"idsouscritere","description","datedebut","datefin"})
  public etu002087.framework.ModelView insertcandidature(String[] idsouscritere,String[] description,String[] datedebut,String[] datefin ){
      ModelView model = new ModelView(); 
      setidcandidat(null);
      String iddemande = (String) getSession().get("iddemande");
      setidfdemande(iddemande);
      super.insert(null);
      
      for(int i=0;i<description.length;i++){
        System.out.println(idsouscritere[i]);
        try {
          Cvcandidadetaille cvd= new  Cvcandidadetaille(idsouscritere[i],getidcandidat(),description[i],convertStringToDate(datedebut[i]) ,convertStringToDate(datefin[i]));
          cvd.setidcvcandidadetaille(null);
          cvd.insert(null);
        } catch (Exception e) {
          e.printStackTrace();
          System.out.println(e);
        }
       
      }
      getSession().put("idfcandidat", getidcandidat());
      
      
      Vector<Question> resulta = new Question().selectAllWithcondition( " where idfdemande='"+iddemande.toUpperCase()+"'");
      Vector<Question> res =new Vector<Question>();
      System.out.println(" where idfdemande='"+iddemande+"'   "+resulta.size());
      for(int i=0;i<resulta.size();i++){
        Question q = resulta.get(i);
          q.setchoix(q.getidquestion());
          res.add(q);
      }
      model.addItem("liste",res);
      model.setnompage("questioncv.jsp");
      return model;

      
  } 
   
  
  public void setchoix(String iddemande){
    ConnectPostgres connex = new ConnectPostgres();
      try {
        Connection con = connex.getconnection();
        Statement stmt= con.createStatement();
        String requete = "select note,choix,textquestion from reponsequetion join choixquestion on reponsequetion.idfchoixquestion = choixquestion.idchoixquestion join question on question.idquestion=choixquestion.idfquestion where idfdemande='"+iddemande+"' and idfcandidat='"+getidcandidat()+"'";
        System.out.println(requete);
        ResultSet donner = stmt.executeQuery(requete);
        Integer in = 0;
        while(donner.next()){
          HashMap<String,Object> choix = new HashMap<String,Object>();
          in = in+ donner.getInt("note");
          choix.put("note",donner.getInt("note"));
          choix.put("choix",donner.getString("choix"));
          choix.put("textquestion",donner.getString("textquestion"));
          setchoixquestion(choix);
        }
        requete = "select  nomcritere,nomdetaillecritere,note from cvcandidadetaille  join notecritere on cvcandidadetaille.idfdetaille_cr=notecritere.idfdetaille_cr  join detaille_critere on detaille_critere.iddetaille_cr  = notecritere.idfdetaille_cr join critere on critere.idcritere = detaille_critere.idfcrietere where idfdemande='"+iddemande+"' and idfcandidat='"+getidcandidat()+"'";
        System.out.println(requete);
        donner = stmt.executeQuery(requete);
        while(donner.next()){
          HashMap<String,Object> choix = new HashMap<String,Object>();
          choix.put("nomcritere",donner.getString("nomcritere"));
          choix.put("nomdetaillecritere",donner.getString("nomdetaillecritere"));
          choix.put("note",donner.getInt("note"));
          setchoixcritere(choix);
          in = in+ donner.getInt("note");
        }
        setnotgenerale(in);
        stmt.close();
        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }
  }
  
//etoeto
  @Sessionannotation()
  @Urlannotation(index = "listedemandeclient.do",nomparametre={"iddemande"})
  public etu002087.framework.ModelView listedemandeclient(String iddemande ){
    Vector<Candidat> resulta = super.selectAllWithcondition(" LEFT JOIN detailleemploie ON candidat.idcandidat = detailleemploie.idfcandidat where detailleemploie.idfcandidat is null and idfdemande='"+iddemande+"'");
    Vector<Candidat> re = new Vector<Candidat>();
    for(int i=0;i<resulta.size();i++){
        Candidat candidat = (Candidat) resulta.get(i);
        candidat.setchoix(iddemande);
        System.out.println("llllllllll");
        re.add(candidat);
    }
    // Triez le vecteur en ordre décroissant
    Collections.sort(re, new Comparator<Candidat>() {
      @Override
      public int compare(Candidat candidat1, Candidat candidat2) {
          // Triez en ordre décroissant des scores
          return Integer.compare(candidat2.getnotegenerale(), candidat1.getnotegenerale());
      }
    });
    ModelView model = new ModelView(); 
    model.addItem("iddemande",iddemande);
    model.addItem("liste",re);
    //model.setnompage("listenotecandidat.jsp");
    model.setnompage("listecandidature.jsp");
    return model;

  }
//page maneo ny detaille na cv n'olona ray
  @Sessionannotation()
  @Urlannotation(index = "voirdetaillecvcandidat.do",nomparametre={"idcandidat","iddemande"})
  public etu002087.framework.ModelView voirdetaillecvcandidat(String idcandidat,String iddemande ){
    Vector<Candidat> re = new Vector<Candidat>();
    Candidat candidat = new Candidat();
    re.add(candidat);

    candidat.setidcandidat(idcandidat);
    candidat.findOne();
    candidat.setchoix(iddemande);
    ModelView model = new ModelView(); 
    model.addItem("iddemande",iddemande);
    model.addItem("liste",re);
    model.setnompage("detaillecvcandidature.jsp");
    // model.setnompage("listecandidature.jsp");
    return model;

  }

  
  @Urlannotation(index = "monfichedepay.do",nomparametre={"idfcandidat"})
  public etu002087.framework.ModelView monfichiedepay(String idfcandidat){
    setidcandidat(idfcandidat);
    super.findOne();
    setHeurAbsence();
    setHeurSup();
    setHeurTravaille();//heur de travaille /taux en heur/salaire de base
    setlisteprime();
    setMajoration();//mi calcule ny prix de majoration rahamisy heur sup
    setIrsa();
    setListecnaps();
    setinfopersonnelle();
    ModelView resulta = new ModelView();
    resulta.addItem("moi",this);
    resulta.setnompage("fichedepay.jsp");
    return resulta;
  }

  @Sessionannotation()
  @Urlannotation(index = "etatdepaysuph1.do",nomparametre={})
  public etu002087.framework.ModelView etatdepay(){
    Vector<Candidat> resulta =  new  Vector<Candidat>();
    String idservice = new String();
    String iduser = (String) getSession().get("iduser");
    ConnectPostgres connex = new ConnectPostgres();
    try {
      Connection con = connex.getconnection();
      Statement stmt= con.createStatement();
      String requete = "select idservice from detailleemploie join Hierarchie on detailleemploie.idfhierarchie=Hierarchie.idhierarchie join service on service.idservice=Hierarchie.idfservice where idfcandidat='"+iduser+"'";
      ResultSet donner = stmt.executeQuery(requete);
      Integer in = 0;
      while(donner.next()){
        idservice=donner.getString("idservice");
      }
      donner.close();
      stmt.close();
      requete = " select distinct(idfcandidat) from detailleemploie join Hierarchie on detailleemploie.idfhierarchie=Hierarchie.idhierarchie join service on service.idservice=Hierarchie.idfservice where idservice='"+idservice+"' ";
       donner = stmt.executeQuery(requete);
      while(donner.next()){
        Candidat candidat = new Candidat();
        candidat.setidcandidat(donner.getString("idfcandidat"));
        candidat.findOne();
        candidat.setHeurAbsence();
        candidat.setHeurSup();
        candidat.setHeurTravaille();//heur de travaille /taux en heur/salaire de base
        candidat.setlisteprime();
        candidat.setMajoration();//mi calcule ny prix de majoration rahamisy heur sup
        candidat.setIrsa();
        candidat.setListecnaps();
        candidat.setinfopersonnelle();
        resulta.add(candidat);
      }

      con.close();
  } catch (Exception e) {
      System.out.println(e);
  }
    getSession().put("idserviceuser", idservice);

    ModelView model = new ModelView();
    model.addItem("liste",resulta);
    model.setnompage("etatdepay.jsp");
    return model;
  }


  @Sessionannotation()
  @Urlannotation(index = "etatdepaysudo.do",nomparametre={})
  public etu002087.framework.ModelView etatdepaysudo(){
    Vector<Candidat> res = super.selectAllWithcondition(" LEFT JOIN detailleemploie ON candidat.idcandidat = detailleemploie.idfcandidat where detailleemploie.idfcandidat is not null ");//etoprobleme
    Vector<Candidat> resulta = new  Vector<Candidat>();
    String idservice = new String();
    String iduser = (String) getSession().get("iduser");

    for(int i=0;i<res.size();i++){
        Candidat candidat = (Candidat) res.get(i);
        System.out.println("candidat");
        candidat.setHeurAbsence();
        candidat.setHeurSup();
        System.out.println("absence heure sup");
        candidat.setHeurTravaille();//heur de travaille /taux en heur/salaire de base
        System.out.println("heure");
        candidat.setlisteprime();
        System.out.println("prime ");
        candidat.setMajoration();//mi calcule ny prix de majoration rahamisy heur sup
        candidat.setIrsa();
        System.out.println("irsa ");
        candidat.setListecnaps();
        candidat.setinfopersonnelle();
        System.out.println("info cnpas");
        resulta.add(candidat);
    }
    ModelView model = new ModelView();
    model.addItem("liste",resulta);
    model.setnompage("etatdepay.jsp");
    return model;
  }

  //creation matricule
    public String getFirstFourLetters1(String mot,int nbr) {
      if (mot != null && mot.length() >= nbr) {
          return mot.substring(0, nbr);
      } else {
          return mot;
      }
    }
    public String getnbrelement1(){
        Connection  con=new ConnectPostgres().getconnection();
        String requete = new String();
        requete="SELECT nextval('matriculesequence')";
        int resulta=0;
        try {
            Statement stmt= con.createStatement();
            ResultSet donner = stmt.executeQuery(requete);
            while(donner.next()){
                resulta=donner.getInt(1);
            }
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return Integer.toString(resulta);
    }
    public String newmatrice(){
        String numerovalue=getnbrelement1();
        return getFirstFourLetters1("MATRICULE",4)+getFirstFourLetters1("000000000",5-numerovalue.length())+numerovalue;
    }

  
  @Urlannotation(index = "embauchecandidat.do",nomparametre={"idcandidat"})
  public etu002087.framework.ModelView  embauchecandidat(String idcandidat){
    System.out.println("jjjjjjjjj");
    ConnectPostgres connex = new ConnectPostgres();
    try {
      String idservice=new String();
      String idhierarchie = new String();
      Connection con = connex.getconnection();
      Statement stmt= con.createStatement();
      String requete = "select idfhierarchie,idfservice from demande_besoin join candidat on demande_besoin.iddemande = candidat.idfdemande where idcandidat='"+idcandidat+"'";
      ResultSet donner = stmt.executeQuery(requete);
      Integer in = 0;
      while(donner.next()){
        // idservice=donner.getString("idservice");
          idservice=donner.getString("idfservice");
          idhierarchie=donner.getString("idfhierarchie");
      }
      donner.close();
      String matricule=newmatrice();
      stmt.executeUpdate("insert into detailleemploie(idfcandidat,idfhierarchie,matricule,dateembouche,idfhierarchiegenerale) values ('"+idcandidat+"','"+idhierarchie+"','"+matricule+"',now(),'GENE00003')");
      stmt.executeUpdate("insert into login_employee values ('"+idcandidat+"','metrina50')");

      stmt.close();
      con.close();
  } catch (Exception e) {
      System.out.println(e);
  }
  return  listeemployesudo();
    //page liste employee
  }

  @Urlannotation(index = "listeemployesudo.do",nomparametre={})
  public etu002087.framework.ModelView  listeemployesudo(){
    Vector<HashMap<String,Object>> resulta= new Vector<HashMap<String,Object>>();
    ConnectPostgres connex = new ConnectPostgres();
    try {
      Connection con = connex.getconnection();
      Statement stmt= con.createStatement();
      String requete ="select idfcandidat,nom,prenom,tel,nomhierarchie,EXTRACT(YEAR FROM age(now(), dateembouche)) as ancienete,EXTRACT(YEAR FROM age(now(), datedenaisance)) as age from candidat join detailleemploie on candidat.idcandidat=detailleemploie.idfcandidat join hierarchie on detailleemploie.idfhierarchie=hierarchie.idhierarchie";
      ResultSet donner = stmt.executeQuery(requete);
      Integer in = 0;
     
      while(donner.next()){
        HashMap<String,Object> sous= new HashMap<String,Object>();
        sous.put("idfcandidat", donner.getString("idfcandidat"));
        sous.put("nom", donner.getString("nom"));
        sous.put("prenom", donner.getString("prenom"));
        sous.put("tel", donner.getString("tel"));
        sous.put("nomhierarchie", donner.getString("nomhierarchie"));
        sous.put("ancienete", donner.getInt("ancienete"));
        sous.put("age", donner.getInt("age"));
        resulta.add(sous);
      }
      stmt.close();
      con.close();
  } catch (Exception e) {
      System.out.println(e);
  }
    ModelView model = new ModelView();
    model.addItem("liste",resulta );
    model.addItem("lien","/RHgestion/sudo.do");

    model.setnompage("listeemployesudo.jsp");
    return model;
  }

  @Sessionannotation()
  @Urlannotation(index = "listeemployesup.do",nomparametre={})
  public etu002087.framework.ModelView  listeemployesup(){
    String idservice= (String) getSession().get("idserviceuser");
    Vector<HashMap<String,Object>> resulta= new Vector<HashMap<String,Object>>();
    ConnectPostgres connex = new ConnectPostgres();
    try {
      Connection con = connex.getconnection();
      Statement stmt= con.createStatement();
      String requete ="select idfcandidat,nom,prenom,tel,nomhierarchie,EXTRACT(YEAR FROM age(now(), dateembouche)) as ancienete,EXTRACT(YEAR FROM age(now(), datedenaisance)) as age from candidat join detailleemploie on candidat.idcandidat=detailleemploie.idfcandidat join hierarchie on detailleemploie.idfhierarchie=hierarchie.idhierarchie where idfservice='"+idservice+"'";
      ResultSet donner = stmt.executeQuery(requete);
      Integer in = 0;
     
      while(donner.next()){
        HashMap<String,Object> sous= new HashMap<String,Object>();
        sous.put("idfcandidat", donner.getString("idfcandidat"));
        sous.put("nom", donner.getString("nom"));
        sous.put("prenom", donner.getString("prenom"));
        sous.put("tel", donner.getString("tel"));
        sous.put("nomhierarchie", donner.getString("nomhierarchie"));
        sous.put("ancienete", donner.getInt("ancienete"));
        sous.put("age", donner.getInt("age"));
        resulta.add(sous);
      }
      stmt.close();
      con.close();
  } catch (Exception e) {
      System.out.println(e);
  }
    ModelView model = new ModelView();
    model.addItem("liste",resulta );
    model.addItem("lien","/RHgestion/superieur.do");

    model.setnompage("listeemployesudo.jsp");
    return model;
  }





} 
