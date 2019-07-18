package com.raishin.service;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.annotation.ScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import static junit.framework.Assert.*;


@JGivenStage
public class ThenSomeOutcome{
    @ScenarioState
    String name;
    @ScenarioState
    String sex;
    @ScenarioState
    boolean otokoflg;

    @As("男であることを確認する")
    public void 男であることを確認() {
        assertTrue(otokoflg);
    }

//    public ThenSomeOutcome some_outcome() {
//        return this();
//    }
}