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
    public List<StuScore> getAllStudentsScore() throws Exception {
        ScoreDao dao = new ScoreDao();

        return dao.getAllStudentsScore();
    }
}
