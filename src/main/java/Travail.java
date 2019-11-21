import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Travail {
    private double ponderation;
    private String code;
    private Map<Etudiant,Remise> remises = new HashMap<>();

    public List<Remise> getRemise() {
        return new ArrayList(remises.values());
    }

    public double getPonderation() {
        return ponderation;
    }

    public String getCode() {
        return code;
    }
}
