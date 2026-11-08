package service;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService(
        endpointInterface = "service.IEtudiant",
        serviceName = "GestionEtudiantsService",
        targetNamespace = "http://service/"
)
public class GestionEtudiants implements IEtudiant {
    private final ArrayList<Etudiant> etudiants =
            new ArrayList<>();

    // 1. Ajouter un étudiant
    @Override
    public synchronized String ajouterEtudiant(
            int id, String nom,
            String prenom, double moyenne) {

        if (id <= 0) {
            return "Identifiant invalide";
        }

        if (moyenne < 0 || moyenne > 20) {
            return "La moyenne doit etre entre 0 et 20";
        }

        for (Etudiant e : etudiants) {
            if (e.getId() == id) {
                return "Cet identifiant existe deja";
            }
        }

        Etudiant e = new Etudiant(
                id, nom, prenom, moyenne
        );

        etudiants.add(e);

        return "Etudiant ajoute avec succes";
    }

    // 2. Rechercher un étudiant
    @Override
    public synchronized Etudiant rechercherEtudiant(int id) {

        for (Etudiant e : etudiants) {
            if (e.getId() == id) {
                return e;
            }
        }

        return null;
    }

    // 3. Supprimer un étudiant
    @Override
    public synchronized String supprimerEtudiant(int id) {

        for (Etudiant e : etudiants) {
            if (e.getId() == id) {
                etudiants.remove(e);

                return "Etudiant supprime avec succes";
            }
        }

        return "Etudiant introuvable";
    }

    // 4. Afficher tous les étudiants
    @Override
    public synchronized Etudiant[] afficherEtudiants() {

        return etudiants.toArray(
                new Etudiant[0]
        );
    }

    // 5. Calculer la moyenne générale
    @Override
    public synchronized double calculerMoyenneGenerale() {

        if (etudiants.isEmpty()) {
            return 0;
        }

        double somme = 0;

        for (Etudiant e : etudiants) {
            somme += e.getMoyenne();
        }

        return somme / etudiants.size();
    }

}
