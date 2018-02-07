package cn.les.ui;

import cn.les.biz.StuBiz;
import cn.les.entity.Tclass;
import cn.les.entity.Tstudent;
import cn.les.hib.HibernateSessionFactory;

import java.util.ArrayList;

import java.util.List;

public class TestStu {
    /**
     * 1、hibernate由于其懒加载的特点，要求数据库的关闭点在UI层，不能再biz层；
     * 2、性能方面有问题，所以大并发量中不能使用hibernate；
     * 3、在UI层无法获得dao的对象，那么意味着无法调用closeConnection（）方法；
     */
    public static void addClassAndStudents() {
        Tclass tclass = new Tclass();
        tclass.setCname("java-1");
        tclass.setCno("c001");
        List<Tstudent> tstudentList = new ArrayList<Tstudent>();
        Tstudent stu = new Tstudent();
        stu.setTno("t003");
        stu.setTname("张四");
        Tstudent stu2 = new Tstudent();
        stu2.setTname("王二");
        stu2.setTno("t004");
        tstudentList.add(stu);
        tstudentList.add(stu2);
        StuBiz biz = new StuBiz();
        try {
            biz.addClassAndStudents(tclass, tstudentList);
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("添加失败");
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }


    /**
     * 获得所有学生信息
     */
    public static void getAllStudent(){
        StuBiz biz = new StuBiz();
        try {
            List<Tstudent> tstudentList = biz.getAllStudents();
            for (Tstudent stu:tstudentList) {
                System.out.println(stu.getTno()+"--"+stu.getTname()+"--"+stu.getTclassByCno().getCname());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取失败");
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }


    public static void main(String[] args) {
        TestStu.addClassAndStudents();
        //TestStu.getAllStudent();
    }
}



