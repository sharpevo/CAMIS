//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.chd.tea.TeaConstants;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.chd.HibernateSessionFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.chd.entity.Requirement;
import org.chd.entity.SubjectInfo;
import org.chd.entity.TeacherInfo;
import org.chd.MisConstants;
import org.chd.tea.DisplayTagPagination;




/** 
 * MyEclipse Struts
 * Creation date: 04-11-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class ShowMySubAction extends Action {
	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) {
		Session s = HibernateSessionFactory.getSession();
		HttpSession hs = request.getSession();
		Transaction tx = null;
		
		// clear
		hs.removeAttribute(TeaConstants.SUB_ID); // from sub series
		hs.removeAttribute(TeaConstants.SUB_NAME); // from Sub series
		hs.removeAttribute(TeaConstants.REQ_INFO); // from reviewREQ.jsp
		hs.removeAttribute(TeaConstants.REQ_IS_VALID); // from Sub series
		
		try{
			tx = s.beginTransaction();
			List subInfoList = new ArrayList();
			Map m = new HashMap();
			
			
			
			TeacherInfo tea = (TeacherInfo) hs.getAttribute(MisConstants.TEACHERINFO_KEY);
			String teaId = tea.getTeacherId();
			java.sql.Date d=new java.sql.Date(new java.util.Date().getTime());
			int year=d.getYear()+1900;
			
			DisplayTagPagination displayTagPagination=(DisplayTagPagination) hs.getAttribute(TeaConstants.CURRENT_LIST_OBJECT);
			if(displayTagPagination == null){
				hs.removeAttribute(TeaConstants.SUB_INFO_LIST);
				displayTagPagination = new DisplayTagPagination(5,
									"select s.subjectId,s.subject,s.fieldName,s.propertyName,s.sourceName,s.typeName,s.difficulty,s.excellentTag," +
										"CASE " +
										"WHEN s.subjectId=(select r.subjectId from org.chd.entity.Requirement r where r.subjectId = s.subjectId) " +
											"THEN '查看任务书' " +
											"ELSE '填写' " +
											"END  " +
										"from SubjectInfo s " +
										"where s.teacherAId=:teaId and s.years=:thisyear")
									.setParameter("teaId", new String(teaId))// must equals to displaytag pagesize
									.setParameter("thisyear",new Integer(year));
			}
			subInfoList = displayTagPagination.getList(request);
			int j=0;
			for(Object o:subInfoList){
				System.out.print(j+": ");
				System.out.println(o);
				j++;
			}
			System.out.println("------------------------");
			hs.setAttribute(TeaConstants.CURRENT_LIST_OBJECT, displayTagPagination);
			List result = new ArrayList();
			// format
			for(int i=0;i<subInfoList.size();i++){
				Object[] object = (Object[]) subInfoList.get(i);
				if(object == null){
					result.add(m);
					continue;
				}
				System.out.println(object.length);
				m = new HashMap();
				m.put("subjectId",object[0]);
				m.put("subject",object[1]);
				m.put("fieldName",object[2]);
				m.put("propertyName",object[3]);
				m.put("sourceName",object[4]);
				m.put("typeName",object[5]);
				m.put("difficulty",object[6]);
				if(Boolean.parseBoolean(object[7].toString())){
					m.put("excellentTag","是");
				}else{
					m.put("excellentTag","否");
				}
				m.put("case", object[8]);
				result.add(m);
			}
			hs.removeAttribute(TeaConstants.SUB_INFO_LIST);
			hs.setAttribute(TeaConstants.SUB_INFO_LIST,result);
			tx.commit();

        }catch(Exception e){
        	if(tx!=null){ tx.rollback(); }
        	e.printStackTrace();
        	return mapping.findForward("failure");
        }finally{
        	s.close();
        }
		return mapping.findForward("suc");
	}
	

}

