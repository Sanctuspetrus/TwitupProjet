package com.iup.tp.twitup.datamodel;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Classe du mod�le repr�sentant un utilisateur.
 * 
 * @author S.Lucas
 */
public class User {
	/**
	 * Identifiant unique de l'utilisateur.
	 */
	protected final UUID mUuid;

	/**
	 * Tag non modifiable correspondant � l'utilisateur. <br/>
	 * <i>Doit �tre unique dans le syst�me</i>
	 */
	protected final String mUserTag;

	/**
	 * Mot de passe de l'utilisateur.
	 */
	protected String mUserPassword;

	/**
	 * Nom de l'utilisateur.
	 */
	protected String mName;

	/**
	 * Liste des tags suivis par l'utilisateur.
	 */
	protected final Set<String> mFollows;

	/**
	 * Chemin d'acc�s � l'image de l'avatar de l'utilisateur.
	 */
	protected String mAvatarPath;

	/**
	 * Constructeur.
	 * 
	 * @param uuid
	 *            , Identifiant unique de l'utilisateur.
	 * @param userTag
	 *            , Tag correspondant � l'utilisateur.
	 * @param name
	 *            , Nom de l'utilisateur.
	 * @param follows
	 *            , Liste des tags suivis.
	 * @param avatarPath
	 *            , Chemin d'acc�s � l'image de l'avatar.
	 */
	public User(UUID uuid, String userTag, String userPassword, String name, Set<String> follows, String avatarPath) {
		mUuid = uuid;
		mUserTag = userTag;
		mUserPassword = userPassword;
		mName = name;
		mFollows = follows;
		mAvatarPath = avatarPath;
	}

	/**
	 * Retourne l'identifiant unique de l'utilisateur.
	 */
	public UUID getUuid() {
		return this.mUuid;
	}

	/**
	 * Retourne le nom de l'utilisateur.
	 */
	public String getName() {
		return mName;
	}

	/**
	 * Assigne le nom de l'utilisateur.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.mName = name;
	}

	/**
	 * Retourne le tag correspondant � l'utilisateur.
	 */
	public String getUserTag() {
		return this.mUserTag;
	}

	/**
	 * Retourne le mot de passe de l'utilisateur.
	 */
	public String getUserPassword() {
		return this.mUserPassword;
	}

	/**
	 * Assigne le mot de passe de l'utilisateur.
	 * 
	 * @param userPassword
	 */
	public void setUserPassword(String userPassword) {
		this.mUserPassword = userPassword;
	}

	/**
	 * Retourne la liste clon�e des tag suivis par l'utilsateur.
	 */
	public Set<String> getFollows() {
		// Clonage pour �viter les modifications exterieures
		return new HashSet<String>(this.mFollows);
	}

	/**
	 * Retire un tag de la liste des tags suivis.
	 * 
	 * @param tagToRemove
	 *            , tag � retirer.
	 */
	public void removeFollowing(String tagToRemove) {
		this.mFollows.remove(tagToRemove);
	}

	/**
	 * Ajout un tag de la liste des tags suivis.
	 * 
	 * @param tagToFollow
	 *            , tag � ajouter.
	 */
	public void addFollowing(String tagToFollow) {
		this.mFollows.add(tagToFollow);
	}

	/**
	 * Retourne le chemin d'acc�s au fichier de l'avatar de l'utilisateur.
	 */
	public String getAvatarPath() {
		return this.mAvatarPath;
	}

	/**
	 * Assigne le chemin d'acc�s au fichier de l'avatar de l'utilisateur.
	 * 
	 * @param avatarPath
	 */
	public void setAvatarPath(String avatarPath) {
		this.mAvatarPath = avatarPath;
	}

	/**
	 * Indique si l'utilisateur suit l'utilisateur donn�.
	 */
	public boolean isFollowing(User userToCheck) {
		return this.getFollows().contains(userToCheck.getUserTag());
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public boolean equals(Object other) {
		boolean equals = false;

		if (other != null) {
			if (other instanceof User) {
				User otherUser = (User) other;
				equals = (this.getUuid().equals(otherUser.getUuid()));
			}
		}

		return equals;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("[");
		sb.append(this.getClass().getName());
		sb.append("] : ");
		sb.append(this.getUuid());
		sb.append(" {@");
		sb.append(this.getUserTag());
		sb.append(" / ");
		sb.append(this.getName());
		sb.append("}");

		return sb.toString();
	}
}
