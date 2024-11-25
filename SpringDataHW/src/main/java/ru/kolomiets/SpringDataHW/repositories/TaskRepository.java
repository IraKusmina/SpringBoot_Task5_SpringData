package ru.kolomiets.SpringDataHW.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kolomiets.SpringDataHW.models.Task;

public interface TaskRepository extends JpaRepository <Task, Long> {
}
