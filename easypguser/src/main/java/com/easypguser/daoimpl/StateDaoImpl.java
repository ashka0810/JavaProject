package com.easypguser.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.easypguser.dao.StateDao;
import com.easypguser.model.State;


@Repository("StateDao")
public class StateDaoImpl extends GenericDaoImpl<State> implements StateDao{

	public List<State> getAll() {
		return super.getByQuery("FROM State s WHERE s.isDeleted=0");
	}

	public State getById(long id) {
		return super.getById(State.class,id);
	}

	public boolean deleteState(long id) {
		State obj = super.getById(State.class,id);
		obj.setIsDeleted(1);
		return super.updateObject(obj).getStateId()>0;
	}

	public long addState(State state) {
		
		State new_obj =super.saveUpdateObject(state);
		return new_obj.getStateId();
	
	}
	
}