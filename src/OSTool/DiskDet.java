package OSTool;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import java.io.FileWriter;

public class DiskDet {

    //查询总共有多少个分区，获得分区的数目
    public static int GetDiskNum(){
        File[] disks = File.listRoots();
        return disks.length;
    }

    //获得盘符
    public static String GetDiskDriveName(int index){
        File[] disks = File.listRoots();
        return disks[index].getPath();
    }

    //获得指定分区的总容量
    public static String GetDiskTotalSpace(int index){
        File[] disks = File.listRoots();
        String theTotalSpace=disks[index].getTotalSpace() / 1024 / 1024/1024.0+"";
        return theTotalSpace.substring(0,6)+"GB";

    }

    public static String GetDiskTotalSpace_withStr(int index){
        File[] disks = File.listRoots();
        return disks[index].getPath()+"  "+"总容量："+GetDiskTotalSpace(index);
    }


    //获得指定分区的占用率
    public static String GetDiskUsage(int index){
        File[] disks = File.listRoots();

        double usageNum=100.0d-100.0d*disks[index].getUsableSpace()/disks[index].getTotalSpace();

        String usageStr= usageNum+"";

        return usageStr.substring(0,5)+"%";

    }

    public static String GetDiskUsage_withStr(int index){
        File[] disks = File.listRoots();
        return disks[index].getPath()+"  "+"占用率："+GetDiskUsage(index);
    }



    //获得指定分区的序列号
    public static String GetSerialNumber(int index) {

        String drive=GetDiskDriveName(index);

        String result = "";
        try {
            File file = File.createTempFile("damn", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new java.io.FileWriter(file);
            String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
                    + "Set colDrives = objFSO.Drives\n"
                    + "Set objDrive = colDrives.item(\""
                    + drive
                    + "\")\n"
                    + "Wscript.Echo objDrive.SerialNumber"; // see note
            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec(
                    "cscript //NoLogo " + file.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.format("%08X", Integer.valueOf(result.trim()));

    }

    public static String GetSerialNumber_withStr(int index){
        File[] disks = File.listRoots();
        return disks[index].getPath()+"  "+"序列号："+GetSerialNumber(index);
    }


    //获得指定分区的总容量，占用率，序列号
    public static String GetDiskTotalSpaceAndUsage_withStr(int index){
        File[] disks = File.listRoots();
        return disks[index].getPath()+"  "+"总容量："+GetDiskTotalSpace(index)+"    "+"占用率："+GetDiskUsage(index)+"    "+"序列号："+GetSerialNumber(index);
    }


    public static void ShowAllDiskInfo(){
        int diskNum=GetDiskNum();
        for(int i=0;i<diskNum;i++){
            System.out.println(DiskDet.GetDiskTotalSpaceAndUsage_withStr(i));
        }

    }



}
