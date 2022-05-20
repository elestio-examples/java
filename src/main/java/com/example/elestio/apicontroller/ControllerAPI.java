package com.example.elestio.apicontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ControllerAPI {

@RequestMapping("/data")

public Map<String,String> apicall() {

	HashMap<String, String> map = new HashMap<>();
	map.put("status", "200");
    return map;

}

}