package com.tx.propagation.service;

import com.tx.propagation.TestObject;
import com.tx.propagation.repository.TestObjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@Slf4j
@RequiredArgsConstructor
public class InnerService {
    private final TestObjectRepository testObjectRepository;

    @Transactional
    public void logic() {
        log.info("currentTransactionName : {}",
                TransactionSynchronizationManager.getCurrentTransactionName());
        testObjectRepository.save(new TestObject("자식"));
        throw new RuntimeException();
    }
}
