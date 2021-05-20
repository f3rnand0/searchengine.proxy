package com.task.searchengine.proxy.controler;

import com.task.searchengine.proxy.entity.Search;
import com.task.searchengine.proxy.entity.SearchQueries;
import com.task.searchengine.proxy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    SearchRepository searchRepository;

    @Autowired
    SearchQueryRepository searchRepository;

    public Search search(String query) {
        String result = sendSearchGoogle(query);
        return new Search();
        //TODO transform String to list of Items entity
        //return new Search(new Item());
    }

    public List<SearchQueries> getAllSearches() {
        return searchRepository.findAll();
    }

    public List<User> getUsers() {

    }

    private static String sendSearchGoogle(String query) {
        HttpURLConnection con = null;
        StringBuffer content = null;
        try {
            URL url =
                    new URL("https://www.googleapis.com/customsearch/v1?key=AIzaSyCqvbAAiBeYjS8X37YH3" +
                            "-dQUO6Yp_Kj8A8&cx=054f1dca3a47e68e8&");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(getParamsString(query));
            out.flush();
            out.close();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.disconnect();
        }

        return content.toString();
    }

    private String getParamsString(String query)
            throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        result.append(URLEncoder.encode("q", "UTF-8"));
        result.append("=");
        result.append(URLEncoder.encode(query, "UTF-8"));

        String resultString = result.toString();
        return resultString.length() > 0
               ? resultString.substring(0, resultString.length() - 1)
               : resultString;
    }
}
