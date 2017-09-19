/************************************************************************

This is just a file for testing the Perceptron.
If you deside to download the perceptron you should not use this file.
This is just an example.

Author: Lucas Gillberg Kling

************************************************************************/

import Perceptron.*;

public class Source {
	private static final long serialVersionUID = 1L;	//Not needed
	
	static Perceptron ptron = new Perceptron();
	
	public static void main(String[] args) {
		float[] inputs = {
				0,5,
				-1,5,
				1 //bias
		};
		
		System.out.println(ptron.feedForward(inputs));
		for (int i = 0; i < 100; i++) {
			ptron.train(inputs, 1);
			System.out.println(ptron.feedForward(inputs));
		}
	}
}