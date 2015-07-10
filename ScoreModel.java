import javax.swing.ImageIcon;

class ScoreModel{
  private ImageIcon nextButtonImage = null;

  public ScoreModel(){
    this.nextButtonImage = new ImageIcon("./logo/nextButton.png");
  }

  public ImageIcon getNextButtonImage(){
    return this.nextButtonImage;
  }
}
