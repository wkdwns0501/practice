package com.board.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.board.dao.MemberDao;
import com.board.dto.MemberDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class MemberRestController {
	
	@Autowired
	private MemberDao memberDao;
	
	//등록 매핑에 대한 설명용 annotation
    @Operation(
          description = "사용자 신규 생성",
          responses= {
                @ApiResponse(
                      responseCode = "200",
                      description = "사용자 생성 완료"
                ),
                @ApiResponse(
                      responseCode = "400",
                      description = "전송한 파라미터가 서버에서 요구하는 값과 다름"
                ),
                @ApiResponse(
                      responseCode = "500",
                      description = "서버 실행 중 오류가 발생한 경우"
                )
          }
       )
	@PostMapping("/") //등록
	public void insert(
			@Parameter(
				description = "생성할 사용자 객체",
				required = true,
				schema = @Schema(implementation = MemberDto.class)
			)
			@RequestBody MemberDto memberDto) {
    	memberDao.insert(memberDto);
	}
    
    @Operation(
            description = "사용자 상세 조회"
       )
    @GetMapping("memberId/{memberId}") //상세조회
    public ResponseEntity<MemberDto> find(@PathVariable String memberId){
    	MemberDto memberDto = memberDao.selectOne(memberId);
    	if(memberDto != null) {
    		return ResponseEntity.ok().body(memberDto);
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
    
  //목록 매핑에 대한 설명용 annotation
    @Operation(
            description = "사용자 전체 조회",
            responses = {
                  @ApiResponse(
                        responseCode = "200",
                        description = "조회 성공",
                        content = {
                              @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(
                                          schema = @Schema(implementation = MemberDto.class)
                                    )
                              )
                              
                        }
                  ),
                  @ApiResponse(
                        responseCode = "500",
                        description = "서버 오류",
                        content = @Content(
                              mediaType = "text/plain",
                              schema = @Schema(implementation = String.class),
                              examples = @ExampleObject("server error")
                              )
                        )
            }
      )
    @GetMapping("/") //전체조회
    public List<MemberDto> list(){
    	return memberDao.selectList();
    }
    
    @Operation(
        	description = "사용자 삭제"
        )
    @DeleteMapping("/{memberId}") //삭제
    public void delete(@PathVariable String memberId) {
    	memberDao.delete(memberId);
    }
    
    //수정 임시 보류
	
}
