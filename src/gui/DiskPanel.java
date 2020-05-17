package gui;
import	java.util.ArrayList;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

public class DiskPanel extends JPanel{

    int diskNum;

    public DiskPanel(int num) {
        diskNum = num;
        init();
    }

    JPanel mainPanel, spacePanel;
    ArrayList<JTextField> diskIDText = new ArrayList<> ();
    ArrayList<JTextField> diskTotalMemoryText = new ArrayList<> ();
    ArrayList<JTextField> diskUsedRateText = new ArrayList<> ();

    public void init() {
        this.setSize(550, 300);
        this.setLayout(new BorderLayout());

        mainPanel = new JPanel();

        // 为panel 添加一个 title
        Border titleBorder1 = BorderFactory.createTitledBorder("硬盘信息");
        mainPanel.setBorder(titleBorder1);
        mainPanel.setLayout(new  GridLayout(diskNum, 3, 0, 10));


        for (int i = 0; i < diskNum; ++i) {
            diskIDText.add(new JTextField(15));
            diskTotalMemoryText.add(new JTextField(15));
            diskUsedRateText.add(new JTextField(15));
            diskIDText.get(i).setEditable(false);
            diskTotalMemoryText.get(i).setEditable(false);
            diskUsedRateText.get(i).setEditable(false);
            mainPanel.add(new JLabel("    硬盘 ID:"));
            mainPanel.add(diskIDText.get(i));
            mainPanel.add(new JLabel("    硬盘总容量:"));
            mainPanel.add(diskTotalMemoryText.get(i));
            mainPanel.add(new JLabel("    硬盘使用率："));
            mainPanel.add(diskUsedRateText.get(i));
        }
        this.add("Center", mainPanel);

        // 用于分割不同区域的空白
        spacePanel = new JPanel();
        spacePanel.setLayout(new GridLayout(1, 0));
        spacePanel.add(new JLabel("     "));
        this.add("South", spacePanel);

        this.setVisible(true);
    }

    public void setDiskUsedRateText(int index, String string) {
        this.diskUsedRateText.get(index).setText(string);
    }

    public void setDiskTotalMemoryText(int index, String string) {
        this.diskTotalMemoryText.get(index).setText(string);
    }

    public void setDiskIDText(int index, String string) {
        this.diskIDText.get(index).setText(string);
    }
}
