package tests;

import java.util.Collection;

import fr.inria.domain.Configuration;
import fr.inria.generator.RandomGenerator;
import fr.inria.reader.VMReader;
import fr.inria.writer.MOTIVConfigurationWriter;

public class LoadModelTest {

	public static void main(String[] args) throws Exception {
		
		MOTIVConfigurationWriter writer =  new MOTIVConfigurationWriter();
		Configuration randomConfiguration = RandomGenerator.generateConfiguration(1);
		Collection<Configuration> configurations = RandomGenerator.generateSetOfConfigurations(20);
		VMReader model = new VMReader();
		model.parseFile("MOTIV.vm");
		//isValidConf
		isValidConfiguration(model, randomConfiguration);
		writer.printConf("", randomConfiguration);
		//areValidConfigurations(model,configurations);
	}

	private static void areValidConfigurations(VMReader model, Collection<Configuration> configurations) throws Exception {
		// TODO Auto-generated method stub
		for(Configuration c: configurations){
			isValidConfiguration(model, c);
			model = new VMReader();
			model.parseFile("MOTIV.vm");
		}
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
		System.out.println("The precision was "+ model.reasoner.solver.getPrecision());
	}
	
}
