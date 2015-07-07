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
import org.chd.MisConstants;
import org.chd.entity.StudentInfo;
import org.chd.entity.SubjectInfo;
import org.chd.entity.TableZD;
import org.chd.entity.TeacherInfo;


import org.hibernate.Session;
import org.hibernate.Transaction;


/** 
 * MyEclipse Struts
 * Creation date: 12-16-2006
 * 
 * XDoclet definition:
 * @struts.action path="/zdPre" name="zdPreForm" input="/fst.jsp" scope="request" validate="true"
 * @struts.action-forward name="suc" path="/zdPre.jsp" redirect="true"
 */
public class ZdPreAction extends Action {

	// --------------------------------------------------------- Instance Variables
	
	// --------------------------------------------------------- Methods

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	@Override
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) {

		
		HttpSession hs = request.getSession();
		
		// DisplayTag turn a new Page
		if(hs.getAttribute(TeaConstants.ZD_MYALL)!=null){
			return mapping.findForward("suc");
		}
		Session s = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			java.sql.Date d=new java.sql.Date(new java.util.Date().getTime());
			int year=d.getYear()+1900;
			TeacherInfo tea = (TeacherInfo) hs.getAttribute(MisConstants.TEACHERINFO_KEY);
			String teaId = tea.getTeacherId();
			
			String subId = "", stuId = "";
			StringBuffer link = null;
			Map m = new HashMap();
			List list = new ArrayList();
			List subList = s.createQuery("from SubjectInfo as s where s.teacherAId=:teaId and s.years=:year")
							.setString("teaId",teaId)
							.setInteger("year",year)
							.list();
			hs.setAttribute("list",subList);
			SubjectInfo sub = new SubjectInfo();
			StudentInfo stu = new StudentInfo();
			for(int i=0;i<subList.size();i++){
				sub = (SubjectInfo) subList.get(i);
				System.out.println(sub.getStudentId());
				m = new HashMap();

				link = new StringBuffer("<a href=\"/tea/zdGet.do?subjectId=");
				if(sub.getStudentId()!=null){
					stu = (StudentInfo) s.get(StudentInfo.class,new String(sub.getStudentId()));
					subId=sub.getSubjectId().toString();
					stuId=stu.getStudentId();
					TableZD tzd = (TableZD)s.get(TableZD.class,new Integer(Integer.parseInt(subId)));
					if(tzd!=null){
						link.insert(0,"<font color=\"blue\">已评阅-</font>");
						link.append(subId+"&studentId="+stuId+"\">修改</a>");
					}else{
						link.append(subId+"&studentId="+stuId+"\">评阅论文</a>");
					}
					
					m.put("studentId",stu.getStudentId());
					m.put("studentName",stu.getStudentName());

					m.put("link",link);
					list.add(m);
				}
			}

			hs.setAttribute(TeaConstants.ZD_MYALL,list);
			saveToken(request);
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

