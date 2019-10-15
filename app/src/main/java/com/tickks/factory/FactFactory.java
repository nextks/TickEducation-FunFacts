package com.tickks.factory;

import android.content.Context;
import android.content.SharedPreferences;

import com.tickks.data.Database;
import com.tickks.data.Fact;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class FactFactory {

  private Context context;
  public static final String FILE_NAME = "ALL_FACTS";
  public static final String KEY = "FACTS";

  private String[] faktet = {"Domatja eshte frut", "Kemi 50% ngjajshmeri me bananen", "Uji nuk e ndale zjarrin",
      "Bletat mujn me flutur me lart se Mali Everest", "Bebet kane 100 eshtra me shume se te rriturit", "Domatja eshte frut", "Kemi 50% ngjajshmeri me bananen", "Uji nuk e ndale zjarrin",
      "Bletat mujn me flutur me lart se Mali Everest", "Bebet kane 100 eshtra me shume se te rriturit", "Domatja eshte frut", "Kemi 50% ngjajshmeri me bananen", "Uji nuk e ndale zjarrin",
      "Bletat mujn me flutur me lart se Mali Everest", "Bebet kane 100 eshtra me shume se te rriturit"};


  private static ArrayList<String> newFaktet;
  private final SharedPreferences sharedPreferences;
  private final Database database;


  public FactFactory(Context context) {
    this.context = context;

    sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);

    Set<String> savedFacts = sharedPreferences.getStringSet(KEY, null);

    if (savedFacts == null || savedFacts.size() == 0) {
      sharedPreferences
          .edit()
          .putStringSet(KEY, getFactsAsSet(faktet))
          .apply();
    }
    savedFacts = sharedPreferences.getStringSet(KEY, null);


    database = Database.getDatabase(context);


    List<Fact> facts = database.factDao().getFacts();

    if (facts.size() == 0) {
      List<Fact> factList = new ArrayList<>();

      for (String savedFact : savedFacts) {
        Fact fact = new Fact();
        fact.setText(savedFact);
        factList.add(fact);
      }

      database.factDao().saveAllFact(factList);

      facts = database.factDao().getFacts();
    }


    newFaktet = getFactAsStrings(facts);

   /* if (newFaktet.size() == 0) {
      for (String fact : faktet) {
        newFaktet.add(fact);
      }
    }*/
  }

  private ArrayList<String> getFactsAsArrayList(Set<String> savedFacts) {
    ArrayList<String> facts = new ArrayList<>();
    for (String fact : savedFacts) {
      facts.add(fact);
    }
    return facts;
  }

  private Set<String> getFactsAsSet(String[] newFaktet) {
    Set<String> set = new HashSet<>();
    for (int i = 0; i < newFaktet.length; i++) {
      set.add(newFaktet[i]);
    }
    return set;
  }

  public ArrayList<String> getFacts() {
    List<Fact> facts = database.factDao().getFacts();
    newFaktet = getFactAsStrings(facts);

    return newFaktet;
  }

  private ArrayList<String> getFactAsStrings(List<Fact> facts) {
    ArrayList<String> stringFacts = new ArrayList<>();
    for (Fact fact : facts) {
      stringFacts.add(fact.getText());
    }
    return stringFacts;
  }

  public String getFact() {
    Random r = new Random();
    int random = r.nextInt(getFacts().size());
    String randomFact = getFacts().get(random);

    return randomFact;
  }

  public void addFact(String newFact) {
    /*Set<String> stringSet = sharedPreferences.getStringSet(KEY, null);
    stringSet.add(newFact);
    sharedPreferences.edit().clear().apply();
    sharedPreferences.edit().putStringSet(KEY, stringSet).apply();
    newFaktet = getFactsAsArrayList(stringSet);*/

    database.factDao().saveFact(new Fact(newFact));


  }

  public void delete(String factToDelete) {
    /*Set<String> stringSet = sharedPreferences.getStringSet(KEY, null);
    sharedPreferences.edit().clear().apply();
    for (String fact : stringSet) {
      if (fact.equals(factToDelete)) {
        stringSet.remove(fact);
        break;
      }
    }
    sharedPreferences.edit().putStringSet(KEY, stringSet).apply();*/

    List<Fact> facts = database.factDao().getFacts();

    for (Fact fact : facts) {
      if (factToDelete.equals(fact.getText())) {
        database.factDao().deleteFact(fact);
        break;
      }
    }


  }

  //CRUD
  // CREATE / INSERT
  // Read / Get All
  // Update / update
  // Delete / Delete


  public void updateFact(String oldFact, String newFact) {
   /* Set<String> stringSet = sharedPreferences.getStringSet(KEY, null);
    sharedPreferences.edit().clear().apply();

    for (String fact : stringSet) {
      if (fact.equals(oldFact)) {
        stringSet.remove(fact);
        stringSet.add(newFact);
        break;
      }
    }
    sharedPreferences.edit().putStringSet(KEY, stringSet).apply();*/


    List<Fact> facts = database.factDao().getFacts();

    for (Fact fact : facts) {
      if (oldFact.equals(fact.getText())) {
        fact.setText(newFact);
        database.factDao().updateFact(fact);
        break;
      }
    }

  }
}
