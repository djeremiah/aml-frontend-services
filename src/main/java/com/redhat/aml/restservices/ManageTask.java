package com.redhat.aml.restservices;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.kie.api.task.model.TaskSummary;

@Path("managetask")
public class ManageTask {

		@GET
		public String ping(){
			return "ping";
		}
		
//		@GET
//		@Path("/{uid}/tasklist")
//		@Produces("application/json")
//		public List<TaskSummary> getTasksForUser(@PathParam("uid") final String uid) {
//			//return factory.newRuntimeEngine().getTaskService()
//					.getTasksAssignedAsPotentialOwner(uid, null);
//		}
}
