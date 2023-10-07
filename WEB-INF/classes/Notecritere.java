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
@ANomTable(nomtable = "notecritere", nbrclonne =4,nomsequence = "notecriteresequence")
@Adatabase(nombase = "rh_employee", typebase= "postgres",nomuser= "postgres",password= "root",port="5432") 
public class Notecritere extends Generaliser{ 
   String idnote;
   String idfdetaille_cr;
   Integer note;
   String idfdemande;

   Detaille_critere detaille_critere ;//rehefa ilaina amin'ny affichage vo miasa
   public void setdetaille_critere(){
      detaille_critere = new Detaille_critere();
      detaille_critere.setiddetaille_cr(getidfdetaille_cr());
      detaille_critere.findOne();
   }
   public Detaille_critere getDetaille_critere(){
      return detaille_critere;
   }
    
      HashMap<String,Object> session;
      public void setSession(HashMap<String,Object> s){
         session=s;
       }
      public HashMap<String,Object> getSession(){
          return session;
      }

   public Notecritere(){  
        super();  
        super.setchild(this);  
    } 
@Set_value_jspannotation(nom_atribue= "idnote") 
 @AmethodeSet(nomcolonne =  "idnote")  
  public void setidnote(String string1){ 
 if(string1==null){ 
 idnote=super.newprimarykey().toUpperCase(); 
 }else{ 
 idnote= string1; 
 } 
} 
@Set_value_jspannotation(nom_atribue= "idfdetaille_cr") 
 @AmethodeSet(nomcolonne =  "idfdetaille_cr")  
 public void setidfdetaille_cr(String integer1){ 
        idfdetaille_cr= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "note") 
 @AmethodeSet(nomcolonne =  "note")  
 public void setnote(Integer double1){ 
      note= double1; 
     } 
@Set_value_jspannotation(nom_atribue= "idfdemande") 
 @AmethodeSet(nomcolonne =  "idfdemande")  
 public void setidfdemande(String integer1){ 
        idfdemande= integer1; 
    } 

   @AmethodeGet(nomcolonne ="idnote") 
   @APrimarykey(nomprimarykey = "idnote") 
   public String getidnote(){
       return idnote;
    } 
   @AmethodeGet(nomcolonne ="idfdetaille_cr") 
   public String getidfdetaille_cr(){
       return idfdetaille_cr;
    } 
   @AmethodeGet(nomcolonne ="note") 
 public Integer getnote(){
       return note;
    } 
   @AmethodeGet(nomcolonne ="idfdemande") 
   public String getidfdemande(){
       return idfdemande;
    } 
    @Sessionannotation()
  @Urlannotation(index = "accuillenotecritere.do",nomparametre={}) 
  public etu002087.framework.ModelView accuillenotecritere(){ 
    String iddemande = (String) getSession().get("iddemande");
    Vector resulta= super.selectAllWithcondition(" where note is not null and idfdemande='"+iddemande+"' limit 3"); 
    ModelView model = new ModelView(); 
    model.addItem("nbr",0);
    model.addItem("liste",resulta);
    model.addItem("liste",new Notecritere().selectAllWithcondition(" where note is null and idfdemande='"+iddemande+"'"));
    model.setnompage("notecritere.jsp");
    return model; 
  }

  @Urlannotation(index = "insertnotecritere.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String insertnotecritere(){
    String iddemande = (String) getSession().get("iddemande");
      //rehefa misi an'le critere anatyn'le tabe note de tsy tokony ampiditra tsony 
      if((new Notecritere().selectAllWithcondition(" where idfdetaille_cr='"+getidfdetaille_cr()+"'  and idfdemande='"+iddemande+"'").size()<=0)){
        setidnote(null);
        setidfdemande(iddemande);
        super.insert(null);
      }
      return "insert"; 
    } 

  @Urlannotation(index = "paginationnotecritere.do",nomparametre={"nbr"})
  @Sessionannotation()
  public etu002087.framework.ModelView paginationnotecritere(Integer nbr){
    String iddemande = (String) getSession().get("iddemande");
    ModelView model = new ModelView();
    Vector resulta= super.selectAllWithcondition(" where idfdemande='"+iddemande+"' offset "+nbr+" limit 3");
    if(nbr<=0){
            model.addItem("nbr",0);
    }else{
        model.addItem("nbr",nbr);
   }
   String idservice = (String) getSession().get("idservice");
    model.addItem("liste",resulta);
    model.addItem("listenotevalide",new Detaille_critere().selectAllWithcondition(" join critere on detaille_critere.idfcrietere=critere.idcritere where idservice='"+idservice+"' "));
    model.setnompage("notecritere.jsp");
    return model;
  }

  @Urlannotation(index = "modificationnotecritere.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String modificationservice(){
    super.update(null);
    return "update"; 
  } 

  @Urlannotation(index = "deletenotecritere.do",nomparametre={})
  public etu002087.framework.ModelView deletenotecritere(){
      super.delete(null);
      Vector resulta= super.selectAllWithcondition("limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",resulta);
      model.setnompage("notecritere.jsp");
      return model;
  } 

  @Urlannotation(index = "notecriteredemande.do",nomparametre={"iddemande"})
  @Sessionannotation()
  public etu002087.framework.ModelView setnotecritere(String iddemande){
      getSession().put("iddemande", iddemande);
      String idservice = (String) getSession().get("idservice");
      //accuille note critere
      Vector resulta= super.selectAllWithcondition(" where idfdemande='"+iddemande+"' limit 3"); 
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",resulta);//pagination
      model.addItem("listenotevalide",new Detaille_critere().selectAllWithcondition(" join critere on detaille_critere.idfcrietere=critere.idcritere where idservice='"+idservice+"' "));
      model.setnompage("notecritere.jsp");
      return model; 
      //fin
  }

} 
