package tests;

import fr.inria.domain.Configuration;
import fr.inria.generator.RandomGenerator;
import fr.inria.reader.VMReader;

public class LoadModelTest {

	public static void main(String[] args) throws Exception {
		
		Configuration randomConfiguration = RandomGenerator.generateConfiguration(1);

		VMReader model = new VMReader();
		model.parseFile("MOTIV.vm");
		//isValidConf
		isValidConfiguration(model, randomConfiguration);
	
	}

	public static void generateAllConfigurations(VMReader model){
		model.reasoner.setConstraints();
		model.reasoner.allSolutions();
	}
	
	public static void isValidConfiguration(VMReader model,Configuration conf){
		model.reasoner.setConstraints();
		
		boolean validConf = model.reasoner.isValidConf(conf);
		if(validConf){
			System.out.println("The model is valid");
		}else{
			System.out.println("The model is invalid");
		}
	}
	
}
