package co.aurasphere.botmill.fb.bean;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.botmill.fb.FbBotMillContext;
import co.aurasphere.botmill.fb.event.FbBotMillEventType;
import co.aurasphere.botmill.fb.model.base.QuickReplyLocationPayload;
import co.aurasphere.botmill.fb.model.base.User;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.incoming.callback.EchoMessage;
import co.aurasphere.botmill.fb.model.incoming.callback.LocationCoordinates;
import co.aurasphere.botmill.fb.model.incoming.callback.ReceivedMessage;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.message.Message;


/**
 * Base FbBot bean which contains utility methods for handling an envelope.
 * 
 * @author Donato Rimenti
 * @date Aug 08, 2016
 */
public class FbBotMillBean {

	/**
	 * The logger.
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(FbBotMillBean.class);

	/**
	 * Retrieves a text message from an envelope. It never returns null.
	 * 
	 * @param envelope
	 *            the message envelope.
	 * @return the text message if found or an empty String otherwise. It never
	 *         returns null.
	 */
	protected String safeGetMessage(MessageEnvelope envelope) {
		if (envelope != null && envelope.getMessage() != null
				&& envelope.getMessage().getText() != null) {
			return envelope.getMessage().getText();
		}
		return "";
	}
	
	/**
	 * Retrieves a quick reply payload from an envelope. It never returns null.
	 * 
	 * @param envelope
	 *            the message envelope.
	 * @return the text message if found or an empty String otherwise. It never
	 *         returns null.
	 */
	protected String safeGetQuickReplyPayload(MessageEnvelope envelope) {
		if (envelope != null && envelope.getMessage() != null && envelope.getMessage().getQuickReply() != null && envelope.getMessage().getQuickReply().getPayload() != null) {
			return envelope.getMessage().getQuickReply().getPayload();
		}
		return "";
	}

	/**
	 * Retrieves a text message from an envelope. It never returns null.
	 * 
	 * @param envelope
	 *            the message envelope.
	 * @return the message envelope if found or an empty String otherwise. It
	 *         never returns null.
	 */
	protected String safeGetPostbackPayload(MessageEnvelope envelope) {
		if (envelope != null && envelope.getPostback() != null
				&& envelope.getPostback().getPayload() != null) {
			return envelope.getPostback().getPayload();
		}
		return "";
	}

	/**
	 * Retrieves the recipient ID from an envelope. It never returns null.
	 * 
	 * @param envelope
	 *            the message envelope.
	 * @return the recipient ID if found or an empty String otherwise. It never
	 *         returns null.
	 */
	protected String safeGetRecipientId(MessageEnvelope envelope) {
		if (envelope != null && envelope.getRecipient() != null
				&& envelope.getRecipient().getId() != null) {
			return envelope.getRecipient().getId();
		}
		return "";
	}

	/**
	 * Retrieves the sender ID from an envelope. It never returns null.
	 * 
	 * @param envelope
	 *            the message envelope.
	 * @return the sender ID if found or an empty String otherwise. It never
	 *         returns null.
	 */
	protected String safeGetSenderId(MessageEnvelope envelope) {
		if (envelope != null && envelope.getSender() != null
				&& envelope.getSender().getId() != null) {
			return envelope.getSender().getId();
		}
		return "";
	}

	/**
	 * Retrieves the recipient from an envelope. It never returns null.
	 * 
	 * @param envelope
	 *            the message envelope.
	 * @return a {@link User} containing the recipient if found, empty
	 *         otherwise. It never returns null.
	 */
	protected User safeGetRecipient(MessageEnvelope envelope) {
		if (envelope != null && envelope.getRecipient() != null
				&& envelope.getRecipient().getId() != null) {
			return envelope.getRecipient();
		}
		return new User();
	}
	
	
	/**
	 * Retrieves the location from an envelope. It return nulls if none was retrieved.
	 * @param envelope
	 * @return
	 */
	protected LocationCoordinates getLocationMessage(MessageEnvelope envelope) {
		if (envelope != null && envelope.getMessage() != null 
				&& envelope.getMessage().getAttachments() != null 
				&& envelope.getMessage().getAttachments().get(0) != null 
				&& envelope.getMessage().getAttachments().get(0).getPayload() != null
				&& envelope.getMessage().getAttachments().get(0).getPayload() instanceof QuickReplyLocationPayload) {
		
				QuickReplyLocationPayload payload = (QuickReplyLocationPayload) envelope.getMessage().getAttachments().get(0).getPayload();
			
			return payload.getCoordinates();
		}
		return null;
	}

	/**
	 * Retrieves the sender from an envelope. It never returns null.
	 * 
	 * @param envelope
	 *            the message envelope.
	 * @return a {@link User} containing the sender if found, empty otherwise.
	 *         It never returns null.
	 */
	protected User safeGetSender(MessageEnvelope envelope) {
		if (envelope != null && envelope.getSender() != null
				&& envelope.getSender().getId() != null) {
			return envelope.getSender();
		}
		return new User();
	}

	/**
	 * Returns the kind of callback received for the current envelope.
	 * 
	 * @param envelope
	 *            the envelope to inspect.
	 * @return a {@link FbBotMillEventType} representing the current callback
	 *         type.
	 */
	protected FbBotMillEventType eventKind(MessageEnvelope envelope) {
		Message message = envelope.getMessage();
		if (message != null) {
			if (message instanceof ReceivedMessage) {
				return FbBotMillEventType.MESSAGE;
			}
			if (message instanceof EchoMessage) {
				return FbBotMillEventType.ECHO;
			}
		}
		if (envelope.getPostback() != null) {
			return FbBotMillEventType.POSTBACK;
		}
		if (envelope.getDelivery() != null) {
			return FbBotMillEventType.DELIVERY;
		}
		if (envelope.getRead() != null) {
			return FbBotMillEventType.READ;
		}
		if (envelope.getAccountLinking() != null) {
			return FbBotMillEventType.ACCOUNT_LINKING;
		}
		if (envelope.getOptin() != null) {
			return FbBotMillEventType.AUTHENTICATION;
		}
		if (envelope.getCheckoutUpdate() != null) {
			return FbBotMillEventType.CHECKOUT_UPDATE;
		}
		if (envelope.getReferral() != null) {
			return FbBotMillEventType.REFERRAL;
		}
		if (envelope.getPayment() != null) {
			return FbBotMillEventType.PAYMENT;
		}
		return FbBotMillEventType.ANY;
	}

	/**
	 * Validates the {@link FbBotMillResponse}.
	 *
	 * @param response the response
	 * @return true if the response is valid, false otherwise.
	 */
	protected boolean validate(FbBotMillResponse response) {
		// If validations are not enabled, returns true.
		if (!FbBotMillContext.getInstance().isValidationEnabled()) {
			return true;
		}

		boolean valid = true;
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<FbBotMillResponse>> violations = validator
				.validate(response);
		for (ConstraintViolation<FbBotMillResponse> v : violations) {
			valid = false;
			logger.error(
					"FbBotMillResponse validation error. Message: [{}] Value: [{}], Class: [{}], Field: [{}]",
					v.getMessage(), v.getInvalidValue(), v.getRootBean(),
					v.getPropertyPath());
		}
		return valid;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FbBotMillBean []";
	}


}
