package org.mano.project.individual.resources.common;

import org.mano.project.individual.resources.common.IndividualApiImpl.CreateIndividualParameters;
import org.mano.project.individual.resources.common.IndividualApiImpl.ICreateIndividualDelegate;
import org.mano.project.individual.resources.delegates.CreateIndividualDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResourceConfig {
	@Bean public ICreateIndividualDelegate createIndividualDelegate() {
		return new CreateIndividualDelegate();
	}
	
	@Bean public CreateIndividualParameters createIndividualParameters() {
		return new  CreateIndividualParameters();
	}
}
