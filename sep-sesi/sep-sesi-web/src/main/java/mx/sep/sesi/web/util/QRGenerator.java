/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sep.sesi.web.util;

/**
 *
 * @author heriberto.perez
 */


import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;        
        
        
public class QRGenerator {
    private static final String FORMATO_IMAGEN = "gif";
    private static final String RUTA_IMAGEN = "static/images/";
    private static final String IMAGEN = "qrComprobante.gif";
    private static final int ancho = 500;
    private static final int alto = 500;
    
    /**
     * @param QRdata contenido del Quick Response Code QR
     * @param rutaSer ruta de almacenamiento temporal en servidor
     * @param aleaComp número aleatorio se emplea como prefijo de la imagen del
     * qr
     * @throws com.google.zxing.WriterException
     * @throws java.io.FileNotFoundException
     */
    public void QRGeneratorData(String QRdata, String rutaSer, Integer aleaComp) throws WriterException, FileNotFoundException, IOException {
        BitMatrix bm;
        Writer writer = new QRCodeWriter();
        bm = writer.encode(QRdata, BarcodeFormat.QR_CODE, ancho, alto);
        BufferedImage image = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < ancho; y++) {
            for (int x = 0; x < alto; x++) {
                int grayValue = (bm.get(x, y) ? 1 : 0) & 0xff;
                image.setRGB(x, y, (grayValue == 0 ? 0 : 0xFFFFFF));
            }
        }
        image = invertirColores(image);
        FileOutputStream qrCode = new FileOutputStream(rutaSer + RUTA_IMAGEN + aleaComp + IMAGEN);
        ImageIO.write(image, FORMATO_IMAGEN, qrCode);
        qrCode.close();
    }

    private static BufferedImage invertirColores(BufferedImage imagen) {
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                int rgb = imagen.getRGB(x, y);
                if (rgb == -16777216) {
                    imagen.setRGB(x, y, -1);
                } else {
                    imagen.setRGB(x, y, -16777216);
                }
            }
        }
        return imagen;
    }

    //Elimina la imagen temporal del código QR 
    public void deleteFile(Integer aleaComp) {
        File file = new File(aleaComp + IMAGEN);
        if (file.exists()) {
            System.out.println("borrando..." + file.getName());
            file.delete();
        }
    }
    
    //Elimina del servidor la imagen temporal del código QR 
    public void deleteFile(String rutaSer, Integer aleaComp) {
        File file = new File(rutaSer + RUTA_IMAGEN + aleaComp + IMAGEN);
        if (file.exists()) {
            file.delete();
        }
    }
}
