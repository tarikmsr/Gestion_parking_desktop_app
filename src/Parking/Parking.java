package Parking;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

	public class Parking {
		
		private int nbrePlaces; 
		public ArrayList<Voiture> voituresStationees;
	
	public Parking(int nbrePlaces){
		this.nbrePlaces = nbrePlaces;
		voituresStationees = new ArrayList<Voiture>();
	}
	
	public int nbrePlaces(){ return nbrePlaces; }
	public int placesLibres(){return nbrePlaces - voituresStationees.size();}
	
	
	public void StationerVoiture(String Matricule){
		
		if (placesLibres()<1){
		System.out.println("L'aire de stationnement est complet. Veuillez attendre SVP !");
		} else {
		Voiture v = new Voiture(Matricule); 
		voituresStationees.add(v); 
		}
	}
	
	public void sortirVoiture(int indece)	{
	
		if (indece < 1 || indece > voituresStationees.size()){
		System.err.println("erreur d'indice invalid dans la fonction sortirVoiture() ligne:41 (Parking class)"); 
		} else {
			final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date currentDate = new Date();
			voituresStationees.get(indece-1).setDateSorte(dateFormat.format(currentDate));
			//stocker dans un fichier 
			SaveVoitureSort(voituresStationees.get(indece-1));
			voituresStationees.remove(indece-1); //on eleve la voiture de voituresStationees 
			}
	}
	
	//Enregistrer les voiture qui sont sortir
	public static void SaveVoitureSort(Voiture v)  {
		
		File myFile = new File("StorageFile.txt");
		try {
			if(myFile.createNewFile()) {
				FileWriter myWriter = new FileWriter(myFile.getPath(),true); 
				myWriter.write("Matricule,\t Date Entre,\t\t Date Sorte,\n");
				 myWriter.close();
				  
				System.out.println("the file "+myFile.getName()+" created seccussfuly !");
			}else System.out.println("The file already exist!");
		} catch (IOException e) { System.err.println("\nError in creating File :"+e);}		
								
		//Write on the file
		try {
		FileWriter myWriter = new FileWriter(myFile.getPath(),true);//+true pour ne ep ecraser      
			myWriter.write(v.getMatricule()+",\t"+v.getDateEntre()+",\t"+v.getDateSorte()+",\n");
			  myWriter.close();
	      } catch (IOException e) {System.err.println("\nError in writing on File : "+e);} 
	}
	
	//restauration
	public String listerVoituresSortees() {
		 String data = "\n" ;
	   	//read from the file
		  File myfile = new File("ParkingFile-ELMSAOURI-ELGHIZI.txt");
	      try {
			FileReader myReader = new FileReader(myfile.getPath());
		    Scanner sc = new Scanner(myfile);
		    	    sc.nextLine();//pour detruire le 1er ligne qui contient les nom des colonnes
		     int i=1;
		    	while(sc.hasNextLine()) {   
		    	  data+=i+++","+sc.nextLine()+"\n";
		        } 
	             sc.close();
	      } catch (FileNotFoundException e) { 
	    	  System.err.println("\nError in reading File :"+e+" ligne 88 (Parking Class)");} 
	    
	      return data;
	}
	
	public String CalculePrix(String DateEntre) { 
		int nbrHeures = 0,nbrMinutes=0;
		float prix=2;
		String chainePrix = null;
		
		final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date currentDate = new Date();
		Date dateEntreDateType;
		try {
			dateEntreDateType = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(DateEntre);
		
		Date nbrSecondes = new Date(currentDate.getTime() - dateEntreDateType.getTime());
		nbrHeures=(int) nbrSecondes.getTime()/1000/60/60;
		nbrMinutes=(int) nbrSecondes.getTime()/1000/60;
		chainePrix=" Date d'entrer:  "+DateEntre+"\n Date de sortir: "+dateFormat.format(currentDate);
		chainePrix+="\n Nombre des Heures : " + nbrHeures+"h "+(nbrMinutes-60*nbrHeures)+" min";
		
		} catch (ParseException e) {
			System.err.println("erreur dans la fonction CalculePrix() ligne:111 (Parking class)"); }  	
		
		//On suppose que le prix est 2dh/h et le prix=0 si l'heure ne depasse pas 5min
		//si le nombre d'heures depase 24 on change le calcule
		if(nbrMinutes < 5 ) {
			prix=0;
		}else if(nbrHeures <= 12 ) {
			prix=nbrHeures*2;
		}else if(nbrHeures>12 || nbrHeures <24 ){
			prix=(float) (nbrHeures*1.5);
		}else if(nbrHeures >24 && nbrHeures <= 360) {//C'est à dire, moins d'un 15 jours
			prix= (float) ((nbrHeures/24)*20+(nbrHeures%24)*1.5);//On calcule 20dh/jour et 1.5 par/heures
		}else if(nbrHeures >360 && nbrHeures <720) {//C'est à dire, moins d'un mois
			prix= (float) ((nbrHeures/24)*10+(nbrHeures%24)*1.5);//On calcule 10dh/jour et 1.5 par/heures
		}
		
		return chainePrix+"\n Le prix: "+prix+" Dh"; 	
	}
	
	
	public ArrayList<Voiture> listerVoitures()	{//pour les voitures qui ne sont pas encore enregistrees
		return voituresStationees;
	}
		
}
	
	
	