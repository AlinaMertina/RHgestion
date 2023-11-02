
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
import etu002087.superutilisateur.Service;

@ANomTable(nomtable = "hierarchie", nbrclonne =3,nomsequence = "hierarchiesequence")
@Adatabase(nombase = "rh_employee", typebase= "postgres",nomuser= "postgres",password= "root",port="5432") 
public class Hierarchie extends Generaliser{ 
   String idhierarchie;
   String idfservice;
   String nomhierarchie;

      HashMap<String,Object> session;
      public void setSession(HashMap<String,Object> s){
         session=s;
       }
      public HashMap<String,Object> getSession(){
          return session;
      }

   public Hierarchie(){  
   super();  
   super.setchild(this);  
      } 
@Set_value_jspannotation(nom_atribue= "idhierarchie") 
 @AmethodeSet(nomcolonne =  "idhierarchie")  
  public void setidhierarchie(String string1){ 
 if(string1==null){ 
 idhierarchie=super.newprimarykey().toUpperCase(); 
 }else{ 
 idhierarchie= string1; 
 } 
} 
@Set_value_jspannotation(nom_atribue= "idfservice") 
 @AmethodeSet(nomcolonne =  "idfservice")  
 public void setidfservice(String integer1){ 
        idfservice= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "nomhierarchie") 
 @AmethodeSet(nomcolonne =  "nomhierarchie")  
 public void setnomhierarchie(String integer1){ 
        nomhierarchie= integer1; 
    } 
    
   @AmethodeGet(nomcolonne ="idhierarchie") 
   @APrimarykey(nomprimarykey = "idhierarchie") 
   public String getidhierarchie(){
       return idhierarchie;
    } 
   @AmethodeGet(nomcolonne ="idfservice") 
   public String getidfservice(){
       return idfservice;
    } 
   @AmethodeGet(nomcolonne ="nomhierarchie") 
   public String getnomhierarchie(){
       return nomhierarchie;
    } 
    

  @Urlannotation(index = "accuillehierarchie.do",nomparametre={}) 
  public etu002087.framework.ModelView accuillehierarchie(){ 
    Vector resulta= super.selectAllWithcondition("limit 3"); 
    ModelView model = new ModelView(); 
    model.addItem("nbr",0);
    model.addItem("service", new Service().selectAll() );
    model.addItem("liste",resulta);
    model.setnompage("hierarchie.jsp");
    return model; 
  }

  @Urlannotation(index = "inserthierarchie.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String inserthierarchie(){
    setidhierarchie(null);
    // setidfservice( (String) getSession().get("idservice"));
    super.insert(null);
    return "insert"; 
    } 

  @Urlannotation(index = "paginationhierarchie.do",nomparametre={"nbr"})
  @Sessionannotation()
  public etu002087.framework.ModelView paginationhierarchie(Integer nbr){
    ModelView model = new ModelView();
    Vector resulta= super.selectAllWithcondition(" offset "+nbr+" limit 3");
    if(nbr<=0){
            model.addItem("nbr",0);
    }else{
        model.addItem("nbr",nbr);
   }
    model.addItem("service", new Service().selectAll() );
    model.addItem("liste",resulta);
    model.setnompage("hierarchie.jsp");
    return model;
  }

  @Urlannotation(index = "modificationhierarchie.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String modificationservice(){
    super.update(null);
    return "update"; 
  } 

  @Urlannotation(index = "deletehierarchie.do",nomparametre={})
  public etu002087.framework.ModelView deletehierarchie(){
      super.delete(null);
      Vector resulta= super.selectAllWithcondition("limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",resulta);
      model.setnompage("hierarchie.jsp");
      return model;
  } 

} 
