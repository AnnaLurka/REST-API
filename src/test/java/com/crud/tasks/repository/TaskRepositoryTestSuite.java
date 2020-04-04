package com.crud.tasks.repository;

import com.crud.tasks.domain.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskRepositoryTestSuite {

    @Autowired
    private TaskRepository taskRepository;
    @Test
    public void testFindAll() {
        //Given
        Task task1 = new Task(1L,"cooking", "cook the soup");
        Task task2 = new Task(2L, "cleaning", "clean the bathroom");
        taskRepository.save(task1);
        taskRepository.save(task2);
        //When
        List<Task> taskList = taskRepository.findAll();
        //Then
        assertEquals(2, taskList.size());
        //CleanUp
        taskRepository.deleteAll();
    }

    @Test
    public void testFindAllEmptyRepository() {
        //Given
        //When
        taskRepository.deleteAll();
        //Then
        assertEquals(0, taskRepository.count());
    }
}
