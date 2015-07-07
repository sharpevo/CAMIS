//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;

import java.io.UnsupportedEncodingException;

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
import org.chd.MisConstants;
import org.chd.entity.StudentInfo;
import org.chd.entity.SubjectInfo;
import org.chd.entity.TableDB; 
import org.chd.entity.TeacherInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;
/** 
 * MyEclipse Struts
 * Creation date: 12-17-2006
 * 
 * XDoclet definition:
 * @struts.action path="/db" name="dbForm" input="/db.jsp" scope="request" validate="true"
 * @struts.action-forward name="suc" path="/dbSuc.jsp" redirect="true"
 */
public class DbAction extends Action {
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
		
		if(isTokenValid(request,true)){		

			if (isCancelled(request)) {
				return mapping.findForward("suc");
			}
			DynaValidatorForm df=(DynaValidatorForm) form;
			Session s = HibernateSessionFactory.getSession();
			Transaction tx =null;
			HttpSession hs = request.getSession();
			hs.removeAttribute(TeaConstants.SUB_NAME);
			try{
				tx =s.beginTransaction();
				
				TeacherInfo tea = (TeacherInfo) hs.getAttribute(MisConstants.TEACHERINFO_KEY);
				String teaId = tea.getTeacherId();
				
				int subId = Integer.parseInt(hs.getAttribute(TeaConstants.SUB_ID).toString());
				hs.removeAttribute(TeaConstants.SUB_ID);
				
				java.sql.Date date = new java.sql.Date((new java.util.Date()).getTime());
				
				TableDB db=(TableDB) s.get(TableDB.class,new Integer(subId));
				if (db==null){
					db =new TableDB();
					db.setSubjectId(subId);
				}
				db.setAchievement(Float.parseFloat(df.get("achievement").toString()));
				db.setAddDate(date);
				db.setComment(df.get("comment").toString());
				db.setInnovation(Float.parseFloat(df.get("innovation").toString()));
				db.setReply(Float.parseFloat(df.get("reply").toString()));
				db.setTeacherId(teaId);
				db.setVerbalReport(Float.parseFloat(df.get("verbalReport").toString()));
				db.setWorkLoad(Float.parseFloat(df.get("workLoad").toString()));
				
				resetToken(request);
				s.saveOrUpdate(db);
				
				SubjectInfo subject = (SubjectInfo)s.get(SubjectInfo.class, new Integer(subId));
				Float markDB = db.getAchievement()+db.getInnovation()+db.getReply()+db.getVerbalReport()+db.getWorkLoad();
				subject.setMarkDB(markDB);
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

