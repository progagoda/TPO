package dom;

import java.util.List;

public class YellingAction extends Action{

    private YellingSeries yellingSeries;

    public YellingAction(String reason, String actionContent) {
        super(reason, actionContent);
    }

    public YellingAction(List<IActionTarget> target, YellingSeries yellingSeries){
        super("Yelling", target);
        this.yellingSeries = yellingSeries;
    }

    public void invoke(){
        this.setActionContent("Вопить с силой " + yellingSeries.toString());
    }

    public void setYellingSeries(YellingSeries yellingSeries){
        this.yellingSeries = yellingSeries;
    }

    public String toString(){
        return this.getActionContent();
    }
}
