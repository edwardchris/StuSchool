package cn.les.dao;

import cn.les.entity.Tclass;
import cn.les.entity.Tstudent;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StuDao extends BaseDao {
    /**
     * 增加学生
     *
     * @param tstudent
     * @throws Exception
     */
    public void addStu(Tstudent tstudent) throws Exception {
        this.openConnection();
        this.session.save(tstudent);
        //事务的写法不需要flush方法
        this.session.flush();
    }


    /**
     * 获得学生的信息
     * 通过懒加载机制，获得学生的关联数据
     *
     * @return
     * @throws Exception
     */
    public List<Tstudent> getAllStudents2() throws Exception {
        List<Tstudent> tstudentList = new ArrayList<Tstudent>();
        String hql = "FROM Tstudent";
        this.openConnection();
        Query q = this.session.createQuery(hql);
        //做主键查询，先找缓存
        Iterator iterator = q.iterate();
        while (iterator.hasNext()) {
            //懒加载机制，返回一个代理对象Tstudent
            Object obj = iterator.next();
            Tstudent stu = (Tstudent) obj;
            tstudentList.add(stu);
        }
        return tstudentList;
    }

    /**
     * 获得学生的部分信息
     *
     * @return
     * @throws Exception
     */
    public List<Tstudent> getAllStudents3() throws Exception {
        List<Tstudent> tstudentList = new ArrayList<Tstudent>();
        //hql对象查询，且区分大小写，查询的是属性
        String hql = "select stu.tno, stu.tname FROM Tstudent stu";
        this.openConnection();
        Query q = this.session.createQuery(hql);
        Iterator iterator = q.iterate();
        while (iterator.hasNext()) {
            //返回一个代理对象
            Object obj = iterator.next();
            Object[] objects = (Object[]) obj;
            Tstudent stu = new Tstudent();
            stu.setTno(objects[0].toString());
            stu.setTname(objects[1].toString());
            tstudentList.add(stu);
        }
        return tstudentList;
    }

    /**
     * 直接使用inner join操作，返回的是两个实体结合的对象，不利于后面的调用
     * 效果不如"FROM Tstudent"
     * @return
     * @throws Exception
     */
    public List<Tstudent> getAllStudents4() throws Exception {
        List<Tstudent> tstudentList = new ArrayList<Tstudent>();
        String hql = "FROM Tstudent s inner join s.tclassByCno";
        this.openConnection();
        Query query = this.session.createQuery(hql);
        Iterator iterator = query.iterate();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            Object[] objects = (Object[]) obj;
            Tstudent stu = (Tstudent) objects[0];
            tstudentList.add(stu);
        }
        return tstudentList;
    }

    /**
     * fetch直接从数据库中取出两个实体的结果，同时填充给了Tstudent对象和与它管理的tclass对象
     * 这样做的好处是1、采用的是联合查询的方式，只使用了一个sql语句，比懒加载的机制，性能好；
     * 2、采用这种方式的操作，不需要在UI层进行数据懒加载，这样就可以在Biz层关闭数据库，提高性能；
     * 3、对于sql查询的传统做法是使用dto接收返回值，现在的这种做法省略了dto的定义，大大简化开发；
     * @return
     * @throws Exception
     */
    public List<Tstudent> getAllStudents() throws Exception{
        String hql = "FROM Tstudent s inner join fetch s.tclassByCno";
        this.openConnection();
        Query query = this.session.createQuery(hql);
        return query.list();
    }
}
