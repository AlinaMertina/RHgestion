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
@ANomTable(nomtable = "cnaps", nbrclonne =3,nomsequence = "cnapssequence")
@Adatabase(nombase = "rh_employee", typebase= "postgres",nomuser= "postgres",password= "root",port="5432")

public class Cnaps extends Generaliser{ 
   String idcnaps;
   String description;
   Double pourcentage;
   Double prixcnapscandidat;

   public void setPrixcnapscandidat(Double d){
    prixcnapscandidat=d;
   }
   public Double getPrixcnapscandidat(){
    return prixcnapscandidat;
   }
   
      HashMap<String,Object> session;
      public void setSession(HashMap<String,Object> s){
         session=s;
       }
      public HashMap<String,Object> getSession(){
          return session;
      }

   public Cnaps(){  
   super();  
   super.setchild(this);  
      } 
@Set_value_jspannotation(nom_atribue= "idcnaps") 
 @AmethodeSet(nomcolonne =  "idcnaps")  
  public void setidcnaps(String string1){ 
 if(string1==null){ 
 idcnaps=super.newprimarykey().toUpperCase(); 
 }else{ 
 idcnaps= string1; 
 } 
} 
@Set_value_jspannotation(nom_atribue= "description") 
 @AmethodeSet(nomcolonne =  "description")  
 public void setdescription(String string1){ 
      description= string1; 
     } 
@Set_value_jspannotation(nom_atribue= "pourcentage") 
 @AmethodeSet(nomcolonne =  "pourcentage")  
 public void setpourcentage(Double double1){ 
      pourcentage= double1; 
     } 

   @AmethodeGet(nomcolonne ="idcnaps") 
   @APrimarykey(nomprimarykey = "idcnaps") 
   public String getidcnaps(){
       return idcnaps;
    } 
   @AmethodeGet(nomcolonne ="description") 
   public String getdescription(){
       return description;
    } 
   @AmethodeGet(nomcolonne ="pourcentage") 
   public Double getpourcentage(){
       return pourcentage;
    } 

  @Urlannotation(index = "accuillecnaps.do",nomparametre={}) 
  public etu002087.framework.ModelView accuillecnaps(){ 
    Vector resulta= super.selectAllWithcondition("limit 3"); 
    ModelView model = new ModelView(); 
    model.addItem("nbr",0);
    model.addItem("liste",resulta);
    model.setnompage("cnaps.jsp");
    return model; 
  }

  @Urlannotation(index = "insertcnaps.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String insertcnaps(){
    setidcnaps(null);
    super.insert(null);
    return "insert"; 
    } 

  @Urlannotation(index = "paginationcnaps.do",nomparametre={"nbr"})
  @Sessionannotation()
  public etu002087.framework.ModelView paginationcnaps(Integer nbr){
    ModelView model = new ModelView();
    Vector resulta= super.selectAllWithcondition(" offset "+nbr+" limit 3");
    if(nbr<=0){
            model.addItem("nbr",0);
    }else{
        model.addItem("nbr",nbr);
   }
    model.addItem("liste",resulta);
    model.setnompage("cnaps.jsp");
    return model;
  }

  @Urlannotation(index = "modificationcnaps.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String modificationservice(){
    super.update(null);
    return "update"; 
  } 

  @Urlannotation(index = "deletecnaps.do",nomparametre={})
  public etu002087.framework.ModelView deletecnaps(){
      super.delete(null);
      Vector resulta= super.selectAllWithcondition("limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",resulta);
      model.setnompage("cnaps.jsp");
      return model;
  } 

} 
