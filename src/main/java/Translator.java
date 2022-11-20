import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Translator {
    public static void main(String[] args) throws JsonProcessingException {

        System.out.println("Введите предложение на русском языке");
        Scanner scanner = new Scanner(System.in);
        String sentenceToTranslate = scanner.nextLine();

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://translate.api.cloud.yandex.net/translate/v2/translate";

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType((MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + "неведомая хуйня");

        Map<String, String> jsonData = new HashMap<>();
        jsonData.put("folderId", "shit");
        jsonData.put("shit", "shit");
        jsonData.put("texts", "[" + sentenceToTranslate + "]");

        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonData, headers);

//        String response = restTemplate.postForObject(url, request, String.class);

        //Parser with Jackson
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode obj = mapper.readTree(response);
//        System.out.println("Translate: " + obj.get("translations").get(0).get("text"));

        YandexResponse response = restTemplate.postForObject(url, request, YandexResponse.class);


        System.out.println("Translate: " + response.getTranslations().get(0).getText());


    }
}
