
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RushHourController{
    int debug = 0; // 0:run 1:debag
    public RushHourController(RushHourFrame rushflame){
        this.run();
        if(debug == 0) {
            new TitleView(rushflame,new TitleModel()).paint();
        } else {
            //new GameView(rushflame,new GameModel()).paint();
        }

    }

    private void run(){

    }

    public void moveInputNameView() {

    }

    public void moveRankingView() {

    }

    public void moveStageSelect(String username) {

    }

    public void changeStageInfo(int d) {

    }

    public void moveGameView() {

    }

    public void speakerOnOff() {

    }

    public void moveMenuView() {

    }

    public void moveTitleView() {

    }

    public void resumeGame() {

    }

    public void clickPiece() {

    }

    public void movePiece() {

    }

    public void partPiece() {

    }

    public void moveContinueView() {

    }
}
