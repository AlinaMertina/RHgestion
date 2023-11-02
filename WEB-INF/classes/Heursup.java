package etu002087.payement;

import java.util.HashMap;
import java.util.Vector;
import generaliser.AmethodeSet;
import generaliser.Generaliser; 
import generaliser.ANomTable; 
import generaliser.Adatabase; 
import generaliser.AmethodeGet; 
import generaliser.APrimarykey;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import etu002087.framework.Urlannotation; 
import etu002087.framework.ModelView; 
import etu002087.framework.Scopeannotation; 
import etu002087.framework.Set_value_jspannotation; 
import etu002087.framework.Sessionannotation; 
import etu002087.framework.Gsonannotation; 
import etu002087.demandebesoin.ConnectPostgres;
import java.sql.*;


@ANomTable(nomtable = "heursup", nbrclonne =7,nomsequence = "heursupsequence")
@Adatabase(nombase = "rh_employee", typebase= "postgres",nomuser= "postgres",password= "root",port="5432") 
public class Heursup extends Generaliser{ 
   String idheursup=new String();
   String iddemandeur=new String();
   String idsuperieur=null;
   String idsudo=null;
   String description;
   Date datedebut;
   Date datefin;
  
      HashMap<String,Object> session;
      public void setSession(HashMap<String,Object> s){
         session=s;
       }
      public HashMap<String,Object> getSession(){
          return session;
      }

   public Heursup(){  
   super();  
   super.setchild(this);  
      } 
@Set_value_jspannotation(nom_atribue= "idheursup") 
 @AmethodeSet(nomcolonne =  "idheursup")  
  public void setidheursup(String string1){ 
 if(string1==null){ 
 idheursup=super.newprimarykey().toUpperCase(); 
 }else{ 
 idheursup= string1; 
 } 
} 
@Set_value_jspannotation(nom_atribue= "iddemandeur") 
 @AmethodeSet(nomcolonne =  "iddemandeur")  
 public void setiddemandeur(String integer1){ 
        iddemandeur= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "idsuperieur") 
 @AmethodeSet(nomcolonne =  "idsuperieur")  
 public void setidsuperieur(String integer1){ 
        idsuperieur= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "idsudo") 
 @AmethodeSet(nomcolonne =  "idsudo")  
 public void setidsudo(String integer1){ 
        idsudo= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "description") 
 @AmethodeSet(nomcolonne =  "description")  
 public void setdescription(String string1){ 
      description= string1; 
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

   @AmethodeGet(nomcolonne ="idheursup") 
   @APrimarykey(nomprimarykey = "idheursup") 
   public String getidheursup(){
       return idheursup;
    } 
   @AmethodeGet(nomcolonne ="iddemandeur") 
   public String getiddemandeur(){
       return iddemandeur;
    } 
   @AmethodeGet(nomcolonne ="idsuperieur") 
   public String getidsuperieur(){
       return idsuperieur;
    } 
   @AmethodeGet(nomcolonne ="idsudo") 
   public String getidsudo(){
       return idsudo;
    } 
   @AmethodeGet(nomcolonne ="description") 
   public String getdescription(){
       return description;
    } 
   @AmethodeGet(nomcolonne ="datedebut") 
   public Date getdatedebut(){
         return datedebut;
    } 
   @AmethodeGet(nomcolonne ="datefin") 
   public Date getdatefin(){
         return datefin;
    } 

  @Urlannotation(index = "accuilleheursup.do",nomparametre={}) 
  public etu002087.framework.ModelView accuilleheursup(){ 
    Vector resulta= super.selectAllWithcondition("limit 3"); 
    ModelView model = new ModelView(); 
    model.addItem("nbr",0);
    model.addItem("liste",resulta);
    model.setnompage("heursup.jsp");
    return model; 
  }
  public static String checkformadate(String date){
    if(date.contains("-")==true && date.contains(":")==true){
         return "yyyy-MM-dd HH:mm:ss";
    }else if( date.contains("-")==true && date.contains(":")!=true ){
         return "yyyy-MM-dd";
    }else if( date.contains("/")==true && date.contains(":")==true ){
     return "yyyy/MM/dd HH:mm:ss";
    }
    else if( date.contains("/")==true && date.contains(":")!=true ){
     return "yyyy/MM/dd";
    }
    return "yyyy-MM-dd";
    
 }
 
 // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-d HH:mm");
 // String formattedDate = sdf.format(date1);
 
 public  java.util.Date convertirStringEnDate(String dateString) {
     System.out.println(checkformadate(dateString));
     SimpleDateFormat dateFormat = new SimpleDateFormat(checkformadate(dateString));
     try {
         Date date = dateFormat.parse(dateString);
         return date;
     } catch (ParseException e) {
         e.printStackTrace();
         return null; // En cas d'erreur de conversion
     }
 }

 public  String convertDateToString(Date date) {
     
     SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     // Formatez la date dans le format "dd-MM-yyyy"
     String dateFormatted = outputFormat.format(date);
     return dateFormatted;
 }
 

  @Urlannotation(index = "insertheursup.do",nomparametre={"debut","fin","description"})
  @Sessionannotation()
  public etu002087.framework.ModelView insertheursup(String debut,String fin,String description){
    setidheursup(null);
    setdescription(description);
    setiddemandeur((String)getSession().get("iduser"));

    ConnectPostgres conne = new ConnectPostgres();
    Connection con = conne.getconnection();
    try {

      Statement stmt= con.createStatement();
      stmt.executeQuery("insert into heursup(datedebut,datefin,description,idsudo,idheursup,idsuperieur,iddemandeur) values('"+debut+"'::timestamp,'"+fin+"'::timestamp,'"+description+"',null,'"+getidheursup()+"',null,'"+getiddemandeur()+"')");
      stmt.close();
      con.close();

    } catch (Exception e) {
        System.out.println(e);
    }
    ModelView model = new ModelView();
    model.setnompage("demandeheursup.jsp");
    return model;
  } 

  @Urlannotation(index = "pageinsertheursup.do",nomparametre={})
  @Sessionannotation()
  public etu002087.framework.ModelView pageinsertheursup(){
    ModelView model = new ModelView();
    model.setnompage("demandeheursup.jsp");
    return model;
  } 


  @Urlannotation(index = "paginationheursup.do",nomparametre={"nbr"})
  @Sessionannotation()
  public etu002087.framework.ModelView paginationheursup(Integer nbr){
    ModelView model = new ModelView();
    Vector resulta= super.selectAllWithcondition(" offset "+nbr+" limit 3");
    if(nbr<=0){
            model.addItem("nbr",0);
    }else{
        model.addItem("nbr",nbr);
   }
    model.addItem("liste",resulta);
    model.setnompage("heursup.jsp");
    return model;
  }

  @Urlannotation(index = "modificationheursup.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String modificationservice(){
    super.update(null);
    return "update"; 
  } 

  @Urlannotation(index = "deleteheursup.do",nomparametre={})
  public etu002087.framework.ModelView deleteheursup(){
      super.delete(null);
      Vector resulta= super.selectAllWithcondition("limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",resulta);
      model.setnompage("heursup.jsp");
      return model;
  } 

//fontion qui charge la page de validation de deamnde heur sup
  @Urlannotation(index = "pagevaliderdemandehsphp1.do",nomparametre={})
  public etu002087.framework.ModelView pagevaliderdemandehsphp1(){
      Vector<HashMap<String,Object>> resulta = new Vector<HashMap<String,Object>>();
      ConnectPostgres conne = new ConnectPostgres();
      Connection con = conne.getconnection();
      try {
  
        Statement stmt= con.createStatement();
        ResultSet re = stmt.executeQuery("select idheursup,nomhierarchie,description,idfcandidat,datedebut,datefin from detailleemploie join hierarchie on detailleemploie.idfhierarchie=hierarchie.idhierarchie  join heursup on heursup.iddemandeur=detailleemploie.idfcandidat where idsuperieur is null and datedebut>=now();");
        while(re.next()){
            HashMap<String,Object> sous = new HashMap<String,Object>();
            System.out.println("gggggggg "+re.getString("idheursup"));
            sous.put("idheursup",re.getString("idheursup"));
            sous.put("nomhierarchie",re.getString("nomhierarchie"));
            sous.put("description",re.getString("description"));
            sous.put("idfcandidat",re.getString("idfcandidat"));
            sous.put("datedebut",re.getString("datedebut"));
            sous.put("datefin",re.getString("datefin"));
            resulta.add(sous);
        }
        stmt.close();
        con.close();
  
      } catch (Exception e) {
          System.out.println(e);
      }

      ModelView model = new ModelView(); 
      model.addItem("liste",resulta);
      model.setnompage("validationhspsh1.jsp");
      return model;
  } 


//fonction insertion validation heur sup
  @Sessionannotation()  
  @Urlannotation(index = "validationheursup.do",nomparametre={"idheursup"})
  public etu002087.framework.ModelView validationheursup(String[] idheursup ){
      String iduser =(String) getSession().get("iduser");

      ConnectPostgres conne = new ConnectPostgres();
      Connection con = conne.getconnection();
      try {

        Statement stmt= con.createStatement();
        for(int i=0 ; i < idheursup.length ;i++){
          System.out.println("ppppp "+idheursup[i]);
          stmt.executeUpdate("update heursup set idsuperieur='"+iduser+"'  where idheursup='"+idheursup[i]+"' ");
          stmt.close();
        }
        con.close();

      } catch (Exception e) {
          System.out.println(e);
      }

      
      return pagevaliderdemandehsphp1();
  } 

  //validation heur superieur par sudo 

  @Urlannotation(index = "pagevalidationheursupsudo.do",nomparametre={})
  public etu002087.framework.ModelView pagevalidationheursupsudo(){
      Vector<HashMap<String,Object>> resulta = new Vector<HashMap<String,Object>>();
      ConnectPostgres conne = new ConnectPostgres();
      Connection con = conne.getconnection();
      try {
  
        Statement stmt= con.createStatement();
        ResultSet re = stmt.executeQuery("select idheursup,nomhierarchie,description,idfcandidat,datedebut,datefin from detailleemploie join hierarchie on detailleemploie.idfhierarchie=hierarchie.idhierarchie  join heursup on heursup.iddemandeur=detailleemploie.idfcandidat where idsuperieur is not null and datedebut>=now() and idsudo is null;");
        while(re.next()){
            HashMap<String,Object> sous = new HashMap<String,Object>();
            System.out.println("gggggggg "+re.getString("idheursup"));
            sous.put("idheursup",re.getString("idheursup"));
            sous.put("nomhierarchie",re.getString("nomhierarchie"));
            sous.put("description",re.getString("description"));
            sous.put("idfcandidat",re.getString("idfcandidat"));
            sous.put("datedebut",re.getString("datedebut"));
            sous.put("datefin",re.getString("datefin"));
            resulta.add(sous);
        }
        stmt.close();
        con.close();
  
      } catch (Exception e) {
          System.out.println(e);
      }

      ModelView model = new ModelView(); 
      model.addItem("liste",resulta);
      model.setnompage("validationheursupsudo.jsp");
      return model;
  } 

  @Sessionannotation()  
  @Urlannotation(index = "validationheursupsudo.do",nomparametre={"idheursup"})
  public etu002087.framework.ModelView validationheursupsudo(String[] idheursup ){
      String iduser =(String) getSession().get("iduser");

      ConnectPostgres conne = new ConnectPostgres();
      Connection con = conne.getconnection();
      try {

        Statement stmt= con.createStatement();
        for(int i=0 ; i < idheursup.length ;i++){
          System.out.println("ppppp "+idheursup[i]);
          stmt.executeUpdate("update heursup set idsudo='"+iduser+"'  where idheursup='"+idheursup[i]+"' ");
          stmt.close();
        }
        con.close();

      } catch (Exception e) {
          System.out.println(e);
      }

      
      return pagevalidationheursupsudo();
  } 

  @Urlannotation(index = "heursupvalider.do",nomparametre={})
  public etu002087.framework.ModelView heursupvalider(){
      Vector<HashMap<String,Object>> resulta = new Vector<HashMap<String,Object>>();
      ConnectPostgres conne = new ConnectPostgres();
      Connection con = conne.getconnection();
      try {
  
        Statement stmt= con.createStatement();
        ResultSet re = stmt.executeQuery("select idheursup,nomhierarchie,description,idfcandidat,datedebut,datefin from detailleemploie join hierarchie on detailleemploie.idfhierarchie=hierarchie.idhierarchie  join heursup on heursup.iddemandeur=detailleemploie.idfcandidat where  datedebut>=now() and idsudo is not null;");
        while(re.next()){
            HashMap<String,Object> sous = new HashMap<String,Object>();
            System.out.println("gggggggg "+re.getString("idheursup"));
            sous.put("idheursup",re.getString("idheursup"));
            sous.put("nomhierarchie",re.getString("nomhierarchie"));
            sous.put("description",re.getString("description"));
            sous.put("idfcandidat",re.getString("idfcandidat"));
            sous.put("datedebut",re.getString("datedebut"));
            sous.put("datefin",re.getString("datefin"));
            resulta.add(sous);
        }
        stmt.close();
        con.close();
  
      } catch (Exception e) {
          System.out.println(e);
      }

      ModelView model = new ModelView(); 
      model.addItem("liste",resulta);
      model.setnompage("heursupvalider.jsp");
      return model;
  } 

  

  


} 
