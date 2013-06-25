package com.storchti.jmobilityskeleton.gui.Mmap;

import java.awt.Component;
import java.io.Serializable;
import java.util.Date;

import javax.swing.JOptionPane;

import org.mvc.structure.DefaultController;
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
public abstract class MmapGuiController implements DefaultController, Serializable {

	public abstract String[] getHosts();

	public abstract MmapGuiModel getModel();

	public abstract Component getParent();

	private String[][] sendMessage() throws Exception {
		MmapPrintRemote message = new MmapPrintRemote(getHosts()) {

			private static final long serialVersionUID = 1L;

			@Override
			public String mensagem() {
				return getModel().getText();
			}

		};
		return message.goMmap();
	}

	public void send() throws Exception {
		String[][] result = sendMessage();
		if (result == null) {
			showSendError();
		}
		for(int i=0;i<result.length;i++){
			showTime(Long.parseLong(result[i][1]), result[i][0]);
		}
	}

	public void showSendError() {
		JOptionPane.showMessageDialog(getParent(), "Error getting date!");
	}

	private void showTime(long t,String h){
		Date d=new Date(t);
		JOptionPane.showMessageDialog(getParent(), "At "+h+" is "+d);
	}

}
