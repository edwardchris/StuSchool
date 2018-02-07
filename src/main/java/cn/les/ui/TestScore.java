package cn.les.ui;

import cn.les.biz.ScoreBiz;

import cn.les.dto.StuScore;
import cn.les.hib.HibernateSessionFactory;
import cn.les.util.Log;

import java.util.List;

public class TestScore {


    public static void getAllStudentsScore2() {
        ScoreBiz biz = new ScoreBiz();
        try {
            List<StuScore> stuScores = biz.getAllStudentsScore2();
            for (StuScore stus : stuScores) {
                System.out.println(stus.getTname()+"--"+stus.getCname()+"--"+stus.getKname()+"--"+stus.getScore());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.getLogger().error(e.getMessage());
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }


    public static void getAllStudentsScore(int iStart,int rows) {
        ScoreBiz biz = new ScoreBiz();
        try {
            List<StuScore> stuScores = biz.getAllStudentsScore(iStart,rows);
            for (StuScore stus : stuScores) {
                System.out.println(stus.getTname()+"--"+stus.getCname()+"--"+stus.getKname()+"--"+stus.getScore());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.getLogger().error(e.getMessage());
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }


    public static void main(String[] args) {
        TestScore.getAllStudentsScore(4,5);
        TestScore.getAllStudentsScore2();
    }
}
