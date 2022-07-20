package com.tx.propagation.repository;

import com.tx.propagation.TestObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestObjectRepository extends JpaRepository<TestObject, Long> {
}
