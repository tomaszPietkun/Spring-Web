package com.crud.tasks.mapper;


import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTestSuite {

    @InjectMocks
    TaskMapper taskMapper;

    @Test
    public void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(12L, "Title1", "Content1");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        Assert.assertNotNull(task);
        Assert.assertEquals(12L, task.getId(), 0);
        Assert.assertEquals("Title1", task.getTitle());
        Assert.assertEquals("Content1", task.getContent());
    }

    @Test
    public void testMapToTaskDto() {
        //Given
        Task task = new Task(13L, "Title2", "Content2");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        Assert.assertNotNull(taskDto);
        Assert.assertEquals(13L, taskDto.getId(), 0);
        Assert.assertEquals("Title2", taskDto.getTitle());
        Assert.assertEquals("Content2", taskDto.getContent());
    }

    @Test
    public void testMapToTaskDtoList() {
        //Given
        Task task = new Task(14L, "Title3", "Content3");
        List<Task> taskList = Arrays.asList(task);

        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        Assert.assertNotNull(taskDtoList);
        Assert.assertEquals(1, taskDtoList.size());
        taskDtoList.forEach(taskDto -> {
            Assert.assertEquals(14L, taskDto.getId(), 0);
            Assert.assertEquals("Title3", taskDto.getTitle());
            Assert.assertEquals("Content3", taskDto.getContent());
        });
    }
}
