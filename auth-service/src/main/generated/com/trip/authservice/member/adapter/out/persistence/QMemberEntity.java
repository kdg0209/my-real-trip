package com.trip.authservice.member.adapter.out.persistence;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberEntity is a Querydsl query type for MemberEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberEntity extends EntityPathBase<MemberEntity> {

    private static final long serialVersionUID = 530130946L;

    public static final QMemberEntity memberEntity = new QMemberEntity("memberEntity");

    public final DateTimePath<java.time.LocalDateTime> createDatetime = createDateTime("createDatetime", java.time.LocalDateTime.class);

    public final StringPath email = createString("email");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final StringPath nickName = createString("nickName");

    public final StringPath password = createString("password");

    public final NumberPath<Long> pk = createNumber("pk", Long.class);

    public QMemberEntity(String variable) {
        super(MemberEntity.class, forVariable(variable));
    }

    public QMemberEntity(Path<? extends MemberEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberEntity(PathMetadata metadata) {
        super(MemberEntity.class, metadata);
    }

}

