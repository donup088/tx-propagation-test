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
//    @Transactional(propagation = Propagation.REQUIRED) //부모 트랜잭션이 있으면 합류한다.
//    @Transactional(propagation = Propagation.REQUIRES_NEW) //부모 트랜잭션 상관없이 무조건 새로운 트랜잭션을 생성한다.
//    @Transactional(propagation = Propagation.MANDATORY) //부모 트랜잭션에 합류한다. 부모 트랜잭션이 없다면 예외가 발생한다.
//    @Transactional(propagation = Propagation.NEVER) //트랜잭션을 생성하지 않는다. 부모 트랜잭션이 있다면 예외가 발생한다.
//    @Transactional(propagation = Propagation.SUPPORTS) //부모 트랜잭션에 합류한다. 진행중인 부모 트랜잭션이 없다면 새로운 트랜잭션을 생성하지 않는다.
    public void logic() {
        log.info("currentTransactionName : {}",
                TransactionSynchronizationManager.getCurrentTransactionName());
        testObjectRepository.save(new TestObject("자식"));
//        throw new RuntimeException();
    }
}
