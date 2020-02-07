package org.kie.server.samples;


import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.casemgmt.api.model.CaseDefinition;
import org.jbpm.kie.services.impl.ProcessServiceImpl;
//import org.jbpm.process.instance.ProcessInstance;
import org.jbpm.process.instance.context.variable.VariableScopeInstance;
import org.jbpm.services.api.model.ProcessDefinition;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.task.model.Task;
import org.kie.server.services.jbpm.ui.form.render.AbstractFormRenderer;
import org.kie.server.services.jbpm.ui.form.render.model.FormField;
import org.kie.server.services.jbpm.ui.form.render.model.FormInstance;
import org.kie.server.services.jbpm.ui.form.render.model.FormLayout;
import org.kie.server.services.jbpm.ui.form.render.model.LayoutColumn;
import org.kie.server.services.jbpm.ui.form.render.model.LayoutItem;
import org.kie.server.services.jbpm.ui.form.render.model.LayoutRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.process.WorkflowProcessInstance;

 
 
public class AuditFormRenderer extends AbstractFormRenderer {
     
	public static final String HTML_LAYOUT_TEMPLATE = "htmlLayoutTemplate";
	private String serverPath;
	private Map<String, String> inputTypes;
	 
    @Override
	public void configure(String serverPath, String resources) {
		// TODO Auto-generated method stub
    	System.out.println("configure called");
		super.configure(serverPath, resources);
		
	}

	@Override
	public String renderCase(String containerId, CaseDefinition caseDefinition, FormInstance form) {
		System.out.println("renderCase called");
		// TODO Auto-generated method stub
		return super.renderCase(containerId, caseDefinition, form);
		
	}

	@Override
	public String renderProcess(String containerId, ProcessDefinition processDesc, FormInstance form) {
		System.out.println("renderProcess called");
		// TODO Auto-generated method stub
		return super.renderProcess(containerId, processDesc, form);
	}

	@Override
	public String renderTask(String containerId, Task task, FormInstance form, Map<String, Object> inputs,
			Map<String, Object> outputs) {
		// TODO Auto-generated method stub
		
		System.out.println("renderTask called");
		taskFormDetails(containerId,task,form,inputs,outputs);
		return super.renderTask(containerId, task, form, inputs, outputs);
	}
	
	public void taskFormDetails(String containerId, Task task, FormInstance form, Map<String, Object> inputs,
			Map<String, Object> outputs) {
		
		
	//	new ProcessServiceImpl().
		
		
		System.out.println("containerId " + containerId);
		if (inputs != null) {
			System.out.println("inputs Details " + inputs.toString());
		}
		if (outputs != null) {
			System.out.println("outputs Details " + outputs.toString());
		}
		if (task != null && task.getTaskData() != null) {
			System.out.println( "Test1 [getId()=" + task.getId() + ", getPriority()=" + task.getPriority() + ", getNames()=" + task.getNames()
			+ ", getSubjects()=" + task.getSubjects() + ", getDescriptions()=" + task.getDescriptions() + ", getName()="
			+ task.getName() + ", getSubject()=" + task.getSubject() + ", getDescription()=" + task.getDescription()
			+ ", getPeopleAssignments()=" + task.getPeopleAssignments() + ", getTaskData()=1"
			+ ", getTaskType()=" + task.getTaskType() + ", isArchived()=" + task.isArchived() + ", getVersion()="
			+ task.getVersion() + ", getFormName()=" + task.getFormName() + "]");
			
		System.out.println("Test1 [getStatus()=" + task.getTaskData().getStatus() + ", getPreviousStatus()=" + task.getTaskData().getPreviousStatus()
			+ ", getActualOwner()=" + task.getTaskData().getActualOwner() + ", getCreatedBy()=" + task.getTaskData().getCreatedBy() + ", getCreatedOn()="
			+ task.getTaskData().getCreatedOn() + ", getActivationTime()=" + task.getTaskData().getActivationTime() + ", getExpirationTime()="
			+ task.getTaskData().getExpirationTime() + ", isSkipable()=" + task.getTaskData().isSkipable() + ", getWorkItemId()=" + task.getTaskData().getWorkItemId()
			+ ", getProcessInstanceId()=" + task.getTaskData().getProcessInstanceId() + ", getProcessId()=" + task.getTaskData().getProcessId()
			+ ", getDeploymentId()=" + task.getTaskData().getDeploymentId() + ", getProcessSessionId()=" + task.getTaskData().getProcessSessionId()
			+ ", getDocumentType()=" + task.getTaskData().getDocumentType() + ", getDocumentContentId()=" + task.getTaskData().getDocumentContentId()
			+ ", getOutputType()=" + task.getTaskData().getOutputType() + ", getOutputContentId()=" + task.getTaskData().getOutputContentId()
			+ ", getFaultName()=" + task.getTaskData().getFaultName() + ", getFaultType()=" + task.getTaskData().getFaultType() + ", getFaultContentId()="
			+ task.getTaskData().getFaultContentId() + ", getComments()=" + task.getTaskData().getComments() + ", getAttachments()=" + task.getTaskData().getAttachments()
			+ ", getParentId()=" + task.getTaskData().getParentId() + ", getTaskInputVariables()=" + task.getTaskData().getTaskInputVariables()
			+ ", getTaskOutputVariables()=" + task.getTaskData().getTaskOutputVariables() + "]");
		
		try {
			RuntimeManager runTimeManager = (RuntimeManager)task.getTaskData().getTaskInputVariables().get("runTimeManager");
			System.out.println("Auditor Render runTimeManager " + runTimeManager);
			org.kie.api.runtime.manager.Context<?> context = org.kie.internal.runtime.manager.context.ProcessInstanceIdContext.get(task.getTaskData().getProcessInstanceId());
			KieSession ksession = runTimeManager.getRuntimeEngine(context).getKieSession();
			System.out.println("Auditor Render KSession " + ksession);
			 ProcessInstance processInstnace =  ksession.getProcessInstance(task.getTaskData().getProcessInstanceId());
			 System.out.println("Auditor Render processInstnace .." + processInstnace);
			 WorkflowProcessInstance workProcessInstance= (WorkflowProcessInstance)processInstnace;
			 System.out.println("Auditor Render CaseId " + workProcessInstance.getVariable("CaseId"));
			 System.out.println("Auditor Render caseFile_auditorList " + workProcessInstance.getVariable("caseFile_auditorList"));
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
			//org.kie.api.runtime.manager.Context<?> context = org.kie.internal.runtime.manager.context.ProcessInstanceIdContext.get(task.getTaskData().getProcessInstanceId());
			
		//	System.out.println("context object " + context);
			
//			if (context != null) {
////			//	KieServices kieServices = KieServices.Factory.get();
////				 KieContainer kContainer = kieServices.getKieClasspathContainer();
////				 KieSession kSession = kContainer.newKieSession();
////				 System.out.println(kSession.getProcessInstance(task.getTaskData().getProcessInstanceId()));
////				System.out.println("context ..class" + context.getClass() + ":" + context.getContextId());
////			}
			
		}
	}

	@Override
	protected void processFormLayout(FormInstance topLevelForm, FormInstance form, Map<String, Object> inputs,
			Map<String, Object> outputs, String layoutTemplate, StringBuilder jsonTemplate, boolean wrapJson,
			List<String> scriptDataList) {
		
		
		System.out.println("processFormLayout called");
		// TODO Auto-generated method stub
FormLayout layout = form.getLayout();
        
        if (form.getModel().getClassName() != null && wrapJson) {
            jsonTemplate                
                .append("'")
                .append(form.getModel().getName())
                .append("' : ")
                .append("{")
                .append("'")
                .append(form.getModel().getClassName())                
                .append("' : ")
                .append("{");
        }
        
        
        for (LayoutRow row : layout.getRows()) {
            row.setHeader(form.getName());
            for (LayoutColumn column : row.getColumns()) {
                // append each item's content into the builder
                StringBuilder content = new StringBuilder();
                
                for (LayoutItem item : column.getItems()) {
                    if (item.getValue() != null) {
                    	System.out.println("item.getValue()" + item.getValue());
                    	 Map<String, Object> parameters = new HashMap();
                         parameters.put("htmlContent", item.getValue());
                         String output = renderTemplate(HTML_LAYOUT_TEMPLATE, parameters);
                         column.setSpan("12");
                        content.append(output);
                    } else {
                    	column.setSpan("6");
                        FormField field = form.getField(item.getFieldId());
                        
                        if (field.getNestedForm() != null && !field.getNestedForm().isEmpty()) {
                            // handle subform
                            handleSubForm(topLevelForm, field, inputs, outputs, layoutTemplate, jsonTemplate, wrapJson, scriptDataList, content);
                            continue;
                        } else if (field.getCreationForm() != null) {
                            // handle multi subforms
                            handleMultiSubForm(topLevelForm, field, inputs, outputs, layoutTemplate, jsonTemplate, scriptDataList, content);
                            continue;
                        }
                        
                        // handle regular fields in the form 
                        System.out.println("inputTypes .." + this.inputTypes);
                        System.out.println("inputTypes field code .." + field.getCode());
                        String fieldType = this.inputTypes.get(field.getCode());
                        if (fieldType != null) {
                                                    
                            String jsType = getFieldType(field.getType());
                            
                            item.setId(field.getId());
                            item.setName(nonNull(field.getName()));
                            item.setLabel(nonNull(field.getLabel()));
                            item.setPlaceHolder(nonNull(field.getPlaceHolder()));
                            item.setType(fieldType);
                            item.setValue("");
                            item.setOptions(field.getOptions());
                            item.setPattern(getValidationPatternByType(field.getType()));
                            
                            if (inputs.get(field.getBinding()) != null) {
                                item.setValue(inputs.get(field.getBinding()).toString());
                            }
                            if (outputs.get(field.getBinding()) != null) {
                                item.setValue(outputs.get(field.getBinding()).toString());
                            }
                            
                            item.setReadOnly(field.isReadOnly());
                            item.setRequired(field.isRequired());
                            
                            // generate column content                    
                            Map<String, Object> parameters = new HashMap();
                            parameters.put("item", item);
                            parameters.put("serverPath", this.serverPath); // used to generate link for documents
                            String output = renderTemplate(FORM_GROUP_LAYOUT_TEMPLATE, parameters);
                            // append rendered content to the column content
                            content.append(output);
                            
                            // add the field to json template
                            appendFieldJSON(jsonTemplate, fieldType, field.getBinding(), field.getId(), jsType);
                        } else {
                            logger.warn("Field type {} is not supported, skipping it...", field.getCode());
                        }
                    }
                }
                
                column.setContent(content.toString());
            }
        }

        if (form.getModel().getClassName() != null && wrapJson) {
            jsonTemplate
                .deleteCharAt(jsonTemplate.length() - 1)
                .append("}")
                .append("}")
                .append(",");
        }        

	}

	@Override
	protected void handleSubForm(FormInstance topLevelForm, FormField field, Map<String, Object> inputs,
			Map<String, Object> outputs, String layoutTemplate, StringBuilder jsonTemplate, boolean wrapJson,
			List<String> scriptDataList, StringBuilder content) {
		System.out.println("handleSubForm called");
		// TODO Auto-generated method stub
		super.handleSubForm(topLevelForm, field, inputs, outputs, layoutTemplate, jsonTemplate, wrapJson, scriptDataList,
				content);
	}

	@Override
	protected void handleMultiSubForm(FormInstance topLevelForm, FormField field, Map<String, Object> inputs,
			Map<String, Object> outputs, String layoutTemplate, StringBuilder jsonTemplate, List<String> scriptDataList,
			StringBuilder content) {
		System.out.println("handleMultiSubForm called");
		// TODO Auto-generated method stub
		super.handleMultiSubForm(topLevelForm, field, inputs, outputs, layoutTemplate, jsonTemplate, scriptDataList, content);
	}

	@Override
	protected void loadTemplate(String templateId, InputStream stream) {
		// TODO Auto-generated method stub
		System.out.println("loadTemplate called");
		super.loadTemplate(templateId, stream);
	}

	@Override
	protected String read(InputStream input) {
		// TODO Auto-generated method stub
		System.out.println("read called");
		return super.read(input);
	}

	@Override
	protected String renderTemplate(String templateName, Map<String, Object> parameters) {
		// TODO Auto-generated method stub
		System.out.println("renderTemplate called");
		return super.renderTemplate(templateName, parameters);
	}

	@Override
	protected void appendFieldJSON(StringBuilder jsonTemplate, String type, String name, String id, String jsType) {
		// TODO Auto-generated method stub
		System.out.println("appendFieldJSON called");
		super.appendFieldJSON(jsonTemplate, type, name, id, jsType);
	}

	@Override
	protected String appendExtractionExpression(String type, String name, String id, String jsType) {
		// TODO Auto-generated method stub
		System.out.println("appendExtractionExpression called");
		return super.appendExtractionExpression(type, name, id, jsType);
	}

	@Override
	protected void appendRoleAssignment(CaseDefinition caseDefinition, StringBuilder jsonTemplate) {
		// TODO Auto-generated method stub
		System.out.println("appendRoleAssignment called");
		super.appendRoleAssignment(caseDefinition, jsonTemplate);
	}

	@Override
	protected String buildFunctionWithBody(String name, String body) {
		System.out.println("buildFunctionWithBody called");
		// TODO Auto-generated method stub
		return super.buildFunctionWithBody(name, body);
	}

	@Override
	protected String buildScriptData(List<String> scriptDataList) {
		System.out.println("buildScriptData called");
		// TODO Auto-generated method stub
		return super.buildScriptData(scriptDataList);
	}

	@Override
	protected String getFieldType(String type) {
		System.out.println("getFieldType called");
		// TODO Auto-generated method stub
		return super.getFieldType(type);
	}

	@Override
	protected String getExtractionValue(String jsType) {
		// TODO Auto-generated method stub
		System.out.println("getExtractionValue called");
		return super.getExtractionValue(jsType);
	}

	@Override
	protected String getValidationPatternByType(String type) {
		// TODO Auto-generated method stub
		System.out.println("getValidationPatternByType called");
		return super.getValidationPatternByType(type);
	}

	@Override
	protected String nonNull(String value) {
		// TODO Auto-generated method stub
		System.out.println("nonNull called");
		return super.nonNull(value);
	}

	private static final Logger logger = LoggerFactory.getLogger(AuditFormRenderer.class);
 
    public AuditFormRenderer() {
        super(null,  null);
        System.out.println("AuditFormRenderer Called");
        this.inputTypes = new HashMap();
        this.inputTypes.put("TextBox", "text");
        this.inputTypes.put("IntegerBox", "text");
        this.inputTypes.put("DecimalBox", "text");
        this.inputTypes.put("TextArea", "textarea");
        this.inputTypes.put("CheckBox", "checkbox");
        this.inputTypes.put("ListBox", "select");
        this.inputTypes.put("RadioGroup", "radio");
        this.inputTypes.put("Document", "file");
        this.inputTypes.put("DatePicker", "date");
        System.out.println("AuditFormRenderer Called" + this.inputTypes);
    }
     
    public AuditFormRenderer(String serverPath, String resources) {
        super(serverPath, resources);
        System.out.println("AuditFormRenderer Called");
        this.serverPath = serverPath;
        this.inputTypes = new HashMap();
        this.inputTypes.put("TextBox", "text");
        this.inputTypes.put("IntegerBox", "text");
        this.inputTypes.put("DecimalBox", "text");
        this.inputTypes.put("TextArea", "textarea");
        this.inputTypes.put("CheckBox", "checkbox");
        this.inputTypes.put("ListBox", "select");
        this.inputTypes.put("RadioGroup", "radio");
        this.inputTypes.put("Document", "file");
        this.inputTypes.put("DatePicker", "date");
        System.out.println("AuditFormRenderer Called" + this.inputTypes);
    }
     
    public String getName() {
        return "auditor";
    }
 
    @Override
    protected void loadTemplates() {
        loadTemplate(MASTER_LAYOUT_TEMPLATE, this.getClass().getResourceAsStream("/form-templates-providers/auditor/master-template.html"));
        loadTemplate(PROCESS_LAYOUT_TEMPLATE, this.getClass().getResourceAsStream("/form-templates-providers/auditor/process-layout-template.html"));
        loadTemplate(TASK_LAYOUT_TEMPLATE, this.getClass().getResourceAsStream("/form-templates-providers/auditor/task-layout-template.html"));
        loadTemplate(FORM_GROUP_LAYOUT_TEMPLATE, this.getClass().getResourceAsStream("/form-templates-providers/auditor/input-form-group-template.html"));
        loadTemplate(HEADER_LAYOUT_TEMPLATE, this.getClass().getResourceAsStream("/form-templates-providers/auditor/header-template.html"));
        loadTemplate(CASE_LAYOUT_TEMPLATE, this.getClass().getResourceAsStream("/form-templates-providers/auditor/case-layout-template.html"));
        loadTemplate(TABLE_LAYOUT_TEMPLATE, this.getClass().getResourceAsStream("/form-templates-providers/auditor/table-template.html"));
        loadTemplate(HTML_LAYOUT_TEMPLATE, this.getClass().getResourceAsStream("/form-templates-providers/auditor/html-template.html"));
         
        logger.info("Custom Form renderer templates loaded successfully.");
    }
 
}
