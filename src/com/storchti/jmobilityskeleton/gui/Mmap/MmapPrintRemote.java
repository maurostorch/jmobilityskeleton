package com.storchti.jmobilityskeleton.gui.Mmap;

import java.io.Serializable;

import com.storchti.jmobilityskeleton.Mmap;
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
public abstract class MmapPrintRemote extends Mmap implements Serializable {

	long result;

	public MmapPrintRemote(String[] hosts) {
		super(hosts);
	}

	@Override
	public void executar() {
		this.result=System.currentTimeMillis();
	}

	public Serializable result() {
		return this.result;
	}

	public abstract String mensagem();

}
