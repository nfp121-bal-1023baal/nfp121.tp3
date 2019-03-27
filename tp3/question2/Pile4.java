package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4  implements PileI, Cloneable {
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
        
        public void setSuivant(Maillon m){
            suivant=m;
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
        if (estPleine())
            throw new PilePleineException();
        // à compléter
        stk=new Maillon(o,stk);
        this.nombre++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        // à compléter
        Maillon m = this.stk;
        this.stk = this.stk.suivant;
        nombre--;
        return m.element;
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return stk.element; // à compléter
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return stk == null; // à compléter
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return this.taille()>=capacite; // à compléter
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
        Maillon m = stk;
        while(m != null)
        {
            s = s +m.element();
            m = m.suivant();
            if(m != null) s+=", ";
        }
        return s + "]";
    }

    public boolean equals(Object o) {
       
        if (o instanceof Pile4) {
            PileI p = (PileI) o;
            if(taille()!=p.taille() || capacite()!=p.capacite())
                return false;
            try{
                if(taille()==0)
                    return true;
                PileI p1 = (PileI)this.clone();
                PileI pi = foundClass(p);
                for(int i=0;i<p.taille();i++){
                    
                    Object ob = p1.depiler();Object ob2 = pi.depiler();
                   if(!ob.equals(ob2)) return false; 
                    
                }
                
            }
            catch(CloneNotSupportedException e){
                e.printStackTrace();
            }
            catch(PileVideException e){
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
    
    public Object clone() throws CloneNotSupportedException
    {
        Pile4 p = (Pile4) super.clone();
        if(!p.estVide())
            p.setSTK(stk);
        return p;
    }
    
    private PileI foundClass(Object o) throws CloneNotSupportedException
    { 
       
        if(o instanceof Pile){return (PileI)((Pile)o).clone();}
        if(o instanceof Pile2){return (PileI)((Pile2)o).clone();}
        if( o instanceof Pile3){return (PileI)((Pile3)o).clone();}
        if(o instanceof Pile4){return (PileI)((Pile4)o).clone();}
        return null;   
          
    }
    private void setSTK(Object o)
    {
         Maillon returned = new Maillon(((Maillon)o).element(),null);
        
        Maillon index=returned;
        this.stk=returned;
        
        Maillon main = ((Maillon)o).suivant();
        
        while(main!=null)
        {
            
            index.setSuivant(new Maillon(main.element(),null));
            System.out.println(index.suivant());
            main=main.suivant();
            index=index.suivant();
            System.out.println(index.suivant());
            
            
        }
      
        
        
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