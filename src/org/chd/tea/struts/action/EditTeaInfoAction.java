//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.chd.HibernateSessionFactory;
import org.chd.entity.TeacherInfo;
import org.chd.tea.TeaConstants;
import org.chd.tea.struts.form.TeaInfoForm;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.chd.MisConstants;
/** 
 * MyEclipse Struts
 * Creation date: 04-18-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class EditTeaInfoAction extends DispatchAction {
	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
    public ActionForward updateProperty(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)throws Exception {

		if (isCancelled(request)) {
			resetToken(request);
			return mapping.findForward("suc");
		}
    	TeaInfoForm tf= (TeaInfoForm) form;
		Session s = HibernateSessionFactory.getSession();
		HttpSession hs = request.getSession();
		Transaction tx =null;
		if(isTokenValid(request,true)){
			try{
				tx =s.beginTransaction();
				
				TeacherInfo tea = (TeacherInfo) hs.getAttribute(MisConstants.TEACHERINFO_KEY);
				tf.setTeacherPassword(tea.getTeacherPassword());
				PropertyUtils.copyProperties(tea,tf);

				
				ActionMessages msg = new ActionMessages();
				msg.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("msg.TEAsuc"));
				this.saveMessages(request,msg);
				resetToken(request);
				
				s.update(tea);
				resetToken(request);
				tx.commit();
			}catch(Exception e){
				if(tx!=null){tx.rollback();}
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
    
    
    public ActionForward updatePassword(
    	ActionMapping mapping,
    	ActionForm form,
    	HttpServletRequest request,
    	HttpServletResponse response)throws Exception{
		if (isCancelled(request)) {
			
			return mapping.findForward("suc");
		}
    	TeaInfoForm tf = (TeaInfoForm) form;
		Session s = HibernateSessionFactory.getSession();
		Transaction tx =null;
		HttpSession hs = request.getSession();
		if(isTokenValid(request,true)){
			try{
				tx =s.beginTransaction();
				TeacherInfo tea = (TeacherInfo) hs.getAttribute(MisConstants.TEACHERINFO_KEY);
				
				String psw = tea.getTeacherPassword();
				
				String ori = tf.getTeacherPassword();
				String newP = tf.getNewPSW();
				String cfm = tf.getConfirmPSW();
				

				
				if(ori.equals(psw) && newP.equals(cfm)){
					tea.setTeacherPassword(newP);
					ActionMessages msg = new ActionMessages();
					msg.add("",new ActionMessage("msg.PSWsuc"));
					this.saveMessages(request,msg);
					resetToken(request);
					s.update(tea);
					tx.commit();
					return mapping.findForward("suc");
				}else{
					ActionErrors warning = new ActionErrors();
					warning.add("wrongPSW",new ActionError("error.wrongPSW"));
					this.saveErrors(request,warning);
					saveToken(request);
					return mapping.getInputForward();
				}
				
			}catch(Exception e){
				tx.rollback();
				e.printStackTrace();
				return mapping.findForward("failure");
			}finally{
				s.close();
			}
			
		}else{
			ActionErrors errors=new ActionErrors();
			errors.add("submitagain",new ActionError("error.submitagain"));
	        this.saveErrors(request,errors);
	        saveToken(request);
	        return mapping.getInputForward();
		}
    	
    }

}

