import javax.swing.*;
import java.awt.Point;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

class MenuView extends View implements ActionListener{
    /* 新規フィールド*/
    private RushHourFrame rushframe = null;
    private MenuModel model = null;
    private RushHourController controller = null;
    JButton titleButton = null;
    JButton resumeButton = null;
    JLabel logoLabel =  null;
    
    private Point titlePoint = null;
    private Point stageselectPoint = null;
    private Point gameresumePoint = null;

    public MenuView(RushHourFrame f,MenuModel m, RushHourController c) {
        this.rushframe = f;
        this.model = m;
        this.controller = c;
    }

    public void clickTitle() {
        this.clear();
        controller.moveTitleView();
    }

    public void clickSelect() {
        this.clear();
    }

    public void clickResume() {
        this.clear();
        controller.moveGameView();
    }


    @Override
    public void paint() {
        JPanel p = new JPanel();
        p.setLayout(null);
        /*ボタンの設定*/
        titleButton = new ResizeJButton(model.getRetaireButtonImage(),180,370,120,60);
        titleButton.setActionCommand("title");
        resumeButton = new ResizeJButton(model.getResumeBottonImage(),180,500,120,60);
        resumeButton.setActionCommand("resume");
         /*ロゴの設定*/
        logoLabel =  new ResizeJLabel(model.getTitleRogoImage(),120,100,240,200);
        /*ボタンへのイベントリスナーの追加*/
        titleButton.addActionListener(this);
        resumeButton.addActionListener(this);



        
        // /*メインのパネルにコンポーネントを追加*/
         p.add(titleButton);
         p.add(resumeButton);
         p.add(logoLabel);
         rushframe.getContentPane().add(p);//FrameにPanelを追加
         this.rushframe.setVisible(true);//描画処理
    }

        @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if(action.equals("title")){
            this.clickTitle();
        }else if(action.equals("resume")){
            this.clickResume();
        }else
            System.out.println("out");
    }

    /**
       新規メソッド
     */    
    public void clear() {
        this.rushframe.getContentPane().removeAll();
    }
}
