package com.storchti.jmobilityskeleton;

import java.io.Serializable;
import java.util.ArrayList;
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
 * Padr�o de Mobilidade Mmap Descrito no Artigo Towards Mobility Skeletons por
 * Andr� Rauber Du Bois, Phil Trinder e Hans-Wolfgang Loidl Implement�ao em Java
 * sobre o Padr�o de Projeto do tipo Comportamental Template Method e parte do
 * Projeto de Gradu��o submetido a Escola de Inform�tica da Universidade
 * Cat�lica de Pelotas na obten��o do grau de Bacharel em Ci�ncias da Computa�ao
 * por Mauro Storch
 *
 * @author Mauro Storch
 *
 */
public abstract class Mmap implements Execute, Serializable{

	private ArrayList<String> hostsList;
	private ArrayList<DefaultEntry> resultList;

	public Mmap(String[] hosts) {
		hostsList = new ArrayList<String>();
		resultList = new ArrayList<DefaultEntry>();
		for (int i = 0; i < hosts.length; i++) {
			hostsList.add(hosts[i]);
		}
	}

	public String[][] goMmap() throws Exception {
		for (int i = 0; i < hostsList.size(); i++) {
			Object r = RemoteCreate.createS(this, hostsList.get(i));
			DefaultEntry entry=new DefaultEntry();
			entry.setKey(hostsList.get(i));
			entry.setValue(r);
			resultList.add(entry);
		}
		return this.resultado();
	}

	public void execute(){
		executar();
	}

	abstract public Serializable result();

	abstract public void executar();

	public String[][] resultado() {
		String[][] resultado = new String[resultList.size()][2];
		for (int i=0; i < resultList.size(); i++){
			resultado[i][0]=resultList.get(i).getKey();
			resultado[i][1]=resultList.get(i).getValue().toString();
		}
		return resultado;
	}
}