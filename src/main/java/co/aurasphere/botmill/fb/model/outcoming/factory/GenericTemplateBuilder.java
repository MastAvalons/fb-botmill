package co.aurasphere.botmill.fb.model.outcoming.factory;

import co.aurasphere.botmill.fb.model.base.AttachmentType;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.GenericTemplatePayload;
import co.aurasphere.botmill.fb.model.outcoming.quickreply.QuickReply;
import co.aurasphere.botmill.fb.model.outcoming.template.generic.GenericTemplateElement;


/**
 * A builder for a Generic Template.
 *
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/generic-template"
 *      > Facebook's Messenger Platform Generic Template Documentation</a>
 * @author Donato Rimenti
 * @date Aug 25, 2016
 */
public class GenericTemplateBuilder extends TemplateBaseBuilder {

	/**
	 * The payload of the current builder.
	 */
	private GenericTemplatePayload payload;

	/**
	 * Default constructor. Creates a builder for a Generic Template.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/generic-template"
	 *      > Facebook's Messenger Platform Generic Template Documentation</a>
	 * 
	 */
	GenericTemplateBuilder() {
		this.payload = new GenericTemplatePayload();
		this.messageBuilder = new AttachmentMessageBuilder(
				AttachmentType.TEMPLATE, this.payload);
	}

	/**
	 * Adds a {@link GenericTemplateElement} to this template.
	 * 
	 * @param title
	 *            the title of the element to add.
	 * @return a builder for the element.
	 */
	public GenericTemplateElementBuilder addElement(String title) {
		return new GenericTemplateElementBuilder(title, this);
	}

	/**
	 * Adds a {@link GenericTemplateElement} to this template.
	 * 
	 * @param element
	 *            the element to add.
	 * @return this builder.
	 */
	public GenericTemplateBuilder addElement(GenericTemplateElement element) {
		this.payload.addElement(element);
		return this;
	}

	/**
	 * Adds a {@link QuickReply} to the current object.
	 *
	 * @param title            the quick reply button label. It can't be empty.
	 * @param payload            the payload sent back when the button is pressed. It can't be
	 *            empty.
	 * @return this builder.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/quick-replies"
	 *      > Facebook's Messenger Platform Quick Replies Documentation</a>
	 */
	public GenericTemplateBuilder addQuickReply(String title, String payload) {
		this.messageBuilder.addQuickReply(title, payload);
		return this;
	}

	/**
	 * Adds a {@link QuickReply} to the current object.
	 *
	 * @param reply            a quick reply object.
	 * @return this builder.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/quick-replies"
	 *      > Facebook's Messenger Platform Quick Replies Documentation</a>
	 */
	public GenericTemplateBuilder addQuickReply(QuickReply reply) {
		this.messageBuilder.addQuickReply(reply);
		return this;
	}

	/**
	 * {@inheritDoc} Creates a response containing a Generic Template.
	 */
	public FbBotMillResponse build(MessageEnvelope envelope) {
		return this.messageBuilder.build(envelope);
	}
}
