package org.mano.project.individual.resources.common;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.mano.project.individual.resources.interfaces.IndividualApi;
import org.mano.project.individual.resources.models.Individual;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-14T17:45:11.535+05:30")

@Controller
public class IndividualApiImpl implements IndividualApi, ApplicationContextAware {

    private static final Logger log = LoggerFactory.getLogger(IndividualApiImpl.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Inject public IndividualApiImpl(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
    
    private ApplicationContext applicationContext;
    @Override public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ResponseEntity<Individual> getIndividual(@ApiParam(value = "Unique identifier of individual",required=true) @PathVariable("individualId") Long individualId,@ApiParam(value = "The locale of the client" ) @RequestHeader(value="Accept-Language", required=false) String acceptLanguage) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Individual>(objectMapper.readValue("{  \"firstName\" : \"firstName\",  \"lastName\" : \"lastName\",  \"id\" : 0}", Individual.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Individual>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Individual>(HttpStatus.NOT_IMPLEMENTED);
    }
    
    public ResponseEntity<Individual> createIndividual(@ApiParam(value = "The new individual to be created." ,required=true ) @RequestBody Individual individual,@ApiParam(value = "The locale of the client"  ) @RequestHeader(value="Accept-Language", required=false) String acceptLanguage) {
        IndividualApiImpl.ICreateIndividualDelegate delegate = this.applicationContext.getBean(IndividualApiImpl.ICreateIndividualDelegate.class);
    	IndividualApiImpl.CreateIndividualParameters parameters = this.applicationContext.getBean(IndividualApiImpl.CreateIndividualParameters.class);
        parameters.setBody(individual);
        parameters.setAcceptLanguage(acceptLanguage);
        parameters.setSalesChannel("");
        return delegate.execute( parameters);
    }
    
    public static class CreateIndividualParameters {
    
    	private Individual body;
        private String acceptLanguage;
        private String salesChannel;
      
        public Individual getBody() {
            return this.body;
        }
        public void setBody(Individual body) {
            this.body = body;
        }
   
        public String getAcceptLanguage() {
            return this.acceptLanguage;
        }
        public void setAcceptLanguage(String acceptLanguage) {
            this.acceptLanguage = acceptLanguage;
        }
   
        public String getSalesChannel() {
            return this.salesChannel;
        }
        public void setSalesChannel(String salesChannel) {
            this.salesChannel = salesChannel;
        }   
    }
    public interface ICreateIndividualDelegate {
		public ResponseEntity<Individual> execute(IndividualApiImpl.CreateIndividualParameters parameters);
    }

}
