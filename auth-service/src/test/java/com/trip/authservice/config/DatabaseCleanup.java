package com.trip.authservice.config;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DatabaseCleanup {

    @PersistenceContext
    private EntityManager entityManager;

    private List<String> tableNames;

    @PostConstruct
    public void init() throws Exception {
        this.tableNames = entityManager.getMetamodel().getEntities().stream()
                .filter(entity -> entity.getJavaType().getAnnotation(Table.class) != null)
                .map(entity -> entity.getJavaType().getAnnotation(Table.class).name())
                .collect(Collectors.toList());
    }

    @Transactional
    public void execute() {

        // 쓰기 지연 저장소에 남은 SQL을 마저 수행
        this.entityManager.flush();

        // 연관관계 매핑된 테이블이 있는 경우 참조 무결성을 해제 해주어야 TRUNCATE 가능
        this.entityManager.createNativeQuery("SET foreign_key_checks = FALSE").executeUpdate();
        for (String tableName : this.tableNames) {
            this.entityManager.createNativeQuery("TRUNCATE TABLE " + tableName).executeUpdate();
            this.entityManager.createNativeQuery("ALTER TABLE " + tableName + " AUTO_INCREMENT = 1").executeUpdate();
        }
        this.entityManager.createNativeQuery("SET foreign_key_checks = TRUE").executeUpdate();
    }
}
