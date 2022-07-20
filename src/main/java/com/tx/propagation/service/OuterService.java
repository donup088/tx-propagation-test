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
public class OuterService {
    private final InnerService innerService;
    private final TestObjectRepository repository;

    @Transactional
    public void txTest() {
        log.info("currentTransactionName : {}",
                TransactionSynchronizationManager.getCurrentTransactionName());
//        try {
//            repository.save(new TestObject("부모"));
//            innerService.logic();
//        } catch (RuntimeException e) {
//            log.info(e.getMessage());
//        }

        repository.save(new TestObject("부모"));
        innerService.logic();
    }
}
