import org.code.theater.*;
import org.code.media.*;

public class Interest extends Scene {

  /** Instance Variables */
  
  private ImageFilter[][] images;
  private String[][] captions;
  
  
  /** Constructor */
  public Interest(ImageFilter[][] images, String[][] captions) {
    this.images = images;
    this.captions = captions;
  }

  /**
   * Top-level drawScene method which will draw the whole animation
   */
  public void drawScene() {
    drawInterests();
    endScreen();
  }

  /*
  - sets up the largest caption at the end of my personal narrative, divides it and returns the 2D array for the caption
  */
    public String[][] setUpBigCaption(){
    String[][] intro = {
      {"My favorite ", "sport "},
      {"is volleyball!", " "},
    };
    return intro;
  }

  /*
  - iterates through the 2D array for the long caption, returns the actual content of the array
  */
  public String introText(String[][] intro){
    String text = "";
    for(int r = 0; r < intro.length; r++){
      for(int c = 0; c < intro[0].length; c++){
        text+= intro[r][c];
      }
    }

    return text;
  }

  /*
  - draws the interests part of my personal narrative
  - adds filters to each of the images
  - clears screen after a pause after each image is generated
  */
  public void drawInterests(){
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    clear("olive");
    drawImage(images[2][0], 50, 10, 300);
    pause(1);
    images[2][0].colorize(); //added colorize filter
    drawImage(images[2][0], 50, 10, 300);
    pause(1);
     setFillColor("beige");
    drawRectangle(30, 290, 335, 70);
    setTextColor("brown");
    setTextHeight(30);
    drawText(captions[2][0], 40, 335);
    pause(1);

    pause(2); 

    clear("pink");
    drawImage(images[2][1], 50, 50, 300);
    pause(1);
    images[2][1].greenTint(50); //adds green tint filter (this is the one I made myself)
    drawImage(images[2][1], 50, 50, 300);
    pause(1);
    setFillColor("beige");
    drawRectangle(30, 290, 335, 70);
    setTextColor("brown");
    setTextHeight(23);
    String[][] information = setUpBigCaption(); //calls the method that iterates through the array for my large caption
    drawText(introText(information), 50, 335); //prints out the 2D array's content to formulate the caption smoothly
    pause(1);
  }

  /*
  - generates end screen for my personal narrative
  */
  public void endScreen(){
    clear("pink");
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextHeight(40);
    drawText("Thank You!", 100, 200);
  }

  
}