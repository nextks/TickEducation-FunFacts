package com.tickks;


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


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFactFragment extends Fragment {

  FactFactory factFactory;


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_update_fact, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    factFactory = new FactFactory(getContext());

    String fact = getArguments().getString("FACT");

    Toast.makeText(getActivity(), fact, Toast.LENGTH_SHORT).show();

    Button updateButton = view.findViewById(R.id.update_button);
    EditText factText = view.findViewById(R.id.fact_text);
    Button cancelButton = view.findViewById(R.id.cancel_button);

    updateButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        factFactory.updateFact(fact,factText.getText().toString());
        getActivity().onBackPressed();
      }
    });

    cancelButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        getActivity().onBackPressed();
      }
    });

    factText.setText(fact);


  }
}
