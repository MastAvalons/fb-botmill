package co.aurasphere.facebot.userprofile;

import co.aurasphere.facebot.bean.FaceBotNetworkAwareBean;
import co.aurasphere.facebot.model.userprofile.FacebookUserProfile;

/**
 * Class for handling the retrieval of Facebook user info.
 * 
 * @author Donato Rimenti
 * @date Nov 26, 2016
 */
public class FaceBotUserProfileRetriever extends FaceBotNetworkAwareBean {

	/**
	 * Retrieves a {@link FacebookUserProfile} object containing the info for
	 * the user with the ID passed.
	 * 
	 * @param userId
	 *            the id of the user whose profile to retrieve.
	 * @return the user profile.
	 */
	public static FacebookUserProfile getUser(String userId) {
		return getUserProfile(userId);
	}

}