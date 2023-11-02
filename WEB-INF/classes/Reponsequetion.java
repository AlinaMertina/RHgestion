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
@ANomTable(nomtable = "reponsequetion", nbrclonne =3,nomsequence = "reponsequetionsequence")
@Adatabase(nombase = "rh_employee", typebase= "postgres",nomuser= "postgres",password= "root",port="5432") 
public class Reponsequetion extends Generaliser{ 
   String idreponse;
   String idfchoixquestion;
   String idfcandidat;

      HashMap<String,Object> session;
      public void setSession(HashMap<String,Object> s){
         session=s;
       }
      public HashMap<String,Object> getSession(){
          return session;
      }

   public Reponsequetion(){  
      super();  
      super.setchild(this);  
    } 
    public Reponsequetion(String cand,String d){
      super();  
      super.setchild(this);  
      setidreponse(null);
      setidfcandidat(cand);
      setidfchoixquestion(d);
    }

@Set_value_jspannotation(nom_atribue= "idreponse") 
 @AmethodeSet(nomcolonne =  "idreponse")  
  public void setidreponse(String string1){ 
 if(string1==null){ 
 idreponse=super.newprimarykey().toUpperCase(); 
 }else{ 
 idreponse= string1; 
 } 
} 
@Set_value_jspannotation(nom_atribue= "idfchoixquestion") 
 @AmethodeSet(nomcolonne =  "idfchoixquestion")  
 public void setidfchoixquestion(String integer1){ 
        idfchoixquestion= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "idfcandidat") 
 @AmethodeSet(nomcolonne =  "idfcandidat")  
 public void setidfcandidat(String integer1){ 
        idfcandidat= integer1; 
    } 

   @AmethodeGet(nomcolonne ="idreponse") 
   @APrimarykey(nomprimarykey = "idreponse") 
   public String getidreponse(){
       return idreponse;
    } 
   @AmethodeGet(nomcolonne ="idfchoixquestion") 
   public String getidfchoixquestion(){
       return idfchoixquestion;
    } 
   @AmethodeGet(nomcolonne ="idfcandidat") 
   public String getidfcandidat(){
       return idfcandidat;
    } 

  @Urlannotation(index = "accuillereponsequetion.do",nomparametre={}) 
  public etu002087.framework.ModelView accuillereponsequetion(){ 
    Vector resulta= super.selectAllWithcondition("limit 3"); 
    ModelView model = new ModelView(); 
    model.addItem("nbr",0);
    model.addItem("liste",resulta);
    model.setnompage("reponsequetion.jsp");
    return model; 
  }

  @Urlannotation(index = "insertreponsequetion.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String insertreponsequetion(){
    setidreponse(null);
    super.insert(null);
    return "insert"; 
    } 

  @Urlannotation(index = "paginationreponsequetion.do",nomparametre={"nbr"})
  @Sessionannotation()
  public etu002087.framework.ModelView paginationreponsequetion(Integer nbr){
    ModelView model = new ModelView();
    Vector resulta= super.selectAllWithcondition(" offset "+nbr+" limit 3");
    if(nbr<=0){
            model.addItem("nbr",0);
    }else{
        model.addItem("nbr",nbr);
   }
    model.addItem("liste",resulta);
    model.setnompage("reponsequetion.jsp");
    return model;
  }

  @Urlannotation(index = "modificationreponsequetion.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String modificationservice(){
    super.update(null);
    return "update"; 
  } 

  @Urlannotation(index = "deletereponsequetion.do",nomparametre={})
  public etu002087.framework.ModelView deletereponsequetion(){
      super.delete(null);
      Vector resulta= super.selectAllWithcondition("limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",resulta);
      model.setnompage("reponsequetion.jsp");
      return model;
  } 

  @Sessionannotation()
  @Urlannotation(index = "insertquestioncv.do",nomparametre={"idchoix"})
  public etu002087.framework.ModelView insertquestioncv(String[] idchoix){
   
    System.out.println("llll "+idchoix.length);
    String idcandidat = (String) getSession().get("idfcandidat");
    for(int i=0;i<idchoix.length;i++){
      Reponsequetion  p= new Reponsequetion(idcandidat, idchoix[i]);
      p.insert(null);
    }

    Vector resulta = new Demande_besoin().selectAll();
    Vector<Demande_besoin> res = new Vector<Demande_besoin>();
     for(int i=0;i<resulta.size();i++){
          Demande_besoin demande = (Demande_besoin) resulta.get(i);
          demande.setNotecritere(demande.getiddemande());
          res.add(demande);
     }
     ModelView model = new ModelView(); 
     model.addItem("liste",resulta);
     model.setnompage("client.jsp");
     return model; 

  }

  

} 
