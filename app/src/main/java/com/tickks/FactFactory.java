package com.tickks;

import java.util.ArrayList;
import java.util.Random;

public class FactFactory {

  private String[] faktet = {"Domatja eshte frut", "Kemi 50% ngjajshmeri me bananen", "Uji nuk e ndale zjarrin",
      "Bletat mujn me flutur me lart se Mali Everest", "Bebet kane 100 eshtra me shume se te rriturit", "Domatja eshte frut", "Kemi 50% ngjajshmeri me bananen", "Uji nuk e ndale zjarrin",
      "Bletat mujn me flutur me lart se Mali Everest", "Bebet kane 100 eshtra me shume se te rriturit", "Domatja eshte frut", "Kemi 50% ngjajshmeri me bananen", "Uji nuk e ndale zjarrin",
      "Bletat mujn me flutur me lart se Mali Everest", "Bebet kane 100 eshtra me shume se te rriturit"};


  static ArrayList<String> newFaktet = new ArrayList<>();


  public FactFactory() {
    for (String fact : faktet) {
      newFaktet.add(fact);
    }
  }

  public ArrayList<String> getFacts() {
    return newFaktet;
  }

  public String getFact() {
    Random r = new Random();
    int random = r.nextInt(newFaktet.size());
    String randomFact = newFaktet.get(random);

    return randomFact;
  }

  public void addFact(String newFact) {
    newFaktet.add(newFact);
  }
}
