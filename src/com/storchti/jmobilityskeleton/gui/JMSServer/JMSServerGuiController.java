package com.storchti.jmobilityskeleton.gui.JMSServer;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.mvc.structure.DefaultController;

import com.storchti.jmobilityskeleton.JMSServer;
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
public abstract class JMSServerGuiController implements DefaultController {

	private JMSServer jmsserver;

	abstract JMSServerGuiModel getModel();

	abstract JFrame getParent();

	public void startJMSServer(){
		jmsserver=new JMSServer(){
			public void log(String s){
				getModel().log(s);
			}
		};
		jmsserver.start();
	}

	public void stopServer() throws IOException{
		jmsserver.stopServer();
	}

	public boolean sairMsg() {
		switch (JOptionPane.showOptionDialog(getParent(), // COMPONENTE PAI
				"Exit?", // MENSAGEM NA TELA
				getParent().getTitle(), // TITULO DA JANELA
				JOptionPane.YES_NO_OPTION, // TIPO DE BOTOES NA JANELA
				JOptionPane.INFORMATION_MESSAGE, // TIPO DE JANELA REFERENTE
				// AO ICONE TAMBEM
				null, // ICONE DA JANELA
				new Object[] { "Yes", "No" }, // NOME DOS OBJETOS
				0)) // SELE��O INICIA
		{

		case JOptionPane.YES_OPTION:
			return true;
		default:
			return false;
		}
	}

}
