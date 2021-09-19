package utilities;

import java.io.IOException;

public class Comparator {
	
	private static String propertiesfilename = "Test-Data.properties";
	
	public static String compareTemp(double ui, double api) throws IOException {
		if(ui==api) {
			return "Temperature is same in both sources. No need for variance";
		} else {
			String v = "";
			try {
				v = variance(ui, api);
			}catch(VarianceException e) {
				v = e.getMessage();
			}
			return "Temperature is different in both sources. Execute variance: "+v;
		}
	}
	
	public static String variance(double ui, double api) throws IOException, VarianceException {
		double diff;
		if(api>ui) {
			diff = api-ui;
		} else {
			diff = ui-api;
		}
		double limit = Double.parseDouble(configPropertyReader.readAndGetProperty("differenceLimit", propertiesfilename));
		if(diff<=limit) {
			return "Success";
		} else {
			throw new VarianceException("Exception: Difference is greater than allowed limit");
		}
	}
}
