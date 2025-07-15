package ru.boraldan.hashicorpvault.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.boraldan.hashicorpvault.domen.Status;
import ru.boraldan.hashicorpvault.domen.Tasks;
import ru.boraldan.hashicorpvault.domen.dto.CreatTasksDto;
import ru.boraldan.hashicorpvault.domen.dto.TasksDto;
import ru.boraldan.hashicorpvault.repository.TaskRepository;


import java.util.UUID;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class TaskServiceV1 {

    private final TaskRepository taskRepository;

    public Page<Tasks> getTasks(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    public Tasks getTaskById(UUID id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task with id %s not found".formatted(id)));
    }

//    @Transactional
//    public Tasks createTask(CreatTasksDto creatTasksDto) {
//        if (creatTasksDto.getStatus() == null) creatTasksDto.setStatus(Status.PENDING);
//        if (creatTasksDto.getIsActive() == null) creatTasksDto.setIsActive(true);
//        Tasks tasks = taskRepository.save(taskMapper.creatTasksFromDto(creatTasksDto));
//        return taskMapper.toDtoFromTasks(tasks);
//    }
//
//    @Transactional
//    public Tasks updateTask(UUID id, CreatTasksDto creatTasksDto) {
//        Tasks tasks = taskRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Task with id %s not found".formatted(id)));
//        tasks = taskRepository.save(taskMapper.updateTasksFromDto(creatTasksDto, tasks));
//
//        return tasksDto;
//    }
//
    @Transactional
    public void deleteTask(UUID id) {
        Tasks tasks = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task with id %s not found".formatted(id)));
        taskRepository.delete(tasks);
    }

}
