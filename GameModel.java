import javax.swing.ImageIcon;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

class GameModel{
<<<<<<< HEAD
  private ImageIcon speakerButtonImage = null;
=======
>>>>>>> ゲーム画面のボタンのEventListenner
  private ImageIcon undoButtonImage = null;
  private ImageIcon menuButtonImage = null;
  /*フィールド内容の変更*/
  private ArrayList<String[]> stageInformation = new ArrayList();
  private ArrayList<ImageIcon> speakerButtonImage = new ArrayList();
  /*新規のフィールド*/
  private ImageIcon playerImage = null;
  private ArrayList<ImageIcon> cpuImage = new ArrayList();

  public GameModel(){
<<<<<<< HEAD
    this.speakerButtonImage = new ImageIcon("./logo/speaker.png");
    //this.speakerButtonImage[1] = new ImageIcon("./logo/speaker.png");
=======
    this.speakerButtonImage.add(new ImageIcon("./logo/speaker.png"));
    this.speakerButtonImage.add(new ImageIcon("./logo/speakerOFF.png"));
>>>>>>> ゲーム画面のボタンのEventListenner
    this.undoButtonImage = new ImageIcon("./logo/UNDOButton.png");
    this.menuButtonImage = new ImageIcon("./logo/menuButton.png");
    this.playerImage = new ImageIcon("./sozai/vehicle/car_carrier.png");
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

  /*
  public ImageIcon getSpeakerButtonImage(int index){
    return this.speakerButtonImage.get(index);
  }
  */

  public ImageIcon getSpeakerButtonImage(){
    return this.speakerButtonImage;
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

  public void getScene(){

  }

  public void setScene(){

  }

  /*新規のメソッド*/
  public ImageIcon getPlayerImage(){
    return this.playerImage;
  }
  public ImageIcon getCpuImage(int index){
    return this.cpuImage.get(index);
  }


}
