package com.storchti.jmobilityskeleton;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
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
 * Padr�o de Mobilidade Mzipper Descrito no Artigo Towards Mobility Skeletons
 * por Andr� Rauber Du Bois, Phil Trinder e Hans-Wolfgang Loidl Implement�ao em
 * Java sobre o Padr�o de Projeto do tipo Comportamental Template Method e parte
 * do Projeto de Gradu��o submetido a Escola de Inform�tica da Universidade
 * Cat�lica de Pelotas na obten��o do grau de Bacharel em Ci�ncias da Computa�ao
 * por Mauro Storch
 *
 * @author MauroStorch
 *
 */
public abstract class Mzipper implements Runnable, Execute, Serializable {

	private String[] hosts;
	private String[] hostsIniciais;
	private String hostAtual;
	private String hostInicial;
	private String hostControlador;
	private Serializable resposta;

	public Mzipper(String[] hosts) {
		this.hosts = hosts;
		this.hostsIniciais = hosts;
		this.hostControlador = hosts[0];
		try {
			this.hostInicial = InetAddress.getLocalHost().getHostAddress();
		} catch (Exception e) {
		}
	}

	public void run() {
		try {
			this.goVoyager();
		} catch (Exception e) {
		}
	}

	public Serializable goMzipper() throws Exception {

		Thread v = new Thread(this);

		ServerSocket resposta = new ServerSocket(3031);
		Socket c;

		v.start();

		c = resposta.accept();
		ObjectInputStream volta = new ObjectInputStream(c.getInputStream());
		Serializable o = (Serializable) volta.readObject();
		c.close();
		resposta.close();
		return o;
	}

	public void goVoyager() throws Exception {
		if (this.hosts.length > 0) {
			this.hostAtual = this.hosts[0];
			String nextHost = this.hosts[0];
			String[] newHosts = new String[this.hosts.length - 1];
			for (int i = 0; i < newHosts.length; i++) {
				newHosts[i] = this.hosts[i + 1];
			}
			this.hosts = newHosts;
			RemoteCreate.createA(this, nextHost);
		} else {
			Socket s = new Socket(this.hostInicial, 3031);
			ObjectOutputStream volta = new ObjectOutputStream(s
					.getOutputStream());
			volta.writeObject((Object) this.resposta);
			volta.flush();
			s.close();
		}

	}

	public void execute() {

		if (this.hostAtual == this.hostControlador) {
			this.resposta = this.executar();
		} else {
			if (!this.predicado(this.resposta)) {
				this.hosts = this.hostsIniciais;
			}
		}
		try {
			this.goVoyager();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Serializable resultado() {
		return this.resposta;
	}

	abstract public Serializable executar();

	abstract public boolean predicado(Serializable in);
}