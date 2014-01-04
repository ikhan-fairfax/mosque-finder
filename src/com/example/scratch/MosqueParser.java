package com.example.scratch;

import android.util.Log;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.gson.Gson;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static com.google.common.base.Optional.*;
import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by imrank on 4/01/2014.
 */
public class MosqueParser {
    private final List<String> mosqueList = newArrayList(
            "Algester Mosque",
            "Bundeberg Mosque",
            "Capalaba Mosque",
            "Cairns Mosque",
            "Darra Mosque",
            "Darul Uloom Academy",
            "Dreamworld Musalla",
            "Eagleby Mosque",
            "Gladstone Musallah",
            "Gold Coast Mosque",
            "Harbour Town Musalla",
            "Hervey Bay Jummah Salaah",
            "Holland Park Mosque",
            "Ipswich Mosque",
            "Kuraby Mosque - Masjid Al Farooq",
            "Logan City Mosque",
            "Lutwyche Mosque",
            "Mackay Mosque",
            "Mackay Mosque",
            "Masjid Taqwa",
            "MSA Griffith Musalla",
            "MSA St Lucia Musalla",
            "Muslims Organisation Sunshine Coast (MoSC) - Mosque"
    );

    public MosqueResponse parse(InputStream inputStream) {
        Gson gson = new Gson();
        InputStream httpInputStream = fromNullable(inputStream).or(new ByteArrayInputStream("{}".getBytes()));
        return gson.fromJson(new InputStreamReader(httpInputStream), MosqueResponse.class);
    }
}
