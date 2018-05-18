package uk.co.onemandan.recyclerview.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import uk.co.onemandan.recyclerview.Adapters.RecyclerViewAdapter;
import uk.co.onemandan.recyclerview.Classes.RecyclerViewItem;
import uk.co.onemandan.recyclerview.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView _recyclerView;
    private Button _btnAdd, _btnRemove;
    private List<RecyclerViewItem> _recyclerViewItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get RecyclerView handle
        _recyclerView   = findViewById(R.id.rv_list);
        _btnAdd         = findViewById(R.id.btn_add);
        _btnRemove      = findViewById(R.id.btn_remove);

        //Save performance if you know the recycler view layout size is static
        _recyclerView.setHasFixedSize(true);

        //Set RecyclerView layout manager
        _recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Set RecyclerView adapter
        _recyclerView.setAdapter(new RecyclerViewAdapter(_recyclerViewItems));

        //Set Animator
        _recyclerView.setItemAnimator(new DefaultItemAnimator());

        //Button click handlers
        _btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _recyclerViewItems.add(0, new RecyclerViewItem(getString(R.string.item_title),
                        getString(R.string.item_subtitle)));
                _recyclerView.getAdapter().notifyItemInserted(0);
            }
        });
        _btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_recyclerViewItems.size() > 0){
                    _recyclerViewItems.remove(0);
                    _recyclerView.getAdapter().notifyItemRemoved(0);
                }
            }
        });
    }
}
