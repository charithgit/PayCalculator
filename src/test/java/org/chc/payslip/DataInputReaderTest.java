package org.chc.payslip;

import static org.junit.Assert.assertNotNull;

import org.chc.payslip.io.ExcelDataInput;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test the functoinlity of the data input
 * 
 * @author Charith
 *
 */
@Ignore
public class DataInputReaderTest {

	@Test
	public void testDataReadSucess() {
		
		assertNotNull(ExcelDataInput.getInstance().read("C:\\DELME\\employee.csv"));

	}

	
	
}
