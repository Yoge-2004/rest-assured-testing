package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Purpose: Generates the payload for the petstore API testing
 * @since Java 26
 * @version 1.0
 * @author yogeshwaran
 *
 */

public class MockDataGenerator {

    /**
     *
     * Returns the map object replicating the sample payload.
     *
     * Sample Payload:
     * {
     *   "id": 0,
     *   "category": {
     *     "id": 0,
     *     "name": "string"
     *   },
     *   "name": "doggie",
     *   "photoUrls": [
     *     "string"
     *   ],
     *   "tags": [
     *     {
     *       "id": 0,
     *       "name": "string"
     *     }
     *   ],
     *   "status": "available"
     * }
     *
     *
     * @params No parameters
     * @return Map object representing JSON payload
     *
     */

    // The whole JSON
    public static Map<String, Object> payLoad = new HashMap<>();

    public static Map<String, Object> createSampleData() {
        // First component insertion
        // {"id" : 0}
        payLoad.put("id", 0);

        Map<String, Object> category = new HashMap<>();
        // Second component creation
        /* "category" : {
                "id" : 0,
                "name" : "string"
            }
        */
        category.put("id", 0);
        category.put("name", "string");

        // Second component insertion
        payLoad.put("category", category);

        // Third component insertion
        payLoad.put("name", "doggie");

        // Fourth component
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("string");

        // Fourth component insertion
        payLoad.put("photoUrls", photoUrls);

        // Fifth component
        List<Map<String, Object>> tags = new ArrayList<>();
        Map<String, Object> tag1 = new HashMap<>();
        tag1.put("id", 0);
        tag1.put("name", "string");
        tags.add(tag1);

        // Fifth component insertion
        payLoad.put("tags", tags);

        // Sixth component insertion
        payLoad.put("status", "available");

        return payLoad;
    }

    /** Generates and sends the payload needed for POST request
     * @params No parameters
     * @return Map object consisting of payload required for POST request
     */
    public static Map<String, Object> sendDataPayloadforPostRequest() {
        return createSampleData();
    }

    /**
     *
     * Generates and sends the payload needed for PUT request
     * @params No parameters
     * @return Map object representing the payload for PUT request
     *
     */
    public static Map<String, Object> sendDataPayloadforGetRequest() {
        return createSampleData();
    }
}
