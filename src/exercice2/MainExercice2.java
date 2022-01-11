package exercice2;

import exercice2.models.*;
import datamocklib.TxtHelper;

import java.io.FileNotFoundException;
import java.util.List;

public class MainExercice2 implements Exo2 {

    /* EXO 2
     * Recupérez depuis le serveur la liste des gens qui sont nés à Chambéry.
     * La récupération de Data se fait dans l'ordre :
     *  - Récupération de data sur le server grâce à TxtHelper.getDataFromTxt("server.txt");
     *  - Vider la base de données locale grâce à la fonction TxtHelper.clearDataLocal();
     *  - Insérer les données dans la database locale grâce à la fonction TxtHelper.insertDataInTxt(line, "local.txt")
     *  - Afficher les données locale grace à TxtHelper.getDataFromTxt("local.txt")
     */


    @Override
    public void displayPersonFromChambery() throws FileNotFoundException {
        List<String> dataServer = TxtHelper.getDataFromTxt("server.txt");
        TxtHelper.clearDataLocal();
        for (String line : dataServer) {
            String[] person = line.split(",");
            if (person[5].matches("Chambery")) {
                TxtHelper.insertDataInTxt(line, "local.txt");
            }
        }
        TxtHelper.getDataFromTxt("local.txt");
    }

    /*
     * Recupérez depuis le serveur la liste des gens qui ont plus de 25 ans.
     * La récupération de Data se fait comme dans la question précedente
     * Tips : Vous avez dans la class Person la fonction getAge();
     */
    @Override
    public void displayBoomers() {

    }

    /*
     * Recupérez depuis le serveur la liste des gens de sexe féminin.
     * La récupération de Data se fait comme dans la question précedente
     */
    @Override
    public void displayFemales() {

    }

    /*
     * Recupérez depuis le serveur la liste des femmes de plus de 25 ans.
     * La récupération de Data se fait comme dans la question précedente
     */
    @Override
    public void displayFemaleBoomers() {

    }

    public static void main(String[] args) throws FileNotFoundException {
        Exo2 exo2 = new MainExercice2();
        exo2.displayPersonFromChambery();
    }
}
