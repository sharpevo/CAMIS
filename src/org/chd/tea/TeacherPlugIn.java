package org.chd.tea;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.apache.struts.util.LabelValueBean;
import org.chd.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Description: 在系统初始化的时候，查询数据库，将研究方向、课题来源等内容存入servletContext共享。
 * 1.教师－ID的map，用于在浏览课题的时候不用再查询数据库就可显示。
 * 2.年份列表，生成从2005年之今的年份，用于在浏览全部课题的时候显示。
 * 
 * 在struts-config-tea.xml中注册，如下
 * <plug-in className="org.chd.tea.TeacherPlugIn" />
 * 
 * @author Ryan
 *
 */
public class TeacherPlugIn implements PlugIn{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Vector field=new Vector();
			Vector property=new Vector();
			Vector source=new Vector();
			Vector type=new Vector();
			Vector teacherOption=new Vector();
			Vector subjectYears=new Vector();
			
			List temp=null;
			String str=">---------<";
			String t="";
			LabelValueBean tip=new LabelValueBean(str,t);
			
			field.add(tip);
			property.add(tip);
			source.add(tip);
			type.add(tip);
			teacherOption.add(tip);
			subjectYears.add(tip);
			
			// to get "field" for the Struts label in the fillSUB.jsp 
			temp = session.createQuery("select f.field from FieldInfo as f")
					.list();
			for(int i=0;i<temp.size();i++){
				t=temp.get(i).toString();
				field.add(new LabelValueBean(t,t));
			}
			servlet.getServletContext().setAttribute(TeaConstants.OPTION_FIELD, field);

			
			// to get "property" for the Struts label in the fillSUB.jsp 
			temp = session.createQuery("select p.property from PropertyInfo as p")
					.list();
			for(int i=0;i<temp.size();i++){
				t=temp.get(i).toString();
				property.add(new LabelValueBean(t,t));
			}
			servlet.getServletContext().setAttribute(TeaConstants.OPTION_PROPERTY,property);
			
			// to get "source" for the Struts label in the fillSUB.jsp 
			temp = session.createQuery("select s.source from SourceInfo as s")
					.list();
			for(int i=0;i<temp.size();i++){
				t=temp.get(i).toString();
				source.add(new LabelValueBean(t,t));
			}
			servlet.getServletContext().setAttribute(TeaConstants.OPTION_SOURCE,source);
			
			// to get "type" for the Struts label in the fillSUB.jsp 
			temp = session.createQuery("select t.type from TypeInfo as t")
					.list();
			for(int i=0;i<temp.size();i++){
				t=temp.get(i).toString();
				type.add(new LabelValueBean(t,t));
			}
			servlet.getServletContext().setAttribute(TeaConstants.OPTION_TYPE,type);
				
			
			// to get "teacherOptions" for the label in the ShowAllSub.jsp
			Map m = new HashMap();
			temp=session.createQuery("select t.teacherId,t.teacherName from TeacherInfo as t")
			.list();
			for(int i=0;i<temp.size();i++){
				Object[] object = (Object[]) temp.get(i);
				m.put(object[0].toString(), object[1].toString());
				teacherOption.add(new LabelValueBean(object[1].toString(),object[0].toString()));
			}
			servlet.getServletContext().setAttribute(TeaConstants.TEACHER_NAME_ID_MAP, m); // for the show in table need name
			servlet.getServletContext().setAttribute(TeaConstants.OPTION_TEACHER,teacherOption);
			
			// generate years from an initial value to current year
			java.sql.Date d=new java.sql.Date(new java.util.Date().getTime());
			int year=d.getYear()+1900;
			for(int i=2005;i<=year;i++){
				t=String.valueOf(i);
				subjectYears.add(new LabelValueBean(t,t));
			}
			servlet.getServletContext().setAttribute(TeaConstants.OPTION_YEAR, subjectYears);
			
        }catch(Exception e){
        	if(tx!=null){ tx.rollback(); }
        	e.printStackTrace();
        }finally{
        	session.close();
        }
	}

}
