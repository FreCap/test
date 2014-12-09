package it.unibo.oop.smartercities;

import it.unibo.oop.streetObservers.StreetObserver;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class SmarterCitiesViewGUI implements SmarterCitiesView{

	private static final int DEFAULT_WIDTH = 700;
	private static final int DEFAULT_HEIGHT = 700;

	private JFrame mainFrame;
	private JPanel controlPanel;
	private JScrollPane scrollControlPanel;
	private JPanel infoPanel;
	
	private GridBagConstraints cnst;

	public SmarterCitiesViewGUI() {
		// creation mainFrame
		mainFrame = new JFrame("Smarter Cities");
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		
		// creation of infoPanel
		infoPanel = new JPanel();
		infoPanel.setBorder(new TitledBorder("Info"));
		infoPanel.add(new JButton("tanti bei bottoncini qui"));
		infoPanel.add(new JTextArea("qualche info quà e la :)"));
		
		// creation of an empty controlPanel
		controlPanel = new JPanel();
		controlPanel.setBorder(new TitledBorder("Controllers"));
		controlPanel.setLayout(new GridBagLayout());
		scrollControlPanel = new JScrollPane(controlPanel);
		
		// vertical disposition of the element of the panel (controlPanel)
		cnst = new GridBagConstraints () ;
		cnst.gridy = 0;
		cnst.insets = new Insets (5 ,5 ,5 ,5);
		
		// join of the two panels, and showing of the mainFrame
		mainFrame.add(scrollControlPanel, BorderLayout.CENTER);
		mainFrame.add(infoPanel, BorderLayout.EAST);
		mainFrame.setVisible(true);

	}

	@Override
	public boolean pluginRequest(Double latitude, Double longitude) {
		String msg = "There is a new request for plugging a new street observer. \nIt's location is: " +
					 "\n   - Latitude:  " + latitude +
					 "\n   - Longitude: " + longitude +
					 "\n\nDo you want to plug it?";
		
		Integer choice = JOptionPane.showOptionDialog(null, 
												  msg,
												  "New plugging request",
												  JOptionPane.YES_NO_OPTION, 
												  JOptionPane.QUESTION_MESSAGE, 
												  null, null, null);
		
		
		if(choice.equals(JOptionPane.YES_OPTION)) {
			//TODO  fallo come liste! qui sto perdendo info dei labels e degli StreetObserver
			JLabel controlLabel = new JLabel();
			StreetObserver so = new StreetObserver(latitude, longitude);
			controlLabel.setBorder(new TitledBorder("Street Observer" + " " + so.getID()));
			controlLabel.setIcon(so.getPositionMap());
			controlPanel.add(controlLabel, cnst);
			cnst.gridy++;
			mainFrame.validate();
			mainFrame.repaint();
			return true;
		} else {
			return false;
		}

	}

	
	@Override
	public void sendInformationsTo() {
		// TODO
	}

}
