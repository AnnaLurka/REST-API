package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskMapperTestSuite {

    @Autowired
    private TaskMapper taskMapper;

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
}
