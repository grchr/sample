package gr.aueb.mscis.sample.dao;

import java.util.List;

/**
 * The type User dao.
 */
public abstract class UserDao {

	/**
	 * Find by last name list.
	 *
	 * @param <Y>      the type parameter
	 * @param lastName the last name
	 * @return the list
	 */
	public abstract <Y> List<Y> findByLastName(String lastName);

	/**
	 * Find by user name list.
	 *
	 * @param <Y>      the type parameter
	 * @param userName the user name
	 * @return the list
	 */
	public abstract <Y> List<Y> findByUserName(String userName);
}
