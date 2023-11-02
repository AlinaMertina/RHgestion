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
@ANomTable(nomtable = "cvcandidadetaille", nbrclonne =6,nomsequence = "cvcandidadetaillesequence")
@Adatabase(nombase = "rh_employee", typebase= "postgres",nomuser= "postgres",password= "root",port="5432") 
public class Cvcandidadetaille extends Generaliser{ 
   String idcvcandidadetaille;
   String idfdetaille_cr;
   String idfcandidat;
   String description;
   java.util.Date datedebut;
   java.util.Date datefin;

      HashMap<String,Object> session;
      public void setSession(HashMap<String,Object> s){
         session=s;
       }
      public HashMap<String,Object> getSession(){
          return session;
      }

   public Cvcandidadetaille(){  
        super();  
        super.setchild(this);  
    } 
    public Cvcandidadetaille(String iddetaille,String idcan,String descri,Date debut ,Date fin){  
      super();  
      super.setchild(this);  
      setidfdetaille_cr(iddetaille);
      setidfcandidat(idcan);
      setdescription(descri);
      setdatedebut(debut);
      setdatefin(fin);
    } 

@Set_value_jspannotation(nom_atribue= "idcvcandidadetaille") 
 @AmethodeSet(nomcolonne =  "idcvcandidadetaille")  
  public void setidcvcandidadetaille(String string1){ 
 if(string1==null){ 
 idcvcandidadetaille=super.newprimarykey().toUpperCase(); 
 }else{ 
 idcvcandidadetaille= string1; 
 } 
} 
@Set_value_jspannotation(nom_atribue= "idfdetaille_cr") 
 @AmethodeSet(nomcolonne =  "idfdetaille_cr")  
 public void setidfdetaille_cr(String integer1){ 
        idfdetaille_cr= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "idfcandidat") 
 @AmethodeSet(nomcolonne =  "idfcandidat")  
 public void setidfcandidat(String integer1){ 
        idfcandidat= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "description") 
 @AmethodeSet(nomcolonne =  "description")  
 public void setdescription(String string1){ 
      description= string1; 
     } 
@Set_value_jspannotation(nom_atribue= "datedebut") 
 @AmethodeSet(nomcolonne =  "datedebut")  
 public void setdatedebut(java.util.Date date1){ 
      datedebut= date1; 
 } 
@Set_value_jspannotation(nom_atribue= "datefin") 
 @AmethodeSet(nomcolonne =  "datefin")  
 public void setdatefin(java.util.Date date1){ 
      datefin= date1; 
 } 

   @AmethodeGet(nomcolonne ="idcvcandidadetaille") 
   @APrimarykey(nomprimarykey = "idcvcandidadetaille") 
   public String getidcvcandidadetaille(){
       return idcvcandidadetaille;
    } 
   @AmethodeGet(nomcolonne ="idfdetaille_cr") 
   public String getidfdetaille_cr(){
       return idfdetaille_cr;
    } 
   @AmethodeGet(nomcolonne ="idfcandidat") 
   public String getidfcandidat(){
       return idfcandidat;
    } 
   @AmethodeGet(nomcolonne ="description") 
   public String getdescription(){
       return description;
    } 
   @AmethodeGet(nomcolonne ="datedebut") 
   public java.util.Date getdatedebut(){
         return datedebut;
    } 
   @AmethodeGet(nomcolonne ="datefin") 
   public java.util.Date getdatefin(){
         return datefin;
    } 

  @Urlannotation(index = "accuillecvcandidadetaille.do",nomparametre={}) 
  public etu002087.framework.ModelView accuillecvcandidadetaille(){ 
    Vector resulta= super.selectAllWithcondition("limit 3"); 
    ModelView model = new ModelView(); 
    model.addItem("nbr",0);
    model.addItem("liste",resulta);
    model.setnompage("cvcandidadetaille.jsp");
    return model; 
  }

  @Urlannotation(index = "insertcvcandidadetaille.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String insertcvcandidadetaille(){
    setidcvcandidadetaille(null);
    super.insert(null);
    return "insert"; 
    } 

  @Urlannotation(index = "paginationcvcandidadetaille.do",nomparametre={"nbr"})
  @Sessionannotation()
  public etu002087.framework.ModelView paginationcvcandidadetaille(Integer nbr){
    ModelView model = new ModelView();
    Vector resulta= super.selectAllWithcondition(" offset "+nbr+" limit 3");
    if(nbr<=0){
            model.addItem("nbr",0);
    }else{
        model.addItem("nbr",nbr);
   }
    model.addItem("liste",resulta);
    model.setnompage("cvcandidadetaille.jsp");
    return model;
  }

  @Urlannotation(index = "modificationcvcandidadetaille.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String modificationservice(){
    super.update(null);
    return "update"; 
  } 

  @Urlannotation(index = "deletecvcandidadetaille.do",nomparametre={})
  public etu002087.framework.ModelView deletecvcandidadetaille(){
      super.delete(null);
      Vector resulta= super.selectAllWithcondition("limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",resulta);
      model.setnompage("cvcandidadetaille.jsp");
      return model;
  } 

} 
