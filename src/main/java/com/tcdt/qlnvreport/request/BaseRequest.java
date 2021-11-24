package com.tcdt.qlnvreport.request;

import lombok.Data;

@Data
public class BaseRequest {
	PaggingReq paggingReq;
	String trangThai;

}