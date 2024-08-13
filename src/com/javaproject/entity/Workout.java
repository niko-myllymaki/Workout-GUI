package com.javaproject.entity;

import java.util.ArrayList;

public class Workout {

	private String date;
	private String type;
	private ArrayList<Exercise> exercises;

	public Workout() {

	}

	public Workout(String date, String type, ArrayList<Exercise> exercises) {
		this.date = date;
		this.type = type;
		this.exercises = exercises;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setExercises(ArrayList<Exercise> exercises) {
		this.exercises = exercises;
	}

	public ArrayList<Exercise> getExercises() {
		return exercises;
	}

	@Override
	public String toString() {
		return date + " " + type + " " + exercises.toString();
	}
}
