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
@ANomTable(nomtable = "critere", nbrclonne =4,nomsequence = "criteresequence")
@Adatabase(nombase = "rh_employee", typebase= "postgres",nomuser= "postgres",password= "root",port="5432") 
public class Critere extends Generaliser{ 
   String idcritere;
   String nomcritere;
   String idservice;
   String multipleoupas;

      HashMap<String,Object> session;
      public void setSession(HashMap<String,Object> s){
         session=s;
       }
      public HashMap<String,Object> getSession(){
          return session;
      }

   public Critere(){  
   super();  
   super.setchild(this);  
      } 
@Set_value_jspannotation(nom_atribue= "idcritere") 
 @AmethodeSet(nomcolonne =  "idcritere")  
  public void setidcritere(String string1){ 
 if(string1==null){ 
 idcritere=super.newprimarykey().toUpperCase(); 
 }else{ 
 idcritere= string1; 
 } 
} 
@Set_value_jspannotation(nom_atribue= "nomcritere") 
 @AmethodeSet(nomcolonne =  "nomcritere")  
 public void setnomcritere(String integer1){ 
        nomcritere= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "idservice") 
 @AmethodeSet(nomcolonne =  "idservice")  
 public void setidservice(String integer1){ 
        idservice= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "multipleoupas") 
 @AmethodeSet(nomcolonne =  "multipleoupas")  
 public void setmultipleoupas(String integer1){ 
        multipleoupas= integer1; 
    } 

   @AmethodeGet(nomcolonne ="idcritere") 
   @APrimarykey(nomprimarykey = "idcritere") 
   public String getidcritere(){
       return idcritere;
    } 
   @AmethodeGet(nomcolonne ="nomcritere") 
   public String getnomcritere(){
       return nomcritere;
    } 
   @AmethodeGet(nomcolonne ="idservice") 
   public String getidservice(){
       return idservice;
    } 
   @AmethodeGet(nomcolonne ="multipleoupas") 
   public String getmultipleoupas(){
       return multipleoupas;
    } 

  @Urlannotation(index = "accuillecritere.do",nomparametre={}) 
  public etu002087.framework.ModelView accuillecritere(){ 
    Vector resulta= super.selectAllWithcondition("limit 3"); 
    ModelView model = new ModelView(); 
    model.addItem("nbr",0);
    model.addItem("liste",resulta);
    model.setnompage("critere.jsp");
    return model; 
  }

  @Urlannotation(index = "insertcritere.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String insertcritere(){
    setidcritere(null);
    setidservice( (String) getSession().get("idservice")    );
    super.insert(null);
    return "insert"; 
    } 

  @Urlannotation(index = "paginationcritere.do",nomparametre={"nbr"})
  @Sessionannotation()
  public etu002087.framework.ModelView paginationcritere(Integer nbr){
    ModelView model = new ModelView();
    Vector resulta= super.selectAllWithcondition(" offset "+nbr+" limit 3");
    if(nbr<=0){
            model.addItem("nbr",0);
    }else{
        model.addItem("nbr",nbr);
   }
    model.addItem("liste",resulta);
    model.setnompage("critere.jsp");
    return model;
  }

  @Urlannotation(index = "modificationcritere.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String modificationservice(){
    super.update(null);
    return "update"; 
  } 

  @Urlannotation(index = "deletecritere.do",nomparametre={})
  public etu002087.framework.ModelView deletecritere(){
      super.delete(null);
      Vector resulta= super.selectAllWithcondition("limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",resulta);
      model.setnompage("critere.jsp");
      return model;
  } 

} 
