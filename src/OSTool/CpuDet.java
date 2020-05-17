package OSTool;

import java.io.IOException;
import java.util.Scanner;
import javax.management.ObjectName;
import javax.management.MBeanServer;
import javax.management.AttributeList;
import javax.management.Attribute;

import java.lang.management.ManagementFactory;

public class CpuDet {
    //获得CPU序列号

    public  static String GetCpuSerial(){
        //String theSerial="CPU序列号:";
        try{

            Process process = Runtime.getRuntime().exec(new String[] { "wmic", "cpu", "get", "ProcessorId" });

            process.getOutputStream().close();

            Scanner sc = new Scanner(process.getInputStream());

            String property = sc.next();
            String serial = sc.next();

            return serial;
        }catch (Exception e){
            return "error";
        }

    }

    public static String GetCpuSerial_withStr() {
        return "CPU序列号:"+GetCpuSerial();
    }


    //获得CPU名称

    public static String GetCpuName() {

        try {
            Process process=Runtime.getRuntime().exec("wmic cpu get name");
            process.getOutputStream().close();
            Scanner sc = new Scanner(process.getInputStream());
            String key = sc.next();

            String cpuName = "";
            while (sc.hasNext()) {
                cpuName += sc.next() + " ";
            }
            if(cpuName.equals("")){
                return "error";
            }
            else{
                return cpuName.substring(0, cpuName.length() - 1);
            }

        } catch (IOException ex) {
            return "error";
        }
    }

    public static String GetCpuName_withStr() {
        return "CPU名称："+GetCpuName();
    }



    //获得CPU使用率
    public static String GetCpuUsage(){
        try{
            MBeanServer mbs    = ManagementFactory.getPlatformMBeanServer();
            ObjectName name    = ObjectName.getInstance("java.lang:type=OperatingSystem");
            AttributeList list = mbs.getAttributes(name, new String[]{ "ProcessCpuLoad" });

            if (list.isEmpty()) {
                return "error";
            }

            Attribute att = (Attribute)list.get(0);
            Double value  = (Double)att.getValue();


            if (value == -1.0)  {
                return "error";
            }

            String theCpuUsage=""+(value*1000);
            return theCpuUsage.substring(0,5)+"%";
        }catch(Exception  e){
            return "error";
        }


    }

    public static String GetCpuUsage_withStr() {
        return "CPU占用率:"+GetCpuUsage();

    }

}



