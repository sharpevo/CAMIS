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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.DynaValidatorForm;
import org.chd.HibernateSessionFactory;
import org.chd.entity.StudentInfo;
import org.chd.entity.SubjectInfo;
import org.chd.entity.TablePY;
import org.chd.entity.TeacherInfo;
import org.chd.MisConstants;
import org.hibernate.Session;
import org.hibernate.Transaction;
/** 
 * MyEclipse Struts
 * Creation date: 12-16-2006
 * 
 * XDoclet definition:
 * @struts.action path="/py" name="pyForm" input="/py.jsp" scope="request" validate="true"
 * @struts.action-forward name="suc" path="/aaa.jsp" redirect="true"
 */
public class PyAction extends Action {
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
		HttpServletResponse response){
       
		if(isTokenValid(request,true)){
			if (isCancelled(request)) {
				return mapping.findForward("suc");
			}
			DynaValidatorForm df=(DynaValidatorForm) form;
			Session s = HibernateSessionFactory.getSession();
			Transaction tx =null;
			HttpSession hs = request.getSession();
			hs.removeAttribute(TeaConstants.SUB_NAME);
			hs.removeAttribute(TeaConstants.SUB_INFO);
			try{
				tx =s.beginTransaction();
				
				TeacherInfo tea = (TeacherInfo) hs.getAttribute(MisConstants.TEACHERINFO_KEY);
				String teaId = tea.getTeacherId();
				
				int subId = Integer.parseInt(hs.getAttribute(TeaConstants.SUB_ID).toString());
				hs.removeAttribute(TeaConstants.SUB_ID);
				
				java.sql.Date date = new java.sql.Date((new java.util.Date()).getTime());
				
				TablePY py=(TablePY) s.get(TablePY.class,new Integer(subId));
				if (py==null){
					py =new TablePY();
					py.setSubjectId(subId);
				}
				py.setAchievement(Float.parseFloat(df.get("achievement").toString()));
				py.setAddDate(date);
				py.setArgumentation(Float.parseFloat(df.get("argumentation").toString()));
				py.setDesign(Float.parseFloat(df.get("design").toString()));
				py.setDesignSpecification(Float.parseFloat(df.get("designSpecification").toString()));
				py.setInnovation(Float.parseFloat(df.get("innovation").toString()));
				py.setComment(df.get("comment").toString());
				py.setTranslating(Float.parseFloat(df.get("translating").toString()));
				py.setTeacherId(teaId);
				resetToken(request);
				s.saveOrUpdate(py);
				
				SubjectInfo subject = (SubjectInfo)s.get(SubjectInfo.class, new Integer(subId));
				Float markPY = py.getAchievement()+py.getArgumentation()+py.getDesign()+py.getDesignSpecification()+py.getInnovation()+py.getTranslating();
				subject.setMarkPY(markPY);
				s.update(subject);
				
				tx.commit();
			}catch(Exception e){
				if(tx!=null){ tx.rollback(); }
				e.printStackTrace();
				return mapping.findForward("failure");
			}finally{
				s.close();
			}
			
			StudentInfo stu = (StudentInfo)hs.getAttribute(TeaConstants.STU_INFO);
			hs.removeAttribute(TeaConstants.STU_INFO);
			
			ActionMessages message = new ActionMessages();
			ActionMessage msg = new ActionMessage("msg.pySUC",stu.getStudentId(),stu.getStudentName());
			message.add(ActionMessages.GLOBAL_MESSAGE,msg);
			this.saveMessages(request,message);
			return mapping.findForward("suc");
        }else{
        	ActionErrors errors = new ActionErrors();
        	errors.add("submitagain",new ActionError("error.submitagain"));
        	this.saveErrors(request,errors);
        	saveToken(request);
        	return mapping.getInputForward();
        }
	}
}
