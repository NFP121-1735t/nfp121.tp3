package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        if(taille<=0){// prevoir le cas <=0
        taille = CAPACITE_PAR_DEFAUT;}
        stk= new Stack<Object>();
        this.capacite=taille;// a completer
    }

    // constructeur fourni
    public Pile2() {
        //this(0);
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
       if(estPleine()){
           throw new PilePleineException();
        }
        stk.push(o);//to push an element into the Stack.
                        //The element gets pushed onto the top of the Stack.
        // a completer
    }

    public Object depiler() throws PileVideException {
        if(estVide())
            throw new PileVideException();
        
        return stk.pop();//to pop an element from the stack.
                        //The element is popped from the top of the stack
        // a completer
        //return null;
    }

    public Object sommet() throws PileVideException {
        if(estVide()){
            throw new PileVideException();
        }
        return stk.peek();//to retrieve or fetch the first element of the Stack
                        //or the element present at the top of the Stack
        //return null;
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        // a completer
        //return false;
        return stk.isEmpty();//is used to check and verify if a Stack is empty or not.
                             //It returns True if the Stack is empty else it returns False
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
       return stk.size()== capacite(); // a completer 
        //return false;
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    
    public String toString() {
        String s = "[";
        for (int i = stk.size() - 1; i>=0 ; i--){
            s=s+stk.get(i).toString();
            if(i>=0)
            s=s+", ";
        }// a completer
        return s + "]";
    }

    public boolean equals(Object o) {
        // a completer
        //return false;
          if(!(o instanceof Pile2)){ return false;}
        if(o instanceof Pile2){
            Pile2 pe = (Pile2)o;
        if(pe.taille()==this.taille() && pe.capacite()==this.capacite()){return true;}
        if (pe.taille()!= this.taille()) {return false;}//comparaison de taill
        if(pe.capacite()!= this.capacite()) {return false;}//comparaison de capacite
                                                    ////on met 'this' car methode taile et capacite ne sont 
                                                                                            //pas static
        for(int i = stk.size() - 1; i>0 ; i--){
             if(pe.stk.get(i)!= this.stk.get(i))
             return false;
            }
        }
        return true;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        // a completer
        //return 0;
        return stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
        // a completer
        //return 0;
        return this.capacite;
    }

} // Pile2.java
