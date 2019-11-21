import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupeClass {
    private List<Travail> travaux = new ArrayList();
    private List<Etudiant> etudiantsInscrits = new ArrayList();

    public void publierNotes(){

        if(travaux.size() == 0){return ;}

        Map<Etudiant,Double> notesPondereesParEtudiant = new HashMap();

        for (Travail travail : travaux){

            for(Remise remise : travail.getRemise()){
                Etudiant etudiantRemise = remise.getEtudiant();

                double note = remise.getNote();
                double ponderation = travail.getPonderation();
                double notePonderee = note * ponderation;

                etudiantRemise.getDossier().inscrireResultatTravail(travail.getCode(),notePonderee);
                notesPondereesParEtudiant.merge(etudiantRemise,notePonderee,(x,y) -> x + y);

            }
        }


        for(Etudiant etudiant : etudiantsInscrits){
            double total = notesPondereesParEtudiant.getOrDefault(etudiant, 0.0);
            etudiant.getDossier().fixerCote(total);
        }
    }

}
