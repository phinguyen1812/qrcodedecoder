import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class QRCodeDataProcessorTest {
    
    @Test
    void testParseValidQRCodeData() {
        QRCodeDataProcessor processor = new QRCodeDataProcessor();
        String validQRCodeData = "SPC\n" +
                "0200\n" +
                "1\n" +
                "CH2130788000050025294\n" +
                "S\n" +
                "Etat de Genève - Office cantonal des poursuites\n" +
                "Case Postale\n" +
                "208\n" +
                "1211\n" +
                "Genève 8\n" +
                "CH\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "22.80\n" +
                "CHF\n" +
                "S\n" +
                "Mobilière Suisse Société d'assurances SA\n" +
                "Bundesgasse\n" +
                "35\n" +
                "3011\n" +
                "Bern\n" +
                "CH\n" +
                "QRR\n" +
                "102322222042402777301001370\n" +
                "FACTURE 424027773\n" +
                "EPD";
        SwissQRBill bill = processor.parseSwissQRCodeData(validQRCodeData);
        assertNotNull(bill);
        assertEquals("SPC", bill.getQrType());
        assertEquals("0200", bill.getVersion());
        assertEquals("1", bill.getCodingType());
        assertEquals("CH2130788000050025294", bill.getAccount());
        assertEquals("S", bill.getCrAdressTyp());
        assertEquals("Etat de Genève - Office cantonal des poursuites", bill.getCrName());
        assertEquals("Case Postale", bill.getCrStreetOrAddressLine1());
        assertEquals("208", bill.getCrBuildingNumberOrAddressLine2());
        assertEquals("1211", bill.getCrPostalCode());
        assertEquals("Genève 8", bill.getCrCity());
        assertEquals("CH", bill.getCrCountry());
        
        assertEquals("", bill.getUcrAdressTyp());
        assertEquals("", bill.getUcrName());
        assertEquals("", bill.getUcrStreetOrAddressLine1());
        assertEquals("", bill.getUcrBuildingNumberOrAddressLine2());
        assertEquals("", bill.getUcrPostalCode());
        assertEquals("", bill.getUcrCity());
        assertEquals("", bill.getUcrCountry());
    
        assertEquals("22.80", bill.getAmount());
        assertEquals("CHF", bill.getCurrency());
    
        assertEquals("S", bill.getUdAdressTyp());
        assertEquals("Mobilière Suisse Société d'assurances SA", bill.getUdName());
        assertEquals("Bundesgasse", bill.getUdStreetOrAddressLine1());
        assertEquals("35", bill.getUdBuildingNumberOrAddressLine2());
        assertEquals("3011", bill.getUdPostalCode());
        assertEquals("Bern", bill.getUdCity());
        assertEquals("CH", bill.getUdCountry());
    
        assertEquals("QRR", bill.getReferenceType());
        assertEquals("102322222042402777301001370", bill.getReference());
        assertEquals("FACTURE 424027773", bill.getUnstructuredMessage());
    
        assertEquals("EPD", bill.getTrailer());
    }
    
    @Test
    void testParseIncompleteQRCodeData() {
        QRCodeDataProcessor processor = new QRCodeDataProcessor();
        String incompleteQRCodeData = "SPC\r\n0200\r\n1";
        assertThrows(IllegalArgumentException.class, () -> {
            processor.parseSwissQRCodeData(incompleteQRCodeData);
        });
    }
}
