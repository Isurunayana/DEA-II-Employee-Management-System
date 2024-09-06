package com.nsbm.ems.attendenceservice.util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class QRCodeGenerator {

    public static byte[] generateQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "q.pic", pngOutputStream);
        return pngOutputStream.toByteArray();
    }
}
