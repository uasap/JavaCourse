import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IgrStore {
    private List<Igr> igrushki;
    private List<Igr> prizeIgruski;

    public IgrStore() {
        igrushki = new ArrayList<>();
        prizeIgruski = new ArrayList<>();
    }

    public void addIgr(int id, String name, int quantity, double weight) {
        Igr igr = new Igr(id, name, quantity, weight);
        igrushki.add(igr);
    }

    public void setToyWeight(int id, double weight) {
        for (Igr igr : igrushki) {
            if (igr.getId() == id) {
                igr.setWeight(weight);
                break;
            }
        }
    }

    public void play() {
        // calculate total weight
        double totalWeight = 0;
        for (Igr igr : igrushki) {
            totalWeight += igr.getWeight();
        }

        Random rand = new Random();
        double randomNumber = rand.nextDouble() * totalWeight;

        // find the prize toy
        Igr prizeIgr = null;
        for (Igr igr : igrushki) {
            if (randomNumber < igr.getWeight()) {
                prizeIgr = igr;
                break;
            }
            randomNumber -= igr.getWeight();
        }

        // add the prize toy to the list of prize toys
        if (prizeIgr != null && prizeIgr.getQuantity() > 0) {
            prizeIgruski.add(prizeIgr);

            // decrement the quantity of the prize toy
            prizeIgr.setQuantity(prizeIgr.getQuantity() - 1);
        }
    }

    public void getPrizeIgr() throws IOException {
        if (prizeIgruski.size() > 0) {
            // remove the first prize toy from the list of prize toys
            Igr prizeToy = prizeIgruski.remove(0);

            // write the prize toy to a file
            FileWriter writer = new FileWriter("prize_igr.txt", true);
            String str = prizeToy.getId() + "," + prizeToy.getName() + "\n";
            writer.write(str);
            writer.close();
            
            System.out.println(str);
        }
    }
}