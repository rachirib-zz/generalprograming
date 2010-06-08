package co.com.fc.model;

import co.com.fc.bd.model.FacrCredito;

public class TaskVo {
	private String taskName;
	private String numberProcessDays;
	private String createDate;
	private String processId;
	private String taskId;
	private FacrCredito facrCredito;



	public FacrCredito getFacrCredito() {
		return facrCredito;
	}

	public void setFacrCredito(FacrCredito facrCredito) {
		this.facrCredito = facrCredito;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getNumberProcessDays() {
		return numberProcessDays;
	}

	public void setNumberProcessDays(String numberProcessDays) {
		this.numberProcessDays = numberProcessDays;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}


}
