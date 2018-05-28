import com.alibaba.simpleimage.ImageFormat;
import com.alibaba.simpleimage.ImageWrapper;
import com.alibaba.simpleimage.SimpleImageException;
import com.alibaba.simpleimage.render.CropParameter;
import com.alibaba.simpleimage.render.ScaleParameter;
import com.alibaba.simpleimage.render.WriteParameter;
import com.alibaba.simpleimage.util.ImageCropHelper;
import com.alibaba.simpleimage.util.ImageReadHelper;
import com.alibaba.simpleimage.util.ImageScaleHelper;
import com.alibaba.simpleimage.util.ImageWriteHelper;
import org.apache.commons.io.IOUtils;

import javax.media.jai.PlanarImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * test demo of Alibaba simple image
 */
public class SimpleImageTest {
    public static void main(String[] args) throws FileNotFoundException {
        String classPath = SimpleImageTest.class.getResource("").getPath();
//        String src = classPath+"/image/street-scape.jpg";
//        String target = classPath+"/image/cut/"+new Date().getTime()+".jpg";
        String src = classPath+"/image/a.gif";
        String target = classPath+"/image/cut/"+new Date().getTime()+".gif";

        File fileIn = new File(src);
        FileInputStream inStream = new FileInputStream(fileIn);

        //x: 117.12158808933005, y: 64.11910669975184, width: 568.888888888889, height: 320.00000000000006,
        CropParameter cropParameter = new CropParameter();
        cropParameter.setX(0);
        cropParameter.setY(0);
        cropParameter.setWidth(200);
        cropParameter.setHeight(198);


        ScaleParameter scaleParameter = new ScaleParameter(500, 500);
        cut(inStream,target,cropParameter,scaleParameter);
    }


    /**
     * @param cropParam  裁切参数
     */
    public static void cut(InputStream inputStream, String targetPath,CropParameter cropParam,ScaleParameter scaleParameter) {

        FileOutputStream outStream = null;
        try {
            ImageWrapper imageWrapper = ImageReadHelper.read(inputStream);
//            int w = imageWrapper.getWidth();
//            int h = imageWrapper.getHeight();
            ImageFormat imageFormat = imageWrapper.getImageFormat();
            System.out.println(imageFormat);
            // crop
            PlanarImage planrImage = ImageCropHelper.crop(imageWrapper.getAsPlanarImage(), cropParam);


            //图片缩放
            planrImage = ImageScaleHelper.scale(planrImage, scaleParameter);

            imageWrapper = new ImageWrapper(planrImage);
            // 4.输出
            // 目的图片
            File out = new File(targetPath);
            outStream = new FileOutputStream(out);

            String prefix = out.getName().substring(out.getName().lastIndexOf(".") + 1);
            ImageWriteHelper.write(imageWrapper, outStream, ImageFormat.getImageFormat(prefix), new WriteParameter());

        }  catch (SimpleImageException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream); // 图片文件输入输出流必须记得关闭
            IOUtils.closeQuietly(outStream);
        }
    }

}
