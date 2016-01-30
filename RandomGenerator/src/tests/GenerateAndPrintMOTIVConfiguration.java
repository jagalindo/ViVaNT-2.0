package tests;

import fr.inria.domain.Configuration;
import fr.inria.generator.RandomGenerator;
import fr.inria.writer.MOTIVConfigurationWriter;

public class GenerateAndPrintMOTIVConfiguration {

	public static void main(String[] args) {

		RandomGenerator generator = new RandomGenerator();
		MOTIVConfigurationWriter writer = new MOTIVConfigurationWriter();
		for(int i=0;i<10;i++){

			Configuration c = generator.generateConfiguration(i);
			writer.printConf("", c);
		}
	}

}
