package org.chd.struts.stu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public abstract class BaseAction extends Action {

    protected static final String SAVE = "save";

    protected static final String DELETE = "delete";

    protected static final String DATABASE_DEST = "database";

    protected static final String FILE_DEST = "file";

    @Override
	public abstract ActionForward execute( ActionMapping mapping, ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception;
    public String getPath(String filePath){

        String path = getServlet().getServletContext().getRealPath(filePath) + "\\";

        return path;
    }
}

