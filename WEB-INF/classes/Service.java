package etu002087.superutilisateur;

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
import etu002087.demandebesoin.*;


@ANomTable(nomtable = "service", nbrclonne =2,nomsequence = "servicesequence")
@Adatabase(nombase = "rh_employee", typebase= "postgres",nomuser= "postgres",password= "root",port="5432") 
public class Service extends Generaliser{ 
   String idservice;
   String nomservice;

  //  demande par service
   Vector<Demande_besoin> listedemande = new Vector<Demande_besoin>();
   public void setlistedemande(String idservice){
        listedemande= new Demande_besoin().selectAllWithcondition( " where idfservice='"+idservice+"' " );
   }
   public Vector<Demande_besoin> getlistedemande(){
    return listedemande;
   }

      HashMap<String,Object> session;
      public void setSession(HashMap<String,Object> s){
         session=s;
       }
      public HashMap<String,Object> getSession(){
          return session;
      }

   public Service(){  
   super();  
   super.setchild(this);  
      } 
@Set_value_jspannotation(nom_atribue= "idservice") 
 @AmethodeSet(nomcolonne =  "idservice")  
  public void setidservice(String string1){ 
 if(string1==null){ 
 idservice=super.newprimarykey().toUpperCase(); 
 }else{ 
 idservice= string1; 
 } 
} 
@Set_value_jspannotation(nom_atribue= "nomservice") 
 @AmethodeSet(nomcolonne =  "nomservice")  
 public void setnomservice(String integer1){ 
        nomservice= integer1; 
    } 

    

   @AmethodeGet(nomcolonne ="idservice") 
   @APrimarykey(nomprimarykey = "idservice") 
   public String getidservice(){
       return idservice;
    } 
   @AmethodeGet(nomcolonne ="nomservice") 
   public String getnomservice(){
       return nomservice;
    } 

  @Urlannotation(index = "accuilleservice.do",nomparametre={}) 
  public etu002087.framework.ModelView accuilleservice(){ 
    Vector resulta= super.selectAllWithcondition("limit 3"); 
    ModelView model = new ModelView(); 
    model.addItem("nbr",0);
    model.addItem("liste",resulta);
    model.setnompage("service.jsp");
    return model; 
  }

  @Urlannotation(index = "insertservice.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String insertservice(){
    setidservice(null);
    super.insert(null);
    return "insert"; 
    } 

  @Urlannotation(index = "paginationservice.do",nomparametre={"nbr"})
  @Sessionannotation()
  public etu002087.framework.ModelView paginationservice(Integer nbr){
    ModelView model = new ModelView();
    Vector resulta= super.selectAllWithcondition(" offset "+nbr+" limit 3");
    if(nbr<=0){
            model.addItem("nbr",0);
    }else{
        model.addItem("nbr",nbr);
   }
    model.addItem("liste",resulta);
    model.setnompage("service.jsp");
    return model;
  }

  @Urlannotation(index = "modificationservice.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String modificationservice(){
    super.update(null);
    return "update"; 
  } 

  @Urlannotation(index = "deleteservice.do",nomparametre={})
  public etu002087.framework.ModelView deleteservice(){
      super.delete(null);
      Vector resulta= super.selectAllWithcondition("limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",resulta);
      model.setnompage("service.jsp");
      return model;
  } 

} 
