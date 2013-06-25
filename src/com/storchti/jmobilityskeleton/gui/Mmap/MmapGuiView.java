package com.storchti.jmobilityskeleton.gui.Mmap;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.mvc.structure.DefaultView;
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
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class MmapGuiView extends javax.swing.JFrame implements
		DefaultView<MmapGuiModel, MmapGuiController>, Serializable {

	private static final long serialVersionUID = 1L;
	private JButton jButtonSend;
	private MmapGuiController controller;
	private MmapGuiModel model;
	private JPanel jPanel1;
	private JLabel jLabel;
	private JButton jButtonExit;
	private JLabel jLabel1;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JTextField jTextFieldHost;

	/**
	 * Auto-generated main method to display this JFrame
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		//JFrame.setDefaultLookAndFeelDecorated(true);
		//JDialog.setDefaultLookAndFeelDecorated(true);
		//UIManager.setLookAndFeel(new SubstanceOfficeSilver2007LookAndFeel());
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				MmapGuiView inst = new MmapGuiView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);


	}

	public MmapGuiView() {
		super("Mmap MVC Test");
		initGUI();
	}

	private void initGUI() {
		try {
			{
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				GridBagLayout thisLayout = new GridBagLayout();
				thisLayout.rowWeights = new double[] { 0.1, 0.1 };
				thisLayout.rowHeights = new int[] { 20, 7 };
				thisLayout.columnWeights = new double[] {0.1, 0.0, 0.1};
				thisLayout.columnWidths = new int[] {7, 7, 20};
				getContentPane().setLayout(thisLayout);
				getContentPane().add(getJButtonSend(), new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				getContentPane().add(getJPanel1(), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				getContentPane().add(getJPanel2(), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				getContentPane().add(getJButtonExit(), new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				getContentPane().add(getJPanel3(), new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			}
			this.setSize(276, 101);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JButton getJButtonSend() {
		if (jButtonSend == null) {
			jButtonSend = new JButton();
			jButtonSend.setText("Get Date");
			jButtonSend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonSendActionPerformed(evt);
				}
			});
		}
		return jButtonSend;
	}

	public MmapGuiController getController() {
		if (controller == null) {
			controller = new MmapGuiController() {

				private static final long serialVersionUID = 1L;

				@Override
				public String[] getHosts() {
					String[] hosts=new String[1];
					hosts[0]=jTextFieldHost.getText();
					return hosts;
				}

				@Override
				public MmapGuiModel getModel() {
					return MmapGuiView.this.getModel();
				}

				@Override
				public Component getParent() {
					return MmapGuiView.this;
				}

			};
		}
		return controller;
	}

	public MmapGuiModel getModel() {
		if (model == null) {
			model = new MmapGuiModel() {

				private static final long serialVersionUID = 1L;

				@Override
				public String getText() {
					return getJTextFieldHost().getText();
				}

				@Override
				public void setText(String string) {
					getJTextFieldHost().setText(string);

				}

			};
		}
		return model;
	}

	@Override
	public void setModel(MmapGuiModel model) {
		if (model != null) {
			getModel().fromObject(model.toObject());
		}
	}

	private JTextField getJTextFieldHost() {
		if (jTextFieldHost == null) {
			jTextFieldHost = new JTextField();
			jTextFieldHost.setText("127.0.0.1");
		}
		return jTextFieldHost;
	}

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			BoxLayout jPanel1Layout = new BoxLayout(jPanel1,
					javax.swing.BoxLayout.Y_AXIS);
			jPanel1.setLayout(jPanel1Layout);
			jPanel1.add(getJLabel());
			jPanel1.add(getJTextFieldHost());
		}
		return jPanel1;
	}

	private JLabel getJLabel() {
		if (jLabel == null) {
			jLabel = new JLabel();
			jLabel.setText("Destination Host");
		}
		return jLabel;
	}

	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			BoxLayout jPanel2Layout = new BoxLayout(jPanel2,
					javax.swing.BoxLayout.Y_AXIS);
			jPanel2.setLayout(jPanel2Layout);
		}
		return jPanel2;
	}

	private JButton getJButtonExit() {
		if(jButtonExit == null) {
			jButtonExit = new JButton();
			jButtonExit.setText("Exit");
			jButtonExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonExitActionPerformed(evt);
				}
			});
			jButtonExit.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent evt) {
					jButtonExitMouseReleased(evt);
				}
			});
		}
		return jButtonExit;
	}

	private void jButtonExitMouseReleased(MouseEvent evt) {
		System.exit(0);
	}

	private void jButtonSendActionPerformed(ActionEvent evt){
		if(!getJTextFieldHost().getText().equals("")){
			try {
				getController().send();
			} catch (Exception e) {
				//e.printStackTrace();
				getController().showSendError();
			}
		}
	}

	private JPanel getJPanel3() {
		if(jPanel3 == null) {
			jPanel3 = new JPanel();
			BoxLayout jPanel3Layout = new BoxLayout(jPanel3, javax.swing.BoxLayout.X_AXIS);
			jPanel3.setLayout(jPanel3Layout);
			jPanel3.add(getJLabel1());
		}
		return jPanel3;
	}

	private void jButtonExitActionPerformed(ActionEvent evt) {
		System.exit(0);
	}
	
	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("CopyLeft 2008");
		}
		return jLabel1;
	}

}
