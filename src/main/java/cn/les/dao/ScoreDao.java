package cn.les.dao;

import cn.les.dto.StuScore;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;


import java.util.List;

public class ScoreDao extends BaseDao{

    /**
     * 获得所有学生的考试成绩
     * 复杂查询使用SQLQuery标量方式addScalar
     * @return
     * @throws Exception
     */
    public List<StuScore> getAllStudentsScore2() throws Exception {
        String sql = "select k.kno,k.kname,sc.score,s.tno,s.tname,c.cname,c.cno from tscore sc,tclass c,tcourse k,tstudent s where k.kno = sc.kno and c.cno = s.cno and sc.tno = sc.tno";
        this.openConnection();
        SQLQuery query = this.session.createSQLQuery(sql);
        query.addScalar("kno",StandardBasicTypes.STRING);
        query.addScalar("kname",StandardBasicTypes.STRING);
        query.addScalar("score", StandardBasicTypes.DOUBLE);
        query.addScalar("tno",StandardBasicTypes.STRING);
        query.addScalar("tname",StandardBasicTypes.STRING);
        query.addScalar("cname",StandardBasicTypes.STRING);
        query.addScalar("cno",StandardBasicTypes.STRING);
        query.setResultTransformer(Transformers.aliasToBean(StuScore.class));
        return query.list();
    }

    /**
     *
     * @param iStart
     * @param rows
     * @return
     * @throws Exception
     */
    public List<StuScore> getAllStudentsScore(int iStart,int rows) throws Exception{
        String sql = "select k.kno,k.kname,sc.score,s.tno,s.tname,c.cname,c.cno from tscore sc,tclass c,tcourse k,tstudent s where k.kno = sc.kno and c.cno = s.cno and sc.tno = sc.tno";
        this.openConnection();
        SQLQuery query = this.session.createSQLQuery(sql);
        query.setFirstResult(iStart);
        //每页显示的数量
        query.setMaxResults(rows);
        query.addScalar("kno",StandardBasicTypes.STRING);
        query.addScalar("kname",StandardBasicTypes.STRING);
        query.addScalar("score", StandardBasicTypes.DOUBLE);
        query.addScalar("tno",StandardBasicTypes.STRING);
        query.addScalar("tname",StandardBasicTypes.STRING);
        query.addScalar("cname",StandardBasicTypes.STRING);
        query.addScalar("cno",StandardBasicTypes.STRING);
        query.setResultTransformer(Transformers.aliasToBean(StuScore.class));
        return query.list();

    }


}
