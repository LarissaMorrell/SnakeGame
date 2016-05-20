package myFinalProj;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SetupPanel extends JPanel{

	JLabel statusLbl;


	public SetupPanel(){

		super();
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
	

		String gameStatus = "Select a level of difficulty";


		//start with a prompt on difficulty
		statusLbl = new JLabel(gameStatus);

		c.gridx = 0;
		c.gridy = 0;
		this.add(statusLbl, c);



		JRadioButton begButton = new JRadioButton("Easy", true);
		JRadioButton intButton = new JRadioButton("Medium", false);
		JRadioButton advButton = new JRadioButton("Hard", false);

		ButtonGroup grp = new ButtonGroup();
		grp.add(begButton);
		grp.add(intButton);
		grp.add(advButton);

		c.gridwidth = 1;

		c.gridx++;
		this.add(begButton, c);

		c.gridx++;
		this.add(intButton, c);

		c.gridx++;
		this.add(advButton, c);

	}

}