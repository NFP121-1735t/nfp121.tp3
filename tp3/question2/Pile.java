package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        if(taille<0)
        taille=CAPACITE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr=0;//instance du zone cad par defaut 0 la march du 1er cas 
        //creer le tableau zone de la meme capacite
        // traiter le cas <=0
        // a completer
    }

    public Pile() {
       // this(taille);
       this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if(estPleine())
            throw new PilePleineException();
            this.zone[this.ptr]= o ;
            this.ptr++;
            
        //march au deuxieme instance
            //empiler l'object o a l'instance ptr c a d au debut du Zone
        // a completer
    }

    public Object depiler() throws PileVideException {
        if(estVide()) 
            throw new PileVideException();
            this.ptr--; //march de la dernier element du zone 
            //donc on retourne la dernier element ajoutee au pile
            // a completer
        return zone[this.ptr];
    
    //retourner l'element depilee ;
    }

    public Object sommet() throws PileVideException {
        if(estVide())
            throw new PileVideException();
            // a completer
        return zone[this.ptr-1];//retourne l'element qui est avant du deuxieme element cad la sommet
    }

    public int capacite() {
        // a completer
        return zone.length;//la taille du tableau est le nombre max des elemnts que l'on empiler
    }

    public int taille() {
        // a completer
        //return ptr;
        return this.ptr;
    }

    public boolean estVide() {
        // a completer
        return this.ptr == 0;
    }

    public boolean estPleine() {
        // a completer
        return this.ptr == zone.length;
    }

    public boolean equals(Object o) {
        // a completer
        //return false;
        if(!(o instanceof Pile)){ return false;}
        if(o instanceof Pile){
            Pile pi = (Pile)o;
        if(pi.taille()==this.taille() && pi.capacite()==this.capacite()){return true;}
        if (pi.taille()!= this.taille()) {return false;}//comparaison de taill
        if(pi.capacite()!= this.capacite()) {return false;}//comparaison de capacite
                                                    ////on met 'this' car methode taile et capacite ne sont 
                                                                                            //pas static
        for(int i = ptr - 1; i>0 ; i--){
             if(this.zone[i]!= pi.zone[i])
             return false;
            }
        }
        return true;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        // a completer
        StringBuffer sg = new StringBuffer("[");
        for ( int i = ptr-1 ; i>=0;i--){
            sg.append(zone[i].toString());
            if(i>0)
            sg.append(", ");
        }
            sg.append("]");
            return sg.toString();//cette methode est deja presente dans
                                //la class pile du question 1 , et responsable pour 
        //return null;          // afficher(ecrire) la zone
    }
}