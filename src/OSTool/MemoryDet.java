package OSTool;

import java.io.File;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
public class MemoryDet {



    //获得硬盘总容量
    public static String GetTotalMemSize()
    {
        OperatingSystemMXBean mem = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        String memSize= mem.getTotalPhysicalMemorySize()/ 1024 / 1024/1024.0+"";

        return memSize.substring(0,5)+ "GB";

    }
    public static String GetTotalMemSize_withStr()
    {
        return "内存总容量："+GetTotalMemSize();
    }


    //内存占用率
    public static String GetMemUsage()
    {

        OperatingSystemMXBean mem = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        double usageNum=100.0d-100.0d*mem.getFreePhysicalMemorySize()/mem.getTotalPhysicalMemorySize();
        String usageStr= usageNum+"";

        return usageStr.substring(0,5)+"%";

    }
    public static String GetMemUsage_withStr()
    {
        return "内存占用率："+GetMemUsage();
    }

}
