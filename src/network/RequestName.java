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
public enum RequestName {
	// client request
	IDENTIFICATION, 
	NEW_USER,
	ALL_GROUP,
	OWN_GROUP,
	NEW_MESSAGE,
	// server request
	INIT_HOME, 
	IDENTIFICATION_OK, 
	IDENTIFICATION_FAILED,
	ALL_GROUP_RESPONSE,
}
