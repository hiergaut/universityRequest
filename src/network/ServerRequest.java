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
public enum ServerRequest {
	INIT_HOME, 
	IDENTIFICATION_OK, 
	IDENTIFICATION_FAILED,
	ALL_GROUP_RESPONSE,
	MAJ_MESSAGES,
	NEW_USER_RESPONSE,
	ALL_GROUP_FOR_TICKET_RESPONSE,
}
