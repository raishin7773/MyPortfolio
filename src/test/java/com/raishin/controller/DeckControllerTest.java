package com.raishin.controller;


import com.raishin.repository.DeckRepository;
import com.raishin.service.DeckService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DeckControllerTest {

    @Mock
    DeckRepository deckRepository;

    @Mock
    DeckService deckService;

    @InjectMocks
    DeckController target;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(target).build();
    }

    @Test
    public void indexTest() throws Exception {
        doNothing().when(deckService).initView(any(),any());
        mockMvc.perform(get("/portfolio/deck/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("deck/starter"));
    }
    @Test
    public void deleteTest() throws Exception {
        doNothing().when(deckService).initView(any(),any());
        doNothing().when(deckService).deckDelete(any());
        mockMvc.perform(get("/portfolio/deck/delete"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("message", "削除しました"))
                .andExpect(view().name("deck/starter"));
    }

    @Test
    public void updateTest() throws Exception {
        doNothing().when(deckService).initView(any(),any());
        doNothing().when(deckService).deckUpdate(any());
        mockMvc.perform(get("/portfolio/deck/update"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("message", "更新しました"))
                .andExpect(view().name("deck/starter"));
    }
    @Test
    public void insertTest() throws Exception {
        doNothing().when(deckService).initView(any(),any());
        doNothing().when(deckService).deckInsert(any());
        mockMvc.perform(get("/portfolio/deck/insert"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("message", "更新しました"))
                .andExpect(view().name("deck/starter"));
    }

    @Test
    public void excelTest() throws Exception {
        doNothing().when(deckService).initView(any(),any());
        doNothing().when(deckService).deckInsert(any());
        mockMvc.perform(get("/portfolio/deck/excel"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("fileName", "デッキ一覧.xls"));
    }

}
