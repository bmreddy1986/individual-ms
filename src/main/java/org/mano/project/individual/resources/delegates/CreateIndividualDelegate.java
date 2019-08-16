package org.mano.project.individual.resources.delegates;

import org.mano.project.individual.resources.common.IndividualApiImpl.CreateIndividualParameters;
import org.mano.project.individual.resources.common.IndividualApiImpl.ICreateIndividualDelegate;
import org.mano.project.individual.resources.models.Individual;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class CreateIndividualDelegate implements ICreateIndividualDelegate {

	@Override
	public ResponseEntity<Individual> execute(CreateIndividualParameters parameters) {
		Individual individual = new Individual();
		individual.setFirstName("manohar");
		individual.setLastName("reddy");
		//individual.setId(12345);
		return new ResponseEntity<Individual>(individual, HttpStatus.OK);
	}

}
