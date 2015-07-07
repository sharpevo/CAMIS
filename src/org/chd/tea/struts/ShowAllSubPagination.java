package org.chd.tea.struts;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.chd.entity.SubjectInfo;
import org.chd.tea.HibernatePagination;
import org.chd.tea.TeaConstants;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

public class ShowAllSubPagination extends HibernatePagination {
	
	private Map map;

	public ShowAllSubPagination(int pagesize, DetachedCriteria detachedCriteria,Session session,Map map) {
		super(pagesize, detachedCriteria,session);
		this.map = map;
	}
	public List fillList(Iterator iterator,int pageStart,List list){
		Map m = new HashMap();
		
		for(int i = pageStart;iterator.hasNext();i++){
			m = new HashMap();
			SubjectInfo sub = (SubjectInfo) iterator.next();
			m.put("subjectId", sub.getSubjectId());
			m.put("subject", sub.getSubject());
			m.put("teacherAId",sub.getTeacherAId());
			m.put("difficulty", sub.getDifficulty());
			m.put("teacherName",map.get(sub.getTeacherAId()));
			m.put("years", sub.getYears());
			list.set(i, m);
			System.out.println("从数据库中取出第"+i+"个记录");
		}
		return list;
	}
	

}
