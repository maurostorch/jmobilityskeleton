package com.storchti.jmobilityskeleton;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public abstract class JMSServerConnection extends Thread{
	Socket c;

	public JMSServerConnection(Socket s) {
		this.c = s;
		log("Conexao recebida de " + s.getRemoteSocketAddress());
	}

	public void run() {
		try {
			ObjectInputStream in = new ObjectInputStream(c.getInputStream());
			Execute skeleton = (Execute) in.readObject();
			skeleton.execute();
			c.shutdownInput();
			ObjectOutputStream out = new ObjectOutputStream(c.getOutputStream());
			out.writeObject((Object) skeleton.result());
			c.close();
		} catch (IOException e) {
			log(e.getMessage());
		} catch (ClassNotFoundException e) {
			log(e.getMessage());
		}
	}

	public abstract void log(String s);
}
