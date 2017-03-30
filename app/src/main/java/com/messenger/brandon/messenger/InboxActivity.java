package com.messenger.brandon.messenger;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class InboxActivity extends Activity {

    private RecyclerView covos;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        populateConversations();
    }

    /**
     * Populate or repopulate the recycle view in the layout.
     */
    public void populateConversations(){
        //Initialize recycle view
        covos = (RecyclerView) findViewById(R.id.conversations);

        //Since the recycle view is not resizing during runtime, we can increase performance with this feature.
        covos.setHasFixedSize(true);

        //We want to list it linearly. Set up the layout manager. (Vertical)
        mLayoutManager = new LinearLayoutManager(this);
        covos.setLayoutManager(mLayoutManager);

        //Create an adapter to gra
        mAdapter = new MessageAdapter();
        covos.setAdapter(mAdapter);

    }
}
