package com.storchti.jmobilityskeleton;

import java.io.IOException;
import java.net.ServerSocket;
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
/**
 * Servidor inicializado nos nodos da estrutura Parte da Estrutura dos Padr�es
 * de Projeto para Programa��o M�vel e parte do Projeto de Gradu��o submetido a
 * Escola de Inform�tica da Universidade Cat�lica de Pelotas na obten��o do grau
 * de Bacharel em Ci�ncias da Computa�ao por Mauro Storch
 *
 * @author MauroStorch
 *
 */
public abstract class JMSServer extends Thread {
	ServerSocket server;

	public void run() {
		try {
			server = new ServerSocket(3030);
			log("Starting server...    OK");
			while (true) {
				new JMSServerConnection(server.accept()){
					public void log(String s){
						JMSServer.this.log(s);
					}
				}.start();
			}
		} catch (Exception e) {
			log(e.getMessage());
		}
	}

	public void stopServer() throws IOException{
		if(server!=null){
			server.close();
		}
	}

	public abstract void log(String s);

}