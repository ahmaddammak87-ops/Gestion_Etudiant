package serveur;
import javax.xml.ws.Endpoint;
import service.GestionEtudiants;
public class ServeurJWS {
    public static void main(String[] args) {

        String url =
                "http://localhost:8080/GestionEtudiantsWS";

        Endpoint.publish(url, new GestionEtudiants());

        System.out.println(
                "Service GestionEtudiants publie avec succes !"
        );

        System.out.println("URL : " + url);

        System.out.println("WSDL : " + url + "?wsdl");
    }
}
