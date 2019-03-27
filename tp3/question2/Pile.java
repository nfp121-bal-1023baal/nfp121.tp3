package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile  implements PileI,Cloneable {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        // traiter le cas <=0
        // a completer
        if (taille < 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        // a completer
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr++] = o;
        
    }

    public Object depiler() throws PileVideException {
        // a completer
        if(estVide())
            throw new PileVideException();
        
        return this.zone[--ptr];
    }

    public Object sommet() throws PileVideException {
        // a completer
        if(estVide())
            throw new PileVideException();
            
        return this.zone[ptr-1];
    }

    public int capacite() {
        // a completer
        return this.zone.length;
    }

    public int taille() {
        // a completer
        if(estVide()){ptr=0;}
            
        return this.ptr;
    }

    public boolean estVide() {
        // a completer
        return this.ptr==0;
    }

    public boolean estPleine() {
        // a completer
        return this.ptr == this.zone.length;
    }

    public boolean equals(Object o) {
        // a completer
       try{
        if( this == o){return true;}
        if(!(o instanceof PileI)){return false;}
        PileI pi = foundClass(o);
        PileI p=(PileI) this.clone();
        if(pi.taille() == p.taille() 
            && pi.capacite() == p.capacite())
        {
            
            for(int i=0 ; i<p.taille(); i++)
            {
                Object ob = p.depiler();Object ob2 = pi.depiler();
                if(!ob.equals(ob2)) return false;             
            }
            return true;
        }
    }catch(Exception e){}
      return false; 

    }
    public Object clone() throws CloneNotSupportedException
    {
        Pile p = (Pile)super.clone();
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

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        // a completer
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i].toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

}