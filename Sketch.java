import processing.core.PApplet;
import java.util.Random;

public class Sketch extends PApplet {
	
  
  public void settings() {
    size(600, 600);
  }

  public void setup() {
    background(192, 233, 250);
  }

  public void draw() {
    //Changes background colour 
    int backgroundColour = readColour();
    noStroke(); 
    fill(backgroundColour);
    rect(0, 0, 600, 600);

    // Draws the smiling faces 
    for(float valueY = 120; valueY < 600; valueY += 170){ 
      for(float valueX = 85; valueX < 500; valueX += 100){
        smile(valueX, valueY);
      }
    }

    // Draw the flowers 
    for(float fishY = 40; fishY <600; fishY +=170){
      for(float fishX = 120; fishX < 550; fishX += 130){ 

        Random ranColour1 = new Random(); 
        int intRanColour1 = ranColour1.nextInt(256); 

        Random ranColour2 = new Random();
        int intRanColour2 = ranColour2.nextInt(256);

        Random ranColour3 = new Random();
        int intRanColour3 = ranColour3.nextInt(256);

        fish(fishX, fishY, intRanColour1, intRanColour2, intRanColour3); 
      }
    }
    
    // Adds delay when colour switches after 
    try {
      Thread.sleep(700);
    } catch (InterruptedException e){
      e.printStackTrace();
    }
  }

  // Level 2
  /**
   * Draws smiles
   * @author T. Wong
   * @param smileX sets the X value of the smile
   * @param smileY sets the Y value of the smile
   */

  public void smile(float smileX, float smileY){
    stroke(0, 0, 0);
    fill(0, 0, 0);
    ellipse(smileX, smileY, 10, 10);
    ellipse(smileX + 50, smileY, 10, 10);
    arc(smileX + 25, smileY + 15, 40, 50, 0, ((float) 3.14));
  }

  // Level 3 
  /**
    * Draws fishes 
    * @author T.Wong
    * @param fishX sets the X value of the fish
    * @param fishY sets the Y value of the fish
    * @param colourR gets a random value for R in RGB
    * @param colourG gets a random value for G in RGB
    * @param colourB gets a random value for B in RGB
    */

  public void fish(float fishX, float fishY, float colourR, float colourG, float colourB){
    noStroke();

    //tail
    fill(colourR, colourG, colourB); 
    triangle(fishX + 10, fishY, fishX - 45, fishY - 35, fishX - 45, fishY + 35); 

    //body of the fish
    fill(247, 235, 178);
    ellipse(fishX, fishY, 50, 50); 

    //fins
    fill(colourR, colourG, colourB); 
    beginShape(); 
    vertex(fishX - 5, fishY);
    vertex(fishX - 15, fishY);
    vertex(fishX - 10, fishY + 30);
    vertex(fishX, fishY + 20);
    endShape(CLOSE);

    //eye of the fish 
    fill(0,5,5); 
    ellipse(fishX + 8, fishY - 5, 8, 8); 
  }


  // Level 4
  /**
   * Gets the X and Y of the mouse
   * @author T. Wong
   * @return the X and Y location of the mouse
   */

  public int readColour(){
    return get(mouseX, mouseY);
  }
}