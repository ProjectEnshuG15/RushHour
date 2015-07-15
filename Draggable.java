import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class  Draggable extends JLabel {
    int w = 400;
    int h = 400;
    private int direction = -1;
    private Point point = null;
    private Point imageSize = null;
    private MyMouseListener listener = null;

    Draggable(ImageIcon icon,int muki,int size,int x,int y) {
        super(icon);
        int sizeX=0,sizeY=0;
        this.direction = muki;

        if(muki==0){
          sizeX = changeMasuPoint(1);
          sizeY = changeMasuPoint(size);
        }else{
          sizeY = changeMasuPoint(1);
          sizeX = changeMasuPoint(size);
        }

        imageSize = new Point(sizeX,sizeY);
        Image new_img = icon.getImage().getScaledInstance(sizeX,sizeY,Image.SCALE_DEFAULT);
        super.setIcon(new ImageIcon(new_img,""));
        super.setBounds(changeMasuPoint(x),changeMasuPoint(y),imageSize.x,imageSize.y);
        point = new Point(changeMasuPoint(x),changeMasuPoint(y));

        // イベントリスナを設定
        listener = new MyMouseListener(this);
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }

    public getMyMouseListener(){
      return listener;
    }



    /*マス用のパラメータをJPanel用の座標パラメータに変換する*/
    public int changeMasuPoint(int v){
      if(v>6 || v<1) return 0;
      return 400/6 * v;
    }

    private class MyMouseListener extends MouseAdapter {
        private int dx, dy;
        Draggable label;
        Point p = null;

        MyMouseListener(Draggable lab) {
            super();
            label = lab;
            this.p = label.point;
        }

        public void mouseDragged(MouseEvent e) {
            // マウスの座標からラベルの左上の座標を取得する

            int x = e.getXOnScreen() - dx;
            int y = e.getYOnScreen() - dy;

            if(x>400-label.imageSize.x || y>400-label.imageSize.y || x<0 || y<0) return;

            if(label.direction==0){
              System.out.println(x +":"+ y);
              p = new Point(p.x,y);
              label.setLocation(p);
            }else{
              System.out.println(x +":"+ y);
              p = new Point(x,p.y);
              label.setLocation(p);
            }
        }

        public void mousePressed(MouseEvent e) {
            // 押さえたところからラベルの左上の差を取っておく
            dx = e.getXOnScreen() - label.getX();
            dy = e.getYOnScreen() - label.getY();
        }
    }
}

class JugePiece{

  ArrayList<Draggable> allPiece = new ArrayList<Draggable>();

  public boolean pillUpPiece(Draggable my){
    for(Draggable d:allPiece){
      if(my!=d){
        //座標の取得
        Point otherPoint = d.getMyMouseListener().p;
        Point myPoint = my.getMyMouseListener().p;

        /*重なり判定乃処理*/
        if(my.direction == 0){
          //X方向の重なりの確認
          if( (myPoint.x+my.imageSize.x)>otherPoint.x || (otherPoint+d.imageSize.x)<myPoint.x ){
            return false;
          }
        }else{
          if( (myPoint.y+my.imageSize.x)>otherPoint.x || (otherPoint+d.imageSize.x)<myPoint.x ){
            return false;
          }
        }



      }
    }
  }
}
