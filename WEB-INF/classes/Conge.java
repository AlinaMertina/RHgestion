package etu002087.conge;
 import java.util.HashMap;
import java.util.Vector;
import generaliser.AmethodeSet;
import generaliser.Generaliser; 
import generaliser.ANomTable; 
import generaliser.Adatabase; 
import generaliser.AmethodeGet; 
import generaliser.APrimarykey; 
import generaliser.Dateformat; 


import java.util.Date; 
import etu002087.framework.Urlannotation; 
import etu002087.framework.ModelView; 
import etu002087.framework.Scopeannotation; 
import etu002087.framework.Set_value_jspannotation; 
import etu002087.framework.Sessionannotation; 
import etu002087.framework.Gsonannotation; 


import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import etu002087.demandebesoin.Candidat;
import etu002087.demandebesoin.ConnectPostgres;
import java.sql.*;

@ANomTable(nomtable = "conge", nbrclonne =5,nomsequence = "congesequence")
@Adatabase(nombase = "rh_employee", typebase= "postgres",nomuser= "postgres",password= "root",port="5432") 
public class Conge extends Generaliser{ 
   String idconger;
   String idfcandidat;
   Date datedebut;
   Date datefin;
   String raison;
   Integer jours;
   Integer nombrerestant;
   Congespecifie congespecifie;
   public void setCongespecifie(){
    congespecifie= new Congespecifie();
    congespecifie.setidcongespecifie(getraison());
    congespecifie.findOne();
   }
   public Congespecifie getCongespecifie(){
    return  congespecifie;
   }
   public void setnombrerestant(Integer no){
      nombrerestant=no;
   }
   public Integer getnombrerestant(){
       return nombrerestant;
   }

   public void setjours(Integer i){
        jours=i;
   }
   public Integer getjours(){
        return jours;
   }
   

      HashMap<String,Object> session;
      public void setSession(HashMap<String,Object> s){
         session=s;
       }
      public HashMap<String,Object> getSession(){
          return session;
      }

   public Conge(){  
   super();  
   super.setchild(this);  
      } 
@Set_value_jspannotation(nom_atribue= "idconger") 
 @AmethodeSet(nomcolonne =  "idconger")  
  public void setidconger(String string1){ 
 if(string1==null){ 
 idconger=super.newprimarykey().toUpperCase(); 
 }else{ 
 idconger= string1; 
 } 
} 
@Set_value_jspannotation(nom_atribue= "idfcandidat") 
 @AmethodeSet(nomcolonne =  "idfcandidat")  
 public void setidfcandidat(String integer1){ 
        idfcandidat= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "datedebut") 
 @AmethodeSet(nomcolonne =  "datedebut")  
 public void setdatedebut(Date date1){ 
      datedebut= date1; 
 } 
@Set_value_jspannotation(nom_atribue= "datefin") 
 @AmethodeSet(nomcolonne =  "datefin")  
 public void setdatefin(Date date1){ 
      datefin= date1; 
 } 
@Set_value_jspannotation(nom_atribue= "raison") 
 @AmethodeSet(nomcolonne =  "raison")  
 public void setraison(String string1){ 
      raison= string1; 
     } 

   @AmethodeGet(nomcolonne ="idconger") 
   @APrimarykey(nomprimarykey = "idconger") 
   public String getidconger(){
       return idconger;
    } 
   @AmethodeGet(nomcolonne ="idfcandidat") 
   public String getidfcandidat(){
       return idfcandidat;
    } 
   @AmethodeGet(nomcolonne ="datedebut") 
   public Date getdatedebut(){
         return datedebut;
    } 
   @AmethodeGet(nomcolonne ="datefin") 
   public Date getdatefin(){
         return datefin;
    } 
   @AmethodeGet(nomcolonne ="raison") 
   public String getraison(){
       return raison;
    } 
    
  @Urlannotation(index = "accuilleconge.do",nomparametre={}) 
  public etu002087.framework.ModelView accuilleconge(){ 
    Vector resulta= super.selectAllWithcondition("limit 3"); 
    ModelView model = new ModelView(); 
    model.addItem("nbr",0);
    model.addItem("liste",resulta);
    model.setnompage("conge.jsp");
    return model; 
  }

  @Urlannotation(index = "insertconge.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String insertconge(){
    setidconger(null);
    super.insert(null);
    return "insert"; 
    } 

  @Urlannotation(index = "paginationconge.do",nomparametre={"nbr"})
  @Sessionannotation()
  public etu002087.framework.ModelView paginationconge(Integer nbr){
    ModelView model = new ModelView();
    Vector resulta= super.selectAllWithcondition(" offset "+nbr+" limit 3");
    if(nbr<=0){
            model.addItem("nbr",0);
    }else{
        model.addItem("nbr",nbr);
   }
    model.addItem("liste",resulta);
    model.setnompage("conge.jsp");
    return model;
  }

  @Urlannotation(index = "modificationconge.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String modificationservice(){
    super.update(null);
    return "update"; 
  } 

  @Urlannotation(index = "deleteconge.do",nomparametre={})
  public etu002087.framework.ModelView deleteconge(){
      super.delete(null);
      Vector resulta= super.selectAllWithcondition("limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",resulta);
      model.setnompage("conge.jsp");
      return model;
  } 
  @Urlannotation(index = "congeemploye.do",nomparametre={"idfcandidat"})
  public etu002087.framework.ModelView congeemploye(String  idfcandidat){
      Vector resulta= super.selectAllWithcondition(" where idfcandidat='"+idfcandidat+"' limit 3");
      Vector<Conge> re = new Vector();

      for(int i=0;i<resulta.size();i++){
          Conge conge = (Conge) resulta.get(i);
          conge.setjours( getDifferenceDays( conge.getdatedebut(), conge.getdatefin() ));
          re.add(conge);

      }
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",re);
      model.addItem("idfcandidat",idfcandidat);
      //model.setnompage("Conge.jsp");
      return model;
  } 

  public static Integer getDifferenceDays(Date date1, Date date2) {
    long diffInMillies = Math.abs(date2.getTime() - date1.getTime());
    return Integer.parseInt(Long.toString(TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS)));
  
  }

  @Urlannotation(index = "congeemployepagination.do",nomparametre={"idfcandidat","nbr"})
  public etu002087.framework.ModelView congeemployepagination(String  idfcandidat,Integer nbr){
      Vector resulta= super.selectAllWithcondition(" where idfcandidat='"+idfcandidat+"' offset "+nbr+" limit 3 ");
      Vector<Conge> re = new Vector();

      for(int i=0;i<resulta.size();i++){
          Conge conge = (Conge) resulta.get(i);
          conge.setjours( getDifferenceDays( conge.getdatedebut(), conge.getdatefin() ));
          re.add(conge);

      }

      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",re);
      model.setnompage("Conge.jsp");
      return model;
  } 

  
  @Urlannotation(index = "pageinsertcongehand.do",nomparametre={"idfcandidat"})
  public etu002087.framework.ModelView pageinsertcongehand(String idfcandidat){
      ModelView model = new ModelView(); 
      model.addItem("idfcandidat",idfcandidat);
      model.addItem("liste",new Listeconge().selectAll());
      model.setnompage("Setconge.jsp");
      return model;
  } 

 
  
  @Urlannotation(index = "insertcongehand.do",nomparametre={})
  public etu002087.framework.ModelView insertcongehand(){
      setidconger(null);
      super.insert(null);
      Vector<Candidat> resulta = super.selectAllWithcondition(" join detailleemploie   on candidat.idcandidat = detailleemploie.idfcandidat limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("idfcandidat",getidfcandidat());
      model.addItem("liste",resulta);
      model.setnompage("listeemployerconger.jsp");
      return model;
  } 
  public Boolean demandecongefirstcontrante(String idpersonne){
    ConnectPostgres connex = new ConnectPostgres();
    try {
      Connection con = connex.getconnection();
      Statement stmt= con.createStatement();
      String requete = "select DATE_PART('year', age(now(), dateembouche)) as annee from detailleemploie where idfcandidat='"+idpersonne+"'";
      System.out.println(requete);
      ResultSet donner = stmt.executeQuery(requete);
      int anne=0;
      while(donner.next()){
        anne=donner.getInt("annee");
      }
      
      stmt.close();
      con.close();
      if(anne>0){
        return true;
      }else{
        return false;
      }
    } catch (Exception e) {
        System.out.println(e);
    }
    return false;
  }

  @Sessionannotation()
  @Urlannotation(index = "demadeconge.do",nomparametre={"idpersonne","idconge"})
  public ModelView demandeconge(String idpersonne,String idconge ){
      if(demandecongefirstcontrante(idpersonne)==true){
         return this.insertcongerautre(idconge,idpersonne);
      }else{
        ModelView model = new ModelView(); 
     
        model.addItem("conge", new Congespecifie().selectAllWithcondition(" where dureejours=0"));
       
        model.setnompage("errorconge.jsp");
        return model;
      }
     
  }
  //detaille congee 
  public int nombreDeDepart(String date){
    ConnectPostgres connex = new ConnectPostgres();
    try {
      Connection con = connex.getconnection();
      Statement stmt= con.createStatement();
      String requete = "select DATE_PART('year', age(now(),'"+date+"'::date)) as annee ";
      System.out.println(requete);
      ResultSet donner = stmt.executeQuery(requete);
      int anne=0;
      while(donner.next()){
        anne=donner.getInt("annee");
      }
      
      stmt.close();
      con.close();
      if(anne>=2){
        return 60;
      }else{
        return 30;
      }
    } catch (Exception e) {
        System.out.println(e);
    }
    return 0;
  }
  public int nombredejourdifference(String datedebut,String datefin){
    ConnectPostgres connex = new ConnectPostgres();
    try {
      Connection con = connex.getconnection();
      Statement stmt= con.createStatement();
      String requete = "select '"+datefin+"'::date-'"+datedebut+"'::date as annee ";
      System.out.println(requete);
      ResultSet donner = stmt.executeQuery(requete);
      int anne=0;
      while(donner.next()){
        anne=donner.getInt("annee");
      }
      
      stmt.close();
      con.close();
      return anne;
    } catch (Exception e) {
        System.out.println(e);
    }
    return 0;
  }

  @Urlannotation(index = "detailleconge.do",nomparametre={"idfcandidat"})
  public ModelView detaillecongee(String idfcandidat){
    Vector<Conge> resulta = super.selectAllWithcondition(" where datedebut >= (SELECT CURRENT_DATE - interval '2 years') and idfcandidat='"+idfcandidat+"' order by datedebut ");
    
    int joursdepart =0;
    int initialejoursdepart=0;
    if(resulta.size()>0){
      Conge conge = (Conge) resulta.get(0);
     

      joursdepart=nombreDeDepart(conge.getdatedebut().toString());
      
      initialejoursdepart=joursdepart;
      Vector<Conge> resultafin = new Vector<Conge>();
      for(int i=0; i < resulta.size() ;i++){
        Conge con = (Conge) resulta.get(i);
        con.setjours( nombredejourdifference(con.getdatedebut().toString(),con.getdatefin().toString()));
        System.out.println(con.getraison());
        con.setCongespecifie();
        joursdepart=joursdepart-con.getjours();
        con.setnombrerestant(joursdepart);
        resultafin.add(con);
      }
      ModelView model = new ModelView(); 

      model.addItem("nombredeconge", joursdepart );
      model.addItem("detailleconge", resultafin );
      model.setnompage("Conge.jsp");
      return model;
    }
    ModelView model = new ModelView(); 
      model.addItem("conge", new Congespecifie().selectAllWithcondition(" where dureejours=0"));

      model.addItem("nombredeconge", initialejoursdepart );
      model.addItem("detailleconge", resulta );
      model.setnompage("Conge.jsp");
      return model;

  }

  @Sessionannotation()
  @Urlannotation(index = "pagesetabsence.do",nomparametre={"idcandidat"})
  public ModelView pageSetAbsence(String idconge){
    getSession().put("idcandidatabsent", idconge);
    ModelView model = new ModelView(); 
    model.setnompage("Setabsence.jsp");
    return model;
  }

  
  @Sessionannotation()
  @Urlannotation(index = "pageinsertabsence.do",nomparametre={"debut","fin"})
  public ModelView pageinsertabsence(String debut,String fin){
    String idcondidatabsent =(String) getSession().get("idcandidatabsent");
    this.setidconger(null);
    this.setidfcandidat(idcondidatabsent);
    this.setdatedebut( Dateformat.convertirStringEnDate(debut) );
    this.setdatefin( Dateformat.convertirStringEnDate(fin) );
    this.setraison("CONG00039");
    super.insert(null);
    System.out.println("hhhhhhhh");
    ModelView model = new ModelView(); 
    model.setnompage("Setabsence.jsp");
    return model;
  }

  @Urlannotation(index = "listeabsence.do",nomparametre={"idfcandidat"})
  public ModelView absenceemploye(String idfcandidat){
    Vector  resulta = super.selectAllWithcondition(" where idfcandidat='"+idfcandidat+"' and raison='CONG00039' ");
    int joursdepart =0;
    int initialejoursdepart=0;
    if(resulta.size()>0){
      Conge conge = (Conge) resulta.get(0);
      System.out.println(resulta.size());

      joursdepart=nombreDeDepart(conge.getdatedebut().toString());
      
      initialejoursdepart=joursdepart;
      Vector<Conge> resultafin = new Vector<Conge>();
      for(int i=0; i < resulta.size() ;i++){
        Conge con = (Conge) resulta.get(i);
        con.setjours( nombredejourdifference(con.getdatedebut().toString(),con.getdatefin().toString()));
        System.out.println(con.getraison());
        con.setCongespecifie();
        joursdepart=joursdepart-con.getjours();
        con.setnombrerestant(joursdepart);
        resultafin.add(con);
      }
      ModelView model = new ModelView(); 

      model.addItem("nombredeconge", joursdepart );

      model.addItem("detailleconge", resultafin );
      model.setnompage("listeabsence.jsp");
      return model;
    }
    ModelView model = new ModelView(); 
      model.addItem("conge", new Congespecifie().selectAllWithcondition(" where dureejours=0"));

      model.addItem("nombredeconge", initialejoursdepart );
      model.addItem("detailleconge", resulta );
      model.setnompage("listeabsence.jsp");
      return model;

  }

  // @Sessionannotation()
  // @Urlannotation(index = "pageinsertionconger.do",nomparametre={"idfconger","idfcandidat"})
  public ModelView insertcongerautre(String idconger,String idfcandidat){
    System.out.println("jjjjjjjlllllllll");
    getSession().put("idconger", idconger);
    getSession().put("idfcandidatconger", idfcandidat);
    System.out.println("jjjjjjj");
    ModelView model = new ModelView(); 
    model.setnompage("Setconge.jsp");
    return model;
  }

  @Sessionannotation()
  @Urlannotation(index = "insertionconger.do",nomparametre={"debut","fin"})
  public ModelView insertdonneconge(String debut,String fin){
    String idconger =(String) getSession().get("idconger");
    String idfcandidat = (String) getSession().get("idfcandidatconger");
    this.setidconger(null);
    this.setidfcandidat(idfcandidat);
    this.setdatedebut( Dateformat.convertirStringEnDate(debut) );
    this.setdatefin( Dateformat.convertirStringEnDate(fin) );
    this.setraison(idconger);
    super.insert(null);
    System.out.println("hhhhhhhh");
    ModelView model = new ModelView(); 
    model.setnompage("Setconge.jsp");
    return model;

  }
  
  @Sessionannotation()
  @Urlannotation(index = "pageinsertionconger.do",nomparametre={})
  public ModelView pageinsertconge(){
    ModelView model = new ModelView(); 
    model.addItem("liste",new Congespecifie().selectAll());
    model.setnompage("Setconge.jsp");
    return model;
  }

  public Boolean secondtest(Connection con,String datedebut) {
    try {
     
        String requete = "select ('"+datedebut+"'::date - now()::date ) as jours";
        System.out.println(requete);
        Statement stmt= con.createStatement();
        ResultSet donner = stmt.executeQuery(requete);
        int jours=0;
        while(donner.next()){
          jours=donner.getInt("jours");
        }
        if(jours<15){
            return false;
        }else{
          return true;
        }
    } catch (Exception e) {
     System.out.println(e);
     try {
      con.close();
     } catch (Exception a) {
      System.out.println(a);
     }
     
    }
    return false;
  }
  public Boolean troisiemetest(Connection con,String iduser){
    try {
      String requete = "select sum ( datefin::date - datedebut::date ) as jours from conge where datedebut>=(SELECT CURRENT_DATE - INTERVAL '2 year') and idfcandidat='"+iduser+"';";
      Statement stmt= con.createStatement();
      ResultSet donner = stmt.executeQuery(requete);
      System.out.println(requete);
      int jours=0;
      while(donner.next()){
        jours=donner.getInt("jours");
        System.out.println("int   "+jours);
      }
      if(jours<60){
          return true;
      }else{
        return false;
      }
  } catch (Exception e) {
   System.out.println(e);
   try {
    con.close();
   } catch (Exception a) {
    System.out.println(a);
   }
   
  }
  return false;

  }
  public int nombredejoursconge(Connection con,String datedebut,String datefin){
    int jours=0;
    try {
      String requete = "select ('"+datefin+"'::date - '"+datedebut+"'::date ) as jours ";
      Statement stmt= con.createStatement();
      ResultSet donner = stmt.executeQuery(requete);
       jours=0;
      while(donner.next()){
        jours=donner.getInt("jours");
      }
        } catch (Exception e) {
          System.out.println(e);
            try {
              con.close();
            } catch (Exception a) {
              System.out.println(a);
            }
        }
    return jours;
  }

  @Sessionannotation()
  @Urlannotation(index = "insertcongevalider.do",nomparametre={"idconger","datedebut","datefin"})
  public ModelView insertcongevalider(String idconger,String datedebut,String datefin){
    String iduser =(String) getSession().get("iduser");
    Congespecifie congespe = new Congespecifie();
    congespe.setidcongespecifie(idconger);
    congespe.findOne();

    if(demandecongefirstcontrante(iduser)==true){
     
      
      ConnectPostgres connex = new ConnectPostgres();
      try {
        Connection con = connex.getconnection();
        if(secondtest(con,datedebut)==false){
          ModelView model = new ModelView(); 
          model.addItem("error","Votre demande devrais etre deposer 15 jours avant ");
          model.addItem("lien","/RHgestion/pageinsertionconger.do");
          model.setnompage("errorpage.jsp");
          return model;
        }else{
          //troisieme test
          if(nombredejoursconge(con,datedebut,datefin)>congespe.getdureejours() && congespe.getdureejours()!=0 ){
            ModelView model = new ModelView(); 
            model.addItem("error","Votre nombre de conge demande depace la duree permise par l'entreprise  qui est de "+congespe.getdureejours());
            model.addItem("lien","/RHgestion/pageinsertionconger.do");
            model.setnompage("errorpage.jsp");
            return model;
          }
          Statement stmt= con.createStatement();
          System.out.println("requete");
          Conge conge= new Conge();
          conge.setidconger(null);
          String requete = "insert into conge (idconger,idfcandidat,datedebut,datefin,raison) values ('"+conge.getidconger()+"','"+iduser+"','"+datedebut+"'::date,'"+datefin+"'::date,'"+idconger+"') ";
          System.out.println(requete);
          stmt.executeUpdate(requete);
          if( troisiemetest(con,iduser)== false){
            conge.delete(null);
            ModelView model = new ModelView(); 
            model.addItem("error","Vous ne pouvez pas prendre de conge car vous avez depas le nombre de votre conge  cette annee ");
            model.addItem("lien","/RHgestion/employee.do");
            model.setnompage("errorpage.jsp");
            return model;
          }

          stmt.close();
          con.close();
        }
        
      } catch (Exception e) {
          System.out.println(e);
      }
       return this.pageinsertconge();
   }else{
     ModelView model = new ModelView(); 
     model.addItem("error","Vous ne pouvez pas prendre de conge car vous n' avez pas depace 1 ans de travaille dans cette entreprise ");
     model.addItem("lien","/RHgestion/employee.do");
     model.setnompage("errorpage.jsp");
     return model;
   }

  }

  @Sessionannotation()
  @Urlannotation(index = "pagevalidationsh1.do",nomparametre={})
  public ModelView pagevalidationsh1(){
    String serviceuser= (String) getSession().get("idserviceuser");
   Vector<HashMap<String,Object>> resulta = new Vector<HashMap<String,Object>>();
    ConnectPostgres connex = new ConnectPostgres();
    try {
      Connection con = connex.getconnection();
      Statement stmt= con.createStatement();
      String requete = "select idconger,nomconge,nomhierarchie,datedebut,datefin,conge.idfcandidat from conge join detailleemploie on conge.idfcandidat=detailleemploie.idfcandidat join hierarchie on hierarchie.idhierarchie=detailleemploie.idfhierarchie join congespecifie on congespecifie.idcongespecifie=conge.Raison  where hierarchie.idfservice = '"+serviceuser+"' and idsuperieur is null ";
      ResultSet donner = stmt.executeQuery(requete);
      while(donner.next()){
        HashMap<String,Object> value = new HashMap<String,Object>();
        value.put("idconger", donner.getString("idconger"));
        value.put("nomconge", donner.getString("nomconge"));
        value.put("nomhierarchie", donner.getString("nomhierarchie"));
        value.put("datedebut", donner.getString("datedebut"));
        value.put("datefin", donner.getString("datefin"));
        value.put("idfcandidat", donner.getString("idfcandidat"));
          resulta.add(value);
      }
      donner.close();
      stmt.close();
      con.close();
  } catch (Exception e) {
      System.out.println(e);
  }
    ModelView model = new ModelView(); 
 
    model.addItem("liste",resulta);
    model.setnompage("validationconge.jsp");
    return model;
  }
  @Sessionannotation()
  @Urlannotation(index = "insertvalidationsh1.do",nomparametre={"idconger"})
  public ModelView insertvalidationsh1(String[] idconger){
    String iduser= (String) getSession().get("iduser");
    String requete = new String();
    ConnectPostgres connex = new ConnectPostgres();
    try {
      Connection con = connex.getconnection();
      Statement stmt= con.createStatement();
      for(int i=0;i<idconger.length;i++){
        requete = "update conge set idsuperieur='"+iduser+"' where idconger='"+idconger[i]+"'";
        stmt.executeUpdate(requete);
      }
      stmt.close();
      con.close();
  } catch (Exception e) {
      System.out.println(e);
  }
    return pagevalidationsh1();
  }

  @Sessionannotation()
  @Urlannotation(index = "pagevalidationsudo.do",nomparametre={})
  public ModelView pagevalidationsudo(){
    String serviceuser= (String) getSession().get("idserviceuser");
   Vector<HashMap<String,Object>> resulta = new Vector<HashMap<String,Object>>();
    ConnectPostgres connex = new ConnectPostgres();
    try {
      Connection con = connex.getconnection();
      Statement stmt= con.createStatement();
      String requete = "select idconger,nomconge,nomhierarchie,datedebut,datefin,conge.idfcandidat from conge join detailleemploie on conge.idfcandidat=detailleemploie.idfcandidat join hierarchie on hierarchie.idhierarchie=detailleemploie.idfhierarchie join congespecifie on congespecifie.idcongespecifie=conge.Raison  where  idsuperieur is not null and idsudo is null ";
      ResultSet donner = stmt.executeQuery(requete);
      while(donner.next()){
        HashMap<String,Object> value = new HashMap<String,Object>();
        value.put("idconger", donner.getString("idconger"));
        value.put("nomconge", donner.getString("nomconge"));
        value.put("nomhierarchie", donner.getString("nomhierarchie"));
        value.put("datedebut", donner.getString("datedebut"));
        value.put("datefin", donner.getString("datefin"));
        value.put("idfcandidat", donner.getString("idfcandidat"));
          resulta.add(value);
      }
      donner.close();
      stmt.close();
      con.close();
  } catch (Exception e) {
      System.out.println(e);
  }
    ModelView model = new ModelView(); 
 
    model.addItem("liste",resulta);
    model.setnompage("validationcongesudo.jsp");
    return model;
  }


  @Sessionannotation()
  @Urlannotation(index = "pagecongevalideemp.do",nomparametre={})
  public ModelView pagecongevalideemp(){
    String idcandidat =(String) getSession().get("iduser");
    String serviceuser= (String) getSession().get("idserviceuser");
   Vector<HashMap<String,Object>> resulta = new Vector<HashMap<String,Object>>();
    ConnectPostgres connex = new ConnectPostgres();
    try {
      Connection con = connex.getconnection();
      Statement stmt= con.createStatement();
      String requete = "select idconger,nomconge,nomhierarchie,datedebut,datefin,conge.idfcandidat from conge join detailleemploie on conge.idfcandidat=detailleemploie.idfcandidat join hierarchie on hierarchie.idhierarchie=detailleemploie.idfhierarchie join congespecifie on congespecifie.idcongespecifie=conge.Raison  where  idsuperieur is not null and idsudo is not null and conge.idfcandidat='"+idcandidat.toUpperCase()+"' ";
      System.out.println(requete);
      ResultSet donner = stmt.executeQuery(requete);
      while(donner.next()){
        HashMap<String,Object> value = new HashMap<String,Object>();
        value.put("idconger", donner.getString("idconger"));
        value.put("nomconge", donner.getString("nomconge"));
        value.put("nomhierarchie", donner.getString("nomhierarchie"));
        value.put("datedebut", donner.getString("datedebut"));
        value.put("datefin", donner.getString("datefin"));
        value.put("idfcandidat", donner.getString("idfcandidat"));
          resulta.add(value);
      }
      donner.close();
      stmt.close();
      con.close();
  } catch (Exception e) {
      System.out.println(e);
  }
    ModelView model = new ModelView(); 
 
    model.addItem("liste",resulta);
    model.setnompage("congevalideremp.jsp");
    return model;
  }




  @Sessionannotation()
  @Urlannotation(index = "insertvalidationsudo.do",nomparametre={"idconger"})
  public ModelView insertvalidationsudo(String[] idconger){
    String iduser= (String) getSession().get("iduser");
    String requete = new String();
    ConnectPostgres connex = new ConnectPostgres();
    try {
      Connection con = connex.getconnection();
      Statement stmt= con.createStatement();
      for(int i=0;i<idconger.length;i++){
        requete = "update conge set idsudo='"+iduser+"' where idconger='"+idconger[i]+"'";
        stmt.executeUpdate(requete);
      }
      stmt.close();
      con.close();
  } catch (Exception e) {
      System.out.println(e);
  }
    return pagevalidationsudo();
  }

  @Sessionannotation()
  @Urlannotation(index = "listeemployeeencongesudo.do",nomparametre={})
  public ModelView listeemployeeencongesudo(){
  String serviceuser= (String) getSession().get("idserviceuser");
   Vector<HashMap<String,Object>> resulta = new Vector<HashMap<String,Object>>();
    ConnectPostgres connex = new ConnectPostgres();
    try {
      Connection con = connex.getconnection();
      Statement stmt= con.createStatement();
      String requete = "select idconger,nomconge,nomhierarchie,datedebut,datefin,conge.idfcandidat,(datefin::date - datedebut::date ) as jours from conge join detailleemploie on conge.idfcandidat=detailleemploie.idfcandidat join hierarchie on hierarchie.idhierarchie=detailleemploie.idfhierarchie join congespecifie on congespecifie.idcongespecifie=conge.Raison  where  idsuperieur is not null and idsudo is not null and now()  BETWEEN datedebut AND datefin ";
     System.out.println(requete);
      ResultSet donner = stmt.executeQuery(requete);
      while(donner.next()){
        HashMap<String,Object> value = new HashMap<String,Object>();
        value.put("idconger", donner.getString("idconger"));
        value.put("nomconge", donner.getString("nomconge"));
        value.put("nomhierarchie", donner.getString("nomhierarchie"));
        value.put("datedebut", donner.getString("datedebut"));
        value.put("datefin", donner.getString("datefin"));
        value.put("idfcandidat", donner.getString("idfcandidat"));
        value.put("jours", donner.getString("jours"));

          resulta.add(value);
      }
      donner.close();
      stmt.close();
      con.close();
  } catch (Exception e) {
      System.out.println(e);
  }
    ModelView model = new ModelView(); 
 
    model.addItem("liste",resulta);
    model.addItem("lien","/RHgestion/sudo.do");
    model.setnompage("employerEnconger.jsp");
    return model;
  }


  @Sessionannotation()
  @Urlannotation(index = "listeemployeeencongesh1.do",nomparametre={})
  public ModelView listeemployeeencongesh1(){
  String serviceuser= (String) getSession().get("idserviceuser");
   Vector<HashMap<String,Object>> resulta = new Vector<HashMap<String,Object>>();
    ConnectPostgres connex = new ConnectPostgres();
    try {
      Connection con = connex.getconnection();
      Statement stmt= con.createStatement();
      String requete = "select idconger,nomconge,nomhierarchie,datedebut,datefin,conge.idfcandidat,(datefin::date - datedebut::date ) as jours from conge join detailleemploie on conge.idfcandidat=detailleemploie.idfcandidat join hierarchie on hierarchie.idhierarchie=detailleemploie.idfhierarchie join congespecifie on congespecifie.idcongespecifie=conge.Raison  where hierarchie.idfservice = '"+serviceuser+"' and idsuperieur is not null and idsudo is not null and now()  BETWEEN datedebut AND datefin ";
      ResultSet donner = stmt.executeQuery(requete);
      while(donner.next()){
        HashMap<String,Object> value = new HashMap<String,Object>();
        value.put("idconger", donner.getString("idconger"));
        value.put("nomconge", donner.getString("nomconge"));
        value.put("nomhierarchie", donner.getString("nomhierarchie"));
        value.put("datedebut", donner.getString("datedebut"));
        value.put("datefin", donner.getString("datefin"));
        value.put("idfcandidat", donner.getString("idfcandidat"));
        value.put("jours", donner.getString("jours"));

          resulta.add(value);
      }
      donner.close();
      stmt.close();
      con.close();
  } catch (Exception e) {
      System.out.println(e);
  }
    ModelView model = new ModelView(); 
 
    model.addItem("liste",resulta);
    model.addItem("lien","/RHgestion/superieur.do");

    model.setnompage("employerEnconger.jsp");
    return model;
  }


} 

