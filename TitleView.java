import javax.swing.*;
import java.awt.Point;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.awt.*;


class TitleView extends View implements ActionListener{
    /* 新規フィールド*/
    private RushHourFrame rushframe = null;
    private TitleModel model = null;
    private RushHourController controller = null;

    /*旧フィールド*/
    private Point startButtonPoint = null;
    private Point rankButtonPoint = null;
    private int titleRogoPoint = 0;

    public TitleView(RushHourFrame f,TitleModel m, RushHourController c) {
        this.rushframe = f;
        this.model = m;
        this.controller = c;
    }

    public void start() {
        controller.moveInputNameView();
    }

    public void ranking() {

    }

    @Override
    public void paint() {
        JPanel p = new JPanel();
        p.setLayout(null);
        /*ボタンの設定*/
        JButton startButton = new ResizeJButton(model.getStartButtonImage(),180,370,120,60);
        startButton.setActionCommand("start");
        JButton rankingButton = new ResizeJButton(model.getRankButtonImage(),180,500,120,60);
        rankingButton.setActionCommand("rank");

        /*ボタンへのイベントリスナーの追加*/
        startButton.addActionListener(this);
        rankingButton.addActionListener(this);

        /*ロゴの設定*/
        JLabel logoLabel =  new ResizeJLabel(model.getTitleRogoImage(),120,100,240,200);
        
        /*メインのパネルにコンポーネントを追加*/
        p.add(startButton);
        p.add(rankingButton);
        p.add(logoLabel);
        rushframe.getContentPane().add(p);//FrameにPanelを追加
        this.rushframe.setVisible(true);//描画処理
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if(action.equals("start")){
            this.start();
        }else if(action.equals("rank")){
            this.ranking();
        }else
            System.out.println("out");
    }
}
/**
   新たに作成したクラス
*/
class ResizeJLabel extends JLabel{
    public ResizeJLabel(ImageIcon icon,int x,int y,int w,int h){
        Image new_img = icon.getImage().getScaledInstance(w,h,Image.SCALE_DEFAULT);
        super.setIcon(new ImageIcon(new_img,""));
        setBounds(x,y,w,h);
    }
}

// /**
//   新たに作成したクラス
//   作業中GameViewクラスがエラーを出していたためこちらにも作成した
// */
// class ResizeJButton extends JButton{

//   public ResizeJButton(ImageIcon icon,int x,int y,int w,int h){
//     Image new_img = icon.getImage().getScaledInstance(w,h,Image.SCALE_DEFAULT);
//     super.setIcon(new ImageIcon(new_img,""));
//     setBounds(x,y,w,h);
//   }
//}
