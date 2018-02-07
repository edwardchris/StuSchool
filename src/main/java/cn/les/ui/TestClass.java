package cn.les.ui;


import cn.les.biz.ClassBiz;
import cn.les.entity.Tclass;
import cn.les.hib.HibernateSessionFactory;
import cn.les.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

    public static void addTclass() {
        Tclass tclass = new Tclass();
        tclass.setCno("c006");
        tclass.setCname("java-6班");

        ClassBiz biz = new ClassBiz();
        try {
            biz.addTClass(tclass);
            System.out.println(tclass.getCname() + "添加成功");
        } catch (Exception e) {
            Log.getLogger().error(e.getMessage());
            System.out.println(tclass.getCname() + "添加失败");
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }

    public static void deleteTclass() {
        ClassBiz biz = new ClassBiz();
        try {
            biz.deleteTClass("c001");
            System.out.println("删除成功");
        } catch (Exception e) {
            Log.getLogger().error(e.getMessage());
            System.out.println("删除失败");
        } finally {
            HibernateSessionFactory.closeSession();
        }

    }

    public static void getAllClass() {
        ClassBiz biz = new ClassBiz();
        List<Tclass> tclassList = new ArrayList<Tclass>();
        try {
            tclassList = biz.getAllClass();
            for (Tclass tclass : tclassList) {
                System.out.println(tclass.getCname() + "--" + tclass.getCno());
            }
        } catch (Exception e) {
            Log.getLogger().error(e.getMessage());
            System.out.println("查询失败");
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }









    public static void getTclass() {
        ClassBiz biz = new ClassBiz();
        try {
            String cno = "c002";
            Tclass tclass = biz.getTclass(cno);
            if (tclass != null) {
                System.out.println("找到了班级" + cno);
            } else {
                System.out.println("无此班级编号" + cno);
            }

        } catch (Exception e) {
            Log.getLogger().error(e.getMessage());
            System.out.println("查询失败");
        } finally {
            HibernateSessionFactory.closeSession();
        }

    }

    public static void main(String[] arg) {
        //TestClass.addTclass();
        //TestClass.deleteTclass();
         TestClass.getAllClass();
        //TestClass.getTclass();
    }

}
