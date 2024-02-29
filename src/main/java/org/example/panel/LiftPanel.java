package org.example.panel;

import org.example.Main;
import org.example.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LiftPanel extends JPanel implements ActionListener {
    private JLabel wingSize;
    private JLabel liftDr;
    private JLabel speed;

    private JTextField _wingSize;
    private JTextField _liftDr;
    private JTextField _speed;

    private JButton calculate;

    private JLabel resultText;
    private JLabel result;

    public LiftPanel() {
        setLayout(null);

        wingSize = new JLabel("날개 크기(m^2)");
        wingSize.setBounds(5, 10, 150, 25);

        _wingSize = new JTextField();
        _wingSize.setBounds(155, 10, 150, 25);

        liftDr = new JLabel("양력 계수");
        liftDr.setBounds(5, 35, 150, 25);

        _liftDr = new JTextField();
        _liftDr.setBounds(155, 35, 150, 25);

        speed = new JLabel("속도(m/s)");
        speed.setBounds(5, 60, 150, 25);

        _speed = new JTextField();
        _speed.setBounds(155, 60, 150, 25);

        calculate = new JButton("계산");
        calculate.setBounds(400, 10, 75, 25);
        calculate.addActionListener(this);

        resultText = new JLabel("결과");
        resultText.setBounds(200, 175, 75, 25);
        resultText.setHorizontalAlignment(JLabel.CENTER);

        result = new JLabel("0kg");
        result.setBounds(200, 195, 75, 25);
        result.setHorizontalAlignment(JLabel.CENTER);

        add(wingSize);
        add(_wingSize);
        add(liftDr);
        add(_liftDr);
        add(speed);
        add(_speed);
        add(calculate);
        add(resultText);
        add(result);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        result.setText(
                Math.round(
                    Double.parseDouble(_liftDr.getText()) *
                    Double.parseDouble(_wingSize.getText()) *
                    (
                        0.5 *
                        1.2 *
                        Double.parseDouble(_speed.getText()) *
                        Double.parseDouble(_speed.getText())
                    ) / 9.8 * 1000
                ) / 1000.0
                + "kg"
        );
    }
}
