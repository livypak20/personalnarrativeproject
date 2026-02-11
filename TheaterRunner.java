import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // Create any 2D arrays & variables to be passed as parameters to constructor
     ImageFilter[][] images = {
      //culture
      { new ImageFilter("southkoreanflag.png"), new ImageFilter("hanbok.png") },
      //friends and family
      { new ImageFilter("IMG_8678-(1).jpg"), new ImageFilter("IMG_8472.jpg") },
      //interests 
      { new ImageFilter("throneofglass.jpg"), new ImageFilter("IMG_8478.jpg") },
    };

    //2D array used for captions that match the images in the other 2D array
    String[][] captions = {
      {"I am Korean!", "Our Traditional Clothing"},
      {"My sister and I", "My friends"},
      {"My Favorite Book Series", null},
    };

    
    
    // Instantiate Scene subclass objects
    CorePartsOfMe c = new CorePartsOfMe(images, captions);
    Interest i = new Interest(images, captions);
    
    // Call drawScene methods in each subclass
    c.drawScene();
     i.drawScene();
    
    // Play scenes in Theater, in order of arguments
    Theater.playScenes(c, i);
    
  }
}