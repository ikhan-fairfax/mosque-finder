package com.example.scratch;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import static com.google.common.base.Optional.fromNullable;
import static com.google.common.collect.FluentIterable.from;
import static java.util.Arrays.asList;

/**
 * Created by imrank on 4/01/2014.
 */
public class GetMosquesTask extends AsyncTask<String, Void, List<Mosque>> {
    private Activity context;

    public GetMosquesTask(Activity context) {
        this.context = context;
    }

    @Override
    protected List<Mosque> doInBackground(String... urls) {
        List<Mosque> result = Lists.newArrayList();
        Optional<String> first = from(asList(urls)).first();
        if (first.isPresent()) {
            String urlString = first.get();
            Log.i(getClass().getName(), "Sending request to " + urlString);
            InputStream inputStream = getResponse(urlString);
            MosqueResponse response = new MosqueParser().parse(inputStream);
            result = fromNullable(response.getMosques()).or(Lists.<Mosque>newArrayList());
        }
        return result;
    }


    /* uses HttpURLConnection to make Http request from Android to download
         the XML file */
    private InputStream getResponse(String urlString) {
        InputStream result = null;
        try {
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpResponse response = defaultHttpClient.execute(new HttpGet(urlString));

            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                result = response.getEntity().getContent();
            } else {
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (Exception ex) {
            Log.e(getClass().getName(), "Failed to get response.", ex);
        }
        return result;
    }

    @Override
    protected void onPostExecute(List<Mosque> mosqueList) {
        ListView listView = (ListView) context.findViewById(R.id.listview);
        Collections.shuffle(mosqueList);
        listView.setAdapter(new CustomListViewAdapter(context, mosqueList));
    }
}
