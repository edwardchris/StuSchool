package cn.les.util;


import org.apache.log4j.Logger;

/**
 * @author hx
 * @description Log
 * @create 2017-11-14 14:48
 **/
public class Log {

    /**
     * 通过反射机制，动态获得日志的记录位置
     * @return
     */
    public static Logger getLogger() {
        return Logger.getLogger(Log.class.getName());
    }
}
