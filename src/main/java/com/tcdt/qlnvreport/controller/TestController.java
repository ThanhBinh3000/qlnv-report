package com.tcdt.qlnvreport.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tcdt.qlnvreport.request.BaseRequest;
import com.tcdt.qlnvreport.response.BaseResponse;
import com.tcdt.qlnvreport.util.Contains;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/test")
@Api(tags = "Get token test", value = "Authentication API", description = "Dùng để lấy token, sau này sẽ xóa đi ")
public class TestController {

	static final long EXPIRATIONTIME = 36_000_000; // 10 phut 36_000_000

	static final String SECRET = "Teca15DuyTan";

	static final String TOKEN_PREFIX = "Bearer";

	static final String HEADER_STRING = "Authorization";

	@ApiOperation(value = "Authenticated User Login")
	@PostMapping(value = "/testAPI", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<BaseResponse> login(@Valid @RequestBody BaseRequest objReq) {
		BaseResponse resp = new BaseResponse();
		try {
			resp.setData(TOKEN_PREFIX + " " + "abc");
			resp.setStatusCode(Contains.RESP_SUCC);

		} catch (Exception e) {
			// TODO: handle exception
			resp.setStatusCode(Contains.RESP_FAIL);
			resp.setMsg(e.getMessage());
		}
		return ResponseEntity.ok(resp);
	}
}