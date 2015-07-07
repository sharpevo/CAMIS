//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;


import org.apache.commons.beanutils.PropertyUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.chd.tea.TeaConstants;
import org.chd.tea.struts.form.TeaInfoForm;
import org.chd.entity.TeacherInfo;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.chd.HibernateSessionFactory;
import org.chd.MisConstants;
import org.hibernate.Session;
import org.hibernate.Transaction;

/** 
 * MyEclipse Struts
 * Creation date: 04-12-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class ModifyTeaAction extends Action {
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
		Transaction tx =null;
		try{
			tx= s.beginTransaction();
			form = new TeaInfoForm();
			request.setAttribute(mapping.getAttribute(), form);
			TeaInfoForm uf = (TeaInfoForm) form;
			TeacherInfo tea = (TeacherInfo) hs.getAttribute(MisConstants.TEACHERINFO_KEY);
			PropertyUtils.copyProperties(uf,tea);
			saveToken(request);
			tx.commit();
		}catch(Exception e){
			if(tx!=null){tx.rollback();}
			e.printStackTrace();
			return mapping.findForward("failure");
		}finally{
			s.close();
		}
		return mapping.findForward("suc");
	}

}

