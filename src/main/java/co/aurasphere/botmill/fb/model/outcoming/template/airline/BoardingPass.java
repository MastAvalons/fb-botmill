package co.aurasphere.botmill.fb.model.outcoming.template.airline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.google.gson.annotations.SerializedName;


/**
 * The Class BoardingPass.
 */
public class BoardingPass implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The passenger name. */
	@NotBlank
	@SerializedName("passenger_name")
	private String passengerName;

	/** The pnr number. */
	@NotBlank
	@SerializedName("pnr_number")
	private String pnrNumber;
	
	/** The travel class. */
	@SerializedName("travel_class")
	private TravelClass travelClass;
	
	/** The seat. */
	private String seat;
	
	/** The auxiliary fields. */
	@Size(max=5)
	@SerializedName("auxiliary_fields")
	private List<Field> auxiliaryFields;
	
	/** The secondary fields. */
	@Size(max=5)
	@SerializedName("secondary_fields")
	private List<Field> secondaryFields;
	
	/** The logo image url. */
	@NotBlank
	@SerializedName("logo_image_url")
	private String logoImageUrl;
	
	/** The header image url. */
	@SerializedName("header_image_url")
	private String headerImageUrl;
	
	/** The header text field. */
	@SerializedName("header_text_field")
	private String headerTextField;
	
	/** The qr code. */
	@SerializedName("qr_code")
	private String qrCode;
	
	/** The barcode image url. */
	@SerializedName("barcode_image_url")
	private String barcodeImageUrl;
	
	/** The above bar code image url. */
	@NotBlank
	@SerializedName("above_bar_code_image_url")
	private String aboveBarCodeImageUrl;
	
	/** The flight info. */
	@Valid
	@NotNull
	@SerializedName("flight_info")
	private FlightInfo flightInfo;
	
	/**
	 * Instantiates a new boarding pass.
	 *
	 * @param passengerName the passenger name
	 * @param pnrNumber the pnr number
	 * @param logoImageUrl the logo image url
	 * @param aboveBarCodeImageUrl the above bar code image url
	 */
	public BoardingPass(String passengerName, String pnrNumber, String logoImageUrl, String aboveBarCodeImageUrl){
		this.passengerName = passengerName;
		this.pnrNumber = pnrNumber;
		this.logoImageUrl = logoImageUrl;
		this.aboveBarCodeImageUrl = aboveBarCodeImageUrl;
		this.auxiliaryFields = new ArrayList<Field>();
		this.secondaryFields = new ArrayList<Field>();
	}

	/**
	 * Gets the passenger name.
	 *
	 * @return the passenger name
	 */
	public String getPassengerName() {
		return passengerName;
	}

	/**
	 * Sets the passenger name.
	 *
	 * @param passengerName the new passenger name
	 */
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	/**
	 * Gets the pnr number.
	 *
	 * @return the pnr number
	 */
	public String getPnrNumber() {
		return pnrNumber;
	}

	/**
	 * Sets the pnr number.
	 *
	 * @param pnrNumber the new pnr number
	 */
	public void setPnrNumber(String pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	/**
	 * Gets the travel class.
	 *
	 * @return the travel class
	 */
	public TravelClass getTravelClass() {
		return travelClass;
	}

	/**
	 * Sets the travel class.
	 *
	 * @param travelClass the new travel class
	 */
	public void setTravelClass(TravelClass travelClass) {
		this.travelClass = travelClass;
	}

	/**
	 * Gets the seat.
	 *
	 * @return the seat
	 */
	public String getSeat() {
		return seat;
	}

	/**
	 * Sets the seat.
	 *
	 * @param seat the new seat
	 */
	public void setSeat(String seat) {
		this.seat = seat;
	}

	/**
	 * Gets the auxiliary fields.
	 *
	 * @return the auxiliary fields
	 */
	public List<Field> getAuxiliaryFields() {
		return auxiliaryFields;
	}

	/**
	 * Sets the auxiliary fields.
	 *
	 * @param auxiliaryFields the new auxiliary fields
	 */
	public void setAuxiliaryFields(List<Field> auxiliaryFields) {
		this.auxiliaryFields = auxiliaryFields;
	}

	/**
	 * Gets the secondary fields.
	 *
	 * @return the secondary fields
	 */
	public List<Field> getSecondaryFields() {
		return secondaryFields;
	}

	/**
	 * Sets the secondary fields.
	 *
	 * @param secondaryFields the new secondary fields
	 */
	public void setSecondaryFields(List<Field> secondaryFields) {
		this.secondaryFields = secondaryFields;
	}

	/**
	 * Gets the logo image url.
	 *
	 * @return the logo image url
	 */
	public String getLogoImageUrl() {
		return logoImageUrl;
	}

	/**
	 * Sets the logo image url.
	 *
	 * @param logoImageUrl the new logo image url
	 */
	public void setLogoImageUrl(String logoImageUrl) {
		this.logoImageUrl = logoImageUrl;
	}

	/**
	 * Gets the header image url.
	 *
	 * @return the header image url
	 */
	public String getHeaderImageUrl() {
		return headerImageUrl;
	}

	/**
	 * Sets the header image url.
	 *
	 * @param headerImageUrl the new header image url
	 */
	public void setHeaderImageUrl(String headerImageUrl) {
		this.headerImageUrl = headerImageUrl;
	}

	/**
	 * Gets the header text field.
	 *
	 * @return the header text field
	 */
	public String getHeaderTextField() {
		return headerTextField;
	}

	/**
	 * Sets the header text field.
	 *
	 * @param headerTextField the new header text field
	 */
	public void setHeaderTextField(String headerTextField) {
		this.headerTextField = headerTextField;
	}

	/**
	 * Gets the qr code.
	 *
	 * @return the qr code
	 */
	public String getQrCode() {
		return qrCode;
	}

	/**
	 * Sets the qr code.
	 *
	 * @param qrCode the new qr code
	 */
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	/**
	 * Gets the barcode image url.
	 *
	 * @return the barcode image url
	 */
	public String getBarcodeImageUrl() {
		return barcodeImageUrl;
	}

	/**
	 * Sets the barcode image url.
	 *
	 * @param barcodeImageUrl the new barcode image url
	 */
	public void setBarcodeImageUrl(String barcodeImageUrl) {
		this.barcodeImageUrl = barcodeImageUrl;
	}

	/**
	 * Gets the above bar code image url.
	 *
	 * @return the above bar code image url
	 */
	public String getAboveBarCodeImageUrl() {
		return aboveBarCodeImageUrl;
	}

	/**
	 * Sets the above bar code image url.
	 *
	 * @param aboveBarCodeImageUrl the new above bar code image url
	 */
	public void setAboveBarCodeImageUrl(String aboveBarCodeImageUrl) {
		this.aboveBarCodeImageUrl = aboveBarCodeImageUrl;
	}

	/**
	 * Gets the flight info.
	 *
	 * @return the flight info
	 */
	public FlightInfo getFlightInfo() {
		return flightInfo;
	}

	/**
	 * Sets the flight info.
	 *
	 * @param flightInfo the new flight info
	 */
	public void setFlightInfo(FlightInfo flightInfo) {
		this.flightInfo = flightInfo;
	}

	/**
	 * Adds the auxiliary field.
	 *
	 * @param field the field
	 */
	public void addAuxiliaryField(Field field) {
		this.auxiliaryFields.add(field);
	}
	
	/**
	 * Adds the secondary field.
	 *
	 * @param field the field
	 */
	public void addSecondaryField(Field field) {
		this.secondaryFields.add(field);
	}
}
