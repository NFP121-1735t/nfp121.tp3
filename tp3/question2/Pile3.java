package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;
  
    public Pile3() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public Pile3(int taille) {
        // traiter le cas <=0
        // à compléter
        if(taille<0)
        taille=CAPACITE_PAR_DEFAUT;
        v= new Vector<Object>(taille);
    }

    public void empiler(Object o) throws PilePleineException {
        // à compléter
          if(estPleine()){
            throw new PilePleineException();
          }
          v.add(o);//The element specified by the parameter
                    //is appended to end of the vector. 
    }
    

    public Object depiler() throws PileVideException {
        // à compléter
        //return null;
        if(estVide()){
            throw new PileVideException();
        }
        return v.remove(taille() - 1);// is used to remove the last element from a Vector
    }
                                       


      

    public Object sommet() throws PileVideException {
        // à compléter
        //return null;
         if(estVide()){
            throw new PileVideException();
        }
        return v.lastElement();// is used to get the last element from a Vector
    }

    public int taille() {
        // à compléter
        //return -1;
        return v.size();//is used to get the size of the Vector 
                    //or the number of elements present in the Vector.
        
    }

    public int capacite() {
        // à compléter
        //return -1;
        return v.capacity();// is used to get the capacity of the Vector 
                        //or the length of the array present in the Vector.
    }

    public boolean estVide() {
        // à compléter
        //return false;
        return taille() == 0;
    }

    public boolean estPleine() {
        // à compléter
        //return false;
        return taille() == capacite();
    }

    public String toString() {
        // à compléter
        //return "";
        String s = "[";
        for (int i = this.taille() - 1 ; i >= 0 ; i--){
            s= s+v.get(i).toString();
            if(i>=0)
            s = s+" -";
        }
        return s + "]";
    }
    

    public boolean equals(Object o) {
        // à compléter
        //return false;
         if(!(o instanceof Pile3)){ return false;}
        if(o instanceof Pile3){
            Pile3 p3 = (Pile3)o;
        if(p3.taille()==this.taille() && p3.capacite()==this.capacite()){return true;}
        if (p3.taille()!= this.taille()) {return false;}//comparaison de taill
        if(p3.capacite()!= this.capacite()) {return false;}//comparaison de capacite
                                                    ////on met 'this' car methode taile et capacite ne sont 
                                                                                            //pas static
        for(int i = v.size() - 1; i>0 ; i--){
             if(p3.v.get(i)!= this.v.get(i))
             return false;
            }
        }
        return true;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
