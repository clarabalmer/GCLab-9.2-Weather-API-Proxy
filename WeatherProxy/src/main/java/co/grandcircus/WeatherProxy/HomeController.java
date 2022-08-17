package co.grandcircus.WeatherProxy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/forecast")
	public List<Period> getForecast(@RequestParam Double lat, @RequestParam Double lon) {
		String url = weatherService.getForecastURL(lat, lon);
		WeatherGridResponse gridResponse = weatherService.getGridResponse(url);
		return gridResponse.getProperties().getPeriods();
	}
	@GetMapping("/forecast/plus")
	public ProxyResponse getForecastPlus(@RequestParam Double lat, @RequestParam Double lon) {
		return weatherService.getProxyResponse(lat, lon);
	}
}
