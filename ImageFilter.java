import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  
  /** Constructor */
public ImageFilter(String fileName) {
  super(fileName);
}

/*
 shifts color of each pixel in the given image by a inputted value by adding it to the current value of each RGB in the 
 pixel, and then sets the new RGB values to the pixel using 2D array iteration
*/
public void colorShift(int value) {

  Pixel[][] pixels = getPixelsFromImage();

  for (int row = 0; row < pixels.length; row++) {
    for (int col = 0; col < pixels[0].length; col++) {
      Pixel currentPixel = pixels[row][col];

      int currentRed = currentPixel.getRed();
      int currentGreen = currentPixel.getGreen();
      int currentBlue = currentPixel.getBlue();

      //adds a value to each of the current RGB values to shift the colors proportionally
      int newRed = currentRed + value;
      int newGreen = currentGreen + value;
      int newBlue = currentBlue + value;

      currentPixel.setRed(newRed);
      currentPixel.setGreen(newGreen);
      currentPixel.setBlue(newBlue);
    }
  }
}

  /*
  applies a brown tint to the image by multiplying each current RGB value by a number that makes the color more
  muted and warm colored, then returns those updates RGB values to the pixels using the 2D array iteration
  */
 public void applySepia() {
   Pixel[][] pixels = getPixelsFromImage();

  for (int row = 0; row < pixels.length; row++) {
    for (int col = 0; col < pixels[0].length; col++) {
      Pixel currentPixel = pixels[row][col];

      int currentRed = currentPixel.getRed();
      int currentGreen = currentPixel.getGreen();
      int currentBlue = currentPixel.getBlue();

      //multiplies each RGB value by a value that makes each pixel more warm toned
      int newRed = (int)((0.393 * currentRed) + (0.769 * currentGreen) + (0.189 * currentBlue)); 
      int newGreen = (int)((0.349 * currentRed) + (0.686 * currentGreen) + (0.168 * currentBlue));
      int newBlue = (int)((0.272 * currentRed) + (0.534 * currentGreen) + (0.131 * currentBlue));

      currentPixel.setRed(newRed);
      currentPixel.setGreen(newGreen);
      currentPixel.setBlue(newBlue);
    }
  }
}

  /*
  creates a motion blur affect to the given image by calculating the average RGB value of the current pixel and
  its neighboring pixel in a line segment given a length. and then, applies the inputted direction to see if the
  average colors will be applied vertically or horizontally to give the blur effect
  */
public void motionBlur(int length, String direction) {
  
     Pixel[][] pixels = getImagePixels();   
  
  for (int row = 0; row < pixels.length; row++) {
    for (int col = 0; col < pixels[0].length; col++) {
      Pixel currentPixel = pixels[row][col];
  
      int redSum = 0;
      int greenSum = 0;
      int blueSum = 0;
      int count = 0;
  
      for (int i = 0; i < length; i++) {
        int r = row;
        int c = col;
  
        if (direction.equals("horizontal")) { //determines the direction of the blur based on the direction input
          c = col + i;
        } else if (direction.equals("vertical")) {
          r = row + i;
        }
  
        if (r < pixels.length && c < pixels[0].length) { //adds sum of each RGB value to the neighboring pixel
          Pixel neighbor = pixels[r][c]; 
          redSum += neighbor.getRed();
          greenSum += neighbor.getGreen();
          blueSum += neighbor.getBlue();
          count++;
        }
      }
  
      currentPixel.setRed(redSum/count);
      currentPixel.setGreen(greenSum/count);
      currentPixel.setBlue(blueSum/count);
    }
  }
  
}


  /*
  changes image into a 3-color version of each of the RGB values based on the brightness of each pixel. based on
  the brightness of each pixel, it is assigned either, red, blue, or green
  */
 public void colorize() {

  Pixel[][] pixels = getPixelsFromImage();

   for (int row = 0; row < pixels.length; row++) {
    for (int col = 0; col < pixels[0].length; col++) {
      Pixel currentPixel = pixels[row][col];

    int currentRed = currentPixel.getRed();
    int currentGreen = currentPixel.getGreen();
    int currentBlue = currentPixel.getBlue();

    int pixelColorAverage = (currentRed + currentGreen + currentBlue) / 3; //finds average of the current RGB values
     
     if (pixelColorAverage < 85) {
      currentPixel.setRed(255);
      currentPixel.setGreen(0);
      currentPixel.setBlue(0);
    }
    else if (pixelColorAverage < 170) {
      currentPixel.setRed(0);
      currentPixel.setGreen(255);
      currentPixel.setBlue(0);
    }
    else {
      currentPixel.setRed(0);
      currentPixel.setGreen(0);
      currentPixel.setBlue(255);
    }

    }
  }
}

  /*
  gives image a green tint, the tint becomes more green based on the inputted intensity of the color. it does this by 
  adding more to the green value of each pixel, based on the inputted intensity
  */
public void greenTint(int intensity) {
  Pixel[][] pixels = getPixelsFromImage();

  for (int r = 0; r < pixels.length; r++) {
    for (int c = 0; c < pixels[r].length; c++) {
      Pixel p = pixels[r][c];

      int newGreen = p.getGreen() + intensity;
      if (newGreen > 255){ //makes sure that it doesn't go out of bounds
        newGreen = 255; 
      }
      p.setGreen(newGreen);
    }
  }
}

}