package co.aurasphere.botmill.fb.model.outcoming.factory;

import co.aurasphere.botmill.fb.model.base.AttachmentType;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.ListTemplatePayload;
import co.aurasphere.botmill.fb.model.outcoming.quickreply.QuickReply;
import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;
import co.aurasphere.botmill.fb.model.outcoming.template.list.ListTemplateElement;
import co.aurasphere.botmill.fb.model.outcoming.template.list.TopElementStyle;


/**
 * A builder for a List Template.
 *
 * @author Alvin Reyes
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/list-template"
 *      > Facebook's Messenger Platform List Template Documentation</a>
 * @date Nov 22, 2016
 */
public class ListTemplateBuilder extends TemplateBaseBuilder {

	/**
	 * The payload of the current builder.
	 */
	private ListTemplatePayload payload;

	/**
	 * Default constructor. Creates a builder for a List Template.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/list-template"
	 *      > Facebook's Messenger Platform List Template Documentation</a>
	 * 
	 */
	ListTemplateBuilder() {
		this.payload = new ListTemplatePayload();
		this.messageBuilder = new AttachmentMessageBuilder(AttachmentType.TEMPLATE, this.payload);
	}
	
	/**
	 * Sets/Adds a {@link TopElementStyle} to the list template payload.
	 * 
	 * @param topElementStyle
	 * 			the top element style
	 * @return this builder
	 */
	public ListTemplateBuilder setTopElementStyle(TopElementStyle topElementStyle) {
		this.payload.setTopElementStyle(topElementStyle);
		return this;
	}

	/**
	 * Adds a {@link ListTemplateElement} to this template.
	 * 
	 * @param title
	 *            the title of the element to add.
	 * @return a builder for the element.
	 */
	public ListTemplateElementBuilder addElement(String title) {
		return new ListTemplateElementBuilder(title, this);
	}

	/**
	 * Adds a {@link ListTemplateElement} to this template.
	 * 
	 * @param element
	 *            the element to add.
	 * @return this builder.
	 */
	public ListTemplateBuilder addElement(ListTemplateElement element) {
		this.payload.addElement(element);
		return this;
	}
	
	/**
	 * Add a {@link Button} to this template.
	 *
	 * @param button 			the button to add
	 * @return this builder.
	 */
	public ListTemplateBuilder addButton(Button button) {
		this.payload.addButton(button);
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
	public ListTemplateBuilder addQuickReply(String title, String payload) {
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
	public ListTemplateBuilder addQuickReply(QuickReply reply) {
		this.messageBuilder.addQuickReply(reply);
		return this;
	}

	/**
	 * {@inheritDoc} Creates a response containing a List Template.
	 */
	public FbBotMillResponse build(MessageEnvelope envelope) {
		return this.messageBuilder.build(envelope);
	}
}
