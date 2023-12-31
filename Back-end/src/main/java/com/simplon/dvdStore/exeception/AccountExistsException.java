package com.simplon.dvdStore.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Account exists exception.
 */
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Account already exists")
public class AccountExistsException extends Exception {
}
