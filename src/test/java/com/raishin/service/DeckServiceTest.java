package com.raishin.service;

import com.raishin.entity.DeckEntity;
import com.raishin.form.DeckForm;
import com.raishin.repository.DeckRepository;
import org.hibernate.validator.constraints.ModCheck;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@EnableCaching
public class DeckServiceTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DeckService deckService;

    @MockBean
    DeckRepository deckRepository;

    @Autowired
    CacheManager cacheManager;

    DeckEntity deckEntity;

    List<DeckEntity> deckEntityList;

    private void putCache() {
        //キャッシュを取得
        Cache cache = cacheManager.getCache("sample");
        //キー：引数なし、値：作成したデッキリストをキャッシュにセット
        cache.put(SimpleKey.EMPTY,deckEntityList);
        //対象のキーでキャッシュの値を取得して表示
        logger.info(cache.get(SimpleKey.EMPTY).get().toString());
    }

    //必要なBeanを定義
    @TestConfiguration
    @EnableConfigurationProperties
    public static class Config {

        @Bean
        public CacheManager cacheManager() {
            return new ConcurrentMapCacheManager("sample");
        }

        @Bean
        DeckService deckService() {
            return new DeckService();
        }

        @Bean
        DeckRepository deckRepository() {
            return Mockito.mock(DeckRepository.class);
        }

    }

    //テスト前に実行する処理
    @Before
    public void setup() {

        deckEntityList = new ArrayList<>();

        this.deckEntity = new DeckEntity();
        deckEntity.setId(100);
        deckEntity.setWin(1);
        deckEntity.setLose(1);
        deckEntity.setDraw(1);
        deckEntity.setDeckname("first");
        deckEntityList.add(deckEntity);
        this.deckEntity = new DeckEntity();
        deckEntity.setId(200);
        deckEntity.setWin(2);
        deckEntity.setLose(2);
        deckEntity.setDraw(2);
        deckEntity.setDeckname("second");
        deckEntityList.add(deckEntity);


    }

    /**
     * 事前にキャッシュにPutした値が取得できるか確認するテスト
     * @throws Exception
     */
    @Test
    public void キャッシュテスト() throws Exception {
        //キャッシュに値をセット
        putCache();
        //@Cacheableが付与されたメソッドをコール
        List<DeckEntity> deckList = deckService.getAll();
        assertEquals(deckEntityList,deckList);

    }
}
