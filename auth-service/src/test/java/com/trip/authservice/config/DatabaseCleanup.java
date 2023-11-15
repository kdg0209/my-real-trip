package com.trip.authservice.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DatabaseCleanup implements InitializingBean {

    @PersistenceContext
    private EntityManager entityManager;

    private List<String> tableNames;

    @Override
    public void afterPropertiesSet() throws Exception {
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
        this.entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate();
        for (String tableName : this.tableNames) {
            this.entityManager.createNativeQuery("TRUNCATE TABLE " + tableName).executeUpdate();
//            this.entityManager.createNativeQuery("ALTER TABLE " + tableName + " ALTER COLUMN ID RESTART WITH 1").executeUpdate();
        }
        this.entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate();
    }
}
