package com.tcdt.qlnvreport;

import javax.servlet.http.HttpServletRequest;

public interface RequestService {

	String getClientIp(HttpServletRequest request);

}