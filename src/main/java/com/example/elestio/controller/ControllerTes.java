package com.example.elestio.controller;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Controller
public class ControllerTes {

	@GetMapping("/")
	public String getdata(Model model, HttpServletRequest request) throws ParseException {

		if (request.getHeader("X-Forwarded-For") != "" && request.getHeader("X-Forwarded-For") != null) {
			model.addAttribute("ip", request.getHeader("X-Forwarded-For"));
			String ip = request.getHeader("X-Forwarded-For");
			String uri = "https://ipinfo.io/" + ip + "/json";
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(uri, String.class);
			String jsonstring = result;

			JSONParser jsonparser = new JSONParser();

			Object obj = jsonparser.parse(jsonstring);

			JSONObject resultobj = (JSONObject) obj;

			if (resultobj.get("country") != null && resultobj.get("city") != null) {
				model.addAttribute("country", resultobj.get("country"));
				model.addAttribute("city", resultobj.get("city"));
				model.addAttribute("bool", true);
			} else {
				model.addAttribute("bool", false);
			}

		}

		else if (request.getRemoteAddr() != "" && request.getRemoteAddr() != null) {
			model.addAttribute("ip", request.getRemoteAddr());
			String ip = request.getRemoteAddr();
			String uri = "https://ipinfo.io/" + ip + "/json";
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(uri, String.class);
			String jsonstring = result;

			JSONParser jsonparser = new JSONParser();

			Object obj = jsonparser.parse(jsonstring);

			JSONObject resultobj = (JSONObject) obj;

			if (resultobj.get("country") != null && resultobj.get("city") != null) {
				model.addAttribute("country", resultobj.get("country"));
				model.addAttribute("city", resultobj.get("city"));
				model.addAttribute("bool", true);
			} else {
				model.addAttribute("bool", false);
			}

		} else {
			model.addAttribute("ip", "?");
		}
		try {
			InetAddress ia = InetAddress.getLocalHost();
			String ipAddress = ia.getHostAddress();
			model.addAttribute("host", ipAddress);

		} catch (UnknownHostException e) {

			model.addAttribute("host", "?");
		}
		return "elestio";
	}
}
