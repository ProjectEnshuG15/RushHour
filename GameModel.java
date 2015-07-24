import javax.swing.ImageIcon;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Point;
import javax.sound.sampled.*;

class GameModel{

  private ImageIcon undoButtonImage = null;
  private ImageIcon menuButtonImage = null;
  /*フィールド内容の変更*/
  private ArrayList<String[]> stageInformation = new ArrayList();
  private ArrayList<ImageIcon> speakerButtonImage = new ArrayList();
  /*新規のフィールド*/
  private ImageIcon playerImage = null;
  private ArrayList<ImageIcon> cpuImage = new ArrayList();
  private ArrayList<ArrayList<Point>> pointPiece = new ArrayList<ArrayList<Point>>();
  private DataLine.Info di = null;
  private AudioInputStream sound = null;

  public GameModel(){

    this.speakerButtonImage.add(new ImageIcon("./logo/speaker.png"));
    this.speakerButtonImage.add(new ImageIcon("./logo/speakerOFF.png"));
    this.undoButtonImage = new ImageIcon("./logo/UNDOButton.png");
    this.menuButtonImage = new ImageIcon("./logo/menuButton.png");
    this.playerImage = new ImageIcon("./logo/menuButton.png");
    this.cpuImage.add(new ImageIcon("./sozai/vehicle/car_pink.png"));
    this.cpuImage.add(new ImageIcon("./sozai/vehicle/car_skyblue.pngg"));
    this.cpuImage.add(new ImageIcon("./sozai/vehicle/car_yellow.png"));
    this.cpuImage.add(new ImageIcon("./sozai/vehicle/car_yellowgreen.png"));
    this.cpuImage.add(new ImageIcon("./sozai/vehicle/syoubousya_pump.png"));

    try {
          FileReader fr = new FileReader("./data/stage.csv");
          BufferedReader br = new BufferedReader(fr);
          String line="";
          while ((line = br.readLine()) != null) {
              String[] splitLine = line.split(",");
              this.stageInformation.add(splitLine);
          }
        }catch (IOException ex) {
            ex.printStackTrace();
      }

  }


  public ImageIcon getSpeakerButtonImage(int index){
    return this.speakerButtonImage.get(index);
  }

  public ImageIcon getUndoButtonImage(){
    return this.undoButtonImage;
  }

  public ImageIcon getMenuButtonImage(){
    return this.menuButtonImage;
  }

  public ArrayList getStageInformation(){
      return this.stageInformation;
  }

  /*１手前の場面情報を取得するメソッド*/
  public ArrayList<Point> getScene(){
    try{
      ArrayList<Point> scene = pointPiece.get(pointPiece.size()-1);
      pointPiece.remove(pointPiece.size()-1);
      return scene;
    }catch(java.lang.ArrayIndexOutOfBoundsException e){
      return null;
    }
  }

  /*場面情報を新たに追加するメソッド*/
  public void setScene(ArrayList<Draggable> allPiece){
    ArrayList<Point> scene = new ArrayList<Point>();
    for(Draggable d:allPiece) scene.add(d.getMasuLocation());
    pointPiece.add(scene);
  }

  /*新規のメソッド*/
  public ImageIcon getPlayerImage(){
    return this.playerImage;
  }
  public ImageIcon getCpuImage(int index){
    return this.cpuImage.get(index);
  }


  public boolean checkGoalZone(Draggable label){
    Point masuPoint = label.getMasuLocation();
    Point imageSize = label.getImageSize();
    Point goalPoint = label.getGoalPoint();
    if(goalPoint!=null){
      if( (masuPoint.x + imageSize.x)==goalPoint.x && (masuPoint.y+imageSize.y)==goalPoint.y) return true;
    }
    return false;
  }

  /**
    マウスの移動方向と対象のラベル情報を引数として移動先の情報の座標返す
    移動方向をが重複、壁となっている場合はnullを返す
  */
  public Point movePiece(int x,int y,Draggable label,ArrayList<Draggable> allPiece){
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

    p = pillUpPiece(label,p.x,p.y,allPiece);//ここで重複判定を行う
    return p;
  }

  /* 重複判定のためのメソッド */
  private Point pillUpPiece(Draggable my,int x,int y,ArrayList<Draggable> allPiece){
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

  /*マス用のパラメータをJPanel用の座標パラメータに変換する*/
  public static int changeMasuPoint(int v){
    if(v>6 || v<1) return 0;
    return 400/6 * v;
  }

  public void startSE(){
    try{
      AudioInputStream sound=AudioSystem.getAudioInputStream(getClass().getResource("./sozai/sampleSE.wav") );
      DataLine.Info di=new DataLine.Info(Clip.class,sound.getFormat());
      Clip clip = (Clip)AudioSystem.getLine(di);
      clip.open(sound);
      clip.start();
      
    }catch (Exception e) {
      e.printStackTrace();
    }
  }

}
