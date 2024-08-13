package com.javaproject.entity;

public class Exercise {

	private String exerciseName;
	private double weight;
	private int sets;
	private int repetitions;

	public Exercise() {

	}

	public Exercise(String exerciseName, double weight, int sets, int repetitions) {
		this.exerciseName = exerciseName;
		this.weight = weight;
		this.sets = sets;
		this.repetitions = repetitions;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public double getSets() {
		return sets;
	}

	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}

	public double getRepetitions() {
		return repetitions;
	}

	@Override
	public String toString() {
		return exerciseName + " " + weight + " kg " + sets + " X " + repetitions;
	}

}
