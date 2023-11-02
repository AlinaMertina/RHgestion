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
@ANomTable(nomtable = "irsa", nbrclonne =4,nomsequence = "irsasequence")
@Adatabase(nombase = "rh_employee", typebase= "postgres",nomuser= "postgres",password= "root",port="5432") 
public class Irsa extends Generaliser{ 
   String idirsa;
   Double inf;
   Double sup;
   Double taux;

      HashMap<String,Object> session;
      public void setSession(HashMap<String,Object> s){
         session=s;
       }
      public HashMap<String,Object> getSession(){
          return session;
      }

   public Irsa(){  
   super();  
   super.setchild(this);  
      } 
@Set_value_jspannotation(nom_atribue= "idirsa") 
 @AmethodeSet(nomcolonne =  "idirsa")  
  public void setidirsa(String string1){ 
 if(string1==null){ 
 idirsa=super.newprimarykey().toUpperCase(); 
 }else{ 
 idirsa= string1; 
 } 
} 
@Set_value_jspannotation(nom_atribue= "inf") 
 @AmethodeSet(nomcolonne =  "inf")  
 public void setinf(Double double1){ 
      inf= double1; 
     } 
@Set_value_jspannotation(nom_atribue= "sup") 
 @AmethodeSet(nomcolonne =  "sup")  
 public void setsup(Double double1){ 
      sup= double1; 
     } 
@Set_value_jspannotation(nom_atribue= "taux") 
 @AmethodeSet(nomcolonne =  "taux")  
 public void settaux(Double double1){ 
      taux= double1; 
     } 

   @AmethodeGet(nomcolonne ="idirsa") 
   @APrimarykey(nomprimarykey = "idirsa") 
   public String getidirsa(){
       return idirsa;
    } 
   @AmethodeGet(nomcolonne ="inf") 
   public Double getinf(){
       return inf;
    } 
   @AmethodeGet(nomcolonne ="sup") 
   public Double getsup(){
       return sup;
    } 
   @AmethodeGet(nomcolonne ="taux") 
   public Double gettaux(){
       return taux;
    } 

  @Urlannotation(index = "accuilleirsa.do",nomparametre={}) 
  public etu002087.framework.ModelView accuilleirsa(){ 
    Vector resulta= super.selectAllWithcondition("limit 3"); 
    ModelView model = new ModelView(); 
    model.addItem("nbr",0);
    model.addItem("liste",resulta);
    model.setnompage("irsa.jsp");
    return model; 
  }

  @Urlannotation(index = "insertirsa.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String insertirsa(){
    setidirsa(null);
    super.insert(null);
    return "insert"; 
    } 

  @Urlannotation(index = "paginationirsa.do",nomparametre={"nbr"})
  @Sessionannotation()
  public etu002087.framework.ModelView paginationirsa(Integer nbr){
    ModelView model = new ModelView();
    Vector resulta= super.selectAllWithcondition(" offset "+nbr+" limit 3");
    if(nbr<=0){
            model.addItem("nbr",0);
    }else{
        model.addItem("nbr",nbr);
   }
    model.addItem("liste",resulta);
    model.setnompage("irsa.jsp");
    return model;
  }

  @Urlannotation(index = "modificationirsa.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String modificationservice(){
    super.update(null);
    return "update"; 
  } 

  @Urlannotation(index = "deleteirsa.do",nomparametre={})
  public etu002087.framework.ModelView deleteirsa(){
      super.delete(null);
      Vector resulta= super.selectAllWithcondition("limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",resulta);
      model.setnompage("irsa.jsp");
      return model;
  } 

} 
