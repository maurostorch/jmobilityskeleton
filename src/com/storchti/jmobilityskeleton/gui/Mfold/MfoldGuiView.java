package com.storchti.jmobilityskeleton.gui.Mfold;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
public class MfoldGuiView extends javax.swing.JFrame implements
		DefaultView<MfoldGuiModel, MfoldGuiController> {

	private JList jListHosts;
	private JPanel jPanel1;
	private JTextField jTextFieldNewHost;
	private JButton jButtonRemove;
	private JButton jButtonAction;
	private JButton jButtonAdd;
	private JButton jButtonClose;
	private JPanel jPanel2;
	private MfoldGuiModel model;
	private MfoldGuiController controller;

	/**
	 * Auto-generated main method to display this JFrame
	 *
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		UIManager
				.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		MfoldGuiView inst = new MfoldGuiView();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

	public MfoldGuiView() {
		super("Mfold MVC Test");
		initGUI();
	}

	private void initGUI() {
		try {
			{
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				GridBagLayout thisLayout = new GridBagLayout();
				thisLayout.rowWeights = new double[] { 0.1, 0.0 };
				thisLayout.rowHeights = new int[] { 7, 7 };
				thisLayout.columnWeights = new double[] { 0.1 };
				thisLayout.columnWidths = new int[] { 7 };
				getContentPane().setLayout(thisLayout);
				this.setResizable(false);
				getContentPane().add(
						getJListHosts(),
						new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER,
								GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 0), 0, 0));
				getContentPane().add(
						getJPanel1(),
						new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER,
								GridBagConstraints.HORIZONTAL, new Insets(0, 0,
										0, 0), 0, 0));
			}
			this.setSize(261, 300);
			getJTextFieldNewHost().requestFocus();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JList getJListHosts() {
		if (jListHosts == null) {
			DefaultListModel jListHostsModel = new DefaultListModel();
			jListHosts = new JList();
			jListHosts.setModel(jListHostsModel);
			jListHosts.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent evt) {
					jListHostsValueChanged(evt);
				}
			});
			jListHosts.setSelectedIndex(0);
			jListHosts.setBorder(BorderFactory.createTitledBorder(""));
		}
		return jListHosts;
	}

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			BoxLayout jPanel1Layout = new BoxLayout(jPanel1,
					javax.swing.BoxLayout.Y_AXIS);
			jPanel1.setLayout(jPanel1Layout);
			jPanel1.add(getJTextFieldNewHost());
			jPanel1.add(getJPanel2());
		}
		return jPanel1;
	}

	private JTextField getJTextFieldNewHost() {
		if (jTextFieldNewHost == null) {
			jTextFieldNewHost = new JTextField();
			jTextFieldNewHost.setBorder(BorderFactory.createTitledBorder(""));
			jTextFieldNewHost.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					jTextFieldNewHostKeyPressed(evt);
				}
			});
			jTextFieldNewHost.addFocusListener(new FocusAdapter() {
				public void focusGained(FocusEvent evt) {
					jTextFieldNewHostFocusGained(evt);
				}
			});
			jTextFieldNewHost.setText("HostName / IP Address");
		}
		return jTextFieldNewHost;
	}

	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			BoxLayout jPanel2Layout = new BoxLayout(jPanel2,
					javax.swing.BoxLayout.X_AXIS);
			jPanel2.setLayout(jPanel2Layout);
			jPanel2.add(getJButtonAdd());
			jPanel2.add(getJButtonRemove());
			jPanel2.add(getJButtonAction());
			jPanel2.add(getJButtonClose());
		}
		return jPanel2;
	}

	private JButton getJButtonAdd() {
		if (jButtonAdd == null) {
			jButtonAdd = new JButton();
			jButtonAdd.setText("Add");
			jButtonAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonAddActionPerformed(evt);
				}
			});
		}
		return jButtonAdd;
	}

	private JButton getJButtonRemove() {
		if (jButtonRemove == null) {
			jButtonRemove = new JButton();
			jButtonRemove.setText("Remove");
			jButtonRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonRemoveActionPerformed(evt);
				}
			});
		}
		return jButtonRemove;
	}

	private JButton getJButtonAction() {
		if (jButtonAction == null) {
			jButtonAction = new JButton();
			jButtonAction.setText("Action");
		}
		return jButtonAction;
	}

	private void jListHostsValueChanged(ListSelectionEvent evt) {
		String s = (String) getJListHosts().getSelectedValue();
		getJTextFieldNewHost().setText(s);
	}

	private void jTextFieldNewHostFocusGained(FocusEvent evt) {
		getJTextFieldNewHost().selectAll();
	}

	private void jButtonRemoveActionPerformed(ActionEvent evt) {
		if (!getJListHosts().isSelectionEmpty()) {
			((DefaultListModel) getJListHosts().getModel())
					.removeElementAt(getJListHosts().getSelectedIndex());
			getJTextFieldNewHost().setText("HostName / IP Address");
		} else
			getController().showNoSelectedHost();
		getJTextFieldNewHost().requestFocus();
	}

	private void jButtonAddActionPerformed(ActionEvent evt) {
		if (!getJTextFieldNewHost().getText().equals("")
				&& !getJTextFieldNewHost().getText().contains(" ")
				&& (getJTextFieldNewHost().getText().contains(".")
						|| getJTextFieldNewHost().getText().equals("localhost"))) {
			((DefaultListModel) getJListHosts().getModel()).addElement(getJTextFieldNewHost().getText());
			getJTextFieldNewHost().setText("HostName / IP Address");
		} else
			getController().showWrongHost();
		getJTextFieldNewHost().requestFocus();
	}

	@Override
	public MfoldGuiController getController() {
		if (controller == null) {
			controller = new MfoldGuiController() {

				@Override
				public JFrame getParent() {
					return MfoldGuiView.this;
				}

				@Override
				public MfoldGuiModel getModel() {
					return MfoldGuiView.this.getModel();
				}

			};
		}
		return controller;
	}

	@Override
	public MfoldGuiModel getModel() {
		if (model == null) {
			model = new MfoldGuiModel() {

				@Override
				DefaultListModel getHosts() {
					return (DefaultListModel) getJListHosts().getModel();
				}

				@Override
				void setHosts(DefaultListModel hosts) {
					getJListHosts().setModel(hosts);
				}

			};
		}
		return model;
	}

	@Override
	public void setModel(MfoldGuiModel model) {
		if (model != null) {
			getModel().fromObject(model.toObject());
		}

	}

	private JButton getJButtonClose() {
		if (jButtonClose == null) {
			jButtonClose = new JButton();
			jButtonClose.setText("Close");
			jButtonClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonCloseActionPerformed(evt);
				}
			});
		}
		return jButtonClose;
	}

	private void jButtonCloseActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

	private void jTextFieldNewHostKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == 10) {
			jButtonAddActionPerformed(null);
		}
	}

}
