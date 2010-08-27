package org.apache.shindig.social.opensocial.spi;

import java.util.Set;
import java.util.concurrent.Future;

import org.apache.shindig.auth.SecurityToken;
import org.apache.shindig.protocol.ProtocolException;
import org.apache.shindig.protocol.RestfulCollection;
import org.apache.shindig.social.opensocial.model.MediaItem;

/*
 * The MediaItemService interface defines the service provider interface for
 * creating, retrieving, updating, and deleting OpenSocial MediaItems.
 */
public interface MediaItemService {
	
	/*
	 * Retrieves a MediaItem by ID.
	 * 
	 * @param userId		Identifies the owner of the MediaItem to retrieve
	 * @param appId			Identifies the application of the MeiaItem to retrieve
	 * @param albumId		Identifies the album containing the MediaItem
	 * @param mediaItemId	Identifies the MediaItem to retrieve
	 * @param fields		Indicates fields to be returned; empty set implies all
	 * @param token			A valid SecurityToken
	 * 
	 * @return a response item with the requested MediaItem
	 */
	Future<MediaItem> getMediaItem(UserId userId, String appId, String albumId,
			String mediaItemId, Set<String> fields, SecurityToken token)
			throws ProtocolException;
	
	/*
	 * Retrieves MediaItems by IDs.
	 * 
	 * @param userId		Identifies the owner of the MediaItems
	 * @param appId			Identifies the application of the MediaItems
	 * @param albumId		Identifies the album containing the MediaItems
	 * @param mediaItemIds	Identifies the MediaItems to retrieve
	 * @param fields		Specifies the fields to return; empty set implies all
	 * @param options		Sorting/filtering/pagination options
	 * @param token			A valid SecurityToken
	 * 
	 * @return a response item with the requested MediaItems
	 */
	Future<RestfulCollection<MediaItem>> getMediaItems(UserId userId,
			String appId, String albumId, Set<String> mediaItemIds,
			Set<String> fields, CollectionOptions options, SecurityToken token)
			throws ProtocolException;
	
	/*
	 * Retrieves MediaItems by Album.
	 * 
	 * @param userId	Identifies the owner of the MediaItems
	 * @param appId		Identifies the application of the MediaItems
	 * @param albumId	Identifies the Album containing the MediaItems
	 * @param fields	Specifies the fields to return; empty set implies all
	 * @param options	Sorting/filtering/pagination options
	 * @param token		A valid SecurityToken
	 * 
	 * @return a response item with the requested MediaItems
	 */
	Future<RestfulCollection<MediaItem>> getMediaItems(UserId userId,
			String appId, String albumId, Set<String> fields,
			CollectionOptions options, SecurityToken token)
			throws ProtocolException;
	
	/*
	 * Retrieves MediaItems by users and groups.
	 * 
	 * @param userIds	Identifies the users that this request is relative to
	 * @param groupId	Identifies the users' groups to retrieve MediaItems from
	 * @param appId		Identifies the application to retrieve MediaItems from
	 * @param fields	The fields to return; empty set implies all
	 * @param options	Sorting/filtering/pagination options
	 * @param token		A valid SecurityToken
	 * 
	 * @return a response item with the requested MediaItems
	 */
	Future<RestfulCollection<MediaItem>> getMediaItems(Set<UserId> userIds,
			GroupId groupId, String appId, Set<String> fields,
			CollectionOptions options, SecurityToken token)
			throws ProtocolException;
	
	/*
	 * Deletes a MediaItem by ID.
	 * 
	 * @param userId		Identifies the owner of the MediaItem to delete
	 * @param appId			Identifies the application hosting the MediaItem
	 * @param albumId		Identifies the parent album of the MediaItem
	 * @param mediaItemId	Identifies the MediaItem to delete
	 * @param token			A valid SecurityToken
	 * 
	 * @return a response item containing any errors
	 */
	Future<Void> deleteMediaItem(UserId userId, String appId, String albumId,
			String mediaItemId, SecurityToken token) throws ProtocolException;
	
	/*
	 * Create a MediaItem in the given album for the given user.
	 * 
	 * @param userId		Identifies the owner of the MediaItem to create
	 * @param appId			Identifies the application hosting the MediaItem
	 * @param albumId		Identifies the album to contain the MediaItem
	 * @param mediaItem		The MediaItem to create
	 * @param token			A valid SecurityToken
	 * 
	 * @return a response containing any errors
	 */
	Future<Void> createMediaItem(UserId userId, String appId, String albumId,
			MediaItem mediaItem, SecurityToken token) throws ProtocolException;
	
	/*
	 * Updates a MediaItem for the given user.  The MediaItem ID specified in
	 * the REST end-point is used, even if the MediaItem also defines an ID.
	 * 
	 * @param userId		Identifies the owner of the MediaItem to update
	 * @param appId			Identifies the application hosting the MediaItem
	 * @param albumId		Identifies the album containing the MediaItem
	 * @param mediaItemId	Identifies the MediaItem to update
	 * @param mediaItem		The updated MediaItem to persist
	 * @param token			A valid SecurityToken
	 * 
	 * @return a response containing any errors
	 */
	Future<Void> updateMediaItem(UserId userId, String appId, String albumId,
			String mediaItemId, MediaItem mediaItem, SecurityToken token)
			throws ProtocolException;
}