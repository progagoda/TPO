package dom;

import java.util.List;

public class YellingSeries {
    private List<Yelling> yellingSeries;
    private boolean refreshing;

    public YellingSeries(List<Yelling> yellingSeries, boolean refreshing) {
        this.yellingSeries = yellingSeries;
        this.refreshing = refreshing;
    }

    public List<Yelling> getYellingSeries() {
        return yellingSeries;
    }

    public void setYellingSeries(List<Yelling> yellingSeries) {
        this.yellingSeries = yellingSeries;
    }

    public boolean isRefreshing() {
        return refreshing;
    }

    public void setRefreshing(boolean refreshing) {
        this.refreshing = refreshing;
    }

    public String toString(){
        String yellingStrengths = "";
        for (Yelling yelling : yellingSeries){
            yellingStrengths += yelling.getStrength().toString();
        }
        return yellingStrengths;
    }
}
