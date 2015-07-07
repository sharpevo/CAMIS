//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.DynaValidatorActionForm;
import org.chd.HibernateSessionFactory;
import org.chd.entity.StudentInfo;
import org.chd.entity.SubjectInfo;
import org.chd.entity.TablePY;
import org.chd.tea.TeaConstants;
import org.hibernate.Session;
import org.hibernate.Transaction;

/** 
 * MyEclipse Struts
 * Creation date: 04-20-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class ExaminePYAction extends Action {

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
		Transaction tx =null;
		HttpSession hs = request.getSession();
		
		try{
			tx =s.beginTransaction();
			DynaValidatorActionForm df =  (DynaValidatorActionForm) form;
			df.initialize(mapping);
			String str_subId = hs.getAttribute(TeaConstants.SUB_ID).toString();
			int subId = Integer.parseInt(str_subId);
			TablePY tpy=(TablePY)s.get(TablePY.class,new Integer(subId));
			df.set("comment",tpy.getComment());
			df.set("achievement",String.valueOf(tpy.getAchievement()));
			df.set("argumentation",String.valueOf(tpy.getArgumentation()));
			df.set("translating",String.valueOf(tpy.getTranslating()));
			df.set("design",String.valueOf(tpy.getDesign()));
			df.set("designSpecification",String.valueOf(tpy.getDesignSpecification()));
			df.set("innovation",String.valueOf(tpy.getInnovation()));
			request.setAttribute(mapping.getAttribute(), form);
			
			StudentInfo stu = (StudentInfo)hs.getAttribute(TeaConstants.STU_INFO);
			ActionMessages message = new ActionMessages();
			ActionMessage msg = new ActionMessage("msg.beScored",stu.getStudentId(),stu.getStudentName());
			message.add(ActionMessages.GLOBAL_MESSAGE,msg);
			this.saveMessages(request,message);

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

