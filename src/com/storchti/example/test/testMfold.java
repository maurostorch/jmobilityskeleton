/**
 *
 */
package com.storchti.example.test;

import java.io.Serializable;
import java.util.Random;

import com.storchti.jmobilityskeleton.Mfold;
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
 * @author MauroStorch
 *
 */
public class testMfold extends Mfold {

	public testMfold(Serializable respostaInicial, String[] hosts) {
		super(respostaInicial, hosts);
	}

	@Override
	public Serializable executar() {
		Random r = new Random(System.currentTimeMillis());
		//System.out.println(r.nextInt(100));
		return String.valueOf(r.nextInt(100));
	}

	@Override
	public Serializable operator(Serializable a, Serializable b) {
		return (String) a + " " + (String) b;
	}

	public static void main(String[] args) {
		String[] hosts = new String[1];
		hosts[0] = "127.0.0.1";
		//hosts[1] = "127.0.0.1";
		//hosts[2] = "127.0.0.1";
		try {
			testMfold t = new testMfold("Resposta:", hosts);
			String t1 = (String) t.goMfold();
			System.out.println(t1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
