import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class SocieteArrayList<T extends Employe> implements IGestion<T> {
    private ArrayList<Object> listeEmployes;

    public SocieteArrayList() {
        listeEmployes = new ArrayList<>();
    }

    @Override
    public void ajouterEmploye(Employe employe) {
        listeEmployes.add(employe);
    }

    @Override
    public boolean rechercherEmploye(String nom) {
        for (Employe employe : listeEmployes) {
            if (employe.getNom().equals(nom)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherEmploye(T employe) {
        return listeEmployes.contains(employe);
    }

    @Override
    public void supprimerEmploye(T employe) {
        listeEmployes.remove(employe);
    }

    @Override
    public void displayEmploye() {
            System.out.println(listeEmployes);
    }

    @Override
    public void trierEmployeParId() {
        Collections.sort(listeEmployes);
    }

    @Override
    public void trierEmployeParNomDepartementEtGrade() {
        Collections.sort(listeEmployes, new Comparator<T>() {
            @Override
            public int compare(T employe1, T employe2) {
                int comparaisonNom = employe1.getNom().compareTo(employe2.getNom());
                if (comparaisonNom != 0) {
                    return comparaisonNom;
                }

                int comparaisonDepartement = employe1.getNomDepartement().compareTo(employe2.getNomDepartement());
                if (comparaisonDepartement != 0) {
                    return comparaisonDepartement;
                }

                // Comparaison par grade
                return employe1.getGrade().compareTo(employe2.getGrade());
            }
        });
    }
}

