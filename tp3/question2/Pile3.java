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
public class Pile3  implements PileI,Cloneable {

    private Vector<Object> v;
    private int capacite;

    public Pile3() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public Pile3(int taille) {
        // traiter le cas <=0
        // à compléter
        if (taille < 0)
            taille = CAPACITE_PAR_DEFAUT;
            
            this.v = new Vector<Object>();
            this.capacite=taille;
    }

    public void empiler(Object o) throws PilePleineException {
        
        // à compléter
     if (estPleine())
            throw new PilePleineException();
          this.v.add(o); 
    }

    public Object depiler() throws PileVideException {
        // à compléter
    if(estVide())
            throw new PileVideException();
           int s=v.lastIndexOf(sommet());
           
        return this.v.remove(s);
    }

    public Object sommet() throws PileVideException {
        // à compléter
    if(estVide())
            throw new PileVideException();
            
        return this.v.lastElement();
    }

    public int taille() {
        // à compléter
        return this.v.size();
    }

    public int capacite() {
        // à compléter
        return this.capacite;
    }

    public boolean estVide() {
        // à compléter
        return this.v.isEmpty();
    }

    public boolean estPleine() {
        // à compléter
        return this.v.size() == this.capacite;
    }

    public String toString() {
        // à compléter
     String s = "[";
    
        for(int i=this.v.size()-1 ; i>=0 ; i--)
        {
            s+=this.v.get(i).toString();
            if(i>0) s+=", ";
        }
        
        return s + "]";
    }

    public boolean equals(Object o) {
        // à compléter
        if(this == o) return true;
        if(!(o instanceof PileI)){ return false;}
       try{
           PileI pi= foundClass(o);
           PileI p= (PileI) this.clone();
           if(pi.taille() == p.taille()
                        && pi.capacite() == p.capacite())
           {
            
               for(int i=0 ; i<pi.taille() ; i++)
               {
                   Object ob = p.depiler();Object ob2 = pi.depiler();
                   if(!ob.equals(ob2)) return false;  
                   
                }
                return true;
            }
          }
          catch(CloneNotSupportedException e){e.printStackTrace();}
            catch(PileVideException e){e.printStackTrace();}
          
        return false;
     

    }
    
    
    public Object clone() throws CloneNotSupportedException
    {
        Pile3 p = (Pile3) super.clone();
        p.setVector((Vector) v.clone());
        return p;
    }
    
    private PileI foundClass(Object o) throws CloneNotSupportedException
    { 
       
        if(o instanceof Pile){return (PileI)((Pile)o).clone();}
        if(o instanceof Pile2){return (PileI)((Pile2)o).clone();}
        if(o instanceof Pile3){return (PileI)((Pile3)o).clone();}
        if(o instanceof Pile4){return (PileI)((Pile4)o).clone();} 
            
    return null;
    }
    
    private void setVector(Object o)
    {
        this.v= (Vector)o;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
