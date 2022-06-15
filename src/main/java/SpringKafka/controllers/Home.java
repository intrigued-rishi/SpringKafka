package SpringKafka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Home {
	
	@Autowired
	private KafkaTemplate<String, String> kt;
	
	@RequestMapping("/pub/{msg}")
	@ResponseBody
	public String publish(@PathVariable("msg") String msg) {
		System.out.println("yo");
		kt.send("temp",msg);
		return "Published Succussfully";
	}
}
