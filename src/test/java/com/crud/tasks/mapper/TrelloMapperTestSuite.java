package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrelloMapperTestSuite {

    private TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    public void testMapToBoards() {
        //Given
        TrelloListDto cookingList = new TrelloListDto("33", "cooking", false);
        TrelloListDto cleaningList = new TrelloListDto("11", "cleaning", true);
        List<TrelloListDto> houseworkList1 = new ArrayList<>();
        houseworkList1.add(cookingList);
        houseworkList1.add(cleaningList);
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("55", "housework1", houseworkList1);

        TrelloListDto shoppingList = new TrelloListDto("77", "shopping", false);
        TrelloListDto washingList = new TrelloListDto("22", "washing", true);
        List<TrelloListDto> houseworkList2 = new ArrayList<>();
        houseworkList2.add(shoppingList);
        houseworkList2.add(washingList);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("44", "housework2", houseworkList2);

        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(trelloBoardDto1);
        trelloBoardsDto.add(trelloBoardDto2);
        //When
        List<TrelloBoard> resultList = trelloMapper.mapToBoards(trelloBoardsDto);
        //Then
        assertEquals(2, resultList.size());
        assertEquals("55", resultList.get(0).getId());
        assertEquals("housework1", resultList.get(0).getName());
        assertEquals("33", resultList.get(0).getLists().get(0).getId());
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        TrelloList cookingList = new TrelloList("33", "cooking", false);
        TrelloList cleaningList = new TrelloList("11", "cleaning", true);
        List<TrelloList> houseworkList1 = new ArrayList<>();
        houseworkList1.add(cookingList);
        houseworkList1.add(cleaningList);
        TrelloBoard trelloBoard1 = new TrelloBoard("55", "housework1", houseworkList1);

        TrelloList shoppingList = new TrelloList("77", "shopping", false);
        TrelloList washingList = new TrelloList("22", "washing", true);
        List<TrelloList> houseworkList2 = new ArrayList<>();
        houseworkList2.add(shoppingList);
        houseworkList2.add(washingList);
        TrelloBoard trelloBoard2 = new TrelloBoard("44", "housework2", houseworkList2);

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard1);
        trelloBoards.add(trelloBoard2);
        //When
        List<TrelloBoardDto> resultList = trelloMapper.mapToBoardsDto(trelloBoards);
        //Then
        assertEquals(2, resultList.size());
        assertEquals("55", resultList.get(0).getId());
        assertEquals("housework1", resultList.get(0).getName());
        assertEquals("33", resultList.get(0).getLists().get(0).getId());
    }

    @Test
    public void testMapToList() {
        //Given
        TrelloListDto cookingList = new TrelloListDto("33", "cooking", false);
        TrelloListDto cleaningList = new TrelloListDto("11", "cleaning", true);
        List<TrelloListDto> houseworkList1 = new ArrayList<>();
        houseworkList1.add(cookingList);
        houseworkList1.add(cleaningList);
        //When
        List<TrelloList> resultList = trelloMapper.mapToList(houseworkList1);
        //Then
        assertEquals(2, resultList.size());
        assertEquals("33", resultList.get(0).getId());
        assertEquals("cooking", resultList.get(0).getName());
        assertEquals(false, resultList.get(0).isClosed());
    }

    @Test
    public void testMapToListDto() {
        //Given
        TrelloList cookingList = new TrelloList("33", "cooking", false);
        TrelloList cleaningList = new TrelloList("11", "cleaning", true);
        List<TrelloList> houseworkList1 = new ArrayList<>();
        houseworkList1.add(cookingList);
        houseworkList1.add(cleaningList);
        //When
        List<TrelloListDto> resultList = trelloMapper.mapToListDto(houseworkList1);
        //Then
        assertEquals(2, resultList.size());
        assertEquals("33", resultList.get(0).getId());
        assertEquals("cooking", resultList.get(0).getName());
        assertEquals(false, resultList.get(0).isClosed());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("cooking", "cook the soup", "26", "1");
        //When
        TrelloCardDto result = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("cooking", result.getName());
        assertEquals("cook the soup", result.getDescription());
        assertEquals("26", result.getPos());
        assertEquals("1", result.getListId());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("cooking", "cook the soup", "26", "1");
        //When
        TrelloCard result = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals("cooking", result.getName());
        assertEquals("cook the soup", result.getDescription());
        assertEquals("26", result.getPos());
        assertEquals("1", result.getListId());
    }
}
