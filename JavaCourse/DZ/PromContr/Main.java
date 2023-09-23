import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        IgrStore store = new IgrStore();

        // add some igr
        store.addIgr(1, "Igr 1", 10, 20);
        store.addIgr(2, "Igr 2", 5, 10);
        store.addIgr(3, "Igr 3", 20, 40);
        store.addIgr(4, "Igr 4", 10, 55);
        store.addIgr(5, "Igr 5", 5, 32);
        store.addIgr(6, "Igr 6", 20, 82);
        store.addIgr(7, "Igr 7", 43, 99);
        store.addIgr(8, "Igr 8", 25, 17);


        // set the weight of a igr
        store.setToyWeight(2, 41);
        store.setToyWeight(5, 67);
        store.setToyWeight(4, 80);

        store.play();
        store.getPrizeIgr();      
       
    }
}