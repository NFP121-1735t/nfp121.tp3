package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
    /** la liste des Maillons/Elements */
    private Maillon stk;
    /** la capacité de la pile */
    private int capacite;
    /** le nombre */
    private int nombre;

    /**
     * Classe interne "statique" contenant chaque élément de la chaine c'est une
     * proposition, vous pouvez l'ignorer !
     */
    private static class Maillon implements Cloneable {
        private Object element;
        private Maillon suivant;

        public Maillon(Object element, Maillon suivant) {
            this.element = element;
            this.suivant = suivant;
        }

        public Maillon suivant() {
            return this.suivant;
        }

        public Object element() {
            return this.element;
        }

        public Object clone() throws CloneNotSupportedException {
            Maillon m = (Maillon) super.clone();
            m.element = element;
            return m;
        }
    }

    /**
     * Création d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit être > 0
     */
    public Pile4(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = null;
            this.capacite = taille;
    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine()){
            throw new PilePleineException();
        }// à compléter
        Maillon Mk= new Maillon(o,this.stk);
        stk = Mk;//o est l'element a l'empiler , stk est l'element suivent
        nombre++;//marche de l'indice
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        
        Maillon me = this.stk;
        stk=stk.suivant();//cas 1 devient le cas suivant c.a.d ancien cas est depilee
        nombre--;
        // à compléter
        //return null;
        return me.element(); // retourn l'element depiler
    }

    public Object sommet() throws PileVideException {
        if (estVide()){
            throw new PileVideException();
        }
        //return null; // à compléter
        return this.stk.element();//car stk est le premiere cas(noeud) dans la liste
                             // donc stk comporte le sommet de la liste
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
       // return false; // à compléter
       return this.stk == null ; // si stk est null dont pas du sommet donc liste est vide
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        //return false; // à complét
         return capacite()==taille();
    }

    /**
     * Retourne une représentation en String d'une pile, contenant la
     * représentation en String de chaque élément.
     * 
     * @return une représentation en String d'une pile
     */
    public String toString() {

        String s = "[";
        // à compléter
        Maillon m1 = stk;//matrch du noeud principale c.a.d sommet
        while(stk !=null){//liste n'est pas vide
            s = s+ stk.element().toString(); // add all the elements to the string s
            stk = stk.suivant();//march au deuxieme noeud
            if(stk!=null)
            s= s+", ";//separation des elements par n'import quelle caracter
        }
        //stk = m1;
        return s + "]";
    }

    public boolean equals(Object o) {
             if(!(o instanceof Pile4)){ return false;}
        if(o instanceof Pile4){
            Pile4 p4 = (Pile4)o;
        if(p4.taille()==this.taille() && p4.capacite()==this.capacite()){return true;}
        if (p4.taille()!= this.taille()) {return false;}//comparaison de taill
        if(p4.capacite()!= this.capacite()) {return false;}//comparaison de capacite
                                                    ////on met 'this' car methode taile et capacite ne sont 
                                                                                            //pas static
       /* for(int i = v.size() - 1; i>0 ; i--){
             if(p3.v.get(i)!= this.v.get(i))
             return false;
            }*/
        }
        return true;
       /* if (o instanceof Pile4) {
            // à compléter
            return false;
        }*/
    }

    public int capacite() {
        return this.capacite;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        return nombre;
    }
}