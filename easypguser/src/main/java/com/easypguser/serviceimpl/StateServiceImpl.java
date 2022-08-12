package com.easypguser.serviceimpl;

import java.sql.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easypguser.dao.StateDao;
import com.easypguser.model.State;
import com.easypguser.service.StateService;

@Service("stateservice")
@Transactional
public class StateServiceImpl implements StateService{

	@Autowired
	StateDao statedao;
	
	
//	public long addState(State state) {
//		state.setIsActive(1);
//		state.setIsDeleted(0);
//		return statedao.addState(state);
//	}
//
//	public State editState(long id) {
//		// TODO Auto-generated method stub
//		return statedao.getById(id);
//	}
//
//	public boolean deleteState(long id) {
//		return statedao.deleteState(id);
//	}

	public List<State> getAll() {
		return statedao.getAll();
	}

	public State getById(long id) {
		return statedao.getById(id);
	}
	

}
