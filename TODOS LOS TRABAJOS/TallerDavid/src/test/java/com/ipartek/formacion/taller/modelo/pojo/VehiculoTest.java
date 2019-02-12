package com.ipartek.formacion.taller.modelo.pojo;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

import com.ipartek.formacion.taller.modelo.pojo.validactions.VehiculoCompleteCheck;
import com.ipartek.formacion.taller.modelo.pojo.validactions.VehiculosPostCheck;

public class VehiculoTest {

	@Test
	public void test() {
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Vehiculo vCompleteCheck = new Vehiculo();
		Vehiculo vPostCheck = new Vehiculo();
		Combustible cCompleteCheck = new Combustible();
		Combustible cPostCheck = new Combustible();
		
	//Combustible vCompleteCheck = new Combustible();
		//Combustible  vPostCheck = new Combustible();
				
		Set<ConstraintViolation<Vehiculo>> vComplete = validator.validate(vCompleteCheck, VehiculoCompleteCheck.class );
		Set<ConstraintViolation<Combustible>> cComplete = validator.validate(cCompleteCheck, VehiculoCompleteCheck.class );
		Set<ConstraintViolation<Vehiculo>> vPost = validator.validate(vPostCheck, VehiculosPostCheck.class );
		
		
		assertEquals("Deberia haber 5 violaciones", 5 , vComplete.size() );
		assertEquals("Deberia haber 4 violaciones", 4 , vPost.size() );
		
		vCompleteCheck.setMatricula("12");
		vComplete = validator.validate(vCompleteCheck, VehiculoCompleteCheck.class );
		assertEquals("quitamos viloacion NotEmpty", 4 , vComplete.size() );
		
		
		vCompleteCheck.setMatricula("12345678");
		vComplete = validator.validate(vCompleteCheck, VehiculoCompleteCheck.class );
		assertEquals("quitamos viloacion Size(min=8, max =10)", 3 , vComplete.size() );
		
		
		vCompleteCheck.setNumeroBastidor("12");
		vComplete = validator.validate(vCompleteCheck, VehiculoCompleteCheck.class );
		assertEquals("quitamos viloacion NotEmpty", 2 , vComplete.size() );
		
		
		
		vCompleteCheck.setNumeroBastidor("12345678901234567");
		vComplete = validator.validate(vCompleteCheck, VehiculoCompleteCheck.class );
		assertEquals("quitamos viloacion Size(min=17, max =17)", 1 , vComplete.size() );
	
		cCompleteCheck.setNombre("as");
		cComplete = validator.validate(cCompleteCheck, VehiculoCompleteCheck.class );
		assertEquals("quitamos viloacion Size(min=1, max =45)", 0 , cComplete.size() );
	
	
	}

}
