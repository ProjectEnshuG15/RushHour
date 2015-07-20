
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class GameView extends View implements ActionListener{
  /*  新規フィールド*/
  private RushHourFrame rushframe = null;
  private GameModel model = null;
  private ArrayList<Draggable> labelPiece = new ArrayList<Draggable>();
  private Point goalPoint = null;
    private RushHourController controller = null;

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

    public GameView(RushHourFrame f,GameModel m, RushHourController c){
      this.rushframe = f;
      this.model = m;
      this.controller = c;
      ArrayList<String[]> list = m.getStageInformation();
      this.goalPoint = new Point( Integer.parseInt(list.get(1)[0]),Integer.parseInt(list.get(1)[1]) );//ゴールの座標の設定
      //this.playerLabel = new Draggable(model.getPlayerImage(),0,3,4-1,1-1);
      /*駒のラベル用インスタンスを生成しArrayListに格納する*/
      for(int i=2;i<list.size();i++){
        this.labelPiece.add(new Draggable(this,model.getPlayerImage(),
                                        Integer.parseInt(list.get(i)[0]),
                                        Integer.parseInt(list.get(i)[1]),
                                        Integer.parseInt(list.get(i)[2])-1,
                                        Integer.parseInt(list.get(i)[3])-1
                                        )
                          );
      }
      this.labelPiece.get(0).setGoalPoint(goalPoint);//対象の駒のみゴールの座標を設定する
      this.name = "サンプル";
  }

  public void soudChage(){

  }

  /**
    全てのラベルをもつlabelPieceを引数に加えコントローラのmovePieceを実行する
  */
  public void moveObstacle(int x,int y,Draggable lab){
    controller.movePiece(x,y,lab,labelPiece);
  }

  public void clickUndo(){

  }

  public void clickMenuButton(){

  }

  @Override
  public void paint(){
    System.out.println("DEBUG:gameView paint");
    JPanel p = new JPanel();
    p.setLayout(null);
    /*ボタンの設定*/
    JButton undoButton = new ResizeJButton(model.getUndoButtonImage(),20,610,120,60);
    undoButton.setActionCommand("undo");
    JButton menuButton = new ResizeJButton(model.getMenuButtonImage(),370,610,120,60);
    menuButton.setActionCommand("menu");
    JButton speakerButton = new ResizeJButton(model.getSpeakerButtonImage(0),10,50,60,60);
    speakerButton.setBorderPainted(false);
    speakerButton.setActionCommand("speaker");
    /*ラベルの設定*/

    JLabel name_label = new JLabel(this.name + "さん");
    name_label.setBounds(350,20,150,40);
    name_label.setFont(new Font("Century", Font.ITALIC, 20));
    JLabel socore_label = new JLabel("Score:");
    socore_label.setBounds(330,50,100,50);
    socore_label.setFont(new Font("Century", Font.ITALIC, 24));
    /*ステージ用のJPanelの作成*/
    JPanel stage = new GridJPanel();
    stage.setLayout(null);
    stage.setPreferredSize(new Dimension(400,400));
    stage.setBackground(Color.WHITE);
    stage.setBounds(50,150,400,400);
    //JugePiece jugePieceInstance = new JugePiece(labelPiece);
    for(Draggable d:labelPiece){
        MyMouseListener listener = new MyMouseListener(d);
        d.addMouseListener(listener);
        d.addMouseMotionListener(listener);
        stage.add(d);
    }

    /*ボタンへのイベントリスナーの追加*/
    undoButton.addActionListener(this);
    menuButton.addActionListener(this);

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


  @Override
  public void actionPerformed(ActionEvent ae) {
    String action = ae.getActionCommand();
    if(action.equals("undo")){
      this.clickUndo();
    }else if(action.equals("menu")){
      clickMenuButton();
    }else if(action.equals("speaker")){
      soudChage();
    }else{
      System.out.println("out");
    }
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
