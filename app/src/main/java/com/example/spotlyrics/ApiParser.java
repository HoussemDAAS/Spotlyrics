package com.example.spotlyrics;

import org.json.JSONObject;
import java.util.Collections;

import model.Album;
import model.Artist;
import model.Music;

import org.json.JSONObject;
import org.json.JSONException;

public class ApiParser {

    public Music parseMusic(String jsonData) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);

            // Parse the fields you're interested in
            long id = jsonObject.getLong("id");
            String title = jsonObject.getString("title");
            String titleShort = jsonObject.getString("title_short");
            String md5Image = jsonObject.getString("md5_image");

            // Pass 'null' for the artist and album fields since they are not being used currently
            return new Music(id, title, titleShort, md5Image, null, null);
        } catch (JSONException e) {
            e.printStackTrace();
            // Handle the JSONException
            return null;
        }
    }
}