package com.trip.outboxservice.domain.outbox.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberOutBox is a Querydsl query type for MemberOutBox
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberOutBox extends EntityPathBase<MemberOutBox> {

    private static final long serialVersionUID = -1719699960L;

    public static final QMemberOutBox memberOutBox = new QMemberOutBox("memberOutBox");

    public final DateTimePath<java.time.LocalDateTime> createDatetime = createDateTime("createDatetime", java.time.LocalDateTime.class);

    public final StringPath memberId = createString("memberId");

    public final StringPath payload = createString("payload");

    public final NumberPath<Long> pk = createNumber("pk", Long.class);

    public QMemberOutBox(String variable) {
        super(MemberOutBox.class, forVariable(variable));
    }

    public QMemberOutBox(Path<? extends MemberOutBox> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberOutBox(PathMetadata metadata) {
        super(MemberOutBox.class, metadata);
    }

}

