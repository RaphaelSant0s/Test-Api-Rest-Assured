package rest.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class JsonManager {

	public static JsonObject getJsonObject(File jsonFile) throws IOException {
		String jsonStr = new String(Files.readAllBytes(jsonFile.toPath()));
		JsonParser jsonParser = new JsonParser();
		return jsonParser.parse(jsonStr).getAsJsonObject();
	}
	
	public static String getJsonAsString(File jsonFile) throws IOException {
		String jsonStr = new String(Files.readAllBytes(jsonFile.toPath()));
		JsonParser jsonParser = new JsonParser();
		return jsonParser.parse(jsonStr).getAsJsonObject().toString();
	}
}
