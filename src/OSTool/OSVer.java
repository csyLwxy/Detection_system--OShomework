package OSTool;

public class OSVer {

    //获得操作系统版本
    public static String GetOsVersion(){
        return System.getProperty("os.name")+"(版本号："+System.getProperty("os.version")+")";
    }
    public static String GetOsVersion_withStr(){
        return "操作系统版本："+GetOsVersion();
    }

}
