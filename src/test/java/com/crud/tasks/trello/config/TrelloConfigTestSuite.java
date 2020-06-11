package com.crud.tasks.trello.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TrelloConfigTestSuite {

    @Mock
    TrelloConfig trelloConfig;

    @Test
    public void testGetTrelloApiEndpoint() {
        //Given
        String trelloApiEndpoint = "https://api.trello.com/1";
        when(trelloConfig.getTrelloApiEndpoint()).thenReturn(trelloApiEndpoint);

        //When
        String expectedEndpoint = trelloConfig.getTrelloApiEndpoint();

        //Then
        Assert.assertEquals(trelloApiEndpoint, expectedEndpoint);
    }

    @Test
    public void testGetTrelloAppKey() {
        //Given
        String trelloAppKey = "a5105afda9686d6ff0d896665af3f68c";
        when(trelloConfig.getTrelloAppKey()).thenReturn(trelloAppKey);

        //When
        String expectedKey = trelloConfig.getTrelloAppKey();

        //Then
        Assert.assertEquals(trelloAppKey, expectedKey);
    }

    @Test
    public void testGetTrelloToken() {
        //Given
        String trelloToken = "6b2dbf14a8da1a8649eb6b9754aae0a9a07da37fed1f22d180fb9de81da3b1d3";
        when(trelloConfig.getTrelloToken()).thenReturn(trelloToken);

        //When
        String expectedToken = trelloConfig.getTrelloToken();

        //Then
        Assert.assertEquals(trelloToken, expectedToken);
    }

    @Test
    public void testGetTrelloUsername() {
        //Given
        String trelloUsername = "tomaszpietkun99";
        when(trelloConfig.getTrelloUsername()).thenReturn(trelloUsername);

        //When
        String expectedUsername = trelloConfig.getTrelloUsername();

        //Then
        Assert.assertEquals(trelloUsername, expectedUsername);
    }
}
