package com.tickks;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllFactFragment extends Fragment {


  private FactFactory factFactory;
  private FactAdapter ourAdapter;

  public AllFactFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_all_fact, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    factFactory = new FactFactory(getContext().getApplicationContext());

    FloatingActionButton button = view.findViewById(R.id.fab);

    ListView listView = view.findViewById(R.id.list_view);

    ArrayList<String> facts = factFactory.getFacts();

   /* ArrayAdapter<String> adapter =
        new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, facts);

*/
    /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      Toast.makeText(AllFactActivity.this, "You have selected item: " + position, Toast.LENGTH_SHORT).show();
    }
  });*/

    ourAdapter = new FactAdapter(getActivity(), facts);

    listView.setAdapter(ourAdapter);

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();
        getFragmentManager()
            .beginTransaction()
            .replace(R.id.main_layout, new AddFact(), "ADD_NEW")
            .addToBackStack(null)
            .commit();
      }
    });

    ourAdapter.notifyDataSetChanged();


  }


  @Override
  public void onResume() {
    super.onResume();
    ourAdapter.notifyDataSetChanged();
  }
}
