package com.crud.tasks.trello.facade;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {

    private TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    public void testMapToBoards() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("12", "List1", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("13", "List2", false);
        List<TrelloListDto> trelloLists = Arrays.asList(trelloListDto1, trelloListDto2);
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "Board1", trelloLists);
        List<TrelloBoardDto> trelloBoardDtoList = Arrays.asList(trelloBoardDto);

        //When
        List<TrelloBoard> trelloBoardList = trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        Assert.assertEquals(1, trelloBoardList.size());
        Assert.assertEquals(2, trelloBoardList.get(0).getLists().size());
        Assert.assertEquals("13", trelloBoardList.get(0).getLists().get(1).getId());
        Assert.assertEquals("List1", trelloBoardList.get(0).getLists().get(0).getName());
        Assert.assertFalse(trelloBoardList.get(0).getLists().get(1).isClosed());
    }

    @Test
    public void testMapToBoardDto() {
        //Given
        TrelloList trelloList1 = new TrelloList("12", "List1", true);
        TrelloList trelloList2 = new TrelloList("13", "List2", false);
        List<TrelloList> trelloLists = Arrays.asList(trelloList1, trelloList2);
        TrelloBoard trelloBoard = new TrelloBoard("1", "Board1", trelloLists);
        List<TrelloBoard> trelloBoardList = Arrays.asList(trelloBoard);

        //When
        List<TrelloBoardDto> trelloBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoardList);

        //Then
        Assert.assertEquals(1, trelloBoardList.size());
        Assert.assertEquals(2, trelloBoardList.get(0).getLists().size());
        Assert.assertEquals("13", trelloBoardList.get(0).getLists().get(1).getId());
        Assert.assertEquals("List1", trelloBoardList.get(0).getLists().get(0).getName());
        Assert.assertTrue(trelloBoardList.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void testMapToList() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("12", "List1", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("13", "List2", false);
        List<TrelloListDto> trelloListDtos = Arrays.asList(trelloListDto1, trelloListDto2);

        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtos);

        //Then
        Assert.assertEquals(2,trelloLists.size());
        Assert.assertEquals("13", trelloLists.get(1).getId());
        Assert.assertEquals("List1", trelloLists.get(0).getName());
        Assert.assertFalse(trelloLists.get(1).isClosed());
    }

    @Test
    public void testMapToListDto() {
        //Given
        TrelloList trelloList1 = new TrelloList("12", "List1", true);
        TrelloList trelloList2 = new TrelloList("13", "List2", false);
        List<TrelloList> trelloLists = Arrays.asList(trelloList1, trelloList2);

        //When
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloLists);

        //Then
        Assert.assertEquals(2, trelloListDtos.size());
        Assert.assertEquals("13", trelloListDtos.get(1).getId());
        Assert.assertEquals("List1", trelloListDtos.get(0).getName());
        Assert.assertFalse(trelloListDtos.get(1).isClosed());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Card1", "Description1", "top", "List1");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        Assert.assertEquals("Card1", trelloCardDto.getName());
        Assert.assertEquals("Description1", trelloCardDto.getDescription());
        Assert.assertEquals("top", trelloCardDto.getPos());
        Assert.assertEquals("List1", trelloCardDto.getListId());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Card1", "Description1", "top", "List1");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        Assert.assertEquals("Card1", trelloCard.getName());
        Assert.assertEquals("Description1", trelloCard.getDescription());
        Assert.assertEquals("top", trelloCard.getPos());
        Assert.assertEquals("List1", trelloCard.getListId());
    }


}
