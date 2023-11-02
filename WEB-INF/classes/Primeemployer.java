package etu002087.payement;
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
import etu002087.demandebesoin.ConnectPostgres;

import java.sql.*;

@ANomTable(nomtable = "primeemployer", nbrclonne =4,nomsequence = "primeemployersequence")
@Adatabase(nombase = "rh_employee", typebase= "postgres",nomuser= "postgres",password= "root",port="5432") 

public class Primeemployer extends Generaliser{ 
  String idprimeemployee;
  String idfprime;
  String idfcandidat;
  Date dateprime;
  String nomprime;
  Double montant=0.0;
  public Double getmontant(){
    return montant;
  }
  public void setnomprime(){
    ConnectPostgres connex = new ConnectPostgres();
    try {
        Connection con = connex.getconnection();
        Statement stmt= con.createStatement();
        String requete = "select description,montant from primeemployer join prime on  primeemployer.idfprime=prime.idprime where idfprime='"+getidfprime()+"' ";
        System.out.println(requete);
        ResultSet donner = stmt.executeQuery(requete);
        Integer in = 0;
        while(donner.next()){
          nomprime=donner.getString("description");
          montant=donner.getDouble("montant");
        }
        stmt.close();
        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }

  }
  public String getnomprime(){
      return nomprime;
  }
      HashMap<String,Object> session;
      public void setSession(HashMap<String,Object> s){
         session=s;
       }
      public HashMap<String,Object> getSession(){
          return session;
      }

   public Primeemployer(){  
          super();  
          super.setchild(this);  
    } 
@Set_value_jspannotation(nom_atribue= "idprimeemployee") 
 @AmethodeSet(nomcolonne =  "idprimeemployee")  
  public void setidprimeemployee(String string1){ 
 if(string1==null){ 
 idprimeemployee=super.newprimarykey().toUpperCase(); 
 }else{ 
 idprimeemployee= string1; 
 } 
} 
@Set_value_jspannotation(nom_atribue= "idfprime") 
 @AmethodeSet(nomcolonne =  "idfprime")  
 public void setidfprime(String integer1){ 
        idfprime= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "idfcandidat") 
 @AmethodeSet(nomcolonne =  "idfcandidat")  
 public void setidfcandidat(String integer1){ 
        idfcandidat= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "dateprime") 
 @AmethodeSet(nomcolonne =  "dateprime")  
 public void setdateprime(Date date1){ 
      dateprime= date1; 
       } 

   @AmethodeGet(nomcolonne ="idprimeemployee") 
   @APrimarykey(nomprimarykey = "idprimeemployee") 
   public String getidprimeemployee(){
       return idprimeemployee;
    } 
   @AmethodeGet(nomcolonne ="idfprime") 
   public String getidfprime(){
       return idfprime;
    } 
   @AmethodeGet(nomcolonne ="idfcandidat") 
   public String getidfcandidat(){
       return idfcandidat;
    } 
   @AmethodeGet(nomcolonne ="dateprime") 
   public Date getdateprime(){
         return dateprime;
    } 

  @Urlannotation(index = "accuilleprimeemployer.do",nomparametre={}) 
  public etu002087.framework.ModelView accuilleprimeemployer(){ 
    Vector resulta= super.selectAllWithcondition("limit 3"); 
    ModelView model = new ModelView(); 
    model.addItem("nbr",0);
    model.addItem("prime",new Prime().selectAll());
    model.addItem("liste",resulta);
    model.setnompage("primeemployer.jsp");
    return model; 
  }

  @Urlannotation(index = "insertprimeemployer.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String insertprimeemployer(){
    setidprimeemployee(null);
    super.insert(null);
    return "insert"; 
    } 

  @Urlannotation(index = "paginationprimeemployer.do",nomparametre={"nbr"})
  @Sessionannotation()
  public etu002087.framework.ModelView paginationprimeemployer(Integer nbr){
    ModelView model = new ModelView();
    Vector resulta= super.selectAllWithcondition(" offset "+nbr+" limit 3");
    if(nbr<=0){
            model.addItem("nbr",0);
    }else{
        model.addItem("nbr",nbr);
   }
    model.addItem("prime",new Prime().selectAll());
    model.addItem("liste",resulta);
    model.setnompage("primeemployer.jsp");
    return model;
  }

  @Urlannotation(index = "modificationprimeemployer.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String modificationservice(){
    super.update(null);
    return "update"; 
  } 

  @Urlannotation(index = "deleteprimeemployer.do",nomparametre={})
  public etu002087.framework.ModelView deleteprimeemployer(){
      super.delete(null);
      Vector resulta= super.selectAllWithcondition("limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("prime",new Prime().selectAll());
      model.addItem("liste",resulta);
      model.setnompage("primeemployer.jsp");
      return model;
  } 

} 
