package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>,Cloneable{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
        // à compléter
        if (taille <= 0){
            taille = CAPACITE_PAR_DEFAUT;
        }
        this.stk = new Stack<T>();
        this.capacite = taille;
    }

    public Pile2(){
        // à compléter
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(T o) throws PilePleineException{
        // à compléter
        if(estPleine()){
            throw new PilePleineException();
        }
        this.stk.push(o);
    }

    public T depiler() throws PileVideException{
        // à compléter
         if (estVide())
            throw new PileVideException();
        return this.stk.pop();
    }

    public T sommet() throws PileVideException{
        // à compléter
        if (estVide())
            throw new PileVideException();
        return this.stk.peek();
    }
    
    public int capacite(){
         return this.capacite;
    }
    
    public int taille(){
         return this.stk.size();
    }
    
    public boolean estVide(){
        return this.stk.empty();
    }
    
    public boolean estPleine(){
        return this.stk.size() == this.capacite;
    }
    
    public boolean equals(Object o){
          
        if( this== o ){
            return true;
        }
        try{
       if(!(o instanceof Pile2)){return false;}
        PileI pi = (Pile2)o;
        PileI p = (Pile2)this.clone();
        
        
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
    
    public int hashCode(){
        return toString().hashCode();
    }
    
    
     public String toString(){
         String s = "[";
        for (int i = this.stk.size() - 1; i >= 0; i--) {
           s+= this.stk.get(i).toString();
           if(i >0){
               s+= ", ";
           }       
        }
        return s + "]"; 
    }
    

    
    // recopier ici toutes les autres méthodes
    // qui ne sont pas modifiées en fonction
    // du type des éléments de la pile

} // Pile2