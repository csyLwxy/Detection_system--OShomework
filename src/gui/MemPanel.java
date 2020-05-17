package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * 内存总容量
 * 内存占用率
 */
public class MemPanel extends JPanel {

    public MemPanel() {
        init();
    }

    JPanel mainPanel, spacePanel;
    JTextField totalMemoryText, memoryUsedRateText;

    public void init() {
        this.setSize(550, 300);
        this.setLayout(new BorderLayout());

        mainPanel = new JPanel();

        // 为panel 添加一个 title
        Border titleBorder1 = BorderFactory.createTitledBorder("内存信息");
        mainPanel.setBorder(titleBorder1);

        totalMemoryText = new JTextField(15);
        totalMemoryText.setEditable(false);
        memoryUsedRateText = new JTextField(15);
        memoryUsedRateText.setEditable(false);
        mainPanel.add(new JLabel("    内存总大小:"));
        mainPanel.add(totalMemoryText);
        mainPanel.add(new JLabel("    内存使用率:"));
        mainPanel.add(memoryUsedRateText);
        this.add("Center", mainPanel);

        // 用于分割不同区域的空白
        spacePanel = new JPanel();
        spacePanel.setLayout(new GridLayout(1, 0));
        spacePanel.add(new JLabel("     "));
        this.add("South", spacePanel);

        this.setVisible(true);
    }

    public void setMemoryUsedRateText(String string) {
        this.memoryUsedRateText.setText(string);
    }

    public void setTotalMemoryText(String string) {
        this.totalMemoryText.setText(string);
    }
}
