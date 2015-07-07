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
import org.apache.struts.validator.DynaValidatorActionForm;
import org.chd.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.chd.entity.StudentInfo;
import org.chd.entity.SubjectInfo;
import org.chd.entity.TableZD;
import org.chd.tea.TeaConstants;
/** 
 * MyEclipse Struts
 * Creation date: 04-22-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class ZdGetAction extends Action {

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
		hs.removeAttribute(TeaConstants.ZD_MYALL);
		Session s = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try{
			tx=s.beginTransaction();
			String str_subId = request.getParameter("subjectId");
			String stuId = request.getParameter("studentId");
			int subId = Integer.parseInt(str_subId);
			SubjectInfo sub = (SubjectInfo)s.get(SubjectInfo.class,new Integer(subId));
			hs.setAttribute(TeaConstants.SUB_NAME,sub.getSubject());
			hs.setAttribute(TeaConstants.SUB_ID,sub.getSubjectId()); // ZdScoreAction
			StudentInfo stu = (StudentInfo)s.get(StudentInfo.class,new String(stuId));
			hs.setAttribute(TeaConstants.STU_INFO,stu);
			TableZD tzd = (TableZD)s.get(TableZD.class,new Integer(subId));
			if(tzd!=null){
				DynaValidatorActionForm df =  (DynaValidatorActionForm) form;
				df.set("argumentation",String.valueOf(tzd.getArgumentation()));
				df.set("translating",String.valueOf(tzd.getTranslating()));
				df.set("design",String.valueOf(tzd.getDesign()));
				df.set("designSpecification",String.valueOf(tzd.getDesignSpecification()));
				df.set("innovation",String.valueOf(tzd.getInnovation()));
				df.set("comment",tzd.getComment());
				df.set("workLoad",String.valueOf(tzd.getWorkLoad()));
				df.set("tag",tzd.getTag());
				request.setAttribute(mapping.getAttribute(), form);
			}
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

