import javax.swing.ImageIcon;

class TitleModel {
    private ImageIcon titleRogoImage   = null;
    private ImageIcon startButtonImage = null;
    private ImageIcon rankButtonImage  = null;

    public TitleModel() {
        this.titleRogoImage   = new ImageIcon("./logo/title.png");
        this.startButtonImage = new ImageIcon("./logo/startButton.png");
        this.rankButtonImage  = new ImageIcon("./logo/RankingButton.png");
    }

    public ImageIcon getTitleRogoImage() {
        return this.titleRogoImage;
    }

    public ImageIcon getStartButtonImage() {
        return this.startButtonImage;
    }

    public ImageIcon getRankButtonImage() {
        return this.rankButtonImage;
    }

}
