package com.storchti.jmobilityskeleton;

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
/**
 * Classe com m�todos est�ticos de cria��o Sincrona e Asincrona de Objetos Remotos
 * Parte da Estrutura dos Padr�es de Projeto para Programa��o M�vel
 * e parte do Projeto de Gradu��o submetido a Escola de Inform�tica da Universidade Cat�lica
 * de Pelotas na obten��o do grau de Bacharel em Ci�ncias da Computa�ao por Mauro Storch
 *
 * @author MauroStorch
 *
 */
class RemoteCreate{
	/**
	 * @param b
	 * @param host
	 * @return
	 * @throws Exception
	 */
	public final static Object createS(Execute b, String host) throws Exception{

		Socket s=new Socket(host,3030);
		ObjectOutputStream saida=new ObjectOutputStream(s.getOutputStream());
		saida.writeObject((Object) b);
		saida.flush();
		ObjectInputStream retorno=new ObjectInputStream(s.getInputStream());
		Object o=retorno.readObject();
		s.close();
		return o;

	}

	/**
	 * @param b
	 * @param host
	 * @throws Exception
	 */
	public final static void createA(Execute b, String host) throws Exception{

		Socket s=new Socket(host,3030);
		ObjectOutputStream saida=new ObjectOutputStream(s.getOutputStream());
		saida.writeObject((Object) b);
		saida.flush();
		s.shutdownOutput();
		ObjectInputStream retorno=new ObjectInputStream(s.getInputStream());
		Object o=retorno.readObject();
		s.close();

	}
}