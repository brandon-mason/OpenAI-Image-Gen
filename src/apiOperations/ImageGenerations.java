package apiOperations;

import org.json.JSONException;
import org.json.JSONObject;

public class ImageGenerations extends AbstractOpenAIRequest {
    private String model;
    private String prompt;

    public ImageGenerations(String apiKey, String model, String prompt) {
        super(apiKey, model); // Pass apiKey and model to the abstract class constructor
        this.model = model;
        this.prompt = prompt;
    }

    @Override
    protected JSONObject constructRequestBody() throws JSONException {
        JSONObject body = new JSONObject();
        body.put("model", model);
        body.put("prompt", prompt);
        body.put("size", "1024x1024");
        body.put("user", "bjm241");

        return body;
    }

    @Override
    protected String parseResponse(String jsonResponse) {
        try {
            JSONObject json = new JSONObject(jsonResponse);
            return json.getJSONArray("data")
                    .getJSONObject(0)
                    .getString("url");
        } catch (JSONException e) {
            return ("Unable to parse OpenAI JSON response " + e.getMessage());
        }
    }
}
