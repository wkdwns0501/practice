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

import com.board.dao.UserDao;
import com.board.dto.UserDto;

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
public class UserRestController {
	
	@Autowired
	private UserDao userDao;
	
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
				schema = @Schema(implementation = UserDto.class)
			)
			@RequestBody UserDto userDto) {
		userDao.insert(userDto);
	}
    
    @Operation(
            description = "사용자 상세 조회"
       )
    @GetMapping("userId/{userId}") //상세조회
    public ResponseEntity<UserDto> find(@PathVariable String userId){
    	UserDto userDto = userDao.selectOne(userId);
    	if(userDto != null) {
    		return ResponseEntity.ok().body(userDto);
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
                                          schema = @Schema(implementation = UserDto.class)
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
    public List<UserDto> list(){
    	return userDao.selectList();
    }
    
    @Operation(
        	description = "사용자 삭제"
        )
    @DeleteMapping("/{userId}") //삭제
    public void delete(@PathVariable String userId) {
    	userDao.delete(userId);
    }
    
    //수정 임시 보류
	
}
