//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;

import org.apache.commons.beanutils.PropertyUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.chd.tea.TeaConstants;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.chd.HibernateSessionFactory;
import org.chd.entity.Requirement;
import org.chd.entity.SubjectInfo;
import org.chd.entity.TeacherInfo;
import org.chd.MisConstants;
import org.chd.tea.struts.form.SubjectForm;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/** 
 * MyEclipse Struts
 * Creation date: 04-21-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class SubjectInfoAction extends DispatchAction {

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
	public ActionForward saveOrUpdate(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)throws Exception {

		Session s = HibernateSessionFactory.getSession();
		HttpSession hs = request.getSession();
		hs.removeAttribute(TeaConstants.CURRENT_LIST_OBJECT);
		Transaction tx = null;
		if (isCancelled(request)) {
			resetToken(request);
			return mapping.findForward("cancel");
		}
		
		if(isTokenValid(request,true)){
			try{
				tx = s.beginTransaction();
				SubjectForm subForm = (SubjectForm) form;
				int year=0;
				int sid=0;


				TeacherInfo tea  = (TeacherInfo) hs.getAttribute(MisConstants.TEACHERINFO_KEY);
				String teaAid = tea.getTeacherId();
				
				/*search the POST of teacher*/
				Query query = s.createQuery("select t.post from TeacherInfo as t where t.teacherId=:id ")
								.setString("id",teaAid);
				String post = (String) query.uniqueResult();
				
				java.sql.Date d=new java.sql.Date(new java.util.Date().getTime());
				year=d.getYear()+1900;
				
				SubjectInfo sub = new SubjectInfo();
				
				// does this request come from Modify Actions?
				if (hs.getAttribute(TeaConstants.SUB_ID)!=null){
					String str_subId = hs.getAttribute(TeaConstants.SUB_ID).toString();
					sid=Integer.parseInt(str_subId);
					sub=(SubjectInfo) s.get(SubjectInfo.class,new Integer(sid));
					
					// has the requirement of this subject submitted?
					Requirement reqquery = (Requirement)s.get(Requirement.class,new Integer(sid));
					
					if(reqquery!=null){
						
						request.setAttribute(TeaConstants.REQ_IS_VALID,reqquery);
					}
				}

				PropertyUtils.copyProperties(sub,subForm);
				
				// the data subForm doesnot provide
				sub.setTeacherAId(teaAid);
				sub.setTeacherAPost(post);
				sub.setYears(year);

				request.setAttribute(TeaConstants.SUB_INFO,sub);
				
				// clear the Token in request scope
				resetToken(request);
				s.saveOrUpdate(sub);
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
	
	public ActionForward delete(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)throws Exception {
			
			Session s = HibernateSessionFactory.getSession();
			HttpSession hs = request.getSession();
			
			// " showMySub.jsp "
			hs.removeAttribute(TeaConstants.CURRENT_LIST_OBJECT);
			Transaction tx = s.beginTransaction();
			try{
				s.beginTransaction();
				int id =Integer.parseInt(request.getParameter(TeaConstants.SUB_ID));   
				SubjectInfo sub = (SubjectInfo) s.get(SubjectInfo.class,new Integer(id));
				Requirement req = (Requirement) s.get(Requirement.class,new Integer(id));
				
				// we cannot delete the requirement which does not exist
				if(req!=null){
					s.delete(req);
				}
				hs.removeAttribute(TeaConstants.CURRENT_LIST_OBJECT);
				s.delete(sub);
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

