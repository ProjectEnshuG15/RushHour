import javax.swing.ImageIcon;
import java.util.ArrayList;

class RankingModle {
    private ImageIcon titleRogoImage  = null;
    private ArrayList rankInformation = null;
    private ImageIcon goButtonImage   = null;

    public RankingModle() {
        this.titleRogoImage = new ImageIcon("./logo/Ranking.png");
        this.goButtonImage  = new ImageIcon("./logo/GOButton.png");
    }

    public ImageIcon getTitleRogoImage() {
        return this.titleRogoImage;
    }

    public ImageIcon getGobuttonImage() {
        return this.goButtonImage;
    }

    public ArrayList getRankButtonImage() {
        return this.rankInformation;
    }

    public void setRankInformation() {

    }
}
