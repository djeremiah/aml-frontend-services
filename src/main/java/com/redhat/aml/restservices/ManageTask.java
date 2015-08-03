package com.redhat.aml.restservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("managetask")
public class ManageTask {

		@GET
		public String ping(){
			return "ping";
		}
}
