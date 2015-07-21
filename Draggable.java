import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class  Draggable extends JLabel {
    int w = 400;
    int h = 400;
    private int direction = -1;
    private Point masuPoint = null;
    private Point point = null;
    private Point imageSize = null;
    private Point goalPoint = null;
    private GameView gameView = null;

    Draggable(GameView g,ImageIcon icon,int muki,int size,int x,int y) {
        super(icon);
        this.gameView = g;
        this.direction = muki;

        int sizeX=0,sizeY=0;
        if(muki==0){
          sizeX = 1;
          sizeY = size;
        }else{
          sizeY = 1;
          sizeX = size;
        }

        imageSize = new Point(sizeX,sizeY);
        setMasuLocation(x,y);

        int changeX = GameModel.changeMasuPoint(x);
        int changeY = GameModel.changeMasuPoint(y);
        int changeSizeX = GameModel.changeMasuPoint(imageSize.x);
        int changeSizeY = GameModel.changeMasuPoint(imageSize.y);

        Image new_img = icon.getImage().getScaledInstance(changeSizeX , changeSizeY , Image.SCALE_DEFAULT);
        super.setIcon(new ImageIcon(new_img,""));
        super.setBounds(changeX , changeY , changeSizeX , changeSizeY );
        point = new Point(changeX , changeY);
    }

    /*この駒が目的とする座標をセットする*/
    public void setGoalPoint(Point p){
      this.goalPoint = p;
    }

    public Point getGoalPoint(){
      return this.goalPoint;
    }

    /*この駒が方向パラメータを返す*/
    public int getDirection(){
      return this.direction;
    }

    /*この駒のx,yの大きさをPointとして返す*/
    public Point getImageSize(){
      return this.imageSize;
    }

    /*ラベルのインスタンスからViewのメソッドを実行する*/
    public void moveObstacle(int x,int y){
      gameView.moveObstacle(x,y,this);
    }

    /*ます単位での座標を引数として変換した上でこのラベルの座標を置き換える*/
    public void setMasuLocation(int x,int y){
      int changeX = GameModel.changeMasuPoint(x);
      int changeY = GameModel.changeMasuPoint(y);
      int changeSizeX = GameModel.changeMasuPoint(imageSize.x);
      int changeSizeY = GameModel.changeMasuPoint(imageSize.y);

      //移動が増す範囲を超えるようであればreturnし、移動させない
      if(x<0 || (x+imageSize.x)>6 || y<0 || (x + imageSize.y)>6) return;
      this.masuPoint = new Point(x,y);//ます座標の更新
      this.setLocation(new Point(changeX,changeY));//駒の移動処理
    }

    /*このラベルの6*6におけるマスの現在の座標を返す*/
    public Point getMasuLocation(){
      return this.masuPoint;
    }

}

class MyMouseListener extends MouseAdapter {
    private int dx, dy;
    Draggable label;
    boolean moveFlag = true;

    MyMouseListener(Draggable lab) {
        super();
        label = lab;
    }

    public void mouseDragged(MouseEvent e) {
        if(!moveFlag) return;
        moveFlag = false;

        // マウスの座標からラベルの左上の座標を取得する
        int x = e.getXOnScreen() - dx;
        int y = e.getYOnScreen() - dy;

        label.moveObstacle(x,y);//駒を移動させる
    }

    public void mousePressed(MouseEvent e) {
        // 押さえたところからラベルの左上の差を取っておく
        dx = e.getXOnScreen() - label.getX();
        dy = e.getYOnScreen() - label.getY();
    }

    public void mouseReleased(MouseEvent e){
      moveFlag = true;
    }

}
