import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ImageTest {
    public static void main(String[] args) throws IOException {
        //FileImageInputStream inputStream = new FileImageInputStream(new File("/"));


        String classPath = ImageTest.class.getResource("").getPath();
        System.out.println(classPath);

        InputStream inputStream = ImageTest.class.getClassLoader().getResourceAsStream("image/street-scape.jpg");
        BufferedImage image = ImageIO.read(inputStream);
        BufferedImage subimage = image.getSubimage(0, 0, 100, 100);
        File file = new File(classPath+"subImage.jpg");
//        boolean b = ImageIO.write(subimage, "jpeg", file);
//        System.out.println(b);
        BufferedImage image1 = ImageIO.read(new File("G:/material/1810090006370eui.jpg"));
        System.out.println(image1.getWidth()+" - "+image1.getHeight());



    }
}
