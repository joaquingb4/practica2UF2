package practica2Uf2V2;

import java.util.Date;

public class Lloguer {
	//Atributos
		private static final int diesInicials =3;
		private Date data;
		private int dies;
		private Vehicle vehicle;

		//Getters y Setters

	
		//Constructores
		public Lloguer(Date data, int dies, Vehicle vehicle) {
			this.data=data;
			this.dies=dies;
			this.vehicle = vehicle;
		}
		//Getters y Setters
		public Vehicle getVehicle() {
			return vehicle;
		}
		public int getDies() {
			return dies;
		}
		public Date getData() {
			return data;
		}
		
		//__________________Refracción___________
		public double preu() {
	    	double preu = 0;
	    	switch (getVehicle().getCategoria()) {
	        case Vehicle.BASIC:
	            preu += 3;
	            if (getDies() > diesInicials) {
	                preu += (getDies() - diesInicials) * 1.5;
	            }
	            break;
	        case Vehicle.GENERAL:
	            preu += 4;
	            if (getDies() > 2) {
	                preu += (getDies() - 2) * 2.5;
	            }
	            break;
	        case Vehicle.LUXE:
	            preu += getDies() * 6;
	            break;
	    	}
	    	return preu;
	    }
		//____________________________________________
		public int bonificacions() {
	    	int bonificacions =0;
	    	bonificacions ++;

	        // afegeix bonificació per dos dies de lloguer de Luxe
	        if (getVehicle().getCategoria() == Vehicle.LUXE &&
	                getDies()>1 ) {
	            bonificacions ++;
	        }
	        return bonificacions;
	    }
}


