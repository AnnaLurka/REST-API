package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;


import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbServiceTestSuite {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    DbService dbService;

    @Test
    public void testGetAllTasks() {
        //Given
        Task task1 = new Task(1L,"cooking", "cook the soup");
        Task task2 = new Task(2L, "cleaning", "clean the bathroom");
        taskRepository.save(task1);
        taskRepository.save(task2);
        //When
        List<Task> taskList = dbService.getAllTasks();
        //Then
        assertEquals(2, taskList.size());
        //CleanUp
        taskRepository.deleteAll();
    }

    @Test
    public void testGetTaskById() {
        //Given
        Task task1 = new Task("cooking", "cook the soup");
        taskRepository.save(task1);
        //When
        Long task1Id = task1.getId();
        Long task1FromDBId = dbService.getTaskById(task1Id).getId();
        String task1Title = task1.getTitle();
        String task1FromDBTitle = dbService.getTaskById(task1Id).getTitle();
        String task1Content = task1.getContent();
        String task1FromDBContent = dbService.getTaskById(task1Id).getContent();
        //Then
        assertEquals(task1Id, task1FromDBId);
        assertEquals(task1Title, task1FromDBTitle);
        assertEquals(task1Content, task1FromDBContent);
        //CleanUp
        taskRepository.deleteAll();
    }

    @Test
    public void testDeleteTaskById() {
        //Given
        Task task1 = new Task( "cooking", "cook the soup");
        Task task2 = new Task( "cleaning", "clean the bathroom");
        taskRepository.save(task1);
        taskRepository.save(task2);
        Long beforeDeletion = taskRepository.count();
        //When
        dbService.deleteTaskById(task1.getId());
        Long afterDeletion = taskRepository.count();
        //Then
        assertEquals(1, beforeDeletion - afterDeletion);
        //CleanUp
        taskRepository.deleteAll();
    }
}
