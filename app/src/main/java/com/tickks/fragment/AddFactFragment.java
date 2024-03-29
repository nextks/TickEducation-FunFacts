package com.tickks.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tickks.R;
import com.tickks.factory.FactFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFactFragment extends Fragment {

  public AddFactFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_add_fact, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    EditText addFactText = view.findViewById(R.id.fact_text);
    Button cancelButton = view.findViewById(R.id.cancel_button);
    Button addButton = view.findViewById(R.id.update_button);

    cancelButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        getActivity().onBackPressed();
      }
    });

    addButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String newFact = addFactText.getText().toString();

        if (validate(newFact)) {
          addFact(newFact);
        } else {
          addFactText.setError("The fact should have more then 5 characters");
        }
      }
    });

  }

  private boolean validate(String newFact) {
    Toast.makeText(getActivity(), newFact, Toast.LENGTH_SHORT).show();
    newFact = newFact.trim();
    if (newFact.length() < 5) {
      return false;
    }
    return true;

  }

  private void addFact(String newFact) {
    FactFactory factory = new FactFactory(getContext());
    factory.addFact(newFact);
    getActivity().onBackPressed();
  }
}
