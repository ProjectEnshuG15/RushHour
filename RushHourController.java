
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RushHourController{

    /*新フィールド*/
    private TitleView titleView = null;
    private TitleModel titleModel = null;
    private GameView gameView = null;
    private GameModel gameModel = null;
    private MenuView menuView = null;
    private MenuModel menuModel = null;

    public RushHourController(RushHourFrame rushflame){
        this.titleModel = new TitleModel();
        this.titleView = new TitleView(rushflame, titleModel, this);
        this.gameModel = new GameModel();
        this.gameView = new GameView(rushflame, gameModel, this);
        this.menuModel = new MenuModel();
        this.menuView = new MenuView(rushflame, menuModel, this);
        
        this.run();
        titleView.paint();
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
        gameView.paint();
    }

    public void speakerOnOff() {

    }

    public void moveMenuView() {
        menuView.paint();
    }

    public void moveTitleView() {
      titleView.paint();
    }

    public void resumeGame() {

    }

    public void clickPiece() {

    }

    public void movePiece(int x,int y,Draggable lab,ArrayList<Draggable> allPiece) {
      Point p = this.gameModel.movePiece(x,y,lab,allPiece);
      if (p==null) return;//返り値がnullであれば既に駒が存在しているためvoidリターン
      gameModel.setScene(allPiece);//移動するため最後の場面情報を記録する
      gameModel.startSE();//移動時のSEを再生する
      lab.setMasuLocation(p.x,p.y);//移動可能であればラベルの座標を変更する
      if( gameModel.checkGoalZone(lab) ) {//移動した場所がゴールかどうか確認する
          gameView.clear();
          this.moveTitleView();
      }
    }

    public void partPiece() {

    }

    public void moveContinueView() {

    }

    /*新規メソッド*/
    public void doUndoEvent(ArrayList<Draggable> allPiece){
      ArrayList<Point> scene = gameModel.getScene();//最後の場面情報を取得する
      if(scene==null) return;//過去の場面情報がなければreturnする
      //座標の取得と更新
      for(int i=0;i<allPiece.size();i++){
        Draggable d = allPiece.get(i);
        Point p = scene.get(i);
        d.setMasuLocation(p.x,p.y);
      }
    }
}
