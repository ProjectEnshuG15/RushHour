
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RushHourController{
    private int debug = 0; // 0:run 1:debag

    /*新フィールド*/
    private TitleView titleView = null;
    private TitleModel titleModel = null;
    private InputNameView inputNameView = null;
    private GameView gameView = null; 
    private GameModel gameModel = null;
    
    public RushHourController(RushHourFrame rushflame){
        this.titleModel = new TitleModel();
        this.titleView = new TitleView(rushflame, titleModel, this);
        this.inputNameView = new InputNameView();
        this.gameModel = new GameModel();
        this.gameView = new GameView(rushflame, gameModel, this);

        this.run();
        if(debug == 1) {
            titleView.paint();
        } else {
            gameView.paint();
        }

    }

    private void run(){

    }

    public void moveInputNameView() {
        // viewを更新する
        gameView.paint();
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
