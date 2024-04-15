package sit707_week5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;



public class WeatherControllerTest {
	private WeatherController wController;
	
	@Before
	public void setUp() {
		wController = WeatherController.getInstance();
	}
	
	@After
	public void tearDown() {
		wController.close();
	}

	@Test
	public void testStudentIdentity() {
		String studentId = "s223561446";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Sandriya Fernandes";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testTemperatureMin() {
		System.out.println("+++ testTemperatureMin +++");
		//Arrange
		double minTemperature = Double.MAX_VALUE;
		
		// Retrieve all the hours temperatures recorded as for today
		int nHours = wController.getTotalHours();
		
		for (int i=0; i<nHours; i++) {
			// Hour range: 1 to nHours
			double temperatureVal = wController.getTemperatureForHour(i+1); 
			if (minTemperature > temperatureVal) {
				minTemperature = temperatureVal;
			}
		}
		
		// Should be equal to the min value that is cached in the controller.
		Assert.assertEquals(minTemperature,wController.getTemperatureMinFromCache(),0.01);		
	}
	
	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");
		double maxTemperature = Double.MIN_VALUE;
		// Initialise controller
		WeatherController wController = WeatherController.getInstance();
		
		// Retrieve all the hours temperatures recorded as for today
		int nHours = wController.getTotalHours();
		
		for (int i=0; i<nHours; i++) {
			// Hour range: 1 to nHours
			double temperatureVal = wController.getTemperatureForHour(i+1); 
			if (maxTemperature < temperatureVal) {
				maxTemperature = temperatureVal;
			}
		}
		
		// Should be equal to the min value that is cached in the controller.
		Assert.assertEquals(maxTemperature,wController.getTemperatureMaxFromCache(),0.01);
		
		
	}

	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");
		//Arrange
		double sumTemp = 0;
		int nHours = wController.getTotalHours();

		//Act
		for (int i=0; i<nHours; i++) {
			// Hour range: 1 to nHours
			double temperatureVal = wController.getTemperatureForHour(i+1); 
			sumTemp += temperatureVal;
		}
		double averageTemp = sumTemp / nHours;
		
		// Should be equal to the min value that is cached in the controller.
		Assert.assertEquals(averageTemp,wController.getTemperatureAverageFromCache(),0.01);
		
		
	}
	
	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
}
