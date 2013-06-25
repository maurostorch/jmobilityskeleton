package com.storchti.jmobilityskeleton.gui.Mmap;

import java.io.Serializable;

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
public abstract class MmapGuiModel implements DefaultModel, Serializable {

	public abstract String getText();

	public abstract void setText(String string);

	@Override
	public void fromObject(Object values) {
		Object[] objs=(Object[]) values;
		setText((String) objs[0]);
	}

	@Override
	public Object toObject() {
		Object[] objs=new Object[1];
		objs[0]=(Object) getText();
		return (Object)objs;
	}


}
