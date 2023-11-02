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
@ANomTable(nomtable = "detaille_critere", nbrclonne =3,nomsequence = "detaille_criteresequence")
@Adatabase(nombase = "rh_employee", typebase= "postgres",nomuser= "postgres",password= "root",port="5432") 
public class Detaille_critere extends Generaliser{ 
   String iddetaille_cr;
   String idfcrietere;
   String nomdetaillecritere;
   Critere critere = new Critere() ;
   public void setcritere(){
      critere.setidcritere(getidfcrietere());
      critere.findOne();
   }
   public Critere getcritere(){
    return critere;
   }

      HashMap<String,Object> session;
      public void setSession(HashMap<String,Object> s){
         session=s;
       }
      public HashMap<String,Object> getSession(){
          return session;
      }

   public Detaille_critere(){  
   super();  
   super.setchild(this);  
      } 
@Set_value_jspannotation(nom_atribue= "iddetaille_cr") 
 @AmethodeSet(nomcolonne =  "iddetaille_cr")  
  public void setiddetaille_cr(String string1){ 
 if(string1==null){ 
 iddetaille_cr=super.newprimarykey().toUpperCase(); 
 }else{ 
 iddetaille_cr= string1; 
 } 
} 
@Set_value_jspannotation(nom_atribue= "idfcrietere") 
 @AmethodeSet(nomcolonne =  "idfcrietere")  
 public void setidfcrietere(String integer1){ 
        idfcrietere= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "nomdetaillecritere") 
 @AmethodeSet(nomcolonne =  "nomdetaillecritere")  
 public void setnomdetaillecritere(String integer1){ 
        nomdetaillecritere= integer1; 
    } 

   @AmethodeGet(nomcolonne ="iddetaille_cr") 
   @APrimarykey(nomprimarykey = "iddetaille_cr") 
   public String getiddetaille_cr(){
       return iddetaille_cr;
    } 
   @AmethodeGet(nomcolonne ="idfcrietere") 
   public String getidfcrietere(){
       return idfcrietere;
    } 
   @AmethodeGet(nomcolonne ="nomdetaillecritere") 
   public String getnomdetaillecritere(){
       return nomdetaillecritere;
    } 

  @Urlannotation(index = "accuilledetaille_critere.do",nomparametre={}) 
  public etu002087.framework.ModelView accuilledetaille_critere(){ 
    Vector resulta= super.selectAllWithcondition("limit 3"); 
    ModelView model = new ModelView(); 
    model.addItem("nbr",0);
    model.addItem("liste",resulta);
    model.addItem("listecritere",new Critere().selectAll());
    model.setnompage("detaille_critere.jsp");
    return model; 
  }

  @Urlannotation(index = "insertdetaille_critere.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String insertdetaille_critere(){
    setiddetaille_cr(null);
    super.insert(null);
    return "insert"; 
    } 

  @Urlannotation(index = "paginationdetaille_critere.do",nomparametre={"nbr"})
  @Sessionannotation()
  public etu002087.framework.ModelView paginationdetaille_critere(Integer nbr){
    ModelView model = new ModelView();
    Vector resulta= super.selectAllWithcondition(" offset "+nbr+" limit 3");
    if(nbr<=0){
            model.addItem("nbr",0);
    }else{
        model.addItem("nbr",nbr);
   }
    model.addItem("listecritere",new Critere().selectAll());
    model.addItem("liste",resulta);
    model.setnompage("detaille_critere.jsp");
    return model;
  }

  @Urlannotation(index = "modificationdetaille_critere.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String modificationservice(){
    super.update(null);
    return "update"; 
  } 

  @Urlannotation(index = "deletedetaille_critere.do",nomparametre={})
  public etu002087.framework.ModelView deletedetaille_critere(){
      super.delete(null);
      Vector resulta= super.selectAllWithcondition("limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",resulta);
      model.setnompage("detaille_critere.jsp");
      return model;
  } 

} 
