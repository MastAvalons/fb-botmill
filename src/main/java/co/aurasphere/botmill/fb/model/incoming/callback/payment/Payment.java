package co.aurasphere.botmill.fb.model.incoming.callback.payment;

import java.io.Serializable;

import co.aurasphere.botmill.fb.model.outcoming.template.button.BuyButton;
import co.aurasphere.botmill.fb.model.outcoming.template.button.RequestedUserInfo;

import com.google.gson.annotations.SerializedName;


/**
 * Model for the Payment Callback. <br/>
 * <br/>
 * This callback occurs when a persons taps the pay button from the checkout
 * dialog rendered by the {@link BuyButton}. It contains the requested user
 * information as well as payment credentials. Depends on the payment provider
 * you use, the payment credential will differ. <br/>
 * <br/>
 * You must subscribe to this callback by selecting the messaging_payments field
 * when setting up your webhook.
 * 
 * <h1>Stripe/Paypal</h1>
 * 
 * After user click on pay, user will be charged directly and the payment will
 * be send to your Stripe/Paypal account. This webhook event will be called once
 * the process succeed. All the requested user information that user entered in
 * the payment dialog will be passed back in the webhook event. The charge_id
 * from Paypal/Stripe will be passed to you for tracking the payment. You need
 * to return HTTP status of 200 once you finished processing the event. <br/>
 * <br/>
 * If the payment is a test payment, we will not charge the card but will send a
 * result with dummy fb_payment_id/charge_id to you. You can do test payment
 * with Stripe/Paypal only if your page has payment permission for now. Refers
 * to <a href=
 * "https://developers.facebook.com/docs/messenger-platform/complete-guide/payments#test_payments"
 * >How to Test Payment</a> for details. <br/>
 * 
 * <h1>Tokenized Payment</h1>
 * 
 * If you are using tokenized payment, when user click on pay, we will send you
 * a single-use Discover virtual card provisioned by PayPal. The card credential
 * will be encrypted by the public key you provided in previous steps. You can
 * then decrypt the tokenized card by following the <a href=
 * "https://developers.facebook.com/docs/messenger-platform/complete-guide/payments#decrypting"
 * >detail steps here</a>. After you successfully decoded the credential, you
 * can then integrate with your preferred payment provider to charge the card.
 * You need to return HTTP status of 200 once you finished processing the event.<br/>
 * </br> If the payment is a test payment, you will get a dummy tokenized card
 * back with the following dummy information (card_number: 4111111111111111,
 * cvv: 123, expiry month: 11, expiry year: 2020). You can test tokenized
 * payment even if your page/app has not been accepted to beta program. Refers
 * to <a href=
 * "https://developers.facebook.com/docs/messenger-platform/complete-guide/payments#test_payments"
 * >How to Test Payment</a> for details. <br/>
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference/payment"
 *      >Facebook's Messenger Platform Payment Callback Documentation</a>
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/buy-button"
 *      >Facebook's Messenger Platform Buy Button Documentation</a>
 * @date Dec 4, 2016
 */
public class Payment implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Metadata defined in the Buy Button.
	 */
	private String payload;

	/**
	 * Information that was requested from the user by the Buy Button.
	 */
	@SerializedName("requested_user_info")
	private RequestedUserInfo requestedUserInfo;

	/**
	 * Payment credentials.
	 */
	@SerializedName("payment_credential")
	private PaymentCredential paymentCredential;

	/**
	 * Total amount of transaction.
	 */
	private PaymentAmount amount;

	/**
	 * The option_id of the selected shipping option sent via the <a href=
	 * "https://developers.facebook.com/docs/messenger-platform/webhook-reference/checkout-update"
	 * >checkout update callback</a>. Only applicable for flexible payments.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference/checkout-update"
	 *      >Facebook's Messenger Platform Checkout Update Callback
	 *      Documentation</a>
	 */
	@SerializedName("shipping_option_id")
	private String shippingOptionId;

	/**
	 * Gets the {@link #payload}.
	 *
	 * @return the {@link #payload}.
	 */
	public String getPayload() {
		return payload;
	}

	/**
	 * Sets the {@link #payload}.
	 *
	 * @param payload
	 *            the {@link #payload} to set.
	 */
	public void setPayload(String payload) {
		this.payload = payload;
	}

	/**
	 * Gets the {@link #requestedUserInfo}.
	 *
	 * @return the {@link #requestedUserInfo}.
	 */
	public RequestedUserInfo getRequestedUserInfo() {
		return requestedUserInfo;
	}

	/**
	 * Sets the {@link #requestedUserInfo}.
	 *
	 * @param requestedUserInfo
	 *            the {@link #requestedUserInfo} to set.
	 */
	public void setRequestedUserInfo(RequestedUserInfo requestedUserInfo) {
		this.requestedUserInfo = requestedUserInfo;
	}

	/**
	 * Gets the {@link #paymentCredential}.
	 *
	 * @return the {@link #paymentCredential}.
	 */
	public PaymentCredential getPaymentCredential() {
		return paymentCredential;
	}

	/**
	 * Sets the {@link #paymentCredential}.
	 *
	 * @param paymentCredential
	 *            the {@link #paymentCredential} to set.
	 */
	public void setPaymentCredential(PaymentCredential paymentCredential) {
		this.paymentCredential = paymentCredential;
	}

	/**
	 * Gets the {@link #amount}.
	 *
	 * @return the {@link #amount}.
	 */
	public PaymentAmount getAmount() {
		return amount;
	}

	/**
	 * Sets the {@link #amount}.
	 *
	 * @param amount
	 *            the {@link #amount} to set.
	 */
	public void setAmount(PaymentAmount amount) {
		this.amount = amount;
	}

	/**
	 * Gets the {@link #shippingOptionId}.
	 *
	 * @return the {@link #shippingOptionId}.
	 */
	public String getShippingOptionId() {
		return shippingOptionId;
	}

	/**
	 * Sets the {@link #shippingOptionId}.
	 *
	 * @param shippingOptionId
	 *            the {@link #shippingOptionId} to set.
	 */
	public void setShippingOptionId(String shippingOptionId) {
		this.shippingOptionId = shippingOptionId;
	}

}
