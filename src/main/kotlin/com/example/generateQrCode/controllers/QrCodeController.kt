package com.example.generateQrCode.controllers

import com.example.generateQrCode.requests.GenerateQrCodeRequest
import com.google.zxing.BarcodeFormat
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.qrcode.QRCodeWriter
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.awt.image.BufferedImage


@RestController
@RequestMapping("/api/v1/generate-qr-code")
class QrCodeController {

    @PostMapping(produces = [MediaType.IMAGE_PNG_VALUE])
    fun getQrCode(@RequestBody generateQrCodeRequest: GenerateQrCodeRequest): BufferedImage {
        val barcodeWriter = QRCodeWriter()
        val bitMatrix = barcodeWriter.encode(generateQrCodeRequest.link, BarcodeFormat.QR_CODE, 200, 200)
        return MatrixToImageWriter.toBufferedImage(bitMatrix)
    }
}