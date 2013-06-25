package com.storchti.example.test;

import java.io.Serializable;
import java.util.Random;

import com.storchti.jmobilityskeleton.Mzipper;
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
public class testMzipper extends Mzipper {

	private static final long serialVersionUID = 1L;
	private int numero;
	public testMzipper(String[] hosts) {
		super(hosts);
	}

	@Override
	public Serializable executar() {
		Random r=new Random(System.currentTimeMillis());
		int s=r.nextInt(100);
		System.out.println("Sorteio: "+s);
		return s;
	}

	@Override
	public boolean predicado(Serializable in) {
		int n=(Integer)in;
		if(n%2==0) return true;
		return false;
	}

	public Serializable result() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] hosts = new String[3];
		hosts[0] = "127.0.0.1";
		hosts[1] = "127.0.0.1";
		hosts[2] = "127.0.0.1";
		try {
			testMzipper t = new testMzipper(hosts);
			int t1 = (Integer) t.goMzipper();
			System.out.println(t1);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
