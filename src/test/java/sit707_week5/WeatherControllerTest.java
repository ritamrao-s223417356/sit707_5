package sit707_week5;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest {
    private static WeatherController wController;
    private static int nHours;
    private static double[] temperatures;

    @BeforeClass
    public static void setUp() {
        // Initialize controller only once
        wController = WeatherController.getInstance();
        // Retrieve total hours and temperatures
        nHours = wController.getTotalHours();
        temperatures = new double[nHours];
        for (int i = 0; i < nHours; i++) {
            temperatures[i] = wController.getTemperatureForHour(i + 1);
        }
    }

    @AfterClass
    public static void tearDown() {
        // Close controller after all tests are done
        wController.close();
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "s223417356";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Ritam Sunil Rao";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");

        double minTemperature = Double.MAX_VALUE;
        for (double temperature : temperatures) {
            if (minTemperature > temperature) {
                minTemperature = temperature;
            }
        }

        // Should be equal to the min value that is cached in the controller.
        Assert.assertEquals(minTemperature, wController.getTemperatureMinFromCache(), 0);
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");

        double maxTemperature = Double.MIN_VALUE;
        for (double temperature : temperatures) {
            if (maxTemperature < temperature) {
                maxTemperature = temperature;
            }
        }

        // Should be equal to the max value that is cached in the controller.
        Assert.assertEquals(maxTemperature, wController.getTemperatureMaxFromCache(), 0);
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");

        double sumTemp = 0;
        for (double temperature : temperatures) {
            sumTemp += temperature;
        }
        double averageTemp = sumTemp / nHours;

        // Should be equal to the average value that is cached in the controller.
        Assert.assertEquals(averageTemp, wController.getTemperatureAverageFromCache(), 0);
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
