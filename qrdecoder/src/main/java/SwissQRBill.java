public class SwissQRBill {
    private String qrType; //Indicateur - Indicateur SWISS QR Code (Swiss Payments Code)
    private String version; //Numversion - No version QR-Code. actuellement 0200
    private String codingType; //Encodage - Jeu de caractères latin en UTF-8
    private String account; //QRIBAN - QR-IBAN – sans espaces
    private String crAdressTyp; //TypeAdrCred - Type adresse créditeur structuré
    private String crName; //NomCréditeur - Prénom nom ou raison sociale créditeur
    private String crStreetOrAddressLine1; //AdresseLigne1Cred - rue/case postale de l'adresse du créditeur
    private String crBuildingNumberOrAddressLine2; //AdresseLigne2Cred - numéro de maison ou de case postale de l'adresse du créditeur
    private String crPostalCode;// AdresseLigne3Cred - Code postal du créditeur
    private String crCity; //AdresseLigne4Cred - Localité du créditeur
    private String crCountry;//AdresseLigne5Cred - Code pays ISO 3166-1 créditeur. Ne pas afficher si CH
    private String ucrAdressTyp; //AutreLigne1Cred
    private String ucrName; //AutreLigne2Cred
    private String ucrStreetOrAddressLine1; //AutreLigne3Cred
    private String ucrBuildingNumberOrAddressLine2; //AutreLigne4Cred
    private String ucrPostalCode; //AutreLigne5Cred
    private String ucrCity; //AutreLigne6Cred
    private String ucrCountry; //AutreLigne7Cred
    private String amount; //Montant - Montant de la facture avec point comme marque décimal et deux décimales
    private String currency; //Devise
    private String udAdressTyp; //TypeAdrDest - Adresse  destinataire type structuré
    private String udName; //NomDestinataire //Prénom + nom ou raison sociale du destinataire
    private String udStreetOrAddressLine1; //AdresseLigne1Dest - rue/case postale de l'adresse du destinataire
    private String udBuildingNumberOrAddressLine2; //AdresseLigne2Dest - numéro de maison de l'adresse du destinataire
    private String udPostalCode; //AdresseLigne3Dest - Code postal du destinataire
    private String udCity; //AdresseLigne3Dest - Localité du destinataire
    private String udCountry; //AdresseLigne5Dest - Code pays ISO 3166-1  destinataire
    private String referenceType; //TypeRef - Type Réference QR-IBAN
    private String reference; //Réference QR
    private String unstructuredMessage; //InfoInstructuree - FACTURE N° facture
    private String trailer; //FinCodeQR - Fin du code QR (End Payment Data)
    
    public boolean isValidIBAN() {
        return this.account != null && !this.account.isEmpty();
    }
    
    public boolean isValidAmount() {
        try {
            if (this.amount == null) {
                return false;
            }
            Double.parseDouble(this.amount);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public boolean isValidCurrency() {
        return this.currency != null && !this.currency.isEmpty();
    }
    
    public String getQrType() {
        return qrType;
    }
    
    public void setQrType(String qrType) {
        this.qrType = qrType;
    }
    
    public String getVersion() {
        return version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }
    
    public String getCodingType() {
        return codingType;
    }
    
    public void setCodingType(String codingType) {
        this.codingType = codingType;
    }
    
    public String getAccount() {
        return account;
    }
    
    public void setAccount(String account) {
        this.account = account;
    }
    
    public String getCrAdressTyp() {
        return crAdressTyp;
    }
    
    public void setCrAdressTyp(String crAdressTyp) {
        this.crAdressTyp = crAdressTyp;
    }
    
    public String getCrName() {
        return crName;
    }
    
    public void setCrName(String crName) {
        this.crName = crName;
    }
    
    public String getCrStreetOrAddressLine1() {
        return crStreetOrAddressLine1;
    }
    
    public void setCrStreetOrAddressLine1(String crStreetOrAddressLine1) {
        this.crStreetOrAddressLine1 = crStreetOrAddressLine1;
    }
    
    public String getCrBuildingNumberOrAddressLine2() {
        return crBuildingNumberOrAddressLine2;
    }
    
    public void setCrBuildingNumberOrAddressLine2(String crBuildingNumberOrAddressLine2) {
        this.crBuildingNumberOrAddressLine2 = crBuildingNumberOrAddressLine2;
    }
    
    public String getCrPostalCode() {
        return crPostalCode;
    }
    
    public void setCrPostalCode(String crPostalCode) {
        this.crPostalCode = crPostalCode;
    }
    
    public String getCrCity() {
        return crCity;
    }
    
    public void setCrCity(String crCity) {
        this.crCity = crCity;
    }
    
    public String getCrCountry() {
        return crCountry;
    }
    
    public void setCrCountry(String crCountry) {
        this.crCountry = crCountry;
    }
    
    public String getUcrAdressTyp() {
        return ucrAdressTyp;
    }
    
    public void setUcrAdressTyp(String ucrAdressTyp) {
        this.ucrAdressTyp = ucrAdressTyp;
    }
    
    public String getUcrName() {
        return ucrName;
    }
    
    public void setUcrName(String ucrName) {
        this.ucrName = ucrName;
    }
    
    public String getUcrStreetOrAddressLine1() {
        return ucrStreetOrAddressLine1;
    }
    
    public void setUcrStreetOrAddressLine1(String ucrStreetOrAddressLine1) {
        this.ucrStreetOrAddressLine1 = ucrStreetOrAddressLine1;
    }
    
    public String getUcrBuildingNumberOrAddressLine2() {
        return ucrBuildingNumberOrAddressLine2;
    }
    
    public void setUcrBuildingNumberOrAddressLine2(String ucrBuildingNumberOrAddressLine2) {
        this.ucrBuildingNumberOrAddressLine2 = ucrBuildingNumberOrAddressLine2;
    }
    
    public String getUcrPostalCode() {
        return ucrPostalCode;
    }
    
    public void setUcrPostalCode(String ucrPostalCode) {
        this.ucrPostalCode = ucrPostalCode;
    }
    
    public String getUcrCity() {
        return ucrCity;
    }
    
    public void setUcrCity(String ucrCity) {
        this.ucrCity = ucrCity;
    }
    
    public String getUcrCountry() {
        return ucrCountry;
    }
    
    public void setUcrCountry(String ucrCountry) {
        this.ucrCountry = ucrCountry;
    }
    
    public String getAmount() {
        return amount;
    }
    
    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    public String getCurrency() {
        return currency;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    public String getUdAdressTyp() {
        return udAdressTyp;
    }
    
    public void setUdAdressTyp(String udAdressTyp) {
        this.udAdressTyp = udAdressTyp;
    }
    
    public String getUdName() {
        return udName;
    }
    
    public void setUdName(String udName) {
        this.udName = udName;
    }
    
    public String getUdStreetOrAddressLine1() {
        return udStreetOrAddressLine1;
    }
    
    public void setUdStreetOrAddressLine1(String udStreetOrAddressLine1) {
        this.udStreetOrAddressLine1 = udStreetOrAddressLine1;
    }
    
    public String getUdBuildingNumberOrAddressLine2() {
        return udBuildingNumberOrAddressLine2;
    }
    
    public void setUdBuildingNumberOrAddressLine2(String udBuildingNumberOrAddressLine2) {
        this.udBuildingNumberOrAddressLine2 = udBuildingNumberOrAddressLine2;
    }
    
    public String getUdPostalCode() {
        return udPostalCode;
    }
    
    public void setUdPostalCode(String udPostalCode) {
        this.udPostalCode = udPostalCode;
    }
    
    public String getUdCity() {
        return udCity;
    }
    
    public void setUdCity(String udCity) {
        this.udCity = udCity;
    }
    
    public String getUdCountry() {
        return udCountry;
    }
    
    public void setUdCountry(String udCountry) {
        this.udCountry = udCountry;
    }
    
    public String getReferenceType() {
        return referenceType;
    }
    
    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }
    
    public String getReference() {
        return reference;
    }
    
    public void setReference(String reference) {
        this.reference = reference;
    }
    
    public String getUnstructuredMessage() {
        return unstructuredMessage;
    }
    
    public void setUnstructuredMessage(String unstructuredMessage) {
        this.unstructuredMessage = unstructuredMessage;
    }
    
    public String getTrailer() {
        return trailer;
    }
    
    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
    
}