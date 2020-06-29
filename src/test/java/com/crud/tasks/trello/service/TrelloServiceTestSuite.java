package com.crud.tasks.trello.service;


import com.crud.tasks.config.UserConfig;
import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.service.SimpleEmailService;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.client.TrelloClient;
import com.crud.tasks.trello.config.TrelloConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTestSuite {

    @InjectMocks
    TrelloService trelloService;

    @Mock
    TrelloClient trelloClient;

    @Mock
    TrelloConfig trelloConfig;

    @Mock
    SimpleEmailService simpleEmailService;

    @Mock
    UserConfig userConfig;

    @Test
    public void testFetchTrelloBoards() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("12", "List1", true));

        List<TrelloBoardDto> trelloBoardDto = new ArrayList<>();
        trelloBoardDto.add(new TrelloBoardDto("1", "Board1", trelloListDto));

        //When
        when(trelloService.fetchTrelloBoards()).thenReturn(trelloBoardDto);
        List<TrelloBoardDto> fetchedTrelloBoards = trelloService.fetchTrelloBoards();

        //Then
        Assert.assertNotNull(fetchedTrelloBoards);
        Assert.assertEquals(1, fetchedTrelloBoards.size());
        Assert.assertEquals("1", fetchedTrelloBoards.get(0).getId());
        Assert.assertEquals("Board1", fetchedTrelloBoards.get(0).getName());
        Assert.assertTrue(fetchedTrelloBoards.get(0).getLists().get(0).isClosed());
        Assert.assertEquals(trelloListDto, fetchedTrelloBoards.get(0).getLists());
    }

    @Test
    public void testCreateTrelloCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Card1", "Description1", "top", "List1");

        //When
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("12", "Card1", "https://test.com");
        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(createdTrelloCardDto);

        //Then
        CreatedTrelloCardDto createdCard = trelloService.createTrelloCard(trelloCardDto);
        Assert.assertNotNull(createdCard);
        Assert.assertEquals("12", createdCard.getId());
        Assert.assertEquals("Card1", createdCard.getName());
        Assert.assertEquals("https://test.com", createdCard.getShortUrl());
    }
}
