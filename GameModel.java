import javax.swing.ImageIcon;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

class GameModel{
  private ImageIcon speakerButtonImage[] = null;
  private ImageIcon undoButtonImage = null;
  private ImageIcon menuButtonImage = null;
  private BufferedReader stageInformation = null;

  public GameModel(){
    this.speakerButtonImage[0] = new ImageIcon("./logo/speaker.png");
    this.speakerButtonImage[1] = new ImageIcon("./logo/speaker.png");
    this.undoButtonImage = new ImageIcon("./logo/UNDOButton.png");
    this.menuButtonImage = new ImageIcon("./logo/logo3.tiff");

    try {
          FileReader fr = new FileReader("./data/stage.csv");
          this.stageInformation = new BufferedReader(fr);
        }catch (IOException ex) {
            ex.printStackTrace();
        }

  }

  public ImageIcon getSpeakerButtonImage(int index){
    return this.speakerButtonImage[index];
  }

  public ImageIcon getUndoButtonImage(){
    return this.undoButtonImage;
  }

  public ImageIcon getMenuButtonImage(){
    return this.menuButtonImage;
  }

  public BufferedReader getStageInformation(){
      return this.stageInformation;
  }

  public void getScene(){

  }

  public void setScene(){

  }


}
