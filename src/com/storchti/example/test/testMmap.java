package com.storchti.example.test;

import java.io.Serializable;
import java.util.Random;

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
public class testMmap extends Mmap {

	private static final long serialVersionUID = 1L;
	Random resultado;

	public testMmap(String[] hosts) {
		super(hosts);
	}

	public void executar() {
		System.out.println("Getting Random...");
		resultado = new Random(System.currentTimeMillis());
	}

	public Serializable result() {
		return resultado;
	}

	public int fatorial(int numero) {
		if (numero > 1) {
			return fatorial(numero - 1) * numero;
		} else
			return 1;
	}

	public static void main(String[] args) {
		String[] hosts = new String[1];
		hosts[0] = "127.0.0.1";
		//hosts[1] = "localhost";
		//hosts[2] = "127.0.0.1";
		try {
			testMmap t = new testMmap(hosts);
			String[][] r = t.goMmap();
			System.out.println(r);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
