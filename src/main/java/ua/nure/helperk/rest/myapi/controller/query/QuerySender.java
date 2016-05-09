package ua.nure.helperk.rest.myapi.controller.query;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

/**
 * @author Oleg Dashkevych.
 */
public abstract class QuerySender {

    protected Throwable throwable;

    protected DefaultHttpClient httpClient;

    protected ResponseHandler<String> responseHandler;

    protected String query;


    protected void setUpConnectionParams(String query) {
        httpClient = new DefaultHttpClient();
        responseHandler = new BasicResponseHandler();
        this.query = query;
    }

    protected HttpGet makeGetQuery() {
        return new HttpGet(query);
    }

    protected JSONObject getJSONObjectResponse() throws IOException {
        return new JSONObject(getResponseString());
    }

    protected JSONArray getJSONArrayResponse() throws IOException {
        return new JSONArray(getResponseString());
    }

    protected String getResponseString() throws IOException {
        return httpClient.execute(makeGetQuery(), responseHandler);
    }
}
