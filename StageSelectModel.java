import javax.swing.ImageIcon;

class StageSelectModel{
  private ImageIcon rightButtonImage = null;
  private ImageIcon leftButtonImage = null;
  private ImageIcon startButtonImage = null;
  private ImageIcon stageSumnail[] = null;

  public StageSelectModel(){
    this.rightButtonImage = new ImageIcon("./logo/right.png");
    this.leftButtonImage = new ImageIcon("./logo/left.png");
    this.startButtonImage = new ImageIcon("./logo/startButton.png");

    /*とりあえずスピーカーで代用*/
    this.stageSumnail[0] = new ImageIcon("./logo/speaker.png");
    this.stageSumnail[1] = new ImageIcon("./logo/speaker.png");
    this.stageSumnail[2] = new ImageIcon("./logo/speaker.png");
    this.stageSumnail[3] = new ImageIcon("./logo/speaker.png");
    this.stageSumnail[4] = new ImageIcon("./logo/speaker.png");
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

  public ImageIcon getStargeSumnail(int index){
    return this.stageSumnail[index];
  }
}
