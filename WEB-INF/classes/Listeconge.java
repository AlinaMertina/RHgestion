package etu002087.conge;
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
@ANomTable(nomtable = "listeconge", nbrclonne =2,nomsequence = "listecongesequence")
@Adatabase(nombase = "rh_employee", typebase= "postgres",nomuser= "postgres",password= "root",port="5432") 
public class Listeconge extends Generaliser{ 
   String idlisteconge;
   String nomconge;

      HashMap<String,Object> session;
      public void setSession(HashMap<String,Object> s){
         session=s;
       }
      public HashMap<String,Object> getSession(){
          return session;
      }

   public Listeconge(){  
   super();  
   super.setchild(this);  
      } 
@Set_value_jspannotation(nom_atribue= "idlisteconge") 
 @AmethodeSet(nomcolonne =  "idlisteconge")  
  public void setidlisteconge(String string1){ 
 if(string1==null){ 
 idlisteconge=super.newprimarykey().toUpperCase(); 
 }else{ 
 idlisteconge= string1; 
 } 
} 
@Set_value_jspannotation(nom_atribue= "nomconge") 
 @AmethodeSet(nomcolonne =  "nomconge")  
 public void setnomconge(String integer1){ 
        nomconge= integer1; 
    } 

   @AmethodeGet(nomcolonne ="idlisteconge") 
   @APrimarykey(nomprimarykey = "idlisteconge") 
   public String getidlisteconge(){
       return idlisteconge;
    } 
   @AmethodeGet(nomcolonne ="nomconge") 
   public String getnomconge(){
       return nomconge;
    } 

  @Urlannotation(index = "accuillelisteconge.do",nomparametre={}) 
  public etu002087.framework.ModelView accuillelisteconge(){ 
    Vector resulta= super.selectAllWithcondition("limit 3"); 
    ModelView model = new ModelView(); 
    model.addItem("nbr",0);
    model.addItem("liste",resulta);
    model.setnompage("listeconge.jsp");
    return model; 
  }

  @Urlannotation(index = "insertlisteconge.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String insertlisteconge(){
    setidlisteconge(null);
    super.insert(null);
    return "insert"; 
    } 

  @Urlannotation(index = "paginationlisteconge.do",nomparametre={"nbr"})
  @Sessionannotation()
  public etu002087.framework.ModelView paginationlisteconge(Integer nbr){
    ModelView model = new ModelView();
    Vector resulta= super.selectAllWithcondition(" offset "+nbr+" limit 3");
    if(nbr<=0){
            model.addItem("nbr",0);
    }else{
        model.addItem("nbr",nbr);
   }
    model.addItem("liste",resulta);
    model.setnompage("listeconge.jsp");
    return model;
  }

  @Urlannotation(index = "modificationlisteconge.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String modificationservice(){
    super.update(null);
    return "update"; 
  } 

  @Urlannotation(index = "deletelisteconge.do",nomparametre={})
  public etu002087.framework.ModelView deletelisteconge(){
      super.delete(null);
      Vector resulta= super.selectAllWithcondition("limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",resulta);
      model.setnompage("listeconge.jsp");
      return model;
  } 

} 
