package com.troytan.ymcake.manager;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TulingManagerTest {

    @Autowired
    private TulingManager tulingManager;

    @Test
    public void chatWithTextTest() throws JsonParseException, JsonMappingException, IOException {
        System.out.println(tulingManager.chatWithText("how do you do!"));
    }
}
