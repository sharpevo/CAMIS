package org.chd.tea;

import java.util.ArrayList;
import java.util.Enumeration;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import javax.servlet.http.HttpServletRequest;

import org.chd.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.impl.CriteriaImpl;


public class HibernatePagination {

	private List list;
	private int pagesize;
	private DetachedCriteria detachedCriteria;
	private int total;
	public HibernatePagination(int pagesize,DetachedCriteria detachedCriteria,Session session){
		this.pagesize = pagesize;
		this.detachedCriteria= detachedCriteria;
		Criteria criteria = detachedCriteria.getExecutableCriteria(session);
		this.total = getTotal(criteria); 
		System.out.println("记录总数为"+total);
		list = new ArrayList(total);
		// 用null填充一个List，用于DisplayTag显示页数。
		for(int i = 0;i<total;i++){
			list.add(null);
		}
	}
	
	
	public int getTotal(Criteria criteria){
		int totalItems = 0;
		totalItems = (Integer)criteria.setProjection(Projections.rowCount()).uniqueResult();
		System.out.println("处理总数"+totalItems);
		criteria.setProjection(null);
		return totalItems;
	}

	/**
	 * 返回查询结果
	 * @param request
	 * @param session
	 * @return
	 */
	public List getList(HttpServletRequest request,Session session){
		int pageNumber = 1;
		pageNumber = getPageNumber(request);
		int pageStart = ((pageNumber-1)*pagesize<=total)?(pageNumber-1)*pagesize:total;
		int pageEnd = (pageNumber*pagesize<=total)?pageNumber*pagesize:total;
		if(hasList(pageStart,pageEnd)){
			System.out.println("请求的页面已存在");
		}else{
			System.out.println("页面大小"+pagesize);
			List temp = getCriteria(detachedCriteria,pageStart,session).list();
			System.out.println("共取出记录:tempsize "+temp.size()+"pageNumber="+pageNumber+" pageStart="+pageStart);
			list = fillList(temp.iterator(),pageStart,list);
		}
		return list;
	}
	
	public Criteria getCriteria(DetachedCriteria detachedCriteria,int pageStart,Session session){
		return detachedCriteria.getExecutableCriteria(session)
								.setFirstResult(pageStart)
								.setMaxResults(pagesize);
	}
	
	/**
	 * 把这个方法提出来，方便继承，即格式化输出。
	 * @param iterator
	 * @param pageStart
	 * @param list
	 * @return
	 */
	public List fillList(Iterator iterator,int pageStart,List list){
		for(int i = pageStart;iterator.hasNext();i++){
			list.set(i, iterator.next());
			System.out.println("从数据库中取出第"+i+"个记录");
		}
		return list;
	}
	
	
	
	
	
	public int getPageNumber(HttpServletRequest request){
		Enumeration params=request.getParameterNames();
		String aParam="";
		int pageNumber = 1;
		while(params.hasMoreElements()){
			aParam = params.nextElement().toString();
			if(aParam.matches("d-[0-9]+-p")){
				pageNumber = Integer.parseInt(request.getParameter(aParam));
				System.out.println("请求页号:"+pageNumber);
				return pageNumber;
			}
		}
		System.out.println("没有请求页号,默认取1");
		return pageNumber;
	}
	
	/**
	 * 判断内存中有无记录
	 * @param pageStart
	 * @param pageEnd
	 * @return
	 */
	public boolean hasList(int pageStart, int pageEnd){
		for(int i = pageStart; i < pageEnd; i++){
			System.out.println("正在查询缓存中有无记录:"+i);
			if(list.get(i)!=null){
				System.out.println("list中存在要求的内容");
				return true;
			}
		}
		return false;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	

}
