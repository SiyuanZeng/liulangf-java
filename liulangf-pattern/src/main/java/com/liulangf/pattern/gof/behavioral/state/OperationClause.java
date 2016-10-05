package com.liulangf.pattern.gof.behavioral.state;


public class OperationClause {
	//private static final transient Logger LOGGER = LoggerFactory.getLogger(OperationClause.class);

	protected ServiceInfo service;
	private OperationInfo operation = new OperationInfo();
	
	private State inputState = new InputState(this);
	private State outputState = new OutputState(this);
	private State state = inputState;
	
	public OperationClause(ServiceInfo service) {
		this.service = service;
	}
	
	//--------influent API--------
	public OperationClause name(String operationName) {
		operation.setName(operationName);
		service.addOperation(operation);
		return this;
	}
	
	public OperationClause input() {
		setState(inputState);
		return this;
	}
	
	public OperationClause output() {
		setState(outputState);
		return this;
	}
	
	public OperationClause args(String name, String type) {
		state.args(name, type);
		return this;
	}
	
	public OperationClause operation(String operationName) {
		return new OperationClause(service).name(operationName);
	}
	
	private void input(String name, String type) {
		operation.addInput(name, type);
	}
	
	private void output(String name, String type) {
		operation.addOutput(name, type);
	}
	
	private void setState(State state) {
		this.state = state;
	}
	
	/**
	 * A simple state pattern for operation clause.
	 */
	static interface State {
		public void args(String name, String type);
	}
	
	static class InputState implements State {
		private OperationClause operationClause;
		public InputState(OperationClause operationClause) {
			this.operationClause = operationClause;
		}
		public void args(String name, String type) {
			operationClause.input(name, type);
		}
	}
	
	static class OutputState implements State {
		private OperationClause operationClause;
		public OutputState(OperationClause operationClause) {
			this.operationClause = operationClause;
		}
		public void args(String name, String type) {
			operationClause.output(name, type);
		}
	}
}
