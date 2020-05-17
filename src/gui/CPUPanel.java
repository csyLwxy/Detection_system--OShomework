package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * CPU id
 * CPU 类型
 * CPU 实时占用率
 */
public class CPUPanel extends JPanel {

    public CPUPanel() {
        init();
    }

    JPanel mainPanel, spacePanel;
    JTextField cpuIDText, cpuModelText, cpuUsedRateText;

    public void init() {
        this.setSize(550, 300);
        this.setLayout(new BorderLayout());
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new  GridLayout(3, 3, 0, 10));

        // 为panel 添加一个 title
        Border titleBorder1 = BorderFactory.createTitledBorder("CPU信息");
        mainPanel.setBorder(titleBorder1);

        cpuIDText = new JTextField(15);
        cpuIDText.setEditable(false);
        cpuModelText = new JTextField(15);
        cpuModelText.setEditable(false);
        cpuUsedRateText = new JTextField(15);
        cpuUsedRateText.setEditable(false);
        mainPanel.add(new JLabel("    CPU ID:"));
        mainPanel.add(cpuIDText);
        mainPanel.add(new JLabel("    CPU 类型:"));
        mainPanel.add(cpuModelText);
        mainPanel.add(new JLabel("    CPU 使用率："));
        mainPanel.add(cpuUsedRateText);
        this.add("Center", mainPanel);

        // 用于分割不同区域的空白
        spacePanel = new JPanel();
        spacePanel.setLayout(new GridLayout(1, 0));
        spacePanel.add(new JLabel("     "));
        this.add("South", spacePanel);

        this.setVisible(true);
    }

    public void setCpuIDText(String string) {
        this.cpuIDText.setText(string);
    }

    public void setCpuModelText(String string) {
        this.cpuModelText.setText(string);
    }

    public void setCpuUsedRateText(String string) {
        this.cpuUsedRateText.setText(string);
    }

}