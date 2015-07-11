import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RushHourMain{
  public static void main(String[] args) {
    RushHourFrame rushframe = new RushHourFrame("RushHour",100, 100,700,600);
    new RushHourController(rushframe);

  }
}

class RushHourFrame extends JFrame{
  RushHourFrame(String title, int xorig, int yorig, int w, int h){
    setTitle(title);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(xorig, yorig,w,h);
  }
}
