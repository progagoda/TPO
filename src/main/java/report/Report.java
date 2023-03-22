package report;

public class Report {
    public String report;

    public Report(){
       this.report = "";
    }
    public void add(String rep) {
        this.report += rep;
    }
}
