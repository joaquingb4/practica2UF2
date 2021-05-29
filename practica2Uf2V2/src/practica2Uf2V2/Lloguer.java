package practica2Uf2V2;

import java.util.Date;

public class Lloguer {
	//Atributos
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
}
