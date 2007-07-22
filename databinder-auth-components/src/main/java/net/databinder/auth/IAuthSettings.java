package net.databinder.auth;

import org.apache.wicket.markup.html.WebPage;
import net.databinder.auth.data.IUser;
import net.databinder.models.ICriteriaBuilder;

/**
 * Application-specific authorization settings. Many components of Databinder authentication
 * require that this be implemented by the current WebApplication instance.
 * @author Nathan Hamblen
 */
public interface IAuthSettings {
	/**
	 * @return class to be used for signed in users
	 */
	public Class< ? extends IUser> getUserClass();
	/** 
	 * @return criteria builder that will match a single IUser for the given username. 
	 */
	public ICriteriaBuilder getUserCriteriaBuilder(String username);
	/**
	 * @return page to sign in users
	 */
	public Class< ? extends WebPage> getSignInPageClass();
	/**
	 * Cryptographic salt to be used in authentication. The default IUser
	 * implementation uses this value. If your imlementation does not require
	 * a salt value (!), return null.
	 * @return
	 */
	public abstract byte[] getSalt();
}