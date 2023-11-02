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
@ANomTable(nomtable = "question", nbrclonne =4,nomsequence = "questionsequence")
@Adatabase(nombase = "rh_employee", typebase= "postgres",nomuser= "postgres",password= "root",port="5432") 
public class Question extends Generaliser{ 
   String idquestion;
   String idfdemande;
   String textquestion;
   Integer note;

   Vector<Choixquestion> choix = new Vector<Choixquestion>() ;
   public void setchoix(String idquestion){
          choix= new Choixquestion().selectAllWithcondition( " where  idfquestion='"+idquestion+"'");
   }
   public Vector<Choixquestion> getchoix(){
      return choix;
   }
   

      HashMap<String,Object> session;
      public void setSession(HashMap<String,Object> s){
         session=s;
       }
      public HashMap<String,Object> getSession(){
          return session;
      }

   public Question(){  
   super();  
   super.setchild(this);  
      } 
@Set_value_jspannotation(nom_atribue= "idquestion") 
 @AmethodeSet(nomcolonne =  "idquestion")  
  public void setidquestion(String string1){ 
 if(string1==null){ 
 idquestion=super.newprimarykey().toUpperCase(); 
 }else{ 
 idquestion= string1; 
 } 
} 
@Set_value_jspannotation(nom_atribue= "idfdemande") 
 @AmethodeSet(nomcolonne =  "idfdemande")  
 public void setidfdemande(String integer1){ 
        idfdemande= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "textquestion") 
 @AmethodeSet(nomcolonne =  "textquestion")  
 public void settextquestion(String string1){ 
      textquestion= string1; 
     } 
@Set_value_jspannotation(nom_atribue= "note") 
 @AmethodeSet(nomcolonne =  "note")  
 public void setnote(Integer double1){ 
      note= double1; 
     } 

   @AmethodeGet(nomcolonne ="idquestion") 
   @APrimarykey(nomprimarykey = "idquestion") 
   public String getidquestion(){
       return idquestion;
    } 
   @AmethodeGet(nomcolonne ="idfdemande") 
   public String getidfdemande(){
       return idfdemande;
    } 
   @AmethodeGet(nomcolonne ="textquestion") 
   public String gettextquestion(){
       return textquestion;
    } 
   @AmethodeGet(nomcolonne ="note") 
 public Integer getnote(){
       return note;
    } 

  @Sessionannotation()
  @Urlannotation(index = "accuillequestion.do",nomparametre={"iddemande"}) 
  public etu002087.framework.ModelView accuillequestion(String iddemande){ 
    getSession().put("iddemande", iddemande);
    Vector resulta= super.selectAllWithcondition(" where  idfdemande='"+iddemande+"' limit 3"); 
    ModelView model = new ModelView(); 
    model.addItem("nbr",0);
    model.addItem("liste",resulta);
    model.setnompage("question.jsp");
    return model; 
  }

  @Urlannotation(index = "insertquestion.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String insertquestion(){
      String iddemande = (String) getSession().get("iddemande");
      setidquestion(null);
      setidfdemande(iddemande);
      super.insert(null);
      return "insert"; 

    } 

  @Urlannotation(index = "paginationquestion.do",nomparametre={"nbr"})
  @Sessionannotation()
  public etu002087.framework.ModelView paginationquestion(Integer nbr){
    String iddemande = (String) getSession().get("iddemande");
    ModelView model = new ModelView();
    Vector resulta= super.selectAllWithcondition("  where  idfdemande='"+iddemande+"' offset "+nbr+" limit 3");
    if(nbr<=0){
            model.addItem("nbr",0);
    }else{
        model.addItem("nbr",nbr);
   }
    model.addItem("liste",resulta);
    model.setnompage("question.jsp");
    return model;
  }

  @Urlannotation(index = "modificationquestion.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String modificationservice(){
    super.update(null);
    return "update"; 
  } 

  @Urlannotation(index = "deletequestion.do",nomparametre={})
  public etu002087.framework.ModelView deletequestion(){
      super.delete(null);
      Vector resulta= super.selectAllWithcondition("limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",resulta);
      model.setnompage("question.jsp");
      return model;
  } 

  
  // @Urlannotation(index = "questioncv.do",nomparametre={"iddemande"})
  // public etu002087.framework.ModelView questioncv(String iddemande){
    
  //     Vector<Question> resulta = super.selectAllWithcondition( " where idfdemande='"+iddemande.toUpperCase()+"'");
  //     Vector<Question> res =new Vector<Question>();
  //     System.out.println(" where idfdemande='"+iddemande+"'   "+resulta.size());
  //     for(int i=0;i<resulta.size();i++){
  //       Question q = resulta.get(i);
  //         q.setchoix(q.getidquestion());
  //         res.add(q);
  //     }
  //     ModelView model = new ModelView(); 
  //     model.addItem("liste",res);
  //     model.setnompage("questioncv.jsp");
  //     return model;
  // } 

} 
