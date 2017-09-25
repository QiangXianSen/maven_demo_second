/**
 * tzdeskϵͳƽ̨
 * tzupload
 * com.tz.util
 * DateFormateEditor.java
 * ������:xuchengfei 
 * ʱ�䣺2015��11��13��-����8:56:36 
 * 2015̶�ݽ�����˾-��Ȩ����
 */
package com.tz.util;

import java.beans.PropertyEditorSupport;

/**
 * 
 * DateFormateEditor
 * 创建人:wq
 * 时间：2017年9月20日-下午11:05:21
 * @version 1.0.0
 * 
 */
public class BooleanEditor extends PropertyEditorSupport{
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(TmStringUtils.isNotEmpty(text)){
			if(text.equalsIgnoreCase("3"))setValue(true);
			if(text.equalsIgnoreCase("4"))setValue(false);
		}else{
			setValue(false);
		}
	}
}
