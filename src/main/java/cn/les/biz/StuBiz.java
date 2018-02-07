package cn.les.biz;

import cn.les.dao.ClassDao;
import cn.les.dao.StuDao;
import cn.les.entity.Tclass;
import cn.les.entity.Tstudent;

import java.util.ArrayList;
import java.util.List;

public class StuBiz {

    /**
     * 增加一个班级和一群学生
     *
     * @param tclass
     * @param tstudentList
     * @throws Exception
     */
    public void addClassAndStudents(Tclass tclass, List<Tstudent> tstudentList) throws Exception {
        for (Tstudent stu:tstudentList) {
            //多对一建立关系，尽量不要建立一对多的关系，inverse="false"
            stu.setTclassByCno(tclass);
        }

        StuDao stuDao = new StuDao();
        ClassDao classDao = new ClassDao();
        //开启事务
        try {
            stuDao.beginTransaction();
            classDao.addTClass(tclass);
            for (Tstudent stu : tstudentList) {
                stuDao.addStu(stu);
            }
            stuDao.commit();
        } catch (Exception e) {
            e.printStackTrace();
            stuDao.callback();
            throw e;
        }
    }


    /**
     * 获得学生的信息
     * @return
     * @throws Exception
     */
    public List<Tstudent> getAllStudents() throws Exception{
        StuDao dao = new StuDao();
        return dao.getAllStudents();
    }
}
