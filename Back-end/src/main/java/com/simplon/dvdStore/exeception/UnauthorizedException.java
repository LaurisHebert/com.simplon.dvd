package com.simplon.dvdStore.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Unauthorized exception.
 */
@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends Exception {
}
//Remarque: prépare une erreur à lancer si le JWT n'est pas valide
