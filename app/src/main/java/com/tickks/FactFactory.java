package com.tickks;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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


    newFaktet = getFactsAsArrayList(savedFacts);

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
    Set<String> savedFacts = sharedPreferences.getStringSet(KEY, null);


    newFaktet = getFactsAsArrayList(savedFacts);

    return newFaktet;
  }

  public String getFact() {
    Random r = new Random();
    int random = r.nextInt(getFacts().size());
    String randomFact = getFacts().get(random);

    return randomFact;
  }

  public void addFact(String newFact) {
    Set<String> stringSet = sharedPreferences.getStringSet(KEY, null);
    stringSet.add(newFact);
    sharedPreferences.edit().clear().apply();
    sharedPreferences.edit().putStringSet(KEY, stringSet).apply();
    newFaktet = getFactsAsArrayList(stringSet);
  }

  public void delete(String factToDelete) {
    Set<String> stringSet = sharedPreferences.getStringSet(KEY, null);
    sharedPreferences.edit().clear().apply();
    for (String fact : stringSet) {
      if (fact.equals(factToDelete)) {
        stringSet.remove(fact);
        break;
      }
    }
    sharedPreferences.edit().putStringSet(KEY, stringSet).apply();

  }
}
