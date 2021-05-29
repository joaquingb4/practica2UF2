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
    public String informe() {
        String resultat = "Informe de lloguers del client " +
            getNom() +
            " (" + getNif() + ")\n";
        for (Lloguer lloguer: lloguers) {
        	
            // composa els resultats d'aquest lloguer
            resultat += "\t" +
                lloguer.getVehicle().getMarca() +
                " " +
                lloguer.getVehicle().getModel() + ": " +
                (lloguer.quantitat() * EUROS_PER_UNITAT_DE_COST) + "€" + "\n";
        }

        // afegeix informació final
        resultat += "Import a pagar: " + importTotal() + "€\n" +
            "Punts guanyats: " + bonifiacionsTotals() + "\n";
        return resultat;
    }
  //___________________Refracción_______________________
    public double importTotal() {//<--de importe traducido a import
    	double total = 0;
    	for (Lloguer lloguer: lloguers) {
    		total+= lloguer.quantitat()*30;
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
    
}
