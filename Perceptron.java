package Perceptron;

import java.util.Random;

public class Perceptron {
	private float[] m_weights	= new float[3]; 	//two for the inputs and one for the bias
	private double learningrate	= 0.01;             //how fast the weights change
	
	Random rand = new Random();
	
	public Perceptron() {
		//Setting all the weights to random numbers
		System.out.println("Starting Weights : ");
		for (int i = 0; i < m_weights.length; i++) {
			m_weights[i] = (float) (rand.nextGaussian() * 1.0f);
			System.out.print(m_weights[i] + " : ");
		}
		System.out.println("\n");
	}
	
	public float feedForward(float[] inputs) {
		float sum = 0;
		for (int i = 0; i < m_weights.length; i++) {
			sum += m_weights[i] * inputs[i];
		}
		//return activate(sum); //this will be used if you want the perceptron to answer yes or no questions
		return sum;             //this is just by default
	}
	
	public void train(float[] inputs, int target) {
		float guess = this.feedForward(inputs);
		float error = target - guess;
		for (int i = 0; i < m_weights.length; i++) {
			m_weights[i] += error * inputs[i] * learningrate;
		}
	}
	
	public static int activate(float sum) {
		if(sum >= 0) {
			return 1;
		} else {
			return -1;
		}
	}
}