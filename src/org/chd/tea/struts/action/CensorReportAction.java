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
  
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.chd.HibernateSessionFactory;
import org.chd.entity.OpeningReport;
import org.chd.entity.TeacherInfo;
import org.chd.tea.TeaConstants;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.chd.MisConstants;
/** 
 * MyEclipse Struts
 * Creation date: 04-19-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class CensorReportAction extends Action {


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

		HttpSession hs = request.getSession();
		Session s = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try{
			tx = s.beginTransaction();

			TeacherInfo tea = (TeacherInfo)hs.getAttribute(MisConstants.TEACHERINFO_KEY);
			String teaId = tea.getTeacherId();
			
			// DisplayTag turn a page
			if(hs.getAttribute(TeaConstants.CS_MYALL)!=null){
				return mapping.findForward("suc");
			}
			
			
			
			List list = new ArrayList();
			List infolist = null;
			infolist = s.createQuery("select s.studentId,stu.studentName,stu.studentEmail " +
							"from SubjectInfo as s,StudentInfo as stu where s.teacherAId=:teaId and s.studentId=stu.studentId")
			  				.setString("teaId",teaId)
			  				.list();
			
			if(infolist.isEmpty()){
				ActionErrors errors=new ActionErrors();
					errors.add("no",new ActionError("error.noStudent"));
				this.saveErrors(request,errors);
				return mapping.findForward(mapping.getInput());
			}else{
				for(int i=0;i<infolist.size();i++){
					Map m = new HashMap();
					Object[] infob=(Object[])infolist.get(i);
					String id=(String)infob[0];

					m.put(TeaConstants.STU_ID,infob[0]);
					m.put(TeaConstants.STU_NAME,infob[1]);
					OpeningReport or =new OpeningReport();
					or=(OpeningReport)s.get(OpeningReport.class,new String(id)); 
					StringBuffer isReportValid=new StringBuffer("<a href=\"/tea/reportDetail.do?stuId=");
					isReportValid.append(infob[0].toString());

					isReportValid.append("\"/>查看开题报告</a>");
					if(or!=null){
						m.put(TeaConstants.REPORT_IS_VALID,isReportValid.toString());
					}else{
						m.put(TeaConstants.REPORT_IS_VALID,"尚未提交");
					}
					list.add(m);

				}
				hs.removeAttribute(TeaConstants.CS_MYALL);
				hs.setAttribute(TeaConstants.CS_MYALL,list);
				saveToken(request);
			}
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

