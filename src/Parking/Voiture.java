package Parking;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Voiture{

	private String Matricule ;
	private String DateEntre;
	private String DateSorte;
	// static nbr_car
	
	public Voiture(String Matricule )
	{	
		final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");		
		Date currentDate = new Date();
		this.Matricule =Matricule ;
		this.DateEntre= dateFormat.format(currentDate);  //String
		//nbr_car++
	}
	
	
	public String getMatricule() {
		return Matricule ;
	}
	public void setMatricule(String Matricule ) {
		this.Matricule  = Matricule ;
	}

	public String getDateEntre() {
		return DateEntre;
	}

	public void setDateEntre(String dateEntre) {
		DateEntre = dateEntre;
	}

	public String getDateSorte() {
		return DateSorte;
	}

	public void setDateSorte(String dateSorte) {
		DateSorte = dateSorte;
	}
}
	
