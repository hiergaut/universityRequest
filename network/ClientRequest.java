/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

/**
 *
 * @author gauthier
 */
public enum ClientRequest {
	IDENTIFICATION, 
	NEW_USER,
	ALL_GROUP,
	OWN_GROUP,
	NEW_MESSAGE,
	READ_MESSAGES,
	DEL_GROUP,
	ADD_GROUP,
	ALL_GROUP_FOR_TICKET,
	NEW_TICKET,
	LOGOUT,
}
