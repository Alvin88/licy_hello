package com.oc.utils.system;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CodeGenerator extends Thread{  
  
    private static long orderNum = 0l;  
    private static String date ;  
      
    /** 
     * 生成简历编号编号 
     * @return 
     */  
    public static synchronized String getResumeNo() {  
        String str = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());  
        System.err.println(str+"-----"+date);
        if(date==null||!date.equals(str)){  
            date = str;  
            orderNum  = 0l;  
        }  
        orderNum ++;  
        long orderNo = Long.parseLong((date)) * 10000;  
        orderNo += orderNum;;  
        return orderNo+"";  
    }  
  
}  