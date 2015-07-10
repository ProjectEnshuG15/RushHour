
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;

class RushHourController{

  public RushHourController(RushHourFrame rushflame){
    JLabel label1 = new JLabel("今日の天気：");
    JPanel p = new JPanel();
    p.add(label1);
    rushflame.getContentPane().add(p,BorderLayout.CENTER);
    rushflame.setVisible(true);
    this.run();
  }

  private void run(){

  }

}
