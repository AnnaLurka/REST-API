package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskMapperTestSuite {

    private TaskMapper taskMapper = new TaskMapper();

    @Test
    public void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(26L, "cooking", "cook the soup");
        //When
        Task result = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals(26L, result.getId());
        assertEquals("cooking", result.getTitle());
        assertEquals("cook the soup", result.getContent());
    }

    @Test
    public void testMapToTaskDto() {
        //Given
        Task task = new Task(26L, "cooking", "cook the soup");
        //When
        TaskDto result = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(26L, result.getId());
        assertEquals("cooking", result.getTitle());
        assertEquals("cook the soup", result.getContent());
    }

    @Test
    public void mapToTaskDtoList() {
        //Given
        Task task1 = new Task(26L, "cooking", "cook the soup");
        Task task2 = new Task(52L, "cleaning", "clean the bathroom");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        //When
        List<TaskDto> resultList = taskMapper.mapToTaskDtoList(taskList);
        Long firstTask = resultList.get(0).getId();
        Long secondTask = resultList.get(1).getId();

        //Then
        assertEquals(2, resultList.size());
        assertEquals(26L, firstTask);
        assertEquals(52L, secondTask);
    }
}
