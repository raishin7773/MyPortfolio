package com.raishin.service;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.Quoted;
import com.tngtech.jgiven.annotation.ScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class GivenSomeState {
    @ScenarioState
    String name;
    @ScenarioState
    String sex;

    public GivenSomeState 名前をセット(@Quoted String s) {
        name = s;
        return this;
    }

    public GivenSomeState 性別をセット(@Quoted String s) {
        sex = s;
        return this;
    }

    public GivenSomeState 名前と性別をセット(@Quoted String pname, @Quoted String psex) {
        name = pname;
        sex = psex;
        return this;
    }
}