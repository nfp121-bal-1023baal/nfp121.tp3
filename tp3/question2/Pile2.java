package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2  implements PileI,Cloneable {
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
        // prevoir le cas <=0
        // a completer
         if (taille < 0)
           { taille = CAPACITE_PAR_DEFAUT;}
        this.stk = new Stack<Object>();
        this.capacite = taille;
    }

    // constructeur fourni
    public Pile2() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        // a completer
        if (estPleine())
            throw new PilePleineException();
        this.stk.push(o);
    }

    public Object depiler() throws PileVideException {
        // a completer
        if(estVide())
            throw new PileVideException();
        return this.stk.pop();
    }

    public Object sommet() throws PileVideException {
        // a completer
        if (estVide())
            throw new PileVideException();
        return this.stk.peek();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        // a completer
        return this.stk.empty();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        // a completer
        return this.taille() >=capacite;
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        String s = "[";
        // a completer
        for(int i=this.stk.size()-1 ; i>=0 ; i--)
        {
            s+=this.stk.get(i).toString();
            if(i>0) s+=", ";
        }
        
        return s + "]";
    }

    public boolean equals(Object o) {
        // a completer
        try{
        if( this== o ){
            return true;
        }
       if(!(o instanceof PileI)){return false;}
        PileI pi = foundClass(o);
        PileI p = (PileI)this.clone();
        
        
        if (pi.taille() == p.taille() 
            && pi.capacite() == p.capacite())
            {
            
            for(int i= 0; i<taille() ; i++){
                
               Object ob= pi.depiler();Object ob1=p.depiler();
               if(!ob.equals(ob1)) return false;
                    
                }
            
            return true;
        }
    }
    catch(CloneNotSupportedException e){e.printStackTrace(); }
            catch(PileVideException e){e.printStackTrace();}
            
        return false;
    

    }
    
    public Object clone() throws CloneNotSupportedException
    {
        Pile2 p = (Pile2)super.clone();
        
        p.setSTK(stk.clone());
        return p;
    }
    
    public void setSTK(Object t)
    {
        this.stk=(Stack)t;
    }
     
    private PileI foundClass(Object o)throws CloneNotSupportedException
    {
       
        if(o instanceof Pile){return (PileI)((Pile)o).clone();}
        if(o instanceof Pile2){return (PileI)((Pile2)o).clone();}
        if(o instanceof Pile3){return (PileI)((Pile3)o).clone();}
        if(o instanceof Pile4){return (PileI)((Pile4)o).clone();}
        
         return null;
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
        return this.stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
        // a completer
        return this.capacite;
    }
    
} // Pile2.java
