package com.iup.tp.twitup.datamodel;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.iup.tp.twitup.common.Constants;

/**
 * Classe du mod�le repr�sentant un twit.
 * 
 * @author S.Lucas
 */
public class Twit {
	/**
	 * Identifiant unique du twit.
	 */
	protected final UUID mUuid;

	/**
	 * Utilisateur source.
	 */
	protected final User mTwiter;

	/**
	 * Date d'�mission du twit.
	 */
	protected final long mEmissionDate;

	/**
	 * Corps du message.
	 */
	protected final String mText;

	/**
	 * Liste des tags repr�sentant un utilisateur pr�sent dans le twit.
	 */
	protected final Set<String> mUserTags;

	/**
	 * Liste des tags pr�sent dans le twit.
	 */
	protected final Set<String> mTags;

	/**
	 * Constructeur.
	 * 
	 * @param twiter
	 *            utilisateur � l'origine du twit.
	 * @param text
	 *            , corps du message.
	 */
	public Twit(User twiter, String text) {
		this(UUID.randomUUID(), twiter, System.currentTimeMillis(), text);
	}

	/**
	 * Constructeur.
	 * 
	 * @param twitUuid
	 *            , identifiant du twit.
	 * @param twiter
	 *            , utilisateur � l'origine du twit.
	 * @param emissionDate
	 *            , date d'�mission du twit.
	 * @param text
	 *            , corps du message.
	 */
	public Twit(UUID twitUuid, User twiter, long emissionDate, String text) {
		mUuid = twitUuid;
		mTwiter = twiter;
		mEmissionDate = emissionDate;
		mText = text;
		mTags = new HashSet<String>();
		mUserTags = new HashSet<String>();

		// Initialisation des mots-cl�s
		this.initTags(new String(mText));
	}

	/**
	 * Initialisation de la liste de tags pr�sents dans le corps du message.
	 */
	protected void initTags(String text) {
		if (text != null) {
			// Ajoute les tags correspondants aux utilisateurs.
			mUserTags.addAll(this.extractTags(text, Constants.USER_TAG_DELIMITER));

			// Ajoute les tags correspondants aux mots-cl�s.
			mTags.addAll(this.extractTags(text, Constants.WORD_TAG_DELIMITER));
		}
	}

	/**
	 * Retourne les tags pr�sents dans le texte en fonction du caract�re de
	 * d�tection.
	 * 
	 * @param text
	 *            , Texte � analyser.
	 * @param tagDelimiter
	 *            , Caract�re de d�limitation des tags � rechercher.
	 */
	protected Set<String> extractTags(String text, String tagDelimiter) {
		Set<String> tags = new HashSet<String>();

		// Ajout d'un caract�re sp�cial pour reconnaitre les �l�ments
		// r�ellement
		// tagg�
		String specialChar = "~";
		String replacedText = text.replace(tagDelimiter, tagDelimiter + specialChar);

		// D�coupage en foncion du d�limiteur.
		String[] taggedStrings = replacedText.split(tagDelimiter);

		// Parcours de tous les groupes r�cup�r�s
		for (String taggedString : taggedStrings) {
			// Si la chaine courante commencait bien par le d�limiteur
			if (taggedString.startsWith(specialChar)) {
				// R�cup�ration du tag (du d�limiteur jusqu'au premier
				// espace)
				String newTag = taggedString.split(" ")[0];

				// Suppression du caract�re sp�cial
				newTag = newTag.substring(1, newTag.length());

				// Ajout du tag � la liste
				tags.add(newTag);
			}
		}

		return tags;
	}

	/**
	 * @return l'identifiant du Twit.
	 */
	public UUID getUuid() {
		return mUuid;
	}

	/**
	 * @return l'utilisateur source.
	 */
	public User getTwiter() {
		return mTwiter;
	}

	/**
	 * @return le corps du message.
	 */
	public String getText() {
		return mText;
	}

	/**
	 * Retourne la date d'�mission.
	 */
	public long getEmissionDate() {
		return this.mEmissionDate;
	}

	/**
	 * Retourne une liste clon�e des tags du twit. <br/>
	 * <i> Les tags sont les mots du twit pr�c�d�s par la
	 * {@link Constants#WORD_TAG_DELIMITER}</i>
	 */
	public Set<String> getTags() {
		return new HashSet<String>(mTags);
	}

	/**
	 * Retourne une liste clon�e des tags du twit repr�sentant un utilisateur.
	 * <br/>
	 * <i> Les tags utilisateurs sont les mots du twit pr�c�d�s par la
	 * {@link Constants#USER_TAG_DELIMITER}</i>
	 */
	public Set<String> getUserTags() {
		return new HashSet<String>(mUserTags);
	}

	/**
	 * Indique si le Twit poss�de le tag donn�.
	 * 
	 * @param aTag
	 *            , tag � rechercher.
	 */
	public boolean containsTag(String aTag) {
		return this.getTags().contains(aTag);
	}

	/**
	 * Indique si le Twit poss�de le tag utilisateur donn�.
	 * 
	 * @param anUserTag
	 *            , tag utilisateur � rechercher.
	 */
	public boolean containsUserTag(String anUserTag) {
		return this.getUserTags().contains(anUserTag);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object other) {
		boolean equals = false;

		if (other != null) {
			if (other instanceof Twit) {
				Twit otherTwit = (Twit) other;
				equals = (this.getUuid().equals(otherTwit.getUuid()));
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
		sb.append(" {");
		sb.append(this.getText());
		sb.append("}");

		return sb.toString();
	}
}
