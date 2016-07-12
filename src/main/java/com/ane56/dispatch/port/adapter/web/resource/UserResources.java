package com.ane56.dispatch.port.adapter.web.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ane56.dispatch.application.UserApplicationService;
import com.ane56.dispatch.port.adapter.rest.ResourceResponseSupport;
import com.ane56.dispatch.port.adapter.rest.RestResultResponse;

@RestController
public class UserResources extends ResourceResponseSupport {

	@Autowired
	private UserApplicationService userApplicationService;

	@RequestMapping(value = "/api/users", method = RequestMethod.GET)
	public RestResultResponse allUsers() {
		return this.buildSuccessRestResultResponse(this.userApplicationService.allUsers());
	}

}
