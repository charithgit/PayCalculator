package org.chc.payslip.io;

import java.util.ArrayList;
/**
 * Represent a Data output/target
 * @author Charith
 *
 * @param <E>
 */
public interface DataOutput <E> {
	public boolean write(String location,ArrayList<E> data);

	
}
