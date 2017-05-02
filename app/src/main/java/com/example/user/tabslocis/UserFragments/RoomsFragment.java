package com.example.user.tabslocis.UserFragments;

import android.os.Bundle;
import android.support.test.InstrumentationRegistry;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.support.annotation.RequiresApi;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.user.tabslocis.Adapters.RoomsAdapter;
import com.example.user.tabslocis.Api.RoomsViewTask;
import com.example.user.tabslocis.Items.ItemRoom;
import com.example.user.tabslocis.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 18.04.2017.
 */

public class RoomsFragment extends Fragment {
    String token;
    Button createRoomButton;
    Button invitesButton;
    ArrayList<ItemRoom> roomsList;
    ArrayAdapter adapter;
    ListView listView;
    EditText createRoomET;
    public String response;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      // final RoomsViewTask api = new RoomsViewTask(token);
       //api.execute();
       // new RoomsViewTask(token).execute();
        View rootView = inflater.inflate(R.layout.rooms_tab, container, false);
        listView = (ListView) rootView.findViewById(R.id.lv_rooms);
        initListView(roomsList);


        return rootView;
    }
    private void initListView(List<ItemRoom> rooms){
        roomsList = new ArrayList<>();
        //roomsList.addAll(rooms);
        roomsList.add(new ItemRoom("Room huy"));
        roomsList.add(new ItemRoom("Room xyu"));
        roomsList.add(new ItemRoom("Room hui"));
        roomsList.add(new ItemRoom("Room хуй"));
        roomsList.add(new ItemRoom("Room huй"));



        RoomsAdapter roomsAdapter = new RoomsAdapter(getActivity(),0,roomsList,token);
        listView.setAdapter(roomsAdapter);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

    }
    public void onJSONParsed(List<ItemRoom> rooms) {
        initListView(rooms);
    }


}
