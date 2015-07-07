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
import org.apache.struts.validator.DynaValidatorForm;
import org.chd.HibernateSessionFactory;
import org.chd.MisConstants;
import org.chd.entity.SubjectInfo;
import org.chd.entity.TableZD;
import org.chd.entity.TeacherInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;
/** 
 * MyEclipse Struts
 * Creation date: 12-16-2006
 * 
 * XDoclet definition:
 * @struts.action path="/zdScore" name="zdScoreForm" input="/zdPre.jsp" scope="request" validate="true"
 * @struts.action-forward name="suc" path="aaa" redirect="true"
 */
public class ZdScoreAction extends Action {
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
			if (isCancelled(request)) {
				return mapping.findForward("suc");
			}
			DynaValidatorForm df=(DynaValidatorForm) form;
			Session s = HibernateSessionFactory.getSession();
			Transaction tx =null;
			HttpSession hs = request.getSession();
			hs.removeAttribute(TeaConstants.STU_INFO);
			hs.removeAttribute(TeaConstants.SUB_NAME);
			try{
				tx = s.beginTransaction();
		
				TeacherInfo tea = (TeacherInfo) hs.getAttribute(MisConstants.TEACHERINFO_KEY);
				String teaId = tea.getTeacherId();
				
				int subId = Integer.parseInt(hs.getAttribute(TeaConstants.SUB_ID).toString());
				hs.removeAttribute(TeaConstants.SUB_ID); // terminal his life
				java.sql.Date date = new java.sql.Date((new java.util.Date()).getTime());
				
				TableZD tzd=(TableZD) s.get(TableZD.class,new Integer(subId));
				if (tzd==null){
					tzd =new TableZD();
					tzd.setSubjectId(subId);
				}
				tzd.setTag(Boolean.parseBoolean(df.get("tag").toString()));
				tzd.setWorkLoad(Float.parseFloat(df.get("workLoad").toString()));
				tzd.setAddDate(date);
				tzd.setArgumentation(Float.parseFloat(df.get("argumentation").toString()));
				tzd.setDesign(Float.parseFloat(df.get("design").toString()));
				tzd.setDesignSpecification(Float.parseFloat(df.get("designSpecification").toString()));
				tzd.setInnovation(Float.parseFloat(df.get("innovation").toString()));
				tzd.setComment(df.get("comment").toString());
				tzd.setTranslating(Float.parseFloat(df.get("translating").toString()));
				tzd.setTeacherId(teaId);
				resetToken(request);
				s.saveOrUpdate(tzd);
				
				SubjectInfo subject = (SubjectInfo)s.get(SubjectInfo.class, new Integer(subId));
				Float markZD = tzd.getArgumentation()+tzd.getDesign()+tzd.getDesignSpecification()+tzd.getInnovation()+tzd.getTranslating()+tzd.getWorkLoad();
				subject.setMarkZD(markZD);
				s.update(subject);
				
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
        	ActionErrors errors = new ActionErrors();
        	errors.add("submitagain",new ActionError("error.submitagain"));
        	this.saveErrors(request,errors);
        	saveToken(request);
        	return mapping.getInputForward();
        }
	}
}

