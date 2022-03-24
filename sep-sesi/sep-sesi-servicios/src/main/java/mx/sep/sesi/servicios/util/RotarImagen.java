/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.servicios.util;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author HeribertoGonzálezPér
 */
public class RotarImagen {
    
    
    public static byte[] rotateImage(InputStream originalImageAsBytes , double radians){
        ByteArrayOutputStream rotatedImageStream = null;

    try {
        
        byte[] bytes = IOUtils.toByteArray(originalImageAsBytes);
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(bytes)); // read the original image
        AffineTransform rotationTransform = new AffineTransform();
        rotationTransform.rotate(radians, originalImage.getWidth() / 2.0 , originalImage.getHeight() / 2.0);
        AffineTransformOp rotationTransformOp = 
          new AffineTransformOp(rotationTransform , AffineTransformOp.TYPE_NEAREST_NEIGHBOR); 
        BufferedImage rotatedImage = rotationTransformOp.filter(originalImage,null); 

        rotatedImageStream = new ByteArrayOutputStream();
        ImageIO.write(rotatedImage, "jpg" , rotatedImageStream); 
        } catch (IOException e) {
         
        }
        return rotatedImageStream.toByteArray();
}
    
}
