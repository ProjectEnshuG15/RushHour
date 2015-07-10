import javax.swing.ImageIcon;

class ContinueModle {
    private ImageIcon[] yesnoButtonImage = null;

    public ContinueModle() {
        this.yesnoButtonImage[0] = new ImageIcon("./logo/NoButton.png");
        this.yesnoButtonImage[1] = new ImageIcon("./logo/yesButton.png");
    }

    public ImageIcon getYesNoButtonImage(int n) {
            return this.yesnoButtonImage[n];
    }

}
