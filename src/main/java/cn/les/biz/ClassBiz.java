package cn.les.biz;


import cn.les.dao.ClassDao;
import cn.les.entity.Tclass;

import java.util.ArrayList;
import java.util.List;

public class ClassBiz {
	/**
	 * 添加班级
	 * 
	 * @param tclass
	 * @throws Exception
	 */
	public void addTClass(Tclass tclass) throws Exception {

		ClassDao dao = new ClassDao();
		dao.addTClass2(tclass);

	}

	/**
	 * 根据班级的主键删除班级
	 * 
	 * @param cno
	 * @throws Exception
	 */
	public void deleteTClass(String cno) throws Exception {
		ClassDao dao = new ClassDao();
		dao.deleteTClass2(cno);
	}

	/**
	 * 查询所有班级信息
	 * @return
	 * @throws Exception
	 */
	public List<Tclass> getAllClass() throws Exception{
		List<Tclass> tclasses = new ArrayList<Tclass>();
		ClassDao dao = new ClassDao();
		tclasses = dao.getAllClass();
		return tclasses;
	}


	/**
	 * 根据cno获取班级的信息
	 * @param cno
	 * @return
	 * @throws Exception
	 */
	public Tclass getTclass(String cno) throws Exception{
		Tclass tclass = new Tclass();
		ClassDao dao = new ClassDao();
		dao.getTclass(cno);
		return tclass;
	}


}
