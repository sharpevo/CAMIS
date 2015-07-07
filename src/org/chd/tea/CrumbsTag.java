package org.chd.tea;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.struts.Globals;
import org.apache.struts.util.MessageResources;
import org.apache.struts.taglib.html.Constants;

/**
 * 关于读取property文件的方法，参考了其他的代码。
 * @author Ryan
 *
 */

public class CrumbsTag extends TagSupport {

	
	private String bundle;
	private String name;
	protected static MessageResources messages =
		MessageResources.getMessageResources(Constants.Package + ".LocalStrings");
	
	public String getBundle() {
		return bundle;
	}
	public void setBundle(String bundle) {
		this.bundle = bundle;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLabel(
			HttpServletRequest request,String bundle,String key)
			throws JspException {	
			
			ServletContext servletContext = pageContext.getServletContext();
			// Acquire the resources object containing our messages
			MessageResources resources =(MessageResources) request.getAttribute(bundle);
			if (resources == null) {
				resources = (MessageResources) servletContext.getAttribute(bundle);
			}
			if (resources == null) {
				throw new JspException(messages.getMessage("messageTag.resources", "'"+bundle+"'"));
			}
			// Calculate the Locale we will be using
			Locale locale = null;
			try {
				locale =(Locale) request.getSession(false).getAttribute(Globals.LOCALE_KEY);
			} catch (IllegalStateException e) { // Invalidated session
				locale = null;
			} catch (NullPointerException npe) {
				// no session yet.

				locale = request.getLocale();	
			}
			if (locale == null)
				locale = Locale.getDefault();


			// Retrieve the message string we are looking for
			String message = null;
			if (key != null) {
				message = resources.getMessage(locale, key);
			}
			if (message == null) {
					return key;
			}
			return message;
		}

	/*
	 * we need the following method to implement our custom JSP tag.
	 * more in my papers（translation）.
	 *  
	 * (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	
    public int doStartTag() {
    	return SKIP_BODY;
    }
    public int doEndTag() throws JspException{
    	JspWriter out = pageContext.getOut();
    	HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
    	HttpSession hs = request.getSession();
    	List crumbs = (List) hs.getAttribute(name);
    	String key ="";
    	String localeKey="";
    	String link="";
    	Map crumb = new HashMap();
    	String prefix = "<a href=\"";
    	String middle = "\">";
    	String suffix = "</a>";
    	StringBuffer result;
    	if( crumbs == null){// for the wrong name you use in the attribute of name in Jsp.
    		throw new NullPointerException("Cannot find bean "+"'"+name+"'"+" in any scope" );
    	}
    	
    	for(int i=0;i<crumbs.size();i++){
    		result = new StringBuffer();
    		crumb=(Map) crumbs.get(i);
    		key = crumb.get(TeaConstants.CRUMBKEY).toString();
    		if(bundle == null ){// show the key directly if no bundle attribute set in Jsp.
    			bundle = Globals.MESSAGES_KEY;
    		}
    		localeKey = getLabel(request,bundle,key);

    		if(crumb.get(TeaConstants.CRUMBLINK) != null){
        		link = crumb.get(TeaConstants.CRUMBLINK).toString();
        		result.append(prefix);
    			result.append(link);
    			result.append(middle);
    			result.append(localeKey);
    			result.append(suffix);
    		}else{
    			result.append(localeKey);
    		}
    		if(i!=crumbs.size()-1){
    			result.append(">"); // seporator
    		}
    		try {
				out.print(result.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
     	
    	return EVAL_PAGE;
    }
	
    public void release( ) {
        super.release( );
        this.name = TeaConstants.CRUMBS_KEY;
        this.bundle = null;
    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
