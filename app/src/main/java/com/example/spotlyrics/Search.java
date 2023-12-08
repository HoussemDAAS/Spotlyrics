package com.example.spotlyrics;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.SongAdapter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Search extends AppCompatActivity {

    EditText editTextQuery;
    Button searchButton;
    GridView gridViewResults;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editTextQuery = findViewById(R.id.editTextQuery);
        searchButton = findViewById(R.id.buttonSearch);
        gridViewResults = findViewById(R.id.gridViewResults);

        searchButton.setOnClickListener(v -> {
            String query = editTextQuery.getText().toString().trim();
            if (!query.isEmpty()) {
                searchMusic(query);
            }
        });
    }

    private void searchMusic(String query) {
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... params) {
                OkHttpClient client = new OkHttpClient();
                String url = "https://deezerdevs-deezer.p.rapidapi.com/search?q=" + params[0];

                Request request = new Request.Builder()
                        .url(url)
                        .get()
                        .addHeader("X-RapidAPI-Key","300e89e6bfmshb2e539c85630cafp11d800jsn9a1e42aa2704")
                        .addHeader("X-RapidAPI-Host", "deezerdevs-deezer.p.rapidapi.com")
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    return response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(String result) {
                if (result != null && !result.isEmpty()) {
                    displayResult(result);
                } else {
                    Toast.makeText(Search.this, R.string.error_retrieving_data, Toast.LENGTH_SHORT).show();
                }
            }
        }.execute(query);
    }

    private void displayResult(String jsonData) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray dataArray = jsonObject.getJSONArray("data");
            List<Song> songs = new ArrayList<>();

            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject songObject = dataArray.getJSONObject(i);
                String title = songObject.getString("title");
                String imageUrl = songObject.getJSONObject("album").getString("cover");
                songs.add(new Song(title, imageUrl));
            }

            SongAdapter adapter = new SongAdapter(this, songs);
            gridViewResults.setAdapter(adapter);

        } catch (JSONException e) {
            Toast.makeText(this, R.string.error_parsing_response, Toast.LENGTH_LONG).show();
        }
    }
}