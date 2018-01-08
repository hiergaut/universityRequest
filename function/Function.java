/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

/**
 *
 * @author gauthier
 */
public class Function {

	public static String color(Object o) {
		int color =o.hashCode() %15;
		if (color <8)
			color =30 +color;
		else
			color =41 +color -8;
		
		return "\u001B[" +color +"m" +o +"\u001B[0m ";
	}
}
