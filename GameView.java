
import java.awt.*;
import java.awt.geom.Line2D;
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
    this.name = "サンプル";
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
    JPanel p = new JPanel();
    p.setLayout(null);

    JButton undoButton = new ResizeJButton(model.getUndoButtonImage(),20,610,120,60);
    JButton menuButton = new ResizeJButton(model.getMenuButtonImage(),370,610,120,60);
    JButton speakerButton = new ResizeJButton(model.getSpeakerButtonImage(),10,50,60,60);
    speakerButton.setBorderPainted(false);
    JLabel name_label = new JLabel(this.name + "さん");
    name_label.setBounds(350,20,150,40);
    name_label.setFont(new Font("Century", Font.ITALIC, 20));
    JLabel socore_label = new JLabel("Score:");
    socore_label.setBounds(330,50,100,50);
    socore_label.setFont(new Font("Century", Font.ITALIC, 24));
    /*ステージ用のJPanelの作成*/
    JPanel stage = new GridJPanel();
    stage.setPreferredSize(new Dimension(400,400));
    stage.setBackground(Color.WHITE);
    stage.setBounds(50,150,400,400);
    /*メインのパネルにコンポーネントを追加*/
    p.add(undoButton);
    p.add(menuButton);
    p.add(speakerButton);
    p.add(name_label);
    p.add(socore_label);
    p.add(stage);
    rushframe.getContentPane().add(p);//FrameにPanelを追加
    this.rushframe.setVisible(true);//描画処理
  }

  /* グリッド線描画のための新規クラス */
  private class GridJPanel extends JPanel{

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

  			//	大きさ取得
  			Dimension wh = this.getSize();
        System.out.println(wh.width + ":" + wh.height);

  			//グリッド線を惹く
        for(int i=1;i<6;i++){
          g.drawLine(wh.width/6*i,0,wh.width/6*i,wh.height);
          g.drawLine(0,wh.height/6*i,wh.width,wh.height/6*i);
        }

    }
  }
}

/**
  新たに作成したクラス
  デフォルトのJButtonでは画像ボタンのリサイズができないため
  処理の簡略かのため作成
*/
class ResizeJButton extends JButton{

  public ResizeJButton(ImageIcon icon,int x,int y,int w,int h){
    Image new_img = icon.getImage().getScaledInstance(w,h,Image.SCALE_DEFAULT);
    super.setIcon(new ImageIcon(new_img,""));
    setBounds(x,y,w,h);
  }
}
