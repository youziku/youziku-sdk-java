package youziku.sdk.test.impl;

import youziku.sdk.test.*;

import com.youziku.sdk.*;
 
public class Test {

	/**
	 * Test Main
	 * 
	 * @param args
	 * @author
	 */
	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {

			IInterfaceTest test = new SingleTestImpl();
			test.Run(i);
		}

	}

}
