package dom;

import java.util.List;

public class Action {
    private String reason;
    private String actionContent;
    private String period;
    private Action additionalAction;
    private List<IActionTarget> targetList;

    public Action(String reason, String actionContent){
        this.reason = reason;
        this.actionContent = actionContent;
    }

    public Action (String actionContent, List<IActionTarget> target){
        this.actionContent = actionContent;
        this.targetList = target;
    }

    public String getReason() {
        return reason;
    }

    public String getActionContent() {
        return actionContent;
    }

    public void setActionContent(String actionContent) {
        this.actionContent = actionContent;
    }

    public String getPeriod() {
        return period;
    }

    public String toString() {
        return actionContent;
    }

    public Action getAdditionalAction() {
        return additionalAction;
    }
}
