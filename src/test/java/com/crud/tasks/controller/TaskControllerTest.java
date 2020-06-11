package com.crud.tasks.controller;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import com.crud.tasks.trello.mapper.TrelloFacade;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private DbService dbService;

    @MockBean
    private TaskMapper taskMapper;

    @Test
    public void shouldFetchTaskLists() throws Exception {
        //Given
        Task task1 = new Task(1L, "Test task1", "Test1");
        Task task2 = new Task(2L, "Test task2", "Test2");

        TaskDto taskDto1 = new TaskDto(1L, "Test task1", "Test1");
        TaskDto taskDto2 = new TaskDto(2L, "Test task2", "Test2");

        List<TaskDto> taskDtoList = Arrays.asList(taskDto1, taskDto2);

        List<Task> taskList = Arrays.asList(task1, task2);

        when(dbService.getAllTasks()).thenReturn(taskList);
        when(taskMapper.mapToTaskDtoList(taskList)).thenReturn(taskDtoList);

        //When & Then
        mockMvc.perform(get("/v1/tasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].id", is(1)))
                .andExpect(jsonPath("$.[0].title", is("Test task1")))
                .andExpect(jsonPath("$.[0].content", is("Test1")))
                .andExpect(jsonPath("$.[1].id", is(2)))
                .andExpect(jsonPath("$.[1].title", is("Test task2")))
                .andExpect(jsonPath("$.[1].content", is("Test2")));
    }


}
