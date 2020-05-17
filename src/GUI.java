import javax.swing.*;

import gui.*;
import OSTool.*;

import static java.lang.Thread.sleep;

public class GUI {
    public static void main(String[] args) {
        try {
            JFrame jf = new JFrame("系统监控");
            jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jf.setSize(360, 960);

            // 第 1 个 JPanel, 使用默认的浮动布局，显示CPU占用率

            CPUPanel cpuPanel = new CPUPanel();
            cpuPanel.setCpuIDText(CpuDet.GetCpuSerial());
            cpuPanel.setCpuModelText(CpuDet.GetCpuName());

            DiskPanel diskPanel = new DiskPanel(DiskDet.GetDiskNum());
            for (int i = 0; i < DiskDet.GetDiskNum(); ++i) {
                diskPanel.setDiskIDText(i,DiskDet.GetSerialNumber(i));
                diskPanel.setDiskTotalMemoryText(i,DiskDet.GetDiskTotalSpace(i));
            }

            MemPanel MemPanel = new MemPanel();
            MemPanel.setTotalMemoryText(MemoryDet.GetTotalMemSize());

            // 创建一个垂直盒子容器, 把上面 3 个 JPanel 串起来作为内容面板添加到窗口
            Box vBox = Box.createVerticalBox();
            vBox.add(new OSPanel());
            vBox.add(cpuPanel);
            vBox.add(diskPanel);
            vBox.add(MemPanel);

            jf.setContentPane(vBox);

            jf.pack();
            jf.setLocationRelativeTo(null);
            jf.setVisible(true);
            jf.setResizable(false);


            while (true) {
                cpuPanel.setCpuUsedRateText(CpuDet.GetCpuUsage());

                MemPanel.setMemoryUsedRateText(MemoryDet.GetMemUsage());

                for (int i = 0; i < DiskDet.GetDiskNum(); ++i) {
                    diskPanel.setDiskUsedRateText(i, DiskDet.GetDiskUsage(i));
                }
                sleep(1000);
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
