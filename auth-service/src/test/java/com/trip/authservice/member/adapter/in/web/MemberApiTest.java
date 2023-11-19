package com.trip.authservice.member.adapter.in.web;

import com.epages.restdocs.apispec.ResourceSnippetParameters;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trip.authservice.member.application.port.in.CreateMemberUsecase;
import com.trip.authservice.member.application.port.in.MemberUpdatePasswordUsecase;
import com.trip.authservice.member.dto.request.MemberCreateRequest;
import com.trip.authservice.member.dto.request.MemberUpdatePasswordRequest;
import com.trip.authservice.member.dto.response.MemberCreateResponse;
import com.trip.authservice.member.dto.response.MemberUpdatePasswordResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.epages.restdocs.apispec.ResourceDocumentation.resource;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.put;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WithMockUser
@WebMvcTest(MemberApi.class)
@AutoConfigureRestDocs
class MemberApiTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CreateMemberUsecase createMemberUsecase;

    @MockBean
    private MemberUpdatePasswordUsecase memberUpdatePasswordUsecase;
    
    @Test
    void create() throws Exception {

        MemberCreateRequest request = new MemberCreateRequest("test", "123456", "홍길동", "KDG", "test@naver.com");
        MemberCreateResponse response = new MemberCreateResponse("123");

        when(createMemberUsecase.create(request)).thenReturn(response);

        ResultActions actions = mockMvc.perform(post("/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(request))
                .with(csrf())
        );

        actions
        .andExpect(status().isCreated())
        .andDo(document("member/create",
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                resource(ResourceSnippetParameters.builder()
                        .tag("Members API")
                        .summary("회원가입 API")
                        .requestFields(
                                fieldWithPath("id").description("아이디"),
                                fieldWithPath("password").description("비밀번호"),
                                fieldWithPath("name").description("이름"),
                                fieldWithPath("nickName").description("닉네임"),
                                fieldWithPath("email").description("이메일")
                        )
                        .responseFields(
                                fieldWithPath("pk").description("PK")
                        )
                        .build()
                )));
    }

    @Test
    void updatePassword() throws Exception {

        MemberUpdatePasswordRequest request = new MemberUpdatePasswordRequest("test", "123456");
        MemberUpdatePasswordResponse response = new MemberUpdatePasswordResponse("test");

        when(memberUpdatePasswordUsecase.updatePassword(request)).thenReturn(response);

        ResultActions actions = mockMvc.perform(put("/members/password")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(request))
                .with(csrf())
        );

        actions
                .andExpect(status().isOk())
                .andDo(document("member/updatePassword",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        resource(ResourceSnippetParameters.builder()
                                .tag("Members API")
                                .summary("회원 비밀번호 변경 API")
                                .requestFields(
                                        fieldWithPath("id").description("아이디"),
                                        fieldWithPath("password").description("비밀번호")
                                )
                                .responseFields(
                                        fieldWithPath("id").description("아이디")
                                )
                                .build()
                        )));
    }
}