package com.springcloud.netflix.mswoker.repositories;

import com.springcloud.netflix.mswoker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {


}
