package dom;

public class Yelling{
    private Double strength;
    public Yelling(Double strength){
        this.strength = strength;
    }

    public Double getStrength() {
        return strength;
    }

    public String toString(){
        return this.strength.toString();
    }
}
