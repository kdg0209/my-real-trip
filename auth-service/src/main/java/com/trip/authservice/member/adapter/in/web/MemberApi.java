package com.trip.authservice.member.adapter.in.web;

import com.trip.authservice.member.application.port.in.CreateMemberUsecase;
import com.trip.authservice.member.application.port.in.MemberUpdatePasswordUsecase;
import com.trip.authservice.member.dto.request.MemberCreateRequest;
import com.trip.authservice.member.dto.request.MemberUpdatePasswordRequest;
import com.trip.authservice.member.dto.response.MemberCreateResponse;
import com.trip.authservice.member.dto.response.MemberUpdatePasswordResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberApi {

    private final CreateMemberUsecase createMemberUsecase;
    private final MemberUpdatePasswordUsecase memberUpdatePasswordUsecase;

    @PostMapping
    public ResponseEntity<MemberCreateResponse> create(@Valid @RequestBody MemberCreateRequest request) {
        var response = createMemberUsecase.create(request);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping("/password")
    public ResponseEntity<Void> updatePassword(@Valid @RequestBody MemberUpdatePasswordRequest request) {
        var response = memberUpdatePasswordUsecase.updatePassword(request);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
