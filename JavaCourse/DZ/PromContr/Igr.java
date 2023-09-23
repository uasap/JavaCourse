public class Igr {
    private int id;
    private String name;
    private int num;
    private double weight;

    public Igr(int id, String name, int num, double weight) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public int getNum() {
        return num;
    }

    public double getWeight() {
        return weight;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}