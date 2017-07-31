package com.furongsoft.XspWeb.ThirdParty.org.easypr.test;

import static com.furongsoft.XspWeb.ThirdParty.org.easypr.core.CoreFunc.getPlateType;
import static com.furongsoft.XspWeb.ThirdParty.org.easypr.core.CoreFunc.projectedHistogram;
import static com.furongsoft.XspWeb.ThirdParty.org.easypr.core.CoreFunc.showImage;
import static org.bytedeco.javacpp.opencv_highgui.imread;

import java.util.Vector;

import org.bytedeco.javacpp.opencv_core.CvMat;
import org.bytedeco.javacpp.opencv_core.Cv_iplAllocateImageData;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.RotatedRect;
import org.bytedeco.javacpp.opencv_core.Size;

import com.furongsoft.XspWeb.Servlets.ApplicationContextHolder;
import com.furongsoft.XspWeb.ThirdParty.org.easypr.core.CharsIdentify;
import com.furongsoft.XspWeb.ThirdParty.org.easypr.core.CharsRecognise;
import com.furongsoft.XspWeb.ThirdParty.org.easypr.core.CoreFunc;
import com.furongsoft.XspWeb.ThirdParty.org.easypr.core.PlateDetect;
import com.furongsoft.XspWeb.ThirdParty.org.easypr.core.PlateLocate;

/**
 * @author lin.yao
 * 
 */
public class EasyPrTest
{
    public void testPlateRecognise()
    {
        // String imgPath = "res/image/test_image/test.jpg";
        String imgPath = "classpath:EasyPr/res/image/test_image/plate_recognize.jpg";

        Mat src = imread(ApplicationContextHolder.getResourcePath(imgPath));
        PlateDetect plateDetect = new PlateDetect();
        plateDetect.setPDLifemode(true);
        Vector<Mat> matVector = new Vector<Mat>();
        if (0 == plateDetect.plateDetect(src, matVector)) {
            CharsRecognise cr = new CharsRecognise();

            for (int i = 0; i < matVector.size(); ++i) {
                String result = cr.charsRecognise(matVector.get(i));
                System.out.println("Chars Recognised: " + result);
            }
        }
    }

    public void testPlateDetect()
    {
        String imgPath = "classpath:EasyPr/res/image/test_image/IMG_1296.JPG";

        Mat src = imread(ApplicationContextHolder.getResourcePath(imgPath));
        PlateDetect plateDetect = new PlateDetect();
        plateDetect.setPDLifemode(true);
        Vector<Mat> matVector = new Vector<Mat>();
        if (0 == plateDetect.plateDetect(src, matVector)) {
            for (int i = 0; i < matVector.size(); ++i) {
                showImage("Plate Detected", matVector.get(i));
            }
        }
    }

    public void testPlateLocate()
    {
        String imgPath = "classpath:EasyPr/res/image/test_image/IMG_1298.JPG";

        Mat src = imread(ApplicationContextHolder.getResourcePath(imgPath));

        PlateLocate plate = new PlateLocate();
        plate.setDebug(true);
        plate.setLifemode(true);

        Vector<RotatedRect> rectVector = new Vector<RotatedRect>();
        Vector<Mat> resultVec = plate.plateLocate2(src, rectVector);

        int num = resultVec.size();
        for (int j = 0; j < num; j++) {
            showImage("Plate Located " + j, resultVec.get(j));
        }

        return;
    }

    public void testCharsRecognise()
    {
        String imgPath = "res/image/test_image/chars_recognise_huAGH092.jpg";

        Mat src = imread(imgPath);
        CharsRecognise cr = new CharsRecognise();
        cr.setCRDebug(true);
        String result = cr.charsRecognise(src);
        System.out.println("Chars Recognised: " + result);
    }

    public void testColorDetect()
    {
        String imgPath = "res/image/test_image/core_func_yellow.jpg";

        Mat src = imread(imgPath);

        CoreFunc.Color color = getPlateType(src, true);
        System.out.println("Color Deteted: " + color);
    }

    public void testProjectedHistogram()
    {
        String imgPath = "res/image/test_image/chars_identify_E.jpg";

        Mat src = imread(imgPath);
        projectedHistogram(src, CoreFunc.Direction.HORIZONTAL);
    }

    public void testCharsIdentify()
    {
        String imgPath = "res/image/test_image/chars_identify_E.jpg";

        Mat src = imread(imgPath);
        CharsIdentify charsIdentify = new CharsIdentify();
        String result = charsIdentify.charsIdentify(src, false, true);
        System.out.println(result);
    }

    public void plateDetect()
    {
        String imgPath = "classpath:EasyPr/res/image/test_image/IMG_1286.JPG";

        Mat src = imread(ApplicationContextHolder.getResourcePath(imgPath));
        showImage("", src);

        Mat dst = new Mat();
        org.bytedeco.javacpp.opencv_imgproc.resize(
            src, dst,
            new Size(src.size().width() / 4, src.size().height() / 4), 0, 0,
            org.bytedeco.javacpp.opencv_imgproc.CV_INTER_CUBIC);
        showImage("", dst);

        PlateDetect plateDetect = new PlateDetect();
        plateDetect.setPDLifemode(true);
        Vector<Mat> matVector = new Vector<Mat>();
        Vector<RotatedRect> rectVector = new Vector<RotatedRect>();
        if (0 == plateDetect.plateDetect2(src, matVector, rectVector)) {
            for (int i = 0; i < matVector.size(); ++i) {
                RotatedRect rect = rectVector.get(i);
                System.out.println("rect: " + rect.center().x() + ", " + rect
                    .center().y());
                showImage("Plate Detected", matVector.get(i));
            }
        }
    }
}
