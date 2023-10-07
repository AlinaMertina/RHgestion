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
@ANomTable(nomtable = "choixquestion", nbrclonne =4,nomsequence = "choixquestionsequence")
@Adatabase(nombase = "rh_employee", typebase= "postgres",nomuser= "postgres",password= "root",port="5432") 
public class Choixquestion extends Generaliser{ 
   String idchoixquestion;
   String idfquestion;
   String choix;
   String vraifause;

      HashMap<String,Object> session;
      public void setSession(HashMap<String,Object> s){
         session=s;
       }
      public HashMap<String,Object> getSession(){
          return session;
      }

   public Choixquestion(){  
   super();  
   super.setchild(this);  
      } 
@Set_value_jspannotation(nom_atribue= "idchoixquestion") 
 @AmethodeSet(nomcolonne =  "idchoixquestion")  
  public void setidchoixquestion(String string1){ 
 if(string1==null){ 
 idchoixquestion=super.newprimarykey().toUpperCase(); 
 }else{ 
 idchoixquestion= string1; 
 } 
} 
@Set_value_jspannotation(nom_atribue= "idfquestion") 
 @AmethodeSet(nomcolonne =  "idfquestion")  
 public void setidfquestion(String integer1){ 
        idfquestion= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "choix") 
 @AmethodeSet(nomcolonne =  "choix")  
 public void setchoix(String string1){ 
      choix= string1; 
     } 
@Set_value_jspannotation(nom_atribue= "vraifause") 
 @AmethodeSet(nomcolonne =  "vraifause")  
 public void setvraifause(String integer1){ 
        vraifause= integer1; 
    } 

   @AmethodeGet(nomcolonne ="idchoixquestion") 
   @APrimarykey(nomprimarykey = "idchoixquestion") 
   public String getidchoixquestion(){
       return idchoixquestion;
    } 
   @AmethodeGet(nomcolonne ="idfquestion") 
   public String getidfquestion(){
       return idfquestion;
    } 
   @AmethodeGet(nomcolonne ="choix") 
   public String getchoix(){
       return choix;
    } 
   @AmethodeGet(nomcolonne ="vraifause") 
   public String getvraifause(){
       return vraifause;
    } 
    
  @Sessionannotation()
  @Urlannotation(index = "accuillechoixquestion.do",nomparametre={"idfquestion"}) 
  public etu002087.framework.ModelView accuillechoixquestion(String idfquestion){ 
    getSession().put("idfquestion", idfquestion);
    Vector resulta= super.selectAllWithcondition(" where idfquestion ='"+idfquestion+"' limit 3"); 
    ModelView model = new ModelView(); 
    model.addItem("nbr",0);
    model.addItem("liste",resulta);
    model.setnompage("choixquestion.jsp");
    return model; 
  }

  @Urlannotation(index = "insertchoixquestion.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String insertchoixquestion(){
    setidchoixquestion(null);
    String idfquestion = (String) getSession().get("idfquestion");
    setidfquestion(idfquestion);
    super.insert(null);
    return "insert"; 
    } 

  @Urlannotation(index = "paginationchoixquestion.do",nomparametre={"nbr"})
  @Sessionannotation()
  public etu002087.framework.ModelView paginationchoixquestion(Integer nbr){
    ModelView model = new ModelView();
    String idfquestion = (String) getSession().get("idfquestion");
    Vector resulta= super.selectAllWithcondition(" where idfquestion ='"+idfquestion+"' offset "+nbr+" limit 3");
    if(nbr<=0){
            model.addItem("nbr",0);
    }else{
        model.addItem("nbr",nbr);
   }
    model.addItem("liste",resulta);
    model.setnompage("choixquestion.jsp");
    return model;
  }

  @Urlannotation(index = "modificationchoixquestion.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String modificationservice(){
    super.update(null);
    return "update"; 
  } 

  @Urlannotation(index = "deletechoixquestion.do",nomparametre={})
  public etu002087.framework.ModelView deletechoixquestion(){
      super.delete(null);
      Vector resulta= super.selectAllWithcondition("limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",resulta);
      model.setnompage("choixquestion.jsp");
      return model;
  } 

} 
