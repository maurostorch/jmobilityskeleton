package com.storchti.jmobilityskeleton.gui.JMSServer;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jvnet.substance.skin.SubstanceOfficeSilver2007LookAndFeel;
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
public class JMSServerGuiView extends JFrame implements
		DefaultView<JMSServerGuiModel, JMSServerGuiController> {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jPanelButtons;
	private JButton jButtonStart;
	private JButton jButtonStop;
	private JScrollPane jScrollPane;
	private JTextArea jTextArea;
	private JMSServerGuiModel model;
	private JMSServerGuiController controller;

	/**
	 * Auto-generated main method to display this JFrame
	 *
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args)
			throws UnsupportedLookAndFeelException, ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		//JFrame.setDefaultLookAndFeelDecorated(true);
		//JDialog.setDefaultLookAndFeelDecorated(true);
		UIManager.setLookAndFeel(new SubstanceOfficeSilver2007LookAndFeel());
		//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		JMSServerGuiView inst = new JMSServerGuiView();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

	public JMSServerGuiView() {
		super("jMobilitySqueleton Server");
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			getContentPane().add(getJPanelButtons(), BorderLayout.SOUTH);
			getContentPane().add(getJScrollPane(), BorderLayout.CENTER);
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel getJPanelButtons() {
		if (jPanelButtons == null) {
			jPanelButtons = new JPanel();
			GridBagLayout jPanelButtonsLayout = new GridBagLayout();
			jPanelButtonsLayout.rowWeights = new double[] { 0.1 };
			jPanelButtonsLayout.rowHeights = new int[] { 7 };
			jPanelButtonsLayout.columnWeights = new double[] { 0.1, 0.0, 0.0 };
			jPanelButtonsLayout.columnWidths = new int[] { 20, 7, 7 };
			jPanelButtons.setLayout(jPanelButtonsLayout);
			jPanelButtons.add(getJButtonStart(), new GridBagConstraints(1, 0,
					1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanelButtons.add(getJButtonStop(), new GridBagConstraints(2, 0, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		}
		return jPanelButtons;
	}

	private JButton getJButtonStart() {
		if (jButtonStart == null) {
			jButtonStart = new JButton();
			jButtonStart.setText("Start");
			jButtonStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonStartActionPerformed(evt);
				}
			});
		}
		return jButtonStart;
	}

	private JButton getJButtonStop() {
		if (jButtonStop == null) {
			jButtonStop = new JButton();
			jButtonStop.setText("Stop / Close");
			jButtonStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonStopActionPerformed(evt);
				}
			});
		}
		return jButtonStop;
	}

	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTextArea());
		}
		return jScrollPane;
	}

	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setText("");
			jTextArea.setEditable(false);
			jTextArea.setWrapStyleWord(true);
			jTextArea.setLineWrap(true);
			getJTextArea().setAutoscrolls(true);
		}
		return jTextArea;
	}

	public JMSServerGuiController getController() {
		if (controller == null) {
			controller = new JMSServerGuiController() {

				@Override
				JMSServerGuiModel getModel() {
					return JMSServerGuiView.this.getModel();
				}

				@Override
				JFrame getParent() {
					return JMSServerGuiView.this;
				}

			};
		}
		return controller;
	}

	public JMSServerGuiModel getModel() {
		if (model == null) {
			model = new JMSServerGuiModel() {

				@Override
				String getText() {
					return getJTextArea().getText();
				}

				@Override
				void setText(String text) {
					getJTextArea().setText(text);
				}

				@Override
				void log(String s) {
					getJTextArea().setText(
							s + System.getProperty("line.separator")
									+ getJTextArea().getText());
				}

			};
		}
		return model;
	}

	public void setModel(JMSServerGuiModel model) {
		if (model != null) {
			getModel().fromObject(model.toObject());
		}
	}

	private void jButtonStartActionPerformed(ActionEvent evt) {
		getController().startJMSServer();
	}

	private void jButtonStopActionPerformed(ActionEvent evt) {
		try {
			getController().stopServer();
		} catch (IOException e) {
			getModel().log(e.getMessage());
		} finally {
			if (getController().sairMsg())
				System.exit(0);
		}
	}

}
