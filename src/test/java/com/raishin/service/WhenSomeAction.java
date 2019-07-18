package com.raishin.service;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static junit.framework.Assert.assertTrue;

@JGivenStage
public class WhenSomeAction{

    @ScenarioState
    String name;
    @ScenarioState
    String sex;
    @ScenarioState
    boolean otokoflg;

    public void 男判別() {
        if(sex.equals("男")) otokoflg = true;
        else otokoflg = false;
    }
}