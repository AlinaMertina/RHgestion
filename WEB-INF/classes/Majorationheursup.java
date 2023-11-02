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
@ANomTable(nomtable = "majorationheursup", nbrclonne =4,nomsequence = "majorationheursupsequence")
@Adatabase(nombase = "rh_employee", typebase= "postgres",nomuser= "postgres",password= "root",port="5432") 
public class Majorationheursup extends Generaliser{ 

  
   String idmajoration;
   Integer inferieur;
   Integer sup;
   Double majoration=0.0;

   Double prixmajoration=0.0;
   Double heure =0.0;
   public void setHeure(Double h){
    heure=h;
   }
   public Double getHeure(){
    return  heure;
   }

  public void setPrixmajoration(Double heure,Double tauxheur){
    // majoration
    setHeure(heure);
    System.out.println("heure     "+heure);
    Double ma = (tauxheur*getmajoration())/100;
   
    prixmajoration= (tauxheur+ma)*heure;
  }
  public Double getPrixmajoration(){
        return prixmajoration;
  }

      HashMap<String,Object> session;
      public void setSession(HashMap<String,Object> s){
         session=s;
       }
      public HashMap<String,Object> getSession(){
          return session;
      }

   public Majorationheursup(){  
   super();  
   super.setchild(this);  
      } 
@Set_value_jspannotation(nom_atribue= "idmajoration") 
 @AmethodeSet(nomcolonne =  "idmajoration")  
  public void setidmajoration(String string1){ 
 if(string1==null){ 
 idmajoration=super.newprimarykey().toUpperCase(); 
 }else{ 
 idmajoration= string1; 
 } 
} 
@Set_value_jspannotation(nom_atribue= "inferieur") 
 @AmethodeSet(nomcolonne =  "inferieur")  
 public void setinferieur(Integer double1){ 
      inferieur= double1; 
     } 
@Set_value_jspannotation(nom_atribue= "sup") 
 @AmethodeSet(nomcolonne =  "sup")  
 public void setsup(Integer double1){ 
      sup= double1; 
     } 
@Set_value_jspannotation(nom_atribue= "majoration") 
 @AmethodeSet(nomcolonne =  "majoration")  
 public void setmajoration(Double double1){ 
      majoration= double1; 
     } 

   @AmethodeGet(nomcolonne ="idmajoration") 
   @APrimarykey(nomprimarykey = "idmajoration") 
   public String getidmajoration(){
       return idmajoration;
    } 
   @AmethodeGet(nomcolonne ="inferieur") 
 public Integer getinferieur(){
       return inferieur;
    } 
   @AmethodeGet(nomcolonne ="sup") 
 public Integer getsup(){
       return sup;
    } 
   @AmethodeGet(nomcolonne ="majoration") 
   public Double getmajoration(){
       return majoration;
    } 

  @Urlannotation(index = "accuillemajorationheursup.do",nomparametre={}) 
  public etu002087.framework.ModelView accuillemajorationheursup(){ 
    Vector resulta= super.selectAllWithcondition("limit 3"); 
    ModelView model = new ModelView(); 
    model.addItem("nbr",0);
    model.addItem("liste",resulta);
    model.setnompage("majorationheursup.jsp");
    return model; 
  }

  @Urlannotation(index = "insertmajorationheursup.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String insertmajorationheursup(){
    setidmajoration(null);
    super.insert(null);
    return "insert"; 
    } 

  @Urlannotation(index = "paginationmajorationheursup.do",nomparametre={"nbr"})
  @Sessionannotation()
  public etu002087.framework.ModelView paginationmajorationheursup(Integer nbr){
    ModelView model = new ModelView();
    Vector resulta= super.selectAllWithcondition(" offset "+nbr+" limit 3");
    if(nbr<=0){
            model.addItem("nbr",0);
    }else{
        model.addItem("nbr",nbr);
   }
    model.addItem("liste",resulta);
    model.setnompage("majorationheursup.jsp");
    return model;
  }

  @Urlannotation(index = "modificationmajorationheursup.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String modificationservice(){
    super.update(null);
    return "update"; 
  } 

  @Urlannotation(index = "deletemajorationheursup.do",nomparametre={})
  public etu002087.framework.ModelView deletemajorationheursup(){
      super.delete(null);
      Vector resulta= super.selectAllWithcondition("limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",resulta);
      model.setnompage("majorationheursup.jsp");
      return model;
  } 

} 
