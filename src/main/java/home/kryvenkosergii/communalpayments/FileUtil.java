package home.kryvenkosergii.communalpayments;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class 'FileUtil' for reading file with a value of meters and writing logfile
 * @author Serg
 *
 */
public class FileUtil {
	private int gasMeterValue;
	private int waterMeterValue;
	private int electricityMeterValueDay;
	private int electricityMeterValueNight;

	/**
	 * constructor, which receive value String type and execute method 'load' for getting values meters from file
	 * @param filePath
	 */
	public FileUtil(String filePath) {
		try {
			load(filePath);
		} catch (IOException e) {
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}
	}

	/**
	 * The method 'getGasMeterValue' for getting gas meter value
	 * @return gasMeterValue
	 */
	public int getGasMeterValue() {
		return gasMeterValue;
	}

	/**
	 * The method 'getWaterMeterValue' for getting water meter value
	 * @return getWaterMeterValue
	 */
	public int getWaterMeterValue() {
		return waterMeterValue;
	}

	/**
	 * The method 'getElectricityMeterValueDay' for getting electricity day value
	 * @return
	 */
	public int getElectricityMeterValueDay() {
		return electricityMeterValueDay;
	}

	/**
	 * The method 'getElectricityNightValue' for getting electricity night value
	 * @return getElectricityMeterValueNight
	 */
	public int getElectricityMeterValueNight() {
		return electricityMeterValueNight;
	}

	/**
	 * The method 'load' for getting values meters from file. Receive value String type.
	 * @param filePath
	 * @throws IOException
	 */
	private void load(String filePath) throws IOException {

		Pattern gasValue = Pattern.compile("Value of gas: (\\d+)\\s?");
		Matcher matcherGasValue;
		Pattern waterValue = Pattern.compile("Value of water: (\\d+)\\s?");
		Matcher matcherWaterValue;
		Pattern electroDayValue = Pattern.compile("Value of electricity day: (\\d+)\\s?");
		Matcher matcherElectroDayValue;
		Pattern electroNightValue = Pattern.compile("Value of electricity night: (\\d+)\\s?");
		Matcher matcherelectroNightValue;

		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String st;
		while ((st = br.readLine()) != null) {
			matcherGasValue = gasValue.matcher(st);
			matcherWaterValue = waterValue.matcher(st);
			matcherElectroDayValue = electroDayValue.matcher(st);
			matcherelectroNightValue = electroNightValue.matcher(st);

			if (matcherGasValue.find()) {
				st.trim();
				this.gasMeterValue = Integer
						.parseInt(((String) st.subSequence(matcherGasValue.start(1), matcherGasValue.end(1))));
			}

			if (matcherWaterValue.find()) {
				st.trim();
				this.waterMeterValue = Integer
						.parseInt(((String) st.subSequence(matcherWaterValue.start(1), matcherWaterValue.end(1))));
			}

			if (matcherElectroDayValue.find()) {
				st.trim();
				this.electricityMeterValueDay = Integer.parseInt(
						((String) st.subSequence(matcherElectroDayValue.start(1), matcherElectroDayValue.end(1))));
			}

			if (matcherelectroNightValue.find()) {
				st.trim();
				this.electricityMeterValueNight = Integer.parseInt(
						((String) st.subSequence(matcherelectroNightValue.start(1), matcherelectroNightValue.end(1))));
			}

		}
		br.close();
	}

	/**
	 * The method 'save' for saving log values to file. Receive values String type.
	 * @param nameLogFile
	 * @param text
	 */
	public void save(String nameLogFile, String text) {

		LocalDateTime currentTime = LocalDateTime.now();

		try {
			FileWriter fw = new FileWriter(nameLogFile, true); // the true will append the new data
			fw.write(currentTime + " " + text + "\n");// appends the string to the file
			fw.close();
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
		}

	}
}
