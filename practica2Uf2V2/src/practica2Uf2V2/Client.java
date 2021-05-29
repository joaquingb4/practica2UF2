package practica2Uf2V2;

import java.util.Vector;

public class Client {
	private static final double EUROS_PER_UNITAT_DE_COST = 30;
    private String nif;
    private String nom;
    private String telefon;
    private Vector<Lloguer> lloguers;

    public Client(String nif, String nom, String telefon) {
        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
        this.lloguers = new Vector<Lloguer>();
    }

    public String getNif()     { return nif;     }
    public String getNom()     { return nom;     }
    public String getTelefon() { return telefon; }

    public void setNif(String nif) { this.nif = nif; }
    public void setNom(String nom) { this.nom = nom; }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public void afegeix(Lloguer lloguer) {
        if (! lloguers.contains(lloguer) ) {
            lloguers.add(lloguer);
        }
    }
    public void elimina(Lloguer lloguer) {
        if (lloguers.contains(lloguer) ) {
            lloguers.remove(lloguer);
        }
    }
    public boolean conte(Lloguer lloguer) {
        return lloguers.contains(lloguer);
    }
    //________________________________________________
    
  //___________________Refracción_______________________
    public double importTotal() {//<--de importe traducido a import
    	double total = 0;
    	for (Lloguer lloguer: lloguers) {
    		total+= lloguer.preu()*30;
    	}
    	return total;
    }
    public int bonifiacionsTotals() {
    	int bonificacions=0;
    	for (Lloguer lloguer: lloguers) {
        	bonificacions += lloguer.bonificacions();
    	}
    	return bonificacions;
    }
  //___________________________________________________________
    public String informe() {
    	return composaCapsalera() +
    			composaDetall() + 
    			composaPeu();
    }
    public String composaCapsalera() {
    	return "Informe de lloguers del client " +
                getNom() +
                " (" + getNif() + ")\n";
    }
    
    public String composaDetall() {
    	String resultat="";
    	for (Lloguer lloguer: lloguers) {
            // composa els resultats d'aquest lloguer
            resultat += "\t" +
                lloguer.getVehicle().getMarca() +
                " " +
                lloguer.getVehicle().getModel() + ": " +
                (lloguer.preu() * EUROS_PER_UNITAT_DE_COST) + "€" + "\n";
        }
    	return resultat;
    }
    public String composaPeu() {
    	return  "Import a pagar: " + importTotal() + "€\n" +
                "Punts guanyats: " + bonifiacionsTotals() + "\n";	
    }
    //____________________________________________________________
    public String informeHTML() {
    	return composaCapsaleraHTML() +
    			composaDetallHTML() + 
    			composaPeuHTML();
    }
    public String composaCapsaleraHTML() {
    	return "<p>Informe de lloguer del clients <em>" +
				getNom() + "</em> ( <strong>" + getNif() +"</strong>)</p>"+ "\n"; 	
    }
    public String composaDetallHTML() {  	
    	String resultado = "<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>"+ "\n";
    	for (Lloguer lloguer: lloguers) {
    		resultado+= "<tr><td>"+lloguer.getVehicle().getMarca()+"</td><td>"+lloguer.getVehicle().getModel()+"</td><td>"+
    				(lloguer.preu() * EUROS_PER_UNITAT_DE_COST) + "€" + "\n"+"</td></tr>"+"\n";
    	}
    	return resultado;
    }
    public String composaPeuHTML() {
    	return "<p>Import a pagar: <em>"+importTotal()+"</em></p>"+"\n"+
    			"<p>Punts guanyats: <em>"+bonifiacionsTotals()+"</em></p>";
    }
    
    
}
