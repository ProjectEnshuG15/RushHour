import javax.swing.ImageIcon;
import java.io.FileReader;
import java.io.BufferedReader;

class GameModel{
  private ImageIcon speakerButtonImage[] = null;
  private ImageIcon undoButtonImage = null;
  private ImageIcon menuButtonImage = null;
  private BufferedReader stageInformation = null;

  public GameModel(){

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

  public  getStageInformation(){

  }

  public void getScene(){

  }

  public void setScene(){

  }


}
