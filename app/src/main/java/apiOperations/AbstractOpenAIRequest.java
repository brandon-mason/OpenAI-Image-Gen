package apiOperations;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbstractOpenAIRequest {
    protected String apiKey;
    protected String model;

    public AbstractOpenAIRequest(String apiKey, String model) {
        this.apiKey = apiKey;
        this.model = model;
    }

    /**
     * Constructs the JSON body specific to the API request.
     *
     * @return A JSONObject representing the request body.
     */
    protected abstract JSONObject constructRequestBody() throws JSONException;

    /**
     * Executes the API request with the given URL.
     *
     * @param apiUrl The API endpoint URL.
     * @return The response content as a String.
     * @throws Exception If an error occurs during the request.
     */
    public String execute(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Bearer " + apiKey);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        // Construct and send the JSON body
        // catch in try-catch block is handled by the caller of execute()
        try {
            JSONObject requestBody = constructRequestBody();
            OutputStream os = connection.getOutputStream();
            os.write(requestBody.toString().getBytes("UTF-8"));
        } catch (Exception e) {
            return ("Unable to send OpenAI request: " + e.getMessage());
        }

        // Read and return the response
        try (Scanner scanner = new Scanner(connection.getInputStream())) {
            StringBuilder response = new StringBuilder();
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            return parseResponse(response.toString());
        } catch (Exception e) {
            return ("Unable to read OpenAI response: " + e.getMessage());
        }
    }

    /**
     * Parses the API response and extracts the desired result.
     *
     * @param jsonResponse The raw JSON response as a String.
     * @return The parsed response content.
     */
    protected abstract String parseResponse(String jsonResponse);
}
