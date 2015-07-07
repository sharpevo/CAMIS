package org.chd.tea;


import org.apache.commons.lang.ObjectUtils;

/**
 * 尝试不用DisplayTag的Decorator类完成链接。
 * 可以删掉。
 * @author Ryan
 *
 */
public class ShowMySub2PDF extends DisplayPDF{
	
	public boolean isCell(Object value){
    	String cell = ObjectUtils.toString(value);
    	if(cell.equals("查看任务书")
    			||cell.equals("填写")
    			||cell.contains("<a")){
    		System.out.println("不写进去");
    		return false;
    	}else{
    		return true;
    	}
    }

}
