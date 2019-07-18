package com.raishin.service;

import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import org.junit.Test;

public class MemoServiceTest extends SpringScenarioTest<GivenSomeState, WhenSomeAction, ThenSomeOutcome> {
    @Test
    public void something_should_happen() {
        given()
                .名前をセット("太郎")
                .性別をセット("男");

        when().男判別();

        then().男であることを確認();
    }
}
