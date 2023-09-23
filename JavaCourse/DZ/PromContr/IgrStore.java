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

    public void addIgr(int id, String name, int num, double weight) {
        Igr igr = new Igr(id, name, num, weight);
        igrushki.add(igr);
    }

    public void setIgrWeight(int ident, double weight) {
        for (Igr igr : igrushki) {
            if (igr.getId() == ident) {
                igr.setWeight(weight);
                break;
            }
        }
    }

    public void process() {        
        double totalWeight = 0;
        for (Igr igr : igrushki) {
            totalWeight += igr.getWeight();
        }

        Random rand = new Random();
        double randomNumber = rand.nextDouble() * totalWeight;

        // найти призовую игрушку
        Igr prizeIgr = null;
        for (Igr igr : igrushki) {
            if (randomNumber < igr.getWeight()) {
                prizeIgr = igr;
                break;
            }
            randomNumber -= igr.getWeight();
        }

        // добавить призовую игрушку в лист 
        if (prizeIgr != null && prizeIgr.getNum() > 0) {
            prizeIgruski.add(prizeIgr);

            // уменьшить количество призовых игрушек
            prizeIgr.setNum(prizeIgr.getNum() - 1);
        }
    }

    public void getPrizeIgr() throws IOException {
        if (prizeIgruski.size() > 0) {
            // удалить первую призовую игрушку из листа призовых игрушек
            Igr prizeToy = prizeIgruski.remove(0);

            // записать призовую игрушку в файл
            FileWriter writer = new FileWriter("prize_igr.txt", true);
            String str = prizeToy.getId() + "," + prizeToy.getName() + "\n";
            writer.write(str);
            writer.close();
            
            System.out.println(str);
        }
    }
}