package com.liulangf.jsonp;

import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;
import org.junit.Test;

public class JsonpTest {

    @Test
	public void test() {
		Map<String, Object> properties = new HashMap<String, Object>(1);
		properties.put(JsonGenerator.PRETTY_PRINTING, true);
		JsonGeneratorFactory jgf = Json.createGeneratorFactory(properties);
		JsonGenerator jg = jgf.createGenerator(System.out);
		jg.writeStartObject()
		    .write("name", "liuyuqing")
		    .writeStartObject("address")
		        .write("type", 0)
		        .write("street", "aaaa")
		    .writeEnd()
		   .writeEnd()
		   .close();;
	}
}
