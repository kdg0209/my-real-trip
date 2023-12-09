package com.trip.authservice.outbox.adapter.out.persistence;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberOutBoxEntity is a Querydsl query type for MemberOutBoxEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberOutBoxEntity extends EntityPathBase<MemberOutBoxEntity> {

    private static final long serialVersionUID = 575222204L;

    public static final QMemberOutBoxEntity memberOutBoxEntity = new QMemberOutBoxEntity("memberOutBoxEntity");

    public final DateTimePath<java.time.LocalDateTime> createDatetime = createDateTime("createDatetime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath memberId = createString("memberId");

    public final StringPath payload = createString("payload");

    public QMemberOutBoxEntity(String variable) {
        super(MemberOutBoxEntity.class, forVariable(variable));
    }

    public QMemberOutBoxEntity(Path<? extends MemberOutBoxEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberOutBoxEntity(PathMetadata metadata) {
        super(MemberOutBoxEntity.class, metadata);
    }

}

