import javax.swing.ImageIcon;

class MenuModle {
    private ImageIcon titleRogoImage     = null;
    private ImageIcon retaireButtonImage = null;
    private ImageIcon selectButtonImage  = null;
    private ImageIcon resumeButtonImage  = null;

    public MenuModle() {
        this.titleRogoImage     = new ImageIcon("./logo/menu.png");
        this.retaireButtonImage = new ImageIcon("./logo/titleButton.png");        
        this.selectButtonImage  = new ImageIcon("./logo/stageselectButton.png");        
        this.resumeButtonImage  = new ImageIcon("./logo/GameResumeButton.png");        
    }

    public ImageIcon getTitleRogoImage() {
        return this.titleRogoImage;
    }

    public ImageIcon getRetaireButtonImage() {
        return this.retaireButtonImage;
    }

    public ImageIcon getSelectButtonImage() {
        return this.selectButtonImage;
    }

    public ImageIcon getResumeBottonImage() {
        return this.resumeButtonImage;
    }

}
