package CallApi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CallApi_HttpConnection {
    private static HttpURLConnection connection;

    public static void main(String[] args) {
        String line;
        BufferedReader reader;
        StringBuffer responseContent = new StringBuffer();

        //httpUrlConnection
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/albums");
            connection = (HttpURLConnection) url.openConnection();

            //request setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    //System.out.println("resContend:"+responseContent);
                    // System.out.println(line);
                    responseContent.append(line);
                }
                reader.close();
            }
            System.out.println(responseContent);
            //System.out.println(responseContent.toString());

            parse(responseContent.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String parse(String responseBody) {
        JSONArray album = new JSONArray(responseBody);
        for (int i = 0;i< album.length(); i++) {
            JSONObject jsonObject= album.getJSONObject(i);
            int id= jsonObject.getInt("id");
            String title = jsonObject.getString("title");
            System.out.println(id + " "+title);
        }

        return null;
    }
}
