package com.app.dao;

import com.app.pojos.Feedback;

import java.util.List;



public interface IFeedback {
	String addNewFeedback(Feedback f);
	public List<Feedback> getAllFeedback();
}
