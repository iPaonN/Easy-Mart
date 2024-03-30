package UI.View;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.File;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class CircleProfile extends JPanel {
    private JFrame fr1;
    private ImageIcon i1, i2;
    private Image im1;

    public CircleProfile() {
        fr1 = new JFrame("Circle");
        this.setBackground(new Color(69, 104, 159));
        fr1.add(this);
        fr1.pack();
        fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr1.setVisible(false);
    }
    
      public static Image fileToImage(File file) {
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            // Optionally, you can resize the image if needed
            // For example, resizing to 100x100 pixels:
            int width = bufferedImage.getWidth(null);
            int height = bufferedImage.getHeight(null);
            Image resizedImage = bufferedImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            return resizedImage;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Image LoadImage(String link){
        i1 = new ImageIcon(link);
        im1 = i1.getImage();
        return im1;
    }
    //Overload
    public Image LoadImage(Image img){
        i1 = new ImageIcon(img);
        im1 = i1.getImage();
        return im1;
    }
    public Image LoadImage(File f1){
        i1 = new ImageIcon(fileToImage(f1));
        im1 = i1.getImage();
        return im1;
    }
    @Override
    public void paintComponent(Graphics g) {

        //Set Position Draw Circle
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        int position = Math.min(getWidth(), getHeight());
        int x = ((getWidth() - position) / 2);
        int y = ((getHeight() - position) / 2);
        
        // Draw Circle
        Ellipse2D c1 = new Ellipse2D.Float(x, y, position, position);
        g2.setClip(c1);
        g2.drawImage(im1, 0, 0, getWidth(), getHeight(), this);
        g2.dispose();
       
    }
    public static void main(String[] args) {
       CircleProfile cp1 = new CircleProfile();
       cp1.LoadImage("src/UI/Image/3.jpg");
    }
    
}
