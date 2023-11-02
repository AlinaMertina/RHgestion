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

@ANomTable(nomtable = "heurdetravaille", nbrclonne =4,nomsequence = "heurdetravaillesequence")
@Adatabase(nombase = "rh_employee", typebase= "postgres",nomuser= "postgres",password= "root",port="5432") 
public class Heurdetravaille extends Generaliser{ 
   String idheurtravaille;
   String idfhierarchie;
   Double heure;
   Double prix;
   Hierarchie hierarchie;

   public void setHierarchie(){
      hierarchie= new Hierarchie();
      hierarchie.setidhierarchie(getidfhierarchie());
      hierarchie.findOne();
   }
   public Hierarchie getHierarchie(){
    return hierarchie;
   }

      HashMap<String,Object> session;
      public void setSession(HashMap<String,Object> s){
         session=s;
       }
      public HashMap<String,Object> getSession(){
          return session;
      }

   public Heurdetravaille(){  
   super();  
   super.setchild(this);  
      } 
@Set_value_jspannotation(nom_atribue= "idheurtravaille") 
 @AmethodeSet(nomcolonne =  "idheurtravaille")  
  public void setidheurtravaille(String string1){ 
 if(string1==null){ 
 idheurtravaille=super.newprimarykey().toUpperCase(); 
 }else{ 
 idheurtravaille= string1; 
 } 
} 
@Set_value_jspannotation(nom_atribue= "idfhierarchie") 
 @AmethodeSet(nomcolonne =  "idfhierarchie")  
 public void setidfhierarchie(String integer1){ 
        idfhierarchie= integer1; 
    } 
@Set_value_jspannotation(nom_atribue= "heure") 
 @AmethodeSet(nomcolonne =  "heure")  
 public void setheure(Double double1){ 
      heure= double1; 
     } 
@Set_value_jspannotation(nom_atribue= "prix") 
 @AmethodeSet(nomcolonne =  "prix")  
 public void setprix(Double double1){ 
      prix= double1; 
     } 

   @AmethodeGet(nomcolonne ="idheurtravaille") 
   @APrimarykey(nomprimarykey = "idheurtravaille") 
   public String getidheurtravaille(){
       return idheurtravaille;
    } 
   @AmethodeGet(nomcolonne ="idfhierarchie") 
   public String getidfhierarchie(){
       return idfhierarchie;
    } 
   @AmethodeGet(nomcolonne ="heure") 
   public Double getheure(){
       return heure;
    } 
   @AmethodeGet(nomcolonne ="prix") 
   public Double getprix(){
       return prix;
    } 

  @Urlannotation(index = "accuilleheurdetravaille.do",nomparametre={}) 
  public etu002087.framework.ModelView accuilleheurdetravaille(){ 
    Vector resulta= super.selectAllWithcondition("limit 3"); 
    ModelView model = new ModelView(); 
    model.addItem("nbr",0);

    model.addItem("hierarchie", new Hierarchie().selectAll() );
    model.addItem("liste",resulta);
    model.setnompage("heurdetravaille.jsp");
    return model; 
  }


  @Urlannotation(index = "insertheurdetravaille.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String insertheurdetravaille(){
      setidheurtravaille(null);
      if((new Heurdetravaille().selectAllWithcondition(" where idfhierarchie='"+getidfhierarchie()+"' ")).size() <= 0){
        super.insert(null);
        return "insert"; 
      }
      return "not insert";
    } 

  @Urlannotation(index = "paginationheurdetravaille.do",nomparametre={"nbr"})
  @Sessionannotation()
  public etu002087.framework.ModelView paginationheurdetravaille(Integer nbr){
    ModelView model = new ModelView();
    Vector resulta= super.selectAllWithcondition(" offset "+nbr+" limit 3");
    if(nbr<=0){
            model.addItem("nbr",0);
    }else{
        model.addItem("nbr",nbr);
   }
   model.addItem("hierarchie", new Hierarchie().selectAll() );
    model.addItem("liste",resulta);
    model.setnompage("heurdetravaille.jsp");
    return model;
  }

  @Urlannotation(index = "modificationheurdetravaille.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String modificationservice(){
    super.update(null);
    return "update"; 
  } 

  @Urlannotation(index = "deleteheurdetravaille.do",nomparametre={})
  public etu002087.framework.ModelView deleteheurdetravaille(){
      super.delete(null);
      Vector resulta= super.selectAllWithcondition(" limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("hierarchie", new Hierarchie().selectAll() );
      model.addItem("liste",resulta);
      model.setnompage("heurdetravaille.jsp");
      return model;
  } 

} 
