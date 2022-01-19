package Parking;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;



public class Main {
	
	private static JFrame frame;
	private static JFrame prixframe;
	private static JTable jTable1 = new JTable();
	
	public static void main(String[] args) {
		Parking P =new Parking(100); //suppose qu'il ya 100 places dans le parcking
		P.StationerVoiture("22210/A/40");
		P.listerVoitures().get(0).setDateEntre("2021/03/23 23:15:03");
		P.StationerVoiture("12001/A/59");
		
		
		frontEnd(P);
	}
	
	public static void frontEnd(Parking P) {
		
		frame = new JFrame();
		frame.setTitle("Parking");
		frame.setBounds(100, 100, 711, 412);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		prixframe = new JFrame();
		prixframe.setTitle("Prix");
		prixframe.setBounds(110, 300, 230, 110);
		prixframe.setResizable(false);
		
		
		//Left Part : panel
		JPanel leftpanel = new JPanel();
		leftpanel.setBounds(0, 0, 230, 396);
		leftpanel.setBackground(new Color(170,187,255));
		leftpanel.setPreferredSize(new Dimension(400, 190));
		leftpanel.setBorder(BorderFactory.createLineBorder(Color.black));
		frame.getContentPane().add(leftpanel);
		leftpanel.setLayout(null);		

		//Ajoute
		JLabel AddVoiture = new JLabel("Ajouter une voiture ");
		AddVoiture.setFont(new Font("Tahoma", Font.PLAIN, 17));
		AddVoiture.setBounds(10, 10,165, 30);
		AddVoiture.setHorizontalAlignment(SwingConstants.LEFT);
		leftpanel.add(AddVoiture);
		
		JTextField AddVoitureJtext = new JTextField("");
		AddVoitureJtext.setEditable(true);
		AddVoitureJtext.setHorizontalAlignment(SwingConstants.LEFT);
		AddVoitureJtext.setBackground(new Color(255, 250, 250));
		AddVoitureJtext.setFont(new Font("Tahoma", Font.PLAIN, 14));
		AddVoitureJtext.setBounds(10, 50,125 , 30);
		
		AddVoitureJtext.setForeground(Color.GRAY);
		AddVoitureJtext.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (AddVoitureJtext.getText().equals("Enter La Matricule!")) {
		        	AddVoitureJtext.setText("");
		        	AddVoitureJtext.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (AddVoitureJtext.getText().isEmpty()) {
		        	AddVoitureJtext.setForeground(Color.GRAY);
		        	AddVoitureJtext.setText("Enter La Matricule!");
		        }
		    }
		    });
		
		leftpanel.add(AddVoitureJtext);
	
		
		JButton addCarButton = new JButton("");
		addCarButton.setBounds(135, 50,30 , 30);
		leftpanel.add(addCarButton);
		
		ImageIcon icon1 = new ImageIcon("src\\add_car.jpeg");
		Image img1 = icon1.getImage();  
		Image newimg1 = img1.getScaledInstance( 30, 30,  java.awt.Image.SCALE_SMOOTH);  
		icon1 = new ImageIcon( newimg1 );
		addCarButton.setIcon(icon1);
		
		//continue de la fonctionnement a la ligne 243

		
		//remove a car
		JLabel removeVoiture = new JLabel("Enlever une voiture ");
		removeVoiture.setFont(new Font("Tahoma", Font.PLAIN, 17));
		removeVoiture.setBounds(10, 90,165, 30);
		removeVoiture.setHorizontalAlignment(SwingConstants.LEFT);
		leftpanel.add(removeVoiture);
		

		JTextField RemoveVoitureJtext = new JTextField("");
		RemoveVoitureJtext.setEditable(true);
		RemoveVoitureJtext.setHorizontalAlignment(SwingConstants.LEFT);
		RemoveVoitureJtext.setBackground(new Color(255, 250, 250));
		RemoveVoitureJtext.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RemoveVoitureJtext.setBounds(10, 130,125 , 30);
		
		
		RemoveVoitureJtext.setForeground(Color.GRAY);
		RemoveVoitureJtext.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (RemoveVoitureJtext.getText().equals("Enter ID:")) {
		        	RemoveVoitureJtext.setText("");
		        	RemoveVoitureJtext.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (RemoveVoitureJtext.getText().isEmpty()) {
		        	RemoveVoitureJtext.setForeground(Color.GRAY);
		        	RemoveVoitureJtext.setText("Enter ID:");
		        }
		    }
		    });
		leftpanel.add(RemoveVoitureJtext);
		
		//Button remove a car 
		JButton removeCarButton = new JButton("");
		removeCarButton.setBounds(135, 130,30 , 30);
		leftpanel.add(removeCarButton);
		
		ImageIcon icon2 = new ImageIcon("src\\remove_car.png");
		Image img2 = icon2.getImage();  
		Image newimg2 = img2.getScaledInstance( 30, 30,  java.awt.Image.SCALE_SMOOTH);  
		icon2 = new ImageIcon( newimg2 );
		removeCarButton.setIcon(icon2);		


		//Button select all removed cars
		JButton listeCarsButton = new JButton("Listes des voitures stationnées");
		listeCarsButton.setBounds(5, 250,220 , 30);
		leftpanel.add(listeCarsButton);
		
		//Button select all removed cars
		JButton removedCarsButton = new JButton("Listes des voitures sorties");
		removedCarsButton.setBounds(5, 290,220 , 30);
		leftpanel.add(removedCarsButton);
		
		
		
	
		
		//right part ############################################
		JPanel rightpanel = new JPanel();
		rightpanel.setBounds(405, 0, 405, 396);
		rightpanel.setBackground(new Color(102, 102, 255));
		rightpanel.setPreferredSize(new Dimension(250, 190));
		rightpanel.setBorder(BorderFactory.createLineBorder(Color.black));
		frame.getContentPane().add(rightpanel);
		rightpanel.setLayout(null);
		
		//Title
		JLabel listeVoitures = new JLabel("Listes des voitures stationnées");
		listeVoitures.setFont(new Font("Tahoma", Font.BOLD, 17));
		listeVoitures.setBounds(250, 10, 300, 30);
		listeVoitures.setHorizontalAlignment(SwingConstants.LEFT);
		rightpanel.add(listeVoitures);
		
		//Table 
		jTable1 = new JTable(new DefaultTableModel(new Object[]{"ID", "Matricule","Date Entré","Date Sorté"},0));
		jTable1.getColumnModel().getColumn(0).setPreferredWidth(5); 
		jTable1.setPreferredScrollableViewportSize(new Dimension(500, 50));
		jTable1.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(jTable1);
		scrollPane.setBounds(250, 50, 420, 250);
		rightpanel.add(scrollPane);
		
	  //appele le Tableau (ligne 315)
		Table(P);


		//Nombre des Places reservees :
		JLabel NbrPlacesOccupe = new JLabel("Nombre des voitures Stationnées :");
		NbrPlacesOccupe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NbrPlacesOccupe.setBounds(250, 308, 300, 30);
		rightpanel.add(NbrPlacesOccupe);
		
		JTextField NbrPlacesOccupetext = new JTextField("0");
		NbrPlacesOccupetext.setEditable(false); 
		NbrPlacesOccupetext.setHorizontalAlignment(SwingConstants.CENTER);
		NbrPlacesOccupetext.setBorder(null);
		NbrPlacesOccupetext.setOpaque(false);
		NbrPlacesOccupetext.setFont(new Font("Tahoma", Font.BOLD, 16));
		NbrPlacesOccupetext.setBounds(450, 308, 60, 30);
		rightpanel.add(NbrPlacesOccupetext);
		NbrPlacesOccupetext.setText(Integer.toString(P.nbrePlaces()-P.placesLibres()));
		
		//Nombre des Places Libres :
		JLabel NbrPlacesLibres = new JLabel("Nombre des Places Libres :");
		NbrPlacesLibres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NbrPlacesLibres.setBounds(250, 335, 300, 30);
		rightpanel.add(NbrPlacesLibres);
		
		JTextField NbrPlacesLibreJtext = new JTextField("0");
		NbrPlacesLibreJtext.setEditable(false);  
		NbrPlacesLibreJtext.setHorizontalAlignment(SwingConstants.CENTER);
		NbrPlacesLibreJtext.setBorder(null);
		NbrPlacesLibreJtext.setOpaque(false);
		NbrPlacesLibreJtext.setFont(new Font("Tahoma", Font.BOLD, 16));
		NbrPlacesLibreJtext.setBounds(420, 335, 60, 30);
		rightpanel.add(NbrPlacesLibreJtext);
		NbrPlacesLibreJtext.setText(Integer.toString(P.placesLibres()));
		

			
	   /*
		*
		**Button Actions
		*/
		addCarButton.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent ae){
				  if(!AddVoitureJtext.getText().isEmpty()) {
			      String MatriculeValue = AddVoitureJtext.getText();	
			      //add new car using its Matricule
			      if( !MatriculeValue.contentEquals("Enter La Matricule!")) {
			      P.StationerVoiture(MatriculeValue);
			      //Actualise
			      AddVoitureJtext.setText("");
			      NbrPlacesOccupetext.setText(Integer.toString(P.nbrePlaces()-P.placesLibres()));
			      NbrPlacesLibreJtext.setText(Integer.toString(P.placesLibres()));
			  
			      //Tableau
					Table(P);      
			     }
				  }
			   }
			});
		
		//remove a car button
		removeCarButton.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent ae){
				  if(!RemoveVoitureJtext.getText().isEmpty()) {
			      int IndiceValue = Integer.parseInt(RemoveVoitureJtext.getText());
			   
			      if(IndiceValue >=1 ) {
			 String PrixTextera= ""+P.CalculePrix(P.voituresStationees.get(IndiceValue-1).getDateEntre())+"";
				 P.sortirVoiture(IndiceValue);  
				 RemoveVoitureJtext.setText("");  
				 
				 //Actualise
			      NbrPlacesOccupetext.setText(Integer.toString(P.nbrePlaces()-P.placesLibres()));
			      NbrPlacesLibreJtext.setText(Integer.toString(P.placesLibres()));

			     //Tableau
				   Table(P);  
				   
				 //Affichage de prix et nombre des Heures
			
				   JTextArea prix = new JTextArea(PrixTextera);
				   prixframe.add(prix);
				   prixframe.setVisible(true);
				  }       
			         
			     }
			   }
			});
		
		
		
		//button's Listes des voitures stationnes
		listeCarsButton.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent ae){   
				   Table(P); 
				   listeVoitures.setText("Listes des voitures stationnées ");
			   }
			});
		
		//button's removed cars	
		removedCarsButton.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent ae){   
				   ListeRemovedCars(P);//line 327
				   listeVoitures.setText("Listes des voitures qui sont sorties");
			   }
			});
		
		
		frame.setVisible(true);
	}//end of frontEnd function
	
	
	//Tableau
	public static void Table(Parking P) {
		
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		//delete old table
		if (model.getRowCount() > 0) {
		    for (int i = model.getRowCount() - 1; i > -1; i--) {
		    	model.removeRow(i);
		    }
		}
		//remplace with new table
		if (P.listerVoitures().size()>0){
			int i=1;
			for (Voiture v : P.listerVoitures()){
		        model.insertRow(jTable1.getRowCount(), new Object[] {
				i++,v.getMatricule(),v.getDateEntre(),v.getDateSorte()		
		       });
			}
		 }
	}
	
	//Listes des voitures qui sont sortees
	public static void ListeRemovedCars(Parking P) {
		
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		//delete old table
		if (model.getRowCount() > 0) {
		    for (int i = model.getRowCount() - 1; i > -1; i--) {
		    	model.removeRow(i);
		    }
		}
		//remplace with new table
		
		Object[] chaine =  P.listerVoituresSortees().lines().toArray();
 		for(int i = 1; i < chaine.length; i++)
 		{ 
	       String cases = chaine[i].toString().trim();
	       String[] dataRow = cases.split(",");
	       model.addRow(dataRow);
	    }
	}
	
}
