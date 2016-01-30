package tests;

import fr.inria.reader.VMReader;

public class LoadModelTest {

	public static void main(String[] args) throws Exception {
		VMReader reader = new VMReader();
		reader.parseFile("./MOTIV.vm");
		reader.reasoner.setConstraints();
		reader.reasoner.allSolutions();
	}

}
