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
import org.chd.entity.LevelA;
import org.chd.entity.LevelAId;
import org.chd.entity.SubjectInfo;
import org.chd.entity.TeacherInfo;
import org.chd.tea.TeaConstants;
import org.chd.tea.struts.form.PsForm;
import org.hibernate.Session;
import org.hibernate.Transaction;
  
/** 
 * MyEclipse Struts
 * Creation date: 04-23-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class PsGetAction extends Action {

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
		hs.removeAttribute(TeaConstants.PS_MYALL);
		Session s = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			form = new PsForm();
			request.setAttribute(mapping.getAttribute(),form);
		    String str_subId = request.getParameter("subId");
			int subid = Integer.parseInt(str_subId);
			hs.setAttribute(TeaConstants.SUB_ID,str_subId);
			

			TeacherInfo tea = (TeacherInfo) hs.getAttribute(MisConstants.TEACHERINFO_KEY);
			String teaId = tea.getTeacherId();
			
			LevelAId levid = new LevelAId();
			levid.setSubjectId(subid);
			levid.setTeacherId(teaId);
			LevelA level = (LevelA)s.get(LevelA.class,levid);

			SubjectInfo sub = (SubjectInfo)s.get(SubjectInfo.class,new Integer(subid));
			hs.setAttribute(TeaConstants.SUB_NAME,sub.getSubject());
			System.out.println(sub.getIntroduction());
			if(sub.getIntroduction()==null){
				hs.setAttribute(TeaConstants.SUB_INFO,"无难题说明");
			}else{
				hs.setAttribute(TeaConstants.SUB_INFO,sub.getIntroduction());	
			}
			
			if(level!=null){
				PsForm ps = (PsForm)form;
				ps.setGrade(level.getGrade());
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



