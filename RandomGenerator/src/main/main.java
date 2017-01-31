package main;

import fr.inria.reader.VMReader;

public class main {

	public static void main(String[] args) throws Exception {

		VMReader reader = new VMReader();
		reader.parseFile("./inputs/MOTIV.vm");
		
		if(reader.reasoner.isValid()){
			System.out.println("The model is valid");
		}else{
			System.out.println("The model is not valid");
		}
		
	}

}
