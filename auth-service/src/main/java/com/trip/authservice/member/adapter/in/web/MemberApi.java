package com.trip.authservice.member.adapter.in.web;

import com.trip.authservice.member.application.port.in.CreateMemberUsecase;
import com.trip.authservice.member.dto.request.MemberCreateRequest;
import com.trip.authservice.member.dto.response.MemberCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberApi {

    private final CreateMemberUsecase createMemberUsecase;

    @PostMapping
    public ResponseEntity<MemberCreateResponse> create(@RequestBody MemberCreateRequest request) {
        MemberCreateResponse response = createMemberUsecase.create(request);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
