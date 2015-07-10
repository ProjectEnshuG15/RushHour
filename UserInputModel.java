import javax.swing.ImageIcon;

class UserInputModel{
  private ImageIcon enterButtonImage = null;

  public UserInputModel(){
    enterButtonImage = new ImageIcon("./logo/EnterButton.png");
  }

  public ImageIcon getEnterButtonImage(){
    return this.enterButtonImage;
  }
}
