package cvetkov.example.crm.service;

import cvetkov.example.crm.model.Manager;
import cvetkov.example.crm.repository.ManagerRepository;
import cvetkov.example.sessionmanager.TransactionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DbServiceManagerImpl implements DBServiceManager {
    private static final Logger log = LoggerFactory.getLogger(DbServiceManagerImpl.class);

    private final ManagerRepository managerRepository;
    private final TransactionManager transactionManager;

    public DbServiceManagerImpl(ManagerRepository managerRepository, TransactionManager transactionManager) {
        this.managerRepository = managerRepository;
        this.transactionManager = transactionManager;
    }

    @Override
    public Manager saveManager(Manager manager) {
        return transactionManager.doInTransaction(() -> {
            var savedManager = managerRepository.save(manager);

            log.info("savedManager manager: {}", savedManager);
            return savedManager;
        });
    }

    @Override
    public Optional<Manager> getManager(String no) {
            var managerOptional = managerRepository.findById(no);
            log.info("manager: {}", managerOptional);
            return managerOptional;

    }

    @Override
    public List<Manager> findAll() {
        var managerList = managerRepository.findAll();
        log.info("managerList:{}", managerList);
        return managerList;
    }
}
