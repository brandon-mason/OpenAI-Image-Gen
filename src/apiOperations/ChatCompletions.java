package apiOperations;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatCompletions extends AbstractOpenAIRequest {
    private String systemPersonality;
    private String userPrompt;
    private int maxTokens;

    public ChatCompletions(String apiKey, String model, String systemPersonality, String userPrompt, int maxTokens) {
        super(apiKey, model); // Pass apiKey and model to the abstract class constructor
        this.systemPersonality = systemPersonality;
        this.userPrompt = userPrompt;
        this.maxTokens = maxTokens;
    }

    @Override
    protected JSONObject constructRequestBody() throws JSONException {

        JSONObject body = new JSONObject();
        body.put("model", model);

        JSONArray messages = new JSONArray();
        messages.put(new JSONObject().put("role", "system").put("content", systemPersonality));
        messages.put(new JSONObject().put("role", "user").put("content", userPrompt));

        body.put("messages", messages);
        body.put("max_tokens", maxTokens);

        return body;

    }

    @Override
    protected String parseResponse(String jsonResponse) {
        try {
            JSONObject json = new JSONObject(jsonResponse);
            return json.getJSONArray("choices")
                    .getJSONObject(0)
                    .getJSONObject("message")
                    .getString("content");
        } catch (JSONException e) {
            return ("Unable to parse OpenAI JSON response " + e.getMessage());
        }
    }
}
