package com.tickks;

import java.util.Random;

public class FactFactory {

  String[] faktet = {"Domatja eshte frut", "Kemi 50% ngjajshmeri me bananen", "Uji nuk e ndale zjarrin",
      "Bletat mujn me flutur me lart se Mali Everest","Bebet kane 100 eshtra me shume se te rriturit","Domatja eshte frut", "Kemi 50% ngjajshmeri me bananen", "Uji nuk e ndale zjarrin",
      "Bletat mujn me flutur me lart se Mali Everest","Bebet kane 100 eshtra me shume se te rriturit","Domatja eshte frut", "Kemi 50% ngjajshmeri me bananen", "Uji nuk e ndale zjarrin",
      "Bletat mujn me flutur me lart se Mali Everest","Bebet kane 100 eshtra me shume se te rriturit"};


  public String getFact(){
    Random r = new Random();
    int random = r.nextInt(faktet.length);
    String randomFact = faktet[random];

    return randomFact;
  }
}
