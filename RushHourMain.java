import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RushHourMain{
  public static void main(String[] args) {
    RushHourFrame rushframe = new RushHourFrame("RushHour",100, 100, 400, 300);
    new RushHourController(rushframe);
  }

  static class RushHourFrame extends JFrame{
    RushHourFrame(String title, int xorig, int yorig, int w, int h){
      setTitle(title);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JPanel p = new JPanel();
      p.setSize(w, h);
      p.setLayout(null);
      getContentPane().add(p);
      setVisible(true);
      Insets insets = getInsets();
      setBounds(xorig, yorig,
      w + insets.left + insets.right, h + insets.top + insets.bottom);
      setResizable(false);
    }
  }
}
