//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;
import org.chd.tea.TeaConstants;
import org.chd.tea.struts.form.SendMailForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.chd.entity.StudentInfo;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.chd.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/** 
 * MyEclipse Struts
 * Creation date: 04-20-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class WriteMailAction extends Action {

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

		Session s = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			form = new SendMailForm();
			request.setAttribute(mapping.getAttribute(), form);
			SendMailForm sf = (SendMailForm) form;
			String id = request.getParameter("studentId");
			StudentInfo stu = (StudentInfo) s.get(StudentInfo.class,new String(id));
			sf.setEmail(stu.getStudentEmail());
			saveToken(request);
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

