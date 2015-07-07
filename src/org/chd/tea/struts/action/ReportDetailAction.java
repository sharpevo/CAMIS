//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.chd.HibernateSessionFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.chd.tea.TeaConstants;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.chd.entity.OpeningReport;
import org.hibernate.Session;
import org.hibernate.Transaction;

/** 
 * MyEclipse Struts
 * Creation date: 04-20-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class ReportDetailAction extends Action {

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
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) {

		HttpSession hs = request.getSession();
		hs.removeAttribute(TeaConstants.CS_MYALL);
		Session s = HibernateSessionFactory.getSession();
		Transaction tx= null;
		try{
		tx=s.beginTransaction();
		
		String stuId = request.getParameter("stuId");
		if(stuId==null ||stuId.equals("")){
			stuId = hs.getAttribute(TeaConstants.STU_ID).toString();
		}
		hs.removeAttribute(TeaConstants.STU_ID);
		hs.setAttribute(TeaConstants.STU_ID, stuId);
		String stuName = s.createQuery("select s.studentName from StudentInfo as s where s.studentId=:stuId")
							.setString("stuId",stuId)
							.uniqueResult()
							.toString();
		hs.setAttribute(TeaConstants.STU_NAME,stuName); // for send mail
		OpeningReport or = (OpeningReport)s.get(OpeningReport.class,new String(stuId));
		
		Map m = new HashMap();
		m.put("studentId",stuId);

		m.put("content",or.getContent());
		request.setAttribute(TeaConstants.CS_REPORT_DETAIL,m);

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

