package com.tickks.factory;

import java.util.Random;

public class ColorFactory {

  private String[] colors = {"#39add1", "#3079ab", "#c25975",
      "#e15258", "#f9845b", "#838cc7", "#7d669e", "#53bbb4", "#51b46d", "#e0ab18",
      "#637a91", "#f092b0"
  };

  public String[] getColors() {
    return colors;
  }

  public String getColor() {
    Random r = new Random();
    int random = r.nextInt(colors.length);
    return colors[random];

  }
}
