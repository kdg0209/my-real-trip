#!/bin/bash

# 랜덤 포트 할당
RANDOM_PORT=$(( ( RANDOM % 10000 ) + 10000 ))

# 환경 변수로 랜덤 포트 설정
export AUTH_PORT="$RANDOM_PORT"

# 실제 애플리케이션 실행
java -jar /app.jar --server.port="$AUTH_PORT"