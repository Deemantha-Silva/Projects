/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silvadee.a2.util;

import javax.servlet.http.Cookie;

/**
 *
 * @author Deemantha
 */
public class CookieUtil {
    public static String getCookieValue(
            Cookie[] cookies, String cookieName) {
        
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                if (cookieName.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return "";
    }
}
