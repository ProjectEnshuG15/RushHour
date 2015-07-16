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

    Draggable(ImageIcon icon,int muki,int size,int x,int y) {
        super(icon);
        int sizeX=0,sizeY=0;
        this.direction = muki;

        if(muki==0){
          sizeX = 1;
          sizeY = size;
        }else{
          sizeY = 1;
          sizeX = size;
        }

        imageSize = new Point(sizeX,sizeY);
        setMasuLocation(x,y);
        Image new_img = icon.getImage().getScaledInstance(changeMasuPoint(imageSize.x),changeMasuPoint(imageSize.y),Image.SCALE_DEFAULT);
        super.setIcon(new ImageIcon(new_img,""));
        super.setBounds(changeMasuPoint(x),changeMasuPoint(y),changeMasuPoint(imageSize.x),changeMasuPoint(imageSize.y));
        point = new Point(changeMasuPoint(x),changeMasuPoint(y));
    }

    public void setGoalPoint(Point p){
      this.goalPoint = p;
    }

    public int getDirection(){
      return this.direction;
    }

    public Point getImageSize(){
      return this.imageSize;
    }

    public void setMasuLocation(int x,int y){
      if(changeMasuPoint(x)<0 || (changeMasuPoint(x)+changeMasuPoint(imageSize.x))>400 ||
          changeMasuPoint(y)<0 || (changeMasuPoint(y)+changeMasuPoint(imageSize.y))>400 ) return;
      masuPoint = new Point(x,y);
      if(goalPoint!=null){
        if( (masuPoint.x+this.getImageSize().x)==goalPoint.x && (masuPoint.y+this.getImageSize().y)==goalPoint.y) System.out.println("ゴールしました");
      }
      this.setLocation(new Point(changeMasuPoint(x),changeMasuPoint(y)));
    }

    /*このラベルの6*6におけるマスの現在の座標を返す*/
    public Point getMasuLocation(){
      return this.masuPoint;
    }

    /*マス用のパラメータをJPanel用の座標パラメータに変換する*/
    public int changeMasuPoint(int v){
      if(v>6 || v<1) return 0;
      return 400/6 * v;
    }

}

class MyMouseListener extends MouseAdapter {
    private int dx, dy;
    private ArrayList<Draggable> allPiece = null;
    Draggable label;
    boolean moveFlag = true;

    MyMouseListener(Draggable lab,ArrayList<Draggable> a) {
        super();
        label = lab;
        this.allPiece = a;
    }

    public void mouseDragged(MouseEvent e) {
        if(!moveFlag) return;
        moveFlag = false;

        // マウスの座標からラベルの左上の座標を取得する
        int x = e.getXOnScreen() - dx;
        int y = e.getYOnScreen() - dy;
        Point p = label.getMasuLocation();

        /*ラベルの向きを元に移動座標の変換を行う*/
        if(label.getDirection() == 1){
          if(x-label.getX()>0){
            p = new Point(p.x+1,p.y);
          }else{
            p = new Point(p.x-1,p.y);
          }
        }else{
          if(y-label.getY()>0){
            p = new Point(p.x,p.y+1);
          }else{
            p = new Point(p.x,p.y-1);
          }
        }
        p = this.pillUpPiece(label,p.x,p.y);
        if (p==null) return;
        label.setMasuLocation(p.x,p.y);

    }

    public void mousePressed(MouseEvent e) {
        // 押さえたところからラベルの左上の差を取っておく
        dx = e.getXOnScreen() - label.getX();
        dy = e.getYOnScreen() - label.getY();
    }


    /* 重複判定のためのメソッド */
    public Point pillUpPiece(Draggable my,int x,int y){
      for(Draggable d:allPiece){
        Point p = d.getMasuLocation();
        if(my!=d){
          if(y>=p.y && (p.y+d.getImageSize().y)>y){
            if( (x+my.getImageSize().x)>p.x && (x+my.getImageSize().x)<=(p.x+d.getImageSize().x) ) return null;
            else if(x>=p.x && x<(p.x+d.getImageSize().x) ) return null;
          }else if(x>=p.x && (p.x+d.getImageSize().x)>x){
            if( (y+my.getImageSize().y)>p.y && (y+my.getImageSize().y)<=(p.y+d.getImageSize().y) ) return null;
            else if(y>=p.y && y<(p.y+d.getImageSize().y) ) return null;
          }
        }
      }
      return new Point(x,y);
    }


    public void mouseReleased(MouseEvent e){
      moveFlag = true;
    }

}
