package etu002087.demandebesoin;
 import java.util.HashMap;
import java.util.Vector;
import generaliser.AmethodeSet;
import generaliser.Generaliser; 
import generaliser.ANomTable; 
import generaliser.Adatabase; 
import generaliser.AmethodeGet; 
import generaliser.APrimarykey;

import java.sql.Statement;
import java.util.Date; 
import etu002087.framework.Urlannotation; 
import etu002087.framework.ModelView; 
import etu002087.framework.Scopeannotation; 
import etu002087.framework.Set_value_jspannotation; 
import etu002087.framework.Sessionannotation; 
import etu002087.framework.Gsonannotation; 
import java.sql.*;
@ANomTable(nomtable = "demande_besoin", nbrclonne =11,nomsequence = "demande_besoinsequence")
@Adatabase(nombase = "rh_employee", typebase= "postgres",nomuser= "postgres",password= "root",port="5432") 
public class Demande_besoin extends Generaliser{ 

   String iddemande=new String();
   Double horaire=0.0;
   Integer nbr_employee=0;
   Double production_actuelle=0.0;
   Double production_demander=0.0;
   Date datedemande=new Date();
   Date datefin=new Date();
   String idfservice=new String();
   String fait="false";
   String description=new String();
   String idfhierarchie =new String();

//    Vector<Candidat> listecandidat = new Vector<Candidat>();
//    public void setListecandidat(){
//           listecandidat= new Candidat();
//    }
//    public Vector<Candidat> getListecandidat(){
//      return listecandidat;
//    }

     Hierarchie hierarchi ;
     public void sethierarchie(){
          hierarchi=new Hierarchie();
          hierarchi.setidhierarchie(getidfhierarchie() );
          hierarchi.findOne();
     }
     public Hierarchie gethierarchie(){
               return hierarchi;
     }
   

  
     @Set_value_jspannotation(nom_atribue= "idfhierarchie") 
     @AmethodeSet(nomcolonne =  "idfhierarchie")  
     public void setidfhierarchie(String hi){
          idfhierarchie=hi;
     }
     @AmethodeGet(nomcolonne ="idfhierarchie") 
     public String getidfhierarchie(){
          return idfhierarchie;
     }

   Vector<Notecritere> notedemande = new Vector<Notecritere>();
   public void  setNotecritere(String iddemande){
     notedemande= new Notecritere().selectAllWithcondition(" where idfdemande='"+iddemande+"' ");
   } 
   public Vector<Notecritere> getNotecritere(){
     return notedemande;
   }


     @Set_value_jspannotation(nom_atribue= "description") 
     @AmethodeSet(nomcolonne =  "description")  
     public void setdescription(String de){
               description=de;
     }
     @AmethodeGet(nomcolonne ="description") 
     public String getdescription(){
          return description;
     }

     @AmethodeSet(nomcolonne =  "fait")  
     public void setfait(String f){
               fait=f;
     }
     @AmethodeGet(nomcolonne ="fait")
     public String getfait(){
          return fait;
     }
      HashMap<String,Object> session;
      public void setSession(HashMap<String,Object> s){
         session=s;
       }
      public HashMap<String,Object> getSession(){
          return session;
      }

   public Demande_besoin(){  
   super();  
   super.setchild(this);  
      } 
@Set_value_jspannotation(nom_atribue= "iddemande") 
 @AmethodeSet(nomcolonne =  "iddemande")  
  public void setiddemande(String string1){ 
 if(string1==null){ 
 iddemande=super.newprimarykey().toUpperCase(); 
 }else{ 
 iddemande= string1; 
 } 
} 
@Set_value_jspannotation(nom_atribue= "horaire") 
 @AmethodeSet(nomcolonne =  "horaire")  
 public void sethoraire(Double double1){ 
      horaire= double1; 
     } 
@Set_value_jspannotation(nom_atribue= "nbr_employee") 
 @AmethodeSet(nomcolonne =  "nbr_employee")  
 public void setnbr_employee(Integer double1){ 
      nbr_employee= double1; 
     } 
@Set_value_jspannotation(nom_atribue= "production_actuelle") 
 @AmethodeSet(nomcolonne =  "production_actuelle")  
 public void setproduction_actuelle(Double double1){ 
      production_actuelle= double1; 
     } 
@Set_value_jspannotation(nom_atribue= "production_demander") 
 @AmethodeSet(nomcolonne =  "production_demander")  
 public void setproduction_demander(Double double1){ 
      production_demander= double1; 
     } 
@Set_value_jspannotation(nom_atribue= "datedemande") 
 @AmethodeSet(nomcolonne =  "datedemande")  
 public void setdatedemande(Date date1){ 
      datedemande= date1; 
 } 
@Set_value_jspannotation(nom_atribue= "datefin") 
 @AmethodeSet(nomcolonne =  "datefin")  
 public void setdatefin(Date date1){ 
      datefin= date1; 
 } 
@Set_value_jspannotation(nom_atribue= "idfservice") 
 @AmethodeSet(nomcolonne =  "idfservice")  
 public void setidfservice(String integer1){ 
        idfservice= integer1; 
    } 

   @AmethodeGet(nomcolonne ="iddemande") 
   @APrimarykey(nomprimarykey = "iddemande") 
   public String getiddemande(){
       return iddemande;
    } 
   @AmethodeGet(nomcolonne ="horaire") 
   public Double gethoraire(){
       return horaire;
    } 
   @AmethodeGet(nomcolonne ="nbr_employee") 
 public Integer getnbr_employee(){
       return nbr_employee;
    } 
   @AmethodeGet(nomcolonne ="production_actuelle") 
   public Double getproduction_actuelle(){
       return production_actuelle;
    } 
   @AmethodeGet(nomcolonne ="production_demander") 
   public Double getproduction_demander(){
       return production_demander;
    } 
   @AmethodeGet(nomcolonne ="datedemande") 
   public Date getdatedemande(){
         return datedemande;
    } 
   @AmethodeGet(nomcolonne ="datefin") 
   public Date getdatefin(){
         return datefin;
    } 
   @AmethodeGet(nomcolonne ="idfservice") 
   public String getidfservice(){
       return idfservice;
    } 

     @Sessionannotation()
     @Urlannotation(index = "accuilledemande_besoin.do",nomparametre={}) 
  public etu002087.framework.ModelView accuilledemande_besoin(){ 
     
     String idservice=(String) getSession().get("idserviceuser");
    
     Vector resulta= super.selectAllWithcondition(" where idfservice='"+idservice.toUpperCase()+"' limit 3"); 
     ModelView model = new ModelView(); 
     model.addItem("hierarchie",new Hierarchie().selectAllWithcondition("where idfservice='"+idservice.toUpperCase()+"' "));
     model.addItem("nbr",0);
     model.addItem("liste",resulta);
     
     model.setnompage("demande_besoin.jsp");
     System.out.println("kkkkkkkkkk   "+idservice);
     return model; 
  }

  @Urlannotation(index = "insertdemande_besoin.do",nomparametre={})
  @Gsonannotation()
  @Sessionannotation()
  public String insertdemande_besoin(){
    setiddemande(null);
    setidfservice( ((String) getSession().get("idservice")).toUpperCase());
    super.insert(null);
    return "insert"; 
    } 

  @Urlannotation(index = "paginationdemande_besoin.do",nomparametre={"nbr"})
  @Sessionannotation()
  public etu002087.framework.ModelView paginationdemande_besoin(Integer nbr){
     String idservice=(String) getSession().get("idserviceuser");
    ModelView model = new ModelView();

    Vector resulta= super.selectAllWithcondition(" where idfservice='"+idservice.toUpperCase()+"' offset "+nbr+" limit 3");
    if(nbr<=0){
            model.addItem("nbr",0);
    }else{
        model.addItem("nbr",nbr);
   }
     model.addItem("hierarchie",new Hierarchie().selectAllWithcondition("where idfservice='"+idservice+"' "));
     model.addItem("liste",resulta);
     model.setnompage("demande_besoin.jsp");
    return model;
  }

  @Gsonannotation()
  @Urlannotation(index = "modificationdemande_besoin.do",nomparametre={"idde","nbre","ihe"})
  public String modificationservice(String idde,String nbre,String ihe){
   
     ConnectPostgres connex = new ConnectPostgres(); 
    try {
     Connection con = connex.getconnection();
     Statement stmt= con.createStatement();
     String requete = "update  demande_besoin  set   nbr_employee="+nbre+",idfhierarchie='"+ihe+"' Where iddemande='"+idde+"'";
     System.out.println(requete);
     stmt.executeUpdate(requete);
     stmt.close();
     con.close();
     } catch (Exception e) {
          System.out.println(e);
     }

    return "update"; 

  } 

  @Sessionannotation()
  @Urlannotation(index = "deletedemande_besoin.do",nomparametre={})
  public etu002087.framework.ModelView deletedemande_besoin(){
      super.delete(null);
      String idservice=(String) getSession().get("idserviceuser");
      Vector resulta= super.selectAllWithcondition(" where idfservice='"+idservice.toUpperCase()+"' limit 3");
      ModelView model = new ModelView(); 
      model.addItem("nbr",0);
      model.addItem("liste",resulta);
      model.setnompage("demande_besoin.jsp");
      return model;
  } 
  @Sessionannotation()
  @Urlannotation(index = "demandefait.do",nomparametre={"fa","iddemande"})
  public etu002087.framework.ModelView  demandefait(String fa,String iddemande){
     super.update(null," where iddemande='"+iddemande+"'","set fait='"+fa+"'");
     //accuille 
     String idservice=(String) getSession().get("idservice");
     Vector resulta= super.selectAllWithcondition(" where idfservice='"+idservice.toUpperCase()+"' limit 3"); 
     ModelView model = new ModelView(); 
     model.addItem("nbr",0);
     model.addItem("liste",resulta);
     
     model.setnompage("demande_besoin.jsp");
     return model; 
     // fin 

  }

  @Urlannotation(index = "clientdemande.do",nomparametre={})
  public etu002087.framework.ModelView  clientdemande(){
     Vector resulta = super.selectAllWithcondition(" where fait='false' or fait is null ");
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

  @Sessionannotation()
  @Gsonannotation()
  @Urlannotation(index = "insertnewdemande.do",nomparametre={"nbre","debut","fin","idfhi"})
  public String insertnewdemande(Integer nbre,String debut,String fin,String idfhi){
          String idservice = (String) getSession().get("idserviceuser");
          ConnectPostgres connex = new ConnectPostgres(); 
          Demande_besoin demande = new Demande_besoin();
          demande.setiddemande(null);
     try {
          Connection con = connex.getconnection();
          Statement stmt= con.createStatement();
          String requete = "insert into demande_besoin(iddemande,nbr_employee,datedemande,datefin,idfservice,idfhierarchie,fait)  values ('"+demande.getiddemande()+"',"+nbre+",'"+debut+"'::timestamp,'"+fin+"'::timestamp,'"+idservice+"','"+idfhi+"','false')";
          System.out.println(requete);
          stmt.executeUpdate(requete);
          stmt.close();
          con.close();
          } catch (Exception e) {
               System.out.println(e);
          }
          // fin 
          return "insert";
     }

    
     @Sessionannotation()
     @Urlannotation(index = "listecandidatdemandesudo.do",nomparametre={"iddemande"})//liste simple sans l'ordre de note
     public etu002087.framework.ModelView listedemandesudo(String iddemande){
          Vector<Candidat> resulta = new Candidat().selectAllWithcondition(" LEFT JOIN detailleemploie ON candidat.idcandidat = detailleemploie.idfcandidat where detailleemploie.idfcandidat is null and  idfdemande='"+iddemande+"' ");
          ModelView model = new ModelView(); 
          model.addItem("liste",resulta);
          model.setnompage("listecandidature.jsp");
          return model;    
     }

     @Sessionannotation()
     @Urlannotation(index = "accuilledemande_besoinsudo.do",nomparametre={}) 
     public etu002087.framework.ModelView accuilledemande_besoinsudo(){ 
          String idservice=(String) getSession().get("idserviceuser");
          Vector resulta= super.selectAllWithcondition(" where fait='false' or fait is null "); 
          ModelView model = new ModelView(); 
          model.addItem("liste",resulta);
          model.setnompage("demandebesoinservice.jsp");
      
          return model; 
     }

  
} 
