package com.toxin.todo.repository;

import com.toxin.todo.entity.Task;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "tasks", path = "tasks")
public interface TaskRepository extends PagingAndSortingRepository<Task, UUID> {
    List<Task> findByUser_Id(UUID Id);
}
