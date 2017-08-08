package ssm.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UUID {


    private static String preId = "";
    private static final  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");


    /**
     *
     * 返回32位的随机字符串
     * @return
     */
    public static String getUUID(){

        return  java.util.UUID.randomUUID().toString().replaceAll("-","");
    }


    /**
     * 判断是否是重复的ID(跟前面一个）
     * @param newId
     * @return
     */
    private static boolean isRepeatId(String newId){
        if (newId.equals(preId)) return true;
        return false;
    }


    public static synchronized String createIDByNowTime() {

        String newId = simpleDateFormat.format(Calendar.getInstance().getTime());

        while (isRepeatId(newId)) {
            newId = simpleDateFormat.format(Calendar.getInstance().getTime());
        }
        preId = newId;
        return newId;
    }
}
