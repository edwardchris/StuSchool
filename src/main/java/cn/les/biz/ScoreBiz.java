package cn.les.biz;

import cn.les.dao.ScoreDao;
import cn.les.dto.StuScore;

import java.util.List;

public class ScoreBiz {

    /**
     * 获得所有学生的考试成绩
     *
     * @return
     * @throws Exception
     */
    public List<StuScore> getAllStudentsScore2() throws Exception {
        ScoreDao dao = new ScoreDao();

        return dao.getAllStudentsScore2();
    }

    /**
     * 翻页查询成绩信息
     * @param iStart
     * @param rows
     * @return
     * @throws Exception
     */
    public List<StuScore> getAllStudentsScore(int iStart,int rows) throws Exception {
        ScoreDao dao = new ScoreDao();

        return dao.getAllStudentsScore(iStart,rows);
    }
}
