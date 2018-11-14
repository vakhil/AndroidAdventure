package com.example.akhil.newsgetter;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    RecyclerView mRecyclerView;
    ProgressBar mProgressBar;
    TextView textView;
    Button button;
    ImageView mImageVIew;

    String rawHTMLtextData;
    ArrayList<SingleItem> newsItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  mImageVIew = (ImageView) findViewById(R.id.image_view);
       // mProgressBar = (ProgressBar) findViewById(R.id.tv_progress);

        mRecyclerView = (RecyclerView) findViewById(R.id.tv_recycle);

        button = (Button) findViewById(R.id.tv_button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                button.setVisibility(View.INVISIBLE);
               // new FetchNDTVHtml().execute(NetworkUtils.getNewsSource());
                FetchNDTVHtml(NetworkUtils.getNewsSource());

            }
        });


    }

    private void initalizeRecyclerView()
    {
      // mProgressBar.setVisibility(View.INVISIBLE);
         button.setVisibility(View.INVISIBLE);
       // mImageVIew.setVisibility(View.VISIBLE);
        RecyclerAdapter adapter = new RecyclerAdapter(newsItemList, MainActivity.this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
    private void FetchNDTVHtml(final String location) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //mProgressBar.setVisibility(View.VISIBLE);
                try {
                    Document doc = Jsoup.connect(location).get();
                    Elements links = doc.getElementsByClass("thumbnail");
                    int i = 0;
                    for (Element link : links) {

                        if(i == 5)
                            break;
                        //Create a SingleItem object and add to Final ArrayList
                        SingleItem singleNewsStory = new SingleItem();
                        List<Node> childElements = link.childNodes();
                        singleNewsStory.hyperLink = childElements.get(0).attr("href");
                        singleNewsStory.mImageHyperLink = childElements.get(0).childNodes().get(0).childNodes().get(0).attr("srcset");
                        singleNewsStory.storyTitle = childElements.get(0).childNodes().get(0).childNodes().get(1).attr("alt");

                        newsItemList.add(singleNewsStory);
                        i++;
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            initalizeRecyclerView();
                        }
                    });

                } catch (Exception ex) {
                    ex.printStackTrace();
                }


            }
        }).start();
    }

    /*
    public class FetchNDTVHtml extends AsyncTask<String,Void,String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... urls) {
            if(urls.length == 0)
                return null;

            String location = urls[0];
            try
            {
                Document doc = Jsoup.connect(location).get();
                Elements links = doc.getElementsByClass("thumbnail");

                for (Element link : links)
                {
                    //Create a SingleItem object and add to Final ArrayList
                    SingleItem singleNewsStory = new SingleItem();
                    List<DataNode> childElements = link.dataNodes();
                    Log.d(TAG, String.valueOf(link.childNodeSize()) );
                    for(DataNode node: childElements)
                    {

                        if( node.attr("href") != "")
                        {
                            singleNewsStory.hyperLink = node.attr("href");
                        }
                        if(node.attr("srcset") != "")
                        {
                            singleNewsStory.mImageHyperLink = node.attr("srcset");
                        }
                        if(node.attr("alt") != "")
                        {
                            singleNewsStory.mImageHyperLink = node.attr("alt");
                        }
                    }

                    newsItemList.add(singleNewsStory);
                }
            }
            catch (Exception ex)
            {

            }
            /*
            URL newsSourceURL = NetworkUtils.buildUrl(location);
            try {
                String httpDataNDTV = NetworkUtils.getResponseFromHttpUrl(newsSourceURL);
                Log.d(TAG,"String has returned");
                return httpDataNDTV;
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            button.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.VISIBLE);
            textView.setText(s);
            rawHTMLtextData = s;
            mProgressBar.setVisibility(View.INVISIBLE);
        }
    }
*/

}
