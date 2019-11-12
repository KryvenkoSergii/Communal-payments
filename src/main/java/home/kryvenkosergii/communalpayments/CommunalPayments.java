package home.kryvenkosergii.communalpayments;

/**
 * The class 'CommunalPayments' for sending communal meters values to private
 * consumer pages in web sites
 * 
 * @author Serg
 *
 */
public class CommunalPayments {

	public static void main(String args[]) {
		String pathFile = "values.txt";
		FileUtil value = new FileUtil(pathFile);

		WebSiteInfoLviv valueInfoLviv = new WebSiteInfoLviv(value.getGasMeterValue(), value.getWaterMeterValue());
		WebSite104UA value104UA = new WebSite104UA(value.getGasMeterValue());
		WebSiteLOE valueLOE = new WebSiteLOE(value.getElectricityMeterValueNight(),
				value.getElectricityMeterValueDay());

		new Thread(new Runnable() {
			public void run() {
				valueInfoLviv.enterValue();
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				value104UA.enterValue();
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				valueLOE.enterValue();
			}
		}).start();

	}

}
