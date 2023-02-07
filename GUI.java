/**********************Q2-Devoir2 ITI1521....*/
package d2q2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * @author Mohamed Ismail Asaklil 0300243534
 */
class GUI extends JFrame implements ActionListener {
  Calculator cal;
  JTextField input;
  JButton Add, mult, sub, div, POW, sqrt, equal, factorial, ln, Clear; // les operations
  JButton[] opérations = new JButton[10];// les opérations de la calculatrice
  JButton[] chiffres = new JButton[10]; // les chiffres de la calculatrice
  int CompteurOpération = 0;

  GUI(Calculator p) {
    // VOTRE CODE VIENT ICI
    // ici pas besoin de creer un object de chez Jframe car on hérite deja de cette
    // derniere donc on a deja acces a touts ces methodes
    super("Calculator"); // appeler le constructor de Jframe=Superclass
    cal = p;
    // Premierement on va crée l'interface générale et basique contenant le titre,
    // les bouttons(Close,Restore Down,Minimize)
    // titre de la fenetre
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // pour le boutton Close en rouge
    setSize(600, 650); // dimension de la fenetre
    setLayout(null);
    setResizable(false);// pour afficher la fenetre et le title

    // La police de l'ecran
    Font myFont = new Font("Ink Free", Font.PLAIN, 30);// choisi selon ma preference

    // l'ecran de la calculatrice
    input = new JTextField(25);
    input.setBounds(50, 25, 400, 60);
    input.setBackground(Color.LIGHT_GRAY);
    input.setFont(myFont);
    input.setEditable(false);
    input.setText("0");

    // les bouttons de la calculatrice
    // déclarer tous les objects a la fois

    Add = new JButton("+");
    mult = new JButton("*");
    sub = new JButton("-");
    div = new JButton("/");
    POW = new JButton("POW");
    sqrt = new JButton("sqrt");
    equal = new JButton("=");
    factorial = new JButton("!");
    ln = new JButton("ln");
    Clear = new JButton("C");
    setResizable(false);

    // Les bouttons des opérations mathématiques
    opérations[0] = Add;
    opérations[1] = mult;
    opérations[2] = sub;
    opérations[3] = div;
    opérations[4] = POW;
    opérations[5] = sqrt;
    opérations[6] = equal;
    opérations[7] = factorial;
    opérations[8] = ln;
    opérations[9] = Clear;

    for (int i = 0; i < 10; i++) {
      opérations[i].addActionListener(this);
      opérations[i].setFont(myFont);
      opérations[i].setFocusable(false);
      opérations[i].setBorder(BorderFactory.createRaisedBevelBorder());
    }
    // Les boutons des chiffres
    for (int i = 0; i < 10; i++) {
      chiffres[i] = new JButton(String.valueOf(i));
      chiffres[i].addActionListener(this);
      chiffres[i].setFont(myFont);
      chiffres[i].setFocusable(false);

    }

    // l'affichage des bouttons dans la calculatrice
    JPanel panel = new JPanel();
    // l'emplacememnt des bouttons dans la calculatrice
    panel.setBounds(50, 100, 400, 400);
    panel.setLayout(new GridLayout(4, 5, 5, 5));
    panel.setBackground(Color.LIGHT_GRAY);
    panel.add(chiffres[7]);
    panel.add(chiffres[8]);
    panel.add(chiffres[9]);
    panel.add(factorial);
    panel.add(ln);
    panel.add(chiffres[4]);
    panel.add(chiffres[5]);
    panel.add(chiffres[6]);
    panel.add(mult);
    panel.add(div);
    panel.add(chiffres[1]);
    panel.add(chiffres[2]);
    panel.add(chiffres[3]);
    panel.add(Add);
    panel.add(sub);
    panel.add(chiffres[0]);
    panel.add(POW);
    panel.add(sqrt);
    panel.add(equal);
    panel.add(Clear);

    // vu qu'on herite de la classe JFrame pas besoin de creer un object on doit
    // seulement appeler la methode de la SuperClass
    add(panel);
    add(input);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    // VOTRE CODE VIENT ICI

    if (input.getText().equals("0") && e.getActionCommand().equals("+") == false
        && e.getActionCommand().equals("-") == false && e.getActionCommand().equals("*") == false
        && e.getActionCommand().equals("/") == false && e.getActionCommand().equals("POW") == false
        && e.getActionCommand().equals("!") == false && e.getActionCommand().equals("sqrt") == false
        && e.getActionCommand().equals("ln") == false && e.getActionCommand().equals("=") == false) {
      input.setText(e.getActionCommand());
    }

    else {
      for (int i = 0; i < 10; i++) {
        if (e.getActionCommand().equals(String.valueOf(i)) && input.getText().equals("NaN") == false) {
          input.setText(input.getText().concat(String.valueOf(i)));
          equal.setEnabled(true);
        }
      }
    }
    // -----------------------------------------------------------------------------------------------------------
    if (e.getActionCommand().equals("+")) {
      cal.setSecond(Double.parseDouble(input.getText()));// le input que fait entrer l'utilisateur en entrant une valeur
                                                         // de la calculatrice
      cal.add();
      input.setText("");
      CompteurOpération++;
      // POUR BLOQUER L'ACCES AUX AUTRES BOUTTONS
      factorial.setEnabled(false);
      ln.setEnabled(false);
      sqrt.setEnabled(false);
      POW.setEnabled(false);
      equal.setEnabled(false);
      div.setEnabled(false);
      mult.setEnabled(false);
      Add.setEnabled(false);
    }
    // -----------------------------------------------------------------------------------------------------------
    if (e.getActionCommand().equals("-")) {
      if (input.getText().equals("")) {
        input.setText("-");
        sub.setEnabled(false);
      } else {
        cal.setSecond(Double.parseDouble(input.getText()));// le input que fait entrer l'utilisateur en entrant une
                                                           // valeur de la calculatrice
        cal.subtract();
        input.setText("");
        CompteurOpération++;
        POW.setEnabled(false);
        sqrt.setEnabled(false);
        factorial.setEnabled(false);
        ln.setEnabled(false);
        equal.setEnabled(false);
        div.setEnabled(false);
        mult.setEnabled(false);
        sub.setEnabled(false);
        Add.setEnabled(false);
      }
    }
    // -----------------------------------------------------------------------------------------------------------
    if (e.getActionCommand().equals("*")) {
      cal.setSecond(Double.parseDouble(input.getText()));// le input que fait entrer l'utilisateur en entrant une valeur
                                                         // de la calculatrice
      cal.multiply();
      input.setText("");
      CompteurOpération++;
      factorial.setEnabled(false);
      ln.setEnabled(false);
      sqrt.setEnabled(false);
      POW.setEnabled(false);
      equal.setEnabled(false);
      div.setEnabled(false);
      mult.setEnabled(false);
      Add.setEnabled(false);
    }
    // -----------------------------------------------------------------------------------------------------------
    if (e.getActionCommand().equals("/")) {
      cal.setSecond(Double.parseDouble(input.getText()));// le input que fait entrer l'utilisateur en entrant une valeur
                                                         // de la calculatrice
      cal.divide();
      input.setText("");
      CompteurOpération++;
      factorial.setEnabled(false);
      ln.setEnabled(false);
      sqrt.setEnabled(false);
      POW.setEnabled(false);
      equal.setEnabled(false);
      div.setEnabled(false);
      mult.setEnabled(false);
      Add.setEnabled(false);
    }
    // -----------------------------------------------------------------------------------------------------------
    if (e.getActionCommand().equals("POW")) {
      cal.setSecond(Double.parseDouble(input.getText())); // le input que fait entrer l'utilisateur en entrant une
                                                          // valeur de la calculatrice
      cal.pow();
      input.setText("");
      factorial.setEnabled(false);
      ln.setEnabled(false);
      sqrt.setEnabled(false);
      POW.setEnabled(false);
      equal.setEnabled(false);
      div.setEnabled(false);
      mult.setEnabled(false);
      sub.setEnabled(false);
      Add.setEnabled(false);
      CompteurOpération++;
    }
    // -----------------------------------------------------------------------------------
    if (e.getActionCommand().equals("ln")) {
      if (Double.parseDouble(input.getText()) <= 0) {
        input.setText("Domaine invalide");
        factorial.setEnabled(false);
        ln.setEnabled(false);
        sqrt.setEnabled(false);
        POW.setEnabled(false);
        equal.setEnabled(false);
        div.setEnabled(false);
        mult.setEnabled(false);
        sub.setEnabled(false);
        Add.setEnabled(false);
        for (int i = 0; i < 10; i++) {
          chiffres[i].setEnabled(false);
        }
      } else {
        factorial.setEnabled(false);
        ln.setEnabled(false);
        sqrt.setEnabled(false);
        POW.setEnabled(false);
        div.setEnabled(false);
        mult.setEnabled(false);
        sub.setEnabled(false);
        Add.setEnabled(false);
        for (int i = 0; i < 10; i++) {
          chiffres[i].setEnabled(false);
        }
        cal.setSecond(Double.parseDouble(input.getText()));
        cal.nepLog();
        input.setText("ln(" + input.getText() + ")");
        CompteurOpération++;
      }
    }
    // -----------------------------------------------------------------------------------------------------------
    if (e.getActionCommand().equals("C")) {
      input.setText("0");
      cal.clear();
      CompteurOpération = 0;
      factorial.setEnabled(true);
      ln.setEnabled(true);
      sqrt.setEnabled(true);
      POW.setEnabled(true);
      equal.setEnabled(true);
      div.setEnabled(true);
      mult.setEnabled(true);
      sub.setEnabled(true);
      Add.setEnabled(true);
      for (int i = 0; i < 10; i++) {
        chiffres[i].setEnabled(true);
      }
    }

    // -----------------------------------------------------------------------------------------------------------
    if (e.getActionCommand().equals("sqrt")) {
      if (Double.parseDouble(input.getText()) < 0) { // si la valeur entrer dans la calcultrice est negative strict
        // hors du domaine de la racine
        input.setText("Domaine invalide");
        // Blocker l'acces de tous les bouttons
        factorial.setEnabled(false);
        ln.setEnabled(false);
        sqrt.setEnabled(false);
        POW.setEnabled(false);
        equal.setEnabled(false);
        div.setEnabled(false);
        mult.setEnabled(false);
        sub.setEnabled(false);
        Add.setEnabled(false);
        for (int i = 0; i < 10; i++) {
          chiffres[i].setEnabled(false);
        }
      } else {
        for (int i = 0; i < 10; i++) {
          chiffres[i].setEnabled(false);
        }
        factorial.setEnabled(false);
        ln.setEnabled(false);
        sqrt.setEnabled(false);
        POW.setEnabled(false);
        div.setEnabled(false);
        mult.setEnabled(false);
        sub.setEnabled(false);
        Add.setEnabled(false);
        cal.setSecond(Double.parseDouble(input.getText()));
        cal.rootSquare();
        input.setText("sqrt(" + input.getText() + ")");
        CompteurOpération++;
      }
    }

    // -----------------------------------------------------------------------------------------------------------
    if (e.getActionCommand().equals("=")) {
      if (CompteurOpération == 0) {
        input.setText(input.getText());
        CompteurOpération = 0;
      } else if (cal.getoP().equals("!")) {
        cal.compute();
        input.setText(Double.toString(cal.display()));
        CompteurOpération = 0;
      } else if (cal.getoP().equals("sqrt")) {
        cal.compute();
        input.setText(Double.toString(cal.display()));
        CompteurOpération = 0;
      } else if (cal.getoP().equals("ln")) {
        cal.compute();
        input.setText(Double.toString(cal.display()));
        CompteurOpération = 0;
      } else {
        cal.setSecond(Double.parseDouble(input.getText()));
        cal.compute();
        input.setText(Double.toString(cal.display()));
        CompteurOpération = 0;
      }
      if (Double.parseDouble(input.getText()) == Double.POSITIVE_INFINITY
          || Double.parseDouble(input.getText()) == Double.NEGATIVE_INFINITY) {
        CompteurOpération = 0;
        factorial.setEnabled(false);
        ln.setEnabled(false);
        sqrt.setEnabled(false);
        POW.setEnabled(false);
        div.setEnabled(false);
        mult.setEnabled(false);
        sub.setEnabled(false);
        Add.setEnabled(false);

        for (int i = 0; i < 10; i++) {
          chiffres[i].setEnabled(false);
        }
      }

      else {
        factorial.setEnabled(true);
        ln.setEnabled(true);
        sqrt.setEnabled(true);
        POW.setEnabled(true);
        div.setEnabled(true);
        mult.setEnabled(true);
        sub.setEnabled(true);
        Add.setEnabled(true);

        for (int i = 0; i < 10; i++) {
          chiffres[i].setEnabled(true);
        }
      }
    }
    // ----------------------------------------------------------------------------------------------------------
    if (e.getActionCommand().equals("!")) {

      factorial.setEnabled(false);
      ln.setEnabled(false);
      sqrt.setEnabled(false);
      POW.setEnabled(false);
      div.setEnabled(false);
      mult.setEnabled(false);
      sub.setEnabled(false);
      Add.setEnabled(false);

      for (int i = 0; i < 10; i++) {
        chiffres[i].setEnabled(false);
      }
      cal.setSecond(Double.parseDouble(input.getText()));
      cal.factorial(); // in order to do the factorial operation
      input.setText(input.getText() + "!");
      CompteurOpération++;
    }
  }

  public static void main(String arg[]) {
    GUI gui;
    gui = new GUI(new Calculator());
    gui.setVisible(true);
  }
}