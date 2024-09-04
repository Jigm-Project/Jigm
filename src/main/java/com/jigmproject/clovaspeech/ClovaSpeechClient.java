package com.jigmproject.clovaspeech;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class ClovaSpeechClient {

    private final String secret;
    private final String invokeUrl;
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private final Gson gson = new Gson();

    private Header[] headers;

    public ClovaSpeechClient(String secret, String invokeUrl) {
        this.secret = secret;
        this.invokeUrl = invokeUrl;
        this.headers = new Header[] {
            new BasicHeader("Accept", "application/json"),
            new BasicHeader("X-CLOVASPEECH-API-KEY", this.secret),
        };
    }

    public static class NestRequestEntity {
        private String language = "ko-KR";
        private String completion = "sync";
        private Boolean wordAlignment = true;
        private Boolean fullText = true;
        private Boolean noiseFiltering = true;
        private Boolean resultToObs = false;
        private Diarization diarization = new Diarization();

        // getter, setter
        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getCompletion() {
            return completion;
        }

        public void setCompletion(String completion) {
            this.completion = completion;
        }

        public Boolean getWordAlignment() {
            return wordAlignment;
        }

        public void setWordAlignment(Boolean wordAlignment) {
            this.wordAlignment = wordAlignment;
        }

        public Boolean getFullText() {
            return fullText;
        }

        public void setFullText(Boolean fullText) {
            this.fullText = fullText;
        }

        public Boolean getNoiseFiltering() {
            return noiseFiltering;
        }

        public void setNoiseFiltering(Boolean noiseFiltering) {
            this.noiseFiltering = noiseFiltering;
        }

        public Boolean getResultToObs() {
            return resultToObs;
        }

        public void setResultToObs(Boolean resultToObs) {
            this.resultToObs = resultToObs;
        }

        public Diarization getDiarization() {
            return diarization;
        }

        public void setDiarization(Diarization diarization) {
            this.diarization = diarization;
        }
    }

    // 화자 구분을 위한 클래스 (필요에 따라 설정 가능)
    public static class Diarization {
        private Boolean enable = true;

        public Boolean getEnable() {
            return enable;
        }

        public void setEnable(Boolean enable) {
            this.enable = enable;
        }
    }

    /**
     * recognize media using URL
     * @param url required, the media URL
     * @param nestRequestEntity optional
     * @return string
     */
    public String url(String url, NestRequestEntity nestRequestEntity) {
        HttpPost httpPost = new HttpPost(invokeUrl + "/recognizer/url");
        httpPost.setHeaders(headers);
        Map<String, Object> body = new HashMap<>();
        body.put("url", url);
        body.put("language", nestRequestEntity.getLanguage());
        body.put("completion", nestRequestEntity.getCompletion());
        body.put("wordAlignment", nestRequestEntity.getWordAlignment());
        body.put("fullText", nestRequestEntity.getFullText());
        body.put("noiseFiltering", nestRequestEntity.getNoiseFiltering());
        body.put("resultToObs", nestRequestEntity.getResultToObs());
        body.put("diarization", nestRequestEntity.getDiarization());

        HttpEntity httpEntity = new StringEntity(gson.toJson(body), ContentType.APPLICATION_JSON);
        httpPost.setEntity(httpEntity);
        return execute(httpPost);
    }

    // 파일을 업로드하여 자막을 생성하는 메서드
    public String upload(File file, NestRequestEntity nestRequestEntity) {
        HttpPost httpPost = new HttpPost(invokeUrl + "/recognizer/upload");
        httpPost.setHeaders(headers);
        HttpEntity httpEntity = MultipartEntityBuilder.create()
            .addTextBody("params", gson.toJson(nestRequestEntity), ContentType.APPLICATION_JSON)
            .addBinaryBody("media", file, ContentType.MULTIPART_FORM_DATA, file.getName())
            .build();
        httpPost.setEntity(httpEntity);
        return execute(httpPost);
    }

    private String execute(HttpPost httpPost) {
        try (final CloseableHttpResponse httpResponse = httpClient.execute(httpPost)) {
            final HttpEntity entity = httpResponse.getEntity();
            return EntityUtils.toString(entity, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}