package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
        // à compléter
        if(taille<0)
        taille= CAPACITE_PAR_DEFAUT;
        stk=new Stack<T>();
        this.capacite=taille;
    }

    public Pile2(){
        // à compléter
        this(TAILLE_PAR_DEFAUT);
    }

    public void empiler(T o) throws PilePleineException{
        // à compléter
       if(estPleine())
       throw new PilePleineException();
       stk.push(o);//to push an element into the Stack.
                 //The element gets pushed onto the top of the Stack.
    }

    public T depiler() throws PileVideException{
        // à compléter
        if(estVide()){
        throw new PileVideException();
    }
        return stk.pop();//to pop an element from the stack.
                        //The element is popped from the top of the stack
    }

    public T sommet() throws PileVideException{
        // à compléter
        if(estVide()){
        throw new PileVideException();
    }
        return stk.peek();//to retrieve or fetch the first element of the Stack
                        //or the element present at the top of the Stack
        
    }
    public boolean estPleine() {
       return stk.size()== capacite(); // a completer 
        //return false;
    }
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
     public int taille() {
        // a completer
        //return 0;
        return stk.size();
    }
     public int capacite() {
        // a completer
        //return 0;
        return this.capacite;
    }

    

    // recopier ici toutes les autres méthodes
    // qui ne sont pas modifiées en fonction
    // du type des éléments de la pile

} // Pile2