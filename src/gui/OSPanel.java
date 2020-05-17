package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class OSPanel extends JPanel {
    public OSPanel() {
        init();
    }

    public void init() {
        this.setSize(550, 300);
        this.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();

        Border titleBorder1 = BorderFactory.createTitledBorder("操作系统信息");
        mainPanel.setBorder(titleBorder1);

        mainPanel.add(new JLabel("    操作系统："));
        JTextField text = new JTextField(OSTool.OSVer.GetOsVersion());
        text.setEditable(false);
        mainPanel.add(text);

        this.add("Center", mainPanel);


        // 用于分割不同区域的空白
        JPanel spacePanel = new JPanel();
        spacePanel.setLayout(new GridLayout(1, 0));
        spacePanel.add(new JLabel("     "));
        this.add("South", spacePanel);

        this.setVisible(true);


    }
}
