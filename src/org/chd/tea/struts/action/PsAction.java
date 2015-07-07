//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.chd.tea.TeaConstants;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.chd.HibernateSessionFactory;
import org.chd.MisConstants;
import org.chd.entity.LevelA;
import org.chd.entity.LevelAId;
import org.chd.entity.TeacherInfo;
import org.chd.tea.struts.form.PsForm;
import org.hibernate.Session;
import org.hibernate.Transaction;
/** 
 * MyEclipse Struts
 * Creation date: 12-20-2006
 * 
 * XDoclet definition:
 * @struts.action path="/ps" name="psForm" input="/psSuc.jsp" scope="request" validate="true"
 * @struts.action-forward name="suc" path="sss" redirect="true"
 */
public class PsAction extends Action {

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
		
		if(isTokenValid(request,true)){
			PsForm psForm = (PsForm) form;
			HttpSession hs = request.getSession();
			hs.removeAttribute(TeaConstants.SUB_INFO);
			hs.removeAttribute(TeaConstants.SUB_NAME);
			Session s = HibernateSessionFactory.getSession();
			Transaction tx = null;
			try{
				tx = s.beginTransaction();
			    String str_subId = hs.getAttribute(TeaConstants.SUB_ID).toString();
			    hs.removeAttribute(TeaConstants.SUB_ID);
				int subid = Integer.parseInt(str_subId);
				


				TeacherInfo tea = (TeacherInfo) hs.getAttribute(MisConstants.TEACHERINFO_KEY);
				String teaId = tea.getTeacherId();
				LevelAId levid = new LevelAId();
				levid.setSubjectId(subid);
				levid.setTeacherId(teaId);
				LevelA level = (LevelA)s.get(LevelA.class,levid);
				if(level==null){
					level = new LevelA();
					level.setId(levid);
				}
				String grade = psForm.getGrade();
				level.setGrade(grade);
				s.saveOrUpdate(level);
				resetToken(request);
				tx.commit();
			}catch(Exception e){
				if(tx!=null){ tx.rollback(); }
				e.printStackTrace();
				return mapping.findForward("failure");
			}finally{
				s.close();
			}
			return mapping.findForward("suc");
		}else{
			ActionErrors errors=new ActionErrors();
			errors.add("submitagain",new ActionError("error.submitagain"));
	        this.saveErrors(request,errors);
	        saveToken(request);
	        return mapping.getInputForward();
		}	
		
	}

}

