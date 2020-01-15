package com.aem.portal.core.workflow;


import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import com.day.cq.workflow.WorkflowException;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.WorkflowProcess;
import com.day.cq.workflow.metadata.MetaDataMap;

@Component(service= WorkflowProcess.class,
property={
		Constants.SERVICE_DESCRIPTION+"=Test Email workflow process implementation.",
		Constants.SERVICE_VENDOR+"=Adobe",
        "process.label=Email Custom Step"
		})

public class EmailWorkflow implements WorkflowProcess {

	@Override
	public void execute(WorkItem arg0, WorkflowSession arg1, MetaDataMap arg2) throws WorkflowException {
		// TODO Auto-generated method stub
		System.out.println("Sending Mail to publisher to publish the page..");
		
	}

}
