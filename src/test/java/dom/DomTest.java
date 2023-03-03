package dom;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class DomTest {
    static VogonJeltz vogonJeltz;
    static Prisoner prisoner;
    static List<IActionTarget> prisoners;
    static Action action;
    static Yelling yelling;
    static YellingAction yellingAction;
    static YellingSeries yellingSeries;

    @BeforeAll
    public static void createAll(){
        vogonJeltz = new VogonJeltz("Простетный Вогон Джельц");
        prisoner = new Prisoner("Роберт");
        List<String> prisonerNames = Arrays.asList("Артем", "Антон", "Дмитрий", "Василий", "Анатолий");
        prisoners = prisonerNames.stream()
                .map(prisonerName -> new Prisoner(prisonerName))
                .collect(Collectors.toList());
        action = new Action("Голод", "Есть");
        yelling = new Yelling(10D);
        yellingSeries = new YellingSeries(Arrays.asList(yelling),true);
        yellingAction = new YellingAction("Гнусность", "Вопить");
        yellingAction.setYellingSeries(yellingSeries);
    }

    @Test
    public void toStringTest(){
        assertEquals(vogonJeltz.toString(), "Простетный Вогон Джельц");
        assertEquals(prisoner.toString(), "Роберт");
        assertEquals(prisoners.get(0).toString(), "Артем");
        assertEquals(prisoners.get(prisoners.size()-1).toString(), "Анатолий");
        assertEquals(action.toString(), "Есть");
        assertEquals(yelling.toString(), "10.0");
        assertEquals(yellingAction.toString(), "Вопить");
        assertEquals(yellingSeries.toString(), "10.0");
    }

    @Test
    public void actionTest(){
        assertEquals(action.getActionContent(), "Есть");
        assertEquals(action.getReason(), "Голод");
    }

    @Test
    public void prisonerTest(){
        assertEquals(prisoner.getName(), "Роберт");
    }

    @Test
    public void vogonJeltzTest(){
        Action smileAction = vogonJeltz.smile();
        assertEquals(smileAction.toString(), "Улыбнулся очень медленно");
        assertNotEquals(smileAction.getReason(), "Ради эффекта");
        assertEquals(smileAction.getReason(), "Не мог вспомнить правильную последовательность движения мышц");
        Assumptions.assumeFalse(vogonJeltz.isReadyForAbomination());
        vogonJeltz.pamperThemselvesByYellingOn(prisoners);
        assertTrue(vogonJeltz.isReadyForAbomination());
        assertEquals(vogonJeltz.getFeels(), "Отдохнувший");
    }

    @Test
    public void yellingTest(){
        assertEquals(yelling.getStrength(), 10D);
    }

    @Test
    public void yellingActionTest(){
        assertEquals(yellingAction.getActionContent(), "Вопить");
        yellingAction.invoke();
        assertEquals(yellingAction.getActionContent(), "Вопить с силой 10.0");
    }

}
