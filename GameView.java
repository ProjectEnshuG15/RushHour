
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GameView extends View{
  /*  新規フィールド２つ　*/
  private RushHourFrame rushframe = null;
  private GameModel model = null;

  /* 旧フィールド */
  private int heightMasuNum = 50;
  private int weightMasuNum = 50;
  private Point cpuPoint[] = null;
  private Point playerPoint = null;
  private int moveCount = 0;
  private Point soundButtonPoint = null;
  private String name = null;
  private int score = 0;
  private Point undoPoint = null;
  private Point menuPoint = null;

  public GameView(RushHourFrame f,GameModel m){
    this.rushframe = f;
    this.model = m;
    JPanel p = new JPanel();
    JLabel label1 = new JLabel(this.model.getUndoButtonImage());
    p.add(label1);
    rushframe.getContentPane().add(p);
    this.rushframe.setVisible(true);
  }

  public void soudChage(){

  }

  public void moveObstacle(){

  }

  public void clickUndo(){

  }

  public void clickMenuButton(){

  }

  @Override
  public void paint(){

  }
}
