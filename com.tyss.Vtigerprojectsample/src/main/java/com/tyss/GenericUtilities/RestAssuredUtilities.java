package com.tyss.GenericUtilities;

import io.restassured.response.Response;

public class RestAssuredUtilities {
	

		public String getJsonData(Response response, String path)
		{
			String jsonData=response.jsonPath().get(path);
			return jsonData;
		}

	}


