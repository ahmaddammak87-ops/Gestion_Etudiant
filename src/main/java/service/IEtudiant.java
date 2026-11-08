package service;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(
        name = "IEtudiant",
        targetNamespace = "http://service/"
)
public interface IEtudiant {
    // Ajouter un étudiant
    @WebMethod
    String ajouterEtudiant(
            @WebParam(name = "id") int id,
            @WebParam(name = "nom") String nom,
            @WebParam(name = "prenom") String prenom,
            @WebParam(name = "moyenne") double moyenne
    );

    // Rechercher un étudiant par son ID
    @WebMethod
    Etudiant rechercherEtudiant(
            @WebParam(name = "id") int id
    );

    // Supprimer un étudiant
    @WebMethod
    String supprimerEtudiant(
            @WebParam(name = "id") int id
    );

    // Afficher tous les étudiants
    @WebMethod
    Etudiant[] afficherEtudiants();

    // Calculer la moyenne générale de tous les étudiants
    @WebMethod
    double calculerMoyenneGenerale();
}
