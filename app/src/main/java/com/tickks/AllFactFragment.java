package com.tickks;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
  private ArrayList<String> facts;

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

    factFactory = new FactFactory(getContext());

    FloatingActionButton button = view.findViewById(R.id.fab);

    ListView listView = view.findViewById(R.id.list_view);

    facts = factFactory.getFacts();

   /* ArrayAdapter<String> adapter =
        new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, facts);

*/

    ourAdapter = new FactAdapter(getActivity(), facts);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "You have selected item: " + position, Toast.LENGTH_SHORT).show();
      }
    });


    listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
      @Override
      public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String fact = facts.get(position);
        Toast.makeText(getActivity(), fact + position, Toast.LENGTH_SHORT).show();
        areYouSureForDelete(fact);

        return false;
      }
    });


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

  private void areYouSureForDelete(String fact) {
    AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
    alert
        .setTitle("Delete fact!")
        .setMessage("Are you sure you want to delete this fact")
        .setNegativeButton("No", null)
        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            deleteFact(fact);
          }
        });

    alert.show();


  }

  private void deleteFact(String fact) {
    factFactory.delete(fact);
    getLatestData();
    ourAdapter.notifyDataSetChanged();
  }

  private void getLatestData() {
    facts = factFactory.getFacts();
    ourAdapter.list = facts;
  }


  @Override
  public void onResume() {
    super.onResume();
    ourAdapter.notifyDataSetChanged();
  }
}
