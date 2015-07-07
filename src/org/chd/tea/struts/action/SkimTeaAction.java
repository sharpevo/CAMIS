//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.chd.entity.TeacherInfo;
import org.chd.tea.TeaConstants;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.chd.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/** 
 * MyEclipse Struts
 * Creation date: 12-20-2006
 * 
 * XDoclet definition:
 * @struts.action path="/skimTea" name="skimTeaForm" input="/skimTea.jsp" scope="request" validate="true"
 * @struts.action-forward name="suc" path="dd" redirect="true"
 */
public class SkimTeaAction extends Action {
	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws UnsupportedEncodingException 
	 */
	@Override
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) throws UnsupportedEncodingException {
		
		Session s = HibernateSessionFactory.getSession();
		HttpSession hs = request.getSession();
		Transaction tx =null;
		try{
			tx =s.beginTransaction();
			String teaId = request.getParameter("teaId");
			TeacherInfo tea = (TeacherInfo)s.get(TeacherInfo.class,new String(teaId));
			request.setAttribute(TeaConstants.TEA_INFO,tea);
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

