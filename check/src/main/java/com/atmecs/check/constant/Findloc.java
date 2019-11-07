package com.atmecs.check.constant;

import java.util.Properties;

import com.atmecs.check.util.ReadProp;
/**
 * Find locator class
 * @author rishav.kumar
 *
 */
public class Findloc {
	static Properties assessment;

	public Findloc() {
		assessment = ReadProp.loadProperty(FilePath.LOCATOR_FILE);
	}

	public String getlocator(String key) {
		String value = assessment.getProperty(key);
		return value;

	}

}
