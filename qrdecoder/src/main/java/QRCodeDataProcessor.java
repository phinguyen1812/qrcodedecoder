import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QRCodeDataProcessor {
    
    private static final Logger LOGGER = LogManager.getLogger(QRCodeDataProcessor.class);
    
    public SwissQRBill parseSwissQRCodeData(String qrData) throws IllegalArgumentException {
        List<String> lines = Arrays.asList(qrData.split("\\r?\\n"));
        if (lines.size() < 31) {
            LOGGER.error("Error parsing qrcode: " + System.getProperty("line.separator") + qrData);
            throw new IllegalArgumentException("Incomplete QR data");
        }
        
        SwissQRBill bill = new SwissQRBill();
        bill.setQrType(lines.get(0));
        bill.setVersion(lines.get(1));
        bill.setCodingType(lines.get(2));
        bill.setAccount(lines.get(3));
        bill.setCrAdressTyp(lines.get(4));
        bill.setCrName(lines.get(5));
        bill.setCrStreetOrAddressLine1(lines.get(6));
        bill.setCrBuildingNumberOrAddressLine2(lines.get(7));
        bill.setCrPostalCode(lines.get(8));
        bill.setCrCity(lines.get(9));
        bill.setCrCountry(lines.get(10));
        bill.setUcrAdressTyp(lines.get(11));
        bill.setUcrName(lines.get(12));
        bill.setUcrStreetOrAddressLine1(lines.get(13));
        bill.setUcrBuildingNumberOrAddressLine2(lines.get(14));
        bill.setUcrPostalCode(lines.get(15));
        bill.setUcrCity(lines.get(16));
        bill.setUcrCountry(lines.get(17));
        bill.setAmount(lines.get(18));
        bill.setCurrency(lines.get(19));
        bill.setUdAdressTyp(lines.get(20));
        bill.setUdName(lines.get(21));
        bill.setUdStreetOrAddressLine1(lines.get(22));
        bill.setUdBuildingNumberOrAddressLine2(lines.get(23));
        bill.setUdPostalCode(lines.get(24));
        bill.setUdCity(lines.get(25));
        bill.setUdCountry(lines.get(26));
        bill.setReferenceType(lines.get(27));
        bill.setReference(lines.get(28));
        bill.setUnstructuredMessage(lines.get(29));
        bill.setTrailer(lines.get(30));
        
        // Validate the extracted data
        validateBill(bill);
        
        return bill;
    }
    
    private void validateBill(SwissQRBill bill) {
        if (!bill.isValidIBAN()) {
            throw new IllegalArgumentException("Invalid IBAN format");
        }
        if (!bill.isValidAmount()) {
            throw new IllegalArgumentException("Invalid amount format");
        }
        if (!bill.isValidCurrency()) {
            throw new IllegalArgumentException("Invalid currency format");
        }
    }
    
}
