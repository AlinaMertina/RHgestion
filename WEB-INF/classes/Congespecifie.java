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



@ANomTable(nomtable = "congespecifie", nbrclonne =5,nomsequence = "congespecifiesequence")
@Adatabase(nombase = "rh_employee", typebase= "postgres",nomuser= "postgres",password= "root",port="5432") 
public class Congespecifie extends Generaliser{ 
   String idcongespecifie;
   String nomconge;
   Integer dureejours;
   String remunereoupas;
   Integer femmehomme;

      HashMap<String,Object> session;
      public void setSession(HashMap<String,Object> s){
         session=s;
       }
      public HashMap<String,Object> getSession(){
          return session;
      }

   public Congespecifie(){  
   super();  
   super.setchild(this);  
      } 
@Set_value_jspannotation(nom_atribue= "idcongespecifie") 
 @AmethodeSet(nomcolonne =  "idcongespecifie")  
  public void setidcongespecifie(String string1){ 
 if(string1==null){ 
 idcongespecifie=super.newprimarykey().toUpperCase(); 
 }else{ 
 idcongespecifie= string1; 
 } 
} 
@Set_value_jspannotation(nom_atribue= "nomconge") 
 @AmethodeSet(nomcolonne =  "nomconge")  
 public void setnomconge(String integer1){ 
        nomconge= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "dureejours") 
 @AmethodeSet(nomcolonne =  "dureejours")  
 public void setdureejours(Integer double1){ 
      dureejours= double1; 
     } 
@Set_value_jspannotation(nom_atribue= "remunereoupas") 
 @AmethodeSet(nomcolonne =  "remunereoupas")  
 public void setremunereoupas(String integer1){ 
        remunereoupas= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "femmehomme") 
 @AmethodeSet(nomcolonne =  "femmehomme")  
 public void setfemmehomme(Integer double1){ 
      femmehomme= double1; 
     } 
     
   @AmethodeGet(nomcolonne ="idcongespecifie") 
   @APrimarykey(nomprimarykey = "idcongespecifie") 
   public String getidcongespecifie(){
       return idcongespecifie;
    } 
   @AmethodeGet(nomcolonne ="nomconge") 
   public String getnomconge(){
       return nomconge;
    } 
   @AmethodeGet(nomcolonne ="dureejours") 
 public Integer getdureejours(){
       return dureejours;
    } 
   @AmethodeGet(nomcolonne ="remunereoupas") 
   public String getremunereoupas(){
       return remunereoupas;
    } 
   @AmethodeGet(nomcolonne ="femmehomme") 
 public Integer getfemmehomme(){
       return femmehomme;
    } 

  @Urlannotation(index = "accuillecongespecifie.do",nomparametre={}) 
  public etu002087.framework.ModelView accuillecongespecifie(){ 
    Vector resulta= super.selectAllWithcondition("limit 3"); 
    ModelView model = new ModelView(); 
    model.addItem("nbr",0);
    model.addItem("liste",resulta);
    model.setnompage("congespecifie.jsp");
    return model; 
  }

  @Urlannotation(index = "insertcongespecifie.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String insertcongespecifie(){
    setidcongespecifie(null);
    super.insert(null);
    return "insert"; 
    } 

  @Urlannotation(index = "paginationcongespecifie.do",nomparametre={"nbr"})
  @Sessionannotation()
  public etu002087.framework.ModelView paginationcongespecifie(Integer nbr){
    ModelView model = new ModelView();
    Vector resulta= super.selectAllWithcondition(" offset "+nbr+" limit 3");
    if(nbr<=0){
            model.addItem("nbr",0);
    }else{
        model.addItem("nbr",nbr);
   }
    model.addItem("liste",resulta);
    model.setnompage("congespecifie.jsp");
    return model;
  }

  @Urlannotation(index = "modificationcongespecifie.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String modificationservice(){
    super.update(null);
    return "update"; 
  } 

  @Urlannotation(index = "deletecongespecifie.do",nomparametre={})
  public etu002087.framework.ModelView deletecongespecifie(){
      super.delete(null);
      Vector resulta= super.selectAllWithcondition("limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",resulta);
      model.setnompage("congespecifie.jsp");
      return model;
  } 

} 
