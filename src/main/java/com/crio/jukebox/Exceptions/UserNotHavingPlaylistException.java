package com.crio.jukebox.Exceptions;

public class UserNotHavingPlaylistException extends RuntimeException{
    public UserNotHavingPlaylistException() {
        super();
    }
    public UserNotHavingPlaylistException(String msg) {
        super(msg);
    }
}
