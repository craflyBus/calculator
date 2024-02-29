package org.example;

import org.example.panel.LiftDrPanel;
import org.example.panel.LiftPanel;
import org.example.panel.StallSpeedPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private LiftDrPanel liftDrPanel = null;
    private LiftPanel liftPanel = null;
    private StallSpeedPanel stallSpeedPanel = null;

    public Window() {
        super("비행 계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);

        createMenuBar();

        liftDrPanel = new LiftDrPanel();
        liftPanel = new LiftPanel();
        stallSpeedPanel = new StallSpeedPanel();

        setVisible(true);
    }


    public void changePanel(String panelName) {
        switch (panelName) {
            case "양력 계수":
                getContentPane().removeAll();
                getContentPane().add(liftDrPanel);
                break;
            case "양력":
                getContentPane().removeAll();
                getContentPane().add(liftPanel);
                break;
            case "실속 속도":
                getContentPane().removeAll();
                getContentPane().add(stallSpeedPanel);
                break;
        }

        revalidate();
        repaint();
    }

    public void createMenuBar() {
        JMenuBar mb = new JMenuBar();
        mb.add(new JMenu("설정"));

        String[] menuText = {"양력 계수", "양력", "실속 속도"};
        JMenuItem[] menuItem = new JMenuItem[menuText.length];
        JMenu screenMenu = new JMenu("계산");

        MenuActionListener listener = new MenuActionListener();
        for(int i=0; i < menuItem.length; i++) {
            menuItem[i] = new JMenuItem(menuText[i]);
            menuItem[i].addActionListener(listener);
            screenMenu.add(menuItem[i]);
        }
        mb.add(screenMenu);

        setJMenuBar(mb); // 메뉴바를 프레임에 부착
    }
    class MenuActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            System.out.println(cmd);

            changePanel(cmd);
        }
    }
}
