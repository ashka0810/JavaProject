package com.easypguser.service;

import java.util.List;

import com.easypguser.model.State;

public interface StateService {
//	public long addState(State state);
//	public State editState(long id);
//	public boolean deleteState(long id);
	public List<State> getAll();

	public State getById(long id);
}
