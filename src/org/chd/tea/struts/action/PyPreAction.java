//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.chd.HibernateSessionFactory;
import org.chd.MisConstants;
import org.chd.entity.TeacherInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;

/** 
 * MyEclipse Struts
 * Creation date: 04-21-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class PyPreAction extends Action {

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
		/*HttpSession hs = request.getSession();
		Session s = HibernateSessionFactory.getSession();
		TeacherInfo teacher = (TeacherInfo) hs.getAttribute(MisConstants.TEACHERINFO_KEY);
		// hard code
		if(!"评阅".equals(teacher.getRoleName())
				||!"答辩".equals(teacher.getRoleName())
				||!"秘书".equals(teacher.getRoleName())){
			return mapping.findForward("illegalRole");
		}
		Transaction tx = null;
		try{
			tx=s.beginTransaction();
			java.sql.Date d=new java.sql.Date(new java.util.Date().getTime());
			int year=d.getYear()+1900;
			
		}catch(Exception e){
			if(tx!=null){ tx.rollback(); }
			e.printStackTrace();
			return mapping.findForward("failure");
		}finally{
			s.close();
		}*/
		saveToken(request);
		return mapping.findForward("suc");
	}

}

