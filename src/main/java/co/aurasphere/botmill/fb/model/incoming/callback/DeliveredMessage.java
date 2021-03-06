package co.aurasphere.botmill.fb.model.incoming.callback;

import java.io.Serializable;
import java.util.List;


/**
 * Model for a delivered message callback. <br/>
 * <br/>
 * This callback will occur when a message a page has sent has been delivered.
 * You can subscribe to this callback by selecting the message_deliveries field
 * when <a href=
 * "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 * >setting up</a> your webhook.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference/message-delivered"
 *      >Facebook's Messenger Platform Delivery Callback Documentation</a>
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 *      >Facebook's Messenger Platform Webhook Setup Documentation</a>
 * @date Aug 08, 2016
 */
public class DeliveredMessage implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Messages IDs. <br/>
	 * <br/>
	 * Both mids and {@link #watermark} fields are used to determine which
	 * messages were delivered. watermark is always present and mids is
	 * sometimes present. mids provides delivery receipts on a per-message basis
	 * but may not be present (due to backward compatibility reasons with older
	 * Messenger clients). watermark is always present and is a timestamp
	 * indicating that all messages with a timestamp before watermark were
	 * delivered.
	 */
	private List<String> mids;

	// TODO: https://github.com/BotMill/fb-botmill/issues/19
	/**
	 * All messages before this timestamp where seen.<br/>
	 * <br/>
	 * Both {@link #mids} and watermark fields are used to determine which
	 * messages were delivered. watermark is always present and mids is
	 * sometimes present. mids provides delivery receipts on a per-message basis
	 * but may not be present (due to backward compatibility reasons with older
	 * Messenger clients). watermark is always present and is a timestamp
	 * indicating that all messages with a timestamp before watermark were
	 * delivered.
	 */
	private String watermark;

	/**
	 * Sequence number.
	 */
	private String seq;

	/**
	 * Gets the {@link #mids}.
	 *
	 * @return the {@link #mids}.
	 */
	public List<String> getMids() {
		return mids;
	}

	/**
	 * Sets the {@link #mids}.
	 *
	 * @param mids
	 *            the {@link #mids} to set.
	 */
	public void setMids(List<String> mids) {
		this.mids = mids;
	}

	/**
	 * Gets the {@link #watermark}.
	 *
	 * @return the {@link #watermark}.
	 */
	public String getWatermark() {
		return watermark;
	}

	/**
	 * Sets the {@link #watermark}.
	 *
	 * @param watermark
	 *            the {@link #watermark} to set.
	 */
	public void setWatermark(String watermark) {
		this.watermark = watermark;
	}

	/**
	 * Gets the {@link #seq}.
	 *
	 * @return the {@link #seq}.
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * Sets the {@link #seq}.
	 *
	 * @param seq
	 *            the {@link #seq} to set.
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
}
