import javax.swing.ImageIcon;

class StageSelectModel{
  private ImageIcon rightButtonImage = null;
  private ImageIcon leftButtonImage = null;
  private ImageIcon startButtonImage = null;
  private ImageIcon stageSumnail[] = null;

  public StageSelectModel(){

  }

  public ImageIcon getRightButtonImage(){
    return this.rightButtonImage;
  }

  public ImageIcon getLeftButtonImage(){
    return this.leftButtonImage;
  }

  public ImageIcon getStartButtonImage(){
    return this.startButtonImage;
  }

  public ImageIcon getStargeSumnail(int index=0){
    return this.stageSumnail[index];
  }
}
