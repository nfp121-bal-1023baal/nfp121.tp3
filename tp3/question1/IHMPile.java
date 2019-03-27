package question1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class IHMPile extends JFrame implements ActionListener{
    private JTextField donnee = new JTextField(6);
    private JTextField sommet = new JTextField(6);
    private JLabel     contenu = new JLabel("[]");

    private Pile p;

    public IHMPile(){
        super("IHM Pile");
        JButton    boutonEmpiler = new JButton("empiler");
        JButton    boutonDepiler = new JButton("depiler");

        JPanel enHaut = new JPanel();
        enHaut.add(donnee);
        enHaut.add(boutonEmpiler);
        enHaut.add(boutonDepiler);
        // faire sommet non editable
        sommet.setEditable(false);
        
        enHaut.add(sommet);
        setLayout(new BorderLayout(5,5));
        add("North",enHaut);
        add("Center",contenu);
        enHaut.setBackground(Color.red);
        setLocation(100,100);
        pack();setVisible(true);
        boutonEmpiler.addActionListener(this);
        boutonDepiler.addActionListener(this);

        p = new Pile(5);

    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("empiler")){
            try{
            // à compléter
            String s=donnee.getText();
            p.empiler(s) ;
            donnee.setText("");
            contenu.setText( p.toString() );
            sommet.setText(s);
            // en cas d'exception
            //contenu.setText( /* à compléter */"" + " estPleine !");
        }
        catch(Exception e){ 
            contenu.setText(  p.toString() + "   estPleine ! "); }
        }else{
            try{
            // à compléter
            p.depiler();
            Object obj = p.depiler();
            if(obj instanceof String)
            {sommet.setText(obj.toString()); p.empiler(obj);
            contenu.setText( p.toString() );}
            // en cas d'exception
            //contenu.setText( /* à compléter */"" + " estVide !");
        }
        catch(Exception e){sommet.setText("");
            contenu.setText("[]    estVide !");}
        }
    }

    public static void main(String[] args){
        new IHMPile();
    }
}
