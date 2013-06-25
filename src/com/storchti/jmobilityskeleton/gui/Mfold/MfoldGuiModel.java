package com.storchti.jmobilityskeleton.gui.Mfold;

import javax.swing.DefaultListModel;

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
public abstract class MfoldGuiModel implements DefaultModel {

	abstract DefaultListModel getHosts();
	abstract void setHosts(DefaultListModel hosts);

	@Override
	public void fromObject(Object values) {
		Object[] objs=(Object[])values;
		setHosts((DefaultListModel) objs[0]);

	}

	@Override
	public Object toObject() {
		Object[] objs = new Object[1];
		objs[0]=getHosts();
		return objs;
	}

}
