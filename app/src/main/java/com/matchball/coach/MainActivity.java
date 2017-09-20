package com.matchball.coach;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView playername;

    private TextView playername2;

    private TextView drillname;

    private TextView q1starttext;

    private Button q1start;

    private String name;

    private String drill;

    private ListView pl1;

    private ListView dl;

    private ImageView p1;

    private ImageView q1p2back;

    private ImageView drillback;

    private ImageView q1stop;

    private LinearLayout q1p1;

    private LinearLayout q1p2;

    private LinearLayout q1p3;

    private LinearLayout q1p4;

    private LinearLayout q1startpanel;

    private LinearLayout stopwatchpanel;

    private LinearLayout timerpanel;

    private List<String> players_list;

    private List<String> drills_list;

    private ArrayAdapter<String> playeradapter;

    private ArrayAdapter<String> drilladapter;

    String[] players = new String[]{
            "Amit Tandon",
            "Rishabh Singh",
            "Sorabh Pant",
            "Aman Sharma"
    };

    String[] drills = new String[]{
            "Deep drives from backhand",
            "Forehand drive from service box",
            "Backhand volley from short line",
            "Forehand mid-court volley drops",
            "Forehand boasts and drops",
            "Figure of 9",
            "Forehand sidewall zone 1",
            "Forehand sidewall zone 2",
            "Side to side volley",
            "Cross court switching drill",
            "Front corner ghosting",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playername = (TextView) findViewById(R.id.playername);

        playername2 = (TextView) findViewById(R.id.playername2);

        drillname = (TextView) findViewById(R.id.drillname);

        q1starttext = (TextView) findViewById(R.id.q1starttext);

        q1start = (Button) findViewById(R.id.q1start);

        drillback = (ImageView) findViewById(R.id.drillback);

        q1p1 = (LinearLayout) findViewById(R.id.q1p1);

        q1p2 = (LinearLayout) findViewById(R.id.q1p2);

        q1p3 = (LinearLayout) findViewById(R.id.q1p3);

        q1p4 = (LinearLayout) findViewById(R.id.q1p4);

        q1startpanel = (LinearLayout) findViewById(R.id.q1startpanel);

        stopwatchpanel = (LinearLayout) findViewById(R.id.stopwatchpanel);

        timerpanel = (LinearLayout) findViewById(R.id.timerpanel);

        q1p2back = (ImageView) findViewById(R.id.q1p2back);

        p1 = (ImageView) findViewById(R.id.p1);

        q1stop = (ImageView) findViewById(R.id.q1stop);

        pl1 = (ListView) findViewById(R.id.pl1);

        dl = (ListView) findViewById(R.id.dl);

        players_list = new ArrayList<String>(Arrays.asList(players));

        drills_list = new ArrayList<String>(Arrays.asList(drills));

        p1.setOnClickListener(this);

        q1p2back.setOnClickListener(this);

        drillback.setOnClickListener(this);

        q1start.setOnClickListener(this);

        q1stop.setOnClickListener(this);

    }


    private void initializePlayersAdapter() {

        playeradapter = new ArrayAdapter<String>(this, R.layout.listviewcenter, players_list) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View view = super.getView(position, convertView, parent);

                if (position % 2 == 1) {

                    view.setBackgroundColor(Color.parseColor("#282828"));

                } else {

                    view.setBackgroundColor(Color.parseColor("#303030"));

                }

                return view;
            }

        };

        pl1.setAdapter(playeradapter);

        getPlayer();

    }

    private void initializeDrillsAdapter() {

        drilladapter = new ArrayAdapter<String>(this, R.layout.listview, drills_list) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View view = super.getView(position, convertView, parent);

                if (position % 2 == 1) {

                    view.setBackgroundColor(Color.parseColor("#282828"));

                } else {

                    view.setBackgroundColor(Color.parseColor("#303030"));

                }

                return view;
            }

        };

        dl.setAdapter(drilladapter);

        getDrill();

    }


    private void getPlayer() {

        pl1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                q1p2.setVisibility(View.GONE);

                q1p3.setVisibility(View.VISIBLE);

                name = pl1.getItemAtPosition(position).toString();

                playername.setText(name);

                initializeDrillsAdapter();

            }

        });

    }


    private void getDrill() {

        dl.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                q1p3.setVisibility(View.GONE);

                q1p4.setVisibility(View.VISIBLE);

                drill = dl.getItemAtPosition(position).toString();

                playername2.setText(name);

                drillname.setText(drill);

                initializeDrillsAdapter();

            }

        });

    }


    @Override
    public void onClick(View view) {

        if (view == p1) {

            initializePlayersAdapter();

            q1p1.setVisibility(View.GONE);

            q1p2.setVisibility(View.VISIBLE);

        }


        else if (view == q1p2back) {

            q1p1.setVisibility(View.VISIBLE);

            q1p2.setVisibility(View.GONE);

        }

        else if (view == drillback) {

            q1p3.setVisibility(View.VISIBLE);

            q1p4.setVisibility(View.GONE);

        }

        else if (view == q1start) {

            q1starttext.setVisibility(View.GONE);

            q1startpanel.setVisibility(View.GONE);

            timerpanel.setVisibility(View.VISIBLE);

            stopwatchpanel.setVisibility(View.VISIBLE);

        }

        else if (view == q1stop) {


            
        }

    }


}
