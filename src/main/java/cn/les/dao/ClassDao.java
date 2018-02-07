package cn.les.dao;

import cn.les.entity.Tclass;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import java.util.List;

public class ClassDao extends BaseDao {
    /**
     * 添加班级
     *
     * @param tclass
     * @throws Exception
     */
    public void addTClass(Tclass tclass) throws Exception {
        this.openConnection();
        this.session.save(tclass);
        this.session.flush();

    }

    /**
     * 添加班级
     *
     * @param tclass
     * @throws Exception
     */
    public void addTClass2(Tclass tclass) throws Exception {
        String sql = "insert into Tclass values(?,?)";
        this.openConnection();
        SQLQuery query = this.session.createSQLQuery(sql);
        query.setString(0, tclass.getCname());
        query.setString(1, tclass.getCno());
        query.executeUpdate();

    }

    /**
     * 根据班级的主键删除班级
     *
     * @param cno
     * @throws Exception
     */
    public void deleteTClass(String cno) throws Exception {
        Tclass tclass = new Tclass();
        tclass.setCno(cno);
        this.openConnection();
        this.session.delete(tclass);
        this.session.flush();

    }

    /**
     * 根据班级的主键删除班级
     *
     * @param cno
     * @throws Exception
     */
    public void deleteTClass2(String cno) throws Exception {
        String sql = "delete from tclass where cno = ?";
        Tclass tclass = new Tclass();
        this.openConnection();
        SQLQuery query = this.session.createSQLQuery(sql);
        query.setString(0, cno);
        query.executeUpdate();

    }

    /**
     * 查询班级信息
     *
     * @return
     * @throws Exception
     */
    public List<Tclass> getAllClass() throws Exception {
        //hql查询的是实体对象，需要区分大小写
        String hql = "FROM Tclass";
        this.openConnection();
        Query query = this.session.createQuery(hql);
        return query.list();
    }

    /**
     * 根据cno获取班级的信息
     *
     * @param cno
     * @return
     * @throws Exception
     */
    public Tclass getTclass2(String cno) throws Exception {
        String hql = "FROM Tclass t where t.cno = ?";
        this.openConnection();
        Query query = this.session.createQuery(hql);
        query.setString(0, cno);
        List<Tclass> tclasses = query.list();
        return tclasses.get(0);
    }

    /**
     * 根据cno获取班级的信息
     *
     * @param cno
     * @return
     * @throws Exception
     */
    public Tclass getTclass(String cno) throws Exception {
        this.openConnection();
        return (Tclass) this.session.get(Tclass.class,cno);
    }

    public Tclass getTclass3(String cno) throws Exception{
        this.openConnection();
        //懒加载机制
        return (Tclass) this.session.load(Tclass.class,cno);
    }
}
