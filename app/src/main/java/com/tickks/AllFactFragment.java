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


/**
 * A simple {@link Fragment} subclass.
 */
public class AllFactFragment extends Fragment {


  private FactFactory factFactory = new FactFactory();

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

    FloatingActionButton button = view.findViewById(R.id.fab);

    ListView listView = view.findViewById(R.id.list_view);

    String[] facts = factFactory.faktet;

   /* ArrayAdapter<String> adapter =
        new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, facts);

*/
    /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      Toast.makeText(AllFactActivity.this, "You have selected item: " + position, Toast.LENGTH_SHORT).show();
    }
  });*/

    FactAdapter ourAdapter = new FactAdapter(getActivity(), facts);

    listView.setAdapter(ourAdapter);

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();
        getFragmentManager()
            .beginTransaction()
            .replace(R.id.main_layout,new AddFact(), "ADD_NEW")
            .commit();
      }
    });


  }
}
