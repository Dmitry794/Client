package my.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Client {

    public static void main(String[] args) {

        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("http://192.168.100.4:8080/server/info");
        RequestConfig config = RequestConfig.custom()
                .setSocketTimeout(1200)
                .build();
       // post.setConfig(config);


        try {
            System.out.println("Send...");
            HttpResponse response = httpClient.execute(post);
            System.out.println("Status Code: "+response.getStatusLine().getStatusCode());
            System.out.println(response.getStatusLine().getReasonPhrase());

            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


    }
}
