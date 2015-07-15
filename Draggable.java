import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class  Draggable extends JLabel {
    int w = 400;
    int h = 400;

    Draggable(ImageIcon icon,int muki,int size) {
        super(icon);
        int sizeX=0,sizeY=0;
        if(muki==0){
          sizeX = changeMasuPoint(1);
          sizeY = changeMasuPoint(size);
        }else{
          sizeY = changeMasuPoint(1);
          sizeX = changeMasuPoint(size);
        }
        Image new_img = icon.getImage().getScaledInstance(sizeX,sizeY,Image.SCALE_DEFAULT);
        super.setIcon(new ImageIcon(new_img,""));

        // イベントリスナを設定
        MyMouseListener listener = new MyMouseListener(this);
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }


    public void setMasuLocation(int x,int y){
      System.out.println(x + "<>" + y);
      setLocation(changeMasuPoint(x),changeMasuPoint(y));
    }

    /*マス用のパラメータをJPanel用の座標パラメータに変換する*/
    public int changeMasuPoint(int v){
      if(v>6) return 0;
      return 400/6 * v;
    }

    private class MyMouseListener extends MouseAdapter {
        private int dx, dy;
        Draggable label;

        MyMouseListener(Draggable lab) {
            super();
            label = lab;
        }

        public void mouseDragged(MouseEvent e) {
            // マウスの座標からラベルの左上の座標を取得する
            System.out.println("Dragged");
            int x = e.getXOnScreen() - dx;
            int y = e.getYOnScreen() - dy;

            System.out.println(x +":"+ y);
            Point p = new Point(x,y);
            label.setLocation(p);
        }

        public void mousePressed(MouseEvent e) {
            // 押さえたところからラベルの左上の差を取っておく
            dx = e.getXOnScreen() - label.getX();
            dy = e.getYOnScreen() - label.getY();
        }
    }
}
