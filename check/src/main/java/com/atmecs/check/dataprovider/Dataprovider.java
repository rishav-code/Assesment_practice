package com.atmecs.check.dataprovider;

import org.testng.annotations.DataProvider;

import com.atmecs.check.constant.FilePath;
import com.atmecs.check.util.ProvideData;
/**
 * DataProvider class
 * 
 * @author rishav.kumar
 *
 */
public class Dataprovider {
	@DataProvider(name = "content")
	public Object[][] getData() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE, 0);
		Object[][] getData = provideData.provideData();
		return getData;
	}

	@DataProvider(name = "dynamicinput")
	public Object[][] getData1() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE, 1);
		Object[][] getData = provideData.provideData();
		return getData;
	}
	@DataProvider(name = "redbusdata")
	public Object[][] getData2() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE, 2);
		Object[][] getData = provideData.provideData();
		return getData;
}
	@DataProvider(name = "PractoData")
	public Object[][] getData3() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE, 3);
		Object[][] getData = provideData.provideData();
		return getData;
}
}
