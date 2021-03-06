package co.aurasphere.botmill.fb.model.outcoming.factory;


/**
 * Base class for {@link FbBotMillMockableBuilder} that builds a template.
 * 
 * @author Donato Rimenti
 * @date Aug 27, 2016
 */
public abstract class TemplateBaseBuilder extends FbBotMillMockableBuilder {

	/**
	 * The delegated builder for a message containing a template.
	 */
	protected AttachmentMessageBuilder messageBuilder;

}
