package com.storchti.jmobilityskeleton.gui.Mfold;

import javax.swing.JFrame;
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
public abstract class MfoldGuiController implements DefaultController {

	public abstract JFrame getParent();

	public abstract MfoldGuiModel getModel();

	public void showWrongHost() {
		JOptionPane.showMessageDialog(getParent(), "Enter a correct hostname or ip!", getParent().getTitle(), JOptionPane.ERROR_MESSAGE);
	}

	public void showNoSelectedHost() {
		JOptionPane.showMessageDialog(getParent(), "Please! Select a host.", getParent().getTitle(), JOptionPane.WARNING_MESSAGE);
	}
}
