package ru.boraldan.hashicorpvault.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.boraldan.hashicorpvault.domen.Tasks;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, UUID>{

}