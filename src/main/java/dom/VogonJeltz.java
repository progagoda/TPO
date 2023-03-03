package dom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


public class VogonJeltz {

    private String name;
    private String feels;
    private boolean readyForAbomination;

    public VogonJeltz(String name){
        this.name = name;
        this.readyForAbomination = false;
    }

    public boolean isReadyForAbomination(){
        return this.readyForAbomination;
    }

    public Action smile(){
        Action action = new Action("Не мог вспомнить правильную последовательность движения мышц", "Улыбнулся очень медленно");
        return action;
    }

    private Action yell(List<IActionTarget> yellTarget){
        List<Double> yellingStrengths = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Double yellingStrength = ThreadLocalRandom.current().nextDouble(0, 100);
            yellingStrengths.add(yellingStrength);
        }

        List<Yelling> yellings = yellingStrengths.stream()
                .map(yellingStrength -> new Yelling(yellingStrength))
                .collect(Collectors.toList());

        YellingSeries yellingSeries = new YellingSeries(yellings,true);
        YellingAction yellingAction = new YellingAction(yellTarget, yellingSeries);
        yellingAction.invoke();
        return yellingAction;
    }

    public Action pamperThemselvesByYellingOn(List<IActionTarget> target){
        Action action = this.yell(target);
        this.feels = "Отдохнувший";
        this.readyForAbomination = true;
        return action;
    }

    public String getFeels(){
        return this.feels;
    }

    public String toString(){
        return this.name;
    }
}
