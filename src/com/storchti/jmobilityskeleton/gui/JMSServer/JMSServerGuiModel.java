package com.storchti.jmobilityskeleton.gui.JMSServer;

import org.mvc.structure.DefaultModel;
/*
 * Copyright [2008] [Mauro Storch]
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
public abstract class JMSServerGuiModel implements DefaultModel{

	abstract void setText(String text);

	abstract String getText();

	abstract void log(String s);

	public void fromObject(Object values) {
		Object[] tempValues = (Object[]) values;
		setText((String) tempValues[0]);
	}

	public Object toObject() {
		Object[] values = new Object[2];
		values[0] = getText();
		return values;
	}

}
