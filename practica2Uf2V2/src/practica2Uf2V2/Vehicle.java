package practica2Uf2V2;

public class Vehicle {
	public static final String BASIC ="BASIC";
	public static final String GENERAL = "GENERAL";
	public static final String LUXE = "LUXE";
	private String model;
	private String marca;
	private String categoria;
	//Constructores
	public Vehicle() {

	}
	public Vehicle(String model, String marca, String categoria) {
		this.model= model;
		this.marca= marca;
		this.categoria= categoria;
	}

	//GETTERS Y SETTERS

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


}
