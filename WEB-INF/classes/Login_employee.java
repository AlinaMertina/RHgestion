package etu002087.superutilisateur;
 import java.util.HashMap;
import java.util.Vector;
import generaliser.AmethodeSet;
import generaliser.Generaliser; 
import generaliser.ANomTable; 
import generaliser.Adatabase; 
import generaliser.AmethodeGet; 
import generaliser.APrimarykey;


import java.sql.*;

import java.util.Date; 
import etu002087.framework.Urlannotation; 
import etu002087.framework.ModelView; 
import etu002087.framework.Scopeannotation; 
import etu002087.framework.Set_value_jspannotation; 
import etu002087.framework.Sessionannotation;
import etu002087.demandebesoin.ConnectPostgres;
import etu002087.framework.Gsonannotation; 
@ANomTable(nomtable = "login_employee", nbrclonne =2,nomsequence = "login_employeesequence")
@Adatabase(nombase = "rh_employee", typebase= "postgres",nomuser= "postgres",password= "root",port="5432") 
public class Login_employee extends Generaliser{ 
   String idfemployee;
   String modpass;
   //contenire  lien an'le page accuille

  HashMap<String,Object> lien;
  public void setlien(String k,Object o){
    lien.put(k,o);
  }
  public HashMap<String,Object> getligne(){
    return lien;
  }
  //fin setlien

  HashMap<String,Object> session;
  public void setSession(HashMap<String,Object> s){
      session=s;
    }
  public HashMap<String,Object> getSession(){
      return session;
  }

  public Login_employee(){  
        super();  
        super.setchild(this);  
        
  } 

@Set_value_jspannotation(nom_atribue= "idfemployee") 
@AmethodeSet(nomcolonne =  "idfemployee")  
  public void setidfemployee(String string1){ 
 if(string1==null){ 
 idfemployee=super.newprimarykey().toUpperCase(); 
 }else{ 
 idfemployee= string1; 
 } 
} 
@Set_value_jspannotation(nom_atribue= "modpass") 
 @AmethodeSet(nomcolonne =  "modpass")  
 public void setmodpass(String integer1){ 
        modpass= integer1; 
    } 

   @AmethodeGet(nomcolonne ="idfemployee") 
   @APrimarykey(nomprimarykey = "idfemployee") 
   public String getidfemployee(){
       return idfemployee;
    } 
   @AmethodeGet(nomcolonne ="modpass") 
   public String getmodpass(){
       return modpass;
    } 

  @Urlannotation(index = "accuillelogin_employee.do",nomparametre={}) 
  public etu002087.framework.ModelView accuillelogin_employee(){ 
    Vector resulta= super.selectAllWithcondition("limit 3"); 
    ModelView model = new ModelView(); 
    model.addItem("nbr",0);
    model.addItem("liste",resulta);
    model.setnompage("login_employee.jsp");
    return model; 
  }

  @Urlannotation(index = "login.do",nomparametre={}) 
  public etu002087.framework.ModelView login(){ 
    ModelView model = new ModelView(); 
    model.setnompage("login.jsp");
    return model; 
  }

  @Urlannotation(index = "connexion.do",nomparametre={}) 
  public etu002087.framework.ModelView connexion1(){ 
    ModelView model = new ModelView(); 
    if(super.selectAllWithcondition(" where idfemployee = '"+getidfemployee()+"' and modpass = '"+getmodpass()+"'").size()>0){
      ConnectPostgres conne = new ConnectPostgres();
      Connection con = conne.getconnection();
      try {
        Statement stmt= con.createStatement();
        ResultSet donner = stmt.executeQuery("select service.nomservice,service.idservice from service join Employee on  service.idservice=Employee.idservice where Employee.idemployee='"+getidfemployee()+"'");
        while(donner.next()){
          model.addsession("service",donner.getString("nomservice"));
          model.addsession("idservice",donner.getString("idservice"));
          if(donner.getString("nomservice").compareTo("gestion")==0){
            model.setnompage("accuillesudo.jsp");
          }else{
            model.setnompage("accuilleinfo.jsp");
          }
        }
        stmt.close();
        con.close();
      } catch (Exception e) {
          System.out.println(e);
      }
    }else{
      model.setnompage("login.jsp");
    }
    return model; 
  }

  @Urlannotation(index = "accuilleinfo.do",nomparametre={}) 
  public etu002087.framework.ModelView accuilleinfo(){ 
    ModelView model = new ModelView();
    model.setnompage("accuilleinfo.jsp");
    return model;
  }
  @Urlannotation(index = "accuillesudo.do",nomparametre={}) 
  public etu002087.framework.ModelView accuillesudi(){ 
    ModelView model = new ModelView();
    model.setnompage("accuillesudo.jsp");
    return model;
  }

  @Urlannotation(index = "insertlogin_employee.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String insertlogin_employee(){
    setidfemployee(null);
    super.insert(null);
    return "insert"; 
    } 

  @Urlannotation(index = "paginationlogin_employee.do",nomparametre={"nbr"})
  @Sessionannotation()
  public etu002087.framework.ModelView paginationlogin_employee(Integer nbr){
    ModelView model = new ModelView();
    Vector resulta= super.selectAllWithcondition(" offset "+nbr+" limit 3");
    if(nbr<=0){
            model.addItem("nbr",0);
    }else{
        model.addItem("nbr",nbr);
   }
    model.addItem("liste",resulta);
    model.setnompage("login_employee.jsp");
    return model;
  }

  @Urlannotation(index = "modificationlogin_employee.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String modificationservice(){
    super.update(null);
    return "update"; 
  } 

  @Urlannotation(index = "deletelogin_employee.do",nomparametre={})
  public etu002087.framework.ModelView deletelogin_employee(){
      super.delete(null);
      Vector resulta= super.selectAllWithcondition("limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",resulta);
      model.setnompage("login_employee.jsp");
      return model;
  } 

} 
