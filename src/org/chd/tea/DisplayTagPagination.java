package org.chd.tea;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.chd.HibernateSessionFactory;
import org.hibernate.Query;


/**
 * 这个不好。当初是为了尝试hql是否支持Displaytag风格。
 * 主要用于“我的课题”分页显示，因为数据量不是很大，最多10条
 * 所以可以删去。
 * @author Ryan
 *
 */
public class DisplayTagPagination {

	private List list; // 保存参数列表，因为hql不是离线的。
	private int pagesize;
	private int total;
	private String hql; // 包括select语句,需要from分割
	private Map queryParameter = new HashMap();

	private Query query;

	public DisplayTagPagination(int pagesize,String hql){
		this.pagesize = pagesize;
		this.hql = hql;
	}
	
	public void initList(String hql){
		if(list != null){
			return;
		}
		System.out.println("初始化list");
		total = getTotal(hql);
		list = new ArrayList(total);
		for(int i = 0; i<total; i++){
			list.add(null);
		}
	}
	public int getTotal(String hql){
		int totalItems = 0;
		String[] hqls = hql.split("from");
		totalItems = Integer.parseInt(getQuery("select count(*) from"+hqls[hqls.length-1]).uniqueResult().toString());
		return totalItems;
	}
	
	public List getList(HttpServletRequest request){
		int pageNumber = 1;
		pageNumber = getPageNumber(request);
		int pageStart = (pageNumber-1)*pagesize;
		int pageEnd = (pageNumber*pagesize<=total)?pageNumber*pagesize:total;
		initList(hql);
		if(hasList(pageStart,pageEnd)){
			System.out.println("请求的页面已存在");
		}else{
			System.out.println("页面大小"+pagesize);
			query = getQuery(pagesize,pageStart);
			Iterator iterator = query.iterate();
			for(int i = pageStart;iterator.hasNext();i++){
				this.list.set(i, iterator.next());
				System.out.println("从数据库中取出第"+i+"个记录");
			}
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
	
	
	
	public boolean hasList(int pageStart, int pageEnd){
		for(int i = pageStart; i < pageEnd; i++){
			System.out.println("正在查询缓存中有无记录:"+i);
			// 全空才为空
			if(list.get(i)!=null){
				System.out.println("list中存在要求的内容");
				return true;
			}
		}
		return false;
	}
	
	
	public Query getQuery(String hql){
		String name = "";
		Set nameSet = queryParameter.keySet();
		query =  HibernateSessionFactory.getSession().createQuery(hql);
		for(Iterator iterator = nameSet.iterator(); iterator.hasNext();){
			name = iterator.next().toString();
			if(queryParameter.get(name) instanceof String){
				query.setString(name, queryParameter.get(name).toString());
			}
			else if(queryParameter.get(name) instanceof Integer){
				query.setInteger(name, Integer.parseInt(queryParameter.get(name).toString()));
			}
		}
		return query;
	}
	
	public Query getQuery(int pagesize, int pageStart){
		return getQuery(hql).setMaxResults(pagesize).setFirstResult(pageStart);
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

	public String getHql() {
		return hql;
	}

	public void setHql(String hql) {
		this.hql = hql;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public DisplayTagPagination setParameter(String name,Object value){
		queryParameter.put(name, value);
		return this;
	}
	
	public DisplayTagPagination setQueryParameter(Map m){
		this.queryParameter = m;
		return this;
	}



	public Map getQueryParameter() {
		return queryParameter;
	}
	
}
