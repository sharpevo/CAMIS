package org.chd.tea;

import org.apache.struts.action.ActionMapping;
import java.util.Vector;
public class TeaActionMapping extends ActionMapping{
	
	private Vector preActions = new Vector();
	
	private String preAction="";
	
	private boolean toCrumb=true;
	







	public TeaActionMapping()
	{
		super();
	}
	
	
	
	
	
	
	
	public Vector getPreActions() {
		return preActions;
	}


	public void setPreAction(String preAction) {
		
		this.preAction = preAction;
		preActions.add(preAction);
	}







	public boolean isToCrumb() {
		return toCrumb;
	}

	public void setToCrumb(boolean toCrumb) {
		this.toCrumb = toCrumb;
	}
	

}
